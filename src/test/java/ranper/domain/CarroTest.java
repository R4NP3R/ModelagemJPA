package ranper.domain;

import org.junit.Assert;
import org.junit.Test;
import ranper.dao.AcessorioDao;
import ranper.dao.CarroDao;
import ranper.dao.MarcaDao;

public class CarroTest {

    MarcaDao marcaDao;
    CarroDao carroDao;
    AcessorioDao acessorioDao;


    public CarroTest(){
        this.marcaDao = new MarcaDao();
        this.carroDao = new CarroDao();
        this.acessorioDao = new AcessorioDao();
    }


    @Test
    public void cadastrarCarro() {
        Carro carro = new Carro();
        Marca marca = criarMarca();
        Acessorio acessorio = criarAcessorio("A01", "Teto solar");
        Acessorio acessorio2 = criarAcessorio("A02", "Spoiler");

        carro.setCodigo("L01");
        carro.setMarca(marca);
        carro.setNome("Lancer");
        carro.setAno(2019L);
        carro.setPreco(75000L);
        carro.setCor("Preto");
        carro.add(acessorio);
        carro.add(acessorio2);
        carroDao.cadastrar(carro);


        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());
    }

    private Marca criarMarca() {
        Marca marca = new Marca();
        marca.setCodigo("M01");
        marca.setNome("Mitsubishi");

        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String codigo, String nome) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome(nome);

        return acessorio;
    }

}
