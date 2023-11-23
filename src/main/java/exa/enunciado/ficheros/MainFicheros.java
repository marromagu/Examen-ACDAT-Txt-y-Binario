package exa.enunciado.ficheros;

import exa.enunciado.datos.CarreraPuesto;
import exa.enunciado.datos.Caballo;
import exa.enunciado.datos.Establo;
import java.util.ArrayList;


public class MainFicheros {

    public static void main(String[] args) {
        System.out.println("Ejercici 1 Escribir Establo Txt");
        var p = new PrincipalFicheros();
        var establoPrueba = loadEstabloPrueba();
        p.saveEstabloTexto(establoPrueba, "establoPrueba.txt");

        // var establoLeidoTXT = p.leerEstabloFicheroTexto("establoPrueba.txt");
        // System.out.println("Establo prueba txt");
        // System.out.println(establoLeidoTXT);
        
        p.saveEstabloBinario(establoPrueba, "establoPrueba.binario");
        var establoLeidoBinario = p.leerEstabloFicheroBinario("establoPrueba.binario");
        System.out.println("Establo prueba binario");
        System.out.println(establoLeidoBinario);
        p.listarCarpetasYficheris(".");
    }

    private static Establo loadEstabloPrueba() {
        ArrayList<CarreraPuesto> carreraPuestoCaballo1 = new ArrayList<CarreraPuesto>();
        carreraPuestoCaballo1.add(new CarreraPuesto("CarreraPraga", 4));
        carreraPuestoCaballo1.add(new CarreraPuesto("CarreraTokio", 15));
        var caballo1 = new Caballo(1, "Poderoso", carreraPuestoCaballo1);

        ArrayList<CarreraPuesto> carreraPuestoCaballo2 = new ArrayList<CarreraPuesto>();
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraPraga", 2));
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraTokio", 20));
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraMadrid", 1));
        var caballo2 = new Caballo(2, "Liebre", carreraPuestoCaballo2);

        ArrayList<Caballo> caballos = new ArrayList<Caballo>();
        caballos.add(caballo1);
        caballos.add(caballo2);

        var caballo3 = new Caballo(2, "Galgo", new ArrayList<CarreraPuesto>());
        caballos.add(caballo3);

        Establo e = new Establo(caballos);
        return e;
    }

    private static Establo loadEstabloPrueba2() {
        ArrayList<CarreraPuesto> carreraPuestoCaballo1 = new ArrayList<CarreraPuesto>();
        carreraPuestoCaballo1.add(new CarreraPuesto("CarreraPraga", 4));
        carreraPuestoCaballo1.add(new CarreraPuesto("CarreraTokio", 15));
        var caballo1 = new Caballo(1, "Poderoso", carreraPuestoCaballo1);

        ArrayList<CarreraPuesto> carreraPuestoCaballo2 = new ArrayList<CarreraPuesto>();
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraPraga", 2));
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraTokio", 20));
        carreraPuestoCaballo2.add(new CarreraPuesto("CarreraMadrid", 1));
        var caballo2 = new Caballo(2, "Liebre", carreraPuestoCaballo2);

        ArrayList<Caballo> caballos = new ArrayList<Caballo>();
        caballos.add(caballo1);
        caballos.add(caballo2);

        Establo e = new Establo(caballos);
        return e;
    }

}
