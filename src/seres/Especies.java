package seres;

public abstract class Especies {

    private String nombre;
    private int numVic;
    private double lvlAtk;
    private double lvlDef;

    public Especies(String nombre, int numVic, double lvlAtk, double lvlDef) {
        this.nombre = nombre;
        this.numVic = numVic;
        this.lvlAtk = lvlAtk;
        this.lvlDef = lvlDef;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVic() {
        return numVic;
    }

    public void setNumVic(int numVic) {
        this.numVic = numVic;
    }

    public double getLvlAtk() {
        return lvlAtk;
    }

    public void setLvlAtk(double lvlAtk) {
        this.lvlAtk = lvlAtk;
    }

    public double getLvlDef() {
        return lvlDef;
    }

    public void setLvlDef(double lvlDef) {
        this.lvlDef = lvlDef;
    }

    public abstract double atkTotal();
    public abstract double defTotal();
    
    @Override
    public String toString() {
        return "Especies{" + "nombre=" + nombre + ", numVic=" + numVic + ", lvlAtk=" + lvlAtk + ", lvlDef=" + lvlDef + '}';
    }
}
