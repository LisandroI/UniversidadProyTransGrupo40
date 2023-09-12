/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadproytransgrupo40.accesoADatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo Sala 40 
 */
public class Conexion {
    
    
    
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String PASSWORD="";
    private static final String URL ="jdbc:mysql://localhost:3306/";
    // agregamos la variable resultado para acumular la consulta
    private static ResultSet resultado = null;

    //agregamos la variable sentencia para ejecutar las sentencias sql
    private static Statement sentencia = null;

    

//    public static ResultSet getResultado() {
//        return resultado;
//    }
//    
    
    
    private static final String DB="universidadulp";
    private static final String USUARIO="root";
    
    
    private static Connection connection;

    private Conexion() {
    }
    
    public static Connection getConexion(){
        
        if (connection==null){
            try{
                Class.forName(DRIVER);
                
              connection=(Connection) DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode="
                      + "false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);

                //connection=(Connection) DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                    JOptionPane.showMessageDialog(null, "Conexion exitosa!!!");
            }catch(ClassNotFoundException | SQLException ex){
                JOptionPane.showMessageDialog(null,"mensaje de error: " + ex.getMessage());
            }
            
            
            
            
        }
        return connection;
    }   
  
    
    
    
    
} // end Conexion class
