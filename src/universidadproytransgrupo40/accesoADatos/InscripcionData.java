
package universidadproytransgrupo40.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadproytransgrupo40.entidades.Inscripcion;
import universidadproytransgrupo40.entidades.Materia;
import universidadproytransgrupo40.entidades.Alumno;
/**
 *
 * @author Grupo Sala 40
 */
public class InscripcionData {
    
    
    private Connection con;

    public InscripcionData() {
        con=(Connection) Conexion.getConexion();
    }
    
    
    
    public void guardarInscripcion (Inscripcion insc) throws SQLException{
        
//        public Inscripcion(Alumno alumno, Materia materia, double nota)
//                	
//idInscripto	nota	idAlumno	idMateria	
//INSERT INTO `inscripcion` (`nota`, `idAlumno`, `idMateria`) VALUES ( ?,?,?);	
try{
    //JOptionPane.showMessageDialog(null, insc.getAlumno().toString());
    //JOptionPane.showMessageDialog(null,insc.getMateria().toString());
    
        int idalumno=insc.getAlumno().getIdAlumno();
        int idmateria=insc.getMateria().getIdMateria();
        double nota = insc.getNota();

        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES ( ?,?,?);";
        
        PreparedStatement sentencia = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
        sentencia.setDouble(1, nota);
        sentencia.setInt(2, idalumno);
        sentencia.setInt(3, idmateria);
        
         int fila =sentencia.executeUpdate();
         if(fila>0){
             JOptionPane.showMessageDialog(null, "Alumno inscripto");
         }
         /*   
         ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadido con exito.");
            }
        */
            sentencia.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion" + ex.getMessage());
        }

        
        
    }
    
    
    public List<Inscripcion> obtenerInscripciones(){
        return null;
    }
    
    public List<Inscripcion> obtenerInscripcionesporAlumno(int id){
        return null;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id) throws SQLException{
     List<Materia> materias = new ArrayList<Materia>();
        
        
        String sql = "select * from inscripcion join materia on inscripcion.idmateria = materia.idmateria where inscripcion.idalumno=?;";
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        Materia materia;
        while(resultado.next()){
            materia = new Materia();
            materia.setIdMateria(resultado.getInt("idMateria"));
            materia.setNombre(resultado.getString("nombre"));
            materia.setAnioMateria(resultado.getInt("año"));
            materia.setActivo(true);
            materias.add(materia);
        }
                
        
        return materias;
    }
    
    
    
    
   
    public List<Materia> obtenerMateriasNOCursadas(int id) throws SQLException{
       
        
        List<Materia> materias = new ArrayList<Materia>();
        
        
        
        
        
        
        
        
       
        String sql_prueba = "SELECT m.idMateria,m.nombre,m.año\n" +
"from materia m\n" +
"where m.idMateria not IN (SELECT idMateria \n" +
"FROM inscripcion WHERE idAlumno=?);";
        PreparedStatement sentencia = con.prepareStatement(sql_prueba);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        Materia materia;
        while(resultado.next()){
                    materia = new Materia();
                    materia.setIdMateria(resultado.getInt("idMateria"));
                    materia.setNombre(resultado.getString("nombre"));
                    materia.setAnioMateria(resultado.getInt("año"));
                    materia.setActivo(true);
                    materias.add(materia);
        }
            return materias;
    }
    
    
    public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria) throws SQLException{
        
        
        
        String sql = "DELETE FROM inscripcion "
                + "WHERE inscripcion.idAlumno= '" +idAlumno + "' and inscripcion.idMateria= '" +idMateria+"';"; 
     
        //¿Realmente desea ejecutar "DELETE FROM inscripcion WHERE `inscripcion`.`idInscripto` = 35"?
        
        PreparedStatement sentencia = con.prepareStatement(sql);
//        sentencia.setInt(1, idAlumno);
//        sentencia.setInt(2, idMateria);
        int fila =sentencia.executeUpdate();
        JOptionPane.showMessageDialog(null, "filas eliminadas=" + fila);
        if (fila>0){
        JOptionPane.showMessageDialog(null, "eliminado");
        }else{
          JOptionPane.showMessageDialog(null, "NO eliminado");  
        }
        
        
    }
    
    public void actualizarNota(int idAlumno,int idMateria,double nota){
//         JOptionPane.showMessageDialog(null, "idMateria     idAlumno    nota  " + idMateria + " " + idAlumno +
//                                    " " + nota) ;
         
          
        String sql = "UPDATE inscripcion SET nota = ? where idAlumno = ? and  idMateria = ? ";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
         
         
    }
    public ArrayList<Alumno> obtenerAlumnosXMateria(int idMateria){
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT alumno.idAlumno,dni,apellido,nombre FROM alumno join inscripcion on (inscripcion.idAlumno = alumno.idAlumno) WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
//            System.out.println(rs.next());
//            Alumno alumno;
            while (rs.next()) {
//                alumno = new Alumno(32895332,"calvo","daniel",LocalDate.of(1987,Month.JANUARY,13),true);
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
//                alumno.setEstado(true);
                alumnos.add(alumno);
            }
            ps.close();
//            for (Alumno alumno : alumnos) {
//                System.out.println("Estoy acá"+alumno);
//            }
 
                
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumnos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//end InscripcionData class
