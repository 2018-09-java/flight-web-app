/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author claudio
 */
@Path("flights")
public class FlightsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightsResource
     */
    public FlightsResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.example.controllers.FlightsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        JSONObject rootObj = new JSONObject();

        List<Flight> flights = new ArrayList();

        try {
            Flight flight = new Flight.Builder()
                    .setCode("AZ793")
                    .setFrom("Rome")
                    .setTo("Munich")
                    .build();
            flights.add(flight);
            flight = new Flight.Builder()
                    .setCode("AZ901")
                    .setFrom("Rome")
                    .setTo("Berlin")
                    .build();
            flights.add(flight);
            flight = new Flight.Builder()
                    .setCode("AZ902")
                    .setFrom("Paris")
                    .setTo("Beijing")
                    .build();
            flights.add(flight);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

        JSONArray jsonArray = new JSONArray();

        flights.forEach(
                f -> {
                    JSONObject flightJson = new JSONObject();
                    flightJson.put("code", f.getCode());
                    flightJson.put("from", f.getFrom());
                    flightJson.put("to", f.getTo());
                    jsonArray.put(flightJson);
                }
        );

        rootObj.put("flights", jsonArray);
        return rootObj.toString();
    }

    /**
     * PUT method for updating or creating an instance of FlightsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
