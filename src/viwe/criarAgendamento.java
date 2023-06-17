
package viwe;
import com.formdev.flatlaf.FlatIconColors;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.extras.FlatDesktop;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.ui.FlatArrowButton;
import java.awt.Component;
import javax.swing.UIManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import jdbc.ConnectionFactory;
import jdbc.dao.ClienteDao;

import jdbc.model.Consulta;
import jdbc.model.Pet;
import jdbc.service.ClienteService;

public class criarAgendamento extends javax.swing.JFrame {
    private Pet pet;
    private Consulta con;
    Connection conexao;
    ClienteService cli;

    public criarAgendamento() {
      pet= new Pet();
      con = new Consulta();
      conexao = new ConnectionFactory()
                .getConnectionUSBWebService();
      cli = new ClienteService(new ClienteDao());
        initComponents();
        carregaComboBox();
    }
    
private void carregaComboBox() {
    DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();
    String query = "SELECT nome , id from pet";

    PreparedStatement consulta = null;
    ResultSet resultado = null;
    try {
        consulta = conexao.prepareStatement(query);
        resultado = consulta.executeQuery();
        while (resultado.next()) {
            String pet = resultado.getString("nome");
            String id = resultado.getString("id");
            String dados = "ID:" + " " + id + " - " + "NOME: " + pet;
            modeloCombo.addElement(dados);
                  
        }

        comboPet.setModel(modeloCombo);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        criarAgendamento = new javax.swing.JButton();
        btnCancelCadastro = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dataAgendamento = new com.toedter.calendar.JDateChooser();
        comboSer = new javax.swing.JComboBox<>();
        comboFunc = new javax.swing.JComboBox<>();
        comboPet = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Pet: ");

        jLabel5.setText("Serviço:");

        jLabel7.setText("Funcionario:");

        jLabel8.setText("Data");

        criarAgendamento.setText("Criar ");
        criarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                criarAgendamentoMouseClicked(evt);
            }
        });

        btnCancelCadastro.setText("Cancelar");
        btnCancelCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelCadastroMouseClicked(evt);
            }
        });

        jButton4.setText("Limpar");

        jPanel6.setBackground(new java.awt.Color(153, 204, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setForeground(new java.awt.Color(153, 204, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(145, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pet Shop");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        dataAgendamento.setDateFormatString("d '/' MMM '/' y");
        dataAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataAgendamentoMouseClicked(evt);
            }
        });

        comboSer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECIONE--", "PetShop - Banho e Tosa", "Veterinario" }));

        comboFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECIONE--", "Enzo - Pet", "Valentina - Vet" }));

        comboPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Hora:");

        comboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(criarAgendamento)
                        .addGap(45, 45, 45)
                        .addComponent(btnCancelCadastro)
                        .addGap(49, 49, 49)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSer, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPet, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(comboFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(criarAgendamento)
                    .addComponent(jButton4)
                    .addComponent(btnCancelCadastro))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dataAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataAgendamentoMouseClicked

    }//GEN-LAST:event_dataAgendamentoMouseClicked

    private void btnCancelCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelCadastroMouseClicked
        this.setVisible(false);
           new agendamento().setVisible(true);
    }//GEN-LAST:event_btnCancelCadastroMouseClicked

    private void criarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_criarAgendamentoMouseClicked
        Date data = dataAgendamento.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(data);
        
        String  idPet  = comboPet.getSelectedItem().toString();
        String servico= comboSer.getSelectedItem().toString();
        String petId = idPet.replaceAll("[^0-9]", "");
        String hora =comboHora.getSelectedItem().toString();
        int id = Integer.parseInt(petId);
        
        con.setData(dataFormatada);
        con.setPetId(id);
        con.setHora(hora);
        
        
        if ( servico.equals("PetShop - Banho e Tosa") ){
            con.setFuncionario("Enzo");
            con.setServico("Banho e Tosa");
            cli.criarConsulta(con);
            this.setVisible(false);
            new agendamento().setVisible(true);
            
        }
         
        else if ( servico.equals("Veterinario")){
          //cadastrar serviço de veterinario
          con.setFuncionario("Valentina");
          con.setServico("Veterinario");
          cli.criarConsulta(con);
          this.setVisible(false);
            new agendamento().setVisible(true);
            
        }
        
        
       

    }//GEN-LAST:event_criarAgendamentoMouseClicked

    
    public static void main(String args[]) {
        
         try{
        UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
            // FlatNightOwlContrastIJTheme.setup();
             
         }
        catch(Exception e){
            e.printStackTrace();
        }

       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criarAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelCadastro;
    private javax.swing.JComboBox<String> comboFunc;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox<String> comboPet;
    private javax.swing.JComboBox<String> comboSer;
    private javax.swing.JButton criarAgendamento;
    private com.toedter.calendar.JDateChooser dataAgendamento;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
