/*
* Autor: Marlena Ślazyk
* numer albumu: 201647
* numer grupy dziekańskiej: KrDZIS2015
*
* data wykonania: 20.10.2017
* zadanie: 34
* kompilacja: javac BMI.java
* uruchomienie: java BMI, następnie wprowadzenie swojej wagi i wzrostu zatwierdzając obie wartości enterem.
* działanie: program oblicza wartość Twojego BMI na podstawie wprowadzonej wartości wagi i wzrostu
*/

import java.util.Scanner; //umożliwi wyczytanie wartości liczbowej od system.in

public class BMI {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in); //wyczyta wprowadzone wartości liczbowe 

        double weight = 0.0;
        double height = 0.0;
        double bmi = 0.0;

        System.out.print("Podaj swoja wage w kilogramach: "); //prosi o podanie wagi
        weight = input.nextDouble(); //pozwala na wprowadzenie wartości i przypisuje ją do weight

        System.out.print("Podaj swoj wzrost w metrach: "); //prosi o podanie wzrostu
        height = input.nextDouble(); //przypisuje podaną wartość do height

        bmi = ((weight)/(height * height)); //wzór na obliczenie bmi

        System.out.println("Twoje BMI wynosi " + bmi); //wyświetla stosowny komentarz i obliczoną wartość BMI
		
		//poniższe wartości pozwolą sprawdzić użytkownikowi programu, czy jego BMI jest prawidłowe
        System.out.println("Wartosci BMI"); 
        System.out.println("Niedowaga: ponizej 18.5");
        System.out.println("BMI prawidlowe: 18.5-24.9 ");
        System.out.println("Nadwaga: 25-29.9");
        System.out.println("Otylosc: 30 lub wiecej");
     }
    }