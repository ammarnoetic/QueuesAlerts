package com.task.rabbitmqThreeQeuesConsumer.model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProcessRequest {


    public void getDataA(int message){

        int count=0;
        if (count<=message) {

                log.info("message recieved from QUEUE High->{}", message);
                count++;
        }
        else {
            return;
        }
    }

    public void getDataB(int message) throws InterruptedException {

        Thread thread= new Thread();
        thread.sleep(2000);
        for (int i=0;i<=message;i++) {
            log.info("message recieved from QUEUE Low->{}", message);
            i++;
        }



    }

}
