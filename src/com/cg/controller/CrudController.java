package com.cg.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.cg.bean.CrudBean;
import com.cg.dao.CrudDao;
import com.cg.dao.CrudDaoImpl;
import com.cg.home.CrudHome;

public class CrudController implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton addBtn,backBtn,exitBtn,updBtn,delBtn,getBtn,searchBtn;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JFrame jf2,jf3,frame1,jf4;
	JPanel panel;
	JTable table;
	CrudDao cd1;
	CrudBean cb;
	CrudHome ch;
	public void addEmployee() {

		jf2=new JFrame();
		jf2.setTitle("Add Employee");
		jf2.setVisible(true);
		jf2.setSize(500, 500);
		jf2.setLayout(new GridLayout(5,1));
		jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("Employee Maintenance System",SwingConstants.CENTER);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel jp=new JPanel(new GridLayout(3,2));
        l2 = new JLabel("Enter Name:");
        tf1 = new JTextField();
        l3 = new JLabel("Enter Email:");
        tf2 = new JTextField();
        l4 = new JLabel("Enter PhoneNo:");
        tf3 = new JTextField();
        addBtn = new JButton("Add");
        backBtn = new JButton("Back");
        exitBtn = new JButton("Exit");
        jf2.add(l1);
        jp.add(l2);
        jp.add(tf1);
        jp.add(l3);
        jp.add(tf2);
        jp.add(l4);
        jp.add(tf3);
        jf2.add(jp);
        jf2.add(addBtn);
        jf2.add(backBtn);
        jf2.add(exitBtn);
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);
	}

	public void updateEmployee() {
		jf3=new JFrame();
		jf3.setTitle("Update Employee");
		jf3.setVisible(true);
		jf3.setSize(500, 500);
		jf3.setLayout(new GridLayout(7,1));
		jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l5 = new JLabel("Employee Maintenance System",SwingConstants.CENTER);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel jp1=new JPanel(new GridLayout(1,1));
        l6 = new JLabel("Enter Email:");
        tf4 = new JTextField();
        JPanel jp2=new JPanel(new GridLayout(2,2));
        l7 = new JLabel("Enter Name:");
        tf5 = new JTextField();
        l8 = new JLabel("Enter PhoneNo:");
        tf6 = new JTextField();
        searchBtn=new JButton("Search");
        updBtn = new JButton("Update");
        backBtn = new JButton("Back");
        exitBtn = new JButton("Exit");
        jf3.add(l5);
        jp1.add(l6);
        jp1.add(tf4);
        jp2.add(l7);
        jp2.add(tf5);
        jp2.add(l8);
        jp2.add(tf6);
        jf3.add(jp1);
        jf3.add(searchBtn);
        jf3.add(jp2);
        jf3.add(updBtn);
        jf3.add(backBtn);
        jf3.add(exitBtn);
        searchBtn.addActionListener(this);
        updBtn.addActionListener(this);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Add":
			cd1=new CrudDaoImpl();
			cb=new CrudBean();
			cb.setName(tf1.getText());
			cb.setEmail(tf2.getText());
			cb.setPhoneno(tf3.getText());
			int a=cd1.addEmployee(cb);
			if(a==1) {
				JOptionPane.showMessageDialog(null,"Employee Added Successfully");
				ch=new CrudHome();
			}
			else {
				JOptionPane optionPane = new JOptionPane("Failure", JOptionPane.ERROR_MESSAGE);
            	JDialog dialog = optionPane.createDialog("ErrorMsg");
            	dialog.setAlwaysOnTop(true);
            	dialog.setVisible(true);
			}
			break;
		case "Update":
			cd1=new CrudDaoImpl();
			cb=new CrudBean();
			cb.setName(tf5.getText());
			cb.setEmail(tf4.getText());
			cb.setPhoneno(tf6.getText());

			if(cd1.updateEmployee(cb)==1) {
				JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
				ch=new CrudHome();
			}
			else {
				JOptionPane optionPane = new JOptionPane("Failure", JOptionPane.ERROR_MESSAGE);
            	JDialog dialog = optionPane.createDialog("ErrorMsg");
            	dialog.setAlwaysOnTop(true);
            	dialog.setVisible(true);
			}
			break;
		case "Delete":
			cb=new CrudBean();
			cb.setEmail(tf7.getText());
			if(getAnEmp(cb)==null) {
				JOptionPane optionPane = new JOptionPane("Employee Not Found", JOptionPane.ERROR_MESSAGE);
            	JDialog dialog = optionPane.createDialog("ErrorMsg");
            	dialog.setAlwaysOnTop(true);
            	dialog.setVisible(true);
			}
			else {
				cd1=new CrudDaoImpl();
				if(cd1.deleteEmployee(cb)==1) {
					JOptionPane.showMessageDialog(null,"Employee deleted Successfully");
					ch=new CrudHome();
				}
				else {
					JOptionPane optionPane = new JOptionPane("Failed to delete Employee", JOptionPane.ERROR_MESSAGE);
	            	JDialog dialog = optionPane.createDialog("ErrorMsg");
	            	dialog.setAlwaysOnTop(true);
	            	dialog.setVisible(true);
				}
			}
		case "Back":
			if(e.getSource()==jf2) {
			jf2.dispose();
			}
			else if(e.getSource()==jf3) {
				jf3.dispose();
			}
			else if(e.getSource()==jf4) {
				jf4.dispose();
			}
			else if(e.getSource()==frame1) {
				frame1.dispose();
			}
			ch=new CrudHome();
			break;
		case "Exit":
			if(e.getSource()==jf2) {
				jf2.dispose();
				}
				else if(e.getSource()==jf3) {
					jf3.dispose();
				}
				else if(e.getSource()==jf4) {
					jf4.dispose();
				}
				else if(e.getSource()==frame1) {
					frame1.dispose();
				}
			break;
		case "Search":
			cb=new CrudBean();
			cb.setEmail(tf4.getText());
			if(getAnEmp(cb)==null) {
				JOptionPane optionPane = new JOptionPane("Employee Not Found", JOptionPane.ERROR_MESSAGE);
            	JDialog dialog = optionPane.createDialog("ErrorMsg");
            	dialog.setAlwaysOnTop(true);
            	dialog.setVisible(true);
			}
			else {
				tf5.setText(cb.getName());
				tf6.setText(cb.getPhoneno());
			}
			break;
			default:
				break;

		}

	}

	private CrudBean getAnEmp(CrudBean cb2) {
		cd1=new CrudDaoImpl();
		cb2=cd1.getAnEmp(cb2);
		return cb2;

	}

	public void getAllEmployee() {
		ArrayList<CrudBean> empList = null;
		cd1=new CrudDaoImpl();
		String[] columnNames = {"Name", "Email", "Mobile No"};
		empList = cd1.getAllEmployee();
		backBtn = new JButton("Back");
        exitBtn = new JButton("Exit");
		frame1 = new JFrame("Employees list");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);
        model.setRowCount(0);
        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (CrudBean emp : empList) {
            Object rowData[] = {emp.getName(), emp.getEmail(), emp.getPhoneno()};
            model.addRow(rowData);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);
	}

	public void deleteEmployee() {
		jf4=new JFrame();
		jf4.setTitle("Delete Employee");
		jf4.setVisible(true);
		jf4.setSize(500, 500);
		jf4.setLayout(new GridLayout(5,1));
		jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("Employee Maintenance System",SwingConstants.CENTER);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel jp=new JPanel(new GridLayout(1,2));
        l9 = new JLabel("Enter Email:");
        tf7 = new JTextField();
        delBtn = new JButton("Delete");
        backBtn = new JButton("Back");
        exitBtn = new JButton("Exit");

        jf4.add(l1);

        jp.add(l9);
        jp.add(tf7);

        jf4.add(jp);
        jf4.add(delBtn);
        jf4.add(backBtn);
        jf4.add(exitBtn);
        delBtn.addActionListener(this);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);

	}
}
