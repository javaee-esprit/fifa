package com.fifa.client.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.fifa.client.delegate.UserServiceDelegate;
import com.fifa.persistence.Admin;
import com.fifa.persistence.Employee;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthentificationUI extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthentificationUI frame = new AuthentificationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 */
	public AuthentificationUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel authPanel = new JPanel();
		authPanel.setBorder(new TitledBorder(null, "Authentication", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(authPanel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(authPanel, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblLogin = new JLabel("login");
		
		JLabel lblPassword = new JLabel("password");
		
		loginField = new JTextField();
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton connectionButton = new JButton("CONNECTION");
		connectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = UserServiceDelegate.authenticate(loginField.getText(), String.copyValueOf(passwordField.getPassword()));
				if (user != null) {
					System.out.print("ACCESS GRANTED");
					Session.getInstance().getStore().put("authUser", user);
					if (user instanceof Employee) {
						System.out.println(" AS EMPLOYEE");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EmployeeUI frame = new EmployeeUI();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						dispose();
					}else if (user instanceof Admin) {
						System.out.println(" AS ADMIN");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									AdminUI frame = new AdminUI();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						dispose();
					}
					else if (user instanceof User) {
						System.out.println(" AS USER");
					}
					
					
				} else {
					System.out.println("ACCESS DENIED");
				}
			}
		});
		GroupLayout gl_authPanel = new GroupLayout(authPanel);
		gl_authPanel.setHorizontalGroup(
			gl_authPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_authPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_authPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(connectionButton, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addGroup(gl_authPanel.createSequentialGroup()
							.addGroup(gl_authPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addGroup(gl_authPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(loginField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_authPanel.setVerticalGroup(
			gl_authPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_authPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_authPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(loginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_authPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(connectionButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		authPanel.setLayout(gl_authPanel);
		contentPane.setLayout(gl_contentPane);
	}
}
