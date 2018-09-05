/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author claudio
 */
public class FlightTest {

    public FlightTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Builder, success case.
     */
    @Test
    public void testBuilderOK() {
        System.out.println("testBuilderOK");
        try {
            new Flight.Builder()
                    .setCode("AZ123")
                    .build();
        } catch (IllegalArgumentException e) {
            fail("Should use default values.");
        }
    }

    /**
     * Test of Builder, code not set.
     */
    @Test
    public void testBuilderNoCode() {
        System.out.println("testBuilderNoCode");
        try {
            new Flight.Builder()
                    .build();
            fail("Code not set.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of Builder, from not set, to is set.
     */
    @Test
    public void testBuilderFromTo1() {
        System.out.println("testBuilderFromTo1");
        try {
            new Flight.Builder()
                    .setFrom("Rome")
                    .build();
            fail("Attribute To is not set.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of Builder, from is set, to not set.
     */
    @Test
    public void testBuilderFromTo2() {
        System.out.println("testBuilderFromTo2");
        try {
            new Flight.Builder()
                    .setFrom("Rome")
                    .build();
            fail("Attribute From is not set.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of Builder, from is set, to is set.
     */
    @Test
    public void testBuilderFromTo3() {
        System.out.println("testBuilderFromTo3");
        try {
            new Flight.Builder()
                    .setFrom("Rome")
                    .setTo("Munich")
                    .build();
        } catch (IllegalArgumentException e) {
            fail("Attributes From and To are both set.");
        }
    }
}
