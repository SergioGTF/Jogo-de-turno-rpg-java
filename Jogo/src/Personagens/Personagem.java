package Personagens;

/* Classe para personagens (Jogador e Inimigo) */
public class Personagem {
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

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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

    public void equiparArma(Arma arma) {
        this.arma = arma;
    }

    public void equiparArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public int calcularDano() {
        int dado = arma.getCategoria().equals("pesada") ? rolarD12() : rolarD6() + rolarD6() + rolarD4();
        return dado + arma.getDano() + (arma.getCategoria().equals("pesada") ? forca : destreza);
    }

    public void receberDano(int dano){
        int defesa = armadura != null ? armadura.getDefesa() + constituicao : 0;
        int danoFinal = Math.max(dano - defesa, 0);
        vida -= danoFinal;
        System.out.println(nome + " recebeu " + danoFinal + " de dano. Vida restante: " + vida);
    }
}
