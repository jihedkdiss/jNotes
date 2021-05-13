package jnotes;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void printBanner() {
        String banner = "    _ _   _       _                \n" +
                        "   (_) \\ | | ___ | |_ ___  ___    \n" +
                        "   | |  \\| |/ _ \\| __/ _ \\/ __| \n" +
                        "   | | |\\  | (_) | ||  __/\\__ \\ \n" +
                        "  _/ |_| \\_|\\___/ \\__\\___||___/\n" +
                        " |__/      Coded by @jihedkdiss";
        System.out.println(banner);
        System.out.println();
    }

    public static void printOptions() {
        System.out.println("  1. Add Note");
        System.out.println("  2. Remove Note");
        System.out.println("  3. Edit Note");
        System.out.println("  4. Clear Notes");
        System.out.println("  5. Print Notes");
        System.out.println("  6. Close");
    }

    public static void clearScreen() throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        if (os.equals("Linux")) {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } else if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.println("  [ Error Occured ]");
            System.out.println("  System not recognised. Leaving...");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        clearScreen();
        printBanner();
        printOptions();
        System.out.println();
        System.out.print("  >> ");
        int option = input.nextInt();
        System.out.println();
        clearScreen();
    }
}
