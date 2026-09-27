import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        //Creamos variables necesarias y utilizadas durante casi todo el menu para validacion, scaneo y opciones
        Scanner scanner = new Scanner(System.in);
        boolean validar = false;
        boolean programaAbierto = true;
        int opcion = 0;

        //Creamos el sistema de renta movil
        RentaMovil rentaMovil = new RentaMovil();

        // Creamos los 6 vehiculos
        Vehiculo[] flotaInicial = {
            new Automovil(4, true, "PO8175X", "Toyota", "Yaris 2016", 1000, true),
            new Automovil(2, false, "PO157Z", "Ferrari", "GT 2018", 10000, true),
            new Motocicleta(150, "MO548", "Honda", "Pasola 2015", 200, true),
            new Motocicleta(300, "MO568", "Suzuki", "GN125F 2019", 750, true),
            new CamionetaCarga(3, "C867ZX", "Toyota", "Hilux 2020", 1200, true),
            new CamionetaCarga(2.5, "C89579X", "Ford", "Ranger 2022", 1500, true)
        
        };
        
        //Los añadimos a rentamovil
        for (Vehiculo vehiculo : flotaInicial) {
            rentaMovil.registrarVehiculo(vehiculo);
}

    String menu = "\n========== RENTAMOVIL ==========" +
              "\n1. Registrar vehículo" +
              "\n2. Consultar flota" +
              "\n3. Cotizar alquiler" +
              "\n4. Confirmar alquiler" +
              "\n5. Registrar devolución" +
              "\n6. Mostrar reporte general" +
              "\n7. Salir" +
              "\n================================" +
              "\nSeleccione una opción: ";


    while(programaAbierto){
        //imprimimos el menu
        System.out.println(menu);
        validar = false;

        //Validamos siempre cualquier opcion que escoje el usuario 
        while(validar == false){
            try{
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 7) {
                    throw new NumberFormatException();
                }
                validar = true;
            }catch(InputMismatchException e){
            System.out.println("");
                    System.out.println("!ERROR¡");
                    System.out.println("INTENTA INGRESAR UN NUMERO ENTERO");
                    System.out.println("");
                    scanner.nextLine();
            }catch(NumberFormatException e){
                    System.out.println("!ERROR¡");
                    System.out.println("INTENTA INGRESAR UN NUMERO de 1 a 7");
                    System.out.println("");
                    scanner.nextLine();
            }
    }
        validar = false;

        //opcion para añadir un vehiculo
        if(opcion == 1){
            validar = false;
            String tipo = "";
            System.out.println("");
            System.out.println("SELECCIONE SU TIPO DE VE VEHICULO A INGRESAR");
            System.out.println("1. AUTOMOVIL");
            System.out.println("2. MOTOCICLETA");
            System.out.println("3. CAMIONETA DE CARGA");
            scanner.nextLine();
            while (validar == false) { 
                try {
                tipo = scanner.nextLine();
                if(tipo.isBlank()){
                    throw  new Exception();
                }  
                if(!(tipo.equalsIgnoreCase("1") || (tipo.equalsIgnoreCase("Automovil"))
                  ||  (tipo.equalsIgnoreCase("1. Automovil")) || (tipo.equalsIgnoreCase("2"))
                || (tipo.equalsIgnoreCase("2. Motocicleta")) || (tipo.equalsIgnoreCase("Motocicleta"))
                || (tipo.equalsIgnoreCase("3")) || (tipo.equalsIgnoreCase("3. Camioneta de carga"))
            || (tipo.equalsIgnoreCase("Camioneta de carga")))){
                throw  new IllegalStateException();
                }
                validar = true;  
                } catch(IllegalStateException e){
                    System.out.println("");
                    System.out.println("!ERROR¡");
                        System.out.println("SOLAMENTE PUEDES ESCOGER LAS OPCIONES DADAS!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
                catch (Exception e) {
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }
            validar = false;

            if(tipo.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            } else {
            String placa = "";
            String marca = "";
            String modelo = "";
            double tarifa = 0;
            boolean disponibilidad = true;

            System.out.println("Introduce el numero de placa del vehiculo");

            //verificacion de la placa ingresada
            while(validar == false){
                try {
                    placa = scanner.nextLine();
                    if (placa.isBlank()) {
                        throw new Exception();
                    }  
                    if (!(rentaMovil.buscarVehiculo(placa) == null)) {
                        throw new IllegalStateException();
                    }
                    if(placa.equalsIgnoreCase("CANCELAR")){
                    
                    } else if (placa.contains(" ")) {
                       throw  new IllegalArgumentException();
                    }
                    validar = true;
                }catch(IllegalArgumentException e){
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("NO PUEDE HABER ESPACIOS EN LA PLACA!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch(IllegalStateException e){
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("ESTA PLACA YA ESTA REGISTRADA EN EL SISTEMA!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
                catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }

            //if para saber si el usuario dijo cancelar
            if(placa.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            }
            //verificacion de la marca ingresada
            else{
            validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce la marca del vehiculo");
            //verificacion de la marca ingresada
            while(validar == false){
                try {
                    marca = scanner.nextLine();
                    if (marca.isBlank()) {
                        throw new Exception();
                    }
                    if(marca.equalsIgnoreCase("CANCELAR")){
                    
                    } else if (marca.contains(" ")) {
                       throw  new IllegalArgumentException();
                    }
                    validar = true;
                }catch(IllegalArgumentException e){
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("NO PUEDE HABER ESPACIOS EN LA MARCA!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
                catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }
            if(marca.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            }
            //verificacion del modelo ingresado
            else{
                validar = false;
                System.out.println("");
            System.out.println("");
            System.out.println("Introduce el modelo del vehiculo");
            //verificacion del modelo ingresado
            while(validar == false){
                try {
                    modelo = scanner.nextLine().trim();
                    if (modelo.isBlank()) {
                        throw new Exception();
                    }
                    
                    validar = true;
                }
                catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar el registro escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }
            if(modelo.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            }
            //verificacion del modelo ingresado
            else{
                validar = false;
                System.out.println("");
            System.out.println("");
            System.out.println("Introduce la tarifa diaria del vehiculo");
            //verificacion de la tarifa ingresada
            while(validar == false){
                try {
                    tarifa = scanner.nextDouble();
                    if (tarifa <= 0) {
                        throw new Exception();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("SOLAMENTE PUEDES COLOCAR NUMEROS!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
                catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("La tarifa tiene que ser mayor a 0");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                } 
            }
            validar = false;
            scanner.nextLine();
            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("1. Automovil") || tipo.equalsIgnoreCase("Automovil")) {
                boolean automatico = true;
                int pasajeros = 0;
                System.out.println("");
                System.out.println("¿EL AUTOMOVIL ES AUTOMATICO?");
                System.out.println("SI");
                System.out.println("NO");
                System.out.println("");
                String confirmacion = "";
                while(validar == false){
                try {
                    confirmacion = scanner.nextLine();
                    if (confirmacion.isBlank()) {
                        throw new Exception();
                    }
                     if (!(confirmacion.equalsIgnoreCase("SI")|| confirmacion.equalsIgnoreCase("NO"))) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("Solo puedes colocar SI o NO");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar SI o NO!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }}
                if(confirmacion.equalsIgnoreCase("NO")){
                    automatico = false;
                }
                validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce el numero de pasajeros de tu automovil");
            //verificacion del numero de pasajeros
            while(validar == false){
                try {
                    pasajeros = scanner.nextInt();
                    if (pasajeros < 1 || pasajeros > 16) {
                        throw new IllegalArgumentException();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("INTENTA INGRESAR UN NUMERO ENTERO: ");
                        System.out.println("");
                }
                 catch (IllegalArgumentException e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar por almenos 1 pasajero o que no sean mayores de 16!");
                        System.out.println("");
                }
            }
            scanner.nextLine();
            validar = false;
            System.out.println("");
             System.out.println("");
                System.out.println("¿DESEAS REGISTRAR EL AUTOMOVIL?");
                System.out.println("SI");
                System.out.println("NO");
                System.out.println("");
                while(validar == false){
                try {
                    confirmacion = scanner.nextLine();
                    if (confirmacion.isBlank()) {
                        throw new Exception();
                    }
                     if (!(confirmacion.equalsIgnoreCase("SI")|| confirmacion.equalsIgnoreCase("NO"))) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("Solo puedes colocar SI o NO");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar SI o NO!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }}

                if(confirmacion.equalsIgnoreCase("SI")){
                    Vehiculo automovil = new Automovil(pasajeros, automatico, placa, marca, modelo, tarifa, disponibilidad);
                    if (rentaMovil.registrarVehiculo(automovil)) {
                        System.out.println("");
                        System.out.println("REGISTRADO EXITOSAMENTE");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }else {
                         System.out.println("");
                        System.out.println("NO SE HA PODIDO REGISTRAR EL AUTOMOVIL");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }

                } else{
                    System.out.println("");
                    System.out.println("REGISTRO CANCELADO");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                    System.out.println("");
                }
            
            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("2. Motocicleta") || tipo.equalsIgnoreCase("Motocicleta")) {
                int cilindraje = 0;
                validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce el cilindraje que tiene la motocicleta");
            //verificacion del cilindraje ingresado
            while(validar == false){
                try {
                    cilindraje = scanner.nextInt();
                    if (cilindraje < 1) {
                        throw new IllegalArgumentException();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("INTENTA INGRESAR UN NUMERO ENTERO: ");
                        System.out.println("");
                }
                 catch (IllegalArgumentException e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos 1 de cilindraje!");
                        System.out.println("");
                }
            }
            scanner.nextLine();
            validar = false;
            String confirmacion = "";
            System.out.println("");
             System.out.println("");
                System.out.println("¿DESEAS REGISTRAR LA MOTOCICLETA?");
                System.out.println("SI");
                System.out.println("NO");
                System.out.println("");
                while(validar == false){
                try {
                    confirmacion = scanner.nextLine();
                    if (confirmacion.isBlank()) {
                        throw new Exception();
                    }
                     if (!(confirmacion.equalsIgnoreCase("SI")|| confirmacion.equalsIgnoreCase("NO"))) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("Solo puedes colocar SI o NO");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar SI o NO!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }}

                if(confirmacion.equalsIgnoreCase("SI")){
                    Vehiculo motocicleta = new Motocicleta(cilindraje, placa, marca, modelo, tarifa, disponibilidad);
                    if (rentaMovil.registrarVehiculo(motocicleta)) {
                        System.out.println("");
                        System.out.println("REGISTRADO EXITOSAMENTE");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }else {
                         System.out.println("");
                        System.out.println("NO SE HA PODIDO REGISTRAR EL AUTOMOVIL");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }

                } else{
                    System.out.println("");
                    System.out.println("REGISTRO CANCELADO");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                    System.out.println("");
                }


            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("3. Camioneta de carga") || tipo.equalsIgnoreCase("Camioneta de carga")){
                double capacidad = 0;
                validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce la capacidad (en toneladas) que tiene la camioneta");
            //verificacion de la capacidad ingresada
            while(validar == false){
                try {
                    capacidad = scanner.nextDouble();
                    if (capacidad <= 0) {
                        throw new IllegalArgumentException();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("INTENTA INGRESAR UN NUMERO: ");
                        System.out.println("");
                }
                 catch (IllegalArgumentException e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("La capacidad tiene que ser mayor a 0!");
                        System.out.println("");
                }
            }
            scanner.nextLine();
            validar = false;
            String confirmacion = "";
            System.out.println("");
             System.out.println("");
                System.out.println("¿DESEAS REGISTRAR EL LA CAMIONETA?");
                System.out.println("SI");
                System.out.println("NO");
                System.out.println("");
                while(validar == false){
                try {
                    confirmacion = scanner.nextLine();
                    if (confirmacion.isBlank()) {
                        throw new Exception();
                    }
                     if (!(confirmacion.equalsIgnoreCase("SI")|| confirmacion.equalsIgnoreCase("NO"))) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("Solo puedes colocar SI o NO");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar SI o NO!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }}

                if(confirmacion.equalsIgnoreCase("SI")){
                    Vehiculo camioneta = new CamionetaCarga(capacidad, placa, marca, modelo, tarifa, disponibilidad);
                    if (rentaMovil.registrarVehiculo(camioneta)) {
                        System.out.println("");
                        System.out.println("REGISTRADO EXITOSAMENTE");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }else {
                         System.out.println("");
                        System.out.println("NO SE HA PODIDO REGISTRAR EL AUTOMOVIL");
                        System.out.println("");
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                        scanner.nextLine();
                        System.out.println("");
                    }

                } else{
                    System.out.println("");
                    System.out.println("REGISTRO CANCELADO");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                    System.out.println("");
                }

            }
        }
            }
            
            }
            

        }
    }

        if(opcion == 2){
            System.out.println("");
            rentaMovil.mostrarFlota();
            System.out.println("");
            System.out.println("PRESIONA ENTER PARA VOLVER AL MENU");
            scanner.nextLine();
            scanner.nextLine();
            System.out.println("");
        }

        //Cotizar un vehiculo 
        if(opcion == 3){
            System.out.println("");
            scanner.nextLine();
            String placa = "";
            int dias = 0;
            System.out.println("Introduce el numero de placa del vehiculo");

            //verificacion de la placa ingresada
            while(validar == false){
                try {
                    placa = scanner.nextLine();
                    if (placa.isBlank()) {
                        throw new Exception();
                    }
                    if(placa.equalsIgnoreCase("CANCELAR")){
    
                    } else if (rentaMovil.buscarVehiculo(placa) == null) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("La placa ingresada no esta en el sistema!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }

            //if para saber si el usuario dijo cancelar
            if(placa.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            }
            //Verificacion de la cotizacion
            else{
            validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce el numero de dias que quieres cotizar tu vehiculo");
            //verificacion del numero de dias
            while(validar == false){
                try {
                    dias = scanner.nextInt();
                    if (dias < 1) {
                        throw new IllegalArgumentException();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("INTENTA INGRESAR UN NUMERO ENTERO: ");
                        System.out.println("");
                }
                 catch (IllegalArgumentException e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos 1 dia!");
                        System.out.println("");
                }
            }
            validar = false;
            scanner.nextLine();
            //condicion de que si da -1, entonces algo definitivamente salio mal
            double cotizacion =  rentaMovil.cotizarAlquiler(placa, dias);
            if (cotizacion == -1) {
                System.out.println("");
                System.out.println("No se ha podido realizar la cotizacion!");
                System.out.println("PRESIONA ENTER PARA VOLVER AL MENU");
                scanner.nextLine();
                System.out.println("");
            }else{
                //imprime la cotizacion 
                System.out.println("");
                System.out.println("VEHICULO: " + rentaMovil.buscarVehiculo(placa).getMarca() + " " + rentaMovil.buscarVehiculo(placa).getModelo());
                System.out.println("PLACA : " + placa);
                System.out.printf("COTIZACION ESTIMADA: Q %.2f%n", cotizacion);
                System.out.println("");
                System.out.println("PRESIONA ENTER PARA VOLVER AL MENU");
                scanner.nextLine();
            }

        }


        }

        if(opcion == 4){
            System.out.println("");
            scanner.nextLine();
            String placa = "";
            int dias = 0;
            System.out.println("Introduce el numero de placa del vehiculo");

            //verificacion de la placa ingresada
            while(validar == false){
                try {
                    placa = scanner.nextLine();
                    if (placa.isBlank()) {
                        throw new Exception();
                    }
                    if(placa.equalsIgnoreCase("CANCELAR")){
    
                    } else if (rentaMovil.buscarVehiculo(placa) == null) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("La placa ingresada no esta en el sistema!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }

            //if para saber si el usuario dijo cancelar
            if(placa.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            }
            //Verificacion de la cotizacion
            else{
            validar = false;
            System.out.println("");
            System.out.println("");
            System.out.println("Introduce el numero de dias que quieres cotizar tu vehiculo");
            //verificacion del numero de dias
            while(validar == false){
                try {
                    dias = scanner.nextInt();
                    if (dias < 1) {
                        throw new IllegalArgumentException();
                    }
                    validar = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("INTENTA INGRESAR UN NUMERO ENTERO: ");
                        System.out.println("");
                }
                 catch (IllegalArgumentException e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos 1 dia!");
                        System.out.println("");
                }
            }
            validar = false;
            scanner.nextLine();
            //condicion de que si da -1, entonces algo definitivamente salio mal
            double cotizacion =  rentaMovil.cotizarAlquiler(placa, dias);
            if (cotizacion == -1) {
                System.out.println("");
                System.out.println("No se ha podido realizar la cotizacion!");
                System.out.println("PRESIONA ENTER PARA VOLVER AL MENU");
                scanner.nextLine();
                System.out.println("");
            }else{
                //imprime la cotizacion 
                System.out.println("");
                System.out.println("VEHICULO: " + rentaMovil.buscarVehiculo(placa).getMarca() + " " + rentaMovil.buscarVehiculo(placa).getModelo());
                System.out.println("PLACA : " + placa);
                System.out.printf("COTIZACION : Q %.2f%n", cotizacion);
                System.out.println("");
                System.out.println("¿QUIERES CONFIRMAR LA COTIZACION PARA ALQUILAR EL VEHICULO?");
                System.out.println("SI");
                System.out.println("NO");
                System.out.println("");
                String confirmacion = "";
                while(validar == false){
                try {
                    confirmacion = scanner.nextLine();
                    if (confirmacion.isBlank()) {
                        throw new Exception();
                    }
                     if (!(confirmacion.equalsIgnoreCase("SI")|| confirmacion.equalsIgnoreCase("NO"))) {
                        throw new NullPointerException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("Solo puedes colocar SI o NO");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar SI o NO!");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }
            validar = false;

            if(confirmacion.equalsIgnoreCase("NO")){
                System.out.println("");
                System.out.println("Confirmacion cancelada, Regresando al menu");
                System.out.println("");
                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                scanner.nextLine();
            }else{
                if(rentaMovil.confirmarAlquiler(placa, dias)){
                System.out.println("");
                System.out.println("Vehiculo alquilado con exito!");
                System.out.println("");
                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                scanner.nextLine();
                }else{
                System.out.println("");
                System.out.println("No se pudo realizar el alquiler!");
                System.out.println("REGRESANDO AL MENU");
                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                scanner.nextLine();
                }
                

            }

            }

        }
            
        }

        if(opcion == 5){
             System.out.println("");
            scanner.nextLine();
            String placa = "";
            System.out.println("Introduce el numero de placa del vehiculo");

            //verificacion de la placa ingresada
            while(validar == false){
                try {
                    placa = scanner.nextLine();
                    if (placa.isBlank()) {
                        throw new Exception();
                    }
                    if(placa.equalsIgnoreCase("CANCELAR")){
    
                    } else if (rentaMovil.buscarVehiculo(placa) == null) {
                        throw new NullPointerException();
                    } else if (rentaMovil.buscarVehiculo(placa).getDisponibilidad()) {
                        throw new IllegalStateException();
                    }
                    validar = true;
                }catch(NullPointerException e){
                    System.out.println("!ERROR¡");
                        System.out.println("La placa ingresada no esta en el sistema!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");   
                }catch(IllegalStateException e){
                    System.out.println("!ERROR¡");
                        System.out.println("La placa ingresada no se esta alquilando actualmente!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");   
                }
                catch (Exception e) {
                    System.out.println("");
                        System.out.println("!ERROR¡");
                        System.out.println("Tienes que colocar almenos un parametro!");
                        System.out.println("Si deseas cancelar la cotizacion escribre CANCELAR");
                        System.out.println("");
                        System.out.println("Ingresa denuevo!");
                        System.out.println("");
                }
            }

            //if para saber si el usuario dijo cancelar
            if(placa.equalsIgnoreCase("CANCELAR")){
                System.out.println("");
            } else{
                if(rentaMovil.registrarDevolucion(placa)){
                System.out.println("");
                System.out.println("DEVOLUCION REALIZADA CON EXTIO!");
                System.out.println("");
                System.out.println("REGRESANDO AL MENU");
                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                scanner.nextLine();
                } else{
                System.out.println("");
                System.out.println("No se pudo realizar la devolicion del vehiculo!");
                System.out.println("REGRESANDO AL MENU");
                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
                scanner.nextLine();
                }

            }
        }

        //opcion para ver el reporte general de todos los tipos de vehiculo y el total 
        if(opcion == 6){
            System.out.println("");
            rentaMovil.mostrarReporte();
            System.out.println("");
            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENU");
            scanner.nextLine();
            scanner.nextLine();
        
        }

        //salir del programa
        if(opcion == 7){
           programaAbierto = false; 
           System.out.println("");
           System.out.println("TERMINANDO PROGRAMA");
           System.out.println("");
           System.out.println(".... TERMINADO");
        }



    }



    scanner.close();
    }


}