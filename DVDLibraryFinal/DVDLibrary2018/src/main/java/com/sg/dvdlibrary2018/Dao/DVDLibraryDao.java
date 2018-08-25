/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018.Dao;

import com.sg.dvdlibrary2018.Dto.DVD;
import java.util.List;

/**
 *
 * @author jamesbond
 */
public interface DVDLibraryDao {

    DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException;

    List<DVD> getAllDvds()
            throws DVDLibraryDaoException;

    DVD getDvd(String title)
            throws DVDLibraryDaoException;

    DVD removeDvd(String title)
            throws DVDLibraryDaoException;
    
    List<DVD> searchDvd(String keyword)
            throws DVDLibraryDaoException;
}
