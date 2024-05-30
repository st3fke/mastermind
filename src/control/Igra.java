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
    public int pokusaj;
    public int[] pogodjeno;
    public Igra()
    {
        user = "";
        Random r = new Random();
        rnd = r.nextInt(1000, 10000);
        pokusaj = 0;
        int[] pogodjeno2 = {0, 0};
        pogodjeno = pogodjeno2;
    }
    public void test()
    {
       System.out.println(rnd);
       int temp = rnd;
       int pok = pokusaj;
       while(temp != 0)
       {
           if(temp % 10 == pok % 10)
           {
               pogodjeno[0]++;
               break;
           }
           else
           {
               int temp2 = temp;
               while(temp2 != 0)
               {
                   if(temp2 % 10 == pok % 10)
                    {
                        pogodjeno[1]++;
                        break;
                    }
                   temp2 /= 10;
               }
           }
           pok /= 10;
           temp /= 10;
       }
    }
}
