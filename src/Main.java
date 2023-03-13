import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputUsuario;
        boolean isExitoEjecucion = false;
        IOCaracteres IOCaracteres = new IOCaracteres();

        //Ejercicio 1
        System.out.println("Escriba una frase para guardar en el fichero: ");
        inputUsuario = input.nextLine();
        isExitoEjecucion = IOCaracteres.EscribirCaracteres(inputUsuario);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");
        } else {
            System.out.println("La escritura ha fallado.");
        }

        //Ejercicio 2
        System.out.println("Introduzca una ruta o nombre de fichero para leer: ");
        inputUsuario = input.nextLine();
        IOCaracteres.LeerCaracteres(inputUsuario);


    }
}