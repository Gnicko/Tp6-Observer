package punto3.ui;

import punto3.modelo.EstacionDeServicio;
import punto3.modelo.Venta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class VentanaCargarNafta extends JFrame {
    private EstacionDeServicio estacionDeServicio;
    private JPanel contentPane;
    private JTextField litro_textField;
    private JTextField correo_textField;


    public VentanaCargarNafta(EstacionDeServicio estacionDeServicio) {
        this.estacionDeServicio = estacionDeServicio;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        correo_textField = new JTextField();
        correo_textField.setBounds(326, 10, 96, 19);
        contentPane.add(correo_textField);
        correo_textField.setColumns(10);

        litro_textField = new JTextField();
        litro_textField.setBounds(326, 60, 96, 19);
        contentPane.add(litro_textField);
        litro_textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Correo");
        lblNewLabel_3.setBounds(62, 10, 83, 25);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("Litros de Nafta");
        lblNewLabel.setBounds(62, 63, 96, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tipo de Nafta");
        lblNewLabel_1.setBounds(62, 120, 83, 25);
        contentPane.add(lblNewLabel_1);

        JComboBox nafta_comboBox = new JComboBox();
        nafta_comboBox.setBounds(326, 135, 96, 21);
        nafta_comboBox.addItem("Super");
        nafta_comboBox.addItem("Comun");
        contentPane.add(nafta_comboBox);
        JLabel monto_label = new JLabel("");
        monto_label.setBounds(325, 203, 68, 13);
        contentPane.add(monto_label);

        JButton btnNewButton = new JButton("Consultar Monto");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double litros = Double.parseDouble(litro_textField.getText());
                    String tipoNafta = String.valueOf(nafta_comboBox.getSelectedItem());
                    monto_label.setText(String.valueOf(estacionDeServicio.obtenerPrecio(
                            new Venta(LocalDateTime.now(), litros, tipoNafta)
                    )));

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "ingrese un numero valido para los litros", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(62, 199, 142, 21);
        contentPane.add(btnNewButton);


        JButton btnNewButton_1 = new JButton("Confirmar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double litros = 1;
                    litros = Double.parseDouble(litro_textField.getText());
                    String tipoNafta = String.valueOf(nafta_comboBox.getSelectedItem());
                    String correo = correo_textField.getText();
                    estacionDeServicio.registrarVenta(
                            new Venta(LocalDateTime.now(), litros, tipoNafta), correo
                    );

                    JOptionPane.showMessageDialog(null, "Se guardo la venta", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "ingrese un numero valido para los litros", "error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        btnNewButton_1.setBounds(60, 258, 85, 21);
        contentPane.add(btnNewButton_1);

    }
}



