package br.unifor.aulas.estruturadados;

public class BuscaSerial {

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
}
