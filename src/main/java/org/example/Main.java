package org.example;

import org.example.Relacoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tamanho do conjunto A:");
        int tamanhoA = scanner.nextInt();
        int[] conjuntoA = new int[tamanhoA];

        System.out.println("Informe os elementos do conjunto A:");
        for (int i = 0; i < tamanhoA; i++) {
            conjuntoA[i] = scanner.nextInt();
        }

        System.out.println("Informe o tamanho do conjunto B:");
        int tamanhoB = scanner.nextInt();
        int[] conjuntoB = new int[tamanhoB];

        System.out.println("Informe os elementos do conjunto B:");
        for (int i = 0; i < tamanhoB; i++) {
            conjuntoB[i] = scanner.nextInt();
        }

        System.out.println("Escolha a relação:");
        System.out.println("1. Maior que");
        System.out.println("2. Menor que");
        System.out.println("3. Igual a");
        System.out.println("4. Ser o quadrado de");
        System.out.println("5. Ser a raiz quadrada de");
        int escolha = scanner.nextInt();

        System.out.println("Pares que atendem à relação:");
        for (int a : conjuntoA) {
            for (int b : conjuntoB) {
                if (Relacoes.verificarRelacao(a, b, escolha)) {
                    System.out.println("<" + a + ", " + b + ">");
                }
            }
        }

        ArrayList<Integer> dominio = new ArrayList<>();
        for (int a : conjuntoA) {
            dominio.add(a);
        }
        System.out.println("Conjunto domínio de definição: " + dominio);

        ArrayList<Integer> imagem = new ArrayList<>();
        for (int b : conjuntoB) {
            imagem.add(b);
        }
        System.out.println("Conjunto imagem: " + imagem);

        if (Relacoes.isFuncional(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação é funcional.");
        }
        if (Relacoes.isInjetora(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação é injetora.");
        }
        if (Relacoes.isTotal(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação é total.");
        }
        if (Relacoes.isSobrejetora(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação é sobrejetora.");
        }
        if (Relacoes.isMonomorfismo(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação contém monomorfismo (Injetora).");
        }
        if (Relacoes.isEpimorfismo(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação contém epimorfismo (Sobrejetora).");
        }
        if (Relacoes.isIsomorfismo(conjuntoA, conjuntoB, escolha)) {
            System.out.println("A relação contém isomorfismo (Injetora + sobrejetora.");
        }
    }
}
