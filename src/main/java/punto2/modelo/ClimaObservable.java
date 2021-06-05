package punto2.modelo;

import java.util.List;

public class ClimaObservable implements ClimaDecorador {
    private List<ClimaObserver> observadores;
    private ClimaDecorador climaDecorador;

    public ClimaObservable(ClimaDecorador climaDecorador, List<ClimaObserver> observadores) {
        this.observadores = observadores;
        this.climaDecorador = climaDecorador;
    }

    public void agregarObservador(ClimaObserver observer) {
        observadores.add(observer);
    }

    public void notificar(String temperatura) {
        for (ClimaObserver o : observadores) {
            o.actualizar(temperatura);
        }
    }

    @Override
    public String leerTemperatura() {
        String temperatura = climaDecorador.leerTemperatura();
        notificar(temperatura);
        return temperatura;
    }
}
