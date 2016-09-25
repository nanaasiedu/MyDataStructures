package Sorting;
import java.util.*;

public class QuickSort {
    public static void quickSort(Integer[] a) {
        quickSort(a, 0, a.length-1);
    }
    
    public static void quickSort(Integer[] a, int p, int r) {
        if (r-p <= 0) return;
        Random rand = new Random();
        int q = rand.nextInt(r+1-p)+p;
        
        int pivot = a[q];
        int j = p-1;
        
        swap(a, q, r);
        
        for (int i = p; i <= r; i++) {
            if (a[i] <= pivot) {
                j++;
                swap(a, i, j);
            }
        }
        
        quickSort(a, p, j-1);
        quickSort(a, j+1, r);
        
    }
    
    public static void swap(Integer[] a, int i, int j) {
        if (j == i) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
