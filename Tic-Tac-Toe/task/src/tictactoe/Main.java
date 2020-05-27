package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static char win;
    static int keepNumberX = 0;
    static int keepNumberO = 0;
    static int keepNumberSpace = 0;
    static int count = 1;

    public static void main(String[] args) {

        boolean loop = true;
        char player;

        List<String> readXO = new ArrayList<>(9);
        String checkChar = "          ";

        Scanner input = new Scanner(System.in);

        char[] check = checkChar.toCharArray();




        System.out.println(checkChar);

        print_Output(checkChar); // printing out

        List<String> receive = coordinate();



        do {

            if (count % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }

            System.out.print("Enter the coordinates: ");
            String change = input.nextLine();

            if (receive.contains(change)) {
                changeCordinate(receive, check, change, player);

                count++;

            } else if (change.length() != 3) {
                System.out.println("You should enter numbers!");
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            readXO.add(String.valueOf(player));

            if(win == player){
                loop = false;
            }
        } while (loop);
        print_Output(String.valueOf(check));
        System.out.println(win + " wins");
    }


    static public void changeCordinate(List<String> receive, char[] check, String change, char player) {
        String convert;

        for (int i = 0; i < receive.size(); i++) {

            if (change.equals(receive.get(i))) {

                convert = String.valueOf(check[i]);

                if ((convert.equals("X") || convert.equals("O"))) {
                    System.out.println("This cell is occupied! Choose another one!");
                    count = count - 1;
                } else
                    check[i] = player;
                print_Output(String.valueOf(check));
                condition_win(check);
            }


        }

    }























    /*
    @
    @
    @ Parameter String readXO{}
    @ checking for win condition
    @
    @
     */


    //Checking Win Condition
    static public void condition_win(char[] select) {

            if (select[0] == select[1] && select[1] == select[2]) {
                win = select[1];
            } else if (select[3] == select[4] && select[4] == select[5]) {
                win = select[3];
            } else if (select[6] == select[7] && select[7] == select[8]) {
                win = select[6];
            } else if (select[0] == select[4] && select[4] == select[8]) {
                win = select[0];
            } else if (select[2] == select[4] && select[4] == select[6]) {
                win = select[2];
            } else if (select[2] == select[5] && select[5] == select[8]) {
                win = select[2];
            } else if (select[1] == select[4] && select[4] == select[7]) {
                win = select[1];
            } else if (select[0] == select[3] && select[3] == select[6]) {
                win = select[0];
            }

    }


    //making 3 D coordinate
    public static List<String> coordinate() {

        List<String> changeInput = new ArrayList<>(9);

        for (int i = 3; i >= 1; i--) {
            for (int j = 1; j <= 3; j++) {
                changeInput.add(j + " " + i);
            }

        }

        return changeInput;

    }

    //counting X and O
    static public void countXO(String readXO) {
        char[] check = readXO.toCharArray();
        for (int i = 0; i < readXO.length(); i++) {
            String count = String.valueOf(check[i]);
            if (count.equals("X")) {
                keepNumberX++;
            }
            if (count.equals("O")) {
                keepNumberO++;
            }
            if (count.equals("_")) {
                keepNumberSpace++;
            }
        }


    }


    //Printing output
    static private void print_Output(String readXO) {

        char[] select = readXO.toCharArray();
        System.out.println("---------");
        System.out.println('|' + " " + select[0] + " " + select[1] + " " + select[2] + " " + '|');
        System.out.println('|' + " " + select[3] + " " + select[4] + " " + select[5] + " " + '|');
        System.out.println('|' + " " + select[6] + " " + select[7] + " " + select[8] + " " + '|');
        System.out.println("---------");


    }
}


