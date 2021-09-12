package visualizacao;

import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int iniciaMenuFabrica() {

		String[] opcoes = { "Fabricar", "Vender", "Estoque", "Sair" };

		int indexOpcoes = JOptionPane.showOptionDialog(null, "Selecione a opcção desejada", "Car System v2",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

		return indexOpcoes;
	}

	public static int fabricarQuantidadeCarros() {
		int indexCarros = Integer
				.parseInt(JOptionPane.showInputDialog("Digite a quantidade de carros que devem ser fabricados!"));
		while (indexCarros <= 0) {
			JOptionPane.showMessageDialog(null, "Numero de carros incorreto!!");
			indexCarros = Integer
					.parseInt(JOptionPane.showInputDialog("Digite a quantidade de carros que devem ser fabricados!"));
		}

		return indexCarros;
	}

	public static String informeCarros() {

		String modeloCarro = JOptionPane.showInputDialog("Informe o nome do modelo do carro");

		while (modeloCarro == null) {
			JOptionPane.showMessageDialog(null, "Modelo do carro não pode estar vazio, digite novamente");
			modeloCarro = JOptionPane.showInputDialog("Informe o nome do modelo do carro");
		}
		return modeloCarro;
	}

	public static String informeCor(String carroModelo) {

		String corCarro = JOptionPane.showInputDialog("Informe a cor do " + carroModelo);

		while (corCarro == null) {
			JOptionPane.showMessageDialog(null, "Cor do carro não pode estar vazio, digite novamente");
			corCarro = JOptionPane.showInputDialog("Informe a cor do carro");
		}

		return corCarro;
	}

	public static int informePortas(String carroModelo) {

		int portasCarro = Integer
				.parseInt(JOptionPane.showInputDialog("Informe a quatidade de portas do " + carroModelo));

		while (portasCarro <= 0) {
			JOptionPane.showMessageDialog(null, "Numero de portas incorreto!!");
			portasCarro = Integer
					.parseInt(JOptionPane.showInputDialog("Digite a quantidade de portas do " + carroModelo + "!!"));
		}

		return portasCarro;
	}

	public static void MensagemErro() {

		JOptionPane.showMessageDialog(null, "Não a carro pra vender!!");

	}

	public static boolean abrirVendas() {

		if (JOptionPane.showConfirmDialog(null, "Deseja vender um carro ?", "Sistema de Vendas",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	public static int exibirMenuVendas(String[] infoCarros) {

		JComboBox<String> escolha = new JComboBox<String>(infoCarros);

		int option = JOptionPane.showConfirmDialog(null, escolha, "Selecione o carro que deseja vender",
				JOptionPane.OK_CANCEL_OPTION);

		while (option != 0) {
			option = JOptionPane.showConfirmDialog(null, escolha, "Selecione o carro que deseja vender",
					JOptionPane.OK_CANCEL_OPTION);
		}
		return escolha.getSelectedIndex();
	}

	public static void verEstoque(String[] infoCarros) {
		
		
		System.out.println("Passou aqui ");
		if (JOptionPane.showConfirmDialog(null, "Deseja ver o estoque de carros restantes ?", "Sistema de Vendas",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Estoque de carros é :\n" + Arrays.toString(infoCarros));
		}

	}

	public static void encerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado !");

	}

	public static void MensagemEstoque() {
		JOptionPane.showMessageDialog(null, "Não a carro pra vender!!");
	}
}
