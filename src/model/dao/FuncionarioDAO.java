package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Funcionario;

public class FuncionarioDAO implements DAO {


	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM funcionario where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email"));
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
		return funcionario;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into funcionario(nome,telefone,email) values('"
					+ ((Funcionario) entidade).getNome() + "','" + ((Funcionario) entidade).getTelefone() + "','"
					+ ((Funcionario) entidade).getEmail() + "');";
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
			String sql = "delete from funcionario where id=" + id;
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
		List<Funcionario> funcionario = new ArrayList<Funcionario>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM funcionario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				funcionario.add(new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email")));
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
		return funcionario;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String nome = ((Funcionario) entidade).getNome();
			String telefone = ((Funcionario) entidade).getTelefone();
			String email = ((Funcionario) entidade).getEmail();
			int id = ((Funcionario) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE funcionario" + " SET nome = '" + nome + "'," + " telefone ='" + telefone + "',"
					+ " email = '" + email + "'" + " WHERE id = " + id;
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
