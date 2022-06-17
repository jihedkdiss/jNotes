package jnotes;

import java.io.*;
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
        System.out.println("  6. Export Notes");
        System.out.println("  7. Import Notes");
        System.out.println("  8. Close");
    }

    private static void waitForUser() throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        if (os.equals("Linux")) {
            System.out.println("      Press enter key to continue...");
            //noinspection Since15
            new ProcessBuilder("read").inheritIO().start().waitFor();
        } else if (os.contains("Windows")) {
            System.out.println();
            //noinspection Since15
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
        } else {
            System.out.println("  [ Error ] System not recognised. Leaving...");
            System.exit(1);
        }
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
        int cursor = 0;

        while (true) {
            clearScreen();
            printBanner();
            printOptions();
            System.out.println();
            System.out.print("  >> ");
            int option = input.nextInt();
            input.nextLine();
            System.out.println();
            clearScreen();
            printBanner();
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
                    waitForUser();
                    break;
                case 2:
                    System.out.println("  [ Remove Note ] Type note number...");
                    System.out.println();
                    System.out.print("  >> ");
                    int noteNumber = input.nextInt();
                    input.nextLine();
                    notes[noteNumber - 1] = null;
                    System.out.println();
                    System.out.println("  [i] Note removed successfully!");
                    waitForUser();
                    break;
                case 3:
                    System.out.println("  [ Edit Note ] Type note number...");
                    System.out.println();
                    System.out.print("  >> ");
                    int noteNumber2 = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    System.out.println("  (" + notes[noteNumber2 - 1] + ")");
                    System.out.println();
                    System.out.println("  [ Edit Note ] Type new note...");
                    System.out.println();
                    System.out.print("  >> ");
                    String newNote2 = input.nextLine();
                    System.out.println();
                    notes[noteNumber2 - 1] = newNote2;
                    System.out.println("  [i] Note edited successfully!");
                    waitForUser();
                    break;
                case 4:
                    System.out.println("  [ Clear Notes ] Clearing notes...");
                    System.out.println();
                    for (int i = 0; i < notes.length; i++) {
                        notes[i] = "(empty)";
                    }
                    cursor = 0;
                    System.out.println("  [i] Notes cleared successfully!");
                    waitForUser();
                    break;
                case 5:
                    System.out.println("  [ Print Notes ] Printing notes...");
                    System.out.println();
                    for (int i = 0; i < notes.length; i++) {
                        if (notes[i] != null) {
                            System.out.println("  " + (i + 1) + ". " + notes[i]);
                        }
                    }
                    System.out.println("  -- END --");
                    System.out.println();
                    System.out.println("  [i] Notes printed successfully!");
                    waitForUser();
                    break;
                case 6:
                    System.out.println("  [ Export Notes ] Enter the location where to save your notes...");
                    System.out.println();
                    System.out.print("  >> ");
                    String exportLocation = input.nextLine();
                    PrintStream out = new PrintStream(new FileOutputStream(exportLocation));
                    try {
                        for (int i = 0; i < notes.length; i++) {
                            if (notes[i] != null)
                                out.println(notes[i]);
                        }
                    } catch (Exception e) {
                        System.out.println("  [!] " + e);
                    }
                    System.out.println();
                    System.out.println("  [i] Notes exported successfully!");
                    waitForUser();
                    break;
                case 7:
                    System.out.println("  [ Import Notes ] Enter the location of your notes...");
                    System.out.println();
                    System.out.print("  >> ");
                    String importLocation = input.nextLine();
                    File importFile = new File(importLocation);
                    Scanner importScanner = new Scanner(importFile);
                    int line = 0;
                    while (importScanner.hasNextLine()) {
                        notes[line] = importScanner.nextLine();
                        line++;
                    }
                    System.out.println();
                    System.out.println("  [i] Notes imported successfully!");
                    waitForUser();
                    break;
                case 8:
                    clearScreen();
                    System.exit(0);
                    break;
                default:
                    clearScreen();
                    printBanner();
                    System.out.println("  [i] Unexpected choice: " + option);
                    waitForUser();
            }
            clearScreen();
        }
    }
}
