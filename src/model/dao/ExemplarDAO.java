package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Exemplar;
import model.javabean.Livro;

public class ExemplarDAO implements DAO {
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Exemplar exemplar = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM exemplar where id='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				exemplar = new Exemplar(rs.getInt("id"),(rs.getInt("idLivro")),rs.getString("disponibilidade"));
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
		return exemplar;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Exemplar exemplar = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into exemplar(disponibilidade,id_livro) values('"
					+ ((Exemplar) entidade).getDisponibilidade() + "','"+ ((Exemplar) entidade).getIdLivro() + "');";
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
			String sql = "delete from exemplar where id=" + id;
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
		List<Exemplar> exemplar = new ArrayList<Exemplar>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM exemplar;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				exemplar.add(new Exemplar(rs.getInt("id"), rs.getInt("idLivro"), rs.getString("disponibilidade")));
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
		return exemplar;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int idLivro = ((Exemplar) entidade).getIdLivro();
			String disponibilidade = ((Exemplar) entidade).getDisponibilidade();
			int id = ((Exemplar) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE exemplar" + " SET disponibilidade = '" + disponibilidade + "'," + " id_livro ='" + idLivro + "'" + " WHERE id = " + id;
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
