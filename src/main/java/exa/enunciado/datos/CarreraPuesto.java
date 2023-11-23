package exa.enunciado.datos;

public class CarreraPuesto {

    private String carrera;
    private int puesto;

    public CarreraPuesto(String carrera, int puesto) {
        super();
        this.carrera = carrera;
        this.puesto = puesto;
    }

    /*public CarreraPuesto(String linea) {
        this.carrera = carrera;
        this.puesto = puesto;
    }*/
    public String getCarrera() {
        return carrera;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\t\tCarrera");
        sb.append(System.getProperty("line.separator"));
        sb.append("\t\tNombre: " + carrera);
        sb.append(System.getProperty("line.separator"));
        sb.append("\t\tPuesto: " + puesto);
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

    public String toTexto() {
        StringBuffer sb = new StringBuffer();
        sb.append("@").append(carrera);
        sb.append(";").append(puesto);
        return sb.toString();
    }
}
