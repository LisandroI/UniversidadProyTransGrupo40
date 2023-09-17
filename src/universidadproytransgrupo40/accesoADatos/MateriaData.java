
package universidadproytransgrupo40.accesoADatos;

import java.sql.Connection;
import universidadproytransgrupo40.entidades.Materia;
        
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaData {
    
    Connection conexion = null;
    
    public MateriaData() {
        conexion = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        String sql = "insert into materia (nombre, año, estado) values (?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La materia NO ha sido guardada." +ex);
        }
    }
    
    public void eliminarMateria(int idMateria) {
        String sql = "update materia set estado = 0 where idMateria = "+idMateria+"";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue eliminada exitosamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La materia NO pudo ser eliminada. "+ ex);
        }
    }
    
    public void modificarMateria(Materia materia) {
        String sql = "update materia set nombre = ?, año = ?, estado = 1 where idMateria = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue actualizada exitosamente. "+exito);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La materia NO fue actualizada."+ex);
        }
    }
    
    public Materia buscarMateria(int idMateria) {
        String sql = "select nombre, año from materia where idMateria = ? and estado = 1";
        Materia materia = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);
            } else JOptionPane.showMessageDialog(null, "Materia NO encontrada.");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la materia. "+ ex);
        }
        return materia;
    }
    
    public List<Materia> listarMateria() {
        String sql = "select idMateria, nombre, año from materia where estado = 1";
        ArrayList<Materia> materias = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar listar las materias."+ ex);
        }
        return materias;
    }
 
    }
