/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2018.UI;

import com.sg.dvdlibrary2018.Dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jamesbond
 */
public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuSelection() {

        io.print("\tWelcome to your DVD library!\n");
        io.print("\tTodays Date: ");
        io.print("1) List your entire DVD collection.");
        io.print("2) Search for a DVD.");
        io.print("3) Add a DVD to your collection.");
        io.print("4) View a DVD from your collection.");
        io.print("5) Edit DVD information.");
        io.print("6) Remove a DVD from your collection.");
        io.print("7) Quit.");

        return io.readInt("\n\tPick an opiton from above.", 1, 7);
    }

    public DVD getNewDvdInfo() {
        String title = io.readString("What is the title of your DVD?");
        String releaseDate = io.readString("What is the DVD release date?");
        String mpaaRating = io.readString("What is the MPAA rating?");
        String directorsName = io.readString("What is the directors name?");
        String studio = io.readString("What studio is the DVD affiliated with?");
        String userRating = io.readString("What was your rating of the DVD?");
        String userComment = io.readString("Additional Comment:");

        DVD currentDvd = new DVD(title);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        currentDvd.setUserComment(userComment);
        return currentDvd;
    }
//-------------------

    public void displayAddDvdBanner() {
        io.print("=== Add Dvd ===\n");
    }

    public void displayAddSuccessBanner() {
        io.readString("Your DVD has been successfully created.\n"
                + "\tPlease hit enter to continue");
    }
//-------------------

    public void displayAllDvds() {
        io.print("=== Display All DVDs ===\n");
    }

    public void displayAllDvdList(List<DVD> dvds) {

        for (DVD currentDvd : dvds) {
            io.print(currentDvd.getTitle() + ": "
                    + currentDvd.getDirectorsName() + ", "
                    + currentDvd.getReleaseDate());
        }
        io.readString("\nPlease hit enter to continue.");
    }
//-------------------

    public void displayDvdBanner() {
        io.print("=== Display DVD ===\n");
    }

    public String getDvdChoice() {
        return io.readString("What is the title of the movie?\n");
    }

    public void displayDvd(DVD title) {

        if (title != null) {
            io.print(title.getTitle());
            io.print(title.getReleaseDate());
            io.print(title.getMpaaRating());
            io.print(title.getUserRating());
            io.print(title.getDirectorsName());
            io.print(title.getStudio());
            io.print(title.getUserComment());
            io.print("");

        }

        io.print("Hit enter to continue");
    }
//-------------------

    public void displayRemovedBanner() {
        io.print("=== Remove DVD ===\n");
    }

    public void displayRemovedSuccess() {
        io.print("DVD successfully removed");
    }
//--------------------

    public void displayEditInformation() {
        io.print("=== Edit DVD Information ===");
    }

    public String displayEditChoice() {
        return io.readString("Please provide the followint information\n"
                + "Title of movie:");
    }

    public DVD EditDvdInfo() {

        String title = io.readString("Provide the new title");
        String releaseDate = io.readString("What is the DVD release date?");
        String mpaaRating = io.readString("What is the MPAA rating?");
        String directorsName = io.readString("What is the directors name?");
        String studio = io.readString("What studio is the DVD affiliated with?");
        String userRating = io.readString("What was your rating of the DVD?");
        String userComment = io.readString("Additional Comment:");

        DVD currentDvd = new DVD(title);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        currentDvd.setUserComment(userComment);

        return currentDvd;
    }

    public void displayEditSuccess() {
        io.print("You have successfully edited your DVD");
    }

//--------------------
    public void displayExitBanner() {
        io.print("Good Bye!");
    }

    public void displayUnknownBanner() {
        io.print("Command Unknown");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===\n");
        io.print(errorMsg);
    }
    
//--------------------
    
    public void displaySearchDvd(){
        io.print("=== Search for a DVD===");
    }
    
    public void displaySearchDvdSuccess(){
        io.print("\nSearch success!");
    }

}
