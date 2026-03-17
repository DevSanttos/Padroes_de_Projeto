package composite1.problema;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

	private List<Object> membros = new ArrayList<>();
	
	public void add(Empregado membro) {
		membros.add(membro);
	}
	
	public void add(Departamento membro) {
		membros.add(membro);
	}
	
	public void remove(Empregado membro) {
		membros.remove(membro);
	}
	
	public void remove(Departamento membro) {
		membros.remove(membro);
	}
	
	public Object getMembroEmpresa(int index) {
		return membros.get(index);
	}
	
	public double getSalario() {
		
		double total = 0;
		for (Object m:membros) {
			if (m instanceof Empregado)
				total += ((Empregado)m).getSalario();
			if (m instanceof Departamento)
				total += ((Departamento)m).getSalario();
		}
		return total;
	}

}
