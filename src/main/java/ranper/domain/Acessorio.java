package ranper.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    @Id
    @GeneratedValue(generator = "acessorio_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_acessorio", sequenceName = "acessorio_seq", initialValue = 1, allocationSize = 1)
    Long id;
    @Column(name = "codigo", length = 10, unique = true, nullable = false)
    String codigo;
    @Column(name = "nome", length = 50, nullable = false)
    String nome;

    @ManyToOne
    @JoinColumn(name = "id_acessorio_fk", foreignKey = @ForeignKey(name ="fk_acessorio_carro"), nullable = false)
    Carro carro;

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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
