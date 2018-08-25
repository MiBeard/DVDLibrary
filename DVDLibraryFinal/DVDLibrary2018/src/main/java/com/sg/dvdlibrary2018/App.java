/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018;

import com.sg.dvdlibrary2018.Controller.DVDLibraryController;
import com.sg.dvdlibrary2018.Dao.DVDLibraryDao;
import com.sg.dvdlibrary2018.Dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary2018.UI.DVDLibraryView;
import com.sg.dvdlibrary2018.UI.UserIO;
import com.sg.dvdlibrary2018.UI.UserIOConsoleImpl;

/**
 *
 * @author jamesbond
 */
public class App {

    public static void main(String[] args) {

        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller
                = new DVDLibraryController(myDao, myView);
        controller.run();

    }

}
