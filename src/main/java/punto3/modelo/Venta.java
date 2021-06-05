package punto3.modelo;

import java.time.LocalDateTime;

public class Venta {
    private double litros;
    private double precio;
    private LocalDateTime fecha;
    private TipoNafta tipoNafta;

    public Venta(LocalDateTime fecha, double litros, String tipoNafta) {
        this.fecha = fecha;
        this.litros = litros;
        if (tipoNafta.equals("Comun")) {
            this.tipoNafta = new Comun();
        } else {
            this.tipoNafta = new Super();
        }
        this.precio = this.tipoNafta.calularValor(fecha, litros);
    }

    public Venta(LocalDateTime fecha, double litros, double precio) {
        this.fecha = fecha;
        this.litros = litros;
        this.precio = precio;
    }

    public double obtenerLitros() {
        return litros;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public LocalDateTime obtenerFecha() {
        return fecha;
    }

    public TipoNafta obtenerTipoNafta() {
        return tipoNafta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta that = (Venta) o;
        return Double.compare(that.litros, litros) == 0 && Double.compare(that.precio, precio) == 0 && fecha.equals(that.fecha);
    }
}
