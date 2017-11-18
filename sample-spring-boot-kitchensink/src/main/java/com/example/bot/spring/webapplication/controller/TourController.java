package com.example.bot.spring.webapplication.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.bot.spring.webapplication.domain.Tour;
import com.example.bot.spring.webapplication.service.TourService;

@Controller
class TourController {
		
    @Autowired
    TourService tourService;
    
    
    @RequestMapping(value = "/tour", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView home() {
    	ModelAndView modelAndView = new ModelAndView("tour");
    	try {
			modelAndView.addObject("tours", tourService.getTours());
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("message", "Failed to get tour infos");
		}
        return modelAndView;
    }
    
    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    ModelAndView addTour(@RequestParam(value="tourId", required=true, defaultValue= "") String tourId,
    						@RequestParam(value="date", required=true, defaultValue= "") String date,
    						@RequestParam(value="capcity", required=true, defaultValue= "") Integer tourCapacity,
    						@RequestParam(value="tourGuideId", required=true, defaultValue= "") Integer tourGuideId,
    						@RequestParam(value="nameOfHotel", required=true, defaultValue= "") String nameOfHotel) throws Exception {

        ModelAndView modelAndView = new ModelAndView("tour");
        try {
        	Tour tour = new Tour();
        	tour.setNameOfHotel(nameOfHotel);
        	tour.setTourId(tourId);
        	tour.setTourCapacity(tourCapacity);
        	tour.setTourGuideId(tourGuideId);
        	tour.setTourDate(date);
        }
        catch (Exception e){
        	e.printStackTrace();
            modelAndView.addObject("message", "Failed to add customer: " + e.getMessage());
        }
        try {
        	modelAndView.addObject("tours", tourService.getTours());
        	modelAndView.addObject("generalTours", tourService.getGeneralTours());
        }catch(Exception e) {
        	e.printStackTrace();
        	modelAndView.addObject("message", "Failed to get tour infos");
        }
        return modelAndView;
    }
}
