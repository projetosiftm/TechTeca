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
			String sql = "SELECT * FROM multa where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				multa = new Multa(rs.getInt("id"), rs.getInt("idAdministrador"), rs.getInt("idEmprestimo"),
						rs.getInt("idItemEmprestimo"), rs.getDouble("valorMulta"),rs.getDate("dataVencimentoMulta"));
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
			String sql = "delete from multa where id=" + id;
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
			String sql = "SELECT * FROM multa;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				multa.add(new Multa(rs.getInt("id"), rs.getInt("idAdministrador"), rs.getInt("idEmprestimo"),
						rs.getInt("idItemEmprestimo"), rs.getDouble("valorMulta"),rs.getDate("dataVencimentoMulta")));
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
			Date dataVencimentoMulta = ((Multa) entidade).getDataVencimentoMulta();
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
