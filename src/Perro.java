import java.io.Serializable;
import java.util.Random;

public class Perro implements Serializable {

    private String nombre;
    private int edad;
    private String raza;

    public Perro() {
        this.nombre = generadorNombreRandom();
        this.edad = (int) Math.random() * 15;
        this.raza = generadorRazaRandom();
    }

    public String generadorNombreRandom() {
        String nombre = "";
        Random nombreAleatorio = new Random();
        String[] nombres = {"Tom", "Luna", "Toby", "Max", "Lana", "Daisy", "Freddy"};
        nombre = nombres[nombreAleatorio.nextInt(nombres.length)];
        return nombre;
    }

    public String generadorRazaRandom() {
        String raza = "";
        Random razaAleatoria = new Random();
        String[] razas = {"Labrador Retriever", "Golden Retriever", "Bulldog", "Chihuahua", "Poodle", "Boxer", "Pastor alemán"};
        raza = razas[razaAleatoria.nextInt(razas.length)];
        return raza;
    }


    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", raza='" + raza + '\'' +
                '}';
    }
}
