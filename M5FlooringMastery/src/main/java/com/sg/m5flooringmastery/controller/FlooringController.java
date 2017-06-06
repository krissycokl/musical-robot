package com.sg.m5flooringmastery.controller;

import com.sg.m5flooringmastery.service.FlooringService;
import com.sg.m5flooringmastery.view.FlooringView;

public class FlooringController {
    private FlooringView view;
    private FlooringService service;
    
    public FlooringController(FlooringView view, FlooringService service){
        this.view = view;
        this.service = service;
    }
    
    public boolean run() {
        return true;
    }
}
