public class Shopping {

	private String nome;
	private Endereco endereco;
	private Loja[] lojas;

	public Shopping(String nome, Endereco endereco, int capacidadeMaximaLojas) {
		this.nome = nome;
		this.endereco = endereco;
		this.lojas = new Loja[capacidadeMaximaLojas];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Loja[] getLojas() {
		return lojas;
	}

	public void setLojas(Loja[] lojas) {
		this.lojas = lojas;
	}

	public boolean insereLoja(Loja loja) {
		if (lojas == null) {
			return false;
		}
		for (int i = 0; i < lojas.length; i++) {
			if (lojas[i] == null) {
				lojas[i] = loja;
				return true;
			}
		}
		return false;
	}

	public boolean removeLoja(String nomeLoja) {
		if (lojas == null) {
			return false;
		}
		for (int i = 0; i < lojas.length; i++) {
			if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
				lojas[i] = null;
				return true;
			}
		}
		return false;
	}

	// Conta lojas do tipo informado (aceita com e sem acento).
	// Retorna -1 se o tipo nao corresponder a nenhuma categoria valida.
	public int quantidadeLojasPorTipo(String tipoLoja) {
		if (tipoLoja == null) {
			return -1;
		}
		int contador = 0;
		if (tipoLoja.equals("Cosmético") || tipoLoja.equals("Cosmetico")) {
			for (Loja loja : lojas) {
				if (loja instanceof Cosmetico) {
					contador++;
				}
			}
		} else if (tipoLoja.equals("Vestuário") || tipoLoja.equals("Vestuario")) {
			for (Loja loja : lojas) {
				if (loja instanceof Vestuario) {
					contador++;
				}
			}
		} else if (tipoLoja.equals("Bijuteria")) {
			for (Loja loja : lojas) {
				if (loja instanceof Bijuteria) {
					contador++;
				}
			}
		} else if (tipoLoja.equals("Alimentação") || tipoLoja.equals("Alimentacao")) {
			for (Loja loja : lojas) {
				if (loja instanceof Alimentacao) {
					contador++;
				}
			}
		} else if (tipoLoja.equals("Informática") || tipoLoja.equals("Informatica")) {
			for (Loja loja : lojas) {
				if (loja instanceof Informatica) {
					contador++;
				}
			}
		} else {
			return -1;
		}
		return contador;
	}

	// Entre todas as lojas de Informatica, retorna a de maior seguroEletronicos.
	// Retorna null se nao houver nenhuma.
	public Informatica lojaSeguroMaisCaro() {
		Informatica maisCaro = null;
		if (lojas == null) {
			return null;
		}
		for (Loja loja : lojas) {
			if (loja instanceof Informatica) {
				Informatica atual = (Informatica) loja;
				if (maisCaro == null || atual.getSeguroEletronicos() > maisCaro.getSeguroEletronicos()) {
					maisCaro = atual;
				}
			}
		}
		return maisCaro;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Shopping: ").append(nome);
		sb.append(" | Endereco: ").append(endereco != null ? endereco.toString() : "-");
		sb.append(" | Lojas:");
		if (lojas != null) {
			for (Loja loja : lojas) {
				if (loja != null) {
					sb.append("\n  - ").append(loja.toString());
				}
			}
		}
		return sb.toString();
	}
}
