/*
* autor: Marlena Ślazyk
* nr albumu: 201647
* grupa dziekańska: KrDZIs2015
* kompilacja: javac NoweUrzadzenieMuzyczne.java
* uruchomienie: java NoweUrzadzenieMuzyczne
* opis programu: program uwzględnia nową kategorię urządzeń
* numer zadania: 124
*/

interface Wlacza {
 	public void wlacz();
 	public void wylacz();
 	public boolean czyDziala();
}
interface Odtwarza {
 	public void start();
 	public void stop();
 	public void pauza();
}
abstract class Odtwarzacz implements Wlacza, Odtwarza{
 	protected int glosnosc;
 	private boolean dziala;
 	protected String marka;

 public Odtwarzacz(String marka){
 	this.marka = marka;
 	dziala = false;
 }

 public void wlacz(){
 	dziala = true;
 }

 public void wylacz(){
 	dziala = false;
 }
 public boolean czyDziala(){
	 return dziala;
 }

 	public abstract void glosniej();
 	public abstract void ciszej();
}



class OdtwarzaczCD extends Odtwarzacz{

 public OdtwarzaczCD(String marka){
 	super(marka);
 	glosnosc = 10;
 }

 public void glosniej(){
 	glosnosc++;
 }
 public void ciszej(){
 	glosnosc--;
 }

 public void start(){
 	System.out.println ("Odtwarzacz CD odtwarza");
 }
 public void stop(){
 	System.out.println ("Odtwarzacz CD nie odtwarza");
 }
 public void pauza(){
 	System.out.println ("Odtwarzacz CD zatrzymany");
 }

 public String toString(){
 	return "Odtwarzacz CD marki: " + marka + " jest " +
	( czyDziala() ? "wlaczony" : "wylaczony") + " Glosnosc: " + glosnosc;
 }
}


class OdtwarzaczMP3 extends Odtwarzacz{
	//klasa dziedziczy z klasy Odtwarzacz
	private int pojemnosc;
	private int bateria;
	//metoda toString dla klasy odtwarzaczMP3 
	public String toString(){
	 	return "Odtwarzacz MP3 marki: " + marka + " jest " +(czyDziala() ? "wlaczony" : "wylaczony") + " Glosnosc: "
	  	+ glosnosc + ". Bateria:  " + bateria + ". Pojemnosc: " + pojemnosc;
	}
	//konstruktor
	public OdtwarzaczMP3(String marka, int bateria, int pojemnosc){
		super(marka);
		this.bateria = bateria;
		this.pojemnosc = pojemnosc;
		glosnosc = 7;
	}

	public void glosniej(){
		glosnosc++;
	}

	public void ciszej(){
		glosnosc--;
	}

	public void start(){
		System.out.println("Odtwarzacz MP3 odtwarza");
	}

	public void stop(){
		System.out.println ("Odtwarzacz MP3 nie odtwarza");
	}

	public void pauza(){
		System.out.println ("Odtwarzacz MP3 zatrzymany");
	}
}

public class NoweUrzadzenieMuzyczne{
	public static void main (String[] args){

	OdtwarzaczCD sony = new OdtwarzaczCD("Sony");
 	sony.wlacz();
 	sony.start();
 	sony.glosniej();
 	System.out.println(sony);
 	/*
 	utworzenie obiektu typu OdtwarzaczMP3 o nazwie thomson - w konstruktorze podanie
 	marki, baterii,
 	*/ 
 	OdtwarzaczMP3 thomson = new OdtwarzaczMP3("thomson", 50, 4 );
 	thomson.wlacz();
 	thomson.start();
 	thomson.glosniej();
 	System.out.println(thomson);
 	
 }
}