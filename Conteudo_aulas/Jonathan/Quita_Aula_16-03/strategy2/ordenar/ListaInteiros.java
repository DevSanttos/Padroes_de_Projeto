package strategy2.ordenar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaInteiros {

	private List<Integer> inteiros = new ArrayList<>();
	
	public void add(int i) {
		inteiros.add(i);
	}
	
	public void clear() {
		inteiros.clear();
	}
	
	public int get(int index) {
		return inteiros.get(index);
	}
	
	public void sort(Ordenador ordem) {
		int[] is = toIntArray(inteiros);
		ordem.ordenar(is);
		clear();
		for (int i:is) inteiros.add(i);
	}
	
	private int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(toIntArray(inteiros));
	}
}
