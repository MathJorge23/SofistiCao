package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Cliente;
import jdbc.model.Consulta;
import jdbc.model.Endereco;
import jdbc.model.Pet;

/**
 *
 * @author edson
 */
public interface IDao {
    public ArrayList<Cliente> consultar();
    public Cliente consultar(int id);
    public Cliente cadastrar(Cliente cliente, Endereco endereco);
    public Pet cadastarPet(Pet pet);
    public boolean excluir(int id);
    public String alterarCliente(Cliente cliente, int id);
    public String alterarEndereco(Endereco endereco, int id);
    public boolean excluirEndereco(int cliente_id);
    public boolean excluirPet(int cliente_id);
    public Endereco adicionarEndereco(int id,Endereco endereco);
    public Consulta criarConsulta ( Consulta consulta);
    public boolean excluirConsulta (int idConsulta);
}
