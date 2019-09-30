package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import utils.MysqlDBConexion;

public class ModelAlumno {
	public List<Alumno> listar() {
		Alumno alu = null;
		List<Alumno> data = new ArrayList<Alumno>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Connection cn = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_alumno";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				alu = new Alumno();
				alu.setCodigo(rs.getInt(1));
				alu.setNombre(rs.getString(2));
				alu.setPaterno(rs.getString(3));
				alu.setMaterno(rs.getString(4));
				alu.setEdad(rs.getInt(5));
				data.add(alu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	public Alumno buscarAlumno(int cod) {
		Alumno alu = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Connection cn = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_alumno where cod_alu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				alu = new Alumno();
				alu.setCodigo(rs.getInt(1));
				alu.setNombre(rs.getString(2));
				alu.setPaterno(rs.getString(3));
				alu.setMaterno(rs.getString(4));
				alu.setEdad(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return alu;
	}
	
	public int registrarAlumno(Alumno obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into tb_alumno values (null, ?, ?, ?, ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getPaterno());
			pstm.setString(3, obj.getMaterno());
			pstm.setInt(4, obj.getEdad());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	public int actualizarAlumno(Alumno obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update tb_alumno set nom_alu=?, pat_alu=?, mat_alu=?, edad_alu=? where cod_alu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getPaterno());
			pstm.setString(3, obj.getMaterno());
			pstm.setInt(4, obj.getEdad());
			pstm.setInt(5, obj.getCodigo());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	public int eliminarAlumno(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from tb_alumno where cod_alu = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
}
