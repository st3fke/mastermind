/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import control.Igra;

/**
 *
 * @author stefa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        view.Mastermind game = new view.Mastermind();
        game.setVisible(true);
        game.setSize(784, 582);
    }
    
}