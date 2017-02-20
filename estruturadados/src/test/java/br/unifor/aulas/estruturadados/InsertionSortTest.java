package br.unifor.aulas.estruturadados;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void testSort() {
		Integer[] numbers = {31, 41, 59, 26, 41,58};
		Integer[] result = {26, 31, 41, 41, 58, 59};
		InsertionSort.sort(numbers);
		assertArrayEquals(result, numbers);
	}
	
	@Test
	public void testSorting() {
		Integer[] numbers = {31, 41, 59, 26, 41,58};
		Integer[] result = {26, 31, 41, 41, 58, 59};
		InsertionSort.sorting(numbers, (o1, o2) -> ((Integer)o1).compareTo((Integer)o2));
		assertArrayEquals(result, numbers);
	}

}
