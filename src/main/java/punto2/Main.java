package punto2;

import punto2.modelo.Medidor;
import punto2.modelo.Repositorio;
import punto2.persistencia.GuardarTemperaturaEnArchivo;
import punto2.persistencia.MostrarPorConsola;
import punto2.servidorWeb.WeatherChannelService;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Repositorio repositorio = new GuardarTemperaturaEnArchivo(new File("Archivo.txt"),
                new MostrarPorConsola(new Medidor(new WeatherChannelService())));

        System.out.println("La temperatura es de: " + repositorio.leerTemperatura() + "°");
    }
}
