package exa.enunciado.XML;

import exa.enunciado.datos.CarreraPuesto;
import exa.enunciado.datos.Caballo;
import exa.enunciado.datos.Establo;
import java.util.ArrayList;

public class MainXML {

    public static void main(String[] args) {
        String fileLeerXML = "leer.xml";
        String fileGuardarXML = "guardar.xml";

        var p = new PrincipalXML();

        var establoPrueba = loadEstabloPrueba();
        System.out.println("Establo cargado de datos prueba");
        //System.out.println(establoPrueba);
        //Escribir XML
        //p.saveEstabloXMLdom(establoPrueba, "establoPrueba.xml");
        //leer XML escrito
        var establoLeidoXML = p.leerEstabloXMLdom("establoPrueba.xml");
        System.out.println("Establo leido de XML");
        System.out.println(establoLeidoXML);

        //Leer XML1
        //establoLeidoXML = p.leerEstabloXMLdom("establoCorrecto.xml");
        //System.out.println("Establo leido de XML 1 sin errores");
        //System.out.println(establoLeidoXML);
        
        //Leer XML2
        //establoLeidoXML = p.leerEstabloXMLdom("establoFaltaNombre.xml");
        //System.out.println("Establo leido de XML 2 con errores falta nombre");
        //System.out.println(establoLeidoXML);
        
        //Leer XML3
        //establoLeidoXML = p.leerEstabloXMLdom("establoFaltaID.xml");
        //System.out.println("Establo leido de XML 3 con errores falta ID");
        //System.out.println(establoLeidoXML);
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

        Establo e = new Establo(caballos);
        return e;
    }

}
