package br.com.sys.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.sys.bean.MesasBean;
import br.com.sys.dao.mesasDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class mesasView extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt2;
	private JTable tblListarCursos;
	private JScrollPane scrollPane;
	private JTable table;

	public mesasView() {

		// Objecto da classe mesasDao
		mesasDao md = new mesasDao();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel Jlabel = new JLabel("Id Mesa");
		Jlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlabel.setBounds(20, 11, 167, 27);
		contentPane.add(Jlabel);
		Jlabel.setHorizontalTextPosition(SwingConstants.CENTER);

		JLabel Jlabel2 = new JLabel("Id Pedido");
		Jlabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlabel2.setBounds(20, 93, 167, 27);
		contentPane.add(Jlabel2);
		Jlabel2.setHorizontalTextPosition(SwingConstants.CENTER);

		txt = new JTextField();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt.setBounds(10, 49, 182, 33);
		contentPane.add(txt);
		txt.setColumns(10);

		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt2.setColumns(10);
		txt2.setBounds(10, 131, 182, 33);
		contentPane.add(txt2);

		JButton btnCadastrarCurso = new JButton("Cadastrar Mesa");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Obter dados informados
				MesasBean mb = new MesasBean();
				mb.setIdMesa(Integer.parseInt(txt.getText()));
				mb.setIdPedido(Integer.parseInt(txt2.getText()));

				// Executar envio dos dados
				mesasDao md = new mesasDao();
				md.cadastrarDados(mb);

				// Limpar campos
				txt.setText("");
				txt2.setText("");

				// Cursor no campo nome curso
				txt.requestFocus();

				// Atualizar tabela
				table.setModel(md.listarDados());

			}
		});
		btnCadastrarCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarCurso.setBounds(20, 175, 158, 45);
		contentPane.add(btnCadastrarCurso);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 231, 182, 419);
		contentPane.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(md.listarDados());
		
		JButton button = new JButton("");
		button.setFocusPainted(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusable(false);
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button.setBounds(252, 107, 60, 57);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Obter linha
				int linha = table.getSelectedRow();
				
				System.out.println((table.getValueAt(linha, 0).toString()));
			
				if((table.getValueAt(linha, 0).toString()).equals("1")){
				 
				// Obter dados
				MesasBean mb = new MesasBean();
				
				mb.setIdMesa(Integer.parseInt(table.getValueAt(linha, 0).toString()));
				mb.setIdPedido(Integer.parseInt(table.getValueAt(linha, 1).toString()));

				// Chamar tabela 
				AlterarMesasView amv = new AlterarMesasView(mb);
				
				// Fechar tabela
				dispose();	
				
				}else {
				System.out.println("peidei");
				}
				
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.setFocusPainted(false);
		button_1.setFocusTraversalKeysEnabled(false);
		button_1.setFocusable(false);
		button_1.setBackground(Color.WHITE);
		button_1.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_1.setBounds(335, 107, 60, 57);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setFocusPainted(false);
		button_2.setFocusTraversalKeysEnabled(false);
		button_2.setFocusable(false);
		button_2.setBackground(Color.WHITE);
		button_2.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_2.setBounds(421, 107, 60, 57);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setFocusPainted(false);
		button_3.setFocusTraversalKeysEnabled(false);
		button_3.setFocusable(false);
		button_3.setBackground(Color.WHITE);
		button_3.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_3.setBounds(503, 107, 60, 57);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_4.setFocusable(false);
		button_4.setFocusTraversalKeysEnabled(false);
		button_4.setFocusPainted(false);
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(252, 200, 60, 57);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_5.setFocusable(false);
		button_5.setFocusTraversalKeysEnabled(false);
		button_5.setFocusPainted(false);
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(335, 200, 60, 57);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_6.setFocusable(false);
		button_6.setFocusTraversalKeysEnabled(false);
		button_6.setFocusPainted(false);
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(421, 200, 60, 57);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(mesasView.class.getResource("/imagens/if_architecture-interior-27_809104.png")));
		button_7.setFocusable(false);
		button_7.setFocusTraversalKeysEnabled(false);
		button_7.setFocusPainted(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(503, 200, 60, 57);
		contentPane.add(button_7);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 584, 661);
		contentPane.add(label);
		
	}
}
