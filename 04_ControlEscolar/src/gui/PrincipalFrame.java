/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Rafael
 */
public class PrincipalFrame extends JFrame{
    
    private Alumno panel;
    
    public PrincipalFrame(){
        super("Control Escolar Piñata");
        super.setSize(820, 600);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new Alumno();
        panel.setLayout(new FlowLayout());

        super.add(this.panel,BorderLayout.WEST);
        super.setResizable(false);
        super.setVisible(true);
    }
}
