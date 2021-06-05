package punto3;

import punto3.modelo.EstacionDeServicio;
import punto3.modelo.VentaObserver;
import punto3.persistencia.ArchivoTexto;
import punto3.servicio.Email;
import punto3.ui.VentanaInicio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<VentaObserver> listaObserver = new ArrayList<>();
        listaObserver.add(new Email());
        
        VentanaInicio ventanaInicio = new VentanaInicio(
                new EstacionDeServicio(listaObserver, new ArchivoTexto("archivo")
                ));
    }
}
