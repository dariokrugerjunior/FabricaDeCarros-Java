package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visualizacao.EntradaSaida;

public class Fabrica {

	private ArrayList<Carros> arrayCarros = new ArrayList<Carros>();

	public void venderCarros(int indexCarro) {
		arrayCarros.remove(indexCarro);
	}

	public void fabricarCarro(Carros novoCarro) {
		arrayCarros.add(novoCarro);
	}

	public ArrayList<Carros> getArrayCarros() {
		return arrayCarros;
	}

	public String[] infoCarros() {
		String infoCarros[] = new String[arrayCarros.size()];

		for (int i = 0; i < arrayCarros.size(); i++) {
			infoCarros[i] = arrayCarros.get(i).getCarroModelo() + " " + arrayCarros.get(i).getCarroCor() + " "
					+ arrayCarros.get(i).getCarroPortas() + " Portas";
		}
		return infoCarros;
	}
}
