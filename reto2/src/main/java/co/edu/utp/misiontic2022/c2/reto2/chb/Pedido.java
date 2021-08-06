package co.edu.utp.misiontic2022.c2.reto2.chb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Date fecha;
    private String cliente;

    private List<Vehiculo> vehiculos;

    public Pedido(Date fecha, String cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        vehiculos = new ArrayList<>();
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Integer calcularCantidadVehiculos() {
        return vehiculos.size();
    }

    public Double calcularSubtotal() {
        Double subtotal = 0d;
        for (Vehiculo vehiculo : vehiculos) {
            subtotal += vehiculo.calcularPrecio();
        }
        return subtotal;
    }

    public Double calcularDescuentos() {
        Double discount = 0d;
        for (Vehiculo vehiculo : vehiculos) {
            discount += vehiculo.calcularDescuento(fecha);
        }
        return discount;
    }

    public Double calcularImpuestos() {
        Double taxes = 0d;
        for (Vehiculo vehiculo : vehiculos) {
            taxes += (vehiculo.calcularPrecio() - vehiculo.calcularDescuento(fecha)) * vehiculo.calcularPorcentaje()
                    / 100;
        }
        return taxes;
    }

    public Double calcularTotal() {
        return calcularSubtotal() - calcularDescuentos() + calcularImpuestos();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }
}

/*
 * public Double calcularImpuestos(){ Double taxes = 0d; for (Vehiculo vehiculo
 * : vehiculos) { var valueTax = vehiculo.calcularPrecio() -
 * vehiculo.calcularDescuento(fecha); valueTax *=
 * vehiculo.calcularPorcentaje()/100; taxes += valueTax; } return taxes; }
 */