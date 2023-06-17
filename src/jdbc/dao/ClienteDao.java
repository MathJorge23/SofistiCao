 package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Cliente;
import jdbc.model.Endereco;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import jdbc.model.Consulta;
import jdbc.model.Pet;


public class ClienteDao implements IDao {

    Connection conexao;

    public ClienteDao() {
        conexao = new ConnectionFactory()
                .getConnectionUSBWebService();
    }

    @Override
    public ArrayList<Cliente> consultar() {
        ArrayList<Cliente> lstClientes = new ArrayList<>();
        String query = "select * from cliente";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conexao.prepareStatement(query);
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setNascimento(resultado.getString("nascimento"));
                lstClientes.add(c);
            }
            return lstClientes;
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }

    }

    @Override
    public Cliente consultar(int id) {
        String query = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;
        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeQuery();
            Cliente c = new Cliente();
            if (resultado.next()) {
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setNascimento(resultado.getString("nascimento"));
                
            }
            return c;

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }

    }

    @Override
    public Cliente cadastrar(Cliente cliente, Endereco endereco) {
        String queryCliente = "insert into cliente (nome, cpf,nascimento,telefone, email) \n"
                + "values(?, ?, ?, ?, ?);";
        ResultSet resultado = null;
        try {
            PreparedStatement preparedStatementCliente = conexao.prepareStatement(queryCliente,
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementCliente.setString(1, cliente.getNome());
            preparedStatementCliente.setString(2, cliente.getCpf());
            preparedStatementCliente.setString(3, cliente.getNascimento());
            preparedStatementCliente.setString(4, cliente.getTelefone());
            preparedStatementCliente.setString(5, cliente.getEmail());
            
            preparedStatementCliente.executeUpdate();
            resultado = preparedStatementCliente.getGeneratedKeys();
           
            if (resultado.next()) {
                cliente.setId(resultado.getInt(1));
               
               String queryEndereco = "insert into endereco (cliente_id, rua, bairro, numero, cidade) \n"
                    +"values (?,?,?,?,?)";
                PreparedStatement preparedStatementEnderecp = conexao.prepareStatement(queryEndereco,
                    PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatementEnderecp.setInt(1, cliente.getId());
                preparedStatementEnderecp.setString(2, endereco.getRua());
                preparedStatementEnderecp.setString(3, endereco.getBairro());
                preparedStatementEnderecp.setString(4, endereco.getNumero());
                preparedStatementEnderecp.setString(5, endereco.getCidade());
            
                preparedStatementEnderecp.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro ok ");
            }
            return cliente;
            

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }
    
    @Override
    public boolean excluir(int id) {
        String query = "Delete from cliente where id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }

    }

    @Override
    public String alterarCliente(Cliente cliente, int id) {
        String query = "update cliente  set nome = ?,  cpf = ?, nascimento= ?, telefone = ?, email = ? "
                + " where id = "+ id;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getNascimento());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getEmail());
            

            if (preparedStatement.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Não atualizado";
            }

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }

    @Override
    public Pet cadastarPet(Pet pet) {
        String queryCliente = "insert into pet  (cliente_id, nome,raca,cor, porte) \n"
                            + "values(?, ?, ?, ?, ?);";
        ResultSet resultado = null;
        Cliente c = new Cliente ();
        try {
            PreparedStatement preparedStatementCliente = conexao.prepareStatement(queryCliente,
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementCliente.setInt(1, pet.getDonoId());
            preparedStatementCliente.setString(2, pet.getNome());
            preparedStatementCliente.setString(3, pet.getRaca());
            preparedStatementCliente.setString(4, pet.getCor());
            preparedStatementCliente.setString(5, pet.getPorte());
            
            preparedStatementCliente.executeUpdate();
            resultado = preparedStatementCliente.getGeneratedKeys();
           
            if (resultado.next()) {
                pet.setId(resultado.getInt(1));
 
                JOptionPane.showMessageDialog(null, "Cadastro pet ok ");
            }
            return pet;

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }

    @Override
    public boolean excluirEndereco(int cliente_id) {
        String query = "Delete from endereco where cliente_id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, cliente_id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }

    @Override
    public String alterarEndereco(Endereco endereco, int id) {
    String query = "UPDATE endereco SET rua = ?, bairro = ?, numero = ?, cidade = ? WHERE cliente_id = ?";
    try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        preparedStatement.setString(1, endereco.getRua());
        preparedStatement.setString(2, endereco.getBairro());
        preparedStatement.setString(3, endereco.getNumero());
        preparedStatement.setString(4, endereco.getCidade());
        preparedStatement.setInt(5, id);

        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            return "Atualizado com sucesso";
        } else {
            return "Não atualizado";
        }
    } catch (SQLException erro) {
        return "Erro ao atualizar o endereço: " + erro.getMessage();
    }
}

    @Override
    public boolean excluirPet(int cliente_id) {
      String query = "Delete from pet where cliente_id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, cliente_id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }  
    }

    @Override
    public Endereco adicionarEndereco(int id, Endereco endereco) {
        String queryEndereco = "insert into endereco (cliente_id, rua, bairro, numero, cidade) \n"
                    +"values (?,?,?,?,?)";
        ResultSet resultado = null;
        try {
                PreparedStatement preparedStatementEndereco = conexao.prepareStatement(queryEndereco,
                PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatementEndereco.setInt(1, id);
                preparedStatementEndereco.setString(2, endereco.getRua());
                preparedStatementEndereco.setString(3, endereco.getBairro());
                preparedStatementEndereco.setString(4, endereco.getNumero());
                preparedStatementEndereco.setString(5, endereco.getCidade());
            
                preparedStatementEndereco.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro ok ");
             
            return endereco;         

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }

    @Override
    public Consulta criarConsulta ( Consulta consulta) {
        String queryAgendamento = "insert into Consulta  (petId, servico, dia, funcionario, hora) \n"
                            + "values(?, ?, ?,?,?);";
        ResultSet resultado = null;
        try {
            PreparedStatement preparedStatementCliente = conexao.prepareStatement(queryAgendamento,
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementCliente.setInt(1, consulta.getPetId());
            preparedStatementCliente.setString(2, consulta.getServico());
            preparedStatementCliente.setString(3, consulta.getData());
            preparedStatementCliente.setString(4, consulta.getFuncionario());
            preparedStatementCliente.setString(5, consulta.getHora());

            preparedStatementCliente.executeUpdate();
            resultado = preparedStatementCliente.getGeneratedKeys();

            if (resultado.next()) {
                consulta.setId(resultado.getInt(1));
 
                JOptionPane.showMessageDialog(null, "Consulta criada ");
            }
            return consulta;

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        } 
    }

    @Override
    public boolean excluirConsulta(int idConsulta) {
      String query = "Delete from consulta where id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, idConsulta);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }

}
