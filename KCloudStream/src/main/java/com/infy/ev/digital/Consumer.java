package com.infy.ev.digital;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Sink.class)
public class Consumer {
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private Producer producer;

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='string'")
	public void consume(@Payload String message) {
		logger.info("received a string message : " + message);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='chat'")
	public void handle(@Payload ChatMessage message) {
		final DateTimeFormatter df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)
				.withZone(ZoneId.systemDefault());
		final String time = df.format(Instant.ofEpochMilli(message.getTime()));
		logger.info("received a complex message : [{}]: {}", time, message.getContents());

		producer.getMysource().output_2().send(MessageBuilder.withPayload(message).build());
	}
}