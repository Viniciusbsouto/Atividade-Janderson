package atividade01;

public class Busca implements Busca_IF {

    @Override
    public int[] geraVetorNumericoOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1; // Gera vetor ordenado de 1 a tamanho
        }
        return vetor;
    }

    @Override
    public boolean buscaLinear_iterativa(int[] numeros, int k) {
        for (int num : numeros) {
            if (num == k) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscaLinear_recursiva(int[] numeros, int k) {
        return buscaLinear_recursiva_helper(numeros, k, 0);
    }

    private boolean buscaLinear_recursiva_helper(int[] numeros, int k, int index) {
        if (index >= numeros.length) {
            return false;
        }
        if (numeros[index] == k) {
            return true;
        }
        return buscaLinear_recursiva_helper(numeros, k, index + 1);
    }

    @Override
    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k) {
        int inicio = 0;
        int fim = numeros.length - 1;
        
        while (inicio <= fim) {
            if (numeros[inicio] == k || numeros[fim] == k) {
                return true;
            }
            inicio++;
            fim--;
        }
        return false;
    }

    @Override
    public boolean buscaBinaria_iterativa(int[] numeros, int k) {
        int esquerda = 0;
        int direita = numeros.length - 1;
        
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            
            if (numeros[meio] == k) {
                return true;
            }
            
            if (numeros[meio] < k) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false;
    }

    @Override
    public boolean buscaBinaria_recursiva(int[] numeros, int k) {
        return buscaBinaria_recursiva_helper(numeros, k, 0, numeros.length - 1);
    }

    private boolean buscaBinaria_recursiva_helper(int[] numeros, int k, int esquerda, int direita) {
        if (esquerda > direita) {
            return false;
        }
        
        int meio = esquerda + (direita - esquerda) / 2;
        
        if (numeros[meio] == k) {
            return true;
        }
        
        if (numeros[meio] < k) {
            return buscaBinaria_recursiva_helper(numeros, k, meio + 1, direita);
        } else {
            return buscaBinaria_recursiva_helper(numeros, k, esquerda, meio - 1);
        }
    }
}