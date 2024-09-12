package Armamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciarArmamento {
    private Random random = new Random();

    public Arma escolherArma() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Espada Longa", 15, "pesada"));
        armas.add(new Arma("Adaga", 10, "leve"));
        armas.add(new Arma("Martelo de Guerra", 20, "pesada"));

        int index = random.nextInt(armas.size());
        Arma armaEscolhida = armas.get(index);

        System.out.println("Arma escolhida:");
        System.out.println(armaEscolhida.getNome() + " (Dano: " + armaEscolhida.getDano() +
                ", Categoria: " + armaEscolhida.getCategoria() + ")");
        
        return armaEscolhida;
    }

    public Armadura escolherArmadura() {
        List<Armadura> armaduras = new ArrayList<>();
        armaduras.add(new Armadura("Armadura de Couro", 5));
        armaduras.add(new Armadura("Armadura de Ferro", 10));
        armaduras.add(new Armadura("Armadura de Placas", 15));

        int index = random.nextInt(armaduras.size());
        Armadura armaduraEscolhida = armaduras.get(index);

        System.out.println("Armadura escolhida:");
        System.out.println(armaduraEscolhida.getNome() + " (Defesa: " + armaduraEscolhida.getDefesa() + ")");
        
        return armaduraEscolhida;
    }
}
