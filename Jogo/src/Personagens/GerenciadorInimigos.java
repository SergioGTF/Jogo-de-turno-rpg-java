package Personagens;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorInimigos {
    public List<Adversario> criarInimigos() {
        List<Adversario> adversarios = new ArrayList<>();
        adversarios.add(new Adversario("Goblin", 50, 8, 5, 4, 3));
        adversarios.add(new Adversario("Orc", 70, 12, 7, 5, 4));
        adversarios.add(new Adversario("Dragão", 150, 20, 10, 7, 6));
        return adversarios;
    }
}
