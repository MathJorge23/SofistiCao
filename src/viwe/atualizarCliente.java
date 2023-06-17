
package viwe;



import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import jdbc.ConnectionFactory;
import jdbc.dao.ClienteDao;
import jdbc.model.Cliente;
import jdbc.model.Endereco;
import jdbc.service.ClienteService;

public class atualizarCliente extends javax.swing.JFrame {
    Cliente c, cliente;
    ClienteService cli;
    Endereco e, end;
    Connection conexao;
    int id;
    
    public atualizarCliente() {
      initComponents();
      c = new Cliente();
      cli = new ClienteService(new ClienteDao());
      e= new Endereco();
      cliente = new Cliente();
      end= new Endereco();
      
      
      conexao = new ConnectionFactory()
                .getConnectionUSBWebService();
      setInfoCliente(id);
      
 
      
   }

   public void setInfoCliente(int id){
       String query = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;
        
        String queryEndereco = "SELECT * FROM endereco WHERE cliente_id = ?";
        PreparedStatement preparedStatementEndereco = null;
        
        try {
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setNascimento(resultado.getString("nascimento")); 

                edtNomeCliente.setText(c.getNome());
                edtCpf.setText(c.getCpf());
                edtEmail.setText(c.getEmail());
                edtTelefone.setText(c.getTelefone());
                edtNascimento.setText(c.getNascimento());
              // seta informações endereco
                try {
            preparedStatementEndereco = conexao.prepareStatement(queryEndereco);
            preparedStatementEndereco.setInt(1, id);
            resultado = preparedStatementEndereco.executeQuery();
            if (resultado.next()) {
                e.setRua(resultado.getString("rua"));
                e.setBairro(resultado.getString("bairro"));
                e.setNumero(resultado.getString("numero"));
                e.setCidade(resultado.getString("cidade"));
             
                edtRua.setText(e.getRua());
                edtCidade.setText(e.getCidade());
                edtBairro.setText(e.getBairro());
                edtNumero.setText(e.getNumero());
               
            }
         
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
            }
         
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }    
   }
   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtNascimento = new javax.swing.JTextField();
        edtCpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtNomeCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        edtTelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        edtRua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        edtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnCancelEdit = new javax.swing.JButton();
        edtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        edtBairro = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(153, 204, 0));
        jPanel5.setForeground(new java.awt.Color(153, 204, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(145, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pet Shop");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Endereço");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 130, -1));

        jLabel4.setText("Nome Completo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 101, -1));

        jLabel5.setText("CPF:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, -1));
        jPanel1.add(edtNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 129, 30));
        jPanel1.add(edtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 209, 30));

        jLabel6.setText("Data de Nascimento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel1.add(edtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 290, 30));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 274, -1, -1));

        jLabel8.setText("Telefone:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        jPanel1.add(edtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 209, 30));

        jLabel9.setText("Rua");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));
        jPanel1.add(edtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 78, 30));
        jPanel1.add(edtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 252, 30));

        jLabel10.setText("Número");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        edtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(edtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 110, 30));

        jLabel12.setText("Cidade");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        btnCancelEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.setPreferredSize(new java.awt.Dimension(75, 30));
        btnCancelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelEditMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));
        jPanel1.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 154, 220, 30));

        jLabel1.setText("Email:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Editar Cliente");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 100, -1));

        jLabel13.setText("Bairro:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 50, -1));
        jPanel1.add(edtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 200, 30));

        btnSalvar.setText("Atualizar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCidadeActionPerformed

    private void btnCancelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelEditMouseClicked
        this.setVisible(false);
        new cadastros().setVisible(true);
    }//GEN-LAST:event_btnCancelEditMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        cliente.setNome(edtNomeCliente.getText());
        cliente.setCpf(edtCpf.getText());
        cliente.setTelefone(edtTelefone.getText());
        cliente.setEmail(edtEmail.getText());
        cliente.setNascimento(edtNascimento.getText());
        end.setRua(edtRua.getText());
        end.setBairro(edtBairro.getText());
        end.setCidade(edtCidade.getText());
        end.setRua(edtNumero.getText());
        end.setNumero(edtNumero.getText());
      
                   
        cli.alterarCliente(cliente, cliente.getId());
        cli.alterarEndereco(end, cliente.getId());
         
        this.setVisible(false);
        new cadastros().setVisible(true);
    }//GEN-LAST:event_btnSalvarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         try{
        UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
            // FlatNightOwlContrastIJTheme.setup();
             
         }
        catch(Exception e){
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new atualizarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtBairro;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtNascimento;
    private javax.swing.JTextField edtNomeCliente;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtRua;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
