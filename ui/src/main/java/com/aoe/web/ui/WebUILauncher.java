package com.aoe.web.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

/**
 * Created by joey on 16-8-4.
 */
@SpringBootApplication
public class WebUILauncher {

    public static void main(String[] args) {
        SpringApplication.run(WebUILauncher.class, args);
    }

}
