package com.sg.m2dvdlibrary.controller;

import com.sg.m2dvdlibrary.dao.DVDDaoException;
import com.sg.m2dvdlibrary.dao.DVDFields;
import com.sg.m2dvdlibrary.dto.DVD;
import com.sg.m2dvdlibrary.service.DVDDataValidationException;
import com.sg.m2dvdlibrary.service.DVDService;
import com.sg.m2dvdlibrary.ui.DVDView;
import java.util.List;
import java.util.Map;

public class DVDController {

    DVDView view;
    DVDService service;
    
    public DVDController(DVDView view, DVDService service){
        this.view = view;
        this.service  = service;
    }
    
    public void begin() {
        boolean run = true;
        try{
            int choice = view.getMenuImport();
            switch(choice){
                case 1:
                    service.populate();
                    view.importSuccess(service.listDVDs().size());
                    break;
                case 2:
                    break;
                case 3:
                    run = false;
            }
            while(run){
                run = run();
            }
            view.goodBye();
        } catch (DVDDaoException | DVDDataValidationException er) {
            view.bannerError(er.getMessage());
        }
    }
    
    public boolean run() throws DVDDaoException, DVDDataValidationException{
        int choice = getSelectionMain();
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
                getSelectionASearch();
                break;
            case 5:
                if(exitAndSave()==1){
                    return false;
                };
                break;
            case 6:
                if(exitWithoutSave()==1){
                    return false;
                }
                break;
            default:
                invalidInput();
        }
        return true;
    }
    
    private void addDVD() throws DVDDataValidationException, DVDDaoException{
        service.addDVD(view.getNewDVDInfo());
    }
        
    private int getSelectionMain(){
        return view.getMenuMain();
    }
    
    private void getSelectionASearch() {
        int key;
        int search = view.getMenuSearch();
        switch(search){
            case 1:
                int year = view.getYear();
                view.bannerMoviesAfter(year);
                view.showDVDs(service.getDVDsAfterYear(year));
                break;
            case 2:
                view.showDVDs(service.getDVDsByRating(view.getRating()));
                break;
            case 3:
                String director = view.getDirector();
                view.bannerMoviesBy("Director", director);
                Map<String, List<DVD>> dvds = service.getDVDsByDirector(director);
                if (dvds.values().isEmpty()){
                    view.bannerNoResults();
                } else {
                    view.groupMoviesByRating(dvds);
                }
                break;
            case 4:
                String studio = view.getStudio();
                view.bannerMoviesBy("Studio", studio);
                view.showDVDs(service.getDVDsByStudio(studio));
                break;
            case 5:
                view.bannerAverageAge(service.getAverageAge());
                break;
            case 6:
                key = service.getByAge(true);
                view.bannerMovieByAge(true);
                view.getMenuDVD(service.getDVD(key));
                break;
            case 7:
                key = service.getByAge(false);
                view.bannerMovieByAge(false);
                view.getMenuDVD(service.getDVD(key));
                break;
            case 8:
                view.bannerNumberOfNotes(service.getNotes());
                break;
            default:
                invalidInput();
        }
    }
    
    private void getSelectionDVD(int key) throws DVDDataValidationException, DVDDaoException {
        DVD dvd = service.getDVD(key);
        int action = view.getMenuDVD(dvd);
        switch(action){
            case 1:
                service.editDVD(dvd, DVDFields.fields.TITLE, view.getTitle());
                break;
            case 2:
                service.editDVD(dvd, DVDFields.fields.YEAR, view.getDate());
                break;
            case 3:
                service.editDVD(dvd, DVDFields.fields.DIRECTOR, view.getDirector());
                break;
            case 4:
                service.editDVD(dvd, DVDFields.fields.STUDIO, view.getStudio());
                break;
            case 5:
                service.editDVD(dvd, DVDFields.fields.RATING, view.getRating());
                break;
            case 6:
                service.editDVD(dvd, DVDFields.fields.COMMENT, view.getNote());
                break;
            case 7:
                int conf = view.confirmDelete();
                if (conf==1){
                    service.removeDVD(key);
                }
                break;
            case 8:
                break;
            default:
                invalidInput();
        }
    }
    
    private void invalidInput(){
        view.bannerBadInput();
    }
    
    private int exitAndSave() throws DVDDaoException{
        int save = view.confirmSave();
        if(save==1){
            service.save();
            view.saveSuccess(service.listDVDs().size());
        }
        return save;
    }
    
    private int exitWithoutSave() {
        return view.confirmExit();
    }
    
    private void chooseFromMultiple(int key) throws DVDDaoException, DVDDataValidationException{
        if (service.getDVD(key) != null){
            getSelectionDVD(key);
        } 
    }
    
    private void getDVDByName() throws DVDDaoException, DVDDataValidationException{
        Map<Integer, DVD> dvds = service.listDVDs(view.getDVDTitle());
        view.showDVDs(dvds);
        chooseFromMultiple(view.getMenuMultiple());
    }
    
    private void listAllDVDs() throws DVDDaoException, DVDDataValidationException{
        view.bannerAllDVDS();
        view.showDVDs(service.listDVDs());        
        chooseFromMultiple(view.getMenuMultiple());
    }
}