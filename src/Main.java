import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

	public static void main(String[] args) {
		
		int opcao;
		
		do {
			opcao = parseInt(showInputDialog(Util.menu()));
			if (opcao < 1 || opcao > 6) {
				showMessageDialog(null, "Opção inválida");			
				} else {
					switch (opcao) {
					case 1: 
						Util.abrirConta();
					break;
					case 2: 
						Util.saque();
					break;
					case 3: 
						Util.deposito();
					break;
					case 4: 
						Util.relatorio();
					break;
					case 5: 
						Util.encerrarConta();
					break;
					case 6: 
						Util.exit();
					}
				}
		} while(opcao != 6);
	}
}
