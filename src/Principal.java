import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Loja loja = null;
		Produto produto = null;
		boolean executando = true;

		while (executando) {
			System.out.println("\n=== Gerenciador de Lojas ===");
			System.out.println("(1) criar uma loja");
			System.out.println("(2) criar um produto");
			System.out.println("(3) sair");
			System.out.print("Escolha uma opcao: ");
			String opcao = scanner.nextLine();

			if (opcao.equals("1")) {
				loja = criarLoja(scanner);
			} else if (opcao.equals("2")) {
				produto = criarProduto(scanner);
			} else if (opcao.equals("3")) {
				executando = false;
			} else {
				System.out.println("Opção inválida");
			}

			if (loja != null && produto != null) {
				if (produto.estaVencido(new Data(20, 10, 2023))) {
					System.out.println("PRODUTO VENCIDO");
				} else {
					System.out.println("PRODUTO NÃO VENCIDO");
				}
				System.out.println(loja.toString());
			}
		}

		scanner.close();
	}

	private static Loja criarLoja(Scanner scanner) {
		System.out.print("Nome da loja: ");
		String nome = scanner.nextLine();
		System.out.print("Quantidade de funcionarios: ");
		int qtd = Integer.parseInt(scanner.nextLine());
		System.out.print("Salario base do funcionario: ");
		double salario = Double.parseDouble(scanner.nextLine());

		System.out.println("-- Endereco da loja --");
		Endereco endereco = criarEndereco(scanner);

		System.out.println("-- Data de fundacao --");
		Data dataFundacao = criarData(scanner);

		System.out.print("Capacidade maxima do estoque: ");
		int tamanhoEstoque = Integer.parseInt(scanner.nextLine());

		return new Loja(nome, qtd, salario, endereco, dataFundacao, tamanhoEstoque);
	}

	private static Produto criarProduto(Scanner scanner) {
		System.out.print("Nome do produto: ");
		String nome = scanner.nextLine();
		System.out.print("Preco do produto: ");
		double preco = Double.parseDouble(scanner.nextLine());

		System.out.println("-- Data de validade --");
		Data dataValidade = criarData(scanner);

		return new Produto(nome, preco, dataValidade);
	}

	private static Endereco criarEndereco(Scanner scanner) {
		System.out.print("Nome da rua: ");
		String rua = scanner.nextLine();
		System.out.print("Cidade: ");
		String cidade = scanner.nextLine();
		System.out.print("Estado: ");
		String estado = scanner.nextLine();
		System.out.print("Pais: ");
		String pais = scanner.nextLine();
		System.out.print("CEP: ");
		String cep = scanner.nextLine();
		System.out.print("Numero: ");
		String numero = scanner.nextLine();
		System.out.print("Complemento: ");
		String complemento = scanner.nextLine();
		return new Endereco(rua, cidade, estado, pais, cep, numero, complemento);
	}

	private static Data criarData(Scanner scanner) {
		System.out.print("Dia: ");
		int dia = Integer.parseInt(scanner.nextLine());
		System.out.print("Mes: ");
		int mes = Integer.parseInt(scanner.nextLine());
		System.out.print("Ano: ");
		int ano = Integer.parseInt(scanner.nextLine());
		return new Data(dia, mes, ano);
	}
}
