import java.util.ArrayList;

public class RentaMovil {

    // Atributos
    private ArrayList<Vehiculo> vehiculos;
    private double ingresosTotales;


    // Constructor
    public RentaMovil() {
        vehiculos = new ArrayList<Vehiculo>();
        ingresosTotales = 0;
    }

     //getters
    public double getIngresosTotales() {
        return ingresosTotales;
    }

    //Metodos 
    // Registrar un vehículo
    public boolean registrarVehiculo(Vehiculo vehiculo) {

        // Verificar que la placa no esté repetida
        if (buscarVehiculo(vehiculo.getPlaca()) != null) {
            return false;
        }

        vehiculos.add(vehiculo);
        return true;
    }


    // Buscar vehículo por placa
    public Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }


    // Mostrar todos los vehículos
    public void mostrarFlota() {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }


    // Cotizar un alquiler
    public double cotizarAlquiler(String placa, int dias) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null || dias <= 0) {
            return -1;
        }

        return vehiculo.calcularTarifa(dias);
    }


    // Confirmar un alquiler
    public boolean confirmarAlquiler(String placa, int dias) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        // No existe
        if (vehiculo == null) {
            return false;
        }

        // Días inválidos
        if (dias <= 0) {
            return false;
        }

        // Ya está alquilado
        if (!vehiculo.getDisponibilidad()) {
            return false;
        }

        // Calcular costo
        double costo = vehiculo.calcularTarifa(dias);

        // Cambiar disponibilidad
        if (vehiculo.alquilar()) {
            ingresosTotales += costo;
            return true;
        }

        return false;
    }


    // Registrar devolución
    public boolean registrarDevolucion(String placa) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            return false;
        }

        return vehiculo.devolver();
    }


    // Cantidad total de vehículos
    public int contarVehiculos() {
        return vehiculos.size();
    }


    // Cantidad de vehículos disponibles
    public int contarDisponibles() {

        int contador = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getDisponibilidad()) {
                contador++;
            }
        }

        return contador;
    }


    // Cantidad de vehículos alquilados
    public int contarAlquilados() {

        int contador = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (!vehiculo.getDisponibilidad()) {
                contador++;
            }
        }

        return contador;
    }


    // Mostrar reporte general
    public void mostrarReporte() {

    int autosDisponibles = 0;
    int autosAlquilados = 0;

    int motosDisponibles = 0;
    int motosAlquiladas = 0;

    int camionetasDisponibles = 0;
    int camionetasAlquiladas = 0;


    for (Vehiculo vehiculo : vehiculos) {

        if (vehiculo instanceof Automovil) {

            if (vehiculo.getDisponibilidad()) {
                autosDisponibles++;
            } else {
                autosAlquilados++;
            }

        } else if (vehiculo instanceof Motocicleta) {

            if (vehiculo.getDisponibilidad()) {
                motosDisponibles++;
            } else {
                motosAlquiladas++;
            }

        } else if (vehiculo instanceof CamionetaCarga) {

            if (vehiculo.getDisponibilidad()) {
                camionetasDisponibles++;
            } else {
                camionetasAlquiladas++;
            }
        }
    }


    System.out.println("\n===== REPORTE GENERAL =====");

    System.out.println("\nAutomóviles: " + (autosDisponibles + autosAlquilados));
    System.out.println("Disponibles: " + autosDisponibles);
    System.out.println("Alquilados: " + autosAlquilados);

    System.out.println("\nMotocicletas: " + (motosDisponibles + motosAlquiladas));
    System.out.println("Disponibles: " + motosDisponibles);
    System.out.println("Alquiladas: " + motosAlquiladas);

    System.out.println("\nCamionetas de carga: " + (camionetasAlquiladas + camionetasDisponibles));
    System.out.println("Disponibles: " + camionetasDisponibles);
    System.out.println("Alquiladas: " + camionetasAlquiladas);

    System.out.println("\nTotal de vehículos: " + vehiculos.size());
    System.out.printf("Ingresos totales: Q%.2f%n", ingresosTotales);
    System.out.println("");
}
}


 