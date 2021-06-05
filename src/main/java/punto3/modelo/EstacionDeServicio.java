package punto3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EstacionDeServicio extends VentaObservable {
    private RegistroVentaRealizada registroVentaRealizada;

    public EstacionDeServicio(List<VentaObserver> ventaObservers, RegistroVentaRealizada registroVentaRealizada) {
        for (VentaObserver o : ventaObservers) {
            this.agregarObservador(o);
        }
        this.registroVentaRealizada = registroVentaRealizada;
    }

    public void registrarVenta(Venta venta, String correo) {
        registroVentaRealizada.registrarVenta(venta);
        notificar(venta, correo);
    }

    public double obtenerPrecio(Venta venta) {
        return venta.obtenerPrecio();
    }

    public List<Venta> obtenerVentasEntreFecha(String inicio, String fin) {
        if (inicio == null || inicio.isEmpty())
            throw new RuntimeException("Debe ingresar una fecha de inicio.");
        if (fin == null || fin.isEmpty())
            throw new RuntimeException("Debe ingresar una fecha de fin.");
        LocalDate fechaInicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechaFin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (fechaInicio.isAfter(fechaFin))
            throw new RuntimeException("La fecha de inicio debe ser menor a la fecha de fin.");
        return registroVentaRealizada.listadoPorFechas(fechaInicio, fechaFin);
    }

}
