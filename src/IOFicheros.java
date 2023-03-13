

import java.io.*;
import java.util.ArrayList;

public class IOFicheros<Obj> {

    public IOFicheros() {
    }

    //Ejercicio 1
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

    //Ejercicio 2
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
            lectorCaracteres.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenidoFichero;
    }

    //Ejercicio 3
    public boolean addOverwriteCaracteres(String texto, String fichero, boolean isAdd) throws IOException {
        FileWriter escrituraCaracteres;
        boolean isEscrituraOk = false;
        if (!isAdd) {
            try {
                escrituraCaracteres = new FileWriter(fichero);
                escrituraCaracteres.write(texto);
                escrituraCaracteres.close();
                isEscrituraOk = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                isEscrituraOk = false;
            }
            return isEscrituraOk;
        } else {
            /*Si en el constructor añadimos un nuevo parámetro de tipo booleano que sea true, añade la nueva información en lugar de sobrescribirla. Si se establece en false o se omite, el archivo se sobrescribirá.*/
            try {
                escrituraCaracteres = new FileWriter(fichero, true);
                escrituraCaracteres.write(System.lineSeparator()); //añade una nueva línea, para que la nueva información se añada en la línea siguiente
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

    //Ejercicio 4
    public boolean escribirObjeto(Obj objeto, String fichero, boolean isAdd) {
        FileOutputStream escrituraBytes;
        ObjectOutputStream escrituraObjetos;
        boolean isEscrituraOk = false;
        if (!isAdd) {
            try {
                escrituraBytes = new FileOutputStream(fichero);
                escrituraObjetos = new ObjectOutputStream(escrituraBytes);
                escrituraObjetos.writeObject(objeto);
                escrituraObjetos.close();
                escrituraBytes.close();
                isEscrituraOk = true;
            } catch (IOException e) {
                e.printStackTrace();
                isEscrituraOk = false;
            }
        } else {
            try {
                escrituraBytes = new FileOutputStream(fichero, true);
                escrituraObjetos = new ObjectOutputStream(escrituraBytes);
                escrituraObjetos.writeObject(objeto);
                escrituraBytes.write('\n'); //Salto de línea entre objetos
                escrituraObjetos.close();
                escrituraBytes.close();
                isEscrituraOk = true;


            } catch (IOException e) {
                e.printStackTrace();
                isEscrituraOk = false;
            }
        }
        return isEscrituraOk;
    }

    //Ejercicio 5
    public boolean leerObjeto(String fichero) { //modificar para que lea todos los objetos del fichero (si hay varios, ahora solo lee el primero)
        FileInputStream lecturaBytes;
        ObjectInputStream lecturaObjetos;
        Obj objeto;
        boolean isLecturaOk = false;
        try {
            lecturaBytes = new FileInputStream(fichero);
            lecturaObjetos = new ObjectInputStream(lecturaBytes);
            objeto = (Obj) lecturaObjetos.readObject();
            System.out.println(objeto.toString());
            lecturaObjetos.close();
            lecturaBytes.close();
            isLecturaOk = true;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            isLecturaOk = false;
        }
        return isLecturaOk;
    }

    //Ejercicio 6
    public boolean escribirObjetoEficiente(ArrayList lista, String fichero, boolean isAdd) {
        FileOutputStream escrituraBytes;
        ObjectOutputStream escrituraObjetos;
        boolean isEscrituraOk = false;

        try {
            // Se abre el FileOutputStream y el ObjectOutputStream una sola vez
            escrituraBytes = new FileOutputStream(fichero, isAdd);
            escrituraObjetos = new ObjectOutputStream(escrituraBytes);

            // Escribe cada objeto
            for (int i = 0; i < lista.size(); i++) {
                Object objeto = lista.get(i);
                if (objeto instanceof Perro) {
                    escrituraObjetos.writeObject(objeto);
                    escrituraObjetos.reset(); // se utiliza para limpiar el caché interno del ObjectOutputStream de objetos previamente escritos y para restablecer la información de encabezado del objeto. Asegura que cada vez se escribe un objeto distinto.
                }
            }
            escrituraObjetos.close();
            escrituraBytes.close();
            isEscrituraOk = true;
        } catch (IOException e) {
            e.printStackTrace();
            isEscrituraOk = false;
        }

        return isEscrituraOk;
    }


}
