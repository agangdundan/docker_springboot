package org.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.ApplicationContext;

/**
 * Created on 19/11/14.
 */

@Controller
@EnableWebMvc
@EnableAutoConfiguration
public class DemoApplication {
    
    @Value("${currentEnv}")
    private String env;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello spring! profile="+env;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();  
        for (String profile : activeProfiles) {  
            System.out.println("Spring Boot 使用profile为:{}"+ profile);
        } 
    }

}


  
     