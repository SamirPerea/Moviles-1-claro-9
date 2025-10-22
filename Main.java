class Carro {
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private String color;
    private double capacidadCarga; // toneladas
    private String tipoCombustible;
    private int numeroEjes;
    private double kilometraje;
    private double precio;
    private String estado; // nuevo, usado, mantenimiento

    public Carro(String marca, String modelo, int añoFabricacion, String color, double capacidadCarga,
                 String tipoCombustible, int numeroEjes, double kilometraje, double precio, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.color = color;
        this.capacidadCarga = capacidadCarga;
        this.tipoCombustible = tipoCombustible;
        this.numeroEjes = numeroEjes;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.estado = estado;
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + añoFabricacion);
        System.out.println("Color: " + color);
        System.out.println("Capacidad de carga (T): " + capacidadCarga);
        System.out.println("Tipo de combustible: " + tipoCombustible);
        System.out.println("Número de ejes: " + numeroEjes);
        System.out.println("Kilometraje: " + kilometraje);
        System.out.println("Precio: $" + precio);
        System.out.println("Estado: " + estado);
    }

    public double calcularDepreciacion() {
        int años = 2025 - añoFabricacion; // suponiendo año actual 2025
        double depAños = precio * 0.05 * años;
        double depKm = precio * 0.0001 * kilometraje;
        double valor = precio - (depAños + depKm);
        if (valor < 0) valor = 0;
        return valor;
    }

    public boolean necesitaMantenimiento() {
        return kilometraje >= 40000 && !estado.equals("mantenimiento");
    }

    public double aplicarDescuento() {
        double precioFinal = precio;
        if (estado.equals("usado")) {
            precioFinal *= 0.85;
        } else if (estado.equals("mantenimiento")) {
            precioFinal *= 0.75;
        }
        if (añoFabricacion < 2020) {
            precioFinal *= 0.90;
        }
        return precioFinal;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }
}

// Clase VolvoTruck hereda de Carro
class VolvoTruck extends Carro {
    private String sistemaSeguridad;
    private String tipoTransmision;
    private String nivelEmisiones;
    private double capacidadTanque;
    private String[] tecnologiaConfort;

    public VolvoTruck(String marca, String modelo, int añoFabricacion, String color, double capacidadCarga,
                      String tipoCombustible, int numeroEjes, double kilometraje, double precio, String estado,
                      String sistemaSeguridad, String tipoTransmision, String nivelEmisiones,
                      double capacidadTanque, String[] tecnologiaConfort) {
        super(marca, modelo, añoFabricacion, color, capacidadCarga, tipoCombustible, numeroEjes, kilometraje, precio, estado);
        this.sistemaSeguridad = sistemaSeguridad;
        this.tipoTransmision = tipoTransmision;
        this.nivelEmisiones = nivelEmisiones;
        this.capacidadTanque = capacidadTanque;
        this.tecnologiaConfort = tecnologiaConfort;
    }

    public void mostrarTecnologia() {
        System.out.print("Tecnologías de confort: ");
        for (String t : tecnologiaConfort) {
            System.out.print(t + ", ");
        }
        System.out.println();
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Sistema de seguridad: " + sistemaSeguridad);
        System.out.println("Tipo de transmisión: " + tipoTransmision);
        System.out.println("Nivel de emisiones: " + nivelEmisiones);
        System.out.println("Capacidad del tanque: " + capacidadTanque + " litros");
        mostrarTecnologia();
    }
}

// Clase ScaniaTruck hereda de Carro
class ScaniaTruck extends Carro {
    private String sistemaSuspension;
    private int potenciaMotor;
    private String tipoCabina;
    private double consumoCombustible;
    private String[] equipamientoEspecial;

    public ScaniaTruck(String marca, String modelo, int añoFabricacion, String color, double capacidadCarga,
                       String tipoCombustible, int numeroEjes, double kilometraje, double precio, String estado,
                       String sistemaSuspension, int potenciaMotor, String tipoCabina,
                       double consumoCombustible, String[] equipamientoEspecial) {
        super(marca, modelo, añoFabricacion, color, capacidadCarga, tipoCombustible, numeroEjes, kilometraje, precio, estado);
        this.sistemaSuspension = sistemaSuspension;
        this.potenciaMotor = potenciaMotor;
        this.tipoCabina = tipoCabina;
        this.consumoCombustible = consumoCombustible;
        this.equipamientoEspecial = equipamientoEspecial;
    }

    public void mostrarEquipamiento() {
        System.out.print("Equipamiento especial: ");
        for (String e : equipamientoEspecial) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Sistema de suspensión: " + sistemaSuspension);
        System.out.println("Potencia del motor: " + potenciaMotor + " hp");
        System.out.println("Tipo de cabina: " + tipoCabina);
        System.out.println("Consumo combustible: " + consumoCombustible + " km/l");
        mostrarEquipamiento();
    }
}

// Gestor de flota que almacena 20 vehículos (10 Volvo + 10 Scania)
class GestorFlota {
    private Carro[] flota;
    private int contador;

    public GestorFlota() {
        flota = new Carro[20];
        contador = 0;
    }

    public void agregarVehiculo(Carro c) {
        if (contador < flota.length) {
            flota[contador] = c;
            contador++;
        } else {
            System.out.println("Flota llena, no se puede agregar más vehículos");
        }
    }

    public void mostrarFlotaCompleta() {
        System.out.println("=== Flota Completa ===");
        for (int i = 0; i < contador; i++) {
            flota[i].mostrarInformacion();
            System.out.println("-------------------");
        }
    }

    public void buscarPorModelo(String modelo) {
        System.out.println("Vehículos con modelo: " + modelo);
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (flota[i].getModelo().equalsIgnoreCase(modelo)) {
                flota[i].mostrarInformacion();
                System.out.println();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún vehículo con ese modelo.");
        }
    }

    public double calcularValorTotalFlota() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += flota[i].calcularDepreciacion();
        }
        return total;
    }

    public void mostrarVehiculosMantenimiento() {
        System.out.println("Vehículos que necesitan mantenimiento:");
        boolean hay = false;
        for (int i = 0; i < contador; i++) {
            if (flota[i].necesitaMantenimiento()) {
                System.out.println(flota[i].getMarca() + " " + flota[i].getModelo() + " - Km: " + flota[i].getKilometraje());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("Ningún vehículo necesita mantenimiento.");
        }
    }

    public void estadisticasPorMarca() {
        int volvo = 0, scania = 0;
        for (int i = 0; i < contador; i++) {
            if (flota[i].getMarca().equalsIgnoreCase("volvo")) {
                volvo++;
            } else if (flota[i].getMarca().equalsIgnoreCase("scania")) {
                scania++;
            }
        }
        System.out.println("Estadísticas por marca:");
        System.out.println("Volvo: " + volvo);
        System.out.println("Scania: " + scania);
    }
}

// Clase principal para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        GestorFlota gestor = new GestorFlota();

        // Agregar 10 Volvo con datos únicos
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "FH16", 2024, "Blanco", 40, "Diésel", 8, 1200, 180000, "nuevo",
                "ABS", "automática", "Euro 6", 600, new String[]{"Aire acondicionado", "Multimedia"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "FMX", 2023, "Azul", 38, "Diésel", 6, 22000, 160000, "usado",
                "ABS", "manual", "Euro 5", 550, new String[]{"Aire acondicionado"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "VNL", 2022, "Rojo", 35, "Diésel", 6, 35000, 150000, "usado",
                "ESP", "automática", "Euro 5", 500, new String[]{"Multimedia"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "FE", 2021, "Gris", 25, "Gas Natural", 4, 40000, 140000, "mantenimiento",
                "ESP", "manual", "Euro 4", 450, new String[]{"Aire acondicionado"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "FL", 2020, "Negro", 22, "Gas Natural", 4, 42000, 130000, "mantenimiento",
                "ABS", "automática", "Euro 4", 400, new String[]{"Multimedia"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "VNR", 2019, "Blanco", 30, "Diésel", 6, 48000, 120000, "usado",
                "ESP", "manual", "Euro 4", 380, new String[]{"Aire acondicionado"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "VHD", 2018, "Azul", 32, "Diésel", 6, 52000, 110000, "usado",
                "ESP", "manual", "Euro 3", 350, new String[]{"Multimedia"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "780", 2017, "Rojo", 28, "Diésel", 6, 56000, 100000, "usado",
                "ABS", "automática", "Euro 3", 330, new String[]{"Aire acondicionado"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "670", 2016, "Gris", 24, "Diésel", 4, 60000, 90000, "usado",
                "ESP", "manual", "Euro 3", 300, new String[]{"Multimedia"}));
        gestor.agregarVehiculo(new VolvoTruck("Volvo", "630", 2015, "Negro", 18, "Diésel", 4, 65000, 80000, "usado",
                "ABS", "manual", "Euro 3", 280, new String[]{"Aire acondicionado"}));

        // Agregar 10 Scania con datos únicos
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "R730", 2024, "Blanco", 40, "Diésel", 8, 1000, 200000, "nuevo",
                "Neumática", 730, "sleeper cab", 3.2, new String[]{"Cámara 360", "Sensor de lluvia"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "S730", 2023, "Rojo", 38, "Diésel", 6, 20000, 180000, "usado",
                "Mecánica", 730, "day cab", 3.8, new String[]{"Sensor de lluvia"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "G450", 2022, "Azul", 32, "Diésel", 6, 30000, 160000, "usado",
                "Neumática", 450, "day cab", 4.0, new String[]{"GPS"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "P410", 2021, "Gris", 28, "Diésel", 6, 40000, 140000, "mantenimiento",
                "Neumática", 410, "sleeper cab", 4.5, new String[]{"GPS", "Cámara"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "L320", 2020, "Negro", 25, "Gas Natural", 4, 42000, 130000, "mantenimiento",
                "Mecánica", 320, "day cab", 5.0, new String[]{"Cámara"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "XT", 2019, "Blanco", 30, "Diésel", 6, 48000, 120000, "usado",
                "Neumática", 400, "sleeper cab", 3.5, new String[]{"Sensor de lluvia"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "Streamline", 2018, "Azul", 28, "Diésel", 6, 52000, 110000, "usado",
                "Mecánica", 380, "day cab", 3.9, new String[]{"GPS"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "T144", 2017, "Rojo", 26, "Diésel", 6, 56000, 100000, "usado",
                "Neumática", 350, "sleeper cab", 4.1, new String[]{"Cámara 360"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "124L", 2016, "Gris", 24, "Diésel", 4, 60000, 90000, "usado",
                "Mecánica", 320, "day cab", 4.5, new String[]{"GPS"}));
        gestor.agregarVehiculo(new ScaniaTruck("Scania", "113M", 2015, "Negro", 22, "Diésel", 4, 65000, 80000, "usado",
                "Neumática", 320, "sleeper cab", 4.0, new String[]{"Sensor de lluvia"}));

        // Mostrar toda la flota
        gestor.mostrarFlotaCompleta();

        // Buscar por modelo
        System.out.println("\nBuscar por modelo FH16:");
        gestor.buscarPorModelo("FH16");

        // Valor total de la flota depreciado
        System.out.println("\nValor total depreciado de la flota: $" + gestor.calcularValorTotalFlota());

        // Vehículos que necesitan mantenimiento
        System.out.println("\nVehículos que necesitan mantenimiento:");
        gestor.mostrarVehiculosMantenimiento();

        // Estadísticas por marca
        System.out.println("\nEstadísticas por marca:");
        gestor.estadisticasPorMarca();
    }
}
