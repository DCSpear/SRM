/**
 * @author Software Design Group 1
 * ALLEN VAN DIEMAN
 * ANTHONY NDUBUISI JUNIOR JOSEPH
 */

package designsystem;

//Import Display formatting Libraries
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.ImageIcon;

//Import MySQL Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public final class Login extends javax.swing.JFrame {

    //Instance Variables where textbox info get saved
    String uname;
    String pword;
    int accessIndex;
    
    //Instance Variables for database
    private static final String username = "<database username>";
    private static final String password = "<database password>";
    private static final String database = "jdbc:mysql://<database ip>:3306/<DATABASE>";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //Table row and col count variables
    int qqq, iii;
   
    //Default Constructor setting up Page
    public Login() {
        initComponents();
        
        //centre page to screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        //load database table to local table
        upDateDB();
        jTable.getTableHeader().setReorderingAllowed(false);
        
        //set icon
        Image img=new ImageIcon(this.getClass().getResource("/CPUT icon.jpg")).getImage();
        this.setIconImage(img);
        
    }
    
    // database update function
    public void upDateDB(){
	try
	{
            //connect to remote database
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(database,username,password);
            pst = sqlConn.prepareStatement("select * from loginData");
            
            //Send MySQL command to database
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            //set Column count and table layout
            qqq = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)jTable.getModel();
            RecordTable.setRowCount(0);

            //load database table to local table
            while(rs.next())
                {
                    Vector columnData = new Vector();

                    for(iii = 1; iii <= qqq; iii++)
                    	{
                            columnData.add(rs.getString("username")); //depends on colum count
                            columnData.add(rs.getString("password")); //depends on colum count
                            columnData.add(rs.getString("access")); //depends on colum count
			}
		RecordTable.addRow(columnData);
		}
	}
	catch(ClassNotFoundException | SQLException ex)
	{
            //catch and print errors to screen
		JOptionPane.showMessageDialog(null, ex);
	}
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
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLUsername = new javax.swing.JLabel();
        jLPassword = new javax.swing.JLabel();
        jTFUsername = new javax.swing.JTextField();
        jTFPassword = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jBLogin = new javax.swing.JButton();
        jBChangePassword = new javax.swing.JButton();
        jBShowPassword = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 342, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/R.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 400, 390));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/R2.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 120));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "username", "password", "access"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setEnabled(false);
        jTable.setFocusable(false);
        jTable.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 10, 10));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 36)); // NOI18N
        jLabel1.setText("      LOGIN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, 260, 35));

        jLUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLUsername.setText("Username");
        jPanel2.add(jLUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 162, -1, -1));

        jLPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLPassword.setText("Password");
        jPanel2.add(jLPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 240, -1, -1));

        jTFUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFUsernameMouseClicked(evt);
            }
        });
        jTFUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFUsernameKeyPressed(evt);
            }
        });
        jPanel2.add(jTFUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 159, 150, -1));

        jTFPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFPasswordMouseClicked(evt);
            }
        });
        jPanel2.add(jTFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 237, 150, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Student" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 289, 91, -1));

        jBLogin.setText("Login");
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });
        jPanel2.add(jBLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 90, -1));

        jBChangePassword.setText("Change password");
        jBChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBChangePasswordActionPerformed(evt);
            }
        });
        jPanel2.add(jBChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jBShowPassword.setText("Show Password");
        jBShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBShowPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(jBShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/R.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jBChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBChangePasswordActionPerformed
       
        //set index to -1 for username not found
        int index = -1;
        //get number of rows in table to search
        int rows = jTable.getRowCount();
        uname = jTFUsername.getText();
        pword = new String(jTFPassword.getPassword());
        
        //search for username
        for(int i = 0 ; i < rows ; i++)
        {
            if(jTable.getValueAt(i, 0).toString() == null ? uname == null : jTable.getValueAt(i, 0).toString().equals(uname))
            {
                index = i;
                break;
            }
        }
        //-1 for username not found
        if(index==-1)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Username " + uname + " not found!","Error",JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            if(pword == null ? jTable.getValueAt(index, 1).toString() == null : pword.equals(jTable.getValueAt(index, 1).toString()))
            {
                //password match load with username and password as arguments
                ChangePasswordSystem cp=new ChangePasswordSystem(uname , pword);
                cp.setLocationRelativeTo(null);
                cp.setVisible(true);
                this.dispose(); 
                
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Invalid password!","Error",JOptionPane.ERROR_MESSAGE );
            }
        }
         
    }//GEN-LAST:event_jBChangePasswordActionPerformed

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
        //set index to -1 for username not found
        int index = -1;
        //get number of rows in table to search
        int rows = jTable.getRowCount();
        uname = jTFUsername.getText();
        pword = new String(jTFPassword.getPassword());
        
        // 0 for admin 1 for student
        accessIndex = jComboBox1.getSelectedIndex();
        
        //search table to see if user has admin/user access
        for(int i = 0 ; i < rows ; i++)
        {
            if(jTable.getValueAt(i, 0).toString() == null ? uname == null : jTable.getValueAt(i, 0).toString().equals(uname))
            {
                index = i;
                break;
            }
        }
        
        //check if user is found then decide how SMS page is loaded
        if(index==-1)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Username " + uname + " not found!","Error",JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            if(pword == null ? jTable.getValueAt(index, 1).toString() == null : pword.equals(jTable.getValueAt(index, 1).toString()))
            {
                if(accessIndex==0 && "admin".equals(jTable.getValueAt(index, 2).toString()))
                {
                    //load as admin
                    StudentManagementSystem ds=new StudentManagementSystem(accessIndex);
                    ds.setLocationRelativeTo(null);
                    ds.setVisible(true);
                    this.dispose();
                }
                else if(accessIndex==0 && "user".equals(jTable.getValueAt(index, 2).toString()))
                {
                    //error then load as non admin
                    jComboBox1.setSelectedIndex(1);
                    accessIndex = 1;
                    javax.swing.JOptionPane.showMessageDialog(this, uname + " please log in as STUDENT","Error",JOptionPane.ERROR_MESSAGE );
                    
                    StudentManagementSystem ds=new StudentManagementSystem(accessIndex);
                    ds.setLocationRelativeTo(null);
                    ds.setVisible(true);
                    this.dispose();
                    
                }
                else
                {
                    //load as non admin
                    StudentManagementSystem ds=new StudentManagementSystem(accessIndex);
                    ds.setLocationRelativeTo(null);
                    ds.setVisible(true);
                    this.dispose();
                }
                
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Invalid password!","Error",JOptionPane.ERROR_MESSAGE );
            }
        }  
        
    }//GEN-LAST:event_jBLoginActionPerformed

    private void jTFUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUsernameMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTFUsernameMouseClicked

    private void jTFPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPasswordMouseClicked

    private void jTFUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsernameKeyPressed

    private void jBShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBShowPasswordActionPerformed
       if(jBShowPassword.isSelected()){
            jTFPassword.setEchoChar((char)0);
        }
        else{
            jTFPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jBShowPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jBChangePassword;
    private javax.swing.JButton jBLogin;
    private javax.swing.JRadioButton jBShowPassword;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField jTFPassword;
    private javax.swing.JTextField jTFUsername;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}