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
        boolean isSalir = false;
        IOFicheros inputOutput = new IOFicheros();

        while (!isSalir) {
            System.out.println("Elije el ejercicio a ejecutar: \n1.Escritura de caracteres \n2.Lectura de caracteres \n3.Escritura o sobrescritura de caracteres \n4.Escritura de objeto \n5.Lectura de objeto \n6.Escritura de lista de objetos \n7.Lectura de lista de objetos \n8.Salir");
            inputInt = scannerInt.nextInt();

            switch (inputInt) {
                case 1:
                    //Ejercicio 1
                    System.out.println("Escriba una frase para guardar en el fichero: ");
                    inputDatos = scannerStr.nextLine();
                    System.out.println("Introduzca una ruta o nombre de fichero para leer: ");
                    inputFichero = scannerStr.nextLine();
                    isExitoEjecucion = inputOutput.escribirCaracteres(inputDatos, inputFichero);
                    if (isExitoEjecucion) {
                        System.out.println("La escritura se ha realizado con éxito.");
                    } else {
                        System.out.println("La escritura ha fallado.");
                    }
                    break;

                case 2:
                    System.out.println("Introduzca una ruta o nombre de fichero para leer: ");
                    inputDatos = scannerStr.nextLine();
                    inputOutput.leerCaracteres(inputDatos);
                    break;

                case 3:
                    //Ejercicio 3
                    System.out.println("¿Desea añadir nueva información o sobrescribirla? \n1.Añadir \n2.Sobrescribir");
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
                    }
                    break;

                case 4:
                    //Ejercicio 4
                    System.out.println("¿Desea añadir un nuevo objeto al fichero o sobrescribirlo? \n1.Añadir \n2.Sobrescribir");
                    inputInt = scannerInt.nextInt();
                    if (inputInt == 1) {
                        isAdd = true;
                    } else if (inputInt == 2) {
                        isAdd = false;
                    }
                    System.out.println("Introduzca una ruta o nombre de fichero para almacenar el objeto.");
                    inputFichero = scannerStr.nextLine();
                    Perro nuevoPerro = new Perro();
                    isExitoEjecucion = inputOutput.escribirObjeto(nuevoPerro, inputFichero, isAdd);
                    if (isExitoEjecucion) {
                        System.out.println("La escritura se ha realizado con éxito.");

                    } else {
                        System.out.println("La escritura ha fallado.");
                    }
                    break;

                case 5:
                    //Ejercicio 5
                    System.out.println("Introduzca una ruta o nombre de fichero para hacer la lectura del los objetos: ");
                    inputFichero = scannerStr.nextLine();
                    isExitoEjecucion = inputOutput.leerObjeto(inputFichero);
                    if (isExitoEjecucion) {
                        System.out.println("La lectura se ha realizado con éxito.");

                    } else {
                        System.out.println("La lectura ha fallado.");
                    }
                    break;

                case 6:
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
                    break;

                case 7:
                    //Ejercicio 7
                    System.out.println("Introduzca una ruta o nombre de fichero para hacer la lectura de los objetos: ");
                    inputFichero = scannerStr.nextLine();
                    inputOutput.lecturaObjetosLista(inputFichero);
                    break;

                case 8:
                    isSalir = true;
            }

        }
    }
}