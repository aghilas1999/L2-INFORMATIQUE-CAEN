package Logement;

import java.util.Scanner;

 public class Executable  {

    public static void main (String [] args) {
 
    House maison = new House(23 , 14070 , "Caen" , 9) ;

    float c1 = (float)0.5;
    float c2 = (float)0.7;
    float s= maison.getTaxAmount(c1,c2);

    System.out.println(s);
   }
 }