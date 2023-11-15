/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

/**
 *
 * @author liamy
 */
// https://stackoverflow.com/questions/925423/is-it-better-practice-to-use-string-format-over-string-concatenation-in-java
public class StringCompara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String formatString = "Hi %s; Hi to you %s";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String s = String.format(formatString, i, +i * 2);
        }

        long end = System.currentTimeMillis();
        System.out.println("Format = " + ((end - start)) + " millisecond");

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            String s = "Hi " + i + "; Hi to you " + i * 2;
        }

        end = System.currentTimeMillis();

        System.out.println("Concatenation = " + ((end - start)) + " millisecond");

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            StringBuilder bldString = new StringBuilder("Hi ");
            bldString.append(i).append("; Hi to you ").append(i * 2);
            String r = bldString.toString();
        }

        end = System.currentTimeMillis();

        System.out.println("String Builder = " + ((end - start)) + " millisecond");
    }

}
