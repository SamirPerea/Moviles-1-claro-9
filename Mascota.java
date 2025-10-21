public class Mascota{
//1 Declaro los atributos de la clase u objeto
private String nombre;  // letras
private String tipo;
private int edad;

//Contructor
public Mascota(String nombredemimascota, String tipomascota, int edadmascota){
    this.nombre=nombredemimascota;
    this.tipo=tipomascota;
    this.edad=edadmascota;
}

//Creo el primer Metodo
public void saludar(){
    System.out.println("Hola, soy "+nombre+"!  soy de tipo"+tipo+"! y tengo "+edad+"!");
}

public class tipoanimalmascota extends Mascota {
    private String raza;

    public tipoanimalmascota ( String nombre,String tipo,int edad,String raza){
        this.raza=raza;
        super(nombre,tipo,edad);
    }

    public void definirtipoanimal(){
        System.out.println("soy un perro");
    }
} 

public static void main(String[]args){
    Mascota Mascotahija=new Mascota("Cronos","Pastor Aleman",5 );
    Mascotahija.saludar();

    Mascota Mimascota=new Mascota("Golden","Golden Retriver");
    Mimascota.saludar();
}  
}
