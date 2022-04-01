public class Cliente {

	private String cpf, nome;
	private double saldo;
	
	public Cliente(String cpf){
		this.cpf = cpf;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void saque(double valor){
		this.saldo -= valor;
	}
	
	public void deposito(double valor){
		this.saldo += valor;
	}
	
	public String relatorio() {
		return "{O cliente " + this.nome + " com CPF  " + this.cpf + " tem saldo de --> " + this.saldo + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		Cliente cli = (Cliente) obj;
		return this.cpf.equals(cli.cpf);
	}
}
