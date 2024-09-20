package Combate;

import Personagens.Jogador;

public class TelaFinal {
    public void exibirVitoria(Jogador jogador) {
        System.out.println("\n");
        System.out.println(" VVVV     VVVV  IIIIII  TTTTTTTTTTTT   OOOOOOOOO   RRRRRRRR     IIIIII     AAAAAAAA   ");
        System.out.println(" V::V     V::V   I::I   T::::::::::T  O:::O O:::O  R:::::::R     I::I      A::::::A   ");
        System.out.println("  V::V   V::V    I::I      T::::T     O:::O O:::O  R::R  R::R    I::I     A::AAAA::A  ");
        System.out.println("  V::V   V::V    I::I      T::::T     O:::O O:::O   R:R  R::R    I::I     A::A  A::A  ");
        System.out.println("   V::V V::V     I::I      T::::T     O:::O O:::O   R::RRR::R    I::I    A:::AAAA:::A ");
        System.out.println("   V::V V::V     I::I      T::::T     O:::O O:::O  R::R  R::R    I::I    A:::A  A:::A ");
        System.out.println("    VVVVVVV     IIIIII     TTTTTT      OOOOOOOOO   RRRR   RRRR  IIIIII   AAAAA  AAAAA ");
        

        System.out.println("\nParabéns! Você venceu o jogo!");
        System.out.println("\nStatus final do jogador:");
        System.out.println("\nNome: " + jogador.getNome());
        System.out.println("\nVida: " + jogador.getVida());
        System.out.println("\nForça: " + jogador.getForca());
        System.out.println("\nConstituição: " + jogador.getConstituicao());
        System.out.println("\nDestreza: " + jogador.getDestreza());
        System.out.println("\nAgilidade: " + jogador.getAgilidade());
        System.out.println("\nMana : " + jogador.getMana());
        System.out.println();
        System.out.println("\nFeito por: Sergio Gabriel e Pedro Monteiro");
    }

    public void exibirDerrota(Jogador jogador) {
        System.out.println("\n");
        System.out.println(" DDDDDDDD    EEEEEEEE  RRRRRRRR     RRRRRRRR      OOOOOOOOO   TTTTTTTTTTTT    AAAAAAAA   ");
        System.out.println(" D:::::::D   E::E      R:::::::R    R:::::::R    O:::O O:::O  T::::::::::T    A::::::A   ");
        System.out.println(" D::DDDD::D  E::E      R::R  R::R   R::R  R::R   O:::O O:::O     T::::T      A::AAAA::A  ");
        System.out.println(" D::D  D::D  E::EEEEE   R:R  R::R    R:R  R::R   O:::O O:::O     T::::T      A::A  A::A  ");
        System.out.println(" D::DDDD::D  E::E       R::RRR::R    R::RRR::R   O:::O O:::O     T::::T     A:::AAAA:::A ");
        System.out.println(" D:::::::D   E::E      R::R  R::R   R::R  R::R   O:::O O:::O     T::::T     A:::A  A:::A ");
        System.out.println(" DDDDDDDD    E::EEEEE  RRRR   RRRR  RRRR   RRRR   OOOOOOOOO      TTTTTT     AAAAA  AAAAA ");

        System.out.println("\nVocê foi derrotado...");
        System.out.println("\nTente novamente!");
    }
}
