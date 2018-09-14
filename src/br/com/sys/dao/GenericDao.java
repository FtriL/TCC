package br.com.sys.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.Soundbank;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import br.com.sys.bean.ComandasBean;
import br.com.sys.bean.Pedidos_comandasBean;
import br.com.sys.bean.PedidosBean;
import br.com.sys.connection.ConnectionFactory;

public class GenericDao {
	
	//Atributo para conexao
	private Connection conexao;
	
	//Construtor
	public GenericDao() {
		this.conexao = new ConnectionFactory().obterConexao();
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
		list.addElement("-- Selecione --");
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
                    }else if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getInt(s));
                    }else if (pvec[0].getName().equals("double")) {
                        args1[0] = double.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getDouble(s));
                    }else if (pvec[0].getName().equalsIgnoreCase("[B")) {
                    	System.out.println("Byte "+pvec[0].getName());
                        args1[0] = byte.class;
                        obj.getClass().getMethod(m.getName(),
                                args1).invoke(obj, rset.getBinaryStream(s));
                    }
                }
            }
            list.add(obj);
        }

        rset.close();
        stmt.close();
        System.out.println("Lista gerada");
        return list;

    }
    
    public DefaultTableModel geraTabela(Class c, String[] colunas, String[] dados) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException, SQLException {
	    boolean[] canEd = new boolean [dados.length];  
	    for(int x=0; x<dados.length; x++) {
	    	if(x>colunas.length-1) {
	    		canEd[x]=true;
	    	}else{
	    		System.out.println(x);
		    	if((colunas[x].length()>9)) {
		    		if(colunas[x].substring(0, 10).equals("Quantidade")){
		    			canEd[x]=true;
		    		}else {
			    		canEd[x]=false;
	
		    		}
		    		
		    	}else {
		    		canEd[x]=false;
		    	}
	    	}
	    }
	    System.out.println("aqui "+canEd[1]);
    	DefaultTableModel exibirDados = new DefaultTableModel(){    
		    boolean[] canEdit = canEd;    
		    @Override
		    public boolean isCellEditable(int rowIndex, int columnIndex) {      
		        return canEdit [columnIndex];      
		    }    
		};
		
		//Criar colunas
		for (String col : colunas) {
			exibirDados.addColumn(col);
			System.out.println(col);
		}
		String[] linhas = new String[colunas.length];
		List<Object> lista = listarTabela(c);
	
		for (Object l : lista) {
			Object obj = (Object) l;
			
			for(int x = 0; x<colunas.length; x++) {
				for(Method m : c.getMethods()) {
					
					String metodo = m.getName();
					/*if(dados[x].equalsIgnoreCase("Button")) {
						linhas[x]="EXCLUIR";
					}else {*/
						if(metodo.substring(0,3).equalsIgnoreCase("get")){
							if((metodo.substring((3), metodo.length())).equalsIgnoreCase(dados[x])) {
								Class[] args = new Class[1];
	
								System.out.println("-------");

							
								if((dados[x].substring(0,2).equalsIgnoreCase("id")&&(!dados[x].substring(2,dados[x].length()).equalsIgnoreCase("id")))) {
									linhas[x] = selecionadado(dados[x].substring(2, dados[x].length()), dados[x],Integer.parseInt(""+obj.getClass().getMethod(m.getName()).invoke(obj)), 2);
		
								}else if(m.getReturnType().getName().equals("double")) {
									linhas[x] = String.format("%.2f",obj.getClass().getMethod(m.getName()).invoke(obj));
								}else if(m.getReturnType().getName().equals("int")){
									linhas[x] = "" +obj.getClass().getMethod(m.getName()).invoke(obj);
								}else {
									linhas[x] = "" +obj.getClass().getMethod(m.getName()).invoke(obj);
									if(linhas[x].equalsIgnoreCase("0")) {
										linhas[x] = "Não";
									}else if(linhas[x].equalsIgnoreCase("1")) {
										linhas[x] = "Sim";
									}
								}
							}
							//System.out.println("linha"+linhas[x]);
						}
					//}
				}

			}
			

			
			exibirDados.addRow(linhas);
			
			if(dados[dados.length-1].equals("check")) {
				Object ck[] = new Object[exibirDados.getRowCount()];
				for(int x = 0; x<exibirDados.getRowCount();x++) {
					ck[x]= new Boolean(false);
				}
				exibirDados.addColumn("Excluir", ck);
			}

	
		}

		

		
		
		return exibirDados;
	}
    public DefaultTableModel listaMesa(int mesa, String[] colunas, String[] dados) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException, SQLException {
	    System.out.println("mesa"+mesa);
    	boolean[] canEd = new boolean [dados.length];  
	    for(int x=0; x<dados.length; x++) {
	    	if(x>colunas.length-1) {
	    		canEd[x]=true;
	    	}else{
		    	if((colunas[x].length()>9)) {
		    		if(colunas[x].substring(0, 10).equals("Quantidade")){
		    			canEd[x]=true;
		    		}else {
			    		canEd[x]=false;
	
		    		}
		    		
		    	}else {
		    		canEd[x]=false;
		    	}
	    	}
	    }
    	DefaultTableModel exibirDados = new DefaultTableModel(){    
		    boolean[] canEdit = canEd;    
		    @Override
		    public boolean isCellEditable(int rowIndex, int columnIndex) {      
		        return canEdit [columnIndex];      
		    }    
		};
		
		//Criar colunas
		for (String col : colunas) {
			exibirDados.addColumn(col);
			System.out.println(col);
		}
		String[] linhas = new String[colunas.length];
		
		Class c = ComandasBean.class;
		
		List<Object> lista = listarTabela(c);
	
		for (Object l : lista) {
			ComandasBean cb = (ComandasBean) l;
			if(cb.getIdMesa()==mesa) {
				List<Object> lP_C= listarTabela(Pedidos_comandasBean.class);
				
				for (Object ob : lP_C) {
					Pedidos_comandasBean  pc = (Pedidos_comandasBean)ob;
					
					if(pc.getIdComanda()==cb.getIdComanda()) {
						List<Object> lPedidos= listarTabela(PedidosBean.class);
						for (Object o : lPedidos) {
							PedidosBean pb= (PedidosBean)o;
							if(pb.getIdPedido()==pc.getIdPedido()){

								if(pb.getFechadoPedido()==0) {
									System.out.println(pb.getIdPedido()+"Pedido passo"+pb.getFechadoPedido());
									for(int x = 0; x<colunas.length; x++) {
										if(x==0){
											linhas[x]=""+cb.getIdComanda();
										}else if(x==1) {
											linhas[x]=selecionadado("Produto", "idProduto", cb.getIdProduto(), 2);
										}else if(x==2) {
											linhas[x]=""+cb.getQuantidadeComanda();
										}else if(x==3) {
											linhas[x]=String.format("%.2f",cb.getValorUnidadeComanda());														}
										else if(x==4) {
											linhas[x]=String.format("%.2f",cb.getValorTotalComanda());
										}
										else if(x==5) {
											linhas[x]=""+cb.getEmitidaComanda();
											if(linhas[x].equalsIgnoreCase("0")) {
												linhas[x] = "Não";
											}else if(linhas[x].equalsIgnoreCase("1")) {
												linhas[x] = "Sim";
											}
										}

									}
									exibirDados.addRow(linhas);
								}
								
							}
							
						}
					}
				}
	
			}

		}

		if(dados[dados.length-1].equals("check")) {
			Object ck[] = new Object[exibirDados.getRowCount()];
			for(int x = 0; x<exibirDados.getRowCount();x++) {
				ck[x]= new Boolean(false);
			}
			exibirDados.addColumn("Excluir", ck);
		}


		
		
		return exibirDados;
	}
    public String selecionadado(String tabela, String campo, int valor, int coluna) throws SQLException {
    	String select = "";
    	String sql = "SELECT * FROM "+tabela+"s"+" WHERE "+campo+" = ?";
    	System.out.println(sql);
    	PreparedStatement stmt  = this.conexao.prepareStatement(sql);
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




/*recuperar imagem

InputStream input = resultSet.getBinaryStream("coluna_imagem");
if(input != null){
   ByteArrayOutputStream output = new ByteArrayOutputStream();
   // set read buffer size
   byte[] rb = new byte[1024];
   int ch = 0;
   while ((ch = input.read(rb)) != -1){	
       output.write(rb, 0, ch);
   }
   // transfer to byte buffer
   byte[] b = output.toByteArray();
   input.close();
   output.close();
   // onde o método setImagem espera um array de bytes
   umObjeto.setImagem(b);    
   
   email  = DBdesigner == lfrancisco366@gmail.com                 
   senha  = DBdesigner == 56737879887
   
}
*/