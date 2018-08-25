/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018.Dao;

import com.sg.dvdlibrary2018.Dto.DVD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jamesbond
 */
public class DVDLibraryDaoTest {

    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

    public DVDLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddDVD() throws Exception {
        
      DVD dvd = new DVD("Titanico");
        dvd.setTitle("Titan");
        dvd.setReleaseDate("1812");
        dvd.setDirectorsName("Matt Beard");
        dvd.setUserRating("R");
        dvd.setStudio("Cali");
        dvd.setUserRating("5/5");
        dvd.setUserComment("N/A");
        
        dao.addDVD(dvd.getTitle(), dvd);

        DVD fromDao = dao.getDvd(dvd.getTitle());

        assertEquals(dvd, fromDao);

    }



    /**
     * Test of getAllDvds method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {

        DVD dvd = new DVD("");
        dvd.getTitle();

    }

    /**
     * Test of getDvd method, of class DVDLibraryDao.
     */
    @Test
    public void testGetDvd() throws Exception {

  

    }
    



    /**
     * Test of removeDvd method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
    }

    /**
     * Test of searchDvd method, of class DVDLibraryDao.
     */
    @Test
    public void testSearchDvd() throws Exception {

    }

}
