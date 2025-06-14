import java.io.*;
import java.util.Scanner;

public class Config {
    public static String player1 = "Гравець1";
    public static String player2 = "Гравець2";
    public static int size = 3;

    public static void load() {
        try {
            BufferedReader r = new BufferedReader(new FileReader("config.txt"));
            player1 = r.readLine().split("=")[1];
            player2 = r.readLine().split("=")[1];
            size = Integer.parseInt(r.readLine().split("=")[1]);
            r.close();
        } catch (Exception e) {
            save();
        }
    }

    public static void save() {
        try {
            PrintWriter w = new PrintWriter("config.txt");
            w.println("p1=" + player1);
            w.println("p2=" + player2);
            w.println("size=" + size);
            w.close();
        } catch (Exception e) {}
    }

    public static void settings(Scanner sc) {
        System.out.print("Ім'я 1: ");
        player1 = sc.nextLine();
        System.out.print("Ім'я 2: ");
        player2 = sc.nextLine();
        System.out.print("Розмір (3-9): ");
        try {
            int s = Integer.parseInt(sc.nextLine());
            if (s >= 3 && s <= 9) size = s;
        } catch (Exception e) {}
        save();
    }
}
