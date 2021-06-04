package punto1.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ClimaObservable {
    private List<ClimaObserver> observadores;
    public ClimaObservable(){
        observadores = new ArrayList<>();
    }
    public void agregarObservador(ClimaObserver observer){
      observadores.add(observer);
    }
    protected void notificar(String temperatura){
        for(ClimaObserver o : observadores){
            o.actualizar(temperatura);
        }
    }
}
