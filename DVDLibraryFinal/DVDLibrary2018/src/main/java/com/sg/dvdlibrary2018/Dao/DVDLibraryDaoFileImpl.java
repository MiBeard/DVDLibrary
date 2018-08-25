/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018.Dao;

import com.sg.dvdlibrary2018.Dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jamesbond
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException {
        loadDvd();
        DVD newDvd = dvds.put(title, dvd);
        writeDvd();
        return newDvd;
    }

    @Override
    public List<DVD> getAllDvds()
            throws DVDLibraryDaoException {
        loadDvd();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDvd(String title)
            throws DVDLibraryDaoException {
        loadDvd();
        return dvds.get(title);
    }

    @Override
    public DVD removeDvd(String title)
            throws DVDLibraryDaoException {
        loadDvd();
        DVD removedDvd = dvds.remove(title);
        writeDvd();
        return removedDvd;
    }

    @Override
    public List<DVD> searchDvd(String keyword)
            throws DVDLibraryDaoException {
        this.loadDvd();

        ArrayList<DVD> dvdList = new ArrayList<>(dvds.values());
        ArrayList<DVD> matchingDVDs = new ArrayList<>();

        for (DVD dvd : dvdList) {
            String dvdTitle = dvd.getTitle();
            if (dvdTitle.contains(keyword)) {
                matchingDVDs.add(dvd);
            }
        }
        return matchingDVDs;
    }

    private void loadDvd() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load DVD data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVD currentDvd = new DVD(currentTokens[0]);

            currentDvd.setTitle(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setDirectorsName(currentTokens[2]);
            currentDvd.setMpaaRating(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);
            currentDvd.setUserComment(currentTokens[6]);

            dvds.put(currentDvd.getTitle(), currentDvd);

        }
        scanner.close();
    }

    private void writeDvd() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save student data.", e);
        }

        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {

            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserRating() + DELIMITER
                    + currentDvd.getUserComment());

            out.flush();
        }
        out.close();
    }

}
