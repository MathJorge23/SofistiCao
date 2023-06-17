package jdbc.service;

import java.util.ArrayList;
import jdbc.dao.ClienteDao;
import jdbc.model.Cliente;
import jdbc.model.Consulta;
import jdbc.model.Endereco;
import jdbc.model.Pet;

public class ClienteService {
    private ClienteDao clienteDao;
    
    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
    public ArrayList<Cliente> consultar(){
        return clienteDao.consultar();
    }
    public Cliente consultar(int id){
        return clienteDao.consultar(id);       
    }
    public Cliente cadastrar(Cliente cliente, Endereco endereco){
        return clienteDao.cadastrar(cliente,endereco );
    }
    
    public Pet cadastrarPet (Pet pet){
        return clienteDao.cadastarPet(pet);
    }
    
    public boolean excluir(int id){
        return clienteDao.excluir(id);
    }
    public String alterarCliente(Cliente cliente, int id){
        return clienteDao.alterarCliente(cliente, id);
    }
    
    public String alterarEndereco(Endereco endereco, int id){
        return clienteDao.alterarEndereco(endereco, id);
    }
    
    public boolean excluirEndereco(int cliente_id){
        return clienteDao.excluirEndereco(cliente_id);
    }
    
    public boolean excluirPet(int cliente_id){
        return clienteDao.excluirPet(cliente_id);
    }
    public Endereco adicionarEndereco(int id, Endereco endereco){
        return clienteDao.adicionarEndereco(id, endereco);
    }
    
    public Consulta criarConsulta ( Consulta consulta){
        return clienteDao.criarConsulta(consulta);
    }
    
    public boolean excluirConsulta (int id){
        return clienteDao.excluirConsulta(id);
    }
    
}
