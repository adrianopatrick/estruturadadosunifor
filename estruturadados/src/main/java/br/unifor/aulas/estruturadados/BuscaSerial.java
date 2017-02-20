package br.unifor.aulas.estruturadados;

public class BuscaSerial {

	/**
	 * Complexidade: O(n^2)
	 * */
	public static Integer busca(Integer[] numbers, Integer valor){
		if(valor != null) {
			for (int i = 0; i < numbers.length; i++) {
				if(valor == numbers[i]){
					return i;
				}
			}
		}
		return null;
	}
	
	public static Integer buscar(Object[] objs, Object valor) {
		if(valor != null) {
			for (int i = 0; i < objs.length; i++) {
				if(valor.equals(objs[i])){
					return i;
				}
			}
		}
		return null;
	}
}
