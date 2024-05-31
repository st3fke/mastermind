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
    public String user;
    public int rnd;
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
        int temp2 = rnd;
        int[] nadjeno = new int[4];
        int br = 0;
        int pokusaj2 = pokusaj;
        while (temp2 != 0)
        {
            if (temp2 % 10 == pokusaj2 % 10)
            {
                pogodjeno[0]++;
                nadjeno[br]++;
            }
            br++;
            pokusaj2 /= 10;
            temp2 /= 10;
        }
        int temp3 = rnd;
        int temp4 = rnd;
        int pokusaj3 = pokusaj;
        int b = 0;
        while(temp3 != 0)
        {
            b = 0;
            temp4 = rnd;
            while(temp4 != 0)
            {
                if(temp4 % 10 == pokusaj3 %10 && nadjeno[b] != 1)
                {
                    pogodjeno[1]++;
                    nadjeno[b]++;
                }
                b++;
                temp4/= 10;
            }
            temp3 /= 10;
            pokusaj3 /= 10;
            
        }
    }
}
