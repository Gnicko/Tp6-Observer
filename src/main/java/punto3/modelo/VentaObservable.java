package punto3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class VentaObservable {
    private List<VentaObserver> registroDeVentas;

    public VentaObservable() {
        this.registroDeVentas = new ArrayList<>();
    }

    public void agregarObservador(VentaObserver observer) {
        this.registroDeVentas.add(observer);
    }

    public void notificar(Venta venta, String correo) {
        for (VentaObserver o : registroDeVentas) {
            o.enviar(venta, correo);
        }
    }

}
