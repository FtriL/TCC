package br.com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import br.com.sys.bean.ProdutosBean;
import br.com.sys.connection.ConnectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenericDao {
	
	//Atributo para conexao
	private Connection conexao;
	
	//Construtor
	public GenericDao() {
		//this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionar(Object obj) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException  {
        String campos = "";
        String dados = "";
        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        System.out.println("classe"+classe);
        System.out.println("cls"+cls);
        Field listaAtributos[] = cls.getDeclaredFields();
        String valorIncluir = "";
        String tipoDado;
        for (int i = 1; i < listaAtributos.length; i++) {
        Field fld = listaAtributos[i];
        fld.setAccessible(true);
        campos = campos + fld.getName() + ", ";
        dados = dados + "'" + fld.get(obj) + "'" + ",";
        }
        campos = campos.substring(0, campos.length() - 2);
        String tabela = cls.getSimpleName();
        tabela = tabela.substring(0, tabela.length()-4);
        dados = dados.substring(0, dados.length() - 1);
        String sql = "INSERT INTO " + tabela
        + " (" + campos + ") VALUES ("
        + dados + ")";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            System.out.println(sql);
        stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Registro ADICIONADO ao banco!");
    }
	
    public DefaultComboBoxModel  listarComboBox(Object obj)
    // public void listar(Class c)
    throws SQLException, IllegalAccessException, NoSuchMethodException,
    IllegalArgumentException, InvocationTargetException,
    InstantiationException, ClassNotFoundException {
	
		String tabela = (Class.forName(obj.getClass().getName())).getSimpleName(); //Retorna o nome da classe
		tabela = tabela.substring(0, tabela.length()-4);
		String sql = "SELECT * FROM " + tabela;
		System.out.println(sql);
		Statement stmt = conexao.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		DefaultComboBoxModel list = new DefaultComboBoxModel();
		while (rset.next()) {
			list.addElement(rset.getString(2));

		}
		rset.close();
		stmt.close();
		
		return list;
	
	}

    public List<Object> listarTabela(Class c)
            // public void listar(Class c)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        List<Object> list = new ArrayList<Object>();
        String tabela = c.getSimpleName(); //Retorna o nome da classe
        tabela = tabela.substring(0, tabela.length()-4);
        String sql = "SELECT * FROM " + tabela;

        PreparedStatement stmt
                = this.conexao.prepareStatement(sql);
        ResultSet rset = stmt.executeQuery();

        while (rset.next()) {
            Object obj = c.newInstance();
            for (Method m : c.getMethods()) {
                // System.out.println("if 0: "+m);
                if (m.getName().substring(0, 3).equals("set")) {
                    Class[] args1 = new Class[1];
                    Class pvec[] = m.getParameterTypes();
                    String s = m.getName().substring(3, m.getName().length());
                    //    System.out.println("if 1: "+m.getName());
                    if (pvec[0].getName().equals("java.lang.String")) {
                        args1[0] = String.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getString(s));
                    }

                    if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getInt(s));
                    }
                    if (pvec[0].getName().equals("double")) {
                        args1[0] = double.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getDouble(s));
                    }
                }
            }
            list.add(obj);
        }

        rset.close();
        stmt.close();

        return list;

    }
    
    public DefaultTableModel geraTabela(Class c, String[] colunas, String[] dados) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException, SQLException {
		DefaultTableModel exibirDados = new DefaultTableModel();
		
		//Criar colunas
		for (String col : colunas) {
			exibirDados.addColumn(c);
		}
		String[] linhas = new String[colunas.length];
		List<Object> lista = listarTabela(c);
	
		for (Object l : lista) {
			Object obj = l;
			for(int x = 0; x<colunas.length; x++) {
				for(Method m : c.getMethods()) {
					String metodo = m.getName();
					if((metodo.substring((metodo.length()-dados[x].length()), metodo.length())).equalsIgnoreCase(dados[x])) {
						if(dados[x].substring(0,2).equalsIgnoreCase("id")) {
							linhas[x] = selecionadado(c.getSimpleName().substring(0,c.getSimpleName().length()-4), dados[x],Integer.parseInt(""+obj.getClass().getMethod(m.getName(), int.class)), 2);
						}else if(m.getParameterTypes().equals("double")) {
							linhas[x] = String.format("%.2f",obj.getClass().getMethod(m.getName(), double.class));
						}else if(m.getParameterTypes().equals("int")) {
							linhas[x] = ""+obj.getClass().getMethod(m.getName(), int.class);
						}else {
							linhas[x] = ""+obj.getClass().getMethod(m.getName(), String.class);
						}
					}
				}

			}
 
			
			exibirDados.addRow(linhas);
		}
		

		
		
		return exibirDados;
	}
    public String selecionadado(String tabela, String campo, int valor, int coluna) throws SQLException {
    	String select = "";
    	String sql = "SELECT * FROM ? where ? = ?";
    	PreparedStatement stmt  = this.conexao.prepareStatement(sql);
        stmt.setString(1, tabela);
        stmt.setString(2, campo);
        stmt.setInt(1, valor);
        ResultSet rs = stmt.executeQuery();

        rs.last();
 
        select = rs.getString(coluna);
        
		rs.close();
		stmt.close();
		return select;
    	
    }

    public void alterar(Object obj) throws ClassNotFoundException,
            SQLException, IllegalArgumentException,
            IllegalAccessException {

        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        String pK = "";
        String campos = "";
        String lugar = "";
        String tabela = cls.getSimpleName();
        tabela = tabela.substring(0, tabela.length()-4);
        String baseDados = conexao.getCatalog();

        Field listaAtributos[] = cls.getDeclaredFields();

        String sql3 = "SELECT information_schema.KEY_COLUMN_USAGE.COLUMN_NAME as \"chave\" \n"
                + "FROM information_schema.KEY_COLUMN_USAGE \n"
                + "WHERE information_schema.KEY_COLUMN_USAGE.CONSTRAINT_NAME LIKE \"PRIMARY\" \n"
                + "AND information_schema.KEY_COLUMN_USAGE.TABLE_SCHEMA LIKE \"" + baseDados + "\""
                + " AND information_schema.KEY_COLUMN_USAGE.TABLE_NAME LIKE \"" + tabela + "\"";
        // System.out.println("sql3: " + sql3);

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            campos += fld.getName() + " = '" + fld.get(obj) + "'";
            if (i != (listaAtributos.length - 1)) {
                campos += ", ";
            }
            PreparedStatement stmt = conexao.prepareCall(sql3);
            ResultSet RS = stmt.executeQuery();

            while (RS.next()) {
                // Object nextElement = en.nextElement();
                pK = RS.getString("chave");
            }
            if (fld.getType().toString().equals("int")) {
                if (fld.getName().equalsIgnoreCase(pK)) {
                    lugar = fld.getName() + " = '" + fld.get(obj) + "'";
                }
            }
        }
        String sql = "UPDATE " + tabela + " SET " + campos + " WHERE " + lugar + "";
        PreparedStatement stmt = conexao.prepareCall(sql);
        System.out.println(sql);
        stmt.execute();
        stmt.close();
        System.out.println("Registro Alterado!!!");
    }

    public void excluir(Object obj) throws ClassNotFoundException,
            NoSuchFieldException, SQLException {

        String campoTeste = null;
        String campo = null;
        int valorExcluir = 0;
        String classe = obj.getClass().getName();//Nome da classe
        Class cls = Class.forName(classe); //Nome da classe (tabela)
        Field listaAtributos[] = cls.getDeclaredFields(); //array de campos

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);

            try {
                System.out.println("Valor...........: " + fld.get(obj));
                campoTeste = fld.get(obj).toString();
                if (!campoTeste.equals("0")) {
                    System.out.println("OK");
                    campo = fld.getName();
                    valorExcluir = (int) fld.get(obj);
                    break;
                }
            } catch (IllegalAccessException ex) {
                System.out.println("erro: " + ex);
            } catch (NullPointerException ex) {
                campoTeste = null;
            }
        }

        String tabela = cls.getSimpleName();
        tabela = tabela.substring(0, tabela.length()-4);
        String sql = "DELETE FROM " + tabela + " WHERE " + campo + " =?";
        System.out.println("SQL: " + sql);

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, valorExcluir);
        stmt.execute();
        stmt.close();
        System.out.println("Registro EXCLUÍDO no banco!");
    }

}
