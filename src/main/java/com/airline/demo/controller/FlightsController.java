package com.airline.demo.controller;

import com.airline.demo.entity.Flight;
import com.airline.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class FlightsController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public String getAllFlights(Model model){
        List<Flight> flightList = flightRepository.findAll();
        model.addAttribute("flights", flightList);
        return "flights";
    }

    @GetMapping("/selectFlight")
    public String getOneFlight(@ModelAttribute("flight") Flight flight, Model model){
        String dataPlecare = flight.getDateDepart();
        String dataAjungere = flight.getDateArrival();
        if(flight.getDateDepart().isEmpty()){
            flight.setDateDepart(null);
        }
        if(flight.getDateArrival().isEmpty()){
            flight.setDateArrival(null);
        }

        if(flight.getTakeOffLocation()==null){
            List<Flight> list = flightRepository.findByDateDepartAndDateArrival(flight.getDateDepart(), flight.getDateArrival());
            model.addAttribute("flight", list);
        }else if(flight.getDateArrival() != null){
            List<Flight> list = flightRepository.findByDateDepartAndDateArrivalAndTakeOffLocationAndDestination(flight.getDateDepart(), flight.getDateArrival(), flight.getTakeOffLocation(), flight.getDestination());
            model.addAttribute("flight", list);
        }else{
            flight.setDateArrival(dataAjungere);
            flight.setDateDepart(dataPlecare);
            List<Flight> list = flightRepository.findByTakeOffLocationAndDestination(flight.getTakeOffLocation(), flight.getDestination());
            model.addAttribute("flight", list);
        }
        return "selectFlight";
    }

}
