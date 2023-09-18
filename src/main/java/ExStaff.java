
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pabon
 */
public class ExStaff extends javax.swing.JFrame {

    /**
     * Creates new form ExStaff
     */
    public ExStaff() {
        initComponents();
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
        ExStaff_Table = new javax.swing.JTable();
        join_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ExStaff_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StaffID", "FirstName", "LastName", "StatingTime", "EndingTime", "HallName", "Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ExStaff_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ExStaff_Table);
        if (ExStaff_Table.getColumnModel().getColumnCount() > 0) {
            ExStaff_Table.getColumnModel().getColumn(0).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(1).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(2).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(3).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(4).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(5).setResizable(false);
            ExStaff_Table.getColumnModel().getColumn(6).setResizable(false);
        }

        join_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        join_button.setText("Hall");
        join_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                join_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Join With");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(join_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(join_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void join_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_join_buttonActionPerformed
        
        String query = "SELECT * from Hall INNER JOIN ExStaff ON Hall.HallName = ExStaff.HallName";
      
            int itr = 0;
            
            String [][]info = new String [1000][10]; 
            
          try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
    
                   
            rs = ps.executeQuery();  
            
           
          
          
         while(rs.next()){
               
         String []data = new String [10];
               
              
        info[itr][0]= rs.getString("HallName");
        info[itr][1]= rs.getString("HallType");
        info[itr][2]= rs.getString("TotalSeat");
              
        info[itr][3]= rs.getString("StaffID");
        info[itr][4]= rs.getString("FirstName");
        info[itr][5]= rs.getString("LastName");
        info[itr][6]= rs.getString("StartingTime");
        info[itr][7]= rs.getString("EndingTime");
        info[itr][8]= rs.getString("HallName");
        info[itr][9]= rs.getString("Salary");
      
                 
        itr++;
        
      
//JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
      
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       
   
        new ExStaffJoinHall(info,itr).setVisible(true);
        setVisible(false);
          System.out.println(itr);// TODO add your handling code here:
    }//GEN-LAST:event_join_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(ExStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ExStaff_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton join_button;
    // End of variables declaration//GEN-END:variables
}