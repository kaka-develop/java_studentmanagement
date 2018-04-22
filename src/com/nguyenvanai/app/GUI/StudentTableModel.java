
package com.nguyenvanai.app.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.nguyenvanai.app.models.Student;

@SuppressWarnings("serial")
public class StudentTableModel extends AbstractTableModel {

	
	private ApplicationAssistant assistant = ApplicationAssistant.getInstance();
	private static final String[] COLUMN_NAMES = new String[] { "ID", "Name", "Email", "Batch", "Major", "update",
			"delete" };
	private static final Class<?>[] COLUMN_TYPES = new Class<?>[] { JButton.class, String.class,
			String.class, String.class, String.class, JButton.class, JButton.class };

	private Student[] students;
	
	

	public StudentTableModel() {
		this.students = assistant.studentsToArray();
	}
	public StudentTableModel(Student[] students) {
		this.students = students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
		this.fireTableDataChanged();
	}

	public void notifyChanged() {
		this.students = assistant.studentsToArray();
		this.fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return students.length;
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;

	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column]; // To change body of generated methods,
										// choose Tools | Templates.
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_TYPES[columnIndex]; // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Student stu = students[rowIndex];
		
		switch (columnIndex) {
		case 0:
			JButton btn_info = new JButton(stu.getId());
			btn_info.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new StudentDetailDialog(stu).show(stu.getName(),btn_info);
				}
			});
			return btn_info;
		case 1:
			return stu.getName();
		case 2:
			return stu.getEmail();
		case 3:
			return assistant.getBatchByID(stu.getBatchId()).getName();
		case 4:
			return assistant.getMajorByID(stu.getMajorId()).getName();
		case 5:
			JButton btn_update = new JButton("update");
			btn_update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(new StudentDialog(stu).show("Update Student", btn_update)) {
						notifyChanged();
					}
				}
			});
			return btn_update;
		case 6:
			JButton btn_del = new JButton("delete");
			btn_del.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (assistant.deleteStudent(stu.getId())) {
						notifyChanged();
					}
				
					// JOptionPane.showMessageDialog(null, "Can not delete the
					// studuct that is existed in Ordering", "Error!",
					// JOptionPane.ERROR_MESSAGE);

				}
			});
			return btn_del;
		default:
			return "Error";
		}
	}
}
