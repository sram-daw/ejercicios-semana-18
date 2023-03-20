

import java.io.*;
import java.util.ArrayList;

public class IOFicheros<Obj> {

    public IOFicheros() {
    }

    //Ejercicio 1
    public boolean escribirCaracteres(String texto, String fichero) {
        boolean isEscrituraOk = false;
        FileWriter escrituraCaracteres;
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
    }

    //Ejercicio 2
    public String leerCaracteres(String fichero) {
        FileReader lectorCaracteres;
        int caracter = 0;
        char contenidoFichero = 0;
        ArrayList<Character> listaChars = new ArrayList<Character>();
        String textoCompleto = "";
        try {
            //int caracter es igual al código ascii, posteriormente se traduce cuando hacemos (char) caracter y se almacena en contenidoFichero
            lectorCaracteres = new FileReader(fichero);
            caracter = lectorCaracteres.read();
            while (caracter != -1) {
                contenidoFichero = (char) caracter;
                listaChars.add((char)caracter); //añadimos a la lista el caracter
                System.out.print(contenidoFichero);
                caracter = lectorCaracteres.read();
            }
            System.out.println("");
            lectorCaracteres.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
        //se traduce el arraylist de caracteres a string utilizando StringBuilder
        StringBuilder sb = new StringBuilder();
        for (Character c : listaChars) {
            sb.append(c);
        }
        textoCompleto = sb.toString();
        return textoCompleto;
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
    public boolean leerObjeto(String fichero) {
        FileInputStream lecturaBytes;
        ObjectInputStream lecturaObjetos;
        Obj objeto;
        boolean isLecturaOk = false;
        try {
            lecturaBytes = new FileInputStream(fichero);
            lecturaObjetos = new ObjectInputStream(lecturaBytes);

        /*se leen los objetos hasta que la lectura sea null, es decir, hasta que ya no existan más.
         Esta es una forma de leer todos los objetos del archivo. Otra es la del ejercicio 7, que utiliza un arraylist*/
            while ((objeto = (Obj) lecturaObjetos.readObject()) != null) {
                System.out.println(objeto.toString());
            }
            lecturaObjetos.close();
            lecturaBytes.close();
            isLecturaOk = true;
        } catch (EOFException e) {
            // Cuando llega al final del archivo, se lanza una excepción EOF y se ignora
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
        Obj objeto;
        try {
            // Se abre el FileOutputStream y el ObjectOutputStream una sola vez
            escrituraBytes = new FileOutputStream(fichero, isAdd);
            escrituraObjetos = new ObjectOutputStream(escrituraBytes);

            // Escribe cada objeto
            for (int i = 0; i < lista.size(); i++) {
                objeto = (Obj) lista.get(i);
                escrituraObjetos.writeObject(objeto);
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

    //Ejercicio 7
    public ArrayList<Obj> lecturaObjetosLista(String fichero) {
        ArrayList<Obj> listaObjetos = new ArrayList<>();
        FileInputStream lecturaBytes;
        ObjectInputStream lecturaObjetos;
        Obj objeto;
        try {
            lecturaBytes = new FileInputStream(fichero);
            lecturaObjetos = new ObjectInputStream(lecturaBytes);

            while ((objeto = (Obj) lecturaObjetos.readObject()) != null) {
                listaObjetos.add(objeto); //los objetos se van almacenando en el arraylist
                System.out.println(objeto.toString());
            }
            lecturaObjetos.close();
            lecturaBytes.close();

        } catch (EOFException e) {
            // Cuando llega al final del archivo, se lanza una excepción EOF y se ignora

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
        return listaObjetos;
    }


}
