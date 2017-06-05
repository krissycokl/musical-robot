package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.FlooringDao;

public class FlooringServiceImpl implements FlooringService {
    
    private FlooringDao dao;
    
    public FlooringServiceImpl(FlooringDao dao){
        this.dao = dao;
    }

}
