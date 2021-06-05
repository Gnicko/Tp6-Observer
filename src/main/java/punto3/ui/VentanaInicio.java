package punto3.ui;

import punto3.modelo.EstacionDeServicio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    private EstacionDeServicio estacionDeServicio;
    private JPanel contentPane;


    public VentanaInicio(EstacionDeServicio estacionDeServicio) {
        this.estacionDeServicio = estacionDeServicio;
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton cargarCombustible_btnNewButton = new JButton("Cargar Combustible");
        cargarCombustible_btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaCargarNafta pantalla = new VentanaCargarNafta(estacionDeServicio);
                pantalla.setVisible(true);
            }
        });
        cargarCombustible_btnNewButton.setBounds(37, 147, 155, 21);
        contentPane.add(cargarCombustible_btnNewButton);

        JButton consutlarVemtas_btnNewButton_1 = new JButton("Consultar Ventas");
        consutlarVemtas_btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaVentas ventana = new VentanaVentas(estacionDeServicio);
                ventana.setVisible(true);
            }
        });
        consutlarVemtas_btnNewButton_1.setBounds(244, 147, 149, 21);
        contentPane.add(consutlarVemtas_btnNewButton_1);
    }

}
