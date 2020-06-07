package com.infy.ev.digital;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private Producer producer;

	public Controller(Producer producer) {
		super();
		this.producer = producer;
	}

	@RequestMapping(value = "/sendMessage/complexType", method = RequestMethod.POST)
	public String publishMessageComplextType(@RequestBody ChatMessage payload) {

		payload.setTime(System.currentTimeMillis());
		producer.getMysource().output_1().send(MessageBuilder.withPayload(payload).setHeader("type", "chat").build());

		return "success";
	}

	@RequestMapping(value = "/sendMessage/string", method = RequestMethod.POST)
	public String publishMessageString(@RequestBody String payload) {

		// send message to channel
		producer.getMysource().output_1().send(MessageBuilder.withPayload(payload).setHeader("type", "string").build());

		return "success";
	}
}