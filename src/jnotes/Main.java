package jnotes;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static void printBanner() {
        String banner = "    _ _   _       _                \n" +
                        "   (_) \\ | | ___ | |_ ___  ___    \n" +
                        "   | |  \\| |/ _ \\| __/ _ \\/ __| \n" +
                        "   | | |\\  | (_) | ||  __/\\__ \\ \n" +
                        "  _/ |_| \\_|\\___/ \\__\\___||___/\n" +
                        " |__/      Coded by @jihedkdiss";
        System.out.println(banner);
        System.out.println();
    }

    private static void printOptions() {
        System.out.println("  1. Add Note");
        System.out.println("  2. Remove Note");
        System.out.println("  3. Edit Note");
        System.out.println("  4. Clear Notes");
        System.out.println("  5. Print Notes");
        System.out.println("  6. Close");
    }

    private static void clearScreen() throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        if (os.equals("Linux")) {
            //noinspection Since15
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } else if (os.contains("Windows")) {
            //noinspection Since15
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.println("  [ Error ] System not recognised. Leaving...");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String[] notes = new String[64];
        for (int i = 0; i < notes.length; i++) {
            notes[i] = "(empty)";
        }
        int cursor = 0;
        clearScreen();
        printBanner();
        printOptions();
        System.out.println();
        System.out.print("  >> ");
        int option = input.nextInt();
        input.nextLine();
        System.out.println();
        switch (option) {
            case 1:
                System.out.println("  [ Add Note ] Type new note...");
                System.out.println();
                System.out.print("  >> ");
                String newNote = input.nextLine();
                notes[cursor] = newNote;
                cursor++;
                System.out.println();
                System.out.println("  [i] Note added successfully!");
                break;
            case 2:
                System.out.println("  [ Remove Note ] Type note number...");
                System.out.println();
                System.out.print("  >> ");
                int noteNumber = input.nextInt();
                input.nextLine();
                notes[noteNumber - 1] = "(removed)";
                System.out.println();
                System.out.println("   [i] Note removed successfully!");
                break;
            case 3:
                System.out.println("   [ Edit Note ] Type note number...");
                System.out.println();
                System.out.print("  >> ");
                int noteNumber2 = input.nextInt();
                input.nextLine();
                System.out.println();
                System.out.println("   [ Edit Note ] Type new note...");
                System.out.println();
                System.out.print("  >> ");
                String newNote2 = input.nextLine();
                System.out.println();
                notes[noteNumber2 - 1] = newNote2;
                System.out.println("   [i] Note edited successfully!");
                break;
        }
        clearScreen();
    }
}
