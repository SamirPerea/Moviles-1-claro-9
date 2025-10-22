public class Mascota {
    // 1. Atributos
    public String nombre;
    private String tipo;
    private String color;

    // 2. Constructor
    public Mascota(String nombredemimascota, String tipomascota, String colormascota) {
        this.nombre = nombredemimascota;
        this.tipo = tipomascota;
        this.color = colormascota;
    }

    // 3. Método
    public void Saludar() {
        System.out.println("Hola, soy " + nombre + "! y soy de tipo: " + tipo + "! y soy de color " + color + "!");
    }

    // 4. Clase hija interna con herencia
    public static class TipoAnimalMascota extends Mascota {
        private String animal;

        public TipoAnimalMascota(String nombre, String tipo, String color, String raza) {
            super(nombre, tipo, color);
            this.animal = raza; // ← corregido
        }

        public void definirTipoAnimal() {
            System.out.println("Soy un " + animal);
        }
    }

    // Clase hija MascotaPolicia
    public static class MascotaPolicia extends Mascota {
        private String especialidad;

        public MascotaPolicia(String nombre, String tipo, String color, String especialidad) {
            super(nombre, tipo, color);
            this.especialidad = especialidad;
        }

        @Override
        public void Saludar() {
            System.out.println("|Alto| soy " + nombre + ". Mi especialidad es " + especialidad);
        }
    }

    // 5. Método principal
    public static void main(String[] args) {
        // Crear primer objeto
        Mascota miMascota1 = new Mascota("Nala", "bichón maltés", "blanca");
        miMascota1.Saludar();

        // Crear segundo objeto
        Mascota miMascota2 = new Mascota("Simba", "gato", "naranja");
        miMascota2.Saludar();

        // Usar clase hija
        TipoAnimalMascota mascotaConRaza = new TipoAnimalMascota("Nala", "bichón maltés", "blanca", "perro");
        mascotaConRaza.Saludar();
        mascotaConRaza.definirTipoAnimal();

        // Usar clase hija MascotaPolicia
        MascotaPolicia perroPolicia = new MascotaPolicia("Rex", "pastor alemán", "marrón", "detección de drogas");
        perroPolicia.Saludar();
    }
}
