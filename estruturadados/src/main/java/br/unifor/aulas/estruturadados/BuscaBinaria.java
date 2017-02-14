package br.unifor.aulas.estruturadados;

import java.util.Comparator;

public class BuscaBinaria {

	/**
	 * Complexidade: O(lg n)
	 * */
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
	
	
	public static Integer buscar(Object[] objs, Object valor, Comparator<Object> comparator) {
		if(valor != null) {
			Integer inicio = 0;
			Integer fim = objs.length - 1; 
	
			Integer media = (inicio + fim) / 2; 
			while (inicio <= fim) {
				if (objs[media].equals(valor)) {
					return media;
				} else if (comparator.compare(objs[media], valor) > 0) {
					fim = media - 1; 
				} else if (comparator.compare(objs[media], valor) < 0) { 
					inicio = media + 1;  
				}
				media = (inicio + fim) / 2;	
			}
		}
		return null;
	}
	
}
