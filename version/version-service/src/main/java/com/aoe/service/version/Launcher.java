package com.aoe.service.version;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by joey on 16-7-20.
 */
@SpringBootApplication
public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Launcher.class,args);
        while (true){
            synchronized (Launcher.class){
                Launcher.class.wait();
            }
        }
    }
}
