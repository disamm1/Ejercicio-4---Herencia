public class Motocicleta extends Vehiculo{
    //Atributos
    private int cilindraje;
    private static final String descripcionCosto = "Q75 adicionales si el cilindraje es mayor a 250 cc";

    //Constructor
    public Motocicleta(int cilindraje, String placa, String marca, String modelo, double tarifaD, boolean disponibilidad ){
        super(placa, marca, modelo, tarifaD, disponibilidad);
        this.cilindraje = cilindraje;
    }

    //getters
    public int getCilindraje(){
        return cilindraje;
    }


    //Overrides


        //  de la tarifa para calcular el costo
    @Override
    public double calcularTarifa(int dias) {
        if(cilindraje > 250){
            return super.calcularTarifa(dias) + (75);
        }else{
            return super.calcularTarifa(dias);
        }
}


        // to string para mostrar esta clase que heredo
    @Override

        public String toString(){
             return super.toString() +
             "\nCostos extra: " + descripcionCosto +
             "\nCilindraje: " + cilindraje + "cc" +
             "\n-----------------------------------" +
             "\n ";


        }


}