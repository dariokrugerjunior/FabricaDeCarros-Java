package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Carros;
import modelo.Fabrica;
import visualizacao.EntradaSaida;

public class Controladora {

	Fabrica fabrica = new Fabrica();

	public void ExibirMenu() {

		int opcao = EntradaSaida.iniciaMenuFabrica();

		do {
			switch (opcao) {
			case 0:
				iniciarFabrica();
				break;
			case 1:
				if (fabrica.getArrayCarros().size() < 1) {
					EntradaSaida.MensagemErro();
				} else {
					iniciarVendas();
				}
				break;
			case 2:
				chamaEstoque();
				break;
			case 3:
				EntradaSaida.encerraPrograma();
			}
			opcao = EntradaSaida.iniciaMenuFabrica();
		} while (opcao != 3);

	}

	public void iniciarFabrica() {

		JOptionPane.showMessageDialog(null, "Fabricar carros!");

		int carroIndex = EntradaSaida.fabricarQuantidadeCarros();

		ArrayList<Carros> carros = new ArrayList<Carros>();

		for (int i = 0; i < carroIndex; i++) {
			String carroModelo = EntradaSaida.informeCarros();
			String carroCor = EntradaSaida.informeCor(carroModelo);
			int carroPortas = EntradaSaida.informePortas(carroModelo);
			Carros novoCarro = new Carros();
			novoCarro.setCarroCor(carroCor);
			novoCarro.setCarroModelo(carroModelo);
			novoCarro.setCarroPortas(carroPortas);
			fabrica.fabricarCarro(novoCarro);
		}
	}

	public void iniciarVendas() {
		boolean abrirVendas = EntradaSaida.abrirVendas();
		String[] infoCarros = fabrica.infoCarros();

		while (abrirVendas == true && fabrica.getArrayCarros().size() > 0) {

			infoCarros = fabrica.infoCarros();
			int exibirMenuVendas = EntradaSaida.exibirMenuVendas(infoCarros);
			fabrica.venderCarros(exibirMenuVendas);
			if (fabrica.getArrayCarros().size() >= 1) {
				exibirMenuVendas = EntradaSaida.exibirMenuVendas(infoCarros);
			}

		}

	}

	public void chamaEstoque() {
		System.out.println("entrou no chama estoque ");
		if (fabrica.infoCarros().length >= 1) {
			System.out.println("passou if ");
			EntradaSaida.verEstoque(fabrica.infoCarros());
		}else {
			EntradaSaida.MensagemEstoque();
		}
	}

}
