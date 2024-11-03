# Spark Validator v2.0.0

## Overview

The `Spark` library provides a fluent interface for validating and transforming input data in Java. It includes functionality for validating strings and integers with a variety of built-in methods, making it easy to chain validation operations together.

## Packages

-   `com.wishva.validator`
-   `com.wishva.validator.v2`

## Classes

-   `com.wishva.validator.v2.SparkString`
-   `com.wishva.validator.v2.SparkInt`
-   `com.wishva.validator.v2.SparkDouble`
-   `com.wishva.validator.SparkException`
-   `com.wishva.validator.Spark @Depricated `

# SparkString Class

The `SparkString` class provides a set of validation methods for `String` inputs, allowing developers to validate field requirements, check length constraints, ensure valid email formats, and more. The class supports method chaining for streamlined validation flows.

## Package

`com.wishva.validator.v2`

## Constructors

-   `SparkString(String displayName, String input) throws SparkException`

    -   Initializes a `SparkString` instance with a string input.

-   `SparkString(String displayName, char[] input) throws SparkException`
    -   Initializes a `SparkString` instance with a character array input, converting it to a string.

## Fields

-   `String displayName`

    -   The display name for the input field.

-   `String str`

    -   Holds the input string value for validation.

-   `static final String EMAIL_REGEX`
    -   A regular expression pattern for validating email addresses.

## Methods

-   `SparkString required() throws SparkException`

    -   Ensures that the input string is not blank. Throws `SparkException` if the input is blank.

-   `SparkString required(String errorMessage) throws SparkException`

    -   Ensures that the input string is not blank, using a custom error message. Throws `SparkException` if the input is blank.

-   `SparkString email() throws SparkException`

    -   Validates that the input string is a valid email address. Throws `SparkException` if the input is not a valid email.

-   `SparkString equals(String otherString, String msg) throws SparkException`

    -   Validates that the input string is equal to another specified string. Throws `SparkException` if the strings are not equal.

-   `SparkString minLength(int length) throws SparkException`

    -   Ensures that the input string meets a specified minimum length requirement. Throws `SparkException` if the input is shorter than the minimum length.

-   `SparkString minLength(int length, String msg) throws SparkException`

    -   Ensures that the input string meets a specified minimum length, with a custom error message. Throws `SparkException` if the input is shorter than the specified length.

-   `SparkString maxLength(int length) throws SparkException`

    -   Ensures that the input string does not exceed a specified maximum length. Throws `SparkException` if the input exceeds the maximum length.

-   `SparkString maxLength(int length, String msg) throws SparkException`

    -   Ensures that the input string does not exceed a specified maximum length, with a custom error message. Throws `SparkException` if the input exceeds the specified length.

-   `SparkString regex(String pattern) throws SparkException`

    -   Validates the input string against a specified regular expression pattern. Throws `SparkException` if the input does not match the pattern.

-   `SparkString regex(String pattern, String msg) throws SparkException`

    -   Validates the input string against a specified regular expression pattern, with a custom error message. Throws `SparkException` if the input does not match the pattern.

-   `String toString()`

    -   Ends the validation chain and returns the validated string.

-   `SparkInt toInt() throws SparkException`
    -   Converts the input string to an integer. Throws `SparkException` if the input is not a valid number.

# SparkInt Class

The `SparkInt` class is used for validating integer inputs by enforcing minimum and maximum value constraints. It provides methods for chaining validations and retrieving the validated integer value.

## Package

`com.wishva.validator.v2`

## Constructors

-   `SparkInt(String displayName, int input)`

    -   Initializes a `SparkInt` instance with a string input.

## Fields

-   `int num`

    -   Holds the integer input value for validation.

-   `String displayName`
    -   The display name of the input field, used for custom error messages.

## Methods

-   `SparkInt min(int val) throws SparkException`

    -   Ensures that the integer input meets a specified minimum value.

-   `SparkInt min(int val, String msg) throws SparkException`

    -   Ensures that the integer input meets a specified minimum value, with a custom error message.

-   `SparkInt max(int val) throws SparkException`
    -   Ensures that the integer input does not exceed a specified maximum value.
-   `SparkInt max(int val, String msg) throws SparkException`

    -   Ensures that the integer input does not exceed a specified maximum value, with a custom error message.

-   `int toInt()`
    -   Ends the validation chain and returns the validated integer.

# SparkDouble Class

The `SparkDouble` class is designed for validating double inputs by enforcing minimum and maximum value constraints. It provides methods for chaining validations and retrieving the validated double value.

## Package

`com.wishva.validator.v2`

## Constructors

-   `SparkDouble(String displayName, double input)`

    -   Initializes a `SparkDouble` instance with a string input.

## Fields

-   `double num`

    -   Holds the double input value for validation.

-   `String displayName`
    -   The display name of the input field, used for custom error messages.

## Methods

-   `SparkDouble min(double val) throws SparkException`

    -   Ensures that the double input meets a specified minimum value.

-   `SparkDouble min(double val, String msg) throws SparkException`

    -   Ensures that the double input meets a specified minimum value, with a custom error message.

-   `SparkDouble max(double val) throws SparkException`

    -   Ensures that the double input does not exceed a specified maximum value.

-   `SparkDouble max(double val, String msg) throws SparkException`

    -   Ensures that the double input does not exceed a specified maximum value, with a custom error message.

-   `double toDouble()`
    -   Ends the validation chain and returns the validated double.

# SparkException Class

## Package

`com.wishva.validator`

### Fields

-   `public final String title`
    -   The title of the exception, set to "Validation Error".

### Constructors

-   `SparkException(String error)`
    -   Initializes a `SparkException` instance with the specified error message.

# License

Create React App is open source software [Licensed as MIT](https://github.com/vishva-kalhara/Spark-Validator/blob/master/README.md)
