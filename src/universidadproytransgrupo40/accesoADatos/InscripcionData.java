
package universidadproytransgrupo40.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
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
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con=(Connection) Conexion.getConexion();
        JOptionPane.showMessageDialog(null,"conectando inscripcioneas");
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
        JOptionPane.showMessageDialog(null, "paso hasta aca tod bien");
                
        
        return materias;
    }
    
    
    
    
   
    public List<Materia> obtenerMateriasNOCursadas(int id) throws SQLException{
       
        
        List<Materia> materias = new ArrayList<Materia>();
      LinkedList<Integer> inscriptas =new LinkedList<>();
   TreeSet<Integer> norepetidos = new TreeSet();
         
       
        System.out.println("Imprimo deberia figurar vacio el ");
        inscriptas.forEach(System.out::println);
        System.out.println("estoy en obtenerMateriasNOCursadas");
       
        
        String sql_inscriptas = "select * from inscripcion join materia on inscripcion.idmateria = materia.idmateria where inscripcion.idalumno=?;";
        String sql_existentes = "select * from materia;";
        PreparedStatement sentencia = con.prepareStatement(sql_inscriptas);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        Materia materia;
        while(resultado.next()){
           inscriptas.add(resultado.getInt("idMateria"));
        }
        System.out.println("Imprimo las inscriptas que figura");
          Collections.sort(inscriptas);
       inscriptas.forEach(System.out::println);
        
        sentencia.close();
        resultado.close();
        sentencia = con.prepareStatement(sql_existentes);
        //sentencia.setInt(1, id);
        resultado = sentencia.executeQuery();
//       System.out.println("Imprimo las materias existentes que figuran");
//        while(resultado.next()){
//            System.out.println("codigo aque exite" + resultado.getInt("idMateria"));
//        }
       
        int longitud = inscriptas.size();
        System.out.println("la cantidad de elementos del vector es " + longitud);
            while(resultado.next()){
                
                if(inscriptas.contains(resultado.getInt("idMateria"))){
                    System.out.println("el numero esta");
                
            }else{
                    System.out.println("no esta");
                    materia = new Materia();
                    materia.setIdMateria(resultado.getInt("idMateria"));
                    materia.setNombre(resultado.getString("nombre"));
                    materia.setAnioMateria(resultado.getInt("año"));
                    materia.setActivo(true);
                    materias.add(materia);
                }
                //if (resultado.getInt("idMateria"))
                
                 for (Integer inscripta : inscriptas) {
                
                     
                     
                     
                     
                     System.out.println("la materia que trae bd es  " + resultado.getInt("idMateria"));
                     System.out.println("la materia que compara inscrita es " + inscripta);
                     
//                if(inscripta==resultado.getInt("idMateria")){
//                    System.out.println("es igual");
//               
//                    
//            }else{
//                    System.out.println("es diferente");
//                    norepetidos.add(resultado.getInt("idMateria"));
//                    
////                    materia = new Materia();
////                    materia.setIdMateria(resultado.getInt("idMateria"));
////                    materia.setNombre(resultado.getString("nombre"));
////                    materia.setAnioMateria(resultado.getInt("año"));
////                    materia.setActivo(true);
////                    materias.add(materia);
//                    
//                }
                
            
            }
        }
            System.out.println("imprimo las materias no repetidas a ver si sale"
                    + "         "
                    + "       el array de materias" + "--------------------------------------------");
            norepetidos.forEach(System.out::println);
            JOptionPane.showMessageDialog(null, "paso hasta aca tod bien");
            return materias;
    }
    
    /*
    else{
                    System.out.println("es diferente");
                    materia = new Materia();
                    materia.setIdMateria(resultado.getInt("idMateria"));
                    materia.setNombre(resultado.getString("nombre"));
                    materia.setAnioMateria(resultado.getInt("año"));
                    materia.setActivo(true);
                    materias.add(materia);
                    
                }
    */
    
    public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria) throws SQLException{
        System.out.println("aca estoy");
        System.out.println(idAlumno);
        System.out.println(idMateria);
        
        
        
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
    public List<Alumno> obtenerAlumnosXMateria(int idMAteria){
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//end InscripcionData class
