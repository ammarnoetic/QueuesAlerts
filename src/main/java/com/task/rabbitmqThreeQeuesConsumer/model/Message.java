package com.task.rabbitmqThreeQeuesConsumer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

    private int id;
    private String name;
}