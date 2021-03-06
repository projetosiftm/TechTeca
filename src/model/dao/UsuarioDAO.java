package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Usuario;

public class UsuarioDAO implements DAO {

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Usuario usuario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM usuario where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
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
		return usuario;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Usuario usuario = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into usuario(nome,telefone,email) values('"
					+ ((Usuario) entidade).getNome() + "','" + ((Usuario) entidade).getTelefone() + "','"
					+ ((Usuario) entidade).getEmail() + "');";
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
			String sql = "delete from usuario where id=" + id;
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
		List<Usuario> usuario = new ArrayList<Usuario>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM usuario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usuario.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
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
		return usuario;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String nome = ((Usuario) entidade).getNome();
			String telefone = ((Usuario) entidade).getTelefone();
			String email = ((Usuario) entidade).getEmail();
			int id = ((Usuario) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE usuario" + " SET nome = '" + nome + "'," + " telefone ='" + telefone + "',"
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
