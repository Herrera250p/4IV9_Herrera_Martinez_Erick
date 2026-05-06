import java.util.Scanner;

class Figura{
    public static void main (String[] args){
        //menu
        Scanner entrada = new Scanner(System.in);
        char letrapararepetir;
        int opcion = 0;

        do { 
        System.out.println("Eligue la figura a la cual se le calculara el area y perimetro");
        System.out.println("1.cuadrado");
        System.out.println("2.Rectangulo");
        System.out.println("3.Triangulo");
        System.out.println("4.Circulo");
        System.out.println("5.Pentagono");

         opcion = entrada.nextInt();

       
        switch (opcion) {
            case 1:
                System.out.println("Ingrese la medida de un lado del cuadrado");

                float lado;
                lado = entrada.nextFloat();

                float areacuadrado;
                float perimetrocuadrado;

                areacuadrado = lado * lado;
                perimetrocuadrado = lado * 4;
                
                System.out.println("Area " + areacuadrado);
                System.out.println("Perimetro " + perimetrocuadrado);
                
                break;

                case 2:
                    System.out.println("Ingrese la base del rectangulo");

                    float base;
                    base = entrada.nextFloat();
                    System.out.println("Ingrese la altura");
                    float altura;
                    altura = entrada.nextFloat();

                    float arearectangulo;
                    float perimetrorectangulo;

                    arearectangulo = base * altura;
                    perimetrorectangulo = 2 * (base + altura);

                        System.out.println("Area " + arearectangulo);
                        System.out.println("Perimetro" + perimetrorectangulo);

                    break;

                    case 3:
                        System.out.println("Ingrese la base del triangulo");

                        float basetriangulo;
                        basetriangulo = entrada.nextFloat();

                        System.out.println("Ingrese la altura");
                        float alturatriangulo;
                        alturatriangulo = entrada.nextFloat();

                        System.out.println("Ingrese la medida de un lado del triangulo equilatero");
                        float ladotriangulo;
                        ladotriangulo = entrada.nextFloat();

                        float areatriangulo;
                        areatriangulo = (basetriangulo * alturatriangulo) / 2;

                        System.out.println("Area "+ areatriangulo);
                        
                        float perimetrotriangulo;
                        perimetrotriangulo = ladotriangulo * 3;
                        System.out.println("Perimetro de triangulo equilatero" + perimetrotriangulo);
                        break;

                    case 4:
                        System.out.println("Ingrese el radio del circulo");

                        float radio;
                        radio = entrada.nextFloat();
                        float areacirculo;
                        float perimetrocirculo;

                        areacirculo = 3.1416f * radio * radio;
                        perimetrocirculo = 2 * 3.1416f * radio;

                        System.out.println("Area circulo " + areacirculo);
                        System.out.println("Perimetro circulo " + perimetrocirculo);
                        break;
                    case 5:
                        System.out.println("Ingrese la medida de un lado del pentagono");

                        float ladopentagono;
                        ladopentagono = entrada.nextFloat();

                        System.out.println("Ingrese la apotema");

                        float apotema;
                        apotema = entrada.nextFloat();

                        float areapentagono;
                        float perimetropentagono;

                        perimetropentagono = ladopentagono * 5;
                        areapentagono = (perimetropentagono + apotema) / 2;

                        System.out.println("Area " + areapentagono);
                        System.out.println("Perimetro " + perimetropentagono);

                        break;
                        
                    default:
                        break;
        }
        System.out.println("Deseeas repetir el programa escribe s o S para si");
            letrapararepetir = entrada.next().charAt(0);
        } while (letrapararepetir == 's' || letrapararepetir == 'S');
    
    }
}