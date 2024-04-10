package org.example;

import java.util.ArrayList;

public class Relacoes {
    public static boolean verificarRelacao(int a, int b, int escolha) {
        switch (escolha) {
            case 1:
                return a > b;
            case 2:
                return a < b;
            case 3:
                return a == b;
            case 4:
                return a == (b * b);
            case 5:
                return a == Math.sqrt(b);
            default:
                return false;
        }
    }

    public static boolean isFuncional(int[] conjuntoA, int[] conjuntoB, int escolha) {
        for (int a : conjuntoA) {
            boolean mapeado = false;
            for (int b : conjuntoB) {
                if (verificarRelacao(a, b, escolha)) {
                    if (mapeado) { // Se já foi mapeado anteriormente, não é funcional
                        return false;
                    }
                    mapeado = true;
                }
            }
            if (!mapeado) { // Se nenhum elemento de B foi mapeado para A, não é funcional
                return false;
            }
        }
        return true;
    }

    public static boolean isInjetora(int[] conjuntoA, int[] conjuntoB, int escolha) {
        for (int b : conjuntoB) {
            boolean mapeado = false;
            for (int a : conjuntoA) {
                if (verificarRelacao(a, b, escolha)) {
                    if (mapeado) { // Se já foi mapeado anteriormente, não é injetora
                        return false;
                    }
                    mapeado = true;
                }
            }
            if (!mapeado) { // Se nenhum elemento de A foi mapeado para B, não é injetora
                return false;
            }
        }
        return true;
    }


    public static boolean isTotal(int[] conjuntoA, int[] conjuntoB, int escolha) {
        for (int a : conjuntoA) {
            boolean mapeado = false;
            for (int b : conjuntoB) {
                if (verificarRelacao(a, b, escolha)) {
                    mapeado = true;
                    break;
                }
            }
            if (!mapeado) { // Se nenhum elemento de B foi mapeado para A, não é total
                return false;
            }
        }
        return true;
    }

    public static boolean isSobrejetora(int[] conjuntoA, int[] conjuntoB, int escolha) {
        for (int b : conjuntoB) {
            boolean mapeado = false;
            for (int a : conjuntoA) {
                if (verificarRelacao(a, b, escolha)) {
                    mapeado = true;
                    break;
                }
            }
            if (!mapeado) { // Se nenhum elemento de A foi mapeado para B, não é sobrejetora
                return false;
            }
        }
        return true;
    }

    public static boolean isMonomorfismo(int[] conjuntoA, int[] conjuntoB, int escolha) {
        return isFuncional(conjuntoA, conjuntoB, escolha) && isInjetora(conjuntoA, conjuntoB, escolha);
    }

    public static boolean isEpimorfismo(int[] conjuntoA, int[] conjuntoB, int escolha) {
        return isTotal(conjuntoA, conjuntoB, escolha) && isSobrejetora(conjuntoA, conjuntoB, escolha);
    }

    public static boolean isIsomorfismo(int[] conjuntoA, int[] conjuntoB, int escolha) {
        return isFuncional(conjuntoA, conjuntoB, escolha) && isTotal(conjuntoA, conjuntoB, escolha);
    }

    public static ArrayList<Integer> getDominio(int[] conjuntoA) {
        ArrayList<Integer> dominio = new ArrayList<>();
        for (int a : conjuntoA) {
            dominio.add(a);
        }
        return dominio;
    }

    public static ArrayList<Integer> getImagem(int[] conjuntoB) {
        ArrayList<Integer> imagem = new ArrayList<>();
        for (int b : conjuntoB) {
            imagem.add(b);
        }
        return imagem;
    }
}
