package exa.enunciado.datos;

import java.util.ArrayList;
import java.util.Scanner;

public class Caballo {

    private int id;
    private String nombre;
    ArrayList<CarreraPuesto> carreras;

    public Caballo(int id, String nombre, ArrayList<CarreraPuesto> caballos) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.carreras = caballos;
    }

    public Caballo(String linea) {
        Scanner sc = new Scanner(linea).useDelimiter("@");
        this.id = sc.nextInt();
        this.nombre = sc.next();
        this.carreras = new ArrayList<>();
        String carrerasLinea = sc.next();
        //carrerasLinea =

        Scanner sc2 = new Scanner(carrerasLinea).useDelimiter(";");
        this.carreras.add(new CarreraPuesto(sc2.next(), sc2.nextInt()));

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<CarreraPuesto> getCarreraPuesto() {
        return carreras;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCaballos(ArrayList<CarreraPuesto> caballos) {
        this.carreras = caballos;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Caballo");
        sb.append(System.getProperty("line.separator"));
        sb.append("\tId: " + id);
        sb.append(System.getProperty("line.separator"));
        sb.append("\tNombre: " + nombre);
        sb.append(System.getProperty("line.separator"));
        sb.append("\tCarreras");
        sb.append(System.getProperty("line.separator"));
        for (var c : carreras) {
            sb.append(c.toString());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    public String toTexto() {
        StringBuffer sb = new StringBuffer();
        sb.append(id);
        sb.append("@").append(nombre);
        for (var c : carreras) {
            sb.append(c.toTexto());
        }
        return sb.toString();
    }

}
