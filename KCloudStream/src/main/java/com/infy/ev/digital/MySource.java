package com.infy.ev.digital;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

	/**
	 * Name of the output channel.
	 */
	String OUTPUT_1 = "output_1";

	String OUTPUT_2 = "output_2";

	/**
	 * @return output channel
	 */
	@Output(MySource.OUTPUT_1)
	MessageChannel output_1();

	@Output(MySource.OUTPUT_2)
	MessageChannel output_2();

}
