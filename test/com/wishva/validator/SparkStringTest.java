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

    /**
     * Test of email method, of class SparkString.
     */
    @Test
    public void testEmail_0args() throws Exception {
        System.out.println("email");
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.email();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of email method, of class SparkString.
     */
    @Test
    public void testEmail_String() throws Exception {
        System.out.println("email");
        String msg = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.email(msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class SparkString.
     */
    @Test
    public void testEquals() throws Exception {
        System.out.println("equals");
        String otherString = "";
        String msg = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.equals(otherString, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minLength method, of class SparkString.
     */
    @Test
    public void testMinLength_int() throws Exception {
        System.out.println("minLength");
        int length = 0;
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.minLength(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minLength method, of class SparkString.
     */
    @Test
    public void testMinLength_int_String() throws Exception {
        System.out.println("minLength");
        int length = 0;
        String msg = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.minLength(length, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxLength method, of class SparkString.
     */
    @Test
    public void testMaxLength_int() throws Exception {
        System.out.println("maxLength");
        int length = 0;
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.maxLength(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxLength method, of class SparkString.
     */
    @Test
    public void testMaxLength_int_String() throws Exception {
        System.out.println("maxLength");
        int length = 0;
        String msg = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.maxLength(length, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of regex method, of class SparkString.
     */
    @Test
    public void testRegex_String() throws Exception {
        System.out.println("regex");
        String pattern = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.regex(pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of regex method, of class SparkString.
     */
    @Test
    public void testRegex_String_String() throws Exception {
        System.out.println("regex");
        String pattern = "";
        String msg = "";
        SparkString instance = null;
        SparkString expResult = null;
        SparkString result = instance.regex(pattern, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getString method, of class SparkString.
     */
    @Test
    public void testGetString() throws Exception {
        System.out.println("getString");
        SparkString instance = null;
        String expResult = "";
        String result = instance.getString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
