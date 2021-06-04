package punto1.modelo;

import java.util.List;

public class Medidor extends ClimaObservable {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima, List<ClimaObserver> observadores) {
        this.clima = clima;
        for (ClimaObserver o : observadores) {
            this.agregarObservador(o);
        }
    }

    public String leerTemperatura() {
//leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        this.notificar(this.temperatura);
        return temperatura;
    }

}
