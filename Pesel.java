/*
* autor: Marlena Ślazyk
* numer albumu: 201647
* numer grupy dziekańskiej: KrDZIs2015
* data wykonania: 26.10.2017
* 
* sposób kompilacji: javac Pesel.java
* uruchomienie programu: java Pesel
* opis programu: Program ma na celu weryfikację, czy podany numer PESEL jest prawidłowy
* i czy mógłby być prawidłowy na podstawie cyfry kontrolnej.
*/



import java.util.*;

public class Pesel{
	public static boolean sprawdz(String pesel){
		
			//tablica wag numeru PESEL
		int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
		
			//sprawdzenie, czy długość numeru PESEL jest prawidłowa
		if (pesel.length() != 11) return false;
		
			//sprawdzenie, czy we wprowadzonym numerze PESEL są same cyfry
		if (pesel.matches("[0-9]")) return true;
			
			//zmienna badająca cyfrę kontrolną
		int suma = 0;
		
			//odpowiednie przemnożenie w pętli cyfry PESEL z odpowiednią wagą
		for (int i = 0; i < 10; i++)
			suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i]; 
		
			//pobranie do zmiennej wartość ostatniej cyfry z numeru PESEL
		int kontrolna = Integer.parseInt(pesel.substring(10, 11));
		
			//obliczanie cyfry kontrolnej z sumy
		suma %= 10;
		suma = 10 - suma;
		suma %= 10;
		
			//zwrócenie wartości logicznej
		return (suma == kontrolna);
	}
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	
		//pobranie od użytkownika numeru PESEL
	System.out.print ("Podaj numer PESEL: " );
	
		//wyświetlenie na ekranie informacji o poprawności cyfry kontrolnej
	String pesel = sc.nextLine();
	System.out.println("Twoj PESEL jest " + ((sprawdz(pesel)) ? "poprawny." : "niepoprawny"));
	}
}