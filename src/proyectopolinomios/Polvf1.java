 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopolinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Jb
 */
public class Polvf1 {
    private int n;
    private float vec[];
    
      //Metodo Constructor
    
    public Polvf1(int grado){
        n=grado+2;
        vec=new float [n];
        vec[0]=grado;
    }
    
    public int getTam(){
    return (n);
    }
    public float getDato(int pos){
    return(vec[pos]);
    }
    public void setDato(float dato,int pos){
    vec[pos]=dato;
    }
    public void mostar()
    {
        String salida="<html>";
        for (int k = 1; k < vec[0]+2; k++) {
            if(vec[k]!=0)
            {
                if (vec[k]>0&& k>1) {
                    salida=salida+"+";
                }
                salida=salida+vec[k];
                if(vec[0]+1-k==1)
                {
                salida=salida+"X";
                }
                if((vec[0]+1-k)>1)
                {
                salida=salida+"X<sup>"+((int)vec[0]+1-k)+"<sup>";
                }
            }
        }
        salida=salida+"<html>";
        JOptionPane.showMessageDialog(null, "Datos del polinomio\n"+salida);
    }
    
    public void ingresarTerminos()
    {
       int exp,pos;
       float coef;
       String rpa;
       rpa=JOptionPane.showInputDialog("Desea ingresar un termino? S/N");
       while(rpa.equals("S")==true){
       coef=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el coeficiente"));
       exp=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el e´ponente"));
       if(exp>0 && exp<=vec[0]){
           pos= (int)vec[0]+1-exp; 
           if(vec[pos]==0)
           {
               vec[pos]=coef;
           }
           else
           {
           JOptionPane.showInputDialog(null,"Ya existe un termino con ese exponente");
           }
           
       }
       else 
       {
       JOptionPane.showInputDialog(null,"el exponente no es valido");
       }
       rpa=JOptionPane.showInputDialog("Desea ingresar un termino? S/N");
       }
    }
    public void ajustar(){
    int J=1, cont=0, k;

    while(J< vec[0]+2 && vec[J]==0){
    
        cont=cont+1 ;

    J++;
    
    }
    for(k=J; k<vec[0]+2; k++){
    
        vec[k-cont] = vec[k];
    }


    vec[0]= vec[0]-cont;

    }
    
    public float evaluar (float x){
    int k;

    float resultado=0;

    for(k=1; k<vec[0]+2; k++)
    {
    resultado = (float) (resultado + vec[k]*Math.pow(x,(vec[0]+1-k)));
    }


    return (resultado);
    
    }
//falta hacer la multiplicacion

}

