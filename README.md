# About the Project

This repository was created as part of the "QA Mobile" course at Tinkoff Fintech, Spring 2023.

## Project Description

### KotlinUtils

This is a project written in Kotlin with JUnit 5 tests and built using Maven.

## Requirements:

## Task 1

Path to the file containing the solution:

`./src/main/kotlin/MutableListIntExtensions.kt`

Path to the file containing the tests: 

`./src/test/kotlin/MutableListIntExtensionsTest.kt`

Write an extension function for working with mutable collections containing Int elements. The extension function should square all the elements.

### Example Input:

Input collection:

`[1, 4, 9, 16, 25]`

### Example Output:

Output collection: 

`[1, 16, 81, 256, 625]`

## Task 2

Path to the file containing the solution:

`./src/main/kotlin/TypeCastingProcessor.kt`

Path to the file containing the tests:

`./src/test/kotlin/TypeCastingProcessorTest.kt`

Write a method that can take an `Any?` object and perform certain actions based on its type:

- If the object is of type `String`, output the type, its value, and the length of the string in the message `Я получил тип String = 'Привет, Андрей, ну где ты был, ну обними меня скорей!', ее длина равна 51 символ`.
- If it's an `Int`, output the type, its value, and the square of its value, for example, `Я получил Int = val, его квадрат равен $val`.
- If it's a `Double`, output the type, its value, and the mathematically correct rounded value to 2 decimal places in the message `Я получил Double = 2.356, это число округляется до 2.36` (trailing zeros can be omitted).
- If it's a `LocalDate`, output the type, its value, and whether the input date is earlier than the founding date of Tinkoff (which we'll assume is December 24, 2006), for example, `Я получил LocalData = val, эта дата меньше чем дата основания Tinkoff`.
- For other types, the behavior is undefined, so output the message `Мне этот тип неизвестен`.
- If `null` is passed, output that the object is equal to `null`.

### Example Input:
```bash
typeCasting("Privet")
typeCasting(145)
typeCasting(145.0)
typeCasting(145.2817812)
typeCasting(LocalDate.of(1990,1,1))
typeCasting(Handler::class)
```
### Example Output:
```bash
Я получил String = Privet, ее длина равна 6
Я получил Int = 145, его квадрат равен 21025
Я получил Double = 145.0, это число округляется до 145
Я получил Double = 145.2817812, это число округляется до 145,28
я получил LocalDate 1990-01-01, она меньше даты основания Tinkoff
Мне этот тип неизвестен
```
## Task 3

Path to the file containing the solution:

`./src/main/kotlin/SumCalculator.kt`  

Path to the file containing the tests:

`./src/test/kotlin/SumCalculatorTest.kt`

Write a method that takes a list (collection) of nullable Double numbers, and performs the following operations:

- Divides by 2 if the number is odd, and squares it if the number is even (checking for even/oddness - without considering the fractional part)
- Discards all numbers greater than 25
- Discards null values
- Sorts the collection in descending order
- Discards all elements in the collection except the first 10, for which you can use selection functions such as take, drop, etc. (the collection may be of smaller size)
- Returns the sum of the remaining elements in the collection, and prints it to the console with rounding to two decimal places.

Example of input and output values:

Input array:

`[13.31, 3.98, 12.0, 2.99, 9.0]`

Expected sum of elements in the remaining collection: 

`22.09`

## Task 4

Path to the file containing the solution:

`./src/main/kotlin/RussianNumberWordsConverter.kt`  

Path to the file containing the tests:

`./src/test/kotlin/RussianNumberWordsConverterTest.kt`

Given a natural number n (n<=1000), print this number in Russian words (for example, "тринадцать", "сто пять", "двести сорок один", etc.).

Example of input and output values:

Input number:

`975`

Expected output:

`девятьсот семьдесят пять`

## Project Team

- Oleg Komissarov - QA Engineer

## Environment:

- Package: org.example
- JDK 17 Oracle OpenJDK version 17.0.6
- Apache Maven 3.9.1

## Kotlin:

- Kotlin version 1.8.0
- Language level 17 – Sealed types, always-strict floating-point semantics
- Kotlin Target platform JVM 11
- API version 1.8
- Language version 1.8

## Source Folders:

- `src/main/kotlin`

## Test Source Folders:

- `src/test/kotlin`

## Running Tests

To run the tests using Maven, execute the following command in the root directory of the project:

1. Clone the project from GitHub:

```bash
git clone https://github.com/OlegKomissarovV/KotlinUtils.git
```

2. Navigate to the project directory:

```bash
cd KotlinUtils
```

3. (Optional) If you want to install the project in your local Maven repository and execute all tests, run:

```bash
mvn install
```

4. Run tests using Maven:

```bash
mvn test
```

Maven will automatically download and install the project's dependencies, including Kotlin Test for JUnit 5, JUnit Jupiter Engine, Kotlin Standard Library, and JUnit Jupiter Params, as defined in the `pom.xml` file.

## Dependencies

The following dependencies are used in this project:

- Kotlin Test for JUnit 5: `org.jetbrains.kotlin:kotlin-test-junit5:1.8.0`
- JUnit Jupiter Engine: `org.junit.jupiter:junit-jupiter-engine:5.6.3`
- Kotlin Standard Library: `org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0`
- JUnit Jupiter Params: `org.junit.jupiter:junit-jupiter-params:5.6.3`

These dependencies are defined in the `pom.xml` file and will be automatically downloaded and installed by Maven when you run the tests.


