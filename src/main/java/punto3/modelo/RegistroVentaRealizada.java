package punto3.modelo;

import java.time.LocalDate;
import java.util.List;

public interface RegistroVentaRealizada {
    public void registrarVenta(Venta venta);

    public List<Venta> listadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin);

}
