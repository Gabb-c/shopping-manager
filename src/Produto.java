public class Produto {

	private String nome;
	private double preco;
	private Data dataValidade;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = null;
	}

	public Produto(String nome, double preco, Data dataValidade) {
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Data getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Data dataValidade) {
		this.dataValidade = dataValidade;
	}

	// Retorna true se 'data' for estritamente posterior a dataValidade.
	public boolean estaVencido(Data data) {
		if (dataValidade == null || data == null) {
			return false;
		}
		if (data.getAno() != dataValidade.getAno()) {
			return data.getAno() > dataValidade.getAno();
		}
		if (data.getMes() != dataValidade.getMes()) {
			return data.getMes() > dataValidade.getMes();
		}
		return data.getDia() > dataValidade.getDia();
	}

	@Override
	public String toString() {
		return "Produto: " + nome + " | Preco: " + preco
				+ " | Validade: " + (dataValidade != null ? dataValidade.toString() : "-");
	}
}
