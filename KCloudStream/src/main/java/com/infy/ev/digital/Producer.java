package com.infy.ev.digital;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MySource.class)
public class Producer {
	private MySource mySource;

	public Producer(MySource mySource) {
		super();
		this.mySource = mySource;
	}

	public MySource getMysource() {
		return mySource;
	}

	public void setMysource(MySource source) {
		this.mySource = source;
	}
}