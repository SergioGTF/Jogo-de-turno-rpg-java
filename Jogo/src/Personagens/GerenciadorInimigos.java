package Personagens;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorInimigos {
    private Random random = new Random();

    public Adversario selecionarAdversarioPrimeiroCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>();
        
        switch (caminhoEscolhido) {
            case 1: 
                adversarios.add(new Adversario("Lobo Sombrio", 40, 6, 4, 8, 5));
                adversarios.add(new Adversario("Aranha Gigante", 60, 8, 5, 7, 6));
                adversarios.add(new Adversario("Druida Corrompido", 80, 10, 6, 5, 4));
                break;
                
            case 2: 
                adversarios.add(new Adversario("Yeti", 80, 12, 10, 4, 3));
                adversarios.add(new Adversario("Elemental de Gelo", 60, 8, 6, 7, 4));
                adversarios.add(new Adversario("Troll da Montanha", 70, 11, 9, 5, 4));
                break;

            case 3: 
                adversarios.add(new Adversario("Escorpião Gigante", 50, 10, 7, 8, 6));
                adversarios.add(new Adversario("Elemental de Fogo", 70, 10, 5, 7, 5));
                adversarios.add(new Adversario("Serpente de Areia", 65, 9, 6, 7, 6));
                break;

            default:
                System.out.println("Caminho inválido, retornando para a Floresta Sombria.");
                adversarios.add(new Adversario("Lobo Sombrio", 40, 6, 4, 8, 5));
                adversarios.add(new Adversario("Aranha Gigante", 60, 8, 5, 7, 6));
                adversarios.add(new Adversario("Druida Corrompido", 80, 10, 6, 5, 4));
        }

        int index = random.nextInt(adversarios.size());
        return adversarios.get(index);
    }

    public Adversario selecionarAdversarioSegundoCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>();
        
        switch (caminhoEscolhido) {
            case 1: 
                adversarios.add(new Adversario("Corvo Negro", 50, 9, 5, 8, 6));
                adversarios.add(new Adversario("Entidade Corrompida", 70, 10, 7, 5, 4));
                break;

            case 2: 
                adversarios.add(new Adversario("Golem de Gelo", 90, 14, 12, 3, 2));
                adversarios.add(new Adversario("Dragão Branco Jovem", 85, 15, 9, 8, 7));
                break;

            case 3: 
                adversarios.add(new Adversario("Múmia", 60, 11, 8, 5, 4));
                adversarios.add(new Adversario("Faraó Renascido", 90, 16, 10, 6, 5));
                break;

            default:
                System.out.println("Caminho inválido, retornando para a Floresta Sombria.");
                adversarios.add(new Adversario("Corvo Negro", 50, 9, 5, 8, 6));
                adversarios.add(new Adversario("Ent Corrompido", 70, 10, 7, 5, 4));
        }

        int index = random.nextInt(adversarios.size());
        return adversarios.get(index);
    }

    public Adversario criarInimigoFinal(int caminhoEscolhido) {
        switch (caminhoEscolhido) {
            case 1: 
                return new Adversario("Demônio das Sombras", 200, 25, 15, 10, 8);

            case 2: 
                return new Adversario("Demônio de Gelo", 210, 27, 17, 8, 7);

            case 3: 
                return new Adversario("Demônio das Areias", 220, 28, 16, 9, 8);

            default:
                System.out.println("Caminho inválido, retornando para o Demônio das Sombras.");
                return new Adversario("Demônio das Sombras", 200, 25, 15, 10, 8);
        }
    }
}
