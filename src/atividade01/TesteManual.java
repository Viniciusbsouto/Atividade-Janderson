package atividade01;

import java.util.Arrays;

public class TesteManual {
    public static void main(String[] args) {
        Ordenacao ordenacao = new Ordenacao();
        int[] numeros = {5, 3, 2, 4, 1};

        System.out.println("Antes do Randomized QuickSort: " + Arrays.toString(numeros));

        long tempoExecucao = ordenacao.random_quickSort(numeros); // Agora 'numeros' será alterado

        System.out.println("Depois do Randomized QuickSort: " + Arrays.toString(numeros));
        System.out.println("Tempo de execução (ns): " + tempoExecucao);
    }
}
