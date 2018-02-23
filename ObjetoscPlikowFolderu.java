/*
* autor: Marlena Ślazyk
* grupa dziekańska: KrDZIs2015
* nr albumu: 201647
* zadanie 140
* kompilacja: javac ObjetoscPlikowFolderu.java
* data wykonania: 27.12.2017
* 
* opis: program podaje w MB lub kB w zależności od wielkości folderu lub pliku rozmiar
* 		aby uruchomić program należy go najpierw skompilować, a podczas uruchamiania programu wpisać ścieżkę np.
* 		java ObjetoscPlikowFolderu c:\temp		należy pamiętać o poprawności skierowanego slasha
* uruchomienie: java ObjetoscPlikowFolderu (tutaj należy wpisać ścieżkę)
*/


import java.io.*; //importujemy potrzebne biblioteki
 
 
public class ObjetoscPlikowFolderu {
 
	public static void main (String[] args) {
		
		//ustawiamy możliwość pobrania ścieżki folderu
		File plik = new File(args[0]);
		long rozmiar = 0;
		rozmiar = wezRozmiarPlikuLubFolderu(plik);
		
		//przeliczanie ilości bajtów na megabajty bądź kilobajty
		double sizeMB = (double) rozmiar / 1024 / 1024;
		String s = " MB";
		if (sizeMB < 1) {
			sizeMB = (double) rozmiar / 1024;
			s = " kB";
		}
		System.out.println(plik.getName() + " : " + sizeMB + s);
	}
 
	public static long wezRozmiarPlikuLubFolderu(File dir) {
		
		//tworzymy metodę która przy pomocy ścieżki znajdzie plik lub folder, którego rozmiar ma pobrać
		long rozmiar = 0;
		if (dir.isDirectory()) {
			for (File plik : dir.listFiles()) {
				if (plik.isFile()) {
					rozmiar += plik.length();
				} else
					rozmiar += wezRozmiarPlikuLubFolderu(plik);
			}
		} else if (dir.isFile()) {
			rozmiar += dir.length();
		}
		return rozmiar;
	}
}