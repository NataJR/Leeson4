package com.example.geekbrainsdb.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportScheduler {


    @Scheduled(fixedRate = 1000)
    public void sendReport(){
        System.out.println("NEW REPORT SENT!!!");
    }



}
