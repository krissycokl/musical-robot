package com.sg.m2dvdlibrary.App;
import com.sg.m2dvdlibrary.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller = ctx.getBean("controller",DVDController.class);
        controller.begin();
    }
}
