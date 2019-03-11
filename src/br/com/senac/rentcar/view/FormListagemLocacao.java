package br.com.senac.rentcar.view;

import br.com.senac.rentcar.dao.LocacaoDAO;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import br.com.senac.rentcar.model.LocacaoTableModel;
import br.com.senac.rentcar.model.Locacao;
import br.com.senac.rentcar.util.Utilidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class FormListagemLocacao extends javax.swing.JFrame {

    private LocacaoTableModel locacaoTableModel;

    public FormListagemLocacao() {
        initComponents();
        Utilidades.setaIconeJFrame(this);
        this.setLocationRelativeTo(null);
        setResizable(false);
        prepararTable();
    }

    private void prepararTable() {
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        ArrayList<Locacao> arrayLocacoes = new ArrayList<>();
        arrayLocacoes = locacaoDAO.getlist();
        //pesquisar clientes cadastrados no banco de dados
        locacaoTableModel = new LocacaoTableModel(arrayLocacoes);
        tabelaLocacoes.setModel(locacaoTableModel);
        setarCaracteristicasTabela();
    }

    private void setarCaracteristicasTabela() {

        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
        tcr2.setHorizontalAlignment(JLabel.CENTER);
        this.tabelaLocacoes.getColumnModel().getColumn(0).setCellRenderer(tcr2);
        this.tabelaLocacoes.getColumnModel().getColumn(2).setCellRenderer(tcr2);
        this.tabelaLocacoes.getColumnModel().getColumn(4).setCellRenderer(tcr2);
        this.tabelaLocacoes.getColumnModel().getColumn(5).setCellRenderer(tcr2);
        DefaultTableCellRenderer tcr3 = new DefaultTableCellRenderer();
        tcr3.setHorizontalAlignment(JLabel.RIGHT);
        this.tabelaLocacoes.getColumnModel().getColumn(6).setCellRenderer(tcr3);

        this.tabelaLocacoes.getColumnModel().getColumn(0).setMinWidth(120);
        this.tabelaLocacoes.getColumnModel().getColumn(0).setMaxWidth(120);

        this.tabelaLocacoes.getColumnModel().getColumn(1).setMinWidth(160);
        this.tabelaLocacoes.getColumnModel().getColumn(1).setMaxWidth(160);

        this.tabelaLocacoes.getColumnModel().getColumn(2).setMinWidth(80);
        this.tabelaLocacoes.getColumnModel().getColumn(2).setMaxWidth(80);

        this.tabelaLocacoes.getColumnModel().getColumn(3).setMinWidth(140);
        this.tabelaLocacoes.getColumnModel().getColumn(3).setMaxWidth(140);

        this.tabelaLocacoes.getColumnModel().getColumn(4).setMinWidth(80);
        this.tabelaLocacoes.getColumnModel().getColumn(4).setMaxWidth(80);

        this.tabelaLocacoes.getColumnModel().getColumn(5).setMinWidth(80);
        this.tabelaLocacoes.getColumnModel().getColumn(5).setMaxWidth(80);

        this.tabelaLocacoes.getColumnModel().getColumn(6).setMinWidth(80);
        this.tabelaLocacoes.getColumnModel().getColumn(6).setMaxWidth(80);

        //seleção para a linha inteira
        this.tabelaLocacoes.setCellSelectionEnabled(false);
        this.tabelaLocacoes.setRowSelectionAllowed(true);
        //selecionar apenas uma linha
        this.tabelaLocacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaLocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaLocacoes.setToolTipText("");
        jScrollPane1.setViewportView(tabelaLocacoes);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relação de Locações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void atualizarTabela() {
        locacaoTableModel.atualizaTabela();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormListagemLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListagemLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListagemLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListagemLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListagemLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLocacoes;
    // End of variables declaration//GEN-END:variables
}
