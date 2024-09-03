/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wishva.validator;

/**
 *
 * @author vishva
 */

public class SparkException extends Exception {

    public final String title = "Validation Error";

    public SparkException(String error) {
        super(error);
    }
}
