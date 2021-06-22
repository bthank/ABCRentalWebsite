package com.abcrentals.binu.thankachan.custom.exceptions;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Class to help provide custom error messages
 * 
 * 
 * 
 */


@XmlRootElement(name = "error")
public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
    
    
  
    public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	private String message;
    private List<String> details;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public List<String> getDetails() {
        return details;
    }
 
    public void setDetails(List<String> details) {
        this.details = details;
    }
}
