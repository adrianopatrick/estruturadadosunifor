package br.unifor.aulas.estruturadados;

public class InsertionSort {

	public static void sort(Integer[] numbers){
		for(int j = 1; j < numbers.length; j++){
			Integer key = numbers[j];
			Integer i = j - 1;
			
			while (i >= 0 && key < numbers[i]) {
				numbers[i + 1] = numbers[i];
				i--;
			}
			numbers[i + 1] = key;
		}
	}
}
