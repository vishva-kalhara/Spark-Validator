/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wishva;

import java.util.regex.Pattern;

/**
 *
 * @author vishv
 */
public class Spark {
    private String displayName = null;
    private String inputStr = null;
    private int inputInt = -9903;

    private static final String EMAIL_REGEX
            = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    private void isString() throws SparkException {
        if (inputStr == null) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
    }

    private void isInt() throws SparkException {
        if(this.inputStr != null) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
        if (inputInt == -9903) {
            throw new SparkException("Incompatible usage of chained methods! Read the Documentation.");
        }
    }

//  CONSTRUCTORS
    public Spark(String displayName, String input) {
        this.displayName = displayName;
        this.inputStr = input;
    }

    public Spark(String displayName, char[] input) {
        this.displayName = displayName;
        this.inputStr = String.valueOf(input);
    }

    public Spark(String displayName, int input) {
        this.displayName = displayName;
        this.inputInt = input;
    }

//  STRING METHODS
    public Spark required() throws SparkException {

        if (this.inputStr.isBlank()) {
            throw new SparkException(displayName + " cannot be empty!");
        }
        return this;
    }

    public Spark required(String errorMessage) throws SparkException {
        this.isString();

        if (this.inputStr.isBlank()) {
            throw new SparkException(errorMessage);
        }
        return this;
    }

    public Spark email() throws SparkException {
        this.isString();

        if (!pattern.matcher(this.inputStr).matches()) {
            throw new SparkException("Invalid Email!");
        }
        return this;
    }

    public Spark equals(String otherString, String msg) throws SparkException {
        this.isString();

        if (!this.inputStr.equals(otherString)) {
            throw new SparkException(msg);
        }
        return this;
    }

    public Spark minLength(int length) throws SparkException {
        this.isString();

        if (this.inputStr.length() < length) {
            throw new SparkException(displayName + " must include more than " + length + " characters!");
        }
        return this;
    }

    public Spark minLength(int length, String msg) throws SparkException {
        this.isString();

        if (this.inputStr.length() < length) {
            throw new SparkException(msg);
        }
        return this;
    }

    public Spark maxLength(int length) throws SparkException {
        this.isString();

        if (this.inputStr.length() > length) {
            throw new SparkException(displayName + " must include less than " + length + " characters!");
        }
        return this;
    }

    public Spark maxLength(int length, String msg) throws SparkException {
        this.isString();

        if (this.inputStr.length() > length) {
            throw new SparkException(msg);
        }
        return this;
    }

    public String endString() throws SparkException  {
        
        if(this.inputInt != -9903)
            return String.valueOf(this.inputInt);
        
        this.isString();
        return this.inputStr;
    }

//  INT METHODS
    public Spark toInt() throws SparkException  {
        this.required();
        try {
            this.inputInt = Integer.parseInt(this.inputStr);
        } catch (NumberFormatException e) {
            throw new SparkException(this.displayName + " must be a number!");
        }
        return this;
    }

    public Spark min(int val) throws SparkException {
        this.isInt();

        if (this.inputInt < val) {
            throw new SparkException(displayName + " must be greater than " + val + "!");
        }
        return this;
    }

    public Spark min(int val, String msg) throws SparkException {
        this.isInt();

        if (this.inputInt < val) {
            throw new SparkException(msg);
        }
        return this;
    }

    public Spark max(int val) throws SparkException {
        this.isInt();

        if (this.inputInt > val) {
            throw new SparkException(displayName + " must be less than " + val + "!");
        }
        return this;
    }

    public Spark max(int val, String msg) throws SparkException {
        this.isInt();

        if (this.inputInt > val) {
            throw new SparkException(msg);
        }
        return this;
    }

    public int endInt() {
        if (this.inputStr != null) {
            return Integer.parseInt(this.inputStr);
        }

        return this.inputInt;
    }
}
