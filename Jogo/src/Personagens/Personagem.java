package Personagens;

import java.util.Random; // Importa a classe Random para gerar números aleatórios
import Armamento.Arma; // Importa a classe Arma do pacote Armamento
import Armamento.Armadura; // Importa a classe Armadura do pacote Armamento

/* Classe abstrata para representar personagens (Jogador e Inimigo) */
public abstract class Personagem {
    private String nome; // Nome do personagem
    private int vida; // Vida atual do personagem
    private int forca; // Força do personagem
    private int constituicao; // Constituição do personagem
    private int agilidade; // Agilidade do personagem
    private int destreza; // Destreza do personagem
    private Arma arma; // Arma equipada pelo personagem
    private Armadura armadura; // Armadura equipada pelo personagem

    // Construtor da classe Personagem, inicializa os atributos
    public Personagem(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        this.nome = nome; // Define o nome do personagem
        this.vida = vida; // Define a vida inicial do personagem
        this.forca = forca; // Define a força do personagem
        this.constituicao = constituicao; // Define a constituição do personagem
        this.agilidade = agilidade; // Define a agilidade do personagem
        this.destreza = destreza; // Define a destreza do personagem
    }

    // Métodos getters para acessar atributos privados
    public String getNome() {
        return nome; // Retorna o nome do personagem
    }

    public int getVida() {
        return vida; // Retorna a vida atual do personagem
    }

    public int getForca() {
        return forca; // Retorna a força do personagem
    }

    public int getConstituicao() {
        return constituicao; // Retorna a constituição do personagem
    }

    public int getAgilidade() {
        return agilidade; // Retorna a agilidade do personagem
    }

    public int getDestreza() {
        return destreza; // Retorna a destreza do personagem
    }

    public Arma getArma() {
        return arma; // Retorna a arma equipada
    }

    public Armadura getArmadura() {
        return armadura; // Retorna a armadura equipada
    }

    // Métodos setters para modificar atributos privados
    public void setForca(int forca) {
        this.forca = forca; // Define a força do personagem
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao; // Define a constituição do personagem
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade; // Define a agilidade do personagem
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza; // Define a destreza do personagem
    }

    public void setVida(int vida) {
        this.vida = vida; // Define a vida do personagem
    }

    // Método para equipar uma arma ao personagem
    public void equiparArma(Arma arma) {
        this.arma = arma; // Define a arma equipada
    }

    // Método para equipar uma armadura ao personagem
    public void equiparArmadura(Armadura armadura) {
        this.armadura = armadura; // Define a armadura equipada
    }

    // Método para calcular o dano causado pelo personagem ao atacar
    public int calcularDano() {
        if (arma == null) { // Verifica se o personagem não está equipado com uma arma
            System.out.println(getNome() + "\nnão está equipado com uma arma!"); // Mensagem de erro
            return 0; // Retorna 0 de dano
        }

        // Rola o dado baseado na categoria da arma (pesada ou leve) e calcula o dano
        // total
        int dado = arma.getCategoria().equals("pesada") ? rolarD12() : rolarD6() + rolarD6() + rolarD4();
        return dado + arma.getDano() + (arma.getCategoria().equals("pesada") ? getForca() : getDestreza()); // Retorna
                                                                                                            // dano
                                                                                                            // total
    }

    // Método para o personagem receber dano
    public void receberDano(int dano) {
        int defesa = 0; // Inicializa a defesa do personagem
        if (armadura != null) { // Verifica se o personagem está usando uma armadura
            defesa = armadura.getDefesa() + getConstituicao(); // Calcula a defesa total
        }

        // Calcula o dano final levando em conta a defesa
        int danoFinal = Math.max(dano - defesa, 0);
        setVida(getVida() - danoFinal); // Atualiza a vida do personagem
        System.out.println(getNome() + "\nrecebeu " + danoFinal + " de dano. Vida restante: " + getVida()); // Mensagem
                                                                                                            // de dano
                                                                                                            // recebido
    }

    // Método para verificar se o personagem está vivo
    public boolean estaVivo() {
        return vida > 0; // Retorna true se a vida é maior que 0, caso contrário, false
    }

    // Métodos protegidos para rolar dados
    protected int rolarD6() {
        return new Random().nextInt(6) + 1; // Retorna um número aleatório de 1 a 6
    }

    protected int rolarD12() {
        return new Random().nextInt(12) + 1; // Retorna um número aleatório de 1 a 12
    }

    protected int rolarD4() {
        return new Random().nextInt(4) + 1; // Retorna um número aleatório de 1 a 4
    }

    // Método abstrato que deve ser implementado pelas subclasses (Jogador e
    // Inimigo)
    public abstract void realizarAcao(Personagem alvo);
}
