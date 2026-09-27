public class Vehiculo {
    // Atributos
    protected String placa;
    protected String marca;
    protected String modelo; 
    protected double tarifaD;
    protected boolean disponibilidad;


    // Constructor
    public Vehiculo(String placa, String marca, String modelo, double tarifaD, boolean disponibilidad){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaD = tarifaD;
        this.disponibilidad = disponibilidad;
    }


    // Getters
    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }


    public boolean getDisponibilidad(){
        return disponibilidad;
    }

    //Metodos
    // Calculo de la tarifa diaria por dias
    public double calcularTarifa(int dias){
        return tarifaD * dias;
    }


    // Alquilar, si esta disponible lo alquila y pone la disponibilidad en false
    public boolean alquilar(){
        if(disponibilidad){
            disponibilidad = false;
            return true;
        }else {
            return false;
        }
    }

    // devolver el servicio
    public boolean devolver(){
    if(!disponibilidad){
        disponibilidad = true;
        return true;
    } else {
        return false;
    }
}

    // Sobreescritura de To string para mostrar mejor la clase
    @Override

        public String toString(){
             return"\n-----------------------------------" +
         "\nMarca: " + marca +
           "\nModelo: " + modelo +
           "\nPlaca del vehiculo: " + placa + 
           "\nDisponibilidad: " + (disponibilidad ? "Sí" : "No") +
           "\nTarifa Diaria: Q" + String.format("%.2f", tarifaD);
        }

}