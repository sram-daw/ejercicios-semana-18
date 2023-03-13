//Ejercicio 1

import java.io.FileWriter;
import java.io.IOException;

public class AlmacenCaracteres {

    public AlmacenCaracteres() {
    }

    public boolean AlmacenarCaracteres(String texto) {
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
}
