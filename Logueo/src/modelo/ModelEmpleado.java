package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidad.Empleado;
import utils.MysqlDBConexion;

public class ModelEmpleado {
	public Empleado iniciarSesion(String log, String pas){
        Empleado obj = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            String sql = "select * from tb_empledo where login_emp=? and clave_emp=?";
            con = MysqlDBConexion.getConexion();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, log);
            pstm.setString(2, pas);
            rs = pstm.executeQuery();
            if (rs.next()) {
                obj = new Empleado();
                obj.setCodigo(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setApellidos(rs.getString(3));
                obj.setLogin(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstm != null) pstm.close();
                if(con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
