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

/**
 *
 * @author vishv
 */
public class SparkString {
    
    private String displayName;
    private String input;
    
    private static final String EMAIL_REGEX
            = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
    /**
     * Constructs a new {@code Spark} validator for a {@code String} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code String} to be validated.
     */
    public SparkString(String displayName, String input) {
        this.displayName = displayName;
        this.input = input;
    }
    
    /**
     * Constructs a new {@code Spark} validator for a {@code char[]} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code char[]} to be validated.
     */
    public SparkString(String displayName, char[] input) {
        this.displayName = displayName;
        this.input = String.valueOf(input);
    }
    
    /**
     * Ensures that the {@code String} input is not empty or blank.
     *
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is empty or blank.
     */
    public SparkString required() throws SparkException {

        if (this.input.isBlank()) {
            throw new SparkException(displayName + " cannot be empty!");
        }
        return this;
    }
    
    /**
     * Ensures that the {@code String} input is not empty or blank, with a custom error message.
     *
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is empty or blank.
     */
    public SparkString required(String msg) throws SparkException {

        if (this.input.isBlank()) {
            throw new SparkException(msg);
        }
        return this;
    }
    
    /**
     * Validates that the {@code String} input is a valid email address.
     *
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is not a valid email address.
     */
    public SparkString email() throws SparkException {

        if (!this.input.matches(SparkString.EMAIL_REGEX)) {
            throw new SparkException("Invalid Email!");
        }
        return this;
    }
    
    /**
     * Validates that the {@code String} input is a valid email address, with a custom error message.
     *
     * @param msg
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is not a valid email address.
     */
    public SparkString email(String msg) throws SparkException {

        if (!this.input.matches(SparkString.EMAIL_REGEX)) {
            throw new SparkException(msg);
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
    public SparkString equals(String otherString, String msg) throws SparkException {

        if (!this.input.equals(otherString)) {
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
    public SparkString minLength(int length) throws SparkException {
        
        if (this.input.length() < length) {
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
    public SparkString minLength(int length, String msg) throws SparkException {

        if (this.input.length() < length) {
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
    public SparkString maxLength(int length) throws SparkException {

        if (this.input.length() > length) {
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
    public SparkString maxLength(int length, String msg) throws SparkException {

        if (this.input.length() > length) {
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
    public SparkString regex(String pattern) throws SparkException {

        if (!this.input.matches(pattern)) {
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
    public SparkString regex(String pattern, String msg) throws SparkException {

        if (!this.input.matches(pattern)) {
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
    public String getString() throws SparkException {

        return this.input;
    }
}
