/*
vamos a crear 14 pogramas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia
1.-Desarrollar un programa para calcular el bono de un descuento por edad
2.- convertyir numeros a binarios
3.-Convertir temperaturas entre los tres principales grados C, F y K
4.- Realizar un programa para contar numerode positivos y negativos de una serie de numeros
5.- Desarrollar una tiends para agregar productos y precios
6.-Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.-desarrollar una tabla 
8.-Desarrollar una tabala para calcular el factorial xcon recursividad 
9.-Vamos hacer dibujitos wiiiii
10.- Desarrrollar una figura hueca
11.- Realizar algunos patrones
12.- Realizar un diamante
13.- Desarrrollar una calculadora basica+-*/

import java.util.Scanner;

class EstructuraDatos {
    
    public static void main(String[]args){
        //aqqui van las variables
        int opcion;
        Scanner entrada = new Scanner(System.in);
        char letrapararepetir;
        
        //aqui van los objetos

        //aqui va el menu
    do{

        System.out.println("Bienbenido a este programa para verificar que tanto saben de programar a partir de olgaritmos basicos");
        System.out.println("Por favor elija la opcion deseada");
        System.out.println("1.-");
        System.out.println("2.-");
        System.out.println("3.-");
        System.out.println("4.-");
        System.out.println("5.-");
        System.out.println("6.-");
        System.out.println("7.-");
        System.out.println("8.-");
        System.out.println("9.-");
        System.out.println("10.-");
        System.out.println("11.-");
        System.out.println("12.-");
        System.out.println("13.-");
        System.out.println("14.-Salir");
        
        //entrada de dato
        opcion= entrada.nextInt();
        //ahoratengo que evaluar la entrada
    
        switch (opcion){
            case 1:
                System.out.println("Bienvenido a este programa para calcular un descuento por edad ");
                System.out.println("Ingrese su edad");
                //aqui iingresa variables y entrada de datos
                int edad;
                edad = entrada.nextInt();

                if(edad < 16){
                    System.out.println("No tiene descuento");
                }
                else if(edad >= 18&& edad < 60){
                    System.out.println("Tiene un descuento de 30%");

                }else{
                    System.out.println("Tiene un descuento del 35$");
                }

                break;
            case 2:
                //convertir un numero decimal en binario
                System.out.println("Ingrese un numero positiovo que deseeconvertir a binario");
                int numbinario;
                String guardarbinario = "";
                numbinario = entrada.nextInt();

                if(numbinario > 0){
                    while(numbinario > 0){
                        if(numbinario%2 == 0){
                            guardarbinario = "0" + guardarbinario;
                        }else{
                            guardarbinario = "1" + guardarbinario;
                        }
                        numbinario = (int)numbinario/2;
                    }
                }else if (numbinario == 0){
                    guardarbinario = "0";
                }else{
                    guardarbinario = "nose puede convertir ese nnumero, solo acepta positivos";

                }
                System.out.println("El numero convertido a binario ");

                break;
                case 3:
                    System.out.println("Convercion de temperaturas");
                    System.out.println("Ingrese la temoperatura en celsius");

                    //Celsius
                    float celsius;
                    celsius = entrada.nextFloat();
                    //Kelvin
                    float kelvin;
                    //Fahrenheit
                    float fahrenheit;

                    //formulas de convercion 

                    fahrenheit = (celsius * 9/5) + 32;
                    kelvin = celsius + 273.15f;

                    //respuestas 
                    System.out.println("Temperatura en fahrenheit" +  fahrenheit);
                    System.out.println("Temperatura en kelvin" +  kelvin);
                    break;
                case 4: 
                    System.out.println("Contador de numeros positivos y negativos");
                    System.out.println("Ingresa la cantidad de numeros que vas a ingresar");

                    int canum;
                    canum = entrada.nextInt();

                    int positivo = 0;
                    int negativo = 0;

                        for(int i = 1; i <= canum; i++){
                            System.out.println("Ingrese un numero ");
                            int num;
                            num = entrada.nextInt();

                            if(num>= 0){
                                positivo++;
                            }else{
                                negativo++;
                            }
                        }
                        System.out.println("Numeros positivos totales" + positivo);
                        System.out.println("Numeros negativos totales" + negativo);

                    break; 
                case 5:
                    System.out.println("Bienvenido a una tienda linda y kawai");
                    System.out.println("Por favor ingrese cuantos elementos va a comprar");
                    int elementosproducto = 0; 
                    elementosproducto = entrada.nextInt();
                    if(elementosproducto > 0){
                        float compra = 0;
                        for(int i = 1; 1<= elementosproducto; i++){
                            System.out.println("Ingresa el nombre del producto");
                            String nombreproducto = "";
                            nombreproducto = entrada.next();
                            System.out.println("ingrese el precio");
                            float precio = entrada.nextFloat();
                            System.out.println("Ingrese la cantidad del producto");
                            int cantidad = entrada.nextInt();
                            float resultado = cantidad * precio;

                            compra = compra + resultado;
                        }
                        System.out.println("El total de las compras es: " + compra);
                    }else{
                        System.out.println("Ingrese solom cantidades positivas" );
                    }

                    break;

                    case 6:
                        System.out.println("cuadrado");
                        System.out.println("rectangulo");
                        System.out.println("triangulo");
                        System.out.println("circulo");
                        System.out.println("pentagono");

                        int fig;
                        fig =entrada.nextInt();

                        switch (fig){
                            case 1:
                                System.out.println("Ingrese la medidsa de un lado del cuadrado");
                                float lado;
                                lado = entrada.nextFloat();

                                float cuadrado;
                                float pericuadrado;

                                cuadrado = lado * lado;
                                pericuadrado = lado * 4;

                                System.out.println("Area" +  cuadrado);
                                System.out.println("Perimetro" + pericuadrado);
                                break;
                            case 2:
                                System.out.println("Ingrese la base del rectangulo");
                                float base;
                                base = entrada.nextFloat();
                                System.out.println("Ingrese la altura");
                                float altura;
                                altura = entrada.nextFloat();

                                float rectangulo;
                                float perirec;

                                rectangulo = base * altura;
                                perirec = 2 * (base + altura);
                                    System.out.println("Area" + rectangulo);
                                    System.out.println("Perimetro" + perirec);
                                break;
                            case 3:
                                System.out.println("Ingrese la base del triangulo");
                                float basetrian;
                                basetrian = entrada.nextFloat();
                                System.out.println("Ingrese la altura del triangulo");
                                float alturatrian;
                                alturatrian = entrada.nextFloat();
                                float areatri;

                                areatri = (basetrian * alturatrian) / 2;
                                System.out.println("Area" + areatri);
                                break;
                            case 4:
                                System.out.println("Ingrese el radio del circulo");
                                float radio;
                                radio = entrada.nextFloat();
                                float areacir;
                                float perimetrocirculo;

                                areacir = 3.1416f * radio * radio;
                                perimetrocirculo = 2 * 3.1416f * radio;
                                System.out.println("Area" + areacir);
                                System.out.println("Perimetro" + perimetrocirculo);
                                break;
                            case 5:
                                System.out.println("Ingrese la medida de un lado del pentagono");
                                float ladopen;
                                ladopen = entrada.nextFloat();
                                System.out.println("Ingrese la apotema");
                                float apo;
                                apo = entrada.nextFloat();

                                float areap;
                                float perimetrop;

                                perimetrop = ladopen * 5;
                                areap = (perimetrop + apo) / 2;
                                System.out.println("Area" + areap);
                                System.out.println("Perimetro" + perimetrop);
                                break; 

                        }
                        break;

                    case 7:

                    //quiero duna tabla de multiplicar
                    //deberan darle formato titulos

                    for(int n = 1; n <= 10; n++){
                        System.out.println(n + " | " + (n * 10 + " | " + (n * 100) + " | " + (n * 1000)));
                    }
                        break;

                    case 8:
                        System.out.println("Ingrese un numero ");


                        int numerofactorial = entrada.nextInt();
                        int fact = 1;

                        for (int i = 1; i <= numerofactorial; i++){
                            fact = fact * i;
                        }
                        System.out.println("El factorial es:" + fact);
                        break;
                    case 9:
                        System.out.println("Vamos a realizar un dibujo de un cuadrado magico");
                        System.out.println("Ingrese el tamaño del cuadrado");

                        int n1 = entrada.nextInt();

                        if(n1 >= 1 && n1 <=20){
                            //seimprime
                            for(int i = 1; i <= n1; i++){
                                //recorro las columnas
                                for(int j = 1; j <= n1; j++){


                                }
                            }
                        }else{
                            System.out.println("Por favor solo ingrese valores emntre uno y el 20");
                        }
                        break;
                        case 10:
                            System.out.println("Ingrese el tamaño del dibujo kawaii");


                            int tama = entrada.nextInt();

                            if(tama >= 1 && tama <= 20){
                                for(int i = 1; i <= tama; i++){
                                    for(int j = 1; j <= tama; j++){
                                        if (i == 1 || i == tama || j == 1 || j == tama) {
                                            System.out.print("*");
                                        }else{
                                            System.out.print(" ");
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                            break;
                            case 11:
                                System.out.println("NO intente otro numero");
                                break;
                            case 12:
                                System.out.println("Ingrese el tamaño del diamante");

                                int diamon = entrada.nextInt();

                                for(int i = 1; i <= diamon; i++){
                                    for(int j = 1; j <= diamon - i; j++){
                                        System.out.print(" ");

                                    }
                                for(int j = 1; j <= (2*i - 1); j++){
                                System.out.print("*");

                                }
                                    System.out.println();
                                }

                                for(int i = diamon - 1; i >=1; i--){
                                    for(int j = 1; j <= diamon -i; j++){
                                        System.out.print("*");
                                    }
                                    for(int j = 1; j <= (2*i - 1); j++){
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;

                                case 13:
                                    System.out.println("Calculadora basiquisima");
                                    System.out.println("Ingrese su primer numero");
                                    float resul = entrada.nextFloat();
                                    char continuar;

                                    do{
                                        System.out.println("Ingrese la operacion deseada");

                                        char operacion = entrada.next().charAt(0);

                                        System.out.println("ingrese numero");
                                        float num = entrada.nextFloat();


                                        if (operacion == '+'){
                                            resul = resul + num;
                                        }else if (operacion == '-'){
                                            resul = resul + num;
                                        }else if (operacion == '*') {
                                            resul = resul + num;
                                        }else if (operacion == '/') {
                                            resul = resul + num;
                                        }else{
                                            System.out.println("Opercion no valida");
                                        }
                                            System.out.println("¿Deseas continuar con la calculadora? (s)(n)");
                                            continuar = entrada.next().charAt(0);

                                    }while (continuar == 's' || continuar == 'S');

                                    System.out.println("Resultado final" + resul);
                                    break;
                        default:
                            break;

                    

                }
        System.out.println("Deseeas repetir el programa escribe s o S para si");
            letrapararepetir = entrada.next().charAt(0);
        }while (letrapararepetir == 's' || letrapararepetir == 'S');

        


    }
}
