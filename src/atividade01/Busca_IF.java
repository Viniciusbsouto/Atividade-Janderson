package atividade01;

/*
 * Interface para implementação da classe "Busca".
 * Os métodos booleanos devem retornar 'false' se 'k' não estiver no vetor 'numeros'.
 */
public interface Busca_IF {
	
	int[] geraVetorNumericoOrdenado(int tamanho);
	
	boolean buscaLinear_iterativa(int[] numeros, int k);

	boolean buscaLinear_recursiva(int[] numeros, int k);
	
	boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k);

	boolean buscaBinaria_iterativa(int[] numeros, int k);

	boolean buscaBinaria_recursiva(int[] numeros, int k);

}