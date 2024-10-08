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
    public float evaluar(float x)
    {
        int k;
        float resultado = 0;
        for(k=1; k < (vec[0]*2 + 1); k+=2)
        {
            resultado = (int)(resultado + vec[k+1]*Math.pow(x, vec[k]));
        }
        return resultado;
        
    }
    
    public void redimensionarvec(){
        int k;
        n=n+2;
        float aux[]=new float[n];
        for(k=0; (k<vec[0]*2+1); k++)
        {
            aux[k]=vec[k];
        }
        vec=aux;
    }
    
    public void sumarterm(float coef, int exp) {
    if (coef != 0) {
        int k = 1, j;

        // Buscar la posición correcta para el término
        while (k < vec[0] * 2 + 1 && vec[k] > exp) {
            k += 2;
        }

        // Si el exponente ya existe, actualizar el coeficiente o eliminar el término
        if (k < vec[0] * 2 + 1 && vec[k] == exp) {
            if ((vec[k + 1] + coef) != 0) {
                vec[k + 1] += coef;
            } else {
                // Eliminar el término si el coeficiente se vuelve cero
                for (j = k; j < vec[0] * 2 - 2; j += 2) {
                    vec[j] = vec[j + 2];
                    vec[j + 1] = vec[j + 3];
                }
                vec[0]--;
            }
        } else {
            // Verificar si es necesario redimensionar el vector
            if (vec[0] * 2 + 2 >= n) {
                redimensionarvec();
            }

            // Asegurarse de que k es un índice válido
            if (k >= vec.length - 1) {
                redimensionarvec();
            }

            // Mover los elementos a la derecha para hacer espacio
            for (j = (int)vec[0] * 2 - 1; j >= k; j -= 2) {
                vec[j + 2] = vec[j];
                vec[j + 3] = vec[j + 1];
            }

            // Insertar el nuevo término
            vec[k] = exp;
            vec[k + 1] = coef;
            vec[0]++;
        }
    }
}

    
    public Polvf2 hacercopia(){
        int k;
        Polvf2 copia = new Polvf2((int)vec[0]);
        for (k=1; k<vec[0]*2 + 1; k++)
        {
            copia.setDato(vec[k], k);
        }
        return (copia);
    }
    
    public Polvf2 sumar(Polvf2 B){
        
        Polvf2 copia = this.hacercopia();
        
        for (int i = 1; i < B.getDato(0)*2 + 1; i +=2)
        {
            int exp = (int)B.getDato(i);
            float coef = B.getDato(i + 1);
            copia.sumarterm(coef, exp);
        }
        
        return copia;
    }
    
    

}
