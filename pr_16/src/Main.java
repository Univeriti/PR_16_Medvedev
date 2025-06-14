import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Config.load();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Грати\n2. Налаштування\n3. Статистика\n4. Вихід");
            String ch = sc.nextLine();
            if (ch.equals("1")) Game.play();
            else if (ch.equals("2")) Config.settings(sc);
            else if (ch.equals("3")) Stats.show();
            else if (ch.equals("4")) break;
        }
    }
}
