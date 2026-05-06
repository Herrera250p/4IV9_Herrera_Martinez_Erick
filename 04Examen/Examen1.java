import java.util.Scanner;


public class Examen1{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Datos para pedir al usuario

        
        String nombre = "";
        String apellidoP = "";
        String apellidoM = "";
        String fedenacimiento = "";
        String direccion = "";

        int opcion;
        double general = 0;

        do{

            System.out.println("Menu");
            System.out.println("1.- Ingresa datos (cliente)");
            System.out.println("2.- Mostrar tipos de piso");
            System.out.println("3.- Calcular el costo ");
            System.out.println("4.- Salir del programa uwu");
            System.out.println("Elige tu opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {
                case 1:

                    //en este apartado el cliente podra agregar los datos solicitados por el programa como apellidos nombre direccion y su fech DE NACIEMINETO
                    System.out.println("Ingresa los datos del cliente");

                    System.out.println("Nombre ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido paterno ");
                    apellidoP = sc.nextLine();
                    System.out.println("Apellido Materno ");
                    apellidoM = sc.nextLine();
                    System.out.println("Fecha de nacimiento ");
                    fedenacimiento = sc.nextLine();
                    System.out.println("Direccion ");
                    direccion = sc.nextLine();

                    break;

                    case 2:
                        System.out.println("Tipo de piso :)");
                            System.out.println("Piso de Porcelanato ($22.35 por metro cuadrado)");
                            System.out.println("Piso de marmoleado ($34.27 por metro cuadrado)");
                            System.out.println("Tipo de piso acrilico ($22.94 por metro cuadrado)");
                        break;


                    case 3:
                        int numcuarto;

                        do{
                        System.out.println("Elige el numero de cuartos de 2 a 4 ");
                            numcuarto = sc.nextInt();
                        }while (numcuarto <= 1 || numcuarto >=5);
                            general = 0;

                        for(int i = 1; i <= numcuarto; i++){
                            double largo = 0;
                            double ancho = 0;
                            double precio = 0;
                            double area = 0;
                            double costo;

                            System.out.println("Cuarto " + i);

                            System.out.println("Largo: " + largo);
                            largo = sc.nextDouble();

                            System.out.println("Ancho: " + ancho);
                            ancho = sc.nextDouble();

                            area = largo + ancho;

                            int tipopiso;

                            System.out.println("Selecciona tu tipo de piso");

                            System.out.println(" 1.- Porcelanato");
                            System.out.println("2.- Acrilico");
                            System.out.println("3.- Marmoleado");
                            tipopiso = sc.nextInt();

                            switch (tipopiso) {
                                case 1:
                                    precio = 22.35;
                                    break;
                                case 2:
                                    precio = 22.94;
                                    break;
                                case 3:
                                    precio = 34.27;
                                    break;
                                default:
                                    System.out.println("La opcion no es valida");
                                    break;
                                    
                            }

                            costo = area * precio;
                            double IVA = costo*0.16;

                            System.out.println("Area: " + area);
                            System.out.println("El costo sin IVA incluido: " + costo);
                            System.out.println("IVA: " + IVA);
                            System.out.println("Total a pagar por el cuarto:" + (costo+IVA));
                            general += (costo + IVA);

                        }

                        System.out.println("Datos de la compra");
                        System.out.println("Comprador:" + nombre + "" + apellidoP + "" + apellidoM);
                        System.out.println("Fecha de nacimiento: " + fedenacimiento);
                        System.out.println("Direccion: " + direccion);

                        System.out.println("Total general: " + general);
                        System.out.println("Deseas realizar la compra? (1.-si/0.-no): " );
                            int compra = sc.nextInt();

                            if (compra == 1) {
                                double decuento = general* 0.0795;
                                double totalfinal = general - decuento;

                                System.out.println("Descuento: " +  decuento);
                                System.out.println("Total a pagar: " + totalfinal);
                                
                            }

                        break;
                        case 4:
                            System.out.println("Salio del programa :>....");
                            break;
                default:
                    System.out.println("La opcion es invalida");
                    break;
                    
            }

        }while (opcion != 4);
        sc.close();
    }
}