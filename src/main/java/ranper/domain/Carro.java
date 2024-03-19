package ranper.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    public Carro() {
        this.acessorios = new ArrayList<Acessorio>();
    }
    @Id
    @GeneratedValue(generator = "carro_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_carro", sequenceName = "carro_seq", initialValue = 1,allocationSize = 1)
    Long id;
    @Column(name = "codigo", unique = true, length = 10, nullable = false)
    String codigo;
    @Column(name = "nome", length = 30, nullable = false)
    String nome;
    @Column(name = "ano", length = 4, nullable = false)
    Long ano;
    @Column(name = "preco", nullable = false)
    Long preco;
    @Column(name = "cor", nullable = false)
    String cor;
    @ManyToOne
    @JoinColumn(name = "id_carro_fk", foreignKey = @ForeignKey(name = "fk_carro_marca"),
    referencedColumnName = "id", nullable = false)
    Marca marca;
    @OneToMany(mappedBy = "carro")
    List<Acessorio> acessorios;

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

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void add (Acessorio acessorio){
        this.acessorios.add(acessorio);
    }
}
