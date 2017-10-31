package seres;

public class Terran extends Especies{
    
    private int numEdifi;
    private int numArma;
    
    public Terran(int numEdifi, int numArma, String nombre, int numVic, double lvlAtk, double lvlDef) {
        super(nombre, numVic, lvlAtk, lvlDef);
        this.numEdifi = numEdifi;
        this.numArma = numArma;
    }

    public int getNumEdifi() {
        return numEdifi;
    }

    public void setNumEdifi(int numEdifi) {
        this.numEdifi = numEdifi;
    }

    public int getNumArma() {
        return numArma;
    }

    public void setNumArma(int numArma) {
        this.numArma = numArma;
    }
    
    @Override
    public double atkTotal(){
        return this.getLvlAtk() * (1+(0.5*this.numArma));
    }
    
    @Override
    public double defTotal(){
        return this.getLvlDef() * (1+(0.25*this.numEdifi));
    }
    
    @Override
    public String toString() {
        return "Terran{" + "numEdifi=" + numEdifi + ", numArma=" + numArma + '}';
    }
       
}
