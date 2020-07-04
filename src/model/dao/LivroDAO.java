package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Livro;

public class LivroDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Livro livro = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM livro where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				livro = new Livro(rs.getInt("id"), rs.getInt("idAdministrador"), rs.getInt("ano"),
						rs.getString("titulo"), rs.getString("autor"),rs.getString("descricao"), rs.getString("editora"), 
						rs.getString("idioma"),
						rs.getString("isbn"), rs.getString("foto"));
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
		return livro;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Livro livro = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into livro(titulo,autor,descricao,ano,editora,idioma,isbn,foto,id_administrador) values('"
					+ ((Livro) entidade).getTitulo() + "','" 
					+ ((Livro) entidade).getAutor() + "','" 
					+ ((Livro) entidade).getDescricao() + "','" 
					+ ((Livro) entidade).getAno() + "','" 
					+ ((Livro) entidade).getEditora() + "','" 
					+ ((Livro) entidade).getIdioma() + "','" 
					+ ((Livro) entidade).getIsbn() + "','" 
					+ ((Livro) entidade).getFoto()  + "','" 
					+ ((Livro) entidade).getIdAdministrador()
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
			String sql = "delete from livro where id=" + id;
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
		List<Livro> livro = new ArrayList<Livro>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM livro;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				livro.add(new Livro(rs.getInt("id"), rs.getInt("idAdministrador"), rs.getInt("ano"),
						rs.getString("titulo"), rs.getString("autor"),rs.getString("descricao"), rs.getString("editora"), 
						rs.getString("idioma"),
						rs.getString("isbn"), rs.getString("foto")));
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
		return livro;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String titulo = ((Livro) entidade).getTitulo();
			String autor = ((Livro) entidade).getAutor();
			String descricao = ((Livro) entidade).getDescricao();
			int ano = ((Livro) entidade).getAno();
			String editora = ((Livro) entidade).getEditora();
			String idioma = ((Livro) entidade).getIdioma();
			String isbn = ((Livro) entidade).getIsbn();
			String foto = ((Livro) entidade).getFoto();
			int idAdministrador = ((Livro) entidade).getIdAdministrador();
			int id = ((Livro) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE livro" + " SET titulo = '" + titulo + "'," 
					+ " autor ='" + autor + "'," 
					+ " descricao = '" + descricao + "',"
					+ " ano = '" + ano + "'," 
					+ " editora = '" + editora + "'," 
					+ " idioma = '" + idioma + "'," 
					+ " isbn = '" + isbn + "'," 
					+ " foto = '" + foto + "'," 
					+ " id_administrador ='" + idAdministrador + "'" 
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
