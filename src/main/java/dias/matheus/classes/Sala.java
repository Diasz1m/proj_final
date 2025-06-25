package dias.matheus.classes;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sala {

    private Long id;

    private String nome;

    private Integer capacidade;

    public Sala() {}

    public Sala(Long id, String nome, Integer capacidade)
    {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
