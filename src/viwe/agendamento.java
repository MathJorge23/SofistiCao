
package viwe;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import jdbc.ConnectionFactory;
import jdbc.dao.ClienteDao;
import jdbc.model.Consulta;
import jdbc.service.ClienteService;


public class agendamento extends javax.swing.JFrame {
ClienteService cli;
Connection conexao;
Consulta c;
    public agendamento() {
        initComponents();

        cli = new ClienteService(new ClienteDao());
        c= new Consulta();
        conexao = new ConnectionFactory()
                .getConnectionUSBWebService();
        carregaTabela();
    }

    private void carregaTabela(){
        DefaultTableModel modelo= (DefaultTableModel) tblConsultas.getModel();
        modelo.setNumRows(0);
        
        tblConsultas.getColumnModel().getColumn(0).setPreferredWidth(80);//coluna de id
        tblConsultas.getColumnModel().getColumn(1).setPreferredWidth(40);//coluna nome
        tblConsultas.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblConsultas.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblConsultas.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblConsultas.getColumnModel().getColumn(5).setPreferredWidth(120);
        
        
       String query = "select * from consulta";

        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conexao.prepareStatement(query);
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                int idConsulta = resultado.getInt("id");
                int  idPet = resultado.getInt("petId");
                String servico = resultado.getString("servico");
                String funcionario =resultado.getString("funcionario");
                String dia =resultado.getString("dia");
                String hora = resultado.getString("hora");
                

                
                modelo.addRow(new Object[]{idConsulta,idPet, servico,funcionario,dia, hora});
            }
           
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
        
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        btnCriarAgendamento = new javax.swing.JButton();
        btnCadastros = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExluir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pet Shop");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pet Shop");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdConsulta", "IdPet", "Serviço", "Funcionario", "Data", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultas);

        btnCriarAgendamento.setText("Criar Agendamento");
        btnCriarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCriarAgendamentoMouseClicked(evt);
            }
        });

        btnCadastros.setText("Cadastros");
        btnCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrosMouseClicked(evt);
            }
        });

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
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnExluir.setText("Excluir");
        btnExluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCriarAgendamento)
                .addGap(18, 18, 18)
                .addComponent(btnCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrosMouseClicked
        this.setVisible(false);
           new cadastros().setVisible(true);
    }//GEN-LAST:event_btnCadastrosMouseClicked

    private void btnCriarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCriarAgendamentoMouseClicked
        this.setVisible(false);
           new criarAgendamento().setVisible(true);
    }//GEN-LAST:event_btnCriarAgendamentoMouseClicked

    private void tblConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultasMouseClicked
        int selecionado = tblConsultas.getSelectedRow();
        if(selecionado != -1){
            int id = (int) tblConsultas.getValueAt(selecionado, 0);
            c.setId(id);
         
        }
    }//GEN-LAST:event_tblConsultasMouseClicked

    private void btnExluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExluirMouseClicked
         
        cli.excluirConsulta(c.getId());
         
         this.setVisible(false);
        new agendamento().setVisible(true);
    }//GEN-LAST:event_btnExluirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
        UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
           //  FlatNightOwlContrastIJTheme.setup();
             
         }
        catch(Exception e){
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastros;
    private javax.swing.JButton btnCriarAgendamento;
    private javax.swing.JButton btnExluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
