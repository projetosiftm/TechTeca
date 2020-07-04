package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.javabean.Reserva;


public class ReservaDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Reserva reserva = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM reserva where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				reserva = new Reserva(rs.getInt("id"), rs.getInt("idUsuario"), rs.getInt("idEmprestimo"),
						rs.getDate("dateReserva"), rs.getString("statusReserva"));
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
		return reserva;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Reserva reserva = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into reserva(data_reserva,status_reserva,id_usuario,id_emprestimo) values('"
					+ ((Reserva) entidade).getDateReserva() + "','" 
					+ ((Reserva) entidade).getStatusReserva() + "','" 
					+ ((Reserva) entidade).getIdUsuario()  + "','" 
					+ ((Reserva) entidade).getIdEmprestimo()
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
			String sql = "delete from reserva where id=" + id;
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
		List<Reserva> reserva = new ArrayList<Reserva>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM reserva;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				reserva.add(new Reserva(rs.getInt("id"), rs.getInt("idUsuario"), rs.getInt("idEmprestimo"),
						rs.getDate("dateReserva"), rs.getString("statusReserva")));
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
		return reserva;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			Date dataReserva = ((Reserva) entidade).getDateReserva();
			String statusReserva = ((Reserva) entidade).getStatusReserva();
			int idUsuario = ((Reserva) entidade).getIdUsuario();
			int idEmprestimo = ((Reserva) entidade).getIdEmprestimo();
			int id = ((Reserva) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE reserva" + " SET data_reserva = '" + dataReserva + "'," 
					+ " status_reserva ='" + statusReserva + "'," 
					+ " id_usuario = '" + idUsuario + "',"  
					+ " id_emprestimo ='" + idEmprestimo + "'" 
					+ " WHERE id = " + id;
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
