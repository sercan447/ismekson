package com.ismek.exphandler;


import java.io.IOException;

import javax.persistence.NoResultException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class RestResponseExceptionHandler {

	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> HataHandle(IOException e) {
		
		return new ResponseEntity<Object>("BLBALBAL"+e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	/*@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Object> HatNoResultHandle(NoResultException noresult){
		return new ResponseEntity<Object>("No Result Hatasý",HttpStatus.NOT_FOUND);
	}
	*/
	
	
}
