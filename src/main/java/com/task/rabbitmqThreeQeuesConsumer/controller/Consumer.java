package com.task.rabbitmqThreeQeuesConsumer.controller;
import com.task.rabbitmqThreeQeuesConsumer.model.ProcessRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Properties;

@Component
@Slf4j
public class Consumer  {


    @Autowired
    private ProcessRequest  processRequest;

        @Autowired
    private RabbitAdmin admin;



    //accept the message from producer
    @RabbitListener(queues = "highMt")
    public void receive(int message)  {


            processRequest.getDataA(message);


            //log.info("message recieved from QUEUE A->{}", message);


        }


    //accept the message from producer
    @RabbitListener(queues = "lowMt")
    public void receiveFromB(int message) throws InterruptedException {

        processRequest.getDataB(message);

    }

//    for genertaion of alert if consumer is not running
    public static int checkmessage;
    @Scheduled(fixedRate = 2000)
    public void getCounts(){
        Properties props;
        Integer messageCount;
        //int store;
        //int checkmessage

        log.info("Fixed delay task -   Current Time "+ LocalDate.now());
            props = admin.getQueueProperties("lowMt");
            messageCount = Integer.parseInt(props.get("QUEUE_MESSAGE_COUNT").toString());

            System.out.println("lowMt"+ " has " + messageCount + " messages");


            //checkmessage=messageCount;
            //store=checkmessage;

        //System.out.println(checkmessage);
//
//            if (checkmessage<=messageCount){
//
//                checkmessage=messageCount;
//
//                System.out.println("if condition");
//
//               // System.out.println("send message to email");
//            }
//
//
//            else if (checkmessage>messageCount){
//
//                System.out.println(checkmessage);
//                System.out.println("mail generrated");
//            }


        if(checkmessage==0){
            checkmessage=messageCount;
            System.out.println("0 wali condition");
        }


        else if (checkmessage<=messageCount){
            System.out.println(checkmessage);
            System.out.println("send message to email");
           // checkmessage=messageCount;
            System.out.println(checkmessage+"updated mcges");
        }

        checkmessage=messageCount;
        System.out.println(checkmessage);



    }



}