import java.util.ArrayList;
import java.util.List;

public class Cidade {
    String nome;
    List<Estrada> estradas = new ArrayList<>();

    public Cidade(String nome) {
        this.nome = nome;
    }
}