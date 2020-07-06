package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Credenciais;


public class CredenciaisDAO implements DAO {

	public Credenciais busca(String usuario, String senha) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Credenciais credenciais = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT nome FROM credenciais where usuario='" + usuario + "' and senha='" + senha + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				usuario = rs.getString("usuario");
				credenciais = new Credenciais(usuario);
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
		return credenciais;
	}

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Credenciais credenciais = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM credenciais where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				credenciais = new Credenciais(rs.getInt("id"), rs.getInt("idPessoa"), rs.getString("usuario"),
						rs.getString("senha"));
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
		return credenciais;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Credenciais credenciais = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into credenciais(id_pessoa,usuario,senha) values('" + ((Credenciais) entidade).getIdPessoa() + "','"
					+ ((Credenciais) entidade).getUsuario() + "','" + ((Credenciais) entidade).getSenha() + "');";
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
			String sql = "delete from credenciais where id="+id;
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
		List<Credenciais> credenciais = new ArrayList<Credenciais>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM credenciais;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				credenciais.add(new Credenciais(rs.getInt("id"), rs.getInt("idPessoa"), rs.getString("usuario"),
						rs.getString("senha")));
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
		return credenciais;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int idPessoa = ((Credenciais) entidade).getIdPessoa();
			String usuario = ((Credenciais) entidade).getUsuario();
			String senha = ((Credenciais) entidade).getSenha();
			int id = ((Credenciais) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE credenciais" + " SET id_pessoa = '" + idPessoa + "'," + " usuario ='" + usuario + "'," + " senha = '"
					+ senha + "'" + " WHERE id = " + id;
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
