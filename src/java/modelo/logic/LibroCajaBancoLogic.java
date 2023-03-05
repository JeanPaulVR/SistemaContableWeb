package modelo.logic;

import java.util.List;
import modelo.beans.LibroCajaBanco;
import modelo.dao.LibroCajaBancoDao;

public class LibroCajaBancoLogic {
   
    private String msj;

    private LibroCajaBancoDao daoLCB = new LibroCajaBancoDao();

    private LibroCajaBanco beansLCB = new LibroCajaBanco(); 
    
    public List Listarbancos() {

        List<LibroCajaBanco> lcb;

        lcb = daoLCB.listarbancos();

        return lcb;

    }
}
