package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciarArmamento {
    private Scanner entrada = new Scanner(System.in);

    public Arma escolherArma() {

        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Espada Longa", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));

        System.out.println();
        System.out.println("Escolha sua arma:");
        for (int i = 0; i < armas.size(); i++) {
            System.out.println((i + 1) + " - " + armas.get(i).getNome() + " (Dano: " + armas.get(i).getDano()
                    + ", Categoria: " + armas.get(i).getCategoria() + ")");
        }

        int escolha = -1;
        while (escolha < 1 || escolha > armas.size()) {
            try {
                System.out.println();
                System.out.print("Digite o número da arma escolhida: ");
                System.out.println();
                escolha = entrada.nextInt();
                if (escolha < 1 || escolha > armas.size()) {
                    System.out.println();
                    System.out.println("Escolha inválida, tente novamente.");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Entrada inválida! Digite um número.");
                System.out.println();
                entrada.next();
            }
        }

        return armas.get(escolha - 1);
    }

    public Armadura escolherArmadura() {
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Ferro", 10));
        armaduras.add(new Armadura("Armadura de Placas", 15));

        System.out.println("Escolha sua armadura:");
        for (int i = 0; i < armaduras.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + armaduras.get(i).getNome() + " (Defesa: " + armaduras.get(i).getDefesa() + ")");
        }

        int escolha = -1;
        while (escolha < 1 || escolha > armaduras.size()) {
            try {
                System.out.println();
                System.out.print("Digite o número da armadura escolhida: ");
                System.out.println();
                escolha = entrada.nextInt();
                if (escolha < 1 || escolha > armaduras.size()) {
                    System.out.println();
                    System.out.println("Escolha inválida, tente novamente.");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                entrada.next();
            }
        }

        return armaduras.get(escolha - 1);
    }
}
