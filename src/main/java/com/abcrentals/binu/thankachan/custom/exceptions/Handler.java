package com.abcrentals.binu.thankachan.custom.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.abcrentals.binu.thankachan.constants.RentalWebsiteConstants;

/*
 * ControllerAdvice class to intercept/handle exceptions and route them accordingly to display custom error pages
 * 
 * 
 * 
 */


@ControllerAdvice
public class Handler {

	// method to handle Exception class exceptions
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
  
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        List<String> details = new ArrayList<>();
        details.add(RentalWebsiteConstants.INTERNAL_SERVER_ERROR + "This is REALLY, REALLY AWFUL! WHY DID I GET AN EXCEPTION???  <br><br>Message: " + ex.getLocalizedMessage());
        modelAndView.addObject("message", details);
        return modelAndView;       
        
 
    }

	// method to handle NoHandlerFoundException class exceptions
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
  
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        List<String> details = new ArrayList<>();
        details.add(RentalWebsiteConstants.NOT_FOUND + "This is REALLY, REALLY AWFUL!  WHY CAN'T THE HANDLER BE FOUND???  <br><br>Message: " + ex.getLocalizedMessage());
        modelAndView.addObject("message", details);
        return modelAndView;       
        
 
    }    


	// method to handle RuntimeException class exceptions
    @ExceptionHandler(RuntimeException.class)
    public final ModelAndView handleRunTimeException(RuntimeException ex,
                                                WebRequest request) {
                   
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        List<String> details = new ArrayList<>();
        details.add(RentalWebsiteConstants.RUNTIME_EXCEPTION + "This is REALLY, REALLY AWFUL!  WHY A RUNTIME EXCEPTION, NOW???  <br><br>Message: " + ex.getLocalizedMessage());
        modelAndView.addObject("message", details);
        return modelAndView;       
     }
    
    
    
}