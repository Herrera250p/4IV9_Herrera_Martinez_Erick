/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author carlos
 */
public class Profesor extends Persona{
    private int id_profesor;
    
    public Profesor(int id_profesor, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.id_profesor = id_profesor;
    }
    
    public int getid_profesor() {
        return id_profesor;
    }

    public void setid_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

}
