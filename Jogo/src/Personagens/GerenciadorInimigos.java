package Personagens;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import Armamento.Arma;

public class GerenciadorInimigos {
    private Random random = new Random();

    public Adversario selecionarAdversarioPrimeiroCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>();

        switch (caminhoEscolhido) {
            case 1:
                Adversario Enderman = new Adversario("Enderman", 40, 6, 4, 8, 5);
                Enderman.equiparArma(new Arma("Dano", 10, "leve"));
                adversarios.add(Enderman);

                Adversario Whiter = new Adversario("Whiter", 60, 8, 5, 7, 6);
                Whiter.equiparArma(new Arma("Cabeças explosivas", 12, "leve"));
                adversarios.add(Whiter);

                Adversario Warden = new Adversario("Warden", 80, 10, 6, 5, 4);
                Warden.equiparArma(new Arma("Ataque sônico", 14, "pesada"));
                adversarios.add(Warden);
                break;

            case 2:
                Adversario elfodeGelo = new Adversario("Elfo de gelo", 80, 12, 10, 4, 3);
                elfodeGelo.equiparArma(new Arma("Arco e felha congelantes", 14, "pesada"));
                adversarios.add(elfodeGelo);

                Adversario elementalGelo = new Adversario("Elemental de Gelo", 60, 8, 6, 7, 4);
                elementalGelo.equiparArma(new Arma("Lança de Gelo", 13, "leve"));
                adversarios.add(elementalGelo);

                Adversario trollGelo = new Adversario("Troll de Gelo", 70, 11, 9, 5, 4);
                trollGelo.equiparArma(new Arma("Bola de neve", 15, "pesada"));
                adversarios.add(trollGelo);
                break;

            case 3:
                Adversario escorpiaoGigante = new Adversario("Escorpião Gigante", 50, 10, 7, 8, 6);
                escorpiaoGigante.equiparArma(new Arma("Ferrão Mortal", 12, "leve"));
                adversarios.add(escorpiaoGigante);

                Adversario Blaze = new Adversario("Blaze", 70, 10, 5, 7, 5);
                Blaze.equiparArma(new Arma("Tornado de Areia e Fogo", 14, "leve"));
                adversarios.add(Blaze);

                Adversario serpenteAreia = new Adversario("Serpente de Areia", 65, 9, 6, 7, 6);
                serpenteAreia.equiparArma(new Arma("Bote Letal", 13, "leve"));
                adversarios.add(serpenteAreia);
                break;

            default:
                Adversario EndermanPadrao = new Adversario("Enderman", 40, 6, 4, 8, 5);
                EndermanPadrao.equiparArma(new Arma("Dano", 10, "leve"));
                adversarios.add(EndermanPadrao);
        }

        int index = random.nextInt(adversarios.size());
        return adversarios.get(index);
    }

    public Adversario selecionarAdversarioSegundoCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>();

        switch (caminhoEscolhido) {
            case 1:
                Adversario corvosdeOdin = new Adversario("Corvos de Odin (Hugin e Munin)", 50, 9, 5, 8, 6);
                corvosdeOdin.equiparArma(new Arma("Bicos afiados", 11, "leve"));
                adversarios.add(corvosdeOdin);

                Adversario dragaodoender = new Adversario("Dragão do Ender", 70, 10, 7, 5, 4);
                dragaodoender.equiparArma(new Arma("Cajado Sombrio", 12, "pesada"));
                adversarios.add(dragaodoender);
                break;

            case 2:
                Adversario golemGelo = new Adversario("Golem de Gelo", 90, 14, 12, 3, 2);
                golemGelo.equiparArma(new Arma("Socos congelantes", 15, "pesada"));
                adversarios.add(golemGelo);

                Adversario dragaoGelo = new Adversario("Dragão de Gelo Jovem", 85, 15, 9, 8, 7);
                dragaoGelo.equiparArma(new Arma("Chamas Frias", 16, "leve"));
                adversarios.add(dragaoGelo);
                break;

            case 3:
                Adversario anubis = new Adversario("Anúbis", 60, 11, 8, 5, 4);
                anubis.equiparArma(new Arma("Penitência", 11, "leve"));
                adversarios.add(anubis);

                Adversario rá = new Adversario("Rá (Deus do Sol)", 90, 16, 10, 6, 5);
                rá.equiparArma(new Arma("Cetro do Sol", 14, "pesada"));
                adversarios.add(rá);
                break;

            default:
                Adversario corvosdeOdinPadrao = new Adversario("Corvos de Odin (Hugin e Munin)", 50, 9, 5, 8, 6);
                corvosdeOdinPadrao.equiparArma(new Arma("Bico Mortal", 11, "leve"));
                adversarios.add(corvosdeOdinPadrao);
        }

        int index = random.nextInt(adversarios.size());
        return adversarios.get(index);
    }

    public Adversario criarInimigoFinal(int caminhoEscolhido) {
        switch (caminhoEscolhido) {
            case 1:
                Adversario monarcaSombras = new Adversario("Monarca das Sombras", 200, 15, 15, 10, 8);
                monarcaSombras.equiparArma(new Arma("Espada das Trevas", 10, "pesada"));
                return monarcaSombras;

            case 2:
                Adversario monarcaGelo = new Adversario("Monarca do Gelo", 210, 27, 17, 8, 7);
                monarcaGelo.equiparArma(new Arma("Machado Congelante", 22, "pesada"));
                return monarcaGelo;

            case 3:
                Adversario monarcaAreia = new Adversario("Monarca de Areia", 220, 28, 16, 9, 8);
                monarcaAreia.equiparArma(new Arma("Tempestade de Areia", 23, "pesada"));
                return monarcaAreia;

            default:
                Adversario monarcaSombrasPadrao = new Adversario("Monarca das Sombras", 200, 25, 15, 10, 8);
                monarcaSombrasPadrao.equiparArma(new Arma("Espada das Trevas", 20, "pesada"));
                return monarcaSombrasPadrao;
        }    
    }
}
