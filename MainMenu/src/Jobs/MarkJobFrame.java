/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobs;

import username.Username;
import connection.DeleteWorkerJob;
import connection.SearchWorkerJob;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mainmenu.MainMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author sashankbajaru
 */
public class MarkJobFrame extends javax.swing.JFrame {

    /**
     * Creates new form MarkJobFrame
     */
    public MarkJobFrame() {
        initComponents();
        jButton4.setEnabled(true);
        jButton5.setBackground(new Color(0, 0, 0, 0));
        jButton6.setBackground(new Color(0, 0, 0, 0));
        //JFrame.setSize(1280,800);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jobs");

        jPanel1.setBackground(new java.awt.Color(81, 1, 90));
        jPanel1.setForeground(new java.awt.Color(87, 18, 149));

        jLabel1.setBackground(new java.awt.Color(147, 142, 204));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Work Management System- Jobs");
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTextField1.setText("Search Here...");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "jobID", "jobName", "jobDescription", "high", "low", "medium", "lat", "long", "startTime", "amount", "jobRating", "jobPriority", "voteCount", "Status", "Start Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

        jButton4.setText("Mark Completed");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(149, 79, 191));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton5.setBackground(new java.awt.Color(149, 79, 191));
        jButton5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Main Menu");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(149, 79, 191));
        jButton6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 254, 254));
        jButton6.setText("Jobs");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton5)
                .addComponent(jButton6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(357, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(427, 427, 427))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String s = jTextField1.getText();
        int count1 = -1, count2 = 0;
        //SearchWorkerJob j;
        SearchWorkerJob SearchConnector = null;
        try {
            SearchConnector = new SearchWorkerJob();
        } catch (Exception e) {

        }
        try {
            //SearchConnector=new SearchWorkerJob();
            int query = Integer.parseInt(s);
            count1 = SearchConnector.searchByIDJob(query, jTable1);
        } catch (Exception e) {
            System.out.println(e);
        }
        //if(count1==-1) count1=0;
        try {
            //SearchConnector=new SearchWorkerJob();
            count2 = SearchConnector.searchByQueryJob(s, jTable1, count1);
            if (count1 == -1) {
                count1 = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (count1 + count2 == 0) {
            jLabel2.setText("No results found!");
        } else {
            jLabel2.setText("Search Complete");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void deleteJob() {
        long id = (long) jTable1.getValueAt(0, 0);
        try {
            DeleteWorkerJob deleter = new DeleteWorkerJob();
            deleter.deleteIDJob((int) id, jTable1);

        } catch (Exception e) {
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int[] list_of_rows = jTable1.getSelectedRows();
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
                //int count=0;
                //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerDatabase","sashank","Hello$123");
        con = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"
                            + "user=" + Username.username + "&password=Hello$123");
        }
        catch(Exception e)
        {
            
        }

        for (int i = 0; i < list_of_rows.length; i++) {
            int id = Integer.parseInt(jTable1.getValueAt(list_of_rows[i], 0).toString());
            System.out.println("SUCCESS!"+id);
            try {
                System.out.println("SUCCESS!");
                String query = "UPDATE jobDatabase.jobTable1 SET jobStatus = ? WHERE jobID = ?;";
                st = con.prepareStatement(query);
                st.setInt(1, 2);
                st.setInt(2,id);
                System.out.println("IMP"+st.executeUpdate());
                
                System.out.println("YES");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        

        }
        
        JOptionPane.showMessageDialog(null, "Successfully marked selected jobs as complete!", "Marking Job as Complete", JOptionPane.INFORMATION_MESSAGE);
        try{
        con.close();
        }
        catch(Exception e)
        {}
        


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        if(jTextField1.getText().equals("Search Here..."))
            {
                jTextField1.setText("");
                repaint();
                revalidate();
            }           
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        jButton5.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setForeground(new Color(200,200,200));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setForeground(new Color(200,200,200));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(MarkJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkJobFrame().setVisible(true);
            }
        });
    }
    private Connection con;
    private PreparedStatement st;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
