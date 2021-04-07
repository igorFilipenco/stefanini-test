#Readme instructions for test tasks(for Stefanini)

Here you can find necessary information about done tasks.

**Task 1**

You can launch it after cloning prject via your IDE.
After launching write necessary data in console, according to exercise 1 description

**Task 2**

Here, before launching you should go to TaskManagerRepositoryImpl class and specify path to file and its filename(here application will save data) in FILE_PATH variable
example: "/home/user/projects/file"
After that you can pack programm to the jar file and work with him, or you can it directly from IDEA.
go Run-Edit Configurations and in Program arguments you can specify necessary comand, described in exercise 2
After that compile program.

**Task 3**

Here was used PostgreSQL for storage, Hibernate to work with it and Junit4 for tests
First you have to install postgreSql and to create your database
After that go to file src/main/resources/hibernate.cfg.xml and add database connection params:
  - connection.url = your database url like "jdbc:postgresql://172.18.0.2:5432/stefanini"
  - connection.username = your db username
  - connection.password = your db password
  
Compile src/test/java/com/stefanini/test3/utils/HibernateUtilTest, during this hibernate will create necessary tables
As it was in exercise 2 you can launch app via Program arguments in Edit Configurations using comands like:
- createUser -fn='fn_test' -ln='ln_test' -un='un_test'
- showAllUsers
- addTask -un='un_test' -tt='Tas Title' -td='Task Description'
- showTasks -un='un_test'
- showAllTasks
- completeTask -un='un_test' -tt='Tas Title'



### _**tasks:**_

## Exercise 1

_**Birthday Cake Candles**_
You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.

Example
candles=[4,4,3,1]candles=[4,4,3,1]candles=[4,4,3,1]
The maximum height candles are 444 units high. There are 222 of them, so return 222.

Function Description
Write the function birthdayCakeCandles in any programming language you know.

Input Parameters
birthdayCakeCandles has the following input parameter:

int candles[n]candles[n]candles[n]: the candle heights


Returns

int: the number of candles that are tallest


Input Format
The first line contains a single integer, nnn, the size of candles[]candles[]candles[].
The second line contains nnn space-separated integers, where each integer iii describes the height of candles[i]candles[i]candles[i].

Constrains

1<=n<=1031 <= n <= 10^31<=n<=103
1<=candles[i]<=1031 <= candles[i] <= 10^31<=candles[i]<=103


Sample Input

4
3 2 1 3


Sample Output

2


## Exercise 2

**_Task Manager_**
You need to create a java application that will work as a task manager, with this application we should be able to do:

create new users (insert: FirstName, LastName, userName)
show all users (prin: FirstName, LastName, number of tasks)
add a task to the user (insert username, Task Title, Description)
show user's tasks (print: Task title, Description)
All data should be kept in the file, writing and reading should happen via serialization and deserilization operations.


Acceptance Criteria

Create new users - by running this command:

java -jar myaplication.jar -createUser -fn='FirstName' - ln='LastName' -un='UserName'
UserName should be unique,  dot'n forget about validation


Show All Users - by running this command:
java -jar myaplication.jar -showAllUsers


Add a task to the user - by running this command:
java -jar myaplication.jar -addTask -un='userName' -tt='Task Title' -td='Task Description'


Show user's tasks - by running this command:
java -jar myaplication.jar -showTasks -un='userName'


## **Exercise 3**

_**Enhanced Task Manager**_
Add additional functionality to the application that you'll have   created:

- Add one more logical functionality (e. g. task assigned to a group of users)
- Use an Automated Build Tool (Maven/Gradle)
- Use Database instead of storing data in a file
- Cover your code with JUnit tests
