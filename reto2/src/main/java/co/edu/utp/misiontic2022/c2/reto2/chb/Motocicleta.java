package co.edu.utp.misiontic2022.c2.reto2.chb;

public class Motocicleta extends Vehiculo {

    private Integer cilindraje;

    public Motocicleta(String marca, String modelo, Double precioBase, Integer cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    @Override
    public Double calcularPrecio() {

        double precio = getPrecioBase();

        if (cilindraje >= 200 && cilindraje <= 350) {
            precio += 500000d;
        }

        if (cilindraje >= 351 && cilindraje <= 500) {
            precio += 750000d;
        }

        if (cilindraje > 500) {
            precio += 1000000d;
        }

        return precio;
    }

    @Override
    public Double calcularPorcentaje() {
        var percentTaxes = calcularPrecio();
        if (percentTaxes > 7_500_000d) {
            return 10d;
        } else {
            return 0d;
        }
    }
}

