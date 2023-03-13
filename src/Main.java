import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        String inputDatos = "";
        String inputFichero = "";
        int inputInt = 0;
        boolean isExitoEjecucion = false;
        boolean isAdd = false;
        IOFicheros inputOutput = new IOFicheros();

       /* //Ejercicio 1
        System.out.println("Escriba una frase para guardar en el fichero: ");
        inputDatos = scannerStr.nextLine();
        isExitoEjecucion = inputOutput.EscribirCaracteres(inputDatos);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");
        } else {
            System.out.println("La escritura ha fallado.");
        }

        //Ejercicio 2
        System.out.println("Introduzca una ruta o nombre de fichero para leer: ");
        inputDatos = scannerStr.nextLine();
        inputOutput.LeerCaracteres(inputDatos);*/

        //Ejercicio 3

       /* System.out.println("¿Desea añadir nueva información o sobrescribirla? \n1.Añadir \n2.Sobrescribir");
        inputInt = scannerInt.nextInt();
        if (inputInt == 1) {
            isAdd = true;
        } else if (inputInt == 2) {
            isAdd = false;
        }
        System.out.println("Introduzca la ruta o el nombre del fichero donde almacenar los datos.");
        inputFichero = scannerStr.nextLine();
        System.out.println("Escriba los nuevos datos: ");
        inputDatos = scannerStr.nextLine();
        isExitoEjecucion = inputOutput.addOverwriteCaracteres(inputDatos, inputFichero, isAdd);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");
        } else {
            System.out.println("La escritura ha fallado.");
        }*/

        //Ejercicio 4
     /* System.out.println("¿Desea añadir un nuevo objeto al fichero o sobrescribirlo? \n1.Añadir \n2.Sobrescribir");
        inputInt = scannerInt.nextInt();
        if (inputInt == 1) {
            isAdd = true;
        } else if (inputInt == 2) {
            isAdd = false;
        }
        System.out.println("Introduzca una ruta o nombre de fichero para almacenar el objeto.");
        inputFichero = scannerStr.nextLine();
        Perro nuevoPerro = new Perro();
        isExitoEjecucion = inputOutput.escribirObjeto(nuevoPerro, inputDatos, isAdd);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");

        } else {
            System.out.println("La escritura ha fallado.");
        }*/

        //Ejercicio 5
      System.out.println("Introduzca una ruta o nombre de fichero para hacer la lectura de los objetos: ");
        inputFichero = scannerStr.nextLine();
        isExitoEjecucion = inputOutput.leerObjeto(inputFichero);
        if (isExitoEjecucion) {
            System.out.println("La lectura se ha realizado con éxito.");

        } else {
            System.out.println("La lectura ha fallado.");
        }

        //Ejercicio 6
        ArrayList listaPerros = new ArrayList<>();
        listaPerros.add(new Perro());
        listaPerros.add(new Perro());
        listaPerros.add(new Perro());
        listaPerros.add(new Perro());
        listaPerros.add(new Perro());

        System.out.println("Introduzca una ruta o nombre de fichero para almacenar la lista de objetos.");
        inputFichero = scannerStr.nextLine();
        System.out.println("¿Desea añadir la lista al fichero o sobrescribirlo? \n1.Añadir \n2.Sobrescribir");
        inputInt = scannerInt.nextInt();
        if (inputInt == 1) {
            isAdd = true;
        } else if (inputInt == 2) {
            isAdd = false;
        }
        isExitoEjecucion = inputOutput.escribirObjetoEficiente(listaPerros, inputFichero, isAdd);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");

        } else {
            System.out.println("La escritura ha fallado.");
        }
    }
}