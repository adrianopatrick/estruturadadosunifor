package br.unifor.aulas.estruturadados.np1;

import java.util.Comparator;

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
	

	public static void sorting(Object[] objs, Comparator<Object> comparator){
		for(int j = 1; j < objs.length; j++){
			Object key = objs[j];
			Integer i = j - 1;
			
			while (i >= 0 && comparator.compare(key, objs[i]) < 0) {
				objs[i + 1] = objs[i];
				i--;
			}
			objs[i + 1] = key;
		}
	}
}
