package co.edu.utp.misiontic2022.c2.reto2.chb;

public class Automovil extends Vehiculo {

    private TipoTransmision transmision;
    private Boolean vidriosElectricos;
    private Boolean aireAcondicionado;

    public Automovil(String marca, String modelo, Double precioBase, TipoTransmision transmision,
            Boolean vidriosElectricos, Boolean aireAcondicionado) {
        super(marca, modelo, precioBase);
        this.transmision = transmision;
        this.vidriosElectricos = vidriosElectricos;
        this.aireAcondicionado = aireAcondicionado;
    }

    public TipoTransmision getTransmision() {
        return transmision;
    }

    public Boolean getVidriosElectricos() {
        return vidriosElectricos;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    @Override
    public Double calcularPrecio() {

        Double precio = getPrecioBase();

        if (transmision == TipoTransmision.AUTOMATICA) {
            precio *= (100 + 5.0) / 100;
        }

        if (aireAcondicionado) {
            precio += 3000000d;
        }

        if (vidriosElectricos) {
            precio += 400000d;
        }

        return precio;
    }

    @Override
    public Double calcularPorcentaje() {
        var percentTaxes = calcularPrecio();
        if (percentTaxes > 60_000_000d) {
            return 10d;
        } else {
            return 0d;
        }
    }
}

/*
 * @Override public Double calcularPorcentajeImpuesto() { var percentTaxes =
 * calcularPrecio(); if (percentTaxes > 60_000_000d) { return 10d; } else{
 * return 0d; } }
 */
