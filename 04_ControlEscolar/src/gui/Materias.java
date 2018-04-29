/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class Materias extends JDialog{
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
    
    public Materias(JFrame parent){
         super(parent,"Ventana",true);
        super.setSize(300,400);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        
        initComponents();
        
        materia = new JTextField(10);
        ncontrol = new JTextField(10);
        curso = new JTextField(10);
        calif = new JTextField(10);
        
        
        alta = new JButton("Dar alta materia");
        nuevo = new JButton("Nueva materia");
        modificar = new JButton("Modificar materia");
        Eliminar = new JButton("Eliminar materia");
        modmat = new JButton ("Modificar calificacion");
        
        tabla = new JTable();
        js = new JScrollPane();
        
        materia.setText("Materia");
        ncontrol.setText("No. Control");
        curso.setText("Tipo de curso");
        calif.setText("Calificacion");
        
        
        
        
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
      
        this.add(ncontrol);
        this.add(materia);
        this.add(curso);
        this.add(calif);
        
        
        this.add(alta);
        this.add(nuevo);
        this.add(modificar);
        this.add(Eliminar);
        
        this.add(js);
        
        
        modelo.addColumn("No.Control");
        modelo.addColumn("Materia");
        modelo.addColumn("Tipo de Curso");
        modelo.addColumn("Calificacion");

        
        tabla.setModel(modelo);
    }

    
     private void initComponents() {

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
        
        materia.setText("Materia");
        ncontrol.setText("NControl");
        curso.setText("Tipo de curso");
        calif.setText("Calificacion");
        
        
        
        
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
      
        this.add(ncontrol);
        this.add(materia);
        this.add(curso);
        this.add(calif);
        
        
        this.add(alta);
        this.add(nuevo);
        this.add(modificar);
        this.add(Eliminar);
        
        this.add(js);
        
        

     }
}
