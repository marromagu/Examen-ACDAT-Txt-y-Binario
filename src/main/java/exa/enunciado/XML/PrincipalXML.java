package exa.enunciado.XML;

import exa.enunciado.datos.Caballo;
import exa.enunciado.datos.CarreraPuesto;
import exa.enunciado.datos.Establo;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PrincipalXML {

    public Establo leerEstabloXMLdom(String nameFile) {
        try {
            // Configurar el parser de documentos XML
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento
            Document document = documentBuilder.parse(new File(nameFile));

            // Obtener el elemento raíz del documento
            Element rootElement = document.getDocumentElement();

            // Lista para almacenar los caballos
            ArrayList<Caballo> caballos = new ArrayList<>();

            // Obtener nodos de tipo Caballo del documento
            NodeList caballoNodes = rootElement.getElementsByTagName("Caballo");
            for (int i = 0; i < caballoNodes.getLength(); i++) {
                Node caballoNode = caballoNodes.item(i);

                // Verificar si el nodo es de tipo ELEMENT_NODE (elemento XML)
                if (caballoNode.getNodeType() == Node.ELEMENT_NODE) {
                    // Convertir el nodo a un elemento XML
                    Element caballoElement = (Element) caballoNode;

                    // Crear un objeto Caballo a partir del elemento XML
                    Caballo caballo = createCaballoFromElement(caballoElement);

                    // Agregar el caballo a la lista
                    caballos.add(caballo);
                }
            }

            // Crear y retornar un objeto Establo con la lista de caballos
            return new Establo(caballos);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para crear un objeto Caballo a partir de un elemento XML
    private Caballo createCaballoFromElement(Element caballoElement) {
        // Obtener valores de atributos del elemento Caballo
        String idAttribute = caballoElement.getAttribute("Id");

        // Verificar si el atributo Id está presente
        int id = (idAttribute.isEmpty()) ? 0 : Integer.parseInt(idAttribute);

        String nombre = getElementTextByTagName(caballoElement, "Nombre");

        // Lista para almacenar los CarreraPuesto del caballo
        ArrayList<CarreraPuesto> carreras = new ArrayList<>();

        // Obtener nodos de tipo CarreraPuesto dentro del elemento Caballo
        NodeList carreraNodes = caballoElement.getElementsByTagName("CarreraPuesto");
        for (int i = 0; i < carreraNodes.getLength(); i++) {
            Node carreraNode = carreraNodes.item(i);

            // Verificar si el nodo es de tipo ELEMENT_NODE
            if (carreraNode.getNodeType() == Node.ELEMENT_NODE) {
                // Convertir el nodo a un elemento XML
                Element carreraElement = (Element) carreraNode;

                // Obtener valores de atributos del elemento CarreraPuesto
                String carrera = carreraElement.getAttribute("Carrera");
                int puesto = Integer.parseInt(carreraElement.getAttribute("Puesto"));

                // Crear un objeto CarreraPuesto y agregarlo a la lista
                carreras.add(new CarreraPuesto(carrera, puesto));
            }
        }

        // Crear y retornar un objeto Caballo con los datos obtenidos
        return new Caballo(id, nombre, carreras);
    }

    // Método auxiliar para obtener el contenido de un elemento por su nombre de etiqueta
    private String getElementTextByTagName(Element parentElement, String tagName) {
        // Obtener nodos con el nombre de etiqueta especificado
        NodeList nodeList = parentElement.getElementsByTagName(tagName);

        // Verificar si hay al menos un nodo
        if (nodeList.getLength() > 0) {
            // Obtener el primer nodo y devolver su contenido de texto
            Node node = nodeList.item(0);
            return node.getTextContent();
        }

        // Devolver una cadena vacía si no se encuentra el nombre de etiqueta
        return "";
    }

    public void saveEstabloXMLdom(Establo establo, String nameFile) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Crear el elemento raíz
            Element establoElement = document.createElement("Establo");
            document.appendChild(establoElement);

            // Iterar sobre cada caballo en el establo y agregarlos al XML
            for (Caballo caballo : establo.getCaballos()) {
                Element caballoElement = document.createElement("Caballo");

                // Agregar la ID del caballo como atributo
                caballoElement.setAttribute("Id", String.valueOf(caballo.getId()));

                // Agregar el elemento para el nombre del caballo
                Element nombreElement = document.createElement("Nombre");
                nombreElement.appendChild(document.createTextNode(caballo.getNombre()));
                caballoElement.appendChild(nombreElement);

                // Iterar sobre cada CarreraPuesto y agregarlos al elemento Caballo
                for (CarreraPuesto carreraPuesto : caballo.getCarreraPuesto()) {
                    Element carreraPuestoElement = document.createElement("CarreraPuesto");

                    // Agregar los atributos para Carrera y Puesto
                    carreraPuestoElement.setAttribute("Carrera", carreraPuesto.getCarrera());
                    carreraPuestoElement.setAttribute("Puesto", String.valueOf(carreraPuesto.getPuesto()));

                    caballoElement.appendChild(carreraPuestoElement);
                }

                establoElement.appendChild(caballoElement);
            }

            // Escribir el contenido en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(nameFile);
            transformer.transform(source, result);

            System.out.println("XML guardado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
