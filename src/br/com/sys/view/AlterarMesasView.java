package br.com.sys.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.sys.bean.MesasBean;
import br.com.sys.dao.mesasDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlterarMesasView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AlterarMesasView(MesasBean mb) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblmdigo = new JLabel("Id Mesa");
		lblmdigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmdigo.setBounds(215, 50, 101, 22);
		contentPane.add(lblmdigo);
		
		JLabel lbl = new JLabel("Id Pedido");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl.setBounds(215, 177, 101, 22);
		contentPane.add(lbl);
		
		textField = new JTextField(String.valueOf(mb.getIdMesa()));
		textField.setEditable(false);
		textField.setBounds(215, 92, 108, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(mb.getIdPedido());
		textField_1.setBounds(208, 210, 108, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Obter dados
				MesasBean mb = new MesasBean();
				mb.setIdMesa(Integer.parseInt(textField.getText()));
				mb.setIdPedido(Integer.parseInt(textField_1.getText()));
				
				//Chamar a ação alterar
				mesasDao md = new mesasDao();
				md.alterar(mb);
				
				//Fechar formulário
				dispose();
				
				//Chamar formulario
				mesasView cv = new mesasView();
				cv.setVisible(true);
				
			}
		});
		btnAlterar.setBounds(10, 35, 108, 34);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Obter dados
				int idCodigo = Integer.parseInt(textField.getText());
				
				
				//Chamar ação para excluir
				mesasDao md = new mesasDao();
				md.deletarCursos(idCodigo);
				
				//Fechar formulário
				dispose();
				
				//Chamar formulario
				mesasView cv = new mesasView();
				cv.setVisible(true);
				
			}
		});
		btnExcluir.setBounds(10, 104, 108, 34);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Fechar formulário
				dispose();
				
				//Chamar tabela
				mesasView cv = new mesasView();
				cv.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(10, 177, 108, 34);
		contentPane.add(btnCancelar);
	}

}
