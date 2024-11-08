import java.util.Arrays;

public class Ejercicio1 {
    /*
    Desarrollar un algoritmo que permita almacenar en un arreglo los números
    del 1 al 50 e imprima en pantalla lo que registro.
     */
    static int[] numeros = new int[50];
    public static void main(String[] args) {
        System.out.println("Cargando Array");
        cargarArray();
    }
    public static void cargarArray() {
        System.out.print("Elementos del array [");
        int i = 1;
        for(int num : numeros) {
            num = i;
            System.out.print(num);
            if(i<numeros.length) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("]");
        System.out.println("Se registraron: " + Arrays.stream(numeros).count() + " elementos");
    }
}