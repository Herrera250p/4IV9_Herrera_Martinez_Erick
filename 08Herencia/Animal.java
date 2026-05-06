//la herencia es la capacidad de poder tener acceso a los atributos y comportamientos de una clase padre a una clase hijo. Podemos reutilizar codigo.
//encapsulamiento ela capacidad de poder restingir el acceso a los tipos de datos, comportamientos u atributos de una clase frente a otra.
//Con ello vamos a poder agrupar en una clses el acceso a los metodos, atributos y objetos para que no puedan ser modificados.

//sobrecarga es la capacidad de los difertentes metodos de una clase para nombrarse de la misma manera; para establecer diferentes comportamientos


public class Animal{
    private String nombre, raza, tipo_alimento;
    private int edad;

    //toda clase debe tener un constructor
    //sirven para poder declarara la exixtencia de una clase, patra poder icinializar sus variables y poder crear instancias de la misma
    public Animal(){
     //primero su acceso es publico
    //El nombre del contrustor es el mismo que el de la clase pero sin parametros
    //Es un metodo
    

    }
        public Animal(String nom, String raz, String tipo_alime, int eda){
        this.nombre = nom;
        this.raza = raz;
        this.tipo_alimento = tipo_alime;
        this.edad = eda; 
    }

    public String getnombre(){
        return nombre;
    }

    public void setnombre(String nom){
        this.nombre = nom; 
    }

    public String getraza(){
        return raza;
    }

    public void setraza(String raz){
        this.raza = raz; 
    }
    public String gettipo_alimento(){
        return tipo_alimento;
    }

    public void settipo_alimento(String tipo_alime){
        this.tipo_alimento = tipo_alime; 
    } 

    public int getedad(){
        return edad;
    }

    public void setedad(int eda){
        this.edad = eda; 
    }
    
}