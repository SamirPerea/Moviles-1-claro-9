// Clase padre
public class Dydyflow {

    // Atributos generales
    private String nombre;
    private String direccion;
    private String telefono;
    private String administrador;
    private String horario;
    private String tipo;
    private String productos;
    private String empleados;
    private int ingresos;
    private String metodosdepago;

    // Constructor
    public Dydyflow(String nombredeminegocio, String direcciondeminegocio, String telefonodeminegocio,
                    String administradordeminegocio, String horariodeminegocio, String tipodeminegocio,
                    String productosdeminegocio, String empleadoseminegocio, int ingresosdeminegocio,
                    String metodosdepagodeminegocio) {

        this.nombre = nombredeminegocio;
        this.direccion = direcciondeminegocio;
        this.telefono = telefonodeminegocio;
        this.administrador = administradordeminegocio;
        this.horario = horariodeminegocio;
        this.tipo = tipodeminegocio;
        this.productos = productosdeminegocio;
        this.empleados = empleadoseminegocio;
        this.ingresos = ingresosdeminegocio;
        this.metodosdepago = metodosdepagodeminegocio;
    }

    // Método de la clase padre
    public void saludar() {
        System.out.println("¡Bienvenido a mi tienda " + nombre + "!");
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Administrador: " + administrador);
        System.out.println("Horario: " + horario);
        System.out.println("Tipo de tienda: " + tipo);
        System.out.println("Productos: " + productos);
        System.out.println("Empleados: " + empleados);
        System.out.println("Ingresos mensuales: $" + ingresos);
        System.out.println("Métodos de pago: " + metodosdepago);
    }
}

// Clase hija
class TiendaFisica extends Dydyflow {

    private String ubicacionCentroComercial;
    private boolean tieneProbadores;
    private int numeroDeVitrinas;

    public TiendaFisica(String nombredeminegocio, String direcciondeminegocio, String telefonodeminegocio,
                        String administradordeminegocio, String horariodeminegocio, String tipodeminegocio,
                        String productosdeminegocio, String empleadoseminegocio, int ingresosdeminegocio,
                        String metodosdepagodeminegocio, String ubicacionCentroComercial,
                        boolean tieneProbadores, int numeroDeVitrinas) {

        // Llamamos al constructor del padre
        super(nombredeminegocio, direcciondeminegocio, telefonodeminegocio,
              administradordeminegocio, horariodeminegocio, tipodeminegocio,
              productosdeminegocio, empleadoseminegocio, ingresosdeminegocio,
              metodosdepagodeminegocio);

        // Inicializamos los atributos propios de la tienda física
        this.ubicacionCentroComercial = ubicacionCentroComercial;
        this.tieneProbadores = tieneProbadores;
        this.numeroDeVitrinas = numeroDeVitrinas;
    }

    // Método específico de la clase hija
    public void mostrarFisica() {
        System.out.println("🏬 Tienda ubicada en: " + ubicacionCentroComercial);
        System.out.println("¿Tiene probadores? " + (tieneProbadores ? "Sí" : "No"));
        System.out.println("Número de vitrinas: " + numeroDeVitrinas);
    }
}

// Clase principal con método main para probar todo
class Principal {
    public static void main(String[] args) {

        TiendaFisica tienda1 = new TiendaFisica(
                "Dydy Flow",
                "Calle 22 #15-34",
                "3214567654",
                "Samir Perea",
                "8:30 AM - 6:00 PM",
                "Retail",
                "Ropa de toda clase",
                "Juan, Diego, Lina",
                5500000,
                "Tarjeta y efectivo",
                "Centro Comercial Viva",
                true,
                5
        );

        // Llamamos a métodos heredados y propios
        tienda1.saludar();       // método heredado de Dydyflow
        tienda1.mostrarFisica(); // método de TiendaFisica
    }
}
