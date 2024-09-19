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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vishv
 */
public class SparkStringTest {
    
    public SparkStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of required method, of class SparkString.
     */
    @Test
    public void testRequired_0args(){
        
        String displayName = "Username";
        String expectedError = displayName + " cannot be empty!";
        
        try {
            
            new SparkString(displayName, "")
                    .required();
            
        } catch (SparkException e) {
            assertEquals(e.getMessage(), expectedError);
        }
    }

    /**
     * Test of required method, of class SparkString.
     */
    @Test
    public void testRequired_String() {
        String displayName = "Username";
        String inputError = "custom error";
        
        try {
            
            new SparkString(displayName, "")
                    .required(inputError);
            
        } catch (SparkException e) {
            assertEquals(e.getMessage(), inputError);
        }
    }
}
