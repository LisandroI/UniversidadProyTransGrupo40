/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadproytransgrupo40.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadproytransgrupo40.entidades.Alumno;
import universidadproytransgrupo40.entidades.Materia;

/**
 *
 * @author eduardo
 */
public class MateriaData {
    
    private Connection conexion;
    
    
    public MateriaData(){
         conexion=(Connection) Conexion.getConexion();
    }
        
  public void guardarMateria(Materia materia) {
        String sql = "insert into materia (nombre, aÃ±o, estado) values (?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia aÃ±adida exitosamente.");
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
        String sql = "update materia set nombre = ?, aÃ±o = ?, estado = 1 where idMateria = ?";
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
    
}

