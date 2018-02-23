/*
* autor: Marlena Ślazyk
* album: 201647
* numer grupy: KrDZIs2015
* uruchomienie programu: javac LiczbyZespolone.java
*						 java LiczbyZespolone
*
* opis: program ma za zadanie przeprowadzić podstawowe działania na liczbach zespolonych.
*/

import java.util.Objects;

public class LiczbyZespolone {
    private final double re;   // część rzeczywista
    private final double im;   // część urojona

    // tworzymy obiekt z częścią rzeczywistą i urojoną liczby
    public LiczbyZespolone(double rzeczywista, double urojona) {
        re = rzeczywista;
        im = urojona;
    }

    // zwraca obiekt jako ciąg znaków
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // obliczanie wartości bezwzględnej
    public double abs() {
        return Math.hypot(re, im);
    }

    // zwraca liczbę zespoloną po dodaniu drugiej liczby
    public LiczbyZespolone plus(LiczbyZespolone b) {
        LiczbyZespolone a = this;             // invoking object
        double rzeczywista = a.re + b.re;
        double urojona = a.im + b.im;
        return new LiczbyZespolone(rzeczywista, urojona);
    }

    // zwraca liczbę zespoloną po odjęciu drugiej liczby
    public LiczbyZespolone minus(LiczbyZespolone b) {
        LiczbyZespolone a = this;
        double rzeczywista = a.re - b.re;
        double urojona = a.im - b.im;
        return new LiczbyZespolone(rzeczywista, urojona);
    }

    // zwraca wynik mnożenia dwóch liczb
    public LiczbyZespolone times(LiczbyZespolone b) {
        LiczbyZespolone a = this;
        double rzeczywista = a.re * b.re - a.im * b.im;
        double urojona = a.re * b.im + a.im * b.re;
        return new LiczbyZespolone(rzeczywista, urojona);
    }


    // zwraca wartość sprzężoną liczby zespolonej
    public LiczbyZespolone conjugate() {
        return new LiczbyZespolone(re, -im);
    }

    // zwraca wartość odwrotną liczby zespolonej
    public LiczbyZespolone reciprocal() {
        double scale = re*re + im*im;
        return new LiczbyZespolone(re / scale, -im / scale);
    }

    // zwraca część rzeczywistą lub urojoną
    public double re() { return re; }
    public double im() { return im; }

    // zwraca wynik dzielenia a/b
    public LiczbyZespolone divides(LiczbyZespolone b) {
        LiczbyZespolone a = this;
        return a.times(b.reciprocal());
    }

    // wersja static dodawania
    public static LiczbyZespolone plus(LiczbyZespolone a, LiczbyZespolone b) {
        double rzeczywista = a.re + b.re;
        double urojona = a.im + b.im;
        LiczbyZespolone sum = new LiczbyZespolone(rzeczywista, urojona);
        return sum;
    }


    // sztywne wartości do przetestowania kodu
    public static void main(String[] args) {
        LiczbyZespolone a = new LiczbyZespolone(14.5, 2.1);
        LiczbyZespolone b = new LiczbyZespolone(8.0, -2.5);
		
		
        System.out.println("a            = " + a);             //wartość liczby a
        System.out.println("b            = " + b);			   //wartość liczby b
        System.out.println("Re(a)        = " + a.re());		   //wartość rzeczywista liczby a
        System.out.println("Im(a)        = " + a.im());		   //wartość urojona liczby a
        System.out.println("b + a        = " + b.plus(a));	   //suma liczb a i b
        System.out.println("a - b        = " + a.minus(b));	   //różnica liczb a i b
        System.out.println("a * b        = " + a.times(b));	   //iloczyn liczb a i b
        System.out.println("a / b        = " + a.divides(b));  //iloraz liczb a i b
        System.out.println("|a|          = " + a.abs());	   //wartość bezwzględna liczby a
    }

}