package Personagens;

// Importação de classes necessárias para a geração de números aleatórios, listas e armamentos
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import Armamento.Arma;

// Classe responsável por gerenciar os inimigos no jogo
public class GerenciadorInimigos {
    // Instância da classe Random para gerar números aleatórios
    private Random random = new Random();

    // Método para selecionar um adversário para o primeiro combate com base no
    // caminho escolhido
    public Adversario selecionarAdversarioPrimeiroCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>(); // Lista para armazenar os adversários

        // Estrutura switch para determinar quais adversários criar com base no caminho
        // escolhido
        switch (caminhoEscolhido) {
            case 1:
                // Criação de adversários para o caminho 1
                Adversario Enderman = new Adversario("Enderman", 50, 6, 4, 8, 5); // Vida ajustada para 50
                Enderman.equiparArma(new Arma("Dano", 20, "leve")); // Equipando uma arma ao adversário
                adversarios.add(Enderman); // Adiciona o Enderman à lista de adversários

                Adversario Whiter = new Adversario("Whiter", 70, 8, 5, 7, 6); // Vida ajustada para 70
                Whiter.equiparArma(new Arma("Cabeças explosivas", 22, "leve")); // Equipando uma arma
                adversarios.add(Whiter); // Adiciona o Whiter à lista

                Adversario Warden = new Adversario("Warden", 80, 10, 6, 5, 4); // Warden é o "tanque"
                Warden.equiparArma(new Arma("Ataque sônico", 24, "pesada")); // Equipando arma pesada
                adversarios.add(Warden); // Adiciona o Warden à lista
                break;

            case 2:
                // Criação de adversários para o caminho 2
                Adversario elfodeGelo = new Adversario("Elfo de gelo", 80, 12, 10, 4, 3);
                elfodeGelo.equiparArma(new Arma("Arco e flecha congelantes", 18, "pesada")); // Arma pesada
                adversarios.add(elfodeGelo); // Adiciona à lista

                Adversario elementalGelo = new Adversario("Elemental de Gelo", 60, 8, 6, 7, 4);
                elementalGelo.equiparArma(new Arma("Lança de Gelo", 13, "leve"));
                adversarios.add(elementalGelo); // Adiciona à lista

                Adversario trollGelo = new Adversario("Troll de Gelo", 70, 11, 9, 5, 4);
                trollGelo.equiparArma(new Arma("Bola de neve", 17, "pesada")); // Arma pesada
                adversarios.add(trollGelo); // Adiciona à lista
                break;

            case 3:
                // Criação de adversários para o caminho 3
                Adversario escorpiaoGigante = new Adversario("Escorpião Gigante", 60, 10, 7, 8, 6); // Vida ajustada
                escorpiaoGigante.equiparArma(new Arma("Ferrão Mortal", 12, "leve"));
                adversarios.add(escorpiaoGigante); // Adiciona à lista

                Adversario Blaze = new Adversario("Blaze", 70, 10, 5, 8, 5); // Defesa aumentada
                Blaze.equiparArma(new Arma("Tornado de Areia e Fogo", 14, "leve"));
                adversarios.add(Blaze); // Adiciona à lista

                Adversario serpenteAreia = new Adversario("Serpente de Areia", 65, 9, 6, 7, 6);
                serpenteAreia.equiparArma(new Arma("Bote Letal", 13, "leve"));
                adversarios.add(serpenteAreia); // Adiciona à lista
                break;

            default:
                // Adversário padrão se nenhum caminho for escolhido
                Adversario EndermanPadrao = new Adversario("Enderman", 40, 6, 4, 8, 5);
                EndermanPadrao.equiparArma(new Arma("Dano", 10, "leve"));
                adversarios.add(EndermanPadrao); // Adiciona à lista
        }

        // Seleciona um adversário aleatório da lista
        int index = random.nextInt(adversarios.size());
        return adversarios.get(index); // Retorna o adversário selecionado
    }

    // Método para selecionar um adversário para o segundo combate, similar ao
    // primeiro
    public Adversario selecionarAdversarioSegundoCombate(int caminhoEscolhido) {
        List<Adversario> adversarios = new ArrayList<>(); // Lista para armazenar os adversários

        switch (caminhoEscolhido) {
            case 1:
                Adversario corvosdeOdin = new Adversario("Corvos de Odin (Hugin e Munin)", 50, 9, 5, 8, 6);
                corvosdeOdin.equiparArma(new Arma("Bicos afiados", 14, "leve")); // Arma leve
                adversarios.add(corvosdeOdin); // Adiciona à lista

                Adversario dragaodoender = new Adversario("Dragão do Ender", 70, 10, 7, 5, 4);
                dragaodoender.equiparArma(new Arma("Cajado Sombrio", 16, "pesada")); // Arma pesada
                adversarios.add(dragaodoender); // Adiciona à lista
                break;

            case 2:
                Adversario golemGelo = new Adversario("Golem de Gelo", 90, 14, 12, 3, 2);
                golemGelo.equiparArma(new Arma("Socos congelantes", 18, "pesada")); // Arma pesada
                adversarios.add(golemGelo); // Adiciona à lista

                Adversario dragaoGelo = new Adversario("Dragão de Gelo Jovem", 85, 15, 9, 8, 7);
                dragaoGelo.equiparArma(new Arma("Chamas Frias", 16, "leve"));
                adversarios.add(dragaoGelo); // Adiciona à lista
                break;

            case 3:
                Adversario anubis = new Adversario("Anúbis", 60, 11, 8, 7, 4); // Defesa aumentada
                anubis.equiparArma(new Arma("Penitência", 11, "leve"));
                adversarios.add(anubis); // Adiciona à lista

                Adversario rá = new Adversario("Rá (Deus do Sol)", 90, 16, 10, 6, 5);
                rá.equiparArma(new Arma("Cetro do Sol", 14, "pesada"));
                adversarios.add(rá); // Adiciona à lista
                break;

            default:
                Adversario corvosdeOdinPadrao = new Adversario("Corvos de Odin (Hugin e Munin)", 50, 9, 5, 8, 6);
                corvosdeOdinPadrao.equiparArma(new Arma("Bico Mortal", 11, "leve"));
                adversarios.add(corvosdeOdinPadrao); // Adiciona à lista
        }

        // Seleciona um adversário aleatório da lista
        int index = random.nextInt(adversarios.size());
        return adversarios.get(index); // Retorna o adversário selecionado
    }

    // Método para criar o inimigo final com base no caminho escolhido
    public Adversario criarInimigoFinal(int caminhoEscolhido) {
        switch (caminhoEscolhido) {
            case 1:
                Adversario monarcaSombras = new Adversario("Monarca das Sombras", 200, 18, 15, 10, 8); // Dano aumentado
                monarcaSombras.equiparArma(new Arma("Espada das Trevas", 10, "pesada"));
                return monarcaSombras; // Retorna o inimigo final

            case 2:
                Adversario monarcaGelo = new Adversario("Monarca do Gelo", 210, 25, 17, 8, 7); // Dano ajustado
                monarcaGelo.equiparArma(new Arma("Machado Congelante", 22, "pesada"));
                return monarcaGelo; // Retorna o inimigo final

            case 3:
                Adversario monarcaAreia = new Adversario("Monarca da Areia", 220, 30, 18, 9, 6); // Dano ajustado
                monarcaAreia.equiparArma(new Arma("Cárcere de Areia", 18, "pesada"));
                return monarcaAreia; // Retorna o inimigo final

            default:
                Adversario monarcaPadrao = new Adversario("Monarca da Areia", 100, 15, 10, 7, 5);
                monarcaPadrao.equiparArma(new Arma("Espada Comum", 10, "leve"));
                return monarcaPadrao; // Retorna o inimigo final padrão
        }
    }
}
