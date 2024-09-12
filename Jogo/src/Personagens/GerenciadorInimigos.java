package Personagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Armamento.Arma;

public class GerenciadorInimigos {
    private Random random = new Random();

    public List<Adversario> criarInimigosPorCaminho(int caminho) {
        List<Adversario> adversarios = new ArrayList<>();

        switch (caminho) {
            case 1:
                System.out.println("Você escolheu o caminho da Floresta Sombria.");
                adversarios = criarInimigosFloresta();
                break;
            case 2:
                System.out.println("Você escolheu o caminho das Montanhas Geladas.");
                adversarios = criarInimigosMontanha();
                break;
            case 3:
                System.out.println("Você escolheu o caminho do Deserto Ardente.");
                adversarios = criarInimigosDeserto();
                break;
            default:
                System.out.println("Escolha inválida. Você será levado para a Floresta Sombria.");
                adversarios = criarInimigosFloresta();
                break;
        }

        return adversarios;
    }

    private List<Adversario> criarInimigosFloresta() {
        List<Adversario> adversarios = new ArrayList<>();
        adversarios.add(new Adversario("Lobo Sombrio", 40, 6, 4, 8, 5));
        adversarios.add(new Adversario("Aranha Gigante", 60, 8, 5, 7, 6));
        adversarios.add(new Adversario("Druida Corrompido", 80, 10, 6, 5, 4));
        return adversarios;
    }

    private List<Adversario> criarInimigosMontanha() {
        List<Adversario> adversarios = new ArrayList<>();
        adversarios.add(new Adversario("Yeti", 80, 12, 10, 4, 3));
        adversarios.add(new Adversario("Elemental de Gelo", 60, 8, 6, 7, 4));
        adversarios.add(new Adversario("Dragão Branco", 100, 18, 12, 8, 6));
        return adversarios;
    }

    private List<Adversario> criarInimigosDeserto() {
        List<Adversario> adversarios = new ArrayList<>();
        adversarios.add(new Adversario("Escorpião Gigante", 50, 10, 7, 8, 6));
        adversarios.add(new Adversario("Elemental de Fogo", 70, 10, 5, 7, 5));
        adversarios.add(new Adversario("Faraó Renascido", 90, 16, 10, 6, 5));
        return adversarios;
    }

    public Adversario criarInimigoFinal() {
        Adversario bossFinal = new Adversario("Demônio das Sombras", 200, 25, 15, 10, 8);
        bossFinal.equiparArma(new Arma("Espada das Trevas", 20, "pesada"));
        return bossFinal;
    }
}
