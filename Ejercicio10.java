import java.util.Scanner;

public class Ejercicio10 {
    /*
    Desarrollar un programa de llene por teclado una matriz de 10 x 10 e imprima la información registrada.
     */
    static double[][] matriz = new double[10][10];
    public static void main(String[] args) {
       menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        int select;
        System.out.println("Menú principal");
        System.out.println("1. Ingresar Nota ");
        System.out.println("2. Salir");
        select = sc.nextInt();
        switch(select){
            case 1:
                double nota;
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Ingrese el valor de nota ");
                nota = sc2.nextDouble();
                agregar(encontrarDisp(matriz),nota);
                mostrar(matriz);
                break;
            case 2:
                String palabra = "Cerrando programa";

                try{
                    for(int i = 0,j=1;i < 17;i++,j++){

                        System.out.print(palabra.substring(i,j));
                        Thread.sleep(200);
                    }
                    System.out.print("\n\n");
                    System.out.println("Programa Cerrado Existosamente!");
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                System.exit(0);
                break;
            default:
                System.out.println("Error, has ingresado un numero no valido, la opción " + select + " no existe");
                break;
        }
    }

    public static int[] encontrarDisp(double[][] matriz){

       for(int i = 0,c=0;i < matriz.length;i++){
           for(double elemento: matriz[i]){
               if(elemento == 0){
                   //System.out.println("Disponibilidad encontrada en la matriz ["+i+"]["+c+"]");
                   return new int[]{i,c};
               }
               c++;
           }
       }
        return new int[]{-1,-1};
    }

    public static void mostrar(double[][] matriz ){
        int n=1,o=0;
        System.out.print("  [#]  [Nota]\n");

        for(int i = 0;i < matriz.length;i++){
            for(double elemento: matriz[i]){
                if(elemento != 0) {
                    if (n < 10) {
                        System.out.println("  [" + n + "]   [" + elemento + "]");

                    } else if (n < 100) {
                        System.out.println(" [" + n + "]   [" + elemento + "]");

                    } else {
                        System.out.println("[" + n + "]   [" + elemento + "]");

                    }
                }
                else
                    o++;


                n++;
            }
        }
        if(o==100)
            System.out.println("Aún no tiene notas registradas\n");

        menu();
    }

    public static void agregar(int[] position,double nota){
        matriz[position[0]][position[1]] = nota;
        int i = position[0];
        int j = position[1]+1;
        int id = i+j;
        System.out.println("Nota " + nota + " Agregada correctamente #"+id);

    }
}
