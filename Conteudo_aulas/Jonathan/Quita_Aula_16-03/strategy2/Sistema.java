package strategy2;

import java.util.Arrays;
import java.util.Random;
import strategy2.ordenar.BubbleSort;
import strategy2.ordenar.ListaInteiros;
import strategy2.ordenar.QuickSort;

public class Sistema {

	public static void main(String[] args) {

		Random r = new Random();
		ListaInteiros li = new ListaInteiros();
		
		long ini1 = System.currentTimeMillis();
		for (int i = 0; i <= 10000000; i++)
			li.add(r.nextInt(100000000));
		long fim1 = System.currentTimeMillis();
		
		System.out.println("Lista inteiros: " + (fim1-ini1) + "ms");
		
		// ----------------
		
		long ini2 = System.currentTimeMillis();
		li.sort(new QuickSort());
		long fim2 = System.currentTimeMillis();
		
		System.out.println("QuickSort: " + (fim2-ini2) + "ms");
		
		// ----------------
		
		BubbleSort bubbleSort = new BubbleSort();
		
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Antes da execução do BubbleSort: " + Arrays.toString(arr));
        
        bubbleSort.bubbleSort(arr);
        
        System.out.println("Array after sorting: " + Arrays.toString(arr));
	}
}
