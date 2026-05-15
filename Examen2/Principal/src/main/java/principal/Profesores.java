/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author carlos
 */

import javax.swing.JOptionPane;

public class Profesores {
    Profesor obj[] = new Profesor[10];
    int x = 0;

    public void menu_profesor() {
        String var = "si";

        while (var.equalsIgnoreCase("si")) {

            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "CRUD PROFESOR\n"
                    + "1. Registrar Datos\n"
                    + "2. Mostrar Datos\n"
                    + "3. Buscar Profesor\n"
                    + "4. Editar Datos\n"
                    + "5. Eliminar"
            ));

            switch (op) {
                case 1: registrar_prof(); break;
                case 2: mostrar_prof(); break;
                case 3: buscar_prof(); break;
                case 4: editar_prof(); break;
                case 5: eliminar_prof(); break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

            var = JOptionPane.showInputDialog("¿Deseas continuar? (si/no)");
        }
    }

    // registrar
    public void registrar_prof() {
        if (x < obj.length) {

            int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Identificador:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            char genero = JOptionPane.showInputDialog("Género (Masculino/Femenino):").charAt(0);

            obj[x] = new Profesor(identificacion, nombre, edad, genero);
            x++;

            JOptionPane.showMessageDialog(null, "Registrado correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Arreglo lleno");
        }
    }

    // mostar
    public void mostrar_prof() {
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos");
        } else {
            String datos = "";

            for (int i = 0; i < x; i++) {
                datos += "Identificacor: " + obj[i].getid_profesor() + "\n"
                        + "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Género: " + obj[i].getGenero() + "\n";
            }

            JOptionPane.showMessageDialog(null, datos);
        }
    }

    // buscar
    public void buscar_prof() {
        int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificador que desees buscar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getid_profesor() == identificacion) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Género: " + obj[i].getGenero());
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No  se encontro");
    }

    // editar
    public void editar_prof() {
        int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Identificador a editar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getid_profesor()== identificacion) {

                obj[i].setNombre(JOptionPane.showInputDialog("Nuevo nombre"));
                obj[i].setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad")));
                obj[i].setGenero(JOptionPane.showInputDialog("Nuevo género").charAt(0));

                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontro");
    }

    // eliminar
    public void eliminar_prof() {
        int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Identificador que deseas eliminar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getid_profesor()== identificacion) {

                for (int j = i; j < x - 1; j++) {
                    obj[j] = obj[j + 1];
                }

                obj[x - 1] = null;
                x--;

                JOptionPane.showMessageDialog(null, "Eliminado");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No  se encontro");
    }
    
        public Profesores(){
    
        obj = Achivo.cargarProfesor();
        
        for(Profesor e : obj){
            
            if(e != null){
            
                x++;
            }
        }   
    }
}
