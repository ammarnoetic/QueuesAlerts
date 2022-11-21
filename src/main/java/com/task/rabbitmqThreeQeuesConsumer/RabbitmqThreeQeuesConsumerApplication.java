package com.task.rabbitmqThreeQeuesConsumer;

import com.task.rabbitmqThreeQeuesConsumer.controller.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
public class RabbitmqThreeQeuesConsumerApplication {

	@Autowired
	private Consumer consumer;
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqThreeQeuesConsumerApplication.class, args);
	}



	@PostConstruct
	public void call(){
		consumer.getCounts();

	}
}
