import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    /*
    Desarrollar un algoritmo que actualice un número ingresado por teclado en
    un arreglo e imprima el arreglo modificado
     */
    public static void main(String[] args) {
        ArrayList<Integer> numero = new ArrayList<>();
        numero.add(1);
        numero.add(2);
        numero.add(3);

        actividad(numero);
    }

    public static void mostrar(ArrayList<Integer> numero) {
        int i = 1;
        System.out.print("Elementos {");
        for(int element: numero) {
            System.out.print(element);
            if(i<numero.size()) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("}");
    }

    public static void actividad(ArrayList<Integer> numero) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        for(int value: numero) {
            total += value;
        }

        System.out.println("Tenemos los siguientes valores dentro de nuestro array");
        mostrar(numero);
        System.out.println(" ");
        System.out.println("cambia el valor de un elemento para que la suma de todos los elementos del array sea = 10");
        System.out.println("Escribe cambiar(valor a cambiar, nuevo valor)");
        String[] comando = input.nextLine().split("[\\s(),]+");
        if(comando[0].equalsIgnoreCase("cambiar")) {
            int num1 = Integer.parseInt(comando[1]);
            int num2 = Integer.parseInt(comando[2]);
            cambiar(numero,num1,num2);
            total=0;
            for(int element: numero) {
                total += element;
            }
            if(total == 10) {
                System.out.println("Correcto, la suma de todos los elementos es igual a " + total);
            }else
                System.out.println("Cambio incorrecto, la suma de los elementos es: " + total);

        }else{
            System.out.println("ejecute bien el comando por favor, solo puede poner valores enteros");
        }

    }

    public static void cambiar(ArrayList<Integer> numero, int valor1, int valor2) {
        int i = 0;
        for(int element: numero) {
            if(element==valor1) {
                numero.set(i,valor2);
            }
            i++;
        }
        mostrar(numero);
    }
}