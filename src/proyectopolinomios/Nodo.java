package proyectopolinomios;

public class Nodo {
   private int exp;
   private float coef;
   private Nodo liga;

    public Nodo(int exp, float coef) {
        this.exp = exp;
        this.coef = coef;
        liga=null;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
   
}
