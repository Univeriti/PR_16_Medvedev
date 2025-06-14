import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stats {
    public static void save(String winner) {
        try {
            FileWriter f = new FileWriter("stats.txt", true);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            f.write("Дата: " + now.format(fmt) + ", Переміг: " + winner + ", Розмір: " + Config.size + "\n");
            f.close();
        } catch (Exception e) {}
    }

    public static void show() {
        try {
            BufferedReader r = new BufferedReader(new FileReader("stats.txt"));
            String l;
            while ((l = r.readLine()) != null) System.out.println(l);
            r.close();
        } catch (Exception e) {
            System.out.println("Немає статистики.");
        }
    }
}
