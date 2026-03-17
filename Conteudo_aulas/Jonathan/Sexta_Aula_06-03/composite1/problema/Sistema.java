package composite1.problema;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	public static void main(String[] args) {

		Empregado e1 = new Empregado("A", 1300);
		Empregado e2 = new Empregado("B", 1100);
		
		Departamento vendas = new Departamento();
		vendas.add(e1);
		vendas.add(e2);
		System.out.println(vendas.getSalario()); // 2400

		Empregado chefe = new Empregado("Chefao", 7000);
		System.out.println(chefe.getSalario()); // 7000
		
		Departamento marketingEvendas = new Departamento();
		marketingEvendas.add(chefe);
		marketingEvendas.add(vendas); 
		
		System.out.println(marketingEvendas.getSalario()); // 9400
		
		
		
		
	}

}
