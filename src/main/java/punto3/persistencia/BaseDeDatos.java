package punto3.persistencia;

import punto3.modelo.RegistroVentaRealizada;
import punto3.modelo.Venta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos implements RegistroVentaRealizada {
    private String url;
    private String user;
    private String password;
    private Connection conector;


    public BaseDeDatos() {

        try {
            conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void conectar() throws SQLException {

        this.url = "jdbc:mysql://localhost:3306/epp_gomez?useSSL=false";
        this.user = "root";
        this.password = "";
        try {
            this.conector = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectarse con la base de datos");
        }
    }

    @Override
    public void registrarVenta(Venta venta) throws RuntimeException {
        try {

            conectar();
            PreparedStatement st = conector.prepareStatement("insert into ventas(litros, precio, fecha) values(?,?,?)");

            st.setDouble(1, venta.obtenerLitros());
            st.setDouble(2, venta.obtenerPrecio());
            st.setTimestamp(3, Timestamp.valueOf(venta.obtenerFecha()));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar Participante");
        } catch (RuntimeException e1) {
            throw e1;
        }
    }

    public List<Venta> listadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws RuntimeException {
        List<Venta> ventas = new ArrayList<Venta>();

        try {
            conectar();
            PreparedStatement st = conector.prepareStatement("Select * FROM ventas ");
            ResultSet result = st.executeQuery();
            while (result.next()) {
                if (estaEntreFechas(fechaInicio, fechaFin, result.getTimestamp("fecha").toLocalDateTime().toLocalDate()))
                    ventas.add(new Venta(result.getTimestamp("fecha").toLocalDateTime(), result.getDouble("litros"), result.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("no se pudo recuperar la lista", e);
        }
        return ventas;
    }

    public boolean estaEntreFechas(LocalDate desde, LocalDate hasta, LocalDate actual) {
        return actual.isBefore(hasta) && actual.isAfter(desde) || (actual.equals(desde) || actual.equals(hasta));
    }


}
