/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class DialogMate extends JFrame{
    
    //private Materias materia;
    private JScrollPane js;
    private JTextField materia;
    private JTextField ncontrol;
    private JTextField curso;
    private JTextField calif;
    
    private JButton alta;
    private JButton nuevo;
    private JButton modificar;
    private JButton Eliminar;
   private  JButton modmat;
    
    private JTable tabla;
    DefaultTableModel modelo = new DefaultTableModel();
    
    public DialogMate(){
        super("Materias");
        super.setSize(1500, 600);
        super.setLayout(new BorderLayout());
  
        materia = new JTextField(10);
        ncontrol = new JTextField(10);
        curso = new JTextField(10);
        calif = new JTextField(10);
        
        
        alta = new JButton("Dar Alta materia");
        nuevo = new JButton("Nueva materia");
        modificar = new JButton("Modificar materia");
        Eliminar = new JButton("Eliminar materia");
        modmat = new JButton ("Modificar calificacion");
        
        tabla = new JTable();
        js = new JScrollPane();
        
        
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               String dato[] = new String[4];
               dato[0] = ncontrol.getText();
               dato[1]= materia.getText();
               dato[2]= curso.getText();
               dato[3]= calif.getText();
               
               modelo.addRow(dato);
            }
        });
        
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               ncontrol.setText(" ");
               materia.setText(" ");
               curso.setText(" ");
               calif.setText(" ");
               
               materia.requestFocus();
            }
        });
        
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               int filaSelect = tabla.getSelectedRow();
               if(filaSelect >= 0){
                   ncontrol.setText((String) tabla.getValueAt(filaSelect, 0));
                   materia.setText((String) tabla.getValueAt(filaSelect, 1));
                   curso.setText((String) tabla.getValueAt(filaSelect, 2));
                   calif.setText((String) tabla.getValueAt(filaSelect, 3));
                   
                   modelo.removeRow(filaSelect);
               }else{
                   JOptionPane.showMessageDialog(js, "SELECCIONA UNA FILA PRIMERO");
               }
            }
        });
        
         Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               int filaSelect = tabla.getSelectedRow();
               if(filaSelect >= 0){
                   modelo.removeRow(filaSelect);
               }else{
                   JOptionPane.showMessageDialog(js, "SELECCIONA UNA FILA PRIMERO");
               }
            }
        });
         
        
        
         
        
        js.setViewportView(tabla);
      
        
        
        
        
        JPanel btsPanel = new JPanel();
        btsPanel.setLayout(new BoxLayout(btsPanel, BoxLayout.PAGE_AXIS));
        
        JLabel lblNC = new JLabel("N. Control:");
        lblNC.setAlignmentX(LEFT_ALIGNMENT);
        btsPanel.add(lblNC);
        btsPanel.add(ncontrol);
        
        JLabel lblMat = new JLabel("Materia:");
        lblMat.setAlignmentX(LEFT_ALIGNMENT);
        btsPanel.add(lblMat);
        btsPanel.add(materia);
        
        JLabel lblCur = new JLabel("Curso:");
        lblCur.setAlignmentX(LEFT_ALIGNMENT);
        btsPanel.add(lblCur);
        btsPanel.add(curso);
        
        JLabel lblCalif = new JLabel("Calificación:");
        lblCalif.setAlignmentX(LEFT_ALIGNMENT);
        btsPanel.add(lblCalif);
        btsPanel.add(calif);
        
        modelo.addColumn("No.Control");
        modelo.addColumn("Materia");
        modelo.addColumn("Tipo de Curso");
        modelo.addColumn("Calificacion");

        
        tabla.setModel(modelo);
        
        //this.add(alta);
        this.add(nuevo);
        this.add(modificar);
        this.add(Eliminar);
        
        this.add(js);
        
        btsPanel.add(alta);
        btsPanel.add(nuevo);
        btsPanel.add(modificar);
        btsPanel.add(Eliminar);
        
        super.add(btsPanel,BorderLayout.WEST);
    }
}
