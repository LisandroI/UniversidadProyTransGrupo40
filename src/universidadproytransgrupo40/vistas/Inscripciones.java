/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadproytransgrupo40.vistas;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadproytransgrupo40.accesoADatos.AlumnoData;
import universidadproytransgrupo40.accesoADatos.InscripcionData;
import universidadproytransgrupo40.accesoADatos.MateriaData;
import universidadproytransgrupo40.entidades.Alumno;
import universidadproytransgrupo40.entidades.Materia;
import universidadproytransgrupo40.entidades.Inscripcion;
/**
 *
 * @author eduardo
 */
public class Inscripciones extends javax.swing.JInternalFrame {
    
    
    
    private static   AlumnoData aluData = new AlumnoData();
    private static   MateriaData materiadata= new MateriaData();
    private static   InscripcionData inscripciondata = new InscripcionData();
    
private DefaultTableModel modelo = new DefaultTableModel();
private int codigo;
private String apellido;
private String nombre;
Alumno alumnoSeleccionado;
Materia materiaSeleccionada;
    /**
     * Creates new form Inscripciones
     */
    public Inscripciones() {
        initComponents();
        cargarComboBox();
        armarCabecera();
        jbInscribir.setEnabled(false);
        jbAnularInsc.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        listaMateriasInsc = new javax.swing.JRadioButton();
        listaMateriasNOInsc = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInsc = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 153, 0));
        setClosable(true);
        setTitle("Formulario de Inscripcion");
        setPreferredSize(new java.awt.Dimension(600, 450));

        jPanel2.setBackground(new java.awt.Color(0, 204, 102));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jcbAlumno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbAlumno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de Materias");

        listaMateriasInsc.setText("Materias Inscriptas");
        listaMateriasInsc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                listaMateriasInscStateChanged(evt);
            }
        });
        listaMateriasInsc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMateriasInscMouseClicked(evt);
            }
        });

        listaMateriasNOInsc.setText("Materias no inscriptas");
        listaMateriasNOInsc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMateriasNOInscMouseClicked(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInsc.setText("Anular Inscripcion");
        jbAnularInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(listaMateriasInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listaMateriasNOInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jbAnularInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaMateriasInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaMateriasNOInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAnularInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void listaMateriasInscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMateriasInscMouseClicked
             if (listaMateriasInsc.isSelected()){
               try {
        listaMateriasInsc.setSelected(true);
        listaMateriasNOInsc.setSelected(false);
        jbAnularInsc.setEnabled(true);
        jbInscribir.setEnabled(false);
        
        borrarFilas();
        
        JOptionPane.showMessageDialog(null, "aca anda");
            List<Materia> materias = inscripciondata.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());
        JOptionPane.showMessageDialog(null, "aca volvio");
           
     materias.forEach(System.out::println);
        for (Materia materia : materias) {
        modelo.addRow(new Object []{
                    materia.getIdMateria(),
                    materia.getNombre(),
                    materia.getAnioMateria()});
        }
        } catch (SQLException ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_listaMateriasInscMouseClicked

    private void listaMateriasNOInscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMateriasNOInscMouseClicked
       
try {
    if (listaMateriasNOInsc.isSelected()){
             listaMateriasInsc.setSelected(false);
             listaMateriasNOInsc.setSelected(true);
             jbAnularInsc.setEnabled(false);
             jbInscribir.setEnabled(true);
             borrarFilas();
             JOptionPane.showMessageDialog(null, "aca anda");
             List<Materia> materias;
             
                 materias = inscripciondata.obtenerMateriasNOCursadas(alumnoSeleccionado.getIdAlumno());
            
             JOptionPane.showMessageDialog(null, "aca volvio");
             materias.forEach(System.out::println);
             for (Materia materia : materias) {
                 modelo.addRow(new Object []{
                     materia.getIdMateria(),
                     materia.getNombre(),
                     materia.getAnioMateria()});
             }
    }
       } catch (SQLException ex) {
                 Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }//GEN-LAST:event_listaMateriasNOInscMouseClicked

    
    
    
    
    private void jtMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMateriasMouseClicked
        int idMateria;
        String nombre;
        int anioMateria;
        boolean activo;
        int filaSeleccionada = jtMaterias.getSelectedRow();
        if(filaSeleccionada!=-1){

            
            
            idMateria=(Integer) jtMaterias.getValueAt(filaSeleccionada, 0);
            nombre = (String) jtMaterias.getValueAt(filaSeleccionada,1);
            anioMateria=(Integer) jtMaterias.getValueAt(filaSeleccionada,2);
            activo=true;
            materiaSeleccionada= new Materia(idMateria,nombre,anioMateria,activo);
            
        }
    }//GEN-LAST:event_jtMateriasMouseClicked

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        try { 
        Inscripcion inscripcion=new Inscripcion(alumnoSeleccionado,materiaSeleccionada,-1);
        
       
            inscripciondata.guardarInscripcion(inscripcion);
            int filaSeleccionada = jtMaterias.getSelectedRow();
            if(filaSeleccionada!=-1){
                
            modelo.removeRow(filaSeleccionada);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
               
       
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void listaMateriasInscStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_listaMateriasInscStateChanged
       

    }//GEN-LAST:event_listaMateriasInscStateChanged

    private void jbAnularInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscActionPerformed
        
        
        try {
            JOptionPane.showMessageDialog(null, alumnoSeleccionado.getIdAlumno());
            
            
            int alumnoBja=(int) alumnoSeleccionado.getIdAlumno();
            int materiaBja=(int) materiaSeleccionada.getIdMateria();
           JOptionPane.showMessageDialog(null, alumnoBja);
           JOptionPane.showMessageDialog(null, materiaBja);
            inscripciondata.borrarInscripcionMateriaAlumno(alumnoBja,materiaBja);
                        int filaSeleccionada = jtMaterias.getSelectedRow();
            if(filaSeleccionada!=-1){
                
            modelo.removeRow(filaSeleccionada);
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jbAnularInscActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       
          this.dispose();    
        
        
        
        
        
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAnularInsc;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JTable jtMaterias;
    private javax.swing.JRadioButton listaMateriasInsc;
    private javax.swing.JRadioButton listaMateriasNOInsc;
    // End of variables declaration//GEN-END:variables


private void cargarComboBox(){
  
    List<Alumno> alumnos = aluData.listarAlumnos();
     for (Alumno alu : alumnos){
        jcbAlumno.addItem(alu);
     }
}


 private void armarCabecera(){
        
        CabeceraTablaInscripciones[] tope = CabeceraTablaInscripciones.values();
        for (int i=0;i<tope.length;i++){
            modelo.addColumn(tope[i]);
            
        }
        
        jtMaterias.setModel(modelo);
        
        
        
    }

    private void borrarFilas(){
        
        int fila=jtMaterias.getRowCount()-1;
        for (; fila>=0; fila--) {
            modelo.removeRow(fila);
        }
        
        
        
        
    }





}// end class
