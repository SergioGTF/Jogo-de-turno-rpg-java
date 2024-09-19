package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciarArmamento {
    private Random random = new Random();

    public Arma escolherArma() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Punhos de ferro", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));
        armas.add(new Arma("Espada de Netherite", 25, "Média"));
        armas.add(new Arma("Lâminas do Caos", 45, "Média"));

        int index = random.nextInt(armas.size());
        Arma armaEscolhida = armas.get(index);

        System.out.println("Arma escolhida: \n");
        System.out.println(armaEscolhida.getNome() + " (\nDano: " + armaEscolhida.getDano() +
                ", Categoria: " + armaEscolhida.getCategoria() + ")");

        return armaEscolhida;
    }

    public Armadura escolherArmadura() {
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Malha", 10));
        armaduras.add(new Armadura("Armadura de Ferro", 15));
        armaduras.add(new Armadura("Armadura de Diamante", 20));
        armaduras.add(new Armadura("Armadura de Netherite", 25));
        armaduras.add(new Armadura("Armadura de Rocha matriz", 30));

        int index = random.nextInt(armaduras.size());
        Armadura armaduraEscolhida = armaduras.get(index);

        System.out.println("\nArmadura escolhida: \n");
        System.out.println(armaduraEscolhida.getNome() + " (Defesa: " + armaduraEscolhida.getDefesa() + ")");

        return armaduraEscolhida;
    }
}
