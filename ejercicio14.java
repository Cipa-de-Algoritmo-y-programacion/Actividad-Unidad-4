//Desarrollar un algoritmo que busque en una matriz un número ingresado por teclado e
// imprima el número y la posición en que fue encontrado.
import java.util.Scanner;

class ejercicio14 {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner teclado = new teclado(System.in); //para recoger la entrada del usuario.
        int[][] numero = new int[2][6];
        int datoUsuario;
        mostrar(numero);
        System.out.println("Digete un número del 10 al 20 para encontrar su posicion");
        datoUsuario = teclado.nextInt();
        EncontrarNumero(numero, datoUsuario);
    }

    public static void mostrar(int[][] matriz) {
        System.out.println("Matriz{");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j > 0 && j < matriz[i].length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("}");
    }

    public static void EncontrarNumero(int[][] numero, int datoUsuario) {
        int select = 0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                if (numero[i] == datoUsuario) {
                    System.out.println("numero encontrado:" + numero[i]);
                    system.out.println("Se encuentra en la posición: [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("¿Desea buscar la posición de otro numero?");
        System.out.println("1. Si");
        System.out.println("2. No");
        select = in.nextInt();
        switch (select) {
            case 1:
                menu();
                break;
            case 2:
                System.out.println("Cerrando programa");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                System.exit(0);
                break;
        }
    }
}

