package jnotes;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static void printBanner() {
        String banner = "\u001B[92m    _ _   _       _                \n" +
                        "   (_) \\ | | ___ | |_ ___  ___    \n" +
                        "   | |  \\| |/ _ \\| __/ _ \\/ __| \n" +
                        "   | | |\\  | (_) | ||  __/\\__ \\ \n" +
                        "  _/ |_| \\_|\\___/ \\__\\___||___/\n" +
                        " |__/      Coded by @jihedkdiss \u001B[0m";
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
        for (int i = 0; i < notes.length; i++) {
            notes[i] = "(empty)";
        }
        int cursor = 0;

        while(true) {
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
                    System.out.println("  \u001B[92m\u001B[7m[ Add Note ]\u001B[0m\u001B[0m \u001B[93mType new note...\u001B[0m");
                    System.out.println();
                    System.out.print("  >> ");
                    String newNote = input.nextLine();
                    notes[cursor] = newNote;
                    cursor++;
                    System.out.println();
                    System.out.println("  [i] Note added successfully!");
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.println("  [ Remove Note ] Type note number...");
                    System.out.println();
                    System.out.print("  >> ");
                    int noteNumber = input.nextInt();
                    input.nextLine();
                    notes[noteNumber - 1] = "(removed)";
                    System.out.println();
                    System.out.println("  [i] Note removed successfully!");
                    Thread.sleep(2000);
                    break;
                case 3:
                    System.out.println("  [ Edit Note ] Type note number...");
                    System.out.println();
                    System.out.print("  >> ");
                    int noteNumber2 = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    System.out.println("  [ Edit Note ] Type new note...");
                    System.out.println();
                    System.out.print("  >> ");
                    String newNote2 = input.nextLine();
                    System.out.println();
                    notes[noteNumber2 - 1] = newNote2;
                    System.out.println("  [i] Note edited successfully!");
                    Thread.sleep(2000);
                    break;
                case 4:
                    System.out.println("  [ Clear Notes ] Clearing notes...");
                    System.out.println();
                    for (int i = 0; i < notes.length; i++) {
                        notes[i] = "(empty)";
                    }
                    cursor = 0;
                    System.out.println("  [i] Notes cleared successfully!");
                    Thread.sleep(2000);
                    break;
                case 5:
                    System.out.println("  [ Print Notes ] Printing notes...");
                    System.out.println();
                    for (int i = 0; i < notes.length; i++) {
                        if (!notes[i].equals("(empty)")) {
                            System.out.println("  " + i + 1 + ". " + notes[i]);
                        }
                    }
                    System.out.println("  -- END --");
                    System.out.println();
                    System.out.println("  [i] Notes printed successfully!");
                    waitForUser();
                    break;
                case 6:
                    clearScreen();
                    System.exit(0);
                    break;
            }
            clearScreen();
        }
    }
}
