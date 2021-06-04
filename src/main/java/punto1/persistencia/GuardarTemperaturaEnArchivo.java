package punto1.persistencia;

import punto1.modelo.ClimaObserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GuardarTemperaturaEnArchivo implements ClimaObserver {
    private File file;

    public GuardarTemperaturaEnArchivo(File file) {
        this.file = file;
    }

    @Override
    public void actualizar(String temperatura) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(this.file,true))) {
            bf.write("Temperatura "+temperatura+" "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+"\n");

        } catch (IOException e) {
            new RuntimeException("no se pudo guardar en el archivo", e);
        }
    }

}
