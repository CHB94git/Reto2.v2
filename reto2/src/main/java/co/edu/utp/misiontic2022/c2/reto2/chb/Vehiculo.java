package co.edu.utp.misiontic2022.c2.reto2.chb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private Double precioBase;

    public Vehiculo(String marca, String modelo, Double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public abstract Double calcularPrecio();

    public abstract Double calcularPorcentaje();

    public Double calcularDescuento(Date fecha) {

        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);

        var mes = cal.get(Calendar.MONTH);

        var percentDiscount = 0d;

        if (mes == Calendar.JULY && marca.equals("BMW")) {
            percentDiscount = 15;
        } else if (mes == Calendar.JUNE && marca.equals("Suzuki")) {

            if (this instanceof Automovil) {
                percentDiscount = 10;
            } else if (this instanceof Motocicleta) {
                percentDiscount = 5;
            }
        }
        return calcularPrecio() * (percentDiscount / 100);
    }
}
