/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Date1 {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");

        String a = "23:00:00";
        Date date1 = s.parse(a);
        
        System.out.println(s.format(date));
        System.out.println(s.format(date1));
        
        if (s.format(date).compareToIgnoreCase(s.format(date1)) == 0) {
            System.out.println(s.format(date) + " = " + s.format(date1));
        }
        if (s.format(date).compareToIgnoreCase(s.format(date1)) > 0) {
            System.out.println(s.format(date) + " > " + s.format(date1));
        }
        if (s.format(date).compareToIgnoreCase(s.format(date1)) < 0)
        {
            System.out.println(s.format(date) + " < " + s.format(date1));
        }
    }
}
