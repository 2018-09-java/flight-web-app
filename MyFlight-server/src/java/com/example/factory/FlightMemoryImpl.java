/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.factory;

import com.example.model.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author claudio
 */
class FlightMemoryImpl {

    static List<Flight> getAll() {
        List<Flight> flights = new ArrayList();
        try {
            Flight flight = new Flight.Builder()
                    .setCode("AZ793")
                    .setFrom("Rome")
                    .setTo("Munich")
                    .setImgUrl("az-logo.png")
                    .build();
            flights.add(flight);
            flight = new Flight.Builder()
                    .setCode("AZ901")
                    .setFrom("Rome")
                    .setTo("Berlin")
                    .setImgUrl("az-logo.png")
                    .build();
            flights.add(flight);
            flight = new Flight.Builder()
                    .setCode("IB902")
                    .setFrom("Paris")
                    .setTo("Beijing")
                    .setImgUrl("ib-logo.png")
                    .build();
            flights.add(flight);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return flights;
    }

}
