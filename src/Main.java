import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputUsuario;
        boolean isExitoEjecucion = false;

        //Ejercicio 1
        AlmacenCaracteres almacenCaracteres = new AlmacenCaracteres();
        System.out.println("Escriba una frase para guardar en el fichero: ");
        inputUsuario = input.nextLine();
        isExitoEjecucion = almacenCaracteres.AlmacenarCaracteres(inputUsuario);
        if (isExitoEjecucion) {
            System.out.println("La escritura se ha realizado con éxito.");
        } else {
            System.out.println("La escritura ha fallado.");
        }

    }
}