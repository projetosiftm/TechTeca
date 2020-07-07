package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.javabean.Emprestimo;

public class EmprestimoDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Emprestimo emprestimo = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM emprestimo where id_emprestimo='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				emprestimo = new Emprestimo(rs.getInt("id_emprestimo"),rs.getString("data_emprestimo"),
						rs.getString("data_devolucao"),rs.getInt("id_funcionario"),
						rs.getInt("id_usuario"));
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
		return emprestimo;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Emprestimo emprestimo = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into emprestimo(data_emprestimo,data_devolucao,id_funcionario, id_usuario) values('"
					+ ((Emprestimo) entidade).getDateEmprestimo() + "','" + ((Emprestimo) entidade).getDataDevolucao()
					+ "','" + ((Emprestimo) entidade).getIdFuncionario()  + "','" + ((Emprestimo) entidade).getIdUsuario()
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
			String sql = "delete from emprestimo where id_emprestimo=" + id;
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
		List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM emprestimo;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				emprestimo.add(new Emprestimo(rs.getInt("id_emprestimo"),rs.getString("data_emprestimo"),
						rs.getString("data_devolucao"),rs.getInt("id_funcionario"),
						rs.getInt("id_usuario")));
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
		return emprestimo;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String dateEmprestimo = ((Emprestimo) entidade).getDateEmprestimo();
			String dataDevolucao = ((Emprestimo) entidade).getDataDevolucao();
			int idFuncionario = ((Emprestimo) entidade).getIdFuncionario();
			int idUsuario = ((Emprestimo) entidade).getIdUsuario();
			int id = ((Emprestimo) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE emprestimo" + " SET data_emprestimo = '" + dateEmprestimo + "'," + " data_devolucao ='"
					+ dataDevolucao + "'," + " id_funcionario = '" + idFuncionario + "'," + " id_usuario ='" + idUsuario
					+ "'" + " WHERE id_emprestimo = " + id;
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
