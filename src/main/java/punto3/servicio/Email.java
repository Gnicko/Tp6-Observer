package punto3.servicio;


import punto3.modelo.Venta;
import punto3.modelo.VentaObserver;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class Email implements VentaObserver {
    @Override
    public void enviar(Venta venta, String from) {
        String mensaje = venta.obtenerFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + ", " + venta.obtenerLitros() + ", " + venta.obtenerPrecio() + "\n";

        // remitente
        String to = "EstacionDeServicio@example.com";

        //usuario y clave que se obtiene desde Mailtrap
        final String username = "1de72f31d4002f";
        final String password = "4579c34ab48781";
        String host = "smtp.mailtrap.io";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");// it’s optional in Mailtrap
        props.put("mail.smtp.host", host);

        props.put("mail.smtp.port", "2525");
        // Get the Session object.
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Ticket de nafta");
            message
                    .setText(mensaje);
            // Send message

            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }


}


