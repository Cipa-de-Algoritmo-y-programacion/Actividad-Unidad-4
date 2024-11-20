import java.util.Scanner;

public class Ejercicio13 {
    
    // Desarrollar un algoritmo que sume 2 matrices
    public static void main(String[] args) {
       sumarMatrices();
    }
    public static void sumarMatrices(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas que tendra la matriz");
        int filas = sc.nextInt();

        System.out.println("Ingrese el numero de columnas que tendra la matriz");
        int columnas = sc.nextInt();
        
        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[filas][columnas];
        int[][] matrizC = new int[filas][columnas];
        
        // Ingresar datos matriz A
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.printf("Ingrese el valor para el elemento matrizA[%d][%d]: ",i,j);
                matrizA[i][j] = sc.nextInt();
            }

        }
        // Ingresar datos matriz B
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.printf("Ingrese el valor para el elemento matrizB[%d][%d]: ",i,j);
                matrizB[i][j] = sc.nextInt();
            }
        }

        // Sumar Matrices A y B
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        // Mostrar resultados Matriz C (Matriz A + B)
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.println("EL valor para el elemento MatrizC["+i+"]["+j+"]: " + matrizC[i][j]);
            }
            System.out.println("\n");
        }
        sc.close();
    }
}