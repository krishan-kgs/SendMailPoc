package com.send.mail.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.send.mail.model.Mail;
import com.send.mail.service.SendMailService;

/**
 *  
 *  @version     1.0, 03-Nov-2015
 *  @author Krishan
 */

@RestController
public class SendMailController {
	
	@Autowired
	private SendMailService sendMailService;
	
	@RequestMapping("/showForm")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("sendMail");
		return mv;
	}
	
	@RequestMapping(value ="/sendMail", method = RequestMethod.POST ,consumes={"application/json"})
	public ResponseEntity<Mail> checkStatus(@RequestBody Mail mail) {
		HttpStatus status = HttpStatus.OK;
		Mail sendMail = sendMailService.sendMail(mail);
		System.out.println(mail.getComment()+mail.getFromAddr()+mail.getToAddr()+mail.getSubject()+mail.getContent());
		return new ResponseEntity <Mail>(sendMail,status);

		
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, Exception ex) {
		System.out.println("Error occurred in serving requested URL[ " + request.getRequestURL() + "?" + request.getQueryString() + " ], error ::: "
				+ ex.getMessage());
		String errorMessage = "Procession failed :: " + ex.getMessage();
		//DBObject dbObject = new BasicDBObject().append("msg", errorMessage).append("ok", 0);
		return errorMessage;
	}

}
