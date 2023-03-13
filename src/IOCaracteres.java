//Ejercicio 1

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOCaracteres {

    public IOCaracteres() {
    }

    public boolean EscribirCaracteres(String texto) {
        boolean isEscrituraOk = false;
        FileWriter escrituraCaracteres;
        try {
            escrituraCaracteres = new FileWriter("escritura_caracteres.txt");
            escrituraCaracteres.write(texto);
            escrituraCaracteres.close();
            isEscrituraOk = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            isEscrituraOk = false;
        }
        return isEscrituraOk;
    }

    public char LeerCaracteres(String fichero) {
        FileReader lectorCaracteres;
        int caracter = 0;
        char contenidoFichero = 0;
        try {
            lectorCaracteres = new FileReader(fichero);
            caracter = lectorCaracteres.read();//cuenta los caracteres
            while (caracter != -1) {
                contenidoFichero = (char) caracter;
                System.out.print(contenidoFichero);
                caracter = lectorCaracteres.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenidoFichero;
    }
}
