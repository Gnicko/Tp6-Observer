package punto3.modelo;

import java.time.LocalDateTime;

public interface TipoNafta {

    public double calularValor(LocalDateTime dia, double litros);
}
