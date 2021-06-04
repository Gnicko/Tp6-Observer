package punto1;

import punto1.modelo.ClimaObserver;
import punto1.modelo.Medidor;
import punto1.persistencia.GuardarTemperaturaEnArchivo;
import punto1.persistencia.MostrarPorConsola;
import punto1.servidorWeb.WeatherChannelService;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ClimaObserver> observadores = new ArrayList<>();
        observadores.add(new GuardarTemperaturaEnArchivo(new File("Archivo.txt")));
        observadores.add(new MostrarPorConsola());
        Medidor medidor = new Medidor(new WeatherChannelService(), observadores);
        System.out.println("La Temperatura es de : " + medidor.leerTemperatura());
    }
}
