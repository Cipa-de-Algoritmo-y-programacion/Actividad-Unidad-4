import java.util.Scanner;

public class numeromatriz {

    public static void main(String[] args) {
        // objeto scanner
        Scanner entrada = new Scanner(System.in);

        
        int[][] matriz = {
            {1, 2, 3},
            {45, 56, 67},
            {78, 12, 90}
        };

        boolean encontrado = false;
        
       
        do {
            // Pedimos al usuario que ingrese el número que desee buscar
            System.out.print("Ingresa el número que deseas buscar en la matriz: ");
                
                int numero = entrada.nextInt();

            
            encontrado = false;

            // Recorremos la matriz buscando el número
            for (int i = 0; i < matriz.length; i++) {
                
                for (int j = 0; j < matriz[i].length; j++) {
                   
                    if (matriz[i][j] == numero) 
                    {
                       
                        System.out.println("El número " + numero + " se encuentra ubicado en la posición: (" + i + ", " + j + ")");
                            encontrado = true; // El número fue encontrado
                        
                        break; 
                    }
                }
                if (encontrado) break; 
            }

            
            if (!encontrado) {
                System.out.println("El número no se encuentra ubicado en la matriz, por favor inténtelo de nuevo.");
            }

        } while (!encontrado); 

        entrada.close();
    }
}


    

