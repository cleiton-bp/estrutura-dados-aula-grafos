import java.util.*;

public class Grafo {
    private final Map<String, Cidade> cidades = new HashMap<>();

    public void adicionarCidade(String nome) {
        cidades.put(nome, new Cidade(nome));
    }

    public void adicionarEstrada(String origem, String destino, int distancia, int custo) {
        Cidade cidadeOrigem = cidades.get(origem);
        Cidade cidadeDestino = cidades.get(destino);
        cidadeOrigem.estradas.add(new Estrada(cidadeDestino, distancia, custo));
    }

    public List<String> encontrarCaminhoMaisCurto(String origem, String destino, int custoMaximo, Set<String> estradasBloqueadas) {
        PriorityQueue<Nodo> fila = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, Integer> custos = new HashMap<>();
        Map<String, String> anteriores = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        for (String cidade : cidades.keySet()) {
            distancias.put(cidade, Integer.MAX_VALUE);
            custos.put(cidade, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        custos.put(origem, 0);

        fila.add(new Nodo(origem, 0, 0));

        while (!fila.isEmpty()) {
            Nodo atual = fila.poll();
            if (visitados.contains(atual.cidade)) continue;

            visitados.add(atual.cidade);
            Cidade cidadeAtual = cidades.get(atual.cidade);

            for (Estrada estrada : cidadeAtual.estradas) {
                String chaveEstrada = atual.cidade + "-" + estrada.destino.nome;

                if (estradasBloqueadas.contains(chaveEstrada)) continue;

                int novaDistancia = atual.distancia + estrada.distancia;
                int novoCusto = atual.custo + estrada.custo;

                if (novoCusto <= custoMaximo && novaDistancia < distancias.get(estrada.destino.nome)) {
                    distancias.put(estrada.destino.nome, novaDistancia);
                    custos.put(estrada.destino.nome, novoCusto);
                    anteriores.put(estrada.destino.nome, atual.cidade);
                    fila.add(new Nodo(estrada.destino.nome, novaDistancia, novoCusto));
                }
            }
        }

        List<String> caminho = new ArrayList<>();
        for (String cidade = destino; cidade != null; cidade = anteriores.get(cidade)) {
            caminho.add(cidade);
        }
        Collections.reverse(caminho);

        if (distancias.get(destino) == Integer.MAX_VALUE) {
            return Collections.singletonList("Nenhuma rota viável encontrada dentro do limite de custo.");
        }

        return caminho;
    }

    private static class Nodo {
        String cidade;
        int distancia;
        int custo;

        Nodo(String cidade, int distancia, int custo) {
            this.cidade = cidade;
            this.distancia = distancia;
            this.custo = custo;
        }
    }
}