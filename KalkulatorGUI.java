/*
* autor: Marlena Ślazyk
* grupa dziekańska: KrDZIS2015
* numer albumu: 201647
* 
* zadanie numer 175
* data utworzenia: 21.12.2017r.
* kompilacja: javac KalkulatorGUI.java
* uruchomienie programu: java KalkulatorGUI
* opis programu: prosty kalkulator wykonujący podstawowe działania arytmetyczne
* 				 przy pomocy przycisków w programie, lub wprowadzeniu własnego działania
*				 z klawiatury. program wyświetla wynik po wciśnięciu znaku '=' lub wciśnięciu klawisza Enter
*				 program może przyjąć ciąg znaków i odróżnia arytmetyczną kolejność wykonywania
*				 działań (np. mnożenie przed dodawaniem).
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;

class KalkulatorGUI extends JFrame implements ActionListener
{
	/*
	* określenie stałych, które będą użyte
	* do ustawienia parametrów okna
	*/
    private static final int SZEROKOSC_RAMKI = 220;
    private static final int WYSOKOSC_RAMKI = 230;
    private static final int RAMKA_X = 150;
    private static final int RAMKA_Y = 100;

    private JPanel panelPrzyciskow;
    private JPanel panelWejsciaWyjscia;

    private JTextField info;

    private boolean edytowalny = true;

    public KalkulatorGUI()
    {
        Container panelZawartosci = getContentPane();
        panelZawartosci.setLayout(new FlowLayout());

        panelPrzyciskow = new JPanel();
        panelPrzyciskow.setLayout(new GridLayout(5,5,5,5));
       
	   //odstępy przycisków od marginesów
        panelPrzyciskow.setBorder(new EmptyBorder(5,5,5,5));

        panelWejsciaWyjscia = new JPanel();
        panelWejsciaWyjscia.setLayout(new FlowLayout());
        
		//odstępy przycisków od marginesów
        panelWejsciaWyjscia.setBorder(new EmptyBorder(5,5,5,5));

        setTitle("KalkulatorGUI");
		
		//używamy stałych do określenia rozmiarów okna
        setSize(SZEROKOSC_RAMKI,WYSOKOSC_RAMKI);
        
		//umożliwiamy użytkownikowi na zmianę rozmiarów okna
		setResizable(true);
        setLocation(RAMKA_X,RAMKA_Y);

        info = new JTextField();
        info.setPreferredSize(new Dimension(200, 25));
        info.addActionListener(this);
        panelWejsciaWyjscia.add(info);
        panelZawartosci.add(panelWejsciaWyjscia);

        //tworzenie tablicy z nazwami przycisków kalkulatora
        String przyciski[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2","3","-","0",".","=", "+",};

        //przypisywanie przycisków do przycisków z tablicy
        for (String i : przyciski)
        {
            JButton przycisk = new JButton(i);
            przycisk.addActionListener(this);
            panelPrzyciskow.add(przycisk);
        }

        panelZawartosci.add(panelPrzyciskow);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        //pobieramy informację, który przycisk został użyty
        if (event.getSource() instanceof JButton)
        {
            JButton wcisnietyPrzycisk = (JButton) event.getSource();
            
			//jeżeli naciśniemy znak równości pojawi się wynik
            if(wcisnietyPrzycisk.getText().equals("="))
            {
                dodajWyjscie();
            }
            //jeśli nie będzie tekstu, weźmie input
            else
            {
                dodajWejscie(wcisnietyPrzycisk.getText());
            }
        }
        //źródło jest w  JTextField
        else
        {
            dodajWyjscie();
        }
    }

    public void dodajWejscie(String line)
    {
        /*
		* dodaje kolejno wciśnięte przyciski do TextField
        * nie jest możliwy do edytowania po wciśnięciu znaku równości
		*/
		
        if(edytowalny)
        {
            info.setText(info.getText()+line);
        }
		
		else
        {
            info.setText(line);
            edytowalny = true;
        }
    }
    public void dodajWyjscie()
    {
        double wyjscie = 0;

        //konwertujemy ciąg znaków na równanie za pomocą try/catch
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            info.setText(engine.eval(info.getText()).toString());
        }
        catch(ScriptException e)
        {
            info.setText("Syntax error");
        }
        edytowalny = false;
    }

    //tworzymy obiekt KalkulatorGUI i umożliwiamy mu wyświetlenie się na ekranie
    public static void main (String [] args)
    {
        KalkulatorGUI kalkulator = new KalkulatorGUI();
        kalkulator.setVisible(true);
    }
}