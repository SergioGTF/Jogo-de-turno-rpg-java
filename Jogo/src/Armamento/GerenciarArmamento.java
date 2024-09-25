package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Personagens.Jogador;

// Classe responsável por gerenciar a escolha de armas e armaduras
public class GerenciarArmamento {
    // Scanner para entrada de dados do jogador
    private Scanner entrada = new Scanner(System.in);

    // Método para escolher uma arma, baseado no nível do jogador e em suas escolhas anteriores
    public Arma escolherArma(Jogador jogador) {
        // Lista de armas disponíveis no jogo
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Punhos de ferro", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));
        armas.add(new Arma("Espada de Netherite", 25, "Média"));
        armas.add(new Arma("Lâminas do Caos", 45, "Média"));

        // Lista de armas disponíveis para o jogador, filtradas por nível e escolhas anteriores
        List<Arma> armasDisponiveis = new ArrayList<>();
        for (Arma arma : armas) {
            if ((jogador.getNivel() >= 2 && arma.getNome().equals("Martelo de Guerra")) ||
                (jogador.getNivel() >= 3 && arma.getNome().equals("Espada de Netherite")) ||
                (jogador.getNivel() >= 3 && arma.getNome().equals("Lâminas do Caos")) ||
                (arma.getNome().equals("Punhos de ferro") || arma.getNome().equals("Adaga"))) {
                // Verifica se a arma ainda não foi usada pelo jogador
                if (!jogador.getArmasUsadas().contains(arma)) {
                    armasDisponiveis.add(arma);
                }
            }
        }

        // Exibe as opções de armas para o jogador escolher
        System.out.println("\nEscolha sua arma: \n");
        for (int i = 0; i < armasDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + armasDisponiveis.get(i).getNome() +
                               "(Dano: " + armasDisponiveis.get(i).getDano() +
                               ", Categoria: " + armasDisponiveis.get(i).getCategoria() + ")");
        }

        // Valida a escolha do jogador
        int escolha = -1;
        while (escolha < 1 || escolha > armasDisponiveis.size()) {
            System.out.println("\nDigite a numeração da arma escolhida: ");
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > armasDisponiveis.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }

        // Retorna a arma escolhida pelo jogador
        return armasDisponiveis.get(escolha - 1);
    }

    // Método para escolher uma armadura, similar ao método de armas, mas baseado em defesa
    public Armadura escolherArmadura(Jogador jogador) {
        // Lista de armaduras disponíveis no jogo
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Malha", 10));
        armaduras.add(new Armadura("Armadura de Ferro", 15));
        armaduras.add(new Armadura("Armadura de Diamante", 20));
        armaduras.add(new Armadura("Armadura de Netherite", 25));
        armaduras.add(new Armadura("Armadura de Rocha matriz", 30));

        // Lista de armaduras disponíveis para o jogador, filtradas por nível e escolhas anteriores
        List<Armadura> armadurasDisponiveis = new ArrayList<>();
        for (Armadura armadura : armaduras) {
            if ((jogador.getNivel() >= 2 && armadura.getNome().equals("Armadura de Malha")) ||
                (jogador.getNivel() >= 3 && armadura.getNome().equals("Armadura de Ferro")) ||
                (jogador.getNivel() >= 3 && armadura.getNome().equals("Armadura de Diamante")) ||
                (jogador.getNivel() >= 4 && armadura.getNome().equals("Armadura de Netherite")) ||
                (jogador.getNivel() >= 4 && armadura.getNome().equals("Armadura de Rocha matriz")) ||
                (armadura.getNome().equals("Armadura de Couro"))) {
                // Verifica se a armadura ainda não foi usada pelo jogador
                if (!jogador.getArmadurasUsadas().contains(armadura)) {
                    armadurasDisponiveis.add(armadura);
                }
            }
        }

        // Verifica se há uma armadura melhor disponível que a atual do jogador
        Armadura armaduraAtual = jogador.getArmadura();
        List<Armadura> armadurasValidas = new ArrayList<>();

        for (Armadura armadura : armadurasDisponiveis) {
            if (armaduraAtual == null || armadura.getDefesa() > armaduraAtual.getDefesa()) {
                armadurasValidas.add(armadura);
            }
        }

        // Caso não existam armaduras melhores, retorna a armadura atual
        if (armadurasValidas.isEmpty()) {
            System.out.println("\nNão há armaduras mais fortes disponíveis.");
            return armaduraAtual;
        }

        // Exibe as opções de armaduras para o jogador escolher
        System.out.println("\nEscolha sua nova armadura:");
        for (int i = 0; i < armadurasValidas.size(); i++) {
            System.out.println((i + 1) + " - " + armadurasValidas.get(i).getNome() +
                                " (Defesa: " + armadurasValidas.get(i).getDefesa() + ")");
        }

        // Valida a escolha do jogador
        int escolha = -1;
        while (escolha < 1 || escolha > armadurasValidas.size()) {
            System.out.print("\nDigite o número da armadura escolhida: ");
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > armadurasValidas.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }

        // Retorna a armadura escolhida pelo jogador
        return armadurasValidas.get(escolha - 1);
    }
}
