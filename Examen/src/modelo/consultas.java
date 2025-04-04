package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class consultas {
    Connection cx = null;
    
    private String url = "jdbc:mysql://buvh8jhkny2ode9dagxm-mysql.services.clever-cloud.com:3306/buvh8jhkny2ode9dagxm";
    private String usuario = "u2zpxdffk3kcllvk";
    private String password = "U9SFsyDkNq9N9oxI5VrW";
    
    public Connection getConexion() {
        try {
            cx = DriverManager.getConnection(url, usuario, password);
            System.out.println("Se conecto a la base de datos.");
        }
        catch(SQLException e) {
            System.out.println("No se conecto a la base de datos.");
        }
        return cx;
    }
    
    /*Listar todos los nijas*/
    public List<String> obtener(ninja ninjas) {
        String sql = "select n.*, h.nombre, h.descripcion from ninja n inner join habilidades h on n.id_ninja = h.id_ninja";
        List<String> listaNinja = new ArrayList<>();
        try {
            Connection cx = getConexion();
            System.out.println(cx);
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaNinja.add("id_ninja" + rs.getInt("id_ninja")
                + "\nNombre: " + rs.getString("nombre") + 
                        "\nRango: " + rs.getString("rango") + 
                        "\nAldea: " + rs.getString("aldea")
                + "\nhabilidades: " + rs.getString("descripcion"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaNinja;
    }
    
    /*misiones disponibles*/
    public List<String> misionesd(misionD md) {
        String sql = "select n.*, mn.id_mision_ninja, mn.fecha_inicio, mn.fecha_fin, m.* from misionNinja mn" +
"                    inner join mision m on m.id_mision = mn.id_mision" +
"                    inner join ninja n on n.id_ninja = mn.id_ninja" +
"                    where mn.fecha_fin > current_date() and n.id_ninja = ?";
        List<String> listaM = new ArrayList<>();
        try {
            Connection cx = getConexion();
            System.out.println(cx);
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaM.add("id_ninja: " + rs.getInt("id_ninja") +
                        "/nNombre: " + rs.getString("nombre") + 
                        "/nRango: " + rs.getString("rango") + 
                        "/nAldea: " + rs.getString("aldea") + 
                        "/nId_mision: " + rs.getInt("id_mision") + 
                        "/nDescripcion: " + rs.getString("descripcion") + 
                        "/nRango de la aldea: " + rs.getString("rango") + 
                        "/nRecompensa: " + rs.getString("recompensa") + 
                        "/nFecha de inicio: " + rs.getString("fecha_inicio") + 
                        "/nFecha de finalizacion: " + rs.getString("fecha_fin"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaM;
    }
    
    /*mision completa por ninja*/
    public List<String> misioncom(misionD md) {
        String sql = "select n.*, mn.id_mision_ninja, mn.fecha_inicio, mn.fecha_fin, m.* from misionNinja mn" +
"                    inner join nision m on m.id_mision = mn.id_mision" +
"                    inner join ninja n on n.id_ninja = mn.id_ninja" +
"                    where mn.fecha_fin < current_date() and n.id_ninja = ?";
        List<String> listamisi = new ArrayList<>();
        try {
            Connection cx = getConexion();
            System.out.println(cx);
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listamisi.add("id_ninja: " + rs.getInt("id_ninja") + 
                        "/nNombre: " + rs.getString("nombre") + 
                        "/nAldea: " + rs.getString("aldea") + 
                        "/nId de la mision: " + rs.getInt("id_mision") + 
                        "/nDescripcion: " + rs.getString("descripcion") + 
                        "/nRango de la aldea: " + rs.getString("rango") + 
                        "/nRecompensa: " + rs.getString("recompensa") + 
                        "/nFecha de inicio: " + rs.getString("fecha_inicio") + 
                        "/nFecha de finalizacion: " + rs.getString("fecha_fin"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listamisi;
    }
    
    /*asignar mision*/
    public boolean asignarM(mision m) {
        PreparedStatement ps = null;
        Connection cx = getConexion();
        
        String sql = "insert into misionNinja (fecha_inicio, id_ninja, id_mision) values (?,?,?";
        
        try{
            ps = cx.prepareStatement(sql);
            ps.setString(1, m.getFechaI());
            ps.setInt(2, m.getId_ninja());
            ps.setInt(3, m.getId_mision());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                cx.close();
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
    /*marcar como completa*/
    public boolean marcarCo(misionC m) {
        PreparedStatement ps = null;
        Connection cx = getConexion();
        
        String sql = "update misionNinja set fecha_fin=?, where id_misionN=?";
        
        try {
            ps = cx.prepareStatement(sql);
            ps.setString(1, m.getFechaFin());
            ps.setInt(2, m.getId_mision_ninja());
            ps.execute();
            return true;
        }
        catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        finally {
            try {
                cx.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    /*Ver misones completas*/
    public List<String> misionesCom(misionNinja mn) {
        String sql = "select n.*, mn.id_mision_ninja, mn.fecha_inicio, mn.fecha_fin, m.* from misionNinja mn" +
"                    inner join mision m on m.id_mision = mn.id_mision" +
"                    inner join ninja n on n.id_ninja = mn.id_ninja" +
"                    where mn.fecha_fin < current_date()";
        List<String> listaC = new ArrayList<>();
        try {
            Connection cx = getConexion();
            System.out.println(cx);
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaC.add("id_ninja: " + rs.getInt("id_ninja") + 
                        "/nNombre: " + rs.getString("nombre") + 
                        "/nAldea: " + rs.getString("aldea") + 
                        "/nId de la mision: " + rs.getInt("id_mision") + 
                        "/nDescripcion: " + rs.getString("descripcion") + 
                        "/nRango de la aldea: " + rs.getString("rango") + 
                        "/nRecompensa: " + rs.getString("recompensa") + 
                        "/nFecha de inicio: " + rs.getString("fecha_inicio") + 
                        "/nFecha de finalizacion: " + rs.getString("fecha_fin"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;
    }
}