# Rotas entre Cidades

O objetivo é encontrar a rota mais eficiente entre duas cidades, considerando custos de transporte, distâncias e possíveis bloqueios de estradas.

---

## Estrutura do Projeto

O projeto é composto por quatro classes principais:

1. **Cidade**
2. **Estrada**
3. **Grafo**
4. **Main**

---

### 1. Cidade

A classe `Cidade` representa uma cidade no grafo, onde a cidade tem um nome e uma lista de estradas conectadas a ela.

**Atributos:**

- `nome`: Nome da cidade.
- `estradas`: Lista de estradas conectadas a esta cidade.

**Construtor:**

- Inicializa a cidade com um nome e uma lista vazia de estradas.

---

### 2. Estrada

A classe `Estrada` representa uma estrada entre duas cidades, onde a estrada tem uma cidade de destino, uma distância e um custo.

**Atributos:**

- `destino`: Cidade de destino.
- `distancia`: Distância da estrada.
- `custo`: Custo da estrada.

**Construtor:**

- Inicializa a estrada com a cidade de destino, a distância e o custo.

---

### 3. Grafo

A classe `Grafo` representa o grafo de cidades e estradas, esta classe contém métodos para manipular o grafo e encontrar rotas.

**Atributos:**

- `cidades`: Mapa das cidades no grafo (chave: nome da cidade, valor: objeto `Cidade`).

**Métodos principais:**

- **`adicionarCidade(String nome)`**
    - Adiciona uma nova cidade ao grafo.
    - **Parâmetro:** Nome da cidade.

- **`adicionarEstrada(String origem, String destino, int distancia, int custo)`**
    - Adiciona uma estrada entre duas cidades.
    - **Parâmetros:** Cidade de origem, cidade de destino, distância e custo.

- **`removerEstrada(String origem, String destino)`**
    - Remove uma estrada entre duas cidades.
    - **Parâmetros:** Cidade de origem e cidade de destino.

- **`encontrarCaminhoMaisCurto(String origem, String destino, int custoMaximo, Set<String> estradasBloqueadas)`**
    - Encontra o caminho mais curto entre duas cidades, considerando um custo máximo e estradas bloqueadas.
    - **Parâmetros:**
        - `origem`: Cidade de origem.
        - `destino`: Cidade de destino.
        - `custoMaximo`: Limite de custo permitido.
        - `estradasBloqueadas`: Conjunto de estradas bloqueadas.
    - **Processo:**
        1. Usa uma fila de prioridade para explorar as cidades por menor distância.
        2. Verifica custos e distâncias acumulados para atualizar o melhor caminho.
        3. Ignora estradas bloqueadas.
        4. Reconstrói o caminho do destino até a origem.

---

### 4. Main

A classe `Main` configura o grafo e executa exemplos de busca de rotas.
