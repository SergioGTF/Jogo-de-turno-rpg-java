package Personagens;

import java.util.Random;
import Armamento.Arma;
import Armamento.Armadura;

/* Classe para personagens (Jogador e Inimigo) */
public abstract class Personagem {
    private String nome;
    private int vida;
    private int forca;
    private int constituicao;
    private int agilidade;
    private int destreza;
    private Arma arma;
    private Armadura armadura;

    public Personagem(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.constituicao = constituicao;
        this.agilidade = agilidade;
        this.destreza = destreza;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getDestreza() {
        return destreza;
    }

    // Adicione os métodos para retornar a arma e armadura atuais:
    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    // Setters
    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    // Outros métodos
    public void equiparArma(Arma arma) {
        this.arma = arma;
    }

    public void equiparArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public int calcularDano() {
        if (arma == null) {
            System.out.println(getNome() + "\nnão está equipado com uma arma!");
            return 0;
        }

        int dado = arma.getCategoria().equals("pesada") ? rolarD12() : rolarD6() + rolarD6() + rolarD4();
        return dado + arma.getDano() + (arma.getCategoria().equals("pesada") ? getForca() : getDestreza());
    }

    public void receberDano(int dano) {
        int defesa = 0;
        if (armadura != null) {
            defesa = armadura.getDefesa() + getConstituicao();
        }

        int danoFinal = Math.max(dano - defesa, 0);
        setVida(getVida() - danoFinal);
        System.out.println(getNome() + "\nrecebeu " + danoFinal + " de dano. Vida restante: " + getVida());
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    protected int rolarD6() {
        return new Random().nextInt(6) + 1;
    }

    protected int rolarD12() {
        return new Random().nextInt(12) + 1;
    }

    protected int rolarD4() {
        return new Random().nextInt(4) + 1;
    }

    public abstract void realizarAcao(Personagem alvo);
}
