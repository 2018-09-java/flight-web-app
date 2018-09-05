/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author claudio
 */
public class Flights extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            } catch (IllegalArgumentException e) {
                response.setStatus(500);
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

            out.print(rootObj);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
