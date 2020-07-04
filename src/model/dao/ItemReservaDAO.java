package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.ItemReserva;

public class ItemReservaDAO implements DAO {

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		ItemReserva itemReserva = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM item_reserva where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				itemReserva = new ItemReserva(rs.getInt("id"), rs.getInt("idReserva"),rs.getInt("idExemplar"), rs.getInt("idLivro"));
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
		return itemReserva;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		ItemReserva itemReserva = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into item_reserva(id_reserva,id_exemplar,id_livro) values('"
					+ ((ItemReserva) entidade).getIdReserva() + "','" + ((ItemReserva) entidade).getIdExemplar()
					+ "','" + ((ItemReserva) entidade).getIdLivro()
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
			String sql = "delete from item_reserva where id=" + id;
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
		List<ItemReserva> itemReserva = new ArrayList<ItemReserva>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM item_reserva;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				itemReserva.add(new ItemReserva(rs.getInt("id"), rs.getInt("idReserva"),rs.getInt("idExemplar"), rs.getInt("idLivro")));
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
		return itemReserva;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int idReserva = ((ItemReserva) entidade).getIdReserva();
			int idExemplar = ((ItemReserva) entidade).getIdExemplar();
			int idLivro= ((ItemReserva) entidade).getIdLivro();
			int id = ((ItemReserva) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE item_reserva" + " SET id_reserva = '" + idReserva + "'," + " id_exemplar ='"
					+ idExemplar + "'," + " id_livro ='" + idLivro
					+ "'" + " WHERE id = " + id;
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
