/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.factory;

import com.example.model.Flight;
import java.util.List;

/**
 *
 * @author claudio
 */
public class FlightFactory {

    public static String MEMORY_IMPL = "MemoryImpl";

    public static List<Flight> getAll(String implementionType) {
        if (implementionType.equals(MEMORY_IMPL)) {
            return FlightMemoryImpl.getAll();
        } else {
            // we should implement the database!!!!
            throw new IllegalArgumentException("Implementation type not supported: " + implementionType + ". Now only MemoryImpl is supported");
        }
    }

    public static List<Flight> getAll() {
        return FlightFactory.getAll(MEMORY_IMPL);
    }
}
