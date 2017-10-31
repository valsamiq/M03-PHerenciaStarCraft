package seres;

public class Zerg extends Especies{
    
    private int numEsbirro;
    private int numOverlord;

    public Zerg(int numEsbirro, int numOverlord, String nombre, int numVic, double lvlAtk, double lvlDef) {
        super(nombre, numVic, lvlAtk, lvlDef);
        this.numEsbirro = numEsbirro;
        this.numOverlord = numOverlord;
    }

    public int getNumEsbirro() {
        return numEsbirro;
    }

    public void setNumEsbirro(int numEsbirro) {
        this.numEsbirro = numEsbirro;
    }

    public int getNumOverlord() {
        return numOverlord;
    }

    public void setNumOverlord(int numOverlord) {
        this.numOverlord = numOverlord;
    }
    
    @Override
    public double atkTotal(){
        return this.getLvlAtk() * (1+(0.15*this.numEsbirro)+(0.4*this.numOverlord));
    }

    @Override
    public double defTotal(){
        return this.getLvlDef() * (1+(0.3*this.numEsbirro));
    }


    @Override
    public String toString() {
        return "Zerg{" + "numEsbirro=" + numEsbirro + ", numOverlord=" + numOverlord + '}';
    }    
    /*
    //Per a separar text i empleçar-lo en  array
    
    */

}
