package atividade01;

import java.util.Arrays;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public boolean checaVetorOrdenado(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            if (numeros[i] > numeros[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long bubbleSort(int[] numeros) {
        long startTime = System.nanoTime();
        boolean trocou;
        do {
            trocou = false;
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    troca(numeros, j, j + 1);
                    trocou = true;
                }
            }
        } while (trocou);
        return System.nanoTime() - startTime;
    }

    @Override
    public long random_quickSort(int[] numeros) {
        int[] copia = Arrays.copyOf(numeros, numeros.length);
        long startTime = System.nanoTime();
        randomQuickSortHelper(copia, 0, copia.length - 1);
        System.arraycopy(copia, 0, numeros, 0, numeros.length);
        return System.nanoTime() - startTime;
    }

    private void randomQuickSortHelper(int[] arr, int esq, int dir) {
        if (esq < dir) {
            int pivoIndex = partition(arr, esq, dir);
            randomQuickSortHelper(arr, esq, pivoIndex - 1);
            randomQuickSortHelper(arr, pivoIndex + 1, dir);
        }
    }

    private int partition(int[] arr, int esq, int dir) {
        int randomIndex = esq + (int) (Math.random() * (dir - esq + 1));
        swap(arr, randomIndex, dir);
        int pivo = arr[dir];
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (arr[j] <= pivo) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, dir);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public long selectionSort(int[] numeros) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numeros.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[minIdx])
                    minIdx = j;
            }
            if (minIdx != i)
                troca(numeros, i, minIdx);
        }
        return System.nanoTime() - startTime;
    }

    @Override
    public long insertionSort(int[] numeros) {
        long startTime = System.nanoTime();
        for (int i = 1; i < numeros.length; i++) {
            int key = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > key) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = key;
        }
        return System.nanoTime() - startTime;
    }

    @Override
    public long mergeSort(int[] numeros) {
        long startTime = System.nanoTime();
        mergeSortHelper(numeros, 0, numeros.length - 1);
        return System.nanoTime() - startTime;
    }

    private void mergeSortHelper(int[] arr, int esq, int dir) {
        if (esq < dir) {
            int meio = esq + (dir - esq) / 2;
            mergeSortHelper(arr, esq, meio);
            mergeSortHelper(arr, meio + 1, dir);
            merge(arr, esq, meio, dir);
        }
    }

    private void merge(int[] arr, int esq, int meio, int dir) {
        int[] temp = Arrays.copyOfRange(arr, esq, dir + 1);
        int i = 0, j = meio - esq + 1, k = esq;
        while (i <= meio - esq && j < temp.length) {
            arr[k++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];
        }
        while (i <= meio - esq)
            arr[k++] = temp[i++];
        while (j < temp.length)
            arr[k++] = temp[j++];
    }

    @Override
    public long quickSort(int[] numeros) {
        long startTime = System.nanoTime();
        quickSortHelper(numeros, 0, numeros.length - 1);
        return System.nanoTime() - startTime;
    }

    private void quickSortHelper(int[] arr, int esq, int dir) {
        if (esq < dir) {
            int pivo = particiona(arr, esq, dir);
            quickSortHelper(arr, esq, pivo - 1);
            quickSortHelper(arr, pivo + 1, dir);
        }
    }

    private int particiona(int[] arr, int esq, int dir) {
        int pivo = arr[dir], i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (arr[j] <= pivo)
                troca(arr, ++i, j);
        }
        troca(arr, i + 1, dir);
        return i + 1;
    }

    @Override
    public long quickSort_Java(int[] numeros) {
        long startTime = System.nanoTime();
        Arrays.sort(numeros);
        return System.nanoTime() - startTime;
    }

    @Override
    public long countingSort(int[] numeros) {
        if (numeros.length == 0)
            return 0;
        int[] copia = Arrays.copyOf(numeros, numeros.length);
        long startTime = System.nanoTime();
        int min = Arrays.stream(copia).min().orElse(0);
        int max = Arrays.stream(copia).max().orElse(0);
        int[] count = new int[max - min + 1];
        for (int num : copia)
            count[num - min]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0)
                numeros[index++] = i + min;
        }
        return System.nanoTime() - startTime;
    }

    private void troca(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
