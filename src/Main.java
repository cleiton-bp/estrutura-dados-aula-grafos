import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        // Adiciona cidades ao grafo
        grafo.adicionarCidade("A");
        grafo.adicionarCidade("B");
        grafo.adicionarCidade("C");
        grafo.adicionarCidade("D");
        grafo.adicionarCidade("E");

        // Adiciona estradas ao grafo
        grafo.adicionarEstrada("A", "B", 10, 5);
        grafo.adicionarEstrada("B", "C", 20, 15);
        grafo.adicionarEstrada("C", "E", 25, 10);
        grafo.adicionarEstrada("B", "D", 30, 20);
        grafo.adicionarEstrada("A", "E", 50, 40);

        // Exemplo 1: Sem estradas bloqueadas, custo máximo 30
        Set<String> estradasBloqueadas1 = new HashSet<>();
        List<String> caminho1 = grafo.encontrarCaminhoMaisCurto("A", "E", 30, estradasBloqueadas1);
        System.out.println("Exemplo 1: Caminho: " + caminho1);
        System.out.println(" ---------------------------------------------");

        // Exemplo 2: Estrada B-C bloqueada, custo máximo 30
        Set<String> estradasBloqueadas2 = new HashSet<>();
        estradasBloqueadas2.add("B-C");
        List<String> caminho2 = grafo.encontrarCaminhoMaisCurto("A", "E", 30, estradasBloqueadas2);
        System.out.println("Exemplo 2: Caminho: " + caminho2);
        System.out.println(" ---------------------------------------------");

        // Exemplo 3: Estrada A-B bloqueada, custo máximo 30
        Set<String> estradasBloqueadas3 = new HashSet<>();
        estradasBloqueadas3.add("A-B");
        List<String> caminho3 = grafo.encontrarCaminhoMaisCurto("A", "E", 30, estradasBloqueadas3);
        System.out.println("Exemplo 3: Caminho: " + caminho3);
        System.out.println(" ---------------------------------------------");

        // Exemplo 4: Sem estradas bloqueadas, custo máximo 15
        Set<String> estradasBloqueadas4 = new HashSet<>();
        List<String> caminho4 = grafo.encontrarCaminhoMaisCurto("A", "E", 15, estradasBloqueadas4);
        System.out.println("Exemplo 4: Caminho: " + caminho4);
        System.out.println(" ---------------------------------------------");

        // Exemplo 5: Estrada B-D bloqueada, custo máximo 50
        Set<String> estradasBloqueadas5 = new HashSet<>();
        estradasBloqueadas5.add("B-D");
        List<String> caminho5 = grafo.encontrarCaminhoMaisCurto("A", "E", 50, estradasBloqueadas5);
        System.out.println("Exemplo 5: Caminho: " + caminho5);
        System.out.println(" ---------------------------------------------");
    }
}

