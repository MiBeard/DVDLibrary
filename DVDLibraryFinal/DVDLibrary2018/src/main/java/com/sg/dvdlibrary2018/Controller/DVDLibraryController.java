/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018.Controller;

import com.sg.dvdlibrary2018.Dao.DVDLibraryDao;
import com.sg.dvdlibrary2018.Dao.DVDLibraryDaoException;
import com.sg.dvdlibrary2018.Dto.DVD;
import com.sg.dvdlibrary2018.UI.DVDLibraryView;
import java.util.List;

/**
 *
 * @author jamesbond
 */
public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {

                    case 1:
                        listAllDvds();
                        break;
                    case 2:
                        searchDvd();
                        break;
                    case 3:
                        createDvd();
                        break;
                    case 4:
                        viewDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        removeDvd();
                        break;
                    case 7:
                        keepGoing = false;
                        exit();
                        break;
                    default:
                        unknownCommand();
                }
            }

        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuSelection();
    }

    private void createDvd() throws DVDLibraryDaoException {
        view.displayAddDvdBanner();
        DVD newDvd = view.getNewDvdInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayAddSuccessBanner();
    }

    private void listAllDvds() throws DVDLibraryDaoException {
        view.displayAllDvds();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayAllDvdList(dvdList);
    }

    private void searchDvd() throws DVDLibraryDaoException {
        view.displaySearchDvd();
        String title = view.getDvdChoice();
        List<DVD> dvds = dao.searchDvd(title);
        view.displayAllDvdList(dvds);
        view.displaySearchDvdSuccess();
    }

    private void viewDvd() throws DVDLibraryDaoException {
        view.displayDvdBanner();
        String title = view.getDvdChoice();
        DVD dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void editDvd() throws DVDLibraryDaoException {
        String title = view.displayEditChoice();
        DVD editDvd = view.EditDvdInfo();
        dao.removeDvd(title);
        dao.addDVD(editDvd.getTitle(), editDvd);
        view.displayEditSuccess();
    }

    private void removeDvd() throws DVDLibraryDaoException {
        view.displayRemovedBanner();
        String title = view.getDvdChoice();
        dao.removeDvd(title);
        view.displayRemovedSuccess();

    }

    private void unknownCommand() {
        view.displayUnknownBanner();
    }

    private void exit() {
        view.displayExitBanner();
    }

}
