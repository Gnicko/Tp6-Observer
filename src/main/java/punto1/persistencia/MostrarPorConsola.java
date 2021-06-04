package punto1.persistencia;

import punto1.modelo.ClimaObserver;

public class MostrarPorConsola implements ClimaObserver {

    @Override
    public void actualizar(String temperatura) {
        if (haceFrio(temperatura))
            System.out.println("Temperatura: " + temperatura + " Hace frio, se encenderá la caldera"+"\n");
        else {
            if (haceCalor(temperatura)) {
                System.out.println("Temperatura: " + temperatura + " Hace calor, se encenderá el aire acondicionado"+"\n");
            } else
                System.out.println("Temperatura: " + temperatura+"\n");
        }
    }
    private boolean haceFrio(String temperatura) {
        String t = temperatura.split(" ")[0];
        int temp = Integer.valueOf(t);
        if (temp < 12) {
            return true;
        }
        return false;
    }

    private boolean haceCalor(String temperatura) {
        String t = temperatura.split(" ")[0];
        int temp = Integer.valueOf(String.valueOf(t));
        if (temp > 17) {
            return true;
        }
        return false;
    }
}
