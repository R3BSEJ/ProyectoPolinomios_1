/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopolinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Jb
 */
public class ProyectoPolinomios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int grado;
        Polvf1 A,B,C;
        float x;
        grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente"));
        A=new Polvf1(grado);
        A.ingresarTerminos();
        A.mostar();
        
        //Yes que rico
    }
    
}
