import Menu.Menu;
import java.util.Scanner;

public class Jogo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
        System.out.println();
    }
}

