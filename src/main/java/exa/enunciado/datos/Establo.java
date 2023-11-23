package exa.enunciado.datos;

import java.util.ArrayList;

public class Establo {

    private ArrayList<Caballo> caballos;

    public Establo(ArrayList<Caballo> caballos) {
        super();
        this.caballos = caballos;
    }

    public Establo(String linea) {
        this.caballos.add(new Caballo(linea));
    }

    public ArrayList<Caballo> getCaballos() {
        return caballos;
    }

    public void setCaballos(ArrayList<Caballo> caballos) {
        this.caballos = caballos;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(System.getProperty("line.separator"));
        sb.append("Establo");
        sb.append(System.getProperty("line.separator"));
        for (var c : caballos) {
            sb.append(c.toString());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    public String toTexto() {
        StringBuffer sb = new StringBuffer();
        for (var c : caballos) {
            sb.append(c.toTexto()).append("\n");
        }
        return sb.toString();
    }
}
