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
                                                    +"\nDatos del Polinomio multiplicar\n"+C.mostrar());
                break;

               case "5":
    // Verificar que B no sea el polinomio cero, para evitar la división por cero
    if (B.esCero()) {
        JOptionPane.showMessageDialog(null, "Error: No se puede dividir por el polinomio cero.");
    } else {
        // Realizar la división de A por B
        C = A.dividir(B);

        // Verificar si la división ha sido exitosa y mostrar los polinomios
        if (C != null) {
            JOptionPane.showMessageDialog(null, "Datos del Polinomio 1:\n" + A.mostrar()
                + "\nDatos del Polinomio 2:\n" + B.mostrar()
                + "\nResultado de la división:\n" + C.mostrar());
        } else {
            JOptionPane.showMessageDialog(null, "Error: La división no se pudo realizar.");
        }
    }
    break;


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
       
       String opcion, menu="♦♣POLINOMIOS EN VECTOR FORMA 2♣♦\n" +
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
   
public static void menuPolista() {
    Polista A = new Polista();
    Polista B = new Polista();
    Polista C;
    float x;

    String opcion, menu = "♦♣POLINOMIOS EN VECTOR FORMA 3(Lista)♣♦\n" +
                          "1- Mostrar\n" +
                          "2- Evaluar\n" +
                          "3- Sumar\n" +
                          "4- Multiplicar\n" +
                          "5- Dividir\n" +
                          "6- Comparar\n" +
                          "7- Ir al menú principal\n" +
                          "0- Salir\n" +
                          "Digite la opción";

    do {
        opcion = JOptionPane.showInputDialog(null, menu);
        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, "Datos del Polinomio 1\n" + A.mostrar()
                        + "\nDatos del Polinomio 2\n" + B.mostrar());
                break;
            case "2":
                x = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de X"));
                JOptionPane.showMessageDialog(null, "Evaluación de A: " + A.evaluar(x)
                        + "\nEvaluación de B: " + B.evaluar(x));
                break;
            case "3":
                C = A.sumar(B);
                JOptionPane.showMessageDialog(null, "Datos del Polinomio suma\n" + C.mostrar());
                break;
            case "4":
                C = A.multiplicar(B);
                JOptionPane.showMessageDialog(null, "Datos del Polinomio multiplicado\n" + C.mostrar());
                break;
            case "5":
                C = A.dividir(B);
                JOptionPane.showMessageDialog(null, "Datos del Polinomio división\n" + C.mostrar());
                break;
            case "6":
                boolean iguales = A.comparar(B);
                JOptionPane.showMessageDialog(null, "¿Son iguales? " + (iguales ? "Sí" : "No"));
                break;
            case "7":
                menuPrincipal();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }

    } while (!opcion.equals("0"));
}
    
}
