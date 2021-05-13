package jnotes;

public class Main {

    public static void printBanner() {
        String banner = "    _ _   _       _                \n" +
                        "   (_) \\ | | ___ | |_ ___  ___    \n" +
                        "   | |  \\| |/ _ \\| __/ _ \\/ __| \n" +
                        "   | | |\\  | (_) | ||  __/\\__ \\ \n" +
                        "  _/ |_| \\_|\\___/ \\__\\___||___/\n" +
                        " |__/      Coded by @jihedkdiss";
        System.out.println(banner);
    }

    public static void printOptions() {
        System.out.println("  1. Add Note");
        System.out.println("  2. Remove Note");
        System.out.println("  3. Edit Note");
        System.out.println("  4. Clear Notes");
        System.out.println("  5. Print Notes");
        System.out.println("  6. Close");
    }

    public static void main(String[] args) {
        printBanner();
        printOptions();
    }
}
