# Makefile - Shopping Manager
# Projeto Java puro (pacote default): fontes em src/, validadores em validators/,
# binarios (.class) gerados em out/.

JAVAC      := javac
JAVA       := java
SRC_DIR    := src
VAL_DIR    := validators
OUT_DIR    := out
SOURCES    := $(wildcard $(SRC_DIR)/*.java)
VALIDATORS := $(wildcard $(VAL_DIR)/*.java)

.PHONY: all build run test clean help

# Alvo padrao: compila tudo
all: build

# Compila fontes + validadores em out/
build:
	@mkdir -p $(OUT_DIR)
	$(JAVAC) -d $(OUT_DIR) $(SOURCES) $(VALIDATORS)

# Executa a aplicacao interativa
run: build
	$(JAVA) -cp $(OUT_DIR) Principal

# Roda os 4 validadores em sequencia
test: build
	@for n in 1 2 3 4; do \
		echo "========== ValidadorEtapa$$n =========="; \
		$(JAVA) -cp $(OUT_DIR) ValidadorEtapa$$n; \
		echo ""; \
	done

# Remove os binarios
clean:
	rm -rf $(OUT_DIR)

# Lista os alvos disponiveis
help:
	@echo "Alvos disponiveis:"
	@echo "  make build  - compila src/ + validators/ em out/"
	@echo "  make run    - executa a aplicacao (Principal)"
	@echo "  make test   - roda os 4 validadores"
	@echo "  make clean  - remove out/"
