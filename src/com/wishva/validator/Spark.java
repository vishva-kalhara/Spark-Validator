/*
 * The MIT License
 *
 * Copyright 2024 wishva.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.wishva.validator;

import java.util.regex.Pattern;

/**
 * The {@code Spark} class provides a fluent API for validating user input.
 *
 * <p>
 * This class supports validation for both {@code String} and {@code int} types,
 * offering various methods to check for required fields, email format,
 * equality, length constraints, and pattern matching. It also includes methods
 * for converting {@code String} inputs to {@code int} and handling custom error
 * messages.
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * try {
 *     new Spark("Email", "example@domain.com")
 *         .required()
 *         .email()
 *         .endString();
 * } catch (SparkException e) {
 *     System.out.println(e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>
 * Note: This class is designed to be used in a chained method pattern.
 *
 * @author vishv
 */

@Deprecated
public class Spark {

    // Class-level constants and fields
    private String displayName = null;
    private String inputStr = null;
    private int inputInt = -9903;

    private static final String EMAIL_REGEX
            = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    /**
     * Ensures that the current input is a {@code String}.
     *
     * @throws SparkException if the input is not a {@code String}.
     */
    private void isString() throws SparkException {
        if (inputStr == null) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
    }

    /**
     * Ensures that the current input is an {@code int}.
     *
     * @throws SparkException if the input is a {@code String} or has not been
     * set.
     */
    private void isInt() throws SparkException {
        if (this.inputStr != null) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
        if (inputInt == -9903) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
    }

    // Constructors
    /**
     * Constructs a new {@code Spark} validator for a {@code String} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code String} to be validated.
     */
    @Deprecated
    public Spark(String displayName, String input) {
        this.displayName = displayName;
        this.inputStr = input;
    }

    /**
     * Constructs a new {@code Spark} validator for a {@code char[]} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code char[]} to be validated.
     */
    @Deprecated
    public Spark(String displayName, char[] input) {
        this.displayName = displayName;
        this.inputStr = String.valueOf(input);
    }

    /**
     * Constructs a new {@code Spark} validator for an {@code int} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code int} to be validated.
     */
    public Spark(String displayName, int input) {
        this.displayName = displayName;
        this.inputInt = input;
    }

    // String validation methods
    /**
     * Ensures that the {@code String} input is not empty or blank.
     *
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is empty or blank.
     */
    public Spark required() throws SparkException {

        if (this.inputStr.isBlank()) {
            throw new SparkException(displayName + " cannot be empty!");
        }
        return this;
    }

    /**
     * Ensures that the {@code String} input is not empty or blank, with a custom error message.
     *
     * @param errorMessage the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is empty or blank.
     */
    public Spark required(String errorMessage) throws SparkException {
        this.isString();

        if (this.inputStr.isBlank()) {
            throw new SparkException(errorMessage);
        }
        return this;
    }

    /**
     * Validates that the {@code String} input is a valid email address.
     *
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is not a valid email address.
     */
    public Spark email() throws SparkException {
        this.isString();

        if (!pattern.matcher(this.inputStr).matches()) {
            throw new SparkException("Invalid Email!");
        }
        return this;
    }

    /**
     * Validates that the {@code String} input is equal to another {@code String}.
     *
     * @param otherString the {@code String} to compare with.
     * @param msg the custom error message if the strings are not equal.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input does not equal the other {@code String}.
     */
    public Spark equals(String otherString, String msg) throws SparkException {
        this.isString();

        if (!this.inputStr.equals(otherString)) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ensures that the {@code String} input meets a minimum length requirement.
     *
     * @param length the minimum number of characters.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is shorter than the specified length.
     */
    public Spark minLength(int length) throws SparkException {
        this.isString();

        if (this.inputStr.length() < length) {
            throw new SparkException(displayName + " must include more than " + length + " characters!");
        }
        return this;
    }

    /**
     * Ensures that the {@code String} input meets a minimum length requirement, with a custom error message.
     *
     * @param length the minimum number of characters.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is shorter than the specified length.
     */
    public Spark minLength(int length, String msg) throws SparkException {
        this.isString();

        if (this.inputStr.length() < length) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ensures that the {@code String} input does not exceed a maximum length.
     *
     * @param length the maximum number of characters.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input exceeds the specified length.
     */
    public Spark maxLength(int length) throws SparkException {
        this.isString();

        if (this.inputStr.length() > length) {
            throw new SparkException(displayName + " must include less than " + length + " characters!");
        }
        return this;
    }

    /**
     * Ensures that the {@code String} input does not exceed a maximum length, with a custom error message.
     *
     * @param length the maximum number of characters.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input exceeds the specified length.
     */
    public Spark maxLength(int length, String msg) throws SparkException {
        this.isString();

        if (this.inputStr.length() > length) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Validates the {@code String} input against a custom regular expression pattern.
     *
     * @param pattern the regular expression pattern.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input does not match the specified pattern.
     */
    public Spark regex(String pattern) throws SparkException {

        if (!this.inputStr.matches(pattern)) {
            throw new SparkException("Invalid " + displayName + " !");
        }
        return this;
    }

     /**
     * Validates the {@code String} input against a custom regular expression pattern, with a custom error message.
     *
     * @param pattern the regular expression pattern.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input does not match the specified pattern.
     */
    public Spark regex(String pattern, String msg) throws SparkException {

        if (!this.inputStr.matches(pattern)) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ends the {@code String} validation chain and returns the validated {@code String}.
     *
     * @return the validated {@code String}.
     * @throws SparkException if the input is not a valid {@code String}.
     */
    public String endString() throws SparkException {

        if (this.inputInt != -9903) {
            return String.valueOf(this.inputInt);
        }

        this.isString();
        return this.inputStr;
    }

    // Integer validation methods
    /**
     * Converts the current {@code String} input to an {@code int}.
     *
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is not a valid number.
     */
    public Spark toInt() throws SparkException {
        this.required();
        try {
            this.inputInt = Integer.parseInt(this.inputStr);
        } catch (NumberFormatException e) {
            throw new SparkException(this.displayName + " must be a number!");
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input meets a minimum value requirement.
     *
     * @param val the minimum value.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is less than the specified minimum value.
     */
    public Spark min(int val) throws SparkException {
        this.isInt();

        if (this.inputInt < val) {
            throw new SparkException(displayName + " must be greater than " + val + "!");
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input meets a minimum value requirement, with a custom error message.
     *
     * @param val the minimum value.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is less than the specified minimum value.
     */
    public Spark min(int val, String msg) throws SparkException {
        this.isInt();

        if (this.inputInt < val) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input does not exceed a maximum value.
     *
     * @param val the maximum value.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input exceeds the specified maximum value.
     */
    public Spark max(int val) throws SparkException {
        this.isInt();

        if (this.inputInt > val) {
            throw new SparkException(displayName + " must be less than " + val + "!");
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input does not exceed a maximum value, with a custom error message.
     *
     * @param val the maximum value.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input exceeds the specified maximum value.
     */
    public Spark max(int val, String msg) throws SparkException {
        this.isInt();

        if (this.inputInt > val) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ends the {@code int} validation chain and returns the validated {@code int}.
     *
     * @return the validated {@code int}.
     */
    public int endInt() {
        if (this.inputStr != null) {
            return Integer.parseInt(this.inputStr);
        }

        return this.inputInt;
    }
}
