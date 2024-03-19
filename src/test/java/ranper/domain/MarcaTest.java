package ranper.domain;

import org.junit.Test;

import ranper.dao.MarcaDao;

public class MarcaTest {

    MarcaDao marcaDao;

    public MarcaTest () {
        this.marcaDao = new MarcaDao();
    }

    @Test
    public void cadastraMarca() {
        Marca marca = new Marca();

        marca.setNome("Mitsubish");
        marca.setCodigo("M01");

        marcaDao.cadastrar(marca);
    }

}
