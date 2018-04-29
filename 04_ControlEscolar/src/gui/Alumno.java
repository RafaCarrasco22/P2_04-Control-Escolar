/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Alumno extends  JPanel{
    
    
    private JScrollPane js;
    private JTextField name;
    private JTextField ncontrol;
    private JTextField pat;
    private JTextField mat;
    private JTextField fecha;
    private JTextField carrera;
    private JTextField prom;
    private JButton alta;
    private JButton nuevo;
    private JButton modificar;
    private JButton Eliminar;
    private JButton Cali;
    private JTable tabla;
    public Materias materia;
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public Alumno(){
        
        //ingreso
        name = new JTextField(10);
        ncontrol = new JTextField(10);
        pat = new JTextField(10);
        mat = new JTextField(10);
        fecha = new JTextField(7);
        carrera = new JTextField(15);
        prom = new JTextField(8);
        
        
        //botones
        alta = new JButton("Dar Alta");
        nuevo = new JButton("Nuevo");
        modificar = new JButton("Modificar");
        Eliminar = new JButton("Eliminar");
        Cali = new JButton("Ingresar Materia");
        
        tabla = new JTable();
        js = new JScrollPane();
        
        
        //listeners
        
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               String dato[] = new String[7];
               dato[0] = ncontrol.getText();
               dato[1]= name.getText();
               dato[2]= pat.getText();
               dato[3]= mat.getText();
               dato[4]= fecha.getText();
               dato[5]= carrera.getText();
               dato[6]= prom.getText();
               modelo.addRow(dato);
            }
        });
        
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               ncontrol.setText(" ");
               name.setText(" ");
               pat.setText(" ");
               mat.setText(" ");
               fecha.setText(" ");
               carrera.setText(" ");
               prom.setText(" ");
               ncontrol.requestFocus();
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
                   name.setText((String) tabla.getValueAt(filaSelect, 1));
                   pat.setText((String) tabla.getValueAt(filaSelect, 2));
                   mat.setText((String) tabla.getValueAt(filaSelect, 3));
                   fecha.setText((String) tabla.getValueAt(filaSelect, 4));
                   carrera.setText((String) tabla.getValueAt(filaSelect, 5));
                   prom.setText((String) tabla.getValueAt(filaSelect, 6));
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
                   JOptionPane.showMessageDialog(js, "Selecciona una fila primero");
               }
            }
        });
         
       
       
        Cali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {
               DialogMate prueba = new DialogMate();
               prueba.setVisible(true);
               
            }
        });
        
        js.setViewportView(tabla);
        
        
        JPanel panelito = new JPanel();
        panelito.setLayout(new BoxLayout(panelito, BoxLayout.PAGE_AXIS));
        //panelito.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        
        ///labels
        JLabel lblNC = new JLabel("N. Control:");
        lblNC.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblNC);
        panelito.add(ncontrol);
   
        JLabel lblN = new JLabel("Nombre:");
        lblN.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblN);
        panelito.add(name);
        
        JLabel lblap = new JLabel("Apellido Paterno");
        lblap.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblap);
        panelito.add(pat);
        
        JLabel lblam = new JLabel("Apellido Materno");
        lblam.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblam);
        panelito.add(mat);
        
        JLabel lbldate = new JLabel("Fecha Nacimiento");
        lbldate.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lbldate);
        panelito.add(fecha);
        
        JLabel lblcarrera = new JLabel("Carrera");
        lblcarrera.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblcarrera);
        panelito.add(carrera);
        
        JLabel lblprom = new JLabel("Promedio");
        lblap.setAlignmentX(LEFT_ALIGNMENT);
        panelito.add(lblprom);
        panelito.add(prom);
        
        this.add(panelito);
        
        JPanel panelote = new JPanel();
        panelote.setLayout(new BoxLayout(panelote,BoxLayout.PAGE_AXIS));
        
        
        panelote.add(alta);
        panelote.add(nuevo);
        panelote.add(modificar);
        panelote.add(Eliminar);
        panelote.add(Cali);
        this.add(panelote);
        
        this.add(js);
        
        modelo.addColumn("No.Control");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Carrera");
        modelo.addColumn("Promedio");
        
        tabla.setModel(modelo);
    }
   
}

