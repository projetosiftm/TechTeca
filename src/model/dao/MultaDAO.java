package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.javabean.Multa;


public class MultaDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Multa multa = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM multa where id_multa='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				multa = new Multa(rs.getInt("id"), rs.getString("dataVencimentoMulta"), rs.getDouble("valorMulta"),
						rs.getInt("idAdministrador"), rs.getInt("idEmprestimo"),rs.getInt("idItemEmprestimo"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return multa;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Multa multa = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into multa(data_vencimento_multa,valor_multa,id_administrador,id_emprestimo,id_item_emprestimo) values('"
					+ ((Multa) entidade).getDataVencimentoMulta() + "','" 
					+ ((Multa) entidade).getValorMulta() + "','" 
					+ ((Multa) entidade).getIdAdministrador()+ "','" 
					+ ((Multa) entidade).getIdEmprestimo()  + "','" 
					+ ((Multa) entidade).getIdItemEmprestimo()
					+ "');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}

	@Override
	public void excluir(Object id) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from multa where id_multa=" + id;
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}

	@Override
	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<Multa> multa = new ArrayList<Multa>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT m.id_multa,l.foto,l.titulo,l.autor,l.isbn,ex.id_exemplar,"
					+ "e.data_emprestimo,e.data_devolucao,u.nome,m.data_vencimento_multa,m.valor_multa FROM multa as m " + 
					"inner join emprestimo as e " + 
					"ON m.id_emprestimo = e.id_emprestimo " + 
					"inner join item_emprestimo as ie " + 
					"on e.id_emprestimo = ie.id_emprestimo " + 
					"inner join exemplar as ex " + 
					"on ie.id_exemplar = ex.id_exemplar " + 
					"inner join livro as l " + 
					"on ex.id_livro = l.id_livro " + 
					"inner join usuario as u " + 
					"on e.id_usuario = u.id_usuario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				multa.add(new Multa(rs.getInt("id_multa"),
						rs.getString("foto"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getString("isbn"),
						rs.getInt("id_exemplar"),
						rs.getString("data_emprestimo"),
						rs.getString("data_devolucao"), 
						rs.getString("nome"),
						rs.getString("data_vencimento_multa"),
						rs.getDouble("valor_multa")));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return multa;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String dataVencimentoMulta = ((Multa) entidade).getDataVencimentoMulta();
			double valorMulta = ((Multa) entidade).getValorMulta();
			int idAdministrador = ((Multa) entidade).getIdAdministrador();
			int idEmprestimo = ((Multa) entidade).getIdEmprestimo();
			int idItemEmprestimo = ((Multa) entidade).getIdEmprestimo();
			int id = ((Multa) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE multa" + " SET data_vencimento_multa = '" + dataVencimentoMulta + "'," 
					+ " valor_multa ='" + valorMulta + "'," 
					+ " id_administrador = '" + idAdministrador + "',"
					+ " id_emprestimo = '" + idEmprestimo + "',"  
					+ " id_item_emprestimo ='" + idItemEmprestimo + "'" 
					+ " WHERE id_multa = " + id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}
}
