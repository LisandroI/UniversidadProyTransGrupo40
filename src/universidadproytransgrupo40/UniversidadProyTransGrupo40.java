/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadproytransgrupo40;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadproytransgrupo40.accesoADatos.AlumnoData;
import universidadproytransgrupo40.accesoADatos.Conexion;
import universidadproytransgrupo40.entidades.Alumno;
import universidadproytransgrupo40.entidades.Materia;

/**
 *
 * @author eduardo
 */
public class UniversidadProyTransGrupo40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // probando la conexion
        metodo();
    }
     
    
public static void metodo(){
        try{
        Connection con = Conexion.getConexion();
//        AlumnoData alu = new AlumnoData();
//        for (Alumno Alumno : alu.listarAlumnos()){
//            JOptionPane.showMessageDialog(null, alu.toString());
//        }
        
    
        
        List<Materia> materias = new ArrayList<Materia>();
      
            
                    
                    String sql = "select * from inscripcion join materia on inscripcion.idmateria = materia.idmateria where inscripcion.idalumno=?";
                    /*
            SELECT inscripcion.idMateria, nombre, año 
FROM inscripcion JOIN materia
ON(inscripcion.idMateria = materia.idMateria)
WHERE inscripcion.idAlumno = 2;
            */
                    
                    //" SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia ON(inscripcion.idMateria = materia.idMateria) WHERE inscripcion.idAlumno = 2;";
                    
                    
                    
//                    "SELECT inscripcion.idMateria, materia.nombre, materia.año"+ 
//                            "FROM inscripcion JOIN materia"+
//                            "ON(inscripcion.idMateria = materia.idMateria)"+
//                            "WHERE inscripcion.idAlumno = ?;";
//                    
                    
                    
//                    "SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia" 
//                          + "ON(inscripcion.idMateria=materia.idMateria) \n "+
//                    "WHERE inscripcion.idAlumno = ?;";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,2);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                JOptionPane.showMessageDialog(null, rs.getString("nombre"));
            }
//            Materia materia;
//            while (rs.next()){
//                materia=new Materia();
//                materia.setIdMateria(rs.getInt("idMateria"));
//                materia.setNombre(rs.getString("nombre"));
//                materia.setAnioMateria(rs.getInt("año"));
//                materias.add(materia);
//                
//            }
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones " + sqle.getMessage());
        }
          
        
        
        
    
    
    
    
    
    
    
    
    
    
    
}
    
}
