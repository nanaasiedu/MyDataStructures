package Sorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class SortingTest {
	private <T extends Comparable<T>> boolean isSorted(T[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].compareTo(a[i+1]) > 0) return false;
		}
		
		return true;
	}
	
	@Test
	public void quickSortTest() {
		int NUM = 100000;
		Integer[] a = new Integer[NUM];
				
		for (int i = 0; i < NUM; i++) {
			a[i] = i;
		}
		
		Collections.shuffle(Arrays.asList(a));
		QuickSort.quickSort(a);
		assertEquals("Expected a sorted list", true, isSorted(a));
	}
}
