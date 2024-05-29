/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Random;

/**
 *
 * @author stefa
 */
public class Igra {
    String user;
    int rnd;
    int left_rounds;
    int pokusaj;
    public Igra()
    {
        user = "";
        Random r = new Random();
        rnd = r.nextInt(1000, 10000);
        left_rounds = 6;
        pokusaj = 0;
    }
}
