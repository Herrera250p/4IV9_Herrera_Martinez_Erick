import java.util.Scanner;

class EntradaTexto {
    //metodo principal

    public static void main(String[]args){
        //instanciar el objeto
        Scanner entrada = new Scanner(System.in);

        //las vatriables locales de codigo
        String nombre;
        int edad;


System.out.println("Escribe tu nombre: ");
    nombre= System.console().readLine(); 
            
        System.out.println("Hola" + nombre + " bienvenido a programar muy feo");
        System.out.println("Escribe tu edad: ");
        edad = entrada.nextInt();
        
    }
