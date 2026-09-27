public class CamionetaCarga extends Vehiculo{
    //Atributos
    private double capacidadToneladas;
    private static final String descripcionCosto = "Q100 adicionales por tonelada de capacidad por día";
    
    //Constructor
    public CamionetaCarga(double capacidad, String placa, String marca, String modelo, double tarifaD, boolean disponibilidad ){
        super(placa, marca, modelo, tarifaD, disponibilidad);
        this.capacidadToneladas = capacidad;
    }

    //getters
    public double getCapacidadToneladas(){
        return capacidadToneladas;
    }

    //Overrides


        //  de la tarifa para calcular el costo
     @Override
    public double calcularTarifa(int dias) {
        return super.calcularTarifa(dias) + (100 * capacidadToneladas * dias);
    }



        // to string para mostrar esta clase que heredo
    @Override

        public String toString(){
             return super.toString() +
             "\nCostos extra: " + descripcionCosto +
             "\nCapacidad de carga (Toneladas): " + capacidadToneladas +
             "\n-----------------------------------" +
             "\n ";


        }


}