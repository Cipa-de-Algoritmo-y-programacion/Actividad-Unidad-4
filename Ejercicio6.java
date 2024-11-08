import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {
    /*
        Desarrollar un algoritmo que elimine un elemento ingresado por teclado de
        un arreglo e imprima la posición en que fue eliminado y el nuevo arreglo.
     */
    static ArrayList<String> cipa = new ArrayList();
    public static void main(String[] args) {
        cipa.add("bella samai botello mesa");
        cipa.add("maria camila lopez villa");
        cipa.add("nathan gama jimenez");
        cipa.add("kevin manuel gomez rojas");

        mostrar(cipa);
        eliminarElemento(cipa);
    }
    public static void eliminarElemento(ArrayList<String> cipa) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Ingrese el nombre del estudiante que desea eliminar: ");
       String nombre = sc.nextLine();
       for(int i = 0; i < cipa.size(); i++) {
           if(cipa.get(i).contains(nombre.toLowerCase())) {
               String element = cipa.get(i);
               System.out.println( "Integrante " + cipa.get(i) + " eliminado");
               System.out.println("corresponde a elemento " + i);
               cipa.remove(i);
           }
       }
       sc.close();
       System.out.println("Integrantes actuales del cipa");
       mostrar(cipa);
    }

    public static void mostrar(ArrayList<String> array) {
        for(String elemento : array){
            System.out.println(elemento.toUpperCase());
        }
    }

}
