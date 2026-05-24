# Shopping Manager

[![CI](https://github.com/Gabb-c/shopping-manager/actions/workflows/ci.yml/badge.svg)](https://github.com/Gabb-c/shopping-manager/actions/workflows/ci.yml)

Gerenciador de lojas de um shopping center, escrito em **Java puro** (sem Maven/Gradle,
sem `package`, todos os `.java` na raiz). Desafio final da disciplina **Laboratório I**
(Unisinos, 2023/1), desenvolvido em quatro etapas: classes básicas, associação,
herança/polimorfismo e arrays.

## Estrutura

```
.
├── src/                   # Código-fonte
│   ├── Data.java          # Dia/mês/ano com validação e ano bissexto
│   ├── Endereco.java      # Endereço completo (rua, cidade, estado, país, CEP...)
│   ├── Produto.java       # Produto com preço e data de validade
│   ├── Loja.java          # Loja com funcionários, endereço e estoque de produtos
│   ├── Cosmetico.java     # Loja com taxa de comercialização
│   ├── Vestuario.java     # Loja com flag de produtos importados
│   ├── Bijuteria.java     # Loja com meta de vendas
│   ├── Alimentacao.java   # Loja com data de alvará
│   ├── Informatica.java   # Loja com seguro de eletrônicos
│   ├── Shopping.java      # Shopping com array de lojas
│   └── Principal.java     # Menu interativo (Scanner)
├── validators/            # Validadores oficiais (não modificar)
│   ├── ValidadorEtapa1.java
│   ├── ValidadorEtapa2.java
│   ├── ValidadorEtapa3.java
│   └── ValidadorEtapa4.java
└── out/                   # Binários (.class) gerados na compilação
```

Todas as classes ficam no **pacote default** (sem `package`), mesmo organizadas em
pastas — exigência dos validadores, que referenciam as classes pelo nome simples.
`Cosmetico`, `Vestuario`, `Bijuteria`, `Alimentacao` e `Informatica` herdam de `Loja`,
cada uma adicionando um atributo específico.

## Como compilar e executar

Requer apenas um JDK instalado (`javac` e `java`). Os binários são gerados em `out/`
com a flag `-d`, mantendo o código-fonte separado dos `.class`.

### Com Make (atalho)

Se tiver o `make` disponível:

```bash
make build   # compila src/ + validators/ em out/
make test    # roda os 4 validadores
make run     # executa a aplicação (Principal)
make clean   # remove out/
```

### Comandos manuais

### Aplicação

```bash
javac -d out src/*.java
java -cp out Principal
```

`Principal` exibe um menu para criar uma loja e um produto via teclado e informa
se o produto está vencido.

### Validadores

Compile as classes de `src/` junto com os validadores e rode cada etapa pelo
classpath `out`:

```bash
javac -d out src/*.java validators/*.java
java -cp out ValidadorEtapa1
java -cp out ValidadorEtapa2
java -cp out ValidadorEtapa3
java -cp out ValidadorEtapa4
```

Cada validador imprime `[OK]` ou `[NOK]` por verificação. O projeto passa nas quatro
etapas com **`[OK]` em todas as linhas**.

## Principais funcionalidades

- **`Data`** — valida a data no construtor (considerando ano bissexto) e cai para
  `1/1/2000` quando inválida; `verificaAnoBissexto()`.
- **`Produto.estaVencido(Data)`** — compara a data informada com a validade.
- **`Loja`** — `gastosComSalario()`, `tamanhoDaLoja()` (P/M/G) e estoque de produtos
  com `insereProduto`, `removeProduto` e `imprimeProdutos`.
- **`Shopping`** — array de lojas com `insereLoja`, `removeLoja`,
  `quantidadeLojasPorTipo(String)` (via `instanceof`) e `lojaSeguroMaisCaro()`.

## Integração contínua e releases

- **CI** (`.github/workflows/ci.yml`) — a cada push na `main` ou pull request,
  compila o projeto e roda os 4 validadores, falhando se aparecer qualquer `[NOK]`.
- **Release** (`.github/workflows/release.yml`) — disparada ao publicar uma **tag de
  versão**. Revalida as etapas e anexa dois artefatos à release:
  - `shopping-manager.jar` — executável (`java -jar shopping-manager.jar`);
  - `shopping-manager-src.zip` — código-fonte + validadores.

Para gerar uma release:

```bash
git tag v1.0.0
git push origin v1.0.0
```

## Convenções

- Atributos `private`, acesso por getters/setters (padrão JavaBeans).
- Sem bibliotecas externas (apenas `java.util.Scanner`, na classe `Principal`).
- Os arquivos em `validators/` são a fonte da verdade das assinaturas e **não devem
  ser modificados**.
