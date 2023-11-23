package exa.enunciado.ficheros;

import exa.enunciado.datos.Establo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalFicheros {

    public Establo leerEstabloFicheroTexto(String nameFile) {
        Establo miEstablo = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(nameFile));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                miEstablo = new Establo(linea);//Da error
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error leer txt");
        }

        return miEstablo;
    }

    public void saveEstabloTexto(Establo e1, String nameFile) {
        try {
            File file = new File(nameFile);
            if (file.exists()) {
                file.delete();
                System.out.println("El fichero existe y se ha borrado");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            //Ecribimos en el txt
            bw.write(e1.toTexto());
            // Cerrar el archivo
            bw.close();
            System.out.println("Informacion escrita en el archivo.");
        } catch (IOException ex) {
            System.out.println("Error save texto");
        }
    }

    public Establo leerEstabloFicheroBinario(String nameFile) {
        File file = new File(nameFile);
        Establo miEstablo = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                miEstablo = (Establo) ois.readObject();
            }
            //Me salta el catch
        } catch (Exception e) {
            System.out.println("Error leer binario");
        }
        return miEstablo;
    }

    public void saveEstabloBinario(Establo e1, String nameFile) {
        File file = new File(nameFile);

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e1);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrincipalFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarCarpetasYficheris(String direccion) {
        File directorio = new File(direccion);
        int f = 0;
        int d = 0;
        if (!directorio.exists()) {
            System.out.println("No existe.");
        } else {
            if (!directorio.isDirectory()) {
                System.out.println("No es un directorio.");
            } else {
                File[] ruta = directorio.listFiles();
                System.out.println("Archivos totales: " + ruta.length);
                for (int i = 0; i < ruta.length; i++) {
                    if (ruta[i].isDirectory()) {
                        System.out.println("\t" + ruta[i].getName() + " es un directorio.");
                        d++;
                    } else {
                        System.out.println("\t" + ruta[i].getName() + " es un archivo.");
                        f++;
                    }
                }
                System.out.println("Hay " + d + " Directorios");
                System.out.println("Hay " + f + " Fichero");
            }
        }
    }
}

