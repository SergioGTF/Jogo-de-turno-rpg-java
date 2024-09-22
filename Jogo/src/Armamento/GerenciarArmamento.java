package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Personagens.Jogador;

public class GerenciarArmamento {
    private Scanner entrada = new Scanner(System.in);

    public Arma escolherArma(Jogador jogador) {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Punhos de ferro", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));
        armas.add(new Arma("Espada de Netherite", 25, "Média"));
        armas.add(new Arma("Lâminas do Caos", 45, "Média"));

        List<Arma> armasDisponiveis = new ArrayList<>();
        for (Arma arma : armas) {
            if ((jogador.getNivel() >= 2 && arma.getNome().equals("Martelo de Guerra")) ||
                    (jogador.getNivel() >= 3 && arma.getNome().equals("Espada de Netherite")) ||
                    (jogador.getNivel() >= 3 && arma.getNome().equals("Lâminas do Caos")) ||
                    (arma.getNome().equals("Punhos de ferro") || arma.getNome().equals("Adaga"))) {
                if (!jogador.getArmasUsadas().contains(arma)) {
                    armasDisponiveis.add(arma);
                }
            }
        }

        System.out.println("\nEscolha sua arma: \n");
        for (int i = 0; i < armasDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + armasDisponiveis.get(i).getNome() +
                    "(Dano: " + armasDisponiveis.get(i).getDano() +
                    ", Categoria: " + armasDisponiveis.get(i).getCategoria() + ")");
        }

        int escolha = -1;
        while (escolha < 1 || escolha > armasDisponiveis.size()) {
            System.out.println("\nDigite a numeração da arma escolhida: ");
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > armasDisponiveis.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }

        return armasDisponiveis.get(escolha - 1);
    }

    public Armadura escolherArmadura(Jogador jogador) {
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Malha", 10));
        armaduras.add(new Armadura("Armadura de Ferro", 15));
        armaduras.add(new Armadura("Armadura de Diamante", 20));
        armaduras.add(new Armadura("Armadura de Netherite", 25));
        armaduras.add(new Armadura("Armadura de Rocha matriz", 30));

        List<Armadura> armadurasDisponiveis = new ArrayList<>();
        for (Armadura armadura : armaduras) {
            if ((jogador.getNivel() >= 2 && armadura.getNome().equals("Armadura de Malha")) ||
                    (jogador.getNivel() >= 3 && armadura.getNome().equals("Armadura de Ferro")) ||
                    (jogador.getNivel() >= 3 && armadura.getNome().equals("Armadura de Diamante")) ||
                    (jogador.getNivel() >= 4 && armadura.getNome().equals("Armadura de Netherite")) ||
                    (jogador.getNivel() >= 4 && armadura.getNome().equals("Armadura de Rocha matriz")) ||
                    (armadura.getNome().equals("Armadura de Couro"))) {
                if (!jogador.getArmadurasUsadas().contains(armadura)) {
                    armadurasDisponiveis.add(armadura);
                }
            }
        }

        Armadura armaduraAtual = jogador.getArmadura();
        List<Armadura> armadurasValidas = new ArrayList<>();

        for (Armadura armadura : armadurasDisponiveis) {
            if (armaduraAtual == null || armadura.getDefesa() > armaduraAtual.getDefesa()) {
                armadurasValidas.add(armadura);
            }
        }

        if (armadurasValidas.isEmpty()) {
            System.out.println("\nNão há armaduras mais fortes disponíveis.");
            return armaduraAtual;
        }

        System.out.println("\nEscolha sua nova armadura:");
        for (int i = 0; i < armadurasValidas.size(); i++) {
            System.out.println((i + 1) + " - " + armadurasValidas.get(i).getNome() +
                    " (Defesa: " + armadurasValidas.get(i).getDefesa() + ")");
        }

        int escolha = -1;
        while (escolha < 1 || escolha > armadurasValidas.size()) {
            System.out.print("\nDigite o número da armadura escolhida: ");
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > armadurasValidas.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }

        return armadurasValidas.get(escolha - 1);
    }
}
