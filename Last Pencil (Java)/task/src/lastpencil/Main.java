package lastpencil;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static boolean botTime = false;
    static String name1 = "John";
    static String bot = "Jack";

    public static void main(String[] args) {

        //System.out.println("||||||||");
        //System.out.println("Your turn!");
        int pencils = 0;
        String name = "";
        System.out.println("How many pencils would you like to use:");
        do {
            pencils = getPentilcs();

        } while (!(pencils > 0));
        System.out.println("Who will be the first (John, Jack):");
        do {
            name = getName(name1, bot);
        } while (name.isEmpty());
        checkBot(name,name1,bot);
        while (pencils > 0) {
            Scanner sc = new Scanner(System.in);
            int take;
            //System.out.println("How many pencils would you like to use:");
            printPencils(pencils);
            System.out.println(name + "'s turn!");
            if (botTime) {
                take = botTakePencils(pencils);
                System.out.println(take);
            } else {
                do {

                    take = takePencils(pencils);

                } while (take == 0);
            }
            pencils -= take;
            if (pencils > 0) {
                name = switchTurn(name, name1, bot);
                checkBot(name,name1,bot);
            }

            /*if (pencils > 0) {∂
                printPencils(pencils);
            }*/

        }
        getWinner(name, name1, bot);


        //System.out.println("|".repeat(Math.max(0, pencils)));
        //System.out.print(name + " is going first!");
    }

    public static void printPencils(int pencils) {
        for (int i = 0; i < pencils; i++) {
            System.out.print('|');
        }
        System.out.println();
    }

    public static int takePencils(int pencils) {
        Scanner sc = new Scanner(System.in);
        //int take = Integer.parseInt(sc.nextLine());

        if (sc.hasNextInt()) {
            int take = Integer.parseInt(sc.nextLine());
            if ((take < 1) || (take > 3)) {
                System.out.println("Possible values: '1', '2' or '3'");
                return 0;
            } else if (pencils - take < 0) {
                System.out.println("Too many pencils were taken");
                return 0;
            } else
                return take;

        } else {
            //System.out.println("The number of pencils should be numeric");
            System.out.println("Possible values: '1', '2' or '3'");
            return 0;
        }


    }

    public static int botTakePencils(int pencils) {
        if (pencils == 1) {
            return 1;
        } else if ((pencils - 1) % 4 == 0) {
            return (int) (Math.random() * 3 + 1);
        } else if (pencils % 4 == 0) {
            return 3;
        } else if ((pencils + 1) % 4 == 0) {
            return 2;
        } else {
            return 1;
        }
        //int take = Integer.parseInt(sc.nextLine());
    }

    public static String switchTurn(String name, String name1, String bot) {
        if (Objects.equals(name, name1)) {
            //botTime = true;
            return bot;
        } else {
            //botTime = false;
            return name1;
        }
    }
    public static void checkBot(String name, String name1, String bot) {
        if (Objects.equals(name, bot)) {
            botTime = true;
        } else {
            botTime = false;
        }
    }

    public static void getWinner(String name, String name1, String bot) {
        if (Objects.equals(name, name1)) {
            System.out.println(bot + " won!");
        } else {
            System.out.println(name1 + " won!");
        }

    }

    public static String getName(String name1, String bot) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (!(Objects.equals(name, name1) || Objects.equals(name, bot))) {
            System.out.println("Choose between '" + name1 + "' and '" + bot + "'");
            return "";
        } else {
            return name;
        }
    }

    public static int getPentilcs() {
        int pencils = 0;
        Scanner sc = new Scanner(System.in);
        //if (sc.hasNext ()) {
        //    System.out.println("The number of pencils should be numeric");
        //}
        //if (sc.hasNextInt()) {
        try {
            pencils = Integer.parseInt(sc.nextLine());
            if (pencils == 0) {
                System.out.println("The number of pencils should be positive");
            } else if (pencils < 0) {
                System.out.println("The number of pencils should be numeric");
            }
        } catch (NumberFormatException exception) {
            System.out.println("The number of pencils should be numeric");
        }
        //} else {
        //    System.out.println("The number of pencils should be numeric");
        //}
        return pencils;
    }
}
