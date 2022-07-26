package Aplikacja;

import java.util.Scanner;

public class KolkoKrzyzyk {
    public static void main(String[] args) {
        char[][] plansza = new char[3][3];

        char krzyzyk = 'X';


        System.out.println("WITAJ W GRZE");
        KolkoKrzyzyk.drukujPlansze(plansza);

        while (true) {
            boolean ruchPopr = wykRuch(plansza, krzyzyk);
            KolkoKrzyzyk.drukujPlansze(plansza);
            if (ruchPopr) {
                if (krzyzyk == 'X') {
                    krzyzyk = 'O';
                } else krzyzyk = 'X';
                if (plansza[0][0] == 'X' && plansza[0][1] == 'X' && plansza[0][2] == 'X'
                        || plansza[1][0] == 'X' && plansza[1][1] == 'X' && plansza[1][2] == 'X'
                        || plansza[2][0] == 'X' && plansza[2][1] == 'X' && plansza[2][2] == 'X'
                        || plansza[0][0] == 'X' && plansza[1][0] == 'X' && plansza[2][0] == 'X'
                        || plansza[0][1] == 'X' && plansza[1][1] == 'X' && plansza[2][1] == 'X'
                        || plansza[0][2] == 'X' && plansza[1][2] == 'X' && plansza[2][2] == 'X'
                        || plansza[0][0] == 'X' && plansza[1][1] == 'X' && plansza[2][2] == 'X'
                        || plansza[0][2] == 'X' && plansza[1][1] == 'X' && plansza[2][0] == 'X') {
                    System.out.println("Wygral gracz X");
                break;
                }
                else if (plansza[0][0] == 'O' && plansza[0][1] == 'O' && plansza[0][2] == 'O'
                        || plansza[1][0] == 'O' && plansza[1][1] == 'O' && plansza[1][2] == 'O'
                        || plansza[2][0] == 'O' && plansza[2][1] == 'O' && plansza[2][2] == 'O'
                        || plansza[0][0] == 'O' && plansza[1][0] == 'O' && plansza[2][0] == 'O'
                        || plansza[0][1] == 'O' && plansza[1][1] == 'O' && plansza[2][1] == 'O'
                        || plansza[0][2] == 'O' && plansza[1][2] == 'O' && plansza[2][2] == 'O'
                        || plansza[0][0] == 'O' && plansza[1][1] == 'O' && plansza[2][2] == 'O'
                        || plansza[0][2] == 'O' && plansza[1][1] == 'O' && plansza[2][0] == 'O'){
                    System.out.println("Wygral gracz O");
                    break;
                }
                else {
                    System.out.println("REMIS");

                }

                }
            }
        }

    public static boolean wykRuch(char[][] plansza, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Twoj ruch " + symbol);
        System.out.println("Podaj miejsce: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        boolean poprawnyRuch = plansza[a][b] == 0;
        if (! poprawnyRuch ) {
            System.out.println("TO POLE JEST ZAJETE");
            return false;
        }
        plansza[a][b] = symbol;
        return true;
    }
    public static void drukujPlansze(char[][] plansza) {
        System.out.println("\t0\t1\t2");
        for (int i = 0;  i < plansza.length; i++){
            System.out.print(i+": "+"\t");
            for (int j = 0; j < plansza[i].length; j++) {

                System.out.print(plansza[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
