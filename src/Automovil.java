public class Automovil extends Vehiculo{

    //atributos
    private int pasajeros;
    private boolean automatico;
    private static final String descripcionCosto = "Q50 adicionales por día si es automático";

    //Constructor
    public Automovil(int pasajeros, boolean automatico, String placa, String marca, String modelo, double tarifaD, boolean disponibilidad ){
        super(placa, marca, modelo, tarifaD, disponibilidad);
        this.pasajeros = pasajeros;
        this.automatico = automatico;
    }

    //getters
    public int pasajeros(){
        return  pasajeros;
    }

    public boolean automatico(){
        return  automatico;
    }

    //Overrides


        //  de la tarifa para calcular el costo
    @Override
    public double calcularTarifa(int dias) {
        if(automatico){
            return super.calcularTarifa(dias) + (dias * 50);
        }else{
            return super.calcularTarifa(dias);
        }
}


        // to string para mostrar esta clase que heredo
    @Override

        public String toString(){
             return super.toString() +
             "\nCostos extra: " + descripcionCosto +
             "\nCantidad de pasajeros: " + pasajeros +
             "\nTransmisión automática: " + (automatico ? "Sí" : "No") +
             "\n-----------------------------------" +
             "\n ";


        }

}