import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Ejercicio9 {

    static double[] valores = new double[20];
    static String[] estudiantes = new String[20];
    static boolean[] vacio = new boolean[20];


    public static void main(String[] args) {
        for(boolean estado: vacio){
            estado = true;
        }
        menu();
    }

    public static void menu(){
        String opciones[] = new String[]{"Ingresar nuevo dato","Buscar un dato","Eliminar un dato","Actualizar un dato","Imprimir todo el arreglo","Salir"};
        int opcion = JOptionPane.showOptionDialog(null,"Elige una opción","Menú",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones,null);
        switch(opcion){
            case 0:
                String name = input("Ingrese el nombre del estudiante","Agregar nuevo dato");
                if(name == null)
                    break;

                String input = input("Ingrese la nota","Agregar nota final");
                if(input==null)
                    break;

                try{
                    double nota = Double.parseDouble(input);
                    agregar(name,nota);
                    menu();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"No has ingresado un valor entero","Error",JOptionPane.ERROR_MESSAGE);
                    menu();
                }
                break;

            case 1:
                String dato = input("Ingrese el nombre del estudiante","Buscar dato");
                if(dato == null) {
                    break;
                }

                buscar(dato);
                menu();
                break;
            case 2:
                String eliminar = input("Ingrese el nombre del estudiante","Eliminar dato");
                if(eliminar == null)
                    break;

                eliminar(eliminar);
                menu();
                break;
            case 3:
                String Actualizar = input("Ingrese el nombre del estudiante","Actualizar dato");
                if(Actualizar == null)
                    break;

                String newNota = input("Ingrese la nota","Actualizar nota");
                if(newNota == null)
                    break;

                double update = Double.parseDouble(newNota);
                actualizar(Actualizar,update);
                menu();
                break;
            case 4:
                mostrarDatos();
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"Los datos usados se perderan","Cerrar",JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }

    public static void agregar(String name, double nota){

        int i=0,t=0;
        for(double n: valores){
            if(!vacio[i]){
                t++;
            }
            if(t==21){
                JOptionPane.showMessageDialog(null,"Ya no puede agregar más notas, estudiantes 20/20 calificados", "Aviso", JOptionPane.WARNING_MESSAGE);
                menu();
                return;
            }
            if(n == 0 && estudiantes[i] == null){
              valores[i] = nota;
              estudiantes[i] = name.toLowerCase();
              vacio[i] = false;
              int id = i+1;
              System.out.println(estudiantes[i] + " Agregado correctamente ID="+id+" Nota final: " + nota);
              JOptionPane.showMessageDialog(null,"Nota final "+ nota + " agregada correctamente a " + estudiantes[i]);
              return;
            }
            i++;
        }
    }

    public static void eliminar(String busqueda){
        int i = encontrar(busqueda);
        vacio[i] = true;
        valores[i] = 0;
        estudiantes[i] = null;
        JOptionPane.showMessageDialog(null,"Dato Eliminado Correctamente","Eliminar dato",JOptionPane.PLAIN_MESSAGE);
    }

    public static void actualizar(String search,double update){
      int i= encontrar(search);
      valores[i] = update;
      JOptionPane.showMessageDialog(null,"Datos actualizados correctamente","Actualizar dato",JOptionPane.PLAIN_MESSAGE);
    }

    public static void buscar(String busqueda){
      int i = encontrar(busqueda);
      int id = i+1;
      JOptionPane.showMessageDialog(null,"Estudiante #"+id+" "+estudiantes[i]+" Nota final = "+valores[i]);
    }

    //Funciónn para encontrar la posición del elemento con el nombre buscado
    public static int encontrar(String busqueda){
        int i=0;
        for(String e: estudiantes){
            if (e.contains(busqueda.toLowerCase())) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void mostrarDatos(){
        JFrame frame = new JFrame("Nota final de los estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 403);
        frame.setLocationRelativeTo(null);

        String[] columnNames = {"Id","Nombre","Nota final"};
        Object[][] data = new Object[20][3];
        for(double val: valores) {
            for(int i = 0;i < valores.length;i++){
                data[i][0] = i+1;
                if(valores[i]== 0 && estudiantes[i] == null){
                    data[i][2] = "vacio";
                }else{
                    data[i][2] = valores[i];
                    data[i][1] = estudiantes[i].toUpperCase();
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                frame.dispose();
                menu();
            }
        });
        frame.getContentPane().add(cerrar);
        // Agregar el JScrollPane al JFrame
        frame.add(scrollPane); frame.setVisible(true);
        frame.add(cerrar, BorderLayout.SOUTH);
    }

    public static String input(String mensaje, String title){
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        JTextField textField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(new JLabel(mensaje));
        panel.add(textField);

        Object[] options = {okButton, cancelButton};
        JOptionPane OptionPane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

        JDialog dialog = OptionPane.createDialog(title);

        final String[] obtenido = new String[1];

        okButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.out.println(" Catch: " + textField.getText());
                obtenido[0] = textField.getText();
                dialog.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                obtenido[0] = null;
                menu();
            }
        });
        dialog.setVisible(true);
        return obtenido[0];
    }
}