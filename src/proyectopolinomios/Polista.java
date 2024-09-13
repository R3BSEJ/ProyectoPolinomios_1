package proyectopolinomios;

import javax.swing.JOptionPane;

public class Polista 
{
    private Nodo cab;

    public Polista() {
        cab=null;
    }

    public Nodo getCab() {
        return cab;
    }
        
     //Método para mostrar
    public String mostrar() 
    {
        String salida = "<html>";
        Nodo p=cab;
        while(p!=null)
        {
            if (p.getCoef() > 0 && p!=cab) 
            {
                salida = salida + "+ ";
            }
            salida=salida+p.getCoef();
            if(p.getExp()==1)
            {
                salida=salida+"X";
            }
            if(p.getExp()>1)
            {
                salida = salida +"x<sup>" + (int)p.getExp()+"</sup>";
            }
            p=p.getLiga();
         }
        salida = salida + "</html>";
        return salida;
    }
    
     public void ingresarTerminos() {
        int exp;
        float coef;
        Nodo p,ant,x;
        
        String respuesta;
        respuesta = JOptionPane.showInputDialog("Desea ingresar término? S/N");
        while (respuesta.equalsIgnoreCase("S")) 
        {
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el coeficiente: "));
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: "));
            if (exp >= 0) 
            {
               p=cab;
               ant=null;
               while(p!=null && p.getExp()>exp)
               {
                   ant=p;
                   p=p.getLiga();
               }
               if(p!=null &&p.getExp()==exp)
               {
                  JOptionPane.showMessageDialog(null,"Ya existe un término con ese exponente"); 
               }
               else
               {
                   x=new Nodo(exp,coef);
                   x.setLiga(p);
                   if(p==cab)
                   {
                       cab=x;
                   }
                   else
                   {
                       ant.setLiga(x);
                   }
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "El exponente no es válido");
            }
           respuesta = JOptionPane.showInputDialog("Desea ingresar término? S/N");
         }
       }
}
