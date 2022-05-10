/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Gia Naicker
 */
public class CheckValidation {

    public CheckValidation() {
    }

    //CHECKS IF THE NUMBER CONTAINS ANY CHARACTERS
    public boolean checkDigit(String id) {
        boolean checkID = true; //Does not contain letters
        char c = 'a';

        for (int i = 0; i < id.length(); i++) {
            c = id.charAt(i);

            if (!Character.isDigit(c)) { //checks if there is a character
                checkID = false;
            }
        }
        return checkID;
    }

    //CHECKS IF THE STRING CONTAINS ANY NUMBERS
    public boolean checkString(String str) {
        boolean check = true; //Does not contain letters
        char c = 'a';

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (!Character.isLetter(c)) { //checks if there is a character
                check = false;
            }
        }
        return check;
    }

    //CHECKS IF ALL THE DATA IS PRESENT
    public boolean presenceCheck(String str) {
        boolean checkPresence = true;
        if (str.isBlank()) {
            checkPresence = false;
        }
        return checkPresence;
    }

    //CHECKS IF THE ID IS EXACTLY 13 NUMBERS
    public boolean checkLength(String id) {
        boolean check = true;
        if (id.length() != 13) {
            check = false;
        }
        return check;
    }

    //CHECKS IF AGE AND GRADE CORRESPOND
    public boolean ageGradeLogicCheck(LocalDate dob, int grade) {
        if (dob == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - dob.getYear();

        boolean check = false;
        if (age >= (grade + 4) && age <= (grade + 7)) {
            check = true;
        }
        return check;
    }

    //CHECKS IF ID AND DOB CORRESPOND
    public boolean checkIDandDOB(String id, LocalDate dob) {
        if (dob == null) {
            return false;
        }

        String month = id.substring(2, 4);
        String date = id.substring(4, 6);
        String year = id.substring(0, 2);

        if (Integer.parseInt(year) <= 50) {
            year = "20" + id.substring(0, 2);
        } else {
            year = "19" + id.substring(0, 2);
        }

        String strDate = date + "-" + month + "-" + year;
        System.out.println(strDate);
        //formats the datePicker value
        String strDOB = dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean check = false;

        if (strDate.equals(strDOB)) {
            check = true;
        }
        return check;
    }
}
