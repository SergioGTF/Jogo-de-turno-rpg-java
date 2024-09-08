package Personagens;

import java.util.ArrayList;
import java.util.List;
import Armamento.*;

public class GerenciadorInimigos {

    public List<Adversario> criarInimigos() {
        List<Adversario> adversarios = new ArrayList<>();

        Adversario goblin = new Adversario("Goblin", 50, 8, 5, 4, 3);
        goblin.equiparArma(new Arma("Clava", 5, "leve")); 
        adversarios.add(goblin);

        Adversario orc = new Adversario("Orc", 70, 12, 7, 5, 4);
        orc.equiparArma(new Arma("Machado", 10, "pesada")); 
        adversarios.add(orc);

        Adversario dragao = new Adversario("Dragão", 150, 20, 10, 7, 6);
        dragao.equiparArma(new Arma("Garras", 15, "pesada")); 
        adversarios.add(dragao);

        return adversarios;
    }
}

