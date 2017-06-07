package com.sg.m5flooringmastery;

import com.sg.m5flooringmastery.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = ctx.getBean("controller",FlooringController.class);
        
        boolean stop = false;
        while (!stop){
            stop = controller.run();
        }
    }
}