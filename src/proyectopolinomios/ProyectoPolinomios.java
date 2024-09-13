package proyectopolinomios;
import javax.swing.JOptionPane;
public class ProyectoPolinomios 
{
    public static void main(String[] args) 
    {
       menuPrincipal();      
    }
    //Método para el menú principal
    public static void menuPrincipal()
    {
        String opcion, menu="♦♣MENÚ PRINCIPAL♣♦\n" +
                            "1-	Polvf1\n" +
                            "2-	Polvf2\n" +
                            "3-	Polista\n" +
                            "4-	Combinados\n" +
                            "0-	Salir\n" +
                            "Digite la opción";
        
        //camaron//
        do
        {
            opcion=JOptionPane.showInputDialog(null,menu);
            switch(opcion)
            {
                case "1":menuPolvf1();
                break;
                case "2":menuPolvf2();
                break;
                case "3":menuPolista();
                break;
//                case "4":combinado();
//                break;
                case "0":System.exit(0);
            }
            
        }while(!opcion.equals("0"));
     }
    
    //Método para el menú de polinomios en vector forma 1
    public static void menuPolvf1()
    {
       Polvf1 A,B,C;
       int grado;
       float x;
       grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio 1"));
       A=new Polvf1(grado) ; 
       A.ingresarTerminos();
       grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio 2"));
       B=new Polvf1(grado) ; 
       B.ingresarTerminos();
       String opcion, menu="♦♣POLINOMIOS EN VECTOR FORMA 1♣♦\n" +
                            "1-	Mostrar\n" +
                            "2-	Evaluar\n" +
                            "3-	Sumar\n" +
                            "4-	Multiplicar\n" +
                            "5-	Dividir\n" +
                            "6-	Comparar\n" +
                            "7- Ir al menú principal\n"+
                            "0-	Salir\n" +
                            "Digite la opción";
        
        do
        {
            opcion=JOptionPane.showInputDialog(null,menu);
            switch(opcion)
            {
                case "1":JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
                                                        +"\nDatos del Polinomio 2\n"+B.mostrar());
                                                    
                break;
                case "2":x=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de X"));
                      A.evaluar(x);
                break;
                case "3": C=A.sumar(B);
                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
                break;
                case "4": C=A.multiplicar(B);
                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
                break;
//               case "5": C=A.dividir(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
//                break;
                case "6": 
                    boolean a = A.comparar(B);
                    if(a)
                    {
                        JOptionPane.showMessageDialog(null, "son iguales");                    
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "no son iguales");
                    }
                          
                break;
//                case "7":menuPrincipal();
//                break;
//                case "0":System.exit(0);
            }
         
        }while(!opcion.equals("0"));
     }
    //Método para el menú de polinomios en vector forma 2
    public static void menuPolvf2()
    {
       Polvf2 A,B,C;
       int canterm;
       float x;
       canterm=Integer.parseInt(JOptionPane.showInputDialog("Cuántos términos tiene el polinomio 1?"));
       A=new Polvf2(canterm) ; 
       A.ingresarTerminos(canterm);
       canterm=Integer.parseInt(JOptionPane.showInputDialog("Cuántos términos tiene el polinomio 2?"));
       B=new Polvf2(canterm) ; 
       B.ingresarTerminos(canterm);
       
       String opcion, menu="♦♣POLINOMIOS EN VECTOR FORMA 1♣♦\n" +
                            "1-	Mostrar\n" +
                            "2-	Evaluar\n" +
                            "3-	Sumar\n" +
                            "4-	Multiplicar\n" +
                            "5-	Dividir\n" +
                            "6-	Comparar\n" +
                            "7- Ir al menú principal\n"+
                            "0-	Salir\n" +
                            "Digite la opción";
        
        do
        {
            opcion=JOptionPane.showInputDialog(null,menu);
            switch(opcion)
            {
                case "1":JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
                                                        +"\nDatos del Polinomio 2\n"+B.mostrar());
                                                    
                break;
                case "2":x=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de X"));
                      A.evaluar(x);
                break;
//                case "3": C=A.sumar(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
//                break;
//                case "4": C=A.multiplicar(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
////                break;
//               case "5": C=A.dividir(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
//                break;
//                case "6": A.comparar(B);
//                          
//                break;
                case "7":menuPrincipal();
                break;
                case "0":System.exit(0);
            }
         
        }while(!opcion.equals("0"));
     }
    //Método para el menú de polinomios en vector forma 1
    public static void menuPolista()
    {
       Polista A,B,C;
       float x;
       
//       A=new Polista()) ; 
//       A.ingresarTerminos();
//       B=new Polista() ; 
//       B.ingresarTerminos();
      String opcion, menu="♦♣POLINOMIOS EN VECTOR FORMA 1♣♦\n" +
                            "1-	Mostrar\n" +
                            "2-	Evaluar\n" +
                            "3-	Sumar\n" +
                            "4-	Multiplicar\n" +
                            "5-	Dividir\n" +
                            "6-	Comparar\n" +
                            "7- Ir al menú principal\n"+
                            "0-	Salir\n" +
                            "Digite la opción";
        
        do
        {
            opcion=JOptionPane.showInputDialog(null,menu);
            switch(opcion)
            {
//                case "1":JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar());
//                                                    
//                break;
//                case "2":x=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de X"));
//                      A.evaluar(x);
//                break;
//                case "3": C=A.sumar(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
//                break;
//                case "4": C=A.multiplicar(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
////                break;
//               case "5": C=A.dividir(B);
//                          JOptionPane.showMessageDialog(null,"Datos del Polinomio 1\n"+A.mostrar()
//                                                        +"\nDatos del Polinomio 2\n"+B.mostrar()
//                                                    +"\nDatos del Polinomio suma\n"+C.mostrar());
//                break;
//                case "6": A.comparar(B);
//                          
//                break;
                case "7":menuPrincipal();
                break;
                case "0":System.exit(0);
            }
         
        }while(!opcion.equals("0"));
     }
    
}
