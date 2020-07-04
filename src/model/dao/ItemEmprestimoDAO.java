package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.ItemEmprestimo;

public class ItemEmprestimoDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		ItemEmprestimo itemEmprestimo = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM item_emprestimo where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				itemEmprestimo = new ItemEmprestimo(rs.getInt("id"), rs.getInt("idExemplar"),rs.getInt("idEmprestimo"));
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
		return itemEmprestimo;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		ItemEmprestimo itemEmprestimo = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into item_emprestimo(id_exemplar,id_emprestimo) values('"
					+ ((ItemEmprestimo) entidade).getIdExemplar() + "','" + ((ItemEmprestimo) entidade).getIdEmprestimo()
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
			String sql = "delete from item_emprestimo where id=" + id;
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
		List<ItemEmprestimo> itemEmprestimo = new ArrayList<ItemEmprestimo>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM item_emprestimo;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				itemEmprestimo.add(new ItemEmprestimo(rs.getInt("id"), rs.getInt("idExemplar"), rs.getInt("idEmprestimo")));
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
		return itemEmprestimo;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int idExemplar = ((ItemEmprestimo) entidade).getIdExemplar();
			int idEmprestimo = ((ItemEmprestimo) entidade).getIdEmprestimo();
			int id = ((ItemEmprestimo) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE item_emprestimo" + " SET id_exemplar = '" + idExemplar + "'," + " id_emprestimo ='"
					+ idEmprestimo + "'" + " WHERE id = " + id;
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
