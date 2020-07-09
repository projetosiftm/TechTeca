package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
			String sql = "SELECT * FROM livro where id_livro='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				livro = new Livro(rs.getInt("id"),rs.getString("titulo"),
						rs.getString("autor"), rs.getString("descricao"),rs.getString("ano"), rs.getString("editora"), 
						rs.getString("idioma"),
						rs.getString("isbn"), rs.getString("foto"),rs.getInt("id_administrador"));
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
					+ ((Livro) entidade).getFoto() + "','" 
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
			String sql = "delete from livro where id_livro=" + id;
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
				livro.add(new Livro(rs.getInt("id_livro"),rs.getString("titulo"),
						rs.getString("autor"), rs.getString("descricao"),rs.getString("ano"),rs.getString("editora"),
						rs.getString("idioma"),rs.getString("isbn"), rs.getString("foto"),rs.getInt("id_administrador")));
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
	
	
	public List listarTodosAcervo() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<Livro> livro = new ArrayList<Livro>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT l.foto,l.titulo,l.autor,l.descricao,l.ano,l.editora,l.idioma,l.isbn,r.status_reserva FROM reserva as r "
					+ "inner join item_reserva as ir " + 
					"on r.id_reserva = ir.id_reserva " + 
					"inner join livro as l " + 
					"on ir.id_livro = l.id_livro;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				livro.add(new Livro(rs.getString("foto"),rs.getString("titulo"),
						rs.getString("autor"), rs.getString("descricao"),rs.getString("ano"),rs.getString("editora"),
						rs.getString("idioma"),rs.getString("isbn"), rs.getString("status_reserva")));
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
			String ano = ((Livro) entidade).getAno();
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
					+ " WHERE id_livro = " + id;
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
