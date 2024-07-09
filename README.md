# Spark Library

## Overview

The `Spark` library provides a fluent interface for validating and transforming input data in Java. It includes functionality for validating strings and integers with a variety of built-in methods, making it easy to chain validation operations together.

## Package

`com.wishva`

## Classes

-   `Spark`
-   `SparkException`

## Spark Class

### Fields

-   `private String displayName`
    -   The display name for the input field.
-   `private String inputStr`
    -   The input value as a string.
-   `private int inputInt`
    -   The input value as an integer.
-   `private static final String EMAIL_REGEX`
    -   The regular expression for validating email addresses.
-   `private static final Pattern pattern`
    -   The compiled pattern for validating email addresses.

### Constructors

-   `Spark(String displayName, String input)`

    -   Initializes a `Spark` instance with a string input.

-   `Spark(String displayName, char[] input)`

    -   Initializes a `Spark` instance with a character array input, converting it to a string.

-   `Spark(String displayName, int input)`
    -   Initializes a `Spark` instance with an integer input.

### String Methods

-   `Spark required() throws SparkException`

    -   Ensures that the input string is not blank. Throws `SparkException` if the input is blank.

-   `Spark required(String errorMessage) throws SparkException`

    -   Ensures that the input string is not blank. Throws `SparkException` with a custom error message if the input is blank.

-   `Spark email() throws SparkException`

    -   Validates that the input string is a valid email address. Throws `SparkException` if the input is not a valid email.

-   `Spark equals(String otherString, String msg) throws SparkException`

    -   Ensures that the input string equals the specified string. Throws `SparkException` with a custom message if they do not match.

-   `Spark minLength(int length) throws SparkException`

    -   Ensures that the input string has a minimum length. Throws `SparkException` if the input is shorter than the specified length.

-   `Spark minLength(int length, String msg) throws SparkException`

    -   Ensures that the input string has a minimum length. Throws `SparkException` with a custom message if the input is shorter than the specified length.

-   `Spark maxLength(int length) throws SparkException`

    -   Ensures that the input string does not exceed the maximum length. Throws `SparkException` if the input is longer than the specified length.

-   `Spark maxLength(int length, String msg) throws SparkException`

    -   Ensures that the input string does not exceed the maximum length. Throws `SparkException` with a custom message if the input is longer than the specified length.

-   `String endString() throws SparkException`
    -   Returns the validated string input. Throws `SparkException` if the input was initially an integer.

### Integer Methods

-   `Spark toInt() throws SparkException`

    -   Converts the string input to an integer. Throws `SparkException` if the string is not a valid integer.

-   `Spark min(int val) throws SparkException`

    -   Ensures that the input integer is greater than or equal to the specified value. Throws `SparkException` if it is less.

-   `Spark min(int val, String msg) throws SparkException`

    -   Ensures that the input integer is greater than or equal to the specified value. Throws `SparkException` with a custom message if it is less.

-   `Spark max(int val) throws SparkException`

    -   Ensures that the input integer is less than or equal to the specified value. Throws `SparkException` if it is greater.

-   `Spark max(int val, String msg) throws SparkException`

    -   Ensures that the input integer is less than or equal to the specified value. Throws `SparkException` with a custom message if it is greater.

-   `int endInt()`
    -   Returns the validated integer input. Converts the string input to an integer if necessary.

## SparkException Class

### Fields

-   `public final String title`
    -   The title of the exception, set to "Validation Error".

### Constructors

-   `SparkException(String error)`
    -   Initializes a `SparkException` instance with the specified error message.

## License

Create React App is open source software [Licensed as MIT](https://github.com/vishva-kalhara/Spark-Validator/blob/master/README.md)
