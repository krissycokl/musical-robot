package com.sg.m2dvdlibrary.controller;

import com.sg.m2dvdlibrary.dao.DVDDao;
import com.sg.m2dvdlibrary.dao.DVDDaoException;
import com.sg.m2dvdlibrary.dto.DVD;
import com.sg.m2dvdlibrary.ui.DVDView;
import java.util.HashMap;

public class DVDController {

    DVDView view;
    DVDDao dao;
    int choice;
    
    public DVDController(DVDView view, DVDDao dao){
        this.view = view;
        this.dao  = dao;
    }
    
    public boolean run() throws DVDDaoException, NumberFormatException{
        choice = getSelectionMain();
        switch(choice){
            case 1:
                addDVD();
                break;
            case 2:
                getDVDByName();
                break;
            case 3:
                listAllDVDs();
                break;
            case 4:
                exitAndSave();
                return false;
            case 5:
                if(exitWithoutSave()==1){
                    return false;
                }
                break;
            default:
                invalidInput();
        }
        return true;
    }
    
    private void addDVD(){
        dao.addDVD(view.getNewDVDInfo());
    }
        
    private int getSelectionMain(){
        return view.getMenuMain();
    }
    
    private void getSelectionDVD(int key){
        DVD dvd = dao.getDVD(key);
        int action = view.getMenuDVD(dvd);
        switch(action){
            case 1:
                dvd.setTitle(view.getTitle());
                break;
            case 2:
                dvd.setYear(view.getYear());
                break;
            case 3:
                dvd.setDirector(view.getDirector());
                break;
            case 4:
                dvd.setStudio(view.getStudio());
                break;
            case 5:
                dvd.setRating(view.getRating());
                break;
            case 6:
                dvd.setNote(view.getNote());
                break;
            case 7:
                dao.removeDVD(key);
        }
    }
    
    private void invalidInput(){
        view.bannerBadInput();
    }
    
    private void exitAndSave() throws DVDDaoException{
        int save = view.confirmSave();
        if(save==1){
            dao.save();
            view.saveSuccess(dao.listDVDs().size());
        }
    }
    
    private int exitWithoutSave() {
        return view.confirmExit();
    }
    
    private void chooseFromMultiple(String response){
        int key;
        try{key = Integer.parseInt(response);}
        catch (NumberFormatException e) {key = -1;}
        if (dao.getDVD(key) != null){
            getSelectionDVD(key);
        }
    }
    
    private void getDVDByName(){
        HashMap<Integer, DVD> dvds = dao.listDVDs(view.getDVDTitle());
        view.showDVDs(dvds);
        chooseFromMultiple(view.getMenuMultiple());
    }
    
    private void listAllDVDs(){
        view.bannerAllDVDS();
        view.showDVDs(dao.listDVDs());        
        chooseFromMultiple(view.getMenuMultiple());
    }
}