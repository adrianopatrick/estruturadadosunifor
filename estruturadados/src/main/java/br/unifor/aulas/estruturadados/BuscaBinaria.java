package br.unifor.aulas.estruturadados;

public class BuscaBinaria {

	public static Integer busca(Integer[] numbers, Integer valor) {
		
		if(valor != null) {
			Integer inicio = 0;
			Integer fim = numbers.length - 1; 
	
			Integer media = (inicio + fim) / 2; 
			while (inicio <= fim) {
				if (numbers[media] == valor) {
					return media;
				} else if (numbers[media] > valor) {
					fim = media - 1; 
				} else if (numbers[media] < valor) { 
					inicio = media + 1;  
				}
				media = (inicio + fim) / 2;	
			}
		}
		return null;
	}
}
