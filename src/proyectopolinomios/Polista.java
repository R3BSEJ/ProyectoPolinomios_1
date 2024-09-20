    package proyectopolinomios;

import javax.swing.JOptionPane;

public class Polista {

    private Nodo cab;

    public Polista(int canterm) {
        cab = null;
    }

    Polista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Nodo getCab() {
        return cab;
    }

    //Método para mostrar
    public String mostrar() {
        String salida = "<html>";
        Nodo p = cab;
        while (p != null) {
            if (p.getCoef() > 0 && p != cab) {
                salida = salida + "+ ";
            }
            salida = salida + p.getCoef();
            if (p.getExp() == 1) {
                salida = salida + "X";
            }
            if (p.getExp() > 1) {
                salida = salida + "x<sup>" + (int) p.getExp() + "</sup>";
            }
            p = p.getLiga();
        }
        salida = salida + "</html>";
        return salida;
    }

    public float evaluar(float x) {
        float resultado = 0;
        Nodo p = cab;
        while (p != null) {
            resultado += p.getCoef() * Math.pow(x, p.getExp());
            p = p.getLiga();
        }
        return resultado;
    }

    public Polista sumar(Polista B) {
        int canterm;
        Polista C = new Polista(canterm);
        Nodo p1 = this.cab;
        Nodo p2 = B.getCab();
        Nodo x, ant = null;

        while (p1 != null || p2 != null) {
            Nodo nuevoTermino = null;
            if (p1 != null && (p2 == null || p1.getExp() > p2.getExp())) {
                nuevoTermino = new Nodo(p1.getExp(), p1.getCoef());
                p1 = p1.getLiga();
            } else if (p2 != null && (p1 == null || p2.getExp() > p1.getExp())) {
                nuevoTermino = new Nodo(p2.getExp(), p2.getCoef());
                p2 = p2.getLiga();
            } else if (p1 != null && p2 != null && p1.getExp() == p2.getExp()) {
                nuevoTermino = new Nodo(p1.getExp(), p1.getCoef() + p2.getCoef());
                p1 = p1.getLiga();
                p2 = p2.getLiga();
            }
            if (nuevoTermino != null) {
                if (C.getCab() == null) {
                    C.cab = nuevoTermino;
                    ant = C.getCab();
                } else {
                    ant.setLiga(nuevoTermino);
                    ant = nuevoTermino;
                }
            }
        }
        return C;
    }

    public void ingresarTerminos(int canterm) {
        int exp;
        float coef;
        Nodo p, ant, x;

        String respuesta;
        respuesta = JOptionPane.showInputDialog("Desea ingresar término? S/N");
        while (respuesta.equalsIgnoreCase("S")) {
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el coeficiente: "));
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: "));
            if (exp >= 0) {
                p = cab;
                ant = null;
                while (p != null && p.getExp() > exp) {
                    ant = p;
                    p = p.getLiga();
                }
                if (p != null && p.getExp() == exp) {
                    JOptionPane.showMessageDialog(null, "Ya existe un término con ese exponente");
                } else {
                    x = new Nodo(exp, coef);
                    x.setLiga(p);
                    if (p == cab) {
                        cab = x;
                    } else {
                        ant.setLiga(x);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El exponente no es válido");
            }
            respuesta = JOptionPane.showInputDialog("Desea ingresar término? S/N");
        }
    }
    
    public Polista multiplicar(Polista B) {
    Polista C = new Polista(canterm);  // El polinomio resultante
    Nodo p1 = this.cab;         // Nodo para recorrer el primer polinomio

    // Recorremos el primer polinomio
    while (p1 != null) {
        Nodo p2 = B.getCab();   // Nodo para recorrer el segundo polinomio
        // Recorremos el segundo polinomio para multiplicar cada término con p1
        while (p2 != null) {
            int nuevoExp = p1.getExp() + p2.getExp();  // Sumar exponentes
            float nuevoCoef = p1.getCoef() * p2.getCoef();  // Multiplicar coeficientes
            C.insertarOrdenado(nuevoExp, nuevoCoef);   // Insertar en el polinomio resultante
            p2 = p2.getLiga();  // Avanzar en el segundo polinomio
        }
        p1 = p1.getLiga();  // Avanzar en el primer polinomio
    }
    return C;
}

// Método auxiliar para insertar términos de forma ordenada por exponente
public void insertarOrdenado(int exp, float coef) {
    if (coef == 0) {
        return;  // No insertamos términos con coeficiente 0
    }
    
    Nodo nuevoTermino = new Nodo(exp, coef);
    Nodo p = this.cab;
    Nodo ant = null;

    // Encontrar la posición donde insertar el nuevo término
    while (p != null && p.getExp() > exp) {
        ant = p;
        p = p.getLiga();
    }
    
    // Si ya existe un término con el mismo exponente, sumamos los coeficientes
    if (p != null && p.getExp() == exp) {
        p.setCoef(p.getCoef() + coef);
        if (p.getCoef() == 0) { // Si el coeficiente es 0 después de la suma, eliminamos el término
            if (ant == null) {
                this.cab = p.getLiga();  // Eliminar el primer nodo
            } else {
                ant.setLiga(p.getLiga());  // Eliminar el nodo actual
            }
        }
    } else {
        // Insertar el nuevo término en la posición correcta
        if (ant == null) {
            // Insertar al inicio
            nuevoTermino.setLiga(this.cab);
            this.cab = nuevoTermino;
        } else {
            // Insertar en el medio o al final
            nuevoTermino.setLiga(p);
            ant.setLiga(nuevoTermino);
        }
    }
}

    Polista dividir(Polista B) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean comparar(Polista B) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
