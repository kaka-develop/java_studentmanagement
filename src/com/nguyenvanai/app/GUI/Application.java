
package com.nguyenvanai.app.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class Application extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private ApplicationAssistant assistant;
  
    private StudentTableModel tableModel_student;
   
    private StudentDialog studentDialog;
   

    public Application() {
    	assistant = ApplicationAssistant.getInstance();
        initComponents();
        loadStudentTab();
        
    }

    public void loadStudentTab() {

    	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
      
        tableModel_student = new StudentTableModel();
        table_student.setModel(tableModel_student);

        setStudentTable();
        
        studentDialog = new StudentDialog();
    }
    
    private void setStudentTable(){
    
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        
    	 table_student.getColumn("ID").setCellRenderer(buttonRenderer);
         table_student.getColumn("update").setCellRenderer(buttonRenderer);
         table_student.getColumn("delete").setCellRenderer(buttonRenderer);
         
         table_student.addMouseListener(new JTableButtonMouseListener(table_student));
    }

    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab_students = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_student = new javax.swing.JTable();
        btn_newStudent = new javax.swing.JButton();

    	addWindowListener(new java.awt.event.WindowAdapter() {
    	    @Override
    	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
    	        if (JOptionPane.showConfirmDialog(jTabbedPane1, 
    	            "Do you want to save data?", "Exit", 
    	            JOptionPane.YES_NO_OPTION,
    	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
    	        	assistant.saveData();
    	            System.exit(0);
    	        }
    	    }
    	});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_student);

        btn_newStudent.setText("New Student");
        btn_newStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newStudentActionPerformed(evt);
            }
        });
        
        btn_sortByID = new JButton();
        btn_sortByID.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel_student.setStudents(assistant.sortStudentByID());
        	}
        });
        btn_sortByID.setText("Sort By ID");
        
        btnSortByName = new JButton();
        btnSortByName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel_student.setStudents(assistant.sortStudentByName());
        	}
        });
        btnSortByName.setText("Sort By Name");

        javax.swing.GroupLayout gl_tab_students = new javax.swing.GroupLayout(tab_students);
        gl_tab_students.setHorizontalGroup(
        	gl_tab_students.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tab_students.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btn_newStudent)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btn_sortByID, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnSortByName, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        			.addGap(261))
        		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
        );
        gl_tab_students.setVerticalGroup(
        	gl_tab_students.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_tab_students.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_tab_students.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_tab_students.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btn_newStudent, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        					.addComponent(btn_sortByID, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnSortByName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
        );
        tab_students.setLayout(gl_tab_students);

        jTabbedPane1.addTab("Students", tab_students);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_newStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newStudentActionPerformed
        if (studentDialog.show(ApplicationAssistant.NEW_STUDENT,tab_students)) {
            tableModel_student.notifyChanged();
        }

    }//GEN-LAST:event_btn_newStudentActionPerformed

  
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
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_newStudent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tab_students;
    private javax.swing.JTable table_student;
    private JButton btn_sortByID;
    private JButton btnSortByName;
}
