package punto2;

import punto2.modelo.ClimaObservable;
import punto2.modelo.ClimaObserver;
import punto2.modelo.Medidor;
import punto2.persistencia.GuardarTemperaturaEnArchivo;
import punto2.persistencia.MostrarPorConsola;
import punto2.servidorWeb.WeatherChannelService;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ClimaObserver> observadores = new ArrayList<>();
        observadores.add(new GuardarTemperaturaEnArchivo(new File("Temperatura.txt")));
        observadores.add(new MostrarPorConsola());

        ClimaObservable medidor = new ClimaObservable(
                new Medidor(new WeatherChannelService()), observadores);
        System.out.println("La Temperatura es de : " + medidor.leerTemperatura());
    }
}
