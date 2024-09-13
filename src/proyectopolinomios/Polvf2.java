package proyectopolinomios;

import javax.swing.JOptionPane;

public class Polvf2 
{
        private int n;
    private float vec[];
    
    //Metodo constructor
    public Polvf2(int canTerm) {
        n = canTerm*2+1;
        vec = new float[n];
        vec[0] = canTerm;
    }

    public int getN() {
        return n;
    }

    public float getDato(int pos) {
        return (vec[pos]);
    }

    public void setDato(float dato, int pos) {
        vec[pos] = dato;
    }
    //Método para mostrar
    public String mostrar() 
    {
        String salida = "<html>";
        for (int i = 1; i < vec[0]*2+1; i+=2) 
        {
            if (vec[i] > 0 && i > 1) 
            {
                salida = salida + "+ ";
            }
            salida=salida+vec[i+1];
            if(vec[i]==1)
            {
                salida=salida+"X";
            }
            if(vec[i]>1)
            {
                salida = salida +"x<sup>" + (int)vec[i]+"</sup>";
            }
         }
        salida = salida + "</html>";
        return salida;
    }
    //Método para ingresar los términos del polinomio
    public void ingresarTerminos(int canTerm) {
        int exp, cont,k,j;
        float coef;
        for(cont=0;cont<canTerm;cont++)
        {
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el coeficiente: "));
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: "));
            if (exp >= 0) 
            {
               k=1;
               while(k<vec[0]*2+1 && vec[k]>exp)
               {
                   k=k+2;
               }
               if(k<vec[0]*2+1 && vec[k]==exp && vec[k+1]!=0)
               {
                  JOptionPane.showMessageDialog(null,"Ya existe un término con ese exponente"); 
                  cont--;
               }
               else
               {
                   for(j=(int)vec[0]*2-1;j>k;j--)
                   {
                       vec[j+1]=vec[j-1];
                   }
                   vec[k]=exp;
                   vec[k+1]=coef;
               }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "El exponente no es válido");
                cont--;
            }
         }
    }
    
    public void mostrar () {
        int k;
        for (k=1; k < vec[0]*2+1; k+=2)
    }
}
