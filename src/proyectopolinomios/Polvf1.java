package proyectopolinomios;
import javax.swing.JOptionPane;
public class Polvf1 
{
    private int n;
    private float vec[];
    //Método constructor
    public Polvf1(int grado)
    {
        n=grado+2;
        vec=new float[n];
        vec[0]=grado;
    }
     //obtener dato
    public float getDato(int pos){
        return (vec[pos]);
    }
    //asignar dato
    public void setDato(float dato, int pos){
        vec[pos] = dato;
    }
    //obtener tamaño
    public int getTamaño(){
        return(n);
    }
    //Método para mostrar
   public String mostrar() 
    {
        String salida="<html>";
        for(int k=1;k<vec[0]+2;k++)
        {
            if(vec[k]!=0)
            {
                if(vec[k]>0&& k>1)  
                { 
                    salida=salida+"+";
                }
                salida=salida+vec[k];
                if(vec[0]+1-k==1)     
                { 
                    salida=salida+"X";   
                }
                if((vec[0]+1-k)>1)  
                {   
                    salida=salida+"X<sup>"+((int)vec[0]+1-k)+"</sup>";
                }
            }
        }
        salida=salida+"</html>";
        return salida;
    }
    //Método para ingresar los términos del polinomio
    public void ingresarTerminos()
    {
        int exp,pos;
        float coef;
        String resp;
        resp=JOptionPane.showInputDialog("Desea ingresar término? S/N");
        while(resp.equalsIgnoreCase("S"))
        {
           coef=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el coeficiente"));
           exp=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente"));
           if(exp>=0 && exp<= vec[0])
           {
               pos=(int)vec[0]+1-exp;
               if(vec[pos]==0)
               {
                   vec[pos]=coef;
               }
               else
               {
                 JOptionPane.showMessageDialog(null,"Ya existe un Término con ese exponente");
                }
           }
           else
           {
               JOptionPane.showMessageDialog(null,"El exponente no corresponde al polinomio");
           }
           resp=JOptionPane.showInputDialog("Desea ingresar término? S/N");
           
           if(!resp.equalsIgnoreCase("S")&&vec[1]==0)
           {
               JOptionPane.showMessageDialog(null,"Debe ingresar un término con el grado del polinomio");
               resp="S";
           }
       }
    }

     //evaluar el polinomio
    public void evaluar(float x)
    {
        float resultado = 0;
        for(int k = 1;k < vec[0] + 2;k++)
        {
            resultado = resultado + vec[k] * ( (float)Math.pow(x, (vec[0] +1 - k)));
        }
        JOptionPane.showMessageDialog(null, "El resultado es "+ resultado);
    }

 //Método para ajustar los ceros 
    public void ajustar()
    {
        int k=1, j, cont=0;
        while(k<vec[0]+2 && vec[k]==0)
        {
            cont=cont+1;
            k++;
        }
        for(j=k;j<vec[0]+2;j++)
        {
            vec[j-cont]=vec[j];
        }
        vec[0]=vec[0]-cont;
    }
    
   //Método para sumar dos polinomios
   public Polvf1 sumar(Polvf1 B)
   {
       int k = 1, j = 1,mayor, ExpA, ExpB, PosR;
        mayor=vec[0] > B.getDato(0)? (int)vec[0]:(int)B.getDato(0);
        Polvf1 R = new Polvf1(mayor);
        while((k < (vec[0] + 2)) && (j < B.getDato(0)+2))
        {
            ExpA = (int)vec[0] + 1 - k;
            ExpB = (int)B.getDato(0) + 1 - j;
 
            if(ExpA == ExpB)
            {
                PosR = (int)R.getDato(0) + 1 - ExpA;
                R.setDato((vec[k] + B.getDato(j)), PosR);
                k = k + 1;
                j = j +1;
            }
            else
            {
                if(ExpA > ExpB)
                {
                    PosR = (int)R.getDato(0) + 1 - ExpA;
                    R.setDato(vec[k], PosR);
                    k = k + 1;
                }
                else
                {
                    PosR = (int)R.getDato(0) + 1 - ExpB;
                    R.setDato(B.getDato(j), PosR);
                    j = j + 1;
                }
            }
        }
        R.ajustar();
        return R;
    }
   
   //Método para multiplicar dos vectores
   public Polvf1 multiplicar(Polvf1 B)
   {
       int gradoA = (int)vec[0];
       int gradoB = (int)B.getDato(0);
       int gradoR = gradoA + gradoB;
       
       Polvf1 R = new Polvf1(gradoR);
       
       for (int i = 1; i<(vec[0]+2); i++)
       {
           for (int j = 1; j<(B.getDato(0)+2); j++)
           {
               int expA = gradoA + 1 - i;
               int expB = gradoB + 1 - j;
               int expR = expA + expB;
               
               int posR = gradoR + 1 - expR;
               float coefR = R.getDato(posR);
               
               R.setDato(coefR + (vec[i] * B.getDato(j)), posR);
//               float a = R.getDato(i+j);
//               float b = (int)vec[i]*(int)B.getDato(j);
//               R.setDato(a+b, i+j);
           }
           
       }
       public boolean comparar(Polvf1 B) {

       // Obtener el grado de ambos polinomios
       int gradoA = (int) vec[0];
       int gradoB = (int) B.getDato(0);

       // Si los grados no son iguales, los polinomios son diferentes
       if (gradoA != gradoB) {
           return false;
       }

       // Comparar los coeficientes de ambos polinomios
       for (int i = 1; i <= gradoA + 1; i++) {
           if (vec[i] != B.getDato(i)) {
               return false; // Si algún coeficiente es diferente, los polinomios no son iguales
           }
       }

       // Si todos los coeficientes son iguales, los polinomios son iguales
       return true;
   }
       R.ajustar();
       return R;
   }
   public boolean comparar(Polvf1 B) {

        // Obtener el grado de ambos polinomios
        int gradoA = (int) vec[0];
        int gradoB = (int) B.getDato(0);

        // Si los grados no son iguales, los polinomios son diferentes
        if (gradoA != gradoB) {
            return false;
        }

        // Comparar los coeficientes de ambos polinomios
        for (int i = 1; i <= gradoA + 1; i++) {
            if (vec[i] != B.getDato(i)) {
                return false; // Si algún coeficiente es diferente, los polinomios no son iguales
            }
        }

        // Si todos los coeficientes son iguales, los polinomios son iguales
        return true;
    }
}



