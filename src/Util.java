import static javax.swing.JOptionPane.*;
public class Util {
	
	private static Lista<Cliente> clientes = new Lista<Cliente>();
	
	public static String menu(){
		String aux = "Escolha uma opcao: \n";
		aux += "1. Abrir conta  \n";
		aux += "2. Realizar saque \n";
		aux += "3. Realizar deposito \n";
		aux += "4. Relatorio de contas \n";
		aux += "5. Encerrar conta\n";
		aux += "6. Encerrar aplicação \n";
		return aux;
	}

	public static void abrirConta() {
		
		String nome, cpf;
		
		nome = showInputDialog("Nome");
		cpf = showInputDialog("Cpf");
		
		Cliente cliente = new Cliente(cpf);

		if (clientes.pesquisar(cliente) != null){
			showMessageDialog(null, cliente.getNome() + " possui o mesmo cpf que outro cliente");
		}else {
			cliente.setNome(nome);
			clientes.inserir(cliente);
			showMessageDialog(null, "Cliente cadastrado com sucesso!");
		}	
	}

	public static void saque() {

		String cpf;
		double valor;

		cpf = showInputDialog("Cpf");
		Cliente cliente = new Cliente(cpf);
		No<Cliente> cliente_encontrado  = clientes.pesquisar(cliente);

		if (cliente_encontrado != null){
			valor = Double.parseDouble(showInputDialog("Insira o valor a ser sacado:"));
			if (valor <= cliente_encontrado.dado.getSaldo()){
				cliente_encontrado.dado.saque(valor);
				showMessageDialog(null, "Saque efetuado com sucesso!");
			} else {
				showMessageDialog(null, "Saque invalido!");
			}
		}else {
			showMessageDialog(null, "Cliente não existe!");
		}
	}
	
	public static void deposito() {
	
		String cpf;
		double valor;

		cpf = showInputDialog("Cpf");
		Cliente cliente = new Cliente(cpf);
		No<Cliente> encontrado  = clientes.pesquisar(cliente);

		if (encontrado != null){
			valor = Double.parseDouble(showInputDialog("Insira o valor a ser depositado:"));
			if (valor > 0){
				encontrado.dado.deposito(valor);
				showMessageDialog(null, "Depósito efetuado com sucesso!");
			} else {
				showMessageDialog(null, "Depósito invalido!");
			}
		}else {
			showMessageDialog(null, "Cliente não existe!");
		}
	}

	public static void relatorio() {
		
		No<Cliente> aux = clientes.inicio;
		String rel_cliente = "";

		while(aux != null){
			rel_cliente += aux.dado.relatorio();
			aux = aux.dir;
		}
		showMessageDialog(null, rel_cliente);
	}

	public static void encerrarConta() {

		String cpf;
		boolean cliente_existe;

		cpf = showInputDialog("Cpf");
		Cliente cliente = new Cliente(cpf);
		cliente_existe = clientes.remover(cliente);

		if(cliente_existe) {
			showMessageDialog(null, "Conta encerrada com sucesso!");
		} else {
			showMessageDialog(null, "Conta não existe!");
		}
		
	}

	public static void exit() {
		System.exit(0);
	}
}
