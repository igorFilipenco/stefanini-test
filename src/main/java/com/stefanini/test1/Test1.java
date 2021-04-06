package com.stefanini.test1;

import com.stefanini.test1.exception.CandleNumberException;
import com.stefanini.test1.exception.CandleQuantityException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Test1 {
    private static final int MIN_CONSTRAINT = 1;
    private static final int MAX_CONSTRAINT = 1000;

    public static void main(String[] args) {
        int[] candles = readCandlesHeightsFromConsole();

        birthdayCakeCandles(candles);
    }

    public static int[] readCandlesHeightsFromConsole() {
        int candleNum = MIN_CONSTRAINT;
        int[] candles = new int[candleNum];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Enter candles number");

            candleNum = convertStringToInteger(reader.readLine());

            if (candleNum < MIN_CONSTRAINT || candleNum > MAX_CONSTRAINT)
                throw new CandleNumberException("Error: entered wrong number of candles");

            System.out.println("Enter candles heights");

            candles = extractCandlesHeightFromLine(candleNum, reader.readLine());
        } catch (IOException | CandleNumberException | CandleQuantityException e) {
            e.printStackTrace();
        }

        return candles;
    }

    public static int[] extractCandlesHeightFromLine(int candleNum, String line) throws CandleQuantityException {
        String[] candlesHeights = line.split(" ");
        int[] convertedCandlesHeights = new int[candleNum];

        if (candlesHeights.length != candleNum)
            throw new CandleQuantityException("Error: quantity candles heights is not equal to entered candles number");

        for (int i = 0; i < candlesHeights.length; i++) {
            convertedCandlesHeights[i] = convertStringToInteger(candlesHeights[i]);
        }

        return convertedCandlesHeights;
    }

    public static Integer convertStringToInteger(String line) {
        int number = 0;

        try {
            number = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Entered line: " + line + " cannot be converted to number");
        }

        return number;
    }

    public static int findMaxCandleHeight(int[] candleHeights) {
        int maxHeight = candleHeights[0];

        for (int height : candleHeights) {
            if (height > maxHeight) maxHeight = height;
        }

        return maxHeight;
    }

    public static void birthdayCakeCandles(int[] candleHeights) {
        int maxCandleHeight = findMaxCandleHeight(candleHeights);
        List<Integer> maxHeightCandlesQty = new ArrayList<>();

        for (int height : candleHeights) {
            if (height == maxCandleHeight) {
                maxHeightCandlesQty.add(height);
            }
        }

        System.out.println(maxHeightCandlesQty.size());
    }
}
