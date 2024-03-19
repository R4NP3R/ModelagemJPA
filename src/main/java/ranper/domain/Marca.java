package ranper.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    public Marca() {
        this.carros = new ArrayList<Carro>();
    }
    @Id
    @GeneratedValue(generator ="marca_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
    Long id;
    @Column(name= "codigo", length = 10, nullable = false, unique = true)
    String codigo;
    @Column(name= "nome", length = 30, nullable = false)
    String nome;
    @OneToMany(mappedBy = "marca")
    List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
