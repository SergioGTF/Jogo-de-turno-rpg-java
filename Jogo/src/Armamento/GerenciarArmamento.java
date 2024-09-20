package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarArmamento {
    private Scanner entrada = new Scanner(System.in);
    
    public Arma escolherArma() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Punhos de ferro", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));
        armas.add(new Arma("Espada de Netherite", 25, "Média"));
        armas.add(new Arma("Lâminas do Caos", 45, "Média"));


        System.out.println("\nEscolha sua arma: \n");
        for (int i = 0; i <armas.size(); i++){
            System.out.println((i + 1) + " - " + armas.get(i).getNome() + "(Dano: " + armas.get(i).getDano() + ", Categoria: " + armas.get(i).getCategoria() + ")");
        }

        int escolha = -1;

        while (escolha < 1 || escolha > armas.size()) {
            System.out.println("\nDigite a numeração da arma escolhida: ");
            escolha = entrada.nextInt();

            if (escolha < 1 || escolha > armas.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }

        return armas.get(escolha - 1);
    }

    public Armadura escolherArmadura() {
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Malha", 10));
        armaduras.add(new Armadura("Armadura de Ferro", 15));
        armaduras.add(new Armadura("Armadura de Diamante", 20));
        armaduras.add(new Armadura("Armadura de Netherite", 25));
        armaduras.add(new Armadura("Armadura de Rocha matriz", 30));

        System.out.println("\nEscolha sua armadura:");
        for (int i = 0; i < armaduras.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + armaduras.get(i).getNome() + " (Defesa: " + armaduras.get(i).getDefesa() + ")");
        }

        int escolha = -1;
        while (escolha < 1 || escolha > armaduras.size()) {
            System.out.print("\nDigite o número da armadura escolhida: ");
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > armaduras.size()) {
                System.out.println("\nEscolha inválida, tente novamente.");
            }
        }
        return armaduras.get(escolha - 1);
    }
}
