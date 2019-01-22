package org.application.controller;

import org.application.model.Message;
import org.application.utils.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToWordsController {

	public static final Logger logger = LoggerFactory.getLogger(NumberToWordsController.class);
	@Autowired
	private Message msg;
	
	
	@RequestMapping(value="/writeNumber/{value}", method = RequestMethod.GET)
	public Message formatNumber(@PathVariable("value") int value) {
		logger.info("Number to words {}", value);	
		
		if(value < 0 || value > 999999) {
			msg.setContent("Not supported!");
		return msg;	
		}
		msg.setContent(Convert.numberToWords(value));
		return msg;
	}
}
