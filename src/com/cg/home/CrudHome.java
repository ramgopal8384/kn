package com.cg.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cg.controller.CrudController;

public class CrudHome extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3,b4,addBtn,backBtn,exitBtn;
	JTextField tf1,tf2,tf3;
	JFrame jf1,jf2;
	JPanel panel;
	CrudController cc1;
	public CrudHome(){
		jf1= new JFrame();
		jf1.setTitle("EMS");
		jf1.setVisible(true);
		jf1.setSize(500, 500);
		jf1.setLayout(new GridLayout(5,1));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Employee Maintenance System",SwingConstants.CENTER);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        b1 = new JButton("Add Employee");
        b2 = new JButton("Update Employee");
        b3 = new JButton("Get All Employees");
        b4 = new JButton("Delete Employee");


        jf1.add(l1);
        jf1.add(b1);
        jf1.add(b2);
        jf1.add(b3);
        jf1.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cc1=new CrudController();
		switch (e.getActionCommand()) {
		case "Add Employee":
			jf1.dispose();
			cc1.addEmployee();
			break;
		case "Update Employee":
			jf1.dispose();
			cc1.updateEmployee();
			break;
		case "Get All Employees":
			jf1.dispose();
			cc1.getAllEmployee();
			break;
		case "Delete Employee":
			jf1.dispose();
			cc1.deleteEmployee();
			break;
			default:
				break;

		}

	}




	public static void main(String[] args) {
		new CrudHome();
	}
}
