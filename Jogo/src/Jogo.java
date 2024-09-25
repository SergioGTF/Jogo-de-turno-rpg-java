import Menu.Menu; // Importa a classe Menu
import java.util.Scanner; // Importa a classe Scanner para entrada de dados

public class Jogo {
    public static Scanner scanner = new Scanner(System.in); // Cria um Scanner para ler entradas

    public static void main(String[] args) {
        Menu menu = new Menu(); // Cria um objeto Menu
        menu.exibirMenu(); // Mostra o menu do jogo
    }
}
