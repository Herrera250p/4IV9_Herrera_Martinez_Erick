/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersonas;

/**
 *
 * @author carlos
 */

import javax.swing.JOptionPane;

public class DAOEstudiantes {
    
    Estudiante obj[] = new Estudiante[10];
    int x = 0;

    public void menu() {
        String var = "si";

        while (var.equalsIgnoreCase("si")) {

            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "CRUD ESTUDIANTES\n"
                    + "1. Registrar Datos\n"
                    + "2. Mostrar Datos\n"
                    + "3. Buscar Estudiante\n"
                    + "4. Editar Datos\n"
                    + "5. Eliminar"
            ));

            switch (op) {
                case 1: registrar(); break;
                case 2: mostrar(); break;
                case 3: buscar(); break;
                case 4: editar(); break;
                case 5: eliminar(); break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

            var = JOptionPane.showInputDialog("¿Deseas continuar? (si/no)");
        }
    }

    // registrar
    public void registrar() {
        if (x < obj.length) {

            int boleta = Integer.parseInt(JOptionPane.showInputDialog("Boleta:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            char genero = JOptionPane.showInputDialog("Género (Masculino/Femenino):").charAt(0);

            obj[x] = new Estudiante(boleta, nombre, edad, genero);
            x++;

            JOptionPane.showMessageDialog(null, "Registrado correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Arreglo lleno");
        }
    }

    // mostar
    public void mostrar() {
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos");
        } else {
            String datos = "";

            for (int i = 0; i < x; i++) {
                datos += "Boleta: " + obj[i].getNumBoleta() + "\n"
                        + "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Género: " + obj[i].getGenero() + "\n";
            }

            JOptionPane.showMessageDialog(null, datos);
        }
    }

    // buscar
    public void buscar() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese boleta que desees buscar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getNumBoleta() == boleta) {
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
    public void editar() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Boleta a editar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getNumBoleta() == boleta) {

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
    public void eliminar() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Boleta para eliminar:"));

        for (int i = 0; i < x; i++) {
            if (obj[i].getNumBoleta() == boleta) {

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
}
