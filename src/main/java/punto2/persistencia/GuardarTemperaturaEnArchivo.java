package punto2.persistencia;

import punto2.modelo.Repositorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GuardarTemperaturaEnArchivo implements Repositorio {
    private File file;
    private Repositorio repositorio;

    public GuardarTemperaturaEnArchivo(File file, Repositorio repositorio) {
        this.file = file;
        this.repositorio = repositorio;
    }

    @Override
    public String leerTemperatura() {
        String temperatura = this.repositorio.leerTemperatura();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(this.file, true))) {
            bf.write("Temperatura " + temperatura + " " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");

        } catch (IOException e) {
            new RuntimeException("no se pudo guardar en el archivo", e);
        }
        return temperatura;
    }
}
