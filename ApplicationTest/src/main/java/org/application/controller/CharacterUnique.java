package org.application.controller;

import java.util.TreeSet;

import org.application.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterUnique {

	@Autowired
	private Message msg;
	
	@RequestMapping(value="/stringDedup/{string}", method=RequestMethod.GET)
	public Message stringDedup(@PathVariable("string") String string) {
		if(string.isEmpty() || string == null) {
			msg.setContent("Not suppoted!");
			return msg;
		}
		msg.setContent(getUniqueChar(string));
		return msg;
	}

	private String getUniqueChar(String string) {
		TreeSet<Character> t = new TreeSet<>();
		for (char c : string.toCharArray()) {
			if(c !=' ') t.add(c);
		}
		return t.toString().replaceAll("(^\\[)|(,)|(]$)", "");
	}
}
