package com.sg.m3vendingmachine;

import com.sg.m3vendingmachine.controller.*;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main (String[] args) throws IOException {
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingController controller = ctx.getBean("controller",VendingController.class);
        
        controller.run();
    }
}
