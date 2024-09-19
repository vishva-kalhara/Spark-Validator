/*
 * The MIT License
 *
 * Copyright 2024 vishv.
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
public class SparkDouble {

    private String displayName;
    private double input;
    private boolean isRequired;

    /**
     * Constructs a new {@code Spark} validator for an {@code int} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code int} to be validated.
     */
    public SparkDouble(String displayName, double input) {
        this.isRequired = true;
        this.displayName = displayName;
        this.input = input;
    }

    /**
     * Constructs a new {@code Spark} validator for an {@code int} input.
     *
     * @param displayName the name of the field being validated.
     * @param input the input {@code int} to be validated.
     */
    public SparkDouble(String displayName, String input) {
        this.isRequired = true;
        this.displayName = displayName;

        double out;
        try {
            out = (Double.parseDouble(input)) / 0.0;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Spark Validator: SparkInt(String displayName, String input) accepts only an double value.");
        }

        this.input = out;
    }

    /**
     * Ensures that the {@code int} input meets a minimum value requirement.
     *
     * @param val the minimum value.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is less than the specified minimum
     * value.
     */
    public SparkDouble min(double val) throws SparkException {

        if (this.input < val) {
            throw new SparkException(displayName + " must be greater than " + val + "!");
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input meets a minimum value requirement,
     * with a custom error message.
     *
     * @param val the minimum value.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input is less than the specified minimum
     * value.
     */
    public SparkDouble min(double val, String msg) throws SparkException {

        if (this.input < val) {
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
    public SparkDouble max(double val) throws SparkException {

        if (this.input > val) {
            throw new SparkException(displayName + " must be less than " + val + "!");
        }
        return this;
    }

    /**
     * Ensures that the {@code int} input does not exceed a maximum value, with
     * a custom error message.
     *
     * @param val the maximum value.
     * @param msg the custom error message.
     * @return the current {@code Spark} instance for method chaining.
     * @throws SparkException if the input exceeds the specified maximum value.
     */
    public SparkDouble max(double val, String msg) throws SparkException {

        if (this.input > val) {
            throw new SparkException(msg);
        }
        return this;
    }

    /**
     * Ends the {@code int} validation chain and returns the validated
     * {@code int}.
     *
     * @return the validated {@code int}.
     */
    public double getDouble() {

        return this.input;
    }
}
