package br.com.sys.view;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.com.sys.bean.Categorias_produtosBean;
import br.com.sys.bean.ProdutosBean;
import br.com.sys.dao.GenericDao;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane, panelLayoutMesa, panelFecharMesa, panelMesas, panelCardapio, panelCaixa, panelClientes, panelAlterarFuncionarios,
			panelFuncionarios, panelFecharCaixa, panelAlterarProdutos, panelAlterarClientes;
	private JLabel label_5, label_6, labelSelecioneMesa, lblImagemProduto, lblCategoria, lblAlteracaoDeProdutos,
			lblValorProduto;
	private JButton btnLayout, btnListagemMESAS, BotaoMesa1, BotaoMesa2, BotaoMesa3, BotaoMesa4, BotaoMesa5, BotaoMesa6,
			BotaoMesa7, BotaoMesa8, BotaoMesa9, BotaoMesa10, BotaoMesa11, BotaoMesa12, BotaoMesa13, BotaoMesa14,
			BotaoMesa15, btnAlterao, btnAlteraoALTERACAO, btnAlteraoCLIENTES, btnCadastro, btnCadastroCARDAPIO,
			btnCadastroCLIENTE, btnFecharCaixa, btnFecharMesa, btnListagem, btnListagemCLIENTES, btnListagemLISTAGEM,
			btnPagamento, button, button_1, button_2, button_3, button_4, btnAlterar, btnCancelar, btnCadastrarFuncionario, btnLimparDados;
	private JLabel lblNomeProduto;
	private JTextField campoNomeProduto;
	private JLabel lblDescrioDoProduto;
	private JTextArea descricaoProduto;
	private JFormattedTextField valorAlterarProduto; 
	private JFormattedTextField formattedTextField;
	private JTextField textField;
	private JButton btnAdicionarImagem;
	private JComboBox comboBox_2;
	private JTable table;
	private JTable tabelaFuncionarios;
	private JLabel lblImagem;
	private JLabel lblListaDeMesas;
	private JTable table_2;
	private JTable table_3;
	private JLabel lblProdutosDaMesa;
	private JLabel lblMesas;
	private JButton btnCancelar_1;
	private JTable table_4;
	private JRadioButton rdbtnDoces;
	private JLabel lblFecharCaixa;
	private JTable table_5;
	private JLabel lblValorTotalNo;
	private JTextField textFieldvalorDinheiro;
	private JLabel lblValorTotalNo_1;
	private JTextField textFieldvalorDebito;
	private JLabel lblValorTotalNo_2;
	private JTextField valorCredito;
	private JLabel lblCaixaContm_2;
	private JTextField textFieldCaixa3;
	private JTextField textFieldCaixa2;
	private JLabel lblCaixaContm_1;
	private JLabel lblCaixaContm;
	private JTextField textFieldCaixa1;
	private JLabel lblCartesFidelidadeConcludos;
	private JTextField textFieldCartaoFidelidade;
	private JButton btnFechar;
	private JButton btnCancelarCaixa;
	private JLabel lblAlteracaoFuncionarios, lblCadastroFuncionario, lblEnderecoFuncionario;
	private JLabel lblNomeFuncionario;
	private JLabel lblEnderecoFuncionarios;
	private JLabel lblNFuncionarios;
	private JLabel lblBairroFuncionarios;
	private JLabel lblCidadeFuncionarios;
	private JLabel lblEstadoFuncionarios;
	private JLabel lblCpfFuncionarios;
	private JTextField textFieldNomeFuncionario;
	private JTextField textFieldEndereco;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldNumero;
	private JFormattedTextField FormattedEstado;
	private JFormattedTextField FormattedCPF;
	private JLabel labelAvisoProblema;
	private JButton btnAlterarFuncionarios;
	private JButton btnCancelarCadastroFuncionarios;
	private JLabel labelTelefone;
	private JFormattedTextField FormattedTelefone;
	private GenericDao gd = new GenericDao();
	private int alterar = 0;
	private JButton btnAlterar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaPrincipal() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		/****************************************************************************************************************/
  		
		/** Panel Cadastrar Produto **/

		JPanel panelCadastrarProduto = new JPanel();
		panelCadastrarProduto.setBounds(224, 45, 750, 571);
		contentPane.add(panelCadastrarProduto);
		panelCadastrarProduto.setVisible(false);
		panelCadastrarProduto.setBackground(new Color(245, 222, 179));
		panelCadastrarProduto.setLayout(null);

		lblImagemProduto = new JLabel("");
		lblImagemProduto.setBackground(Color.WHITE);
		lblImagemProduto.setBounds(418, 272, 169, 115);
		panelCadastrarProduto.add(lblImagemProduto);

		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroDeProdutos.setFont(new Font("Agency FB", Font.PLAIN, 38));
		lblCadastroDeProdutos.setBounds(225, 11, 316, 56);
		panelCadastrarProduto.add(lblCadastroDeProdutos);

		lblNomeProduto = new JLabel("Nome Produto:");
		lblNomeProduto.setBackground(new Color(184, 134, 11));
		lblNomeProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNomeProduto.setBounds(10, 112, 141, 56);
		panelCadastrarProduto.add(lblNomeProduto);

		campoNomeProduto = new JTextField();
		campoNomeProduto.setFont(new Font("Agency FB", Font.PLAIN, 25));
		campoNomeProduto.setBounds(161, 112, 195, 50);
		panelCadastrarProduto.add(campoNomeProduto);
		campoNomeProduto.setColumns(10);

		lblValorProduto = new JLabel("Valor Produto:");
		lblValorProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblValorProduto.setBackground(new Color(184, 134, 11));
		lblValorProduto.setBounds(385, 112, 141, 56);
		panelCadastrarProduto.add(lblValorProduto);

		lblDescrioDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescrioDoProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblDescrioDoProduto.setBackground(new Color(184, 134, 11));
		lblDescrioDoProduto.setBounds(10, 189, 213, 56);
		panelCadastrarProduto.add(lblDescrioDoProduto);

		descricaoProduto = new JTextArea();
		descricaoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				//pular linha, fazer funcao.
			}
		});
		descricaoProduto.setBounds(10, 256, 346, 172);
		panelCadastrarProduto.add(descricaoProduto);
		descricaoProduto.setFont(new Font("Agency FB", Font.PLAIN, 25));
		descricaoProduto.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		formattedTextField = new JFormattedTextField(new DecimalFormat("#,##0.00"));
		formattedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres="0987654321,";
				if(!caracteres.contains(evt.getKeyChar()+"")){
					evt.consume();
				}

			}
		});


		formattedTextField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		formattedTextField.setBounds(535, 112, 195, 50);
		panelCadastrarProduto.add(formattedTextField);

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblCategoria.setBackground(new Color(184, 134, 11));
		lblCategoria.setBounds(385, 189, 102, 56);
		panelCadastrarProduto.add(lblCategoria);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 25));
		comboBox.setBounds(535, 194, 195, 50);
		comboBox.addItem("-- Selecione --");
		panelCadastrarProduto.add(comboBox);

		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosBean pb = new ProdutosBean();
				pb.setNomeProduto(campoNomeProduto.getText());
				pb.setValorProduto(Double.parseDouble(formattedTextField.getText().replaceAll(",", ".")));
				pb.setDescricaoProduto(descricaoProduto.getText());
				pb.setIdCategoria(comboBox.getSelectedIndex());
				try {
					gd.adicionar(pb);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(new Color(139, 69, 19));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setFocusTraversalKeysEnabled(false);
		btnAdicionar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAdicionar.setBounds(71, 439, 624, 56);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setFocusTraversalKeysEnabled(false);
		panelCadastrarProduto.add(btnAdicionar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(139, 69, 19));
		btnCancelar.setFocusable(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelar.setBounds(71, 495, 624, 56);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCadastrarProduto.setVisible(false);

			}
		});
		panelCadastrarProduto.add(btnCancelar);

		btnAdicionarImagem = new JButton("+");
		btnAdicionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAdicionarImagem.setForeground(Color.WHITE);
		btnAdicionarImagem.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAdicionarImagem.setFocusable(false);
		btnAdicionarImagem.setFocusTraversalKeysEnabled(false);
		btnAdicionarImagem.setFocusPainted(false);
		btnAdicionarImagem.setBackground(new Color(139, 69, 19));
		btnAdicionarImagem.setBounds(647, 272, 51, 56);
		panelCadastrarProduto.add(btnAdicionarImagem);
		
		/** Panel Listar Produto **/

		JPanel panelListarProdutos = new JPanel();
		panelListarProdutos.setVisible(false);
		panelListarProdutos.setBounds(224, 45, 750, 571);
		contentPane.add(panelListarProdutos);
		panelListarProdutos.setBackground(new Color(245, 222, 179));
		panelListarProdutos.setLayout(null);

		JLabel lblListagemDeProdutos = new JLabel("LISTAGEM DE PRODUTOS");
		lblListagemDeProdutos.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblListagemDeProdutos.setBounds(277, 11, 195, 36);
		panelListarProdutos.add(lblListagemDeProdutos);

		JTable table_1 = new JTable();
		
		JScrollPane barraRolagem = new JScrollPane(table_1);
		barraRolagem.setBounds(21, 58, 708, 438);
		panelListarProdutos.add(barraRolagem);

		JButton btnCancelar_1 = new JButton("CANCELAR");
		btnCancelar_1.setForeground(new Color(255, 255, 255));
		btnCancelar_1.setBackground(new Color(139, 69, 19));
		btnCancelar_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelar_1.setBounds(487, 519, 158, 41);
		panelListarProdutos.add(btnCancelar_1);
		btnCancelar_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListarProdutos.setVisible(false);

			}
		});

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setBackground(new Color(139, 69, 19));
		btnAlterar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterar.setBounds(105, 519, 158, 41);
		panelListarProdutos.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListarProdutos.setVisible(false);
				panelAlterarProdutos.setVisible(true);
				try {
					List<Object> list = gd.listarTabela(ProdutosBean.class);
					ProdutosBean pb = (ProdutosBean) list.get(table_1.getSelectedRow());
					campoNomeProduto.setText(pb.getNomeProduto());
					alterar = pb.getIdProduto();
					descricaoProduto.setText(pb.getDescricaoProduto());
					valorAlterarProduto.setText(String.format("%.2f",pb.getValorProduto()));
					comboBox_2.setSelectedIndex(pb.getIdCategoria());
					
					
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});

		/** Panel Alterar Produtos **/
		
		panelAlterarProdutos = new JPanel();
		panelAlterarProdutos.setVisible(false);
		panelAlterarProdutos.setBounds(224, 45, 750, 571);
		contentPane.add(panelAlterarProdutos);
		panelAlterarProdutos.setBackground(new Color(245, 222, 179));
		panelAlterarProdutos.setLayout(null);

		lblImagemProduto = new JLabel("");
		lblImagemProduto.setBackground(Color.WHITE);
		lblImagemProduto.setBounds(548, 272, 169, 115);
		panelAlterarProdutos.add(lblImagemProduto);

		lblAlteracaoDeProdutos = new JLabel("ALTERA\u00C7\u00C3O DE PRODUTOS");
		lblAlteracaoDeProdutos.setFont(new Font("Agency FB", Font.PLAIN, 38));
		lblAlteracaoDeProdutos.setBounds(225, 11, 316, 56);
		panelAlterarProdutos.add(lblAlteracaoDeProdutos);

		lblNomeProduto = new JLabel("Nome Produto:");
		lblNomeProduto.setBackground(new Color(184, 134, 11));
		lblNomeProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNomeProduto.setBounds(10, 112, 141, 56);
		panelAlterarProdutos.add(lblNomeProduto);

		campoNomeProduto = new JTextField();
		campoNomeProduto.setFont(new Font("Agency FB", Font.PLAIN, 25));
		campoNomeProduto.setBounds(161, 112, 195, 50);
		panelAlterarProdutos.add(campoNomeProduto);
		campoNomeProduto.setColumns(10);

		lblValorProduto = new JLabel("Valor Produto:");
		lblValorProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblValorProduto.setBackground(new Color(184, 134, 11));
		lblValorProduto.setBounds(385, 112, 141, 56);
		panelAlterarProdutos.add(lblValorProduto);

		lblDescrioDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescrioDoProduto.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblDescrioDoProduto.setBackground(new Color(184, 134, 11));
		lblDescrioDoProduto.setBounds(10, 189, 213, 56);
		panelAlterarProdutos.add(lblDescrioDoProduto);

		descricaoProduto = new JTextArea();
		descricaoProduto.setBounds(10, 256, 346, 172);
		panelAlterarProdutos.add(descricaoProduto);
		descricaoProduto.setFont(new Font("Agency FB", Font.PLAIN, 25));
		descricaoProduto.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		valorAlterarProduto = new JFormattedTextField(new DecimalFormat("#,##0.00"));
		valorAlterarProduto.setFont(new Font("Agency FB", Font.PLAIN, 25));
		valorAlterarProduto.setBounds(535, 112, 195, 50);
		panelAlterarProdutos.add(valorAlterarProduto);
		panelAlterarProdutos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres="0987654321,";
				if(!caracteres.contains(evt.getKeyChar()+"")){
					evt.consume();
				}

			}
		});

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblCategoria.setBackground(new Color(184, 134, 11));
		lblCategoria.setBounds(385, 189, 102, 56);
		panelAlterarProdutos.add(lblCategoria);

		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Agency FB", Font.PLAIN, 25));
		comboBox_2.setBounds(535, 194, 195, 50);
		comboBox_2.addItem("-- Selecione --");
		panelAlterarProdutos.add(comboBox_2);

		btnAlterar_1 = new JButton("ALTERAR");
		btnAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosBean pb = new ProdutosBean();
				pb.setIdProduto(alterar);
				pb.setNomeProduto(campoNomeProduto.getText());
				pb.setValorProduto(Double.parseDouble(formattedTextField.getText().replaceAll(",", ".")));
				pb.setDescricaoProduto(descricaoProduto.getText());
				pb.setIdCategoria(comboBox.getSelectedIndex());
				try {
					gd.alterar(pb);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnAlterar_1.setForeground(Color.WHITE);
		btnAlterar_1.setBackground(new Color(139, 69, 19));
		btnAlterar_1.setFocusable(false);
		btnAlterar_1.setFocusPainted(false);
		btnAlterar_1.setFocusTraversalKeysEnabled(false);
		btnAlterar_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterar_1.setBounds(71, 439, 624, 56);
		btnAlterar_1.setFocusPainted(false);
		btnAlterar_1.setFocusTraversalKeysEnabled(false);
		panelAlterarProdutos.add(btnAlterar_1);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(139, 69, 19));
		btnCancelar.setFocusable(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelar.setBounds(71, 495, 624, 56);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelAlterarProdutos.setVisible(false);

			}
		});
		panelAlterarProdutos.add(btnCancelar);

		btnAdicionarImagem = new JButton("+");
		btnAdicionarImagem.setForeground(Color.WHITE);
		btnAdicionarImagem.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAdicionarImagem.setFocusable(false);
		btnAdicionarImagem.setFocusTraversalKeysEnabled(false);
		btnAdicionarImagem.setFocusPainted(false);
		btnAdicionarImagem.setBackground(new Color(139, 69, 19));
		btnAdicionarImagem.setBounds(385, 331, 51, 56);
		panelAlterarProdutos.add(btnAdicionarImagem);

		lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblImagem.setBackground(new Color(184, 134, 11));
		lblImagem.setBounds(385, 272, 102, 56);
		panelAlterarProdutos.add(lblImagem);		

		/** Panel Layout Mesas **/
		
		panelLayoutMesa = new JPanel();
		panelLayoutMesa.setBounds(224, 45, 750, 571);
		contentPane.add(panelLayoutMesa);
		panelLayoutMesa.setVisible(false);
		panelLayoutMesa.setBackground(new Color(245, 222, 179));
		panelLayoutMesa.setLayout(null);

		labelSelecioneMesa = new JLabel("SELECIONE A MESA:");
		labelSelecioneMesa.setFont(new Font("Agency FB", Font.PLAIN, 32));
		labelSelecioneMesa.setBounds(280, 0, 202, 29);
		panelLayoutMesa.add(labelSelecioneMesa);

		BotaoMesa1 = new JButton("");
		BotaoMesa1.setFocusTraversalKeysEnabled(false);
		BotaoMesa1.setFocusable(false);
		BotaoMesa1.setFocusPainted(false);
		BotaoMesa1.setBounds(128, 132, 58, 61);
		panelLayoutMesa.add(BotaoMesa1);
		BotaoMesa1.setOpaque(false);
		BotaoMesa1.setContentAreaFilled(false);
		BotaoMesa1.setBorderPainted(false);

		BotaoMesa2 = new JButton("");
		BotaoMesa2.setFocusTraversalKeysEnabled(false);
		BotaoMesa2.setFocusable(false);
		BotaoMesa2.setFocusPainted(false);
		BotaoMesa2.setBounds(128, 204, 58, 61);
		panelLayoutMesa.add(BotaoMesa2);
		BotaoMesa2.setOpaque(false);
		BotaoMesa2.setContentAreaFilled(false);
		BotaoMesa2.setBorderPainted(false);

		BotaoMesa3 = new JButton("");
		BotaoMesa3.setFocusTraversalKeysEnabled(false);
		BotaoMesa3.setFocusable(false);
		BotaoMesa3.setFocusPainted(false);
		BotaoMesa3.setBounds(128, 286, 58, 61);
		panelLayoutMesa.add(BotaoMesa3);
		BotaoMesa3.setOpaque(false);
		BotaoMesa3.setContentAreaFilled(false);
		BotaoMesa3.setBorderPainted(false);

		BotaoMesa4 = new JButton("");
		BotaoMesa4.setFocusTraversalKeysEnabled(false);
		BotaoMesa4.setFocusable(false);
		BotaoMesa4.setFocusPainted(false);
		BotaoMesa4.setBounds(222, 132, 58, 61);
		panelLayoutMesa.add(BotaoMesa4);
		BotaoMesa4.setOpaque(false);
		BotaoMesa4.setContentAreaFilled(false);
		BotaoMesa4.setBorderPainted(false);

		BotaoMesa5 = new JButton("");
		BotaoMesa5.setFocusTraversalKeysEnabled(false);
		BotaoMesa5.setFocusable(false);
		BotaoMesa5.setFocusPainted(false);
		BotaoMesa5.setBounds(222, 204, 58, 61);
		panelLayoutMesa.add(BotaoMesa5);
		BotaoMesa5.setOpaque(false);
		BotaoMesa5.setContentAreaFilled(false);
		BotaoMesa5.setBorderPainted(false);

		BotaoMesa6 = new JButton("");
		BotaoMesa6.setFocusTraversalKeysEnabled(false);
		BotaoMesa6.setFocusable(false);
		BotaoMesa6.setFocusPainted(false);
		BotaoMesa6.setBounds(222, 286, 58, 61);
		panelLayoutMesa.add(BotaoMesa6);
		BotaoMesa6.setOpaque(false);
		BotaoMesa6.setContentAreaFilled(false);
		BotaoMesa6.setBorderPainted(false);

		BotaoMesa7 = new JButton("");
		BotaoMesa7.setFocusTraversalKeysEnabled(false);
		BotaoMesa7.setFocusable(false);
		BotaoMesa7.setFocusPainted(false);
		BotaoMesa7.setBounds(322, 204, 58, 61);
		panelLayoutMesa.add(BotaoMesa7);
		BotaoMesa7.setOpaque(false);
		BotaoMesa7.setContentAreaFilled(false);
		BotaoMesa7.setBorderPainted(false);

		BotaoMesa8 = new JButton("");
		BotaoMesa8.setFocusTraversalKeysEnabled(false);
		BotaoMesa8.setFocusable(false);
		BotaoMesa8.setFocusPainted(false);
		BotaoMesa8.setBounds(322, 286, 58, 61);
		panelLayoutMesa.add(BotaoMesa8);
		BotaoMesa8.setOpaque(false);
		BotaoMesa8.setContentAreaFilled(false);
		BotaoMesa8.setBorderPainted(false);

		BotaoMesa9 = new JButton("");
		BotaoMesa9.setOpaque(false);
		BotaoMesa9.setFocusable(false);
		BotaoMesa9.setFocusTraversalKeysEnabled(false);
		BotaoMesa9.setFocusPainted(false);
		BotaoMesa9.setContentAreaFilled(false);
		BotaoMesa9.setBorderPainted(false);
		BotaoMesa9.setBounds(120, 45, 58, 61);
		panelLayoutMesa.add(BotaoMesa9);

		BotaoMesa10 = new JButton("");
		BotaoMesa10.setFocusTraversalKeysEnabled(false);
		BotaoMesa10.setFocusable(false);
		BotaoMesa10.setFocusPainted(false);
		BotaoMesa10.setBounds(204, 45, 58, 61);
		panelLayoutMesa.add(BotaoMesa10);
		BotaoMesa10.setOpaque(false);
		BotaoMesa10.setContentAreaFilled(false);
		BotaoMesa10.setBorderPainted(false);

		BotaoMesa11 = new JButton("");
		BotaoMesa11.setFocusTraversalKeysEnabled(false);
		BotaoMesa11.setFocusable(false);
		BotaoMesa11.setFocusPainted(false);
		BotaoMesa11.setBounds(280, 45, 58, 61);
		panelLayoutMesa.add(BotaoMesa11);
		BotaoMesa11.setOpaque(false);
		BotaoMesa11.setContentAreaFilled(false);
		BotaoMesa11.setBorderPainted(false);

		BotaoMesa12 = new JButton("");
		BotaoMesa12.setFocusTraversalKeysEnabled(false);
		BotaoMesa12.setFocusable(false);
		BotaoMesa12.setFocusPainted(false);
		BotaoMesa12.setBounds(175, 363, 60, 60);
		panelLayoutMesa.add(BotaoMesa12);
		BotaoMesa12.setOpaque(false);
		BotaoMesa12.setContentAreaFilled(false);
		BotaoMesa12.setBorderPainted(false);

		BotaoMesa13 = new JButton("");
		BotaoMesa13.setFocusTraversalKeysEnabled(false);
		BotaoMesa13.setFocusable(false);
		BotaoMesa13.setFocusPainted(false);
		BotaoMesa13.setBounds(251, 363, 58, 61);
		panelLayoutMesa.add(BotaoMesa13);
		BotaoMesa13.setOpaque(false);
		BotaoMesa13.setContentAreaFilled(false);
		BotaoMesa13.setBorderPainted(false);

		BotaoMesa14 = new JButton("");
		BotaoMesa14.setFocusTraversalKeysEnabled(false);
		BotaoMesa14.setFocusable(false);
		BotaoMesa14.setFocusPainted(false);
		BotaoMesa14.setBounds(332, 363, 58, 61);
		panelLayoutMesa.add(BotaoMesa14);
		BotaoMesa14.setOpaque(false);
		BotaoMesa14.setContentAreaFilled(false);
		BotaoMesa14.setBorderPainted(false);

		BotaoMesa15 = new JButton("");
		BotaoMesa15.setFocusTraversalKeysEnabled(false);
		BotaoMesa15.setFocusable(false);
		BotaoMesa15.setFocusPainted(false);
		BotaoMesa15.setBounds(413, 363, 58, 61);
		panelLayoutMesa.add(BotaoMesa15);
		BotaoMesa15.setOpaque(false);
		BotaoMesa15.setContentAreaFilled(false);
		BotaoMesa15.setBorderPainted(false);
		BotaoMesa15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/LAYOUT MESAS.png")));
		label_6.setBounds(75, 32, 600, 412);
		panelLayoutMesa.add(label_6);

		table = new JTable();
		table.setBounds(20, 443, 709, 117);
		panelLayoutMesa.add(table);
				
		
		/** Panel Listagem Mesas **/

		JPanel panelListagemMesas = new JPanel();
		panelListagemMesas.setVisible(false);
		panelListagemMesas.setBounds(224, 45, 750, 571);
		contentPane.add(panelListagemMesas);
		panelListagemMesas.setBackground(new Color(245, 222, 179));
		panelListagemMesas.setLayout(null);

		lblListaDeMesas = new JLabel("LISTA DE MESAS OCUPADAS:");
		lblListaDeMesas.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblListaDeMesas.setBounds(259, 11, 232, 36);
		panelListagemMesas.add(lblListaDeMesas);

		table_2 = new JTable();
		JScrollPane barraRolagemtb2 = new JScrollPane(table_2);
		barraRolagemtb2.setBounds(10, 70, 730, 206);
		panelListagemMesas.add(barraRolagemtb2);
		

		table_3 = new JTable();
		table_3.setBounds(10, 354, 730, 206);
		panelListagemMesas.add(table_3);

		lblProdutosDaMesa = new JLabel("PRODUTOS DA MESA SELECIONADA:");
		lblProdutosDaMesa.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblProdutosDaMesa.setBounds(236, 295, 278, 36);
		panelListagemMesas.add(lblProdutosDaMesa);
		
		/** Panel Fechar Mesas **/

		JPanel panelFecharMesa = new JPanel();
		panelFecharMesa.setVisible(false);
		panelFecharMesa.setBounds(224, 45, 750, 571);
		contentPane.add(panelFecharMesa);
		panelFecharMesa.setBackground(new Color(245, 222, 179));
		panelFecharMesa.setLayout(null);

		/* Botões Layout das Mesas */

		BotaoMesa1 = new JButton("");
		BotaoMesa1.setFocusTraversalKeysEnabled(false);
		BotaoMesa1.setFocusable(false);
		BotaoMesa1.setFocusPainted(false);
		BotaoMesa1.setBounds(125, 177, 58, 61);
		panelFecharMesa.add(BotaoMesa1);
		BotaoMesa1.setOpaque(false);
		BotaoMesa1.setContentAreaFilled(false);
		BotaoMesa1.setBorderPainted(false);

		BotaoMesa2 = new JButton("");
		BotaoMesa2.setFocusTraversalKeysEnabled(false);
		BotaoMesa2.setFocusable(false);
		BotaoMesa2.setFocusPainted(false);
		BotaoMesa2.setBounds(125, 249, 58, 61);
		panelFecharMesa.add(BotaoMesa2);
		BotaoMesa2.setOpaque(false);
		BotaoMesa2.setContentAreaFilled(false);
		BotaoMesa2.setBorderPainted(false);

		BotaoMesa3 = new JButton("");
		BotaoMesa3.setFocusTraversalKeysEnabled(false);
		BotaoMesa3.setFocusable(false);
		BotaoMesa3.setFocusPainted(false);
		BotaoMesa3.setBounds(125, 331, 58, 61);
		panelFecharMesa.add(BotaoMesa3);
		BotaoMesa3.setOpaque(false);
		BotaoMesa3.setContentAreaFilled(false);
		BotaoMesa3.setBorderPainted(false);

		BotaoMesa4 = new JButton("");
		BotaoMesa4.setFocusTraversalKeysEnabled(false);
		BotaoMesa4.setFocusable(false);
		BotaoMesa4.setFocusPainted(false);
		BotaoMesa4.setBounds(219, 177, 58, 61);
		panelFecharMesa.add(BotaoMesa4);
		BotaoMesa4.setOpaque(false);
		BotaoMesa4.setContentAreaFilled(false);
		BotaoMesa4.setBorderPainted(false);

		BotaoMesa5 = new JButton("");
		BotaoMesa5.setFocusTraversalKeysEnabled(false);
		BotaoMesa5.setFocusable(false);
		BotaoMesa5.setFocusPainted(false);
		BotaoMesa5.setBounds(219, 249, 58, 61);
		panelFecharMesa.add(BotaoMesa5);
		BotaoMesa5.setOpaque(false);
		BotaoMesa5.setContentAreaFilled(false);
		BotaoMesa5.setBorderPainted(false);

		BotaoMesa6 = new JButton("");
		BotaoMesa6.setFocusTraversalKeysEnabled(false);
		BotaoMesa6.setFocusable(false);
		BotaoMesa6.setFocusPainted(false);
		BotaoMesa6.setBounds(219, 331, 58, 61);
		panelFecharMesa.add(BotaoMesa6);
		BotaoMesa6.setOpaque(false);
		BotaoMesa6.setContentAreaFilled(false);
		BotaoMesa6.setBorderPainted(false);

		BotaoMesa7 = new JButton("");
		BotaoMesa7.setFocusTraversalKeysEnabled(false);
		BotaoMesa7.setFocusable(false);
		BotaoMesa7.setFocusPainted(false);
		BotaoMesa7.setBounds(319, 249, 58, 61);
		panelFecharMesa.add(BotaoMesa7);
		BotaoMesa7.setOpaque(false);
		BotaoMesa7.setContentAreaFilled(false);
		BotaoMesa7.setBorderPainted(false);

		BotaoMesa8 = new JButton("");
		BotaoMesa8.setFocusTraversalKeysEnabled(false);
		BotaoMesa8.setFocusable(false);
		BotaoMesa8.setFocusPainted(false);
		BotaoMesa8.setBounds(319, 331, 58, 61);
		panelFecharMesa.add(BotaoMesa8);
		BotaoMesa8.setOpaque(false);
		BotaoMesa8.setContentAreaFilled(false);
		BotaoMesa8.setBorderPainted(false);

		BotaoMesa9 = new JButton("");
		BotaoMesa9.setOpaque(false);
		BotaoMesa9.setFocusable(false);
		BotaoMesa9.setFocusTraversalKeysEnabled(false);
		BotaoMesa9.setFocusPainted(false);
		BotaoMesa9.setContentAreaFilled(false);
		BotaoMesa9.setBorderPainted(false);
		BotaoMesa9.setBounds(117, 90, 58, 61);
		panelFecharMesa.add(BotaoMesa9);

		BotaoMesa10 = new JButton("");
		BotaoMesa10.setFocusTraversalKeysEnabled(false);
		BotaoMesa10.setFocusable(false);
		BotaoMesa10.setFocusPainted(false);
		BotaoMesa10.setBounds(201, 90, 58, 61);
		panelFecharMesa.add(BotaoMesa10);
		BotaoMesa10.setOpaque(false);
		BotaoMesa10.setContentAreaFilled(false);
		BotaoMesa10.setBorderPainted(false);

		BotaoMesa11 = new JButton("");
		BotaoMesa11.setFocusTraversalKeysEnabled(false);
		BotaoMesa11.setFocusable(false);
		BotaoMesa11.setFocusPainted(false);
		BotaoMesa11.setBounds(277, 90, 58, 61);
		panelFecharMesa.add(BotaoMesa11);
		BotaoMesa11.setOpaque(false);
		BotaoMesa11.setContentAreaFilled(false);
		BotaoMesa11.setBorderPainted(false);

		BotaoMesa12 = new JButton("");
		BotaoMesa12.setFocusTraversalKeysEnabled(false);
		BotaoMesa12.setFocusable(false);
		BotaoMesa12.setFocusPainted(false);
		BotaoMesa12.setBounds(172, 408, 60, 60);
		panelFecharMesa.add(BotaoMesa12);
		BotaoMesa12.setOpaque(false);
		BotaoMesa12.setContentAreaFilled(false);
		BotaoMesa12.setBorderPainted(false);

		BotaoMesa13 = new JButton("");
		BotaoMesa13.setFocusTraversalKeysEnabled(false);
		BotaoMesa13.setFocusable(false);
		BotaoMesa13.setFocusPainted(false);
		BotaoMesa13.setBounds(248, 408, 58, 61);
		panelFecharMesa.add(BotaoMesa13);
		BotaoMesa13.setOpaque(false);
		BotaoMesa13.setContentAreaFilled(false);
		BotaoMesa13.setBorderPainted(false);

		BotaoMesa14 = new JButton("");
		BotaoMesa14.setFocusTraversalKeysEnabled(false);
		BotaoMesa14.setFocusable(false);
		BotaoMesa14.setFocusPainted(false);
		BotaoMesa14.setBounds(329, 408, 58, 61);
		panelFecharMesa.add(BotaoMesa14);
		BotaoMesa14.setOpaque(false);
		BotaoMesa14.setContentAreaFilled(false);
		BotaoMesa14.setBorderPainted(false);

		BotaoMesa15 = new JButton("");
		BotaoMesa15.setFocusTraversalKeysEnabled(false);
		BotaoMesa15.setFocusable(false);
		BotaoMesa15.setFocusPainted(false);
		BotaoMesa15.setBounds(410, 408, 58, 61);
		panelFecharMesa.add(BotaoMesa15);
		BotaoMesa15.setOpaque(false);
		BotaoMesa15.setContentAreaFilled(false);
		BotaoMesa15.setBorderPainted(false);
		BotaoMesa15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/LAYOUT MESAS.png")));
		label_6.setBounds(75, 79, 600, 412);
		panelFecharMesa.add(label_6);
		
		lblMesas = new JLabel("ESCOLHA A MESA:");
		lblMesas.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblMesas.setBounds(305, 11, 140, 36);
		panelFecharMesa.add(lblMesas);

		btnCancelar_1 = new JButton("CANCELAR");
		btnCancelar_1.setFocusable(false);
		btnCancelar_1.setFocusTraversalPolicyProvider(false);
		btnCancelar_1.setFocusTraversalKeysEnabled(false);
		btnCancelar_1.setFocusPainted(false);
		btnCancelar_1.setFocusCycleRoot(false);
		btnCancelar_1.setForeground(new Color(255, 255, 255));
		btnCancelar_1.setBackground(new Color(139, 69, 19));
		btnCancelar_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelar_1.setBounds(305, 500, 140, 36);
		panelFecharMesa.add(btnCancelar_1);
		btnCancelar_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelFecharMesa.setVisible(false);

			}
		});

		/** Panel Pagamento **/
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setVisible(false);
		panelPagamento.setBounds(224, 45, 750, 571);
		contentPane.add(panelPagamento);
		panelPagamento.setBackground(new Color(245, 222, 179));
		panelPagamento.setLayout(null);

		JLabel lblPagamento = new JLabel("PAGAMENTO:");
		lblPagamento.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblPagamento.setBounds(325, 11, 100, 36);
		panelPagamento.add(lblPagamento);

		table_4 = new JTable();
		table_4.setBounds(10, 60, 730, 324);
		panelPagamento.add(table_4);

		JRadioButton rdbtnLanches = new JRadioButton("Lanches");
		rdbtnLanches.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnLanches.setBounds(10, 391, 109, 23);
		panelPagamento.add(rdbtnLanches);

		JRadioButton rdbtnPetiscos = new JRadioButton("Petiscos");
		rdbtnPetiscos.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnPetiscos.setBounds(10, 417, 109, 23);
		panelPagamento.add(rdbtnPetiscos);

		JRadioButton rdbtnPores = new JRadioButton("Por\u00E7\u00F5es");
		rdbtnPores.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnPores.setBounds(121, 391, 109, 23);
		panelPagamento.add(rdbtnPores);

		JRadioButton rdbtnBebidas = new JRadioButton("Bebidas");
		rdbtnBebidas.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnBebidas.setBounds(232, 391, 109, 23);
		panelPagamento.add(rdbtnBebidas);

		rdbtnDoces = new JRadioButton("Doces");
		rdbtnDoces.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnDoces.setBounds(121, 417, 109, 23);
		panelPagamento.add(rdbtnDoces);

		JRadioButton rdbtnAdicionais = new JRadioButton("Adicionais");
		rdbtnAdicionais.setFont(new Font("Agency FB", Font.PLAIN, 22));
		rdbtnAdicionais.setBounds(232, 417, 109, 23);
		panelPagamento.add(rdbtnAdicionais);

		JCheckBox chckbxNewCheckBox = new JCheckBox("SELECIONAR TODOS");
		chckbxNewCheckBox.setFont(new Font("Agency FB", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(535, 403, 175, 23);
		panelPagamento.add(chckbxNewCheckBox);

		JLabel lblValorTotal = new JLabel("VALOR TOTAL:");
		lblValorTotal.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblValorTotal.setBounds(320, 463, 109, 36);
		panelPagamento.add(lblValorTotal);

		JLabel lblFormaDePagamento = new JLabel("FORMA DE PAGAMENTO:");
		lblFormaDePagamento.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblFormaDePagamento.setBounds(45, 463, 185, 36);
		panelPagamento.add(lblFormaDePagamento);

		JFormattedTextField valorTotal = new JFormattedTextField();
		valorTotal.setBounds(302, 502, 145, 36);
		panelPagamento.add(valorTotal);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(68, 502, 145, 36);
		panelPagamento.add(comboBox_1);

		JButton btnNewButton = new JButton("PAGAR");
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setBounds(565, 463, 145, 36);
		panelPagamento.add(btnNewButton);

		JButton btnCancelar_2 = new JButton("CANCELAR");
		btnCancelar_2.setFocusable(false);
		btnCancelar_2.setFocusTraversalKeysEnabled(false);
		btnCancelar_2.setFocusPainted(false);
		btnCancelar_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelar_2.setForeground(new Color(255, 255, 255));
		btnCancelar_2.setBackground(new Color(139, 69, 19));
		btnCancelar_2.setBounds(565, 502, 145, 36);
		btnCancelar_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelPagamento.setVisible(false);

			}
		});
		panelPagamento.add(btnCancelar_2);
		
		/** Panel Fechar Caixa **/

		panelFecharCaixa = new JPanel();
		panelFecharCaixa.setVisible(false);
		panelFecharCaixa.setBounds(224, 45, 750, 571);
		contentPane.add(panelFecharCaixa);
		panelFecharCaixa.setBackground(new Color(245, 222, 179));
		panelFecharCaixa.setLayout(null);

		table_5 = new JTable();
		table_5.setBounds(10, 60, 730, 329);
		panelFecharCaixa.add(table_5);

		lblFecharCaixa = new JLabel("FECHAR CAIXA");
		lblFecharCaixa.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblFecharCaixa.setBounds(319, 11, 112, 36);
		panelFecharCaixa.add(lblFecharCaixa);

		lblValorTotalNo = new JLabel("VALOR TOTAL NO DINHEIRO:");
		lblValorTotalNo.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblValorTotalNo.setBounds(20, 403, 173, 27);
		panelFecharCaixa.add(lblValorTotalNo);

		lblValorTotalNo_1 = new JLabel("VALOR TOTAL NO D\u00C9BITO:");
		lblValorTotalNo_1.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblValorTotalNo_1.setBounds(20, 440, 159, 27);
		panelFecharCaixa.add(lblValorTotalNo_1);

		lblValorTotalNo_2 = new JLabel("VALOR TOTAL NO CR\u00C9DITO:");
		lblValorTotalNo_2.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblValorTotalNo_2.setBounds(20, 480, 173, 27);
		panelFecharCaixa.add(lblValorTotalNo_2);

		lblCaixaContm = new JLabel("CAIXA CONT\u00C9M:");
		lblCaixaContm.setForeground(new Color(139, 69, 19));
		lblCaixaContm.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCaixaContm.setBounds(350, 403, 105, 27);
		panelFecharCaixa.add(lblCaixaContm);

		lblCaixaContm_1 = new JLabel("CAIXA CONT\u00C9M:");
		lblCaixaContm_1.setForeground(new Color(139, 69, 19));
		lblCaixaContm_1.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCaixaContm_1.setBounds(350, 440, 105, 27);
		panelFecharCaixa.add(lblCaixaContm_1);

		lblCaixaContm_2 = new JLabel("CAIXA CONT\u00C9M:");
		lblCaixaContm_2.setForeground(new Color(139, 69, 19));
		lblCaixaContm_2.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCaixaContm_2.setBounds(350, 480, 105, 27);
		panelFecharCaixa.add(lblCaixaContm_2);

		lblCartesFidelidadeConcludos = new JLabel("CART\u00D5ES FIDELIDADE CONCLU\u00CDDOS:");
		lblCartesFidelidadeConcludos.setForeground(new Color(139, 69, 19));
		lblCartesFidelidadeConcludos.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCartesFidelidadeConcludos.setBounds(20, 533, 229, 27);
		panelFecharCaixa.add(lblCartesFidelidadeConcludos);

		textFieldvalorDinheiro = new JTextField();
		textFieldvalorDinheiro.setBounds(203, 400, 108, 30);
		panelFecharCaixa.add(textFieldvalorDinheiro);
		textFieldvalorDinheiro.setColumns(10);

		textFieldvalorDebito = new JTextField();
		textFieldvalorDebito.setColumns(10);
		textFieldvalorDebito.setBounds(203, 440, 108, 30);
		panelFecharCaixa.add(textFieldvalorDebito);

		valorCredito = new JTextField();
		valorCredito.setColumns(10);
		valorCredito.setBounds(203, 480, 108, 30);
		panelFecharCaixa.add(valorCredito);

		textFieldCaixa1 = new JTextField();
		textFieldCaixa1.setColumns(10);
		textFieldCaixa1.setBounds(459, 400, 108, 30);
		panelFecharCaixa.add(textFieldCaixa1);

		textFieldCaixa2 = new JTextField();
		textFieldCaixa2.setColumns(10);
		textFieldCaixa2.setBounds(459, 440, 108, 30);
		panelFecharCaixa.add(textFieldCaixa2);

		textFieldCaixa3 = new JTextField();
		textFieldCaixa3.setColumns(10);
		textFieldCaixa3.setBounds(459, 480, 108, 30);
		panelFecharCaixa.add(textFieldCaixa3);

		textFieldCartaoFidelidade = new JTextField();
		textFieldCartaoFidelidade.setColumns(10);
		textFieldCartaoFidelidade.setBounds(249, 530, 108, 30);
		panelFecharCaixa.add(textFieldCartaoFidelidade);

		btnFechar = new JButton("FECHAR CAIXA");
		btnFechar.setFocusable(false);
		btnFechar.setFocusTraversalKeysEnabled(false);
		btnFechar.setFocusPainted(false);
		btnFechar.setFont(new Font("Agency FB", Font.PLAIN, 22));
		btnFechar.setForeground(new Color(255, 255, 255));
		btnFechar.setBackground(new Color(139, 69, 19));
		btnFechar.setBounds(615, 403, 125, 63);
		panelFecharCaixa.add(btnFechar);

		btnCancelarCaixa = new JButton("CANCELAR");
		btnCancelarCaixa.setFocusable(false);
		btnCancelarCaixa.setFocusTraversalKeysEnabled(false);
		btnCancelarCaixa.setFocusPainted(false);
		btnCancelarCaixa.setFont(new Font("Agency FB", Font.PLAIN, 22));
		btnCancelarCaixa.setForeground(new Color(255, 255, 255));
		btnCancelarCaixa.setBackground(new Color(139, 69, 19));
		btnCancelarCaixa.setBounds(615, 485, 125, 63);
		btnCancelarCaixa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelFecharCaixa.setVisible(false);

			}
		});
		panelFecharCaixa.add(btnCancelarCaixa);
		
		/** Panel Cadastro Cliente **/

		JPanel panelCadastroCliente = new JPanel();
		panelCadastroCliente.setVisible(false);
		panelCadastroCliente.setBounds(224, 38, 750, 571);
		contentPane.add(panelCadastroCliente);
		panelCadastroCliente.setBackground(new Color(245, 222, 179));
		panelCadastroCliente.setLayout(null);

		JLabel lblCadastroCliente = new JLabel("CADASTRO CLIENTE:");
		lblCadastroCliente.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblCadastroCliente.setBounds(296, 11, 157, 36);
		panelCadastroCliente.add(lblCadastroCliente);

		JLabel lblNomeCliente = new JLabel("NOME CLIENTE:");
		lblNomeCliente.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNomeCliente.setBounds(10, 62, 94, 50);
		panelCadastroCliente.add(lblNomeCliente);

		JLabel lblTelefone = new JLabel("ENDERE\u00C7O:");
		lblTelefone.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblTelefone.setBounds(10, 123, 70, 50);
		panelCadastroCliente.add(lblTelefone);

		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblN.setBounds(567, 123, 28, 50);
		panelCadastroCliente.add(lblN);

		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblBairro.setBounds(10, 184, 52, 50);
		panelCadastroCliente.add(lblBairro);

		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCidade.setBounds(296, 184, 50, 50);
		panelCadastroCliente.add(lblCidade);

		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEstado.setBounds(546, 184, 59, 50);
		panelCadastroCliente.add(lblEstado);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCpf.setBounds(10, 245, 28, 50);
		panelCadastroCliente.add(lblCpf);

		JLabel lblIdFidelidade = new JLabel("ID FIDELIDADE:");
		lblIdFidelidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblIdFidelidade.setBounds(296, 245, 90, 50);
		panelCadastroCliente.add(lblIdFidelidade);

		labelAvisoProblema = new JLabel("");
		labelAvisoProblema.setForeground(new Color(255, 0, 0));
		labelAvisoProblema.setFont(new Font("Agency FB", Font.PLAIN, 22));
		labelAvisoProblema.setBounds(10, 318, 443, 50);
		panelCadastroCliente.add(labelAvisoProblema);

		JTextField textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNomeCliente.setBounds(108, 70, 632, 36);
		panelCadastroCliente.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(85, 130, 451, 36);
		panelCadastroCliente.add(textFieldEndereco);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(66, 190, 157, 36);
		panelCadastroCliente.add(textFieldBairro);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(356, 190, 157, 36);
		panelCadastroCliente.add(textFieldCidade);

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(594, 130, 70, 36);
		panelCadastroCliente.add(textFieldNumero);

		JTextField textFieldFidelidade = new JTextField();
		textFieldFidelidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldFidelidade.setColumns(10);
		textFieldFidelidade.setBounds(396, 253, 70, 36);
		panelCadastroCliente.add(textFieldFidelidade);

		FormattedEstado = new JFormattedTextField();
		FormattedEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedEstado.setBounds(605, 190, 59, 36);
		panelCadastroCliente.add(FormattedEstado);

		FormattedCPF = new JFormattedTextField();
		FormattedCPF.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedCPF.setBounds(48, 248, 175, 36);
		panelCadastroCliente.add(FormattedCPF);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(139, 69, 19));
		btnCadastrar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCadastrar.setBounds(115, 379, 256, 55);
		panelCadastroCliente.add(btnCadastrar);

		JButton btnLimpar = new JButton("LIMPAR DADOS");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setBackground(new Color(139, 69, 19));
		btnLimpar.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnLimpar.setBounds(378, 379, 256, 55);
		panelCadastroCliente.add(btnLimpar);

		JButton btnCancelarCadastro = new JButton("CANCELAR");
		btnCancelarCadastro.setForeground(new Color(255, 255, 255));
		btnCancelarCadastro.setBackground(new Color(139, 69, 19));
		btnCancelarCadastro.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarCadastro.setBounds(115, 455, 519, 55);
		panelCadastroCliente.add(btnCancelarCadastro);
		
		/** Panel Listagem CLientes **/

		JPanel panelListagemClientes = new JPanel();
		panelListagemClientes.setVisible(false);
		panelListagemClientes.setBounds(224, 38, 750, 571);
		contentPane.add(panelListagemClientes);
		panelListagemClientes.setBackground(new Color(245, 222, 179));
		panelListagemClientes.setLayout(null);

		JLabel lblListagemDeClientes = new JLabel("LISTAGEM DE CLIENTES");
		lblListagemDeClientes.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblListagemDeClientes.setBounds(277, 11, 195, 36);
		panelListagemClientes.add(lblListagemDeClientes);

		JTable tabelaClientes = new JTable();
		tabelaClientes.setBounds(21, 58, 708, 438);
		panelListagemClientes.add(tabelaClientes);

		JButton btnCancelarClientes = new JButton("CANCELAR");
		btnCancelarClientes.setForeground(new Color(255, 255, 255));
		btnCancelarClientes.setBackground(new Color(139, 69, 19));
		btnCancelarClientes.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarClientes.setBounds(487, 519, 158, 41);
		panelListagemClientes.add(btnCancelarClientes);
		btnCancelarClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelListagemClientes.setVisible(false);
				
			}
		});

		JButton btnAlterarClientes = new JButton("ALTERAR");
		btnAlterarClientes.setForeground(new Color(255, 255, 255));
		btnAlterarClientes.setBackground(new Color(139, 69, 19));
		btnAlterarClientes.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterarClientes.setBounds(105, 519, 158, 41);
		panelListagemClientes.add(btnAlterarClientes);
		btnAlterarClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(true);
				

			}
		});
		
		/** Panel Alterar Clientes **/
		
		panelAlterarClientes = new JPanel();
		panelAlterarClientes.setVisible(false);
		panelAlterarClientes.setBounds(224, 45, 750, 571);
		contentPane.add(panelAlterarClientes);
		panelAlterarClientes.setBackground(new Color(245, 222, 179));
		panelAlterarClientes.setLayout(null);
		
		JLabel lblAlteracaoCliente = new JLabel("ALTERAR CLIENTE:");
		lblAlteracaoCliente.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblAlteracaoCliente.setBounds(304, 11, 141, 36);
		panelAlterarClientes.add(lblAlteracaoCliente);

		lblNomeCliente = new JLabel("NOME CLIENTE:");
		lblNomeCliente.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNomeCliente.setBounds(10, 62, 94, 50);
		panelAlterarClientes.add(lblNomeCliente);

		JLabel lblEndereco = new JLabel("ENDERE\u00C7O:");
		lblEndereco.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEndereco.setBounds(10, 123, 70, 50);
		panelAlterarClientes.add(lblEndereco);

		lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblN.setBounds(567, 123, 28, 50);
		panelAlterarClientes.add(lblN);

		lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblBairro.setBounds(10, 184, 52, 50);
		panelAlterarClientes.add(lblBairro);

		lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCidade.setBounds(296, 184, 50, 50);
		panelAlterarClientes.add(lblCidade);

		lblEstado = new JLabel("ESTADO:");
		lblEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEstado.setBounds(546, 184, 59, 50);
		panelAlterarClientes.add(lblEstado);

		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCpf.setBounds(10, 245, 28, 50);
		panelAlterarClientes.add(lblCpf);

		lblIdFidelidade = new JLabel("ID FIDELIDADE:");
		lblIdFidelidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblIdFidelidade.setBounds(296, 245, 90, 50);
		panelAlterarClientes.add(lblIdFidelidade);

		labelAvisoProblema = new JLabel("");
		labelAvisoProblema.setForeground(new Color(255, 0, 0));
		labelAvisoProblema.setFont(new Font("Agency FB", Font.PLAIN, 22));
		labelAvisoProblema.setBounds(10, 318, 443, 50);
		panelAlterarClientes.add(labelAvisoProblema);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNomeCliente.setBounds(108, 70, 337, 36);
		panelAlterarClientes.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(85, 130, 451, 36);
		panelAlterarClientes.add(textFieldEndereco);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(66, 190, 157, 36);
		panelAlterarClientes.add(textFieldBairro);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(356, 190, 157, 36);
		panelAlterarClientes.add(textFieldCidade);

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(594, 130, 70, 36);
		panelAlterarClientes.add(textFieldNumero);

		textFieldFidelidade = new JTextField();
		textFieldFidelidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldFidelidade.setColumns(10);
		textFieldFidelidade.setBounds(396, 253, 70, 36);
		panelAlterarClientes.add(textFieldFidelidade);

		FormattedEstado = new JFormattedTextField();
		FormattedEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedEstado.setBounds(605, 190, 59, 36);
		panelAlterarClientes.add(FormattedEstado);

		FormattedCPF = new JFormattedTextField();
		FormattedCPF.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedCPF.setBounds(48, 248, 175, 36);
		panelAlterarClientes.add(FormattedCPF);

		JButton btnAlterarCliente = new JButton("ALTERAR");
		btnAlterarCliente.setForeground(new Color(255, 255, 255));
		btnAlterarCliente.setBackground(new Color(139, 69, 19));
		btnAlterarCliente.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterarCliente.setBounds(115, 358, 519, 55);
		panelAlterarClientes.add(btnAlterarCliente);

		btnCancelarCadastro = new JButton("CANCELAR");
		btnCancelarCadastro.setForeground(new Color(255, 255, 255));
		btnCancelarCadastro.setBackground(new Color(139, 69, 19));
		btnCancelarCadastro.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarCadastro.setBounds(115, 434, 519, 55);
		panelAlterarClientes.add(btnCancelarCadastro);
		
		JLabel lblTelefoneClientes = new JLabel("TELEFONE:");
		lblTelefoneClientes.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblTelefoneClientes.setBounds(479, 62, 70, 50);
		panelAlterarClientes.add(lblTelefoneClientes);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Agency FB", Font.PLAIN, 22));
		formattedTextField_1.setBounds(548, 70, 175, 36);
		panelAlterarClientes.add(formattedTextField_1);
		
		/** Panel Cadastro Funcionarios **/
		
		JPanel panelCadastroFuncionarios = new JPanel();
		panelCadastroFuncionarios.setVisible(false);
		panelCadastroFuncionarios.setBounds(224, 45, 750, 571);
		contentPane.add(panelCadastroFuncionarios);
		panelCadastroFuncionarios.setBackground(new Color(245, 222, 179));
		panelCadastroFuncionarios.setLayout(null);
		
		lblCadastroFuncionario = new JLabel("CADASTRO FUNCION\u00C1RIO:");
		lblCadastroFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblCadastroFuncionario.setBounds(276, 11, 198, 36);
		panelCadastroFuncionarios.add(lblCadastroFuncionario);

		lblNomeFuncionario = new JLabel("NOME FUNCION\u00C1RIO:");
		lblNomeFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNomeFuncionario.setBounds(10, 62, 129, 50);
		panelCadastroFuncionarios.add(lblNomeFuncionario);

		lblEnderecoFuncionario = new JLabel("ENDERE\u00C7O:");
		lblEnderecoFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEnderecoFuncionario.setBounds(10, 123, 70, 50);
		panelCadastroFuncionarios.add(lblEnderecoFuncionario);

		JLabel lblNumeroFuncionario = new JLabel("N\u00BA:");
		lblNumeroFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNumeroFuncionario.setBounds(567, 123, 28, 50);
		panelCadastroFuncionarios.add(lblNumeroFuncionario);

		JLabel lblBairroFuncionario = new JLabel("BAIRRO:");
		lblBairroFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblBairroFuncionario.setBounds(10, 184, 52, 50);
		panelCadastroFuncionarios.add(lblBairroFuncionario);

		JLabel lblCidadeFuncionario = new JLabel("CIDADE:");
		lblCidadeFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCidadeFuncionario.setBounds(296, 184, 50, 50);
		panelCadastroFuncionarios.add(lblCidadeFuncionario);

		JLabel lblEstadoFuncionario = new JLabel("ESTADO:");
		lblEstadoFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEstadoFuncionario.setBounds(546, 184, 59, 50);
		panelCadastroFuncionarios.add(lblEstadoFuncionario);

		JLabel lblCpfFuncionario = new JLabel("CPF:");
		lblCpfFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCpfFuncionario.setBounds(10, 245, 28, 50);
		panelCadastroFuncionarios.add(lblCpfFuncionario);

		labelAvisoProblema = new JLabel("");
		labelAvisoProblema.setForeground(new Color(255, 0, 0));
		labelAvisoProblema.setFont(new Font("Agency FB", Font.PLAIN, 22));
		labelAvisoProblema.setBounds(31, 306, 443, 50);
		panelCadastroFuncionarios.add(labelAvisoProblema);
		
		labelTelefone = new JLabel("TELEFONE:");
		labelTelefone.setFont(new Font("Agency FB", Font.PLAIN, 22));
		labelTelefone.setBounds(505, 62, 90, 50);
		panelCadastroFuncionarios.add(labelTelefone);
		
		JLabel lblCargo = new JLabel("CARGO:");
		lblCargo.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCargo.setBounds(296, 245, 50, 50);
		panelCadastroFuncionarios.add(lblCargo);

		textFieldNomeFuncionario = new JTextField();
		textFieldNomeFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNomeFuncionario.setBounds(149, 70, 325, 36);
		panelCadastroFuncionarios.add(textFieldNomeFuncionario);
		textFieldNomeFuncionario.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(85, 130, 451, 36);
		panelCadastroFuncionarios.add(textFieldEndereco);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(66, 190, 157, 36);
		panelCadastroFuncionarios.add(textFieldBairro);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(356, 190, 157, 36);
		panelCadastroFuncionarios.add(textFieldCidade);

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(594, 130, 70, 36);
		panelCadastroFuncionarios.add(textFieldNumero);

		FormattedEstado = new JFormattedTextField();
		FormattedEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedEstado.setBounds(605, 190, 59, 36);
		panelCadastroFuncionarios.add(FormattedEstado);

		FormattedCPF = new JFormattedTextField();
		FormattedCPF.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedCPF.setBounds(48, 248, 175, 36);
		panelCadastroFuncionarios.add(FormattedCPF);
		
		FormattedTelefone = new JFormattedTextField();
		FormattedTelefone.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedTelefone.setBounds(578, 70, 146, 36);
		panelCadastroFuncionarios.add(FormattedTelefone);
		
		JComboBox ComboCargos = new JComboBox();
		ComboCargos.setBounds(384, 245, 129, 36);
		panelCadastroFuncionarios.add(ComboCargos);

		btnCadastrarFuncionario = new JButton("CADASTRAR");
		btnCadastrarFuncionario.setForeground(new Color(255, 255, 255));
		btnCadastrarFuncionario.setBackground(new Color(139, 69, 19));
		btnCadastrarFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCadastrarFuncionario.setBounds(115, 379, 256, 55);
		panelCadastroFuncionarios.add(btnCadastrarFuncionario);

		btnLimparDados = new JButton("LIMPAR DADOS");
		btnLimparDados.setForeground(new Color(255, 255, 255));
		btnLimparDados.setBackground(new Color(139, 69, 19));
		btnLimparDados.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnLimparDados.setBounds(378, 379, 256, 55);
		panelCadastroFuncionarios.add(btnLimparDados);

		JButton btnCancelarCadastroFuncionario = new JButton("CANCELAR");
		btnCancelarCadastroFuncionario.setForeground(new Color(255, 255, 255));
		btnCancelarCadastroFuncionario.setBackground(new Color(139, 69, 19));
		btnCancelarCadastroFuncionario.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarCadastroFuncionario.setBounds(115, 455, 519, 55);
		panelCadastroFuncionarios.add(btnCancelarCadastroFuncionario);
		
		/** Panel Listagem Funcionarios **/
		
		JPanel panelListagemFuncionarios = new JPanel();
		panelListagemFuncionarios.setVisible(false);
		panelListagemFuncionarios.setBounds(224, 38, 750, 571);
		contentPane.add(panelListagemFuncionarios);
		panelListagemFuncionarios.setBackground(new Color(245, 222, 179));
		panelListagemFuncionarios.setLayout(null);

		JLabel lblListagemDeFuncionarios = new JLabel("LISTAGEM DE FUNCIONARIOS:");
		lblListagemDeFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblListagemDeFuncionarios.setBounds(262, 11, 226, 36);
		panelListagemFuncionarios.add(lblListagemDeFuncionarios);

		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setBounds(21, 58, 708, 438);
		panelListagemFuncionarios.add(tabelaFuncionarios);

		JButton btnCancelarFuncionarios = new JButton("CANCELAR");
		btnCancelarFuncionarios.setForeground(new Color(255, 255, 255));
		btnCancelarFuncionarios.setBackground(new Color(139, 69, 19));
		btnCancelarFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarFuncionarios.setBounds(487, 519, 158, 41);
		panelListagemFuncionarios.add(btnCancelarFuncionarios);
		btnCancelarFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelListagemFuncionarios.setVisible(false);
				
			}
		});

		JButton btnAlterarFuncionarios = new JButton("ALTERAR");
		btnAlterarFuncionarios.setForeground(new Color(255, 255, 255));
		btnAlterarFuncionarios.setBackground(new Color(139, 69, 19));
		btnAlterarFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterarFuncionarios.setBounds(105, 519, 158, 41);
		panelListagemFuncionarios.add(btnAlterarFuncionarios);
		btnAlterarFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(true);
				

			}
		});
		
		/** Panel Alterar Funcionarios **/
		
		panelAlterarFuncionarios = new JPanel();
		panelAlterarFuncionarios.setVisible(false);
		panelAlterarFuncionarios.setBounds(224, 45, 750, 571);
		contentPane.add(panelAlterarFuncionarios);
		panelAlterarFuncionarios.setBackground(new Color(245, 222, 179));
		panelAlterarFuncionarios.setLayout(null);
		
		lblAlteracaoFuncionarios = new JLabel("ALTERAR FUNCIONARIO:");
		lblAlteracaoFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblAlteracaoFuncionarios.setBounds(284, 11, 182, 36);
		panelAlterarFuncionarios.add(lblAlteracaoFuncionarios);

		JLabel lblNomeFuncionarios = new JLabel("NOME CLIENTE:");
		lblNomeFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNomeFuncionarios.setBounds(10, 62, 94, 50);
		panelAlterarFuncionarios.add(lblNomeFuncionarios);

		lblEnderecoFuncionarios = new JLabel("ENDERE\u00C7O:");
		lblEnderecoFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEnderecoFuncionarios.setBounds(10, 123, 70, 50);
		panelAlterarFuncionarios.add(lblEnderecoFuncionarios);

		lblNFuncionarios = new JLabel("N\u00BA:");
		lblNFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNFuncionarios.setBounds(567, 123, 28, 50);
		panelAlterarFuncionarios.add(lblNFuncionarios);

		lblBairroFuncionarios = new JLabel("BAIRRO:");
		lblBairroFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblBairroFuncionarios.setBounds(10, 184, 52, 50);
		panelAlterarFuncionarios.add(lblBairroFuncionarios);

		lblCidadeFuncionarios = new JLabel("CIDADE:");
		lblCidadeFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCidadeFuncionarios.setBounds(296, 184, 50, 50);
		panelAlterarFuncionarios.add(lblCidadeFuncionarios);

		lblEstadoFuncionarios = new JLabel("ESTADO:");
		lblEstadoFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEstadoFuncionarios.setBounds(546, 184, 59, 50);
		panelAlterarFuncionarios.add(lblEstadoFuncionarios);

		lblCpfFuncionarios = new JLabel("CPF:");
		lblCpfFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblCpfFuncionarios.setBounds(10, 245, 28, 50);
		panelAlterarFuncionarios.add(lblCpfFuncionarios);

		labelAvisoProblema = new JLabel("");
		labelAvisoProblema.setForeground(new Color(255, 0, 0));
		labelAvisoProblema.setFont(new Font("Agency FB", Font.PLAIN, 22));
		labelAvisoProblema.setBounds(10, 318, 443, 50);
		panelAlterarFuncionarios.add(labelAvisoProblema);
		
		JLabel lblTelefoneFuncionarios = new JLabel("TELEFONE:");
		lblTelefoneFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblTelefoneFuncionarios.setBounds(479, 62, 70, 50);
		panelAlterarFuncionarios.add(lblTelefoneFuncionarios);

		JTextField textFieldNomeFuncionarios = new JTextField();
		textFieldNomeFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNomeFuncionarios.setBounds(108, 70, 337, 36);
		panelAlterarFuncionarios.add(textFieldNomeFuncionarios);
		textFieldNomeFuncionarios.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(85, 130, 451, 36);
		panelAlterarFuncionarios.add(textFieldEndereco);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(66, 190, 157, 36);
		panelAlterarFuncionarios.add(textFieldBairro);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(356, 190, 157, 36);
		panelAlterarFuncionarios.add(textFieldCidade);

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Agency FB", Font.PLAIN, 22));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(594, 130, 70, 36);
		panelAlterarFuncionarios.add(textFieldNumero);

		FormattedEstado = new JFormattedTextField();
		FormattedEstado.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedEstado.setBounds(605, 190, 59, 36);
		panelAlterarFuncionarios.add(FormattedEstado);

		FormattedCPF = new JFormattedTextField();
		FormattedCPF.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedCPF.setBounds(48, 248, 175, 36);
		panelAlterarFuncionarios.add(FormattedCPF);
		
		JFormattedTextField FormattedTelefoneFuncionarios = new JFormattedTextField();
		FormattedTelefoneFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 22));
		FormattedTelefoneFuncionarios.setBounds(548, 70, 175, 36);
		panelAlterarFuncionarios.add(FormattedTelefoneFuncionarios);

		btnAlterarFuncionarios = new JButton("ALTERAR");
		btnAlterarFuncionarios.setForeground(new Color(255, 255, 255));
		btnAlterarFuncionarios.setBackground(new Color(139, 69, 19));
		btnAlterarFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnAlterarFuncionarios.setBounds(115, 358, 519, 55);
		panelAlterarFuncionarios.add(btnAlterarFuncionarios);

		btnCancelarCadastroFuncionarios = new JButton("CANCELAR");
		btnCancelarCadastroFuncionarios.setForeground(new Color(255, 255, 255));
		btnCancelarCadastroFuncionarios.setBackground(new Color(139, 69, 19));
		btnCancelarCadastroFuncionarios.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnCancelarCadastroFuncionarios.setBounds(115, 434, 519, 55);
		panelAlterarFuncionarios.add(btnCancelarCadastroFuncionarios);

		/*************************************************************************************************************/

		/* Painel Ação Cardapio */

		panelCardapio = new JPanel();
		panelCardapio.setVisible(false);
		panelCardapio.setBounds(219, 11, 200, 167);
		contentPane.add(panelCardapio);
		panelCardapio.setLayout(null);
		panelCardapio.setBackground(new Color(245, 222, 179));

		btnCadastroCARDAPIO = new JButton("CADASTRO");
		btnCadastroCARDAPIO.setBounds(31, 24, 138, 53);
		panelCardapio.add(btnCadastroCARDAPIO);
		btnCadastroCARDAPIO.setFocusPainted(false);
		btnCadastroCARDAPIO.setFocusTraversalKeysEnabled(false);
		btnCadastroCARDAPIO.setFocusable(false);
		btnCadastroCARDAPIO.setForeground(Color.WHITE);
		btnCadastroCARDAPIO.setBackground(new Color(139, 69, 19));
		btnCadastroCARDAPIO.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnCadastroCARDAPIO.setVisible(true);
		btnCadastroCARDAPIO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCadastrarProduto.setVisible(true);
				panelCardapio.setVisible(false);
				Categorias_produtosBean cp = new Categorias_produtosBean();
				
				try {
					comboBox.setModel(gd.listarComboBox(cp));
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnListagemLISTAGEM = new JButton("LISTAGEM");
		btnListagemLISTAGEM.setBounds(31, 88, 138, 53);
		panelCardapio.add(btnListagemLISTAGEM);
		btnListagemLISTAGEM.setFocusPainted(false);
		btnListagemLISTAGEM.setFocusTraversalKeysEnabled(false);
		btnListagemLISTAGEM.setFocusable(false);
		btnListagemLISTAGEM.setForeground(Color.WHITE);
		btnListagemLISTAGEM.setVisible(true);
		btnListagemLISTAGEM.setBackground(new Color(139, 69, 19));
		btnListagemLISTAGEM.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnListagemLISTAGEM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListarProdutos.setVisible(true);
				panelCardapio.setVisible(false);
				try {
					table_1.setModel(gd.geraTabela(ProdutosBean.class,new String[]{"Produto", "Valor", "Descrição", "Categoria"},new String[]{"nomeProduto", "valorProduto", "descricaoProduto", "idCategoria"} ));
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});


		/* Painel Ação Mesas */

		panelMesas = new JPanel();
		panelMesas.setVisible(false);
		panelMesas.setBounds(219, 100, 200, 167);
		contentPane.add(panelMesas);
		panelMesas.setLayout(null);
		panelMesas.setBackground(new Color(245, 222, 179));

		btnLayout = new JButton("LAYOUT");
		btnLayout.setBounds(31, 24, 138, 53);
		panelMesas.add(btnLayout);
		btnLayout.setFocusPainted(false);
		btnLayout.setFocusTraversalKeysEnabled(false);
		btnLayout.setFocusable(false);
		btnLayout.setForeground(Color.WHITE);
		btnLayout.setBackground(new Color(139, 69, 19));
		btnLayout.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnLayout.setVisible(true);
		btnLayout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelLayoutMesa.setVisible(true);
				panelMesas.setVisible(false);

			}
		});

		btnListagemMESAS = new JButton("LISTAGEM");
		btnListagemMESAS.setBounds(31, 88, 138, 53);
		panelMesas.add(btnListagemMESAS);
		btnListagemMESAS.setFocusPainted(false);
		btnListagemMESAS.setFocusTraversalKeysEnabled(false);
		btnListagemMESAS.setFocusable(false);
		btnListagemMESAS.setForeground(Color.WHITE);
		btnListagemMESAS.setBackground(new Color(139, 69, 19));
		btnListagemMESAS.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnListagemMESAS.setVisible(true);
		btnListagemMESAS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListagemMesas.setVisible(true);
				panelMesas.setVisible(false);
				

			}
		});

		/* Painel Ação Caixa */

		panelCaixa = new JPanel();
		panelCaixa.setVisible(false);
		panelCaixa.setBounds(219, 189, 200, 167);
		contentPane.add(panelCaixa);
		panelCaixa.setLayout(null);
		panelCaixa.setBackground(new Color(245, 222, 179));

		btnFecharMesa = new JButton("FECHAR MESA");
		btnFecharMesa.setBounds(9, 11, 181, 34);
		panelCaixa.add(btnFecharMesa);
		btnFecharMesa.setFocusPainted(false);
		btnFecharMesa.setFocusTraversalKeysEnabled(false);
		btnFecharMesa.setFocusable(false);
		btnFecharMesa.setForeground(Color.WHITE);
		btnFecharMesa.setBackground(new Color(139, 69, 19));
		btnFecharMesa.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnFecharMesa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelFecharMesa.setVisible(true);
				panelCaixa.setVisible(false);

			}
		});

		btnPagamento = new JButton("PAGAMENTO");
		btnPagamento.setBounds(9, 66, 181, 34);
		panelCaixa.add(btnPagamento);
		btnPagamento.setFocusPainted(false);
		btnPagamento.setFocusTraversalKeysEnabled(false);
		btnPagamento.setFocusable(false);
		btnPagamento.setForeground(Color.WHITE);
		btnPagamento.setBackground(new Color(139, 69, 19));
		btnPagamento.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnPagamento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelPagamento.setVisible(true);
				panelCaixa.setVisible(false);

			}
		});

		btnFecharCaixa = new JButton("FECHAR CAIXA");
		btnFecharCaixa.setBounds(9, 122, 181, 34);
		panelCaixa.add(btnFecharCaixa);
		btnFecharCaixa.setFocusPainted(false);
		btnFecharCaixa.setFocusTraversalKeysEnabled(false);
		btnFecharCaixa.setFocusable(false);
		btnFecharCaixa.setForeground(Color.WHITE);
		btnFecharCaixa.setBackground(new Color(139, 69, 19));
		btnFecharCaixa.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnFecharCaixa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelFecharCaixa.setVisible(true);
				panelCaixa.setVisible(false);

			}
		});
		btnFecharCaixa.setVisible(true);
		btnPagamento.setVisible(true);
		btnFecharMesa.setVisible(true);

		/* Painel Ação Clientes */

		panelClientes = new JPanel();
		panelClientes.setVisible(false);
		panelClientes.setBounds(219, 278, 200, 167);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);
		panelClientes.setBackground(new Color(245, 222, 179));

		btnCadastroCLIENTE = new JButton("CADASTRO");
		btnCadastroCLIENTE.setBounds(31, 24, 138, 53);
		panelClientes.add(btnCadastroCLIENTE);
		btnCadastroCLIENTE.setFocusPainted(false);
		btnCadastroCLIENTE.setFocusTraversalKeysEnabled(false);
		btnCadastroCLIENTE.setFocusable(false);
		btnCadastroCLIENTE.setForeground(Color.WHITE);
		btnCadastroCLIENTE.setBackground(new Color(139, 69, 19));
		btnCadastroCLIENTE.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnCadastroCLIENTE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCadastroCliente.setVisible(true);
				panelClientes.setVisible(false);

			}
		});

		btnListagemCLIENTES = new JButton("LISTAGEM");
		btnListagemCLIENTES.setBounds(31, 88, 138, 53);
		panelClientes.add(btnListagemCLIENTES);
		btnListagemCLIENTES.setFocusPainted(false);
		btnListagemCLIENTES.setFocusTraversalKeysEnabled(false);
		btnListagemCLIENTES.setFocusable(false);
		btnListagemCLIENTES.setForeground(Color.WHITE);
		btnListagemCLIENTES.setBackground(new Color(139, 69, 19));
		btnListagemCLIENTES.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnListagemCLIENTES.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelListagemClientes.setVisible(true);
				panelClientes.setVisible(false);

			}
		});

		btnListagemCLIENTES.setVisible(true);
		btnCadastroCLIENTE.setVisible(true);

		/* Painel Ação Funcionarios */

		panelFuncionarios = new JPanel();
		panelFuncionarios.setVisible(false);
		panelFuncionarios.setBounds(219, 367, 200, 167);
		contentPane.add(panelFuncionarios);
		panelFuncionarios.setLayout(null);
		panelFuncionarios.setBackground(new Color(245, 222, 179));

		btnCadastro = new JButton("CADASTRO");
		btnCadastro.setBounds(31, 24, 138, 53);
		panelFuncionarios.add(btnCadastro);
		btnCadastro.setFocusPainted(false);
		btnCadastro.setFocusTraversalKeysEnabled(false);
		btnCadastro.setFocusable(false);
		btnCadastro.setForeground(Color.WHITE);
		btnCadastro.setBackground(new Color(139, 69, 19));
		btnCadastro.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				panelFuncionarios.setVisible(false);
				panelCadastroFuncionarios.setVisible(true);
				
			}
		});

		btnListagem = new JButton("LISTAGEM");
		btnListagem.setBounds(31, 88, 138, 53);
		panelFuncionarios.add(btnListagem);
		btnListagem.setFocusPainted(false);
		btnListagem.setFocusTraversalKeysEnabled(false);
		btnListagem.setFocusable(false);
		btnListagem.setForeground(Color.WHITE);
		btnListagem.setBackground(new Color(139, 69, 19));
		btnListagem.setFont(new Font("Agency FB", Font.PLAIN, 21));
		btnListagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				panelFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(true);
				
			}
		});


		/****************************************************************************************************************/

		button = new JButton("");
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(255, 255, 255));
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusable(false);
		button.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/CARD\u00C1PIO.png")));
		button.setFont(new Font("Agency FB", Font.PLAIN, 25));
		button.setBounds(0, 11, 107, 78);
		contentPane.add(button);
		button.setFocusPainted(false);
		button.setHorizontalTextPosition(SwingConstants.LEFT);

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				button.setBounds(0, 11, 107, 78);
				button.setText(null);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				button.setBounds(0, 11, 214, 78);
				button.setText("CARDÁPIO     ");
				panelCardapio.setVisible(false);
				panelMesas.setVisible(false);
				panelCaixa.setVisible(false);
				panelClientes.setVisible(false);
				panelFuncionarios.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelCardapio.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelAlterarProdutos.setVisible(false);
				panelListarProdutos.setVisible(false);
				panelFecharMesa.setVisible(false);
				panelPagamento.setVisible(false);
				panelFecharCaixa.setVisible(false);
				panelLayoutMesa.setVisible(false);
				panelListagemMesas.setVisible(false);
				panelCadastroCliente.setVisible(false);
				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(false);
				panelCadastroFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(false);

			}
		});

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setFocusTraversalKeysEnabled(false);
		button_1.setFocusable(false);
		button_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/MESAS.png")));
		button_1.setFont(new Font("Agency FB", Font.PLAIN, 25));
		button_1.setBounds(0, 100, 107, 78);
		contentPane.add(button_1);
		button_1.setFocusPainted(false);
		button_1.setHorizontalTextPosition(SwingConstants.LEFT);

		button_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				button_1.setBounds(0, 100, 107, 78);
				button_1.setText(null);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				button_1.setBounds(0, 100, 214, 78);
				button_1.setText("MESAS       ");
				panelCardapio.setVisible(false);
				panelMesas.setVisible(false);
				panelCaixa.setVisible(false);
				panelClientes.setVisible(false);
				panelFuncionarios.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelMesas.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelAlterarProdutos.setVisible(false);
				panelListarProdutos.setVisible(false);
				panelFecharMesa.setVisible(false);
				panelPagamento.setVisible(false);
				panelFecharCaixa.setVisible(false);
				panelLayoutMesa.setVisible(false);
				panelListagemMesas.setVisible(false);
				panelCadastroCliente.setVisible(false);
				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(false);
				panelCadastroFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(false);
			}
		});

		button_2 = new JButton("");
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(new Color(255, 255, 255));
		button_2.setFocusTraversalKeysEnabled(false);
		button_2.setFocusable(false);
		button_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/CAIXA.png")));
		button_2.setFont(new Font("Agency FB", Font.PLAIN, 25));
		button_2.setBounds(0, 189, 107, 78);
		contentPane.add(button_2);
		button_2.setFocusPainted(false);
		button_2.setHorizontalTextPosition(SwingConstants.LEFT);

		button_2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				button_2.setBounds(0, 189, 107, 78);
				button_2.setText(null);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				button_2.setBounds(0, 189, 214, 78);
				button_2.setText("CAIXA         ");
				panelCardapio.setVisible(false);
				panelMesas.setVisible(false);
				panelCaixa.setVisible(false);
				panelClientes.setVisible(false);
				panelFuncionarios.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelCaixa.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelAlterarProdutos.setVisible(false);
				panelListarProdutos.setVisible(false);
				panelFecharMesa.setVisible(false);
				panelPagamento.setVisible(false);
				panelFecharCaixa.setVisible(false);
				panelLayoutMesa.setVisible(false);
				panelListagemMesas.setVisible(false);
				panelCadastroCliente.setVisible(false);
				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(false);
				panelCadastroFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(false);

			}
		});

		button_3 = new JButton("");
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(new Color(255, 255, 255));
		button_3.setFocusTraversalKeysEnabled(false);
		button_3.setFocusable(false);
		button_3.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/USU\u00C1RIO.png")));
		button_3.setFont(new Font("Agency FB", Font.PLAIN, 25));
		button_3.setBounds(0, 278, 107, 78);
		contentPane.add(button_3);
		button_3.setFocusPainted(false);
		button_3.setHorizontalTextPosition(SwingConstants.LEFT);

		button_3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				button_3.setBounds(0, 278, 107, 78);
				button_3.setText(null);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				button_3.setBounds(0, 278, 214, 78);
				button_3.setText("CLIENTES        ");
				panelCardapio.setVisible(false);
				panelMesas.setVisible(false);
				panelCaixa.setVisible(false);
				panelClientes.setVisible(false);
				panelFuncionarios.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelClientes.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelAlterarProdutos.setVisible(false);
				panelListarProdutos.setVisible(false);
				panelFecharMesa.setVisible(false);
				panelPagamento.setVisible(false);
				panelFecharCaixa.setVisible(false);
				panelLayoutMesa.setVisible(false);
				panelListagemMesas.setVisible(false);
				panelCadastroCliente.setVisible(false);
				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(false);
				panelCadastroFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(false);

			}
		});

		button_4 = new JButton("");
		button_4.setForeground(Color.BLACK);
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setFocusTraversalKeysEnabled(false);
		button_4.setFocusable(false);
		button_4.setFont(new Font("Agency FB", Font.PLAIN, 25));
		button_4.setBounds(0, 367, 107, 78);
		contentPane.add(button_4);
		button_4.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/GAR\u00C7ON.png")));
		button_4.setFocusPainted(false);
		button_4.setHorizontalTextPosition(SwingConstants.LEFT);

		button_4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				button_4.setBounds(0, 367, 107, 78);
				button_4.setText("");

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				button_4.setBounds(0, 367, 214, 78);
				button_4.setText("FUNCIONÁRIOS   ");
				panelCardapio.setVisible(false);
				panelMesas.setVisible(false);
				panelCaixa.setVisible(false);
				panelClientes.setVisible(false);
				panelFuncionarios.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelFuncionarios.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelAlterarProdutos.setVisible(false);
				panelListarProdutos.setVisible(false);
				panelFecharMesa.setVisible(false);
				panelPagamento.setVisible(false);
				panelFecharCaixa.setVisible(false);
				panelLayoutMesa.setVisible(false);
				panelListagemMesas.setVisible(false);
				panelCadastroCliente.setVisible(false);
				panelListagemClientes.setVisible(false);
				panelAlterarClientes.setVisible(false);
				panelCadastroFuncionarios.setVisible(false);
				panelListagemFuncionarios.setVisible(false);
				panelAlterarFuncionarios.setVisible(false);

			}
		});

		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/FUNDO TELA PRINCIPAL.jpg")));
		label_5.setForeground(new Color(245, 245, 220));
		label_5.setBackground(new Color(245, 245, 220));
		label_5.setBounds(0, 0, 1264, 921);
		contentPane.add(label_5);

	}
}
