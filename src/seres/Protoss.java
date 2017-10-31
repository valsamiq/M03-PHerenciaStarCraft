package seres;

public class Protoss extends Especies{
    private int numPilon;

    public Protoss(int numPilon, String nombre, int numVic, double lvlAtk, double lvlDef) {
        super(nombre, numVic, lvlAtk, lvlDef);
        this.numPilon = numPilon;
    }

    public int getNumPilon() {
        return numPilon;
    }

    public void setNumPilon(int numPilon) {
        this.numPilon = numPilon;
    }
    
    @Override
    public double atkTotal(){
        return this.getLvlAtk() * (1+(0.5*this.numPilon));
    }

    
    @Override
    public double defTotal(){
        return this.getLvlDef() * (1+(0.5*this.numPilon));
    }

    @Override
    public String toString() {
        return "Protoss{" + "numPilon=" + numPilon + '}';
    }
}