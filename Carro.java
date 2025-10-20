public class Carro{
private String nombre;  // letras
private String marca;
private String tipo;
private String color;

//Contructor
public Carro(String nombredelcarro, String tipocarro, String marcacarro,String colorcarro){
    this.nombre=nombredelcarro;
    this.tipo=tipocarro;
    this.marca=marcacarro;
    this.color=colorcarro;
}


public void hola(){
    System.out.println("Soy un carro deportivo muy potetente"+nombre+"!  soy de tipo"+tipo+"! de "+marca+"! y de  "+color+"!");
}

public static void main(String[]args){
    Carro carropequeño=new Carro("camaro","Deportivo","Chevrolet", "rojo" );
    carropequeño.hola();
}
}
