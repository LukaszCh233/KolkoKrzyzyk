package Aplikacja;

import java.util.Scanner;

public class KolkoKrzyzyk {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("WITAJ W GRZE");
            System.out.println("Podaj rozmiar planszy");

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            char[][] plansza = new char[a][b];



            KolkoKrzyzyk.drukujPlansze(plansza);


            char obecnySymbol = getObecnySymbol();


            while (true) {
                boolean ruchPopr = wykRuch(plansza, obecnySymbol);
                KolkoKrzyzyk.drukujPlansze(plansza);
                if (ruchPopr) {
                    boolean wygranaWiersze = sprawdzWiersz(plansza, obecnySymbol);
                    boolean wygranaKolumn = sprawdzKolumny(plansza, obecnySymbol);
                    boolean wygranaSkos = sprawdzSkos(plansza, obecnySymbol);


                    if (wygranaKolumn || wygranaWiersze || wygranaSkos) {
                        System.out.println("Gratulacje wygral gracz: " + obecnySymbol);
                        break;
                    }
                     else if (!saRuchy(plansza)) {
                        System.out.println("Jest remis");
                        break;
                    }
                    obecnySymbol = ObecnySymbol(obecnySymbol);
                }
            }
        }

    public static char getObecnySymbol() {

        return '1';
    }
    public static char getObecnySymbol1() {

        return '2';
    }


    public static char ObecnySymbol(char obecnySymbol) {
        if (obecnySymbol == getObecnySymbol()) {
            obecnySymbol = getObecnySymbol1();
        } else obecnySymbol = getObecnySymbol();
        return obecnySymbol;
    }

    public static boolean saRuchy ( char[][] plansza) {
            for (int i = 0; i < plansza.length; i++){
                for (int j = 0; j < plansza.length; j++){
                    if (plansza[i][j] != getObecnySymbol() && plansza[i][j] != getObecnySymbol1()) {
                        return true;
                    }
                }
            }
            return false;
        }
        public  static  boolean sprawdzKolumny (char[][] plansza, char symbol) {
            for (int kolumna = 0; kolumna < plansza.length; kolumna++) {
                boolean wygrana = true;
                for (int wiersz = 0; wiersz < plansza.length; wiersz++) {
                    if (plansza[wiersz][kolumna] != symbol) {
                        wygrana = false;
                        break;
                    }
                }
                if (wygrana) { return true; }
            }
            return false;
        }
        public  static  boolean sprawdzWiersz (char[][] plansza, char symbol) {
            for (int wiersz = 0; wiersz < plansza.length; wiersz++) {
                boolean wygrana = true;
                for (int kolumna = 0; kolumna < plansza.length; kolumna++) {
                    if (plansza[wiersz][kolumna] != symbol) {
                        wygrana = false;
                        break;
                    }
                }
                if (wygrana) { return true; }
            }
            return false;
        }
        public static boolean sprawdzSkos(char[][] plansza, char symbol) {
            for (int i = 0; i < plansza.length; i ++) {
                if (plansza[i][i] != symbol) {
                    return false;
                }
            }
            return true;
        }

        public static boolean wykRuch(char[][] plansza, char symbol) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Twoj ruch " + symbol);
            System.out.println("Podaj miejsce: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean poprawnyRuch = plansza[a][b] == 0;
            if (!poprawnyRuch ) {
                System.out.println("TO POLE JEST ZAJETE");
                System.out.println("PROBUJ DALEJ");
                return false;

            }
            plansza[a][b] = symbol;
            return true;

        }
        public static void drukujPlansze(char[][] plansza) {
            for (int e = 0; e < plansza.length; e++){
                System.out.print("\t"+ e);
            }
            System.out.println();

            for (int i = 0;  i < plansza.length; i++){
                System.out.print(i+": "+"\t");
                for (int j = 0; j < plansza[i].length; j++) {

                    System.out.print(plansza[i][j]+ "\t");

                }
                System.out.println();
            }

        }

    }