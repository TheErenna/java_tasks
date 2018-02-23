/*
* autor: Marlena Ślazyk
* nr albumu: 201647
* grupa dziekańska: KrDZIs2015
* data wykonania: 3-5.11.2017
* kompilacja: javac KalendarzMiesieczny.java
* uruchomienie: java KalendarzMiesieczny
*
* opis programu: Program wyświetla kalendarz miesięczny na podstawie wprowadzonego numeru miesiąca i roku.
*
*/

import java.util.*; //importowanie biblioteki Scanner

public class KalendarzMiesieczny
{
    private static int dzien = 0;
    private static int k = 0;
	
		//wzór na lata przestępne, jeśli się zgadza to mamy rok przestępny, zwraca true, jeśli nie zwraca false
    public static boolean przestepny(int rok)
    {
        if(((rok % 4 == 0) && !(rok % 100 == 0)) || (rok % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

		//ustalenie, który dzień tygodnia jest pierwszym dniem miesiąca za pomocą wzoru
    public static void pierwszyDzienMiesiaca(int miesiac, int rok)
    {
        if(miesiac == 1 || miesiac == 2)
        {
            miesiac += 12;
            rok--;
        }
        k = (1 + (int)(((miesiac + 1) * 26) / 10.0) + rok + (int)(rok / 4.0) + 6 * (int)(rok / 100.0) + (int)(rok / 400.0)) % 7;
        String nazwaDnia = "";
        switch(k)
        {
            case 0: nazwaDnia = "Sobota"; break;
            case 1: nazwaDnia = "Niedziela"; break;
            case 2: nazwaDnia = "Poniedziałek"; break;
            case 3: nazwaDnia = "Wtorek"; break;
            case 4: nazwaDnia = "Środa"; break;
            case 5: nazwaDnia = "Czwartek"; break;
            default: nazwaDnia = "Piątek"; break;
        }
        
    }
	
		/*
		* zdeklarowanie za pomocą tablicy ile jest dni w danym miesiącu uwzględniając,
		* że tablice zaczynają się od 0. Puste miejsce w polu "0" dla użytkownika, 
		* który wprowadzi miesiąc "1" i oczekuje wartości "styczeń".
		* pętla zawiera warunek zmieniający liczbę dni lutego na 29 w przypadku stwierdzenia wartości "true"
		* podczas sprawdzania przestępności roku.
		*/
    public static void liczbaDniWMiesiacu(int miesiac, int rok)
    {
        int[] dni = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (miesiac == 2 && przestepny(rok)) dni[miesiac] = 29;
        dzien = dni[miesiac];
    }
	
	/*
	* zdeklarowanie za pomocą tablicy miesięcy oraz uwzględnienie pola "1" jako wartości oczekiwanej przez 
	* użytkownika "styczeń"
	*/
    public static void wyswietlKalendarz(int miesiac, int rok)
    {
        String[] miesiacNazwa = {"","Styczen","Luty","Marzec","Kwiecien","Maj","Czerwiec","Lipiec","Sierpien","Wrzesien","Pazdziernik","Listopad","Grudzien"};
		
		//wyświetlenie jak we wzorze pustych miejsc po bokach nazwy miesiąca i wyświetlenie wybranego roku
        System.out.println("    " + miesiacNazwa[miesiac] + " " + rok);
		//wyświetlenie dni tygodnia jako nagłówków
        System.out.println("Nd Pn Wt Sr Cz Pt So");
		//wyznaczenie pierwszego dnia w miesiącu danego roku
        int z = 0;
        z = k == 0 ? 7 : k;
		for (int i = z; i > 1; i--)
		System.out.print("   ");
        for (int i = 1; i <= dzien; i++) {
            System.out.printf("%2d ", i);
            if (((i + k - 1) % 7 == 0) || (i == dzien))
                System.out.println();
        }
	}
	
	//pobranie wartości, które użytkownik wprowadził i sprawdzenie, czy są poprawne
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Wprowadz miesiac (1-12): ");
        int miesiac = input.nextInt();
        if(miesiac < 1 || miesiac > 12)
        {
            System.out.println("Niewlasciwy miesiac. Wartosci miesiaca sa w przedziale 1-12.");
            System.exit(0);
        }
        System.out.print("Wprowadz rok: ");
        int rok = input.nextInt();
        System.out.println("\n");
		
		//wyświetlenie kalendarza miesięcznego
        pierwszyDzienMiesiaca(miesiac, rok);
        liczbaDniWMiesiacu(miesiac, rok);
        wyswietlKalendarz(miesiac, rok);
    }    
}