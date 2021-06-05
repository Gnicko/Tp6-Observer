package punto3.ui;

import punto3.modelo.EstacionDeServicio;
import punto3.modelo.Venta;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaVentas extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField fechaInicio_textField;
    private JTextField fechaFintextField;
    private EstacionDeServicio estacionDeServicio;
    private DefaultTableModel modelo;

    public VentanaVentas(EstacionDeServicio estacionDeServicio) {
        this.estacionDeServicio = estacionDeServicio;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 644, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();


        fechaInicio_textField = new JTextField();
        fechaInicio_textField.setColumns(10);

        fechaFintextField = new JTextField();
        fechaFintextField.setColumns(10);
        JButton buscar_btnNewButton = new JButton("buscar");
        JLabel lblNewLabel = new JLabel("Ingresar Fechas");

        JLabel lblNewLabel_1 = new JLabel("Inicio");

        JLabel lblNewLabel_2 = new JLabel("Fin");

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        cargarLayout(gl_contentPane, scrollPane, buscar_btnNewButton, lblNewLabel_1, lblNewLabel_2, lblNewLabel);


        table = new JTable();
        modelo = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Fecha", "precio", "litro"
                }
        );

        table.setModel(modelo);


        buscar_btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.setRowCount(0);
                    List<Venta> ventas = estacionDeServicio.obtenerVentasEntreFecha(fechaInicio_textField.getText(), fechaFintextField.getText());

                    for (Venta venta : ventas) {
                        modelo.addRow(new Object[]{venta.obtenerFecha(), venta.obtenerPrecio(), venta.obtenerLitros()});
                    }
                    table.setModel(modelo);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar la fecha | " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }

    private void cargarLayout(GroupLayout gl_contentPane, JScrollPane scrollPane, JButton buscar_btnNewButton, JLabel lblNewLabel_1, JLabel lblNewLabel_2, JLabel lblNewLabel) {
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(buscar_btnNewButton)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(fechaInicio_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(fechaFintextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(51)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(29)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addGap(45)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(fechaInicio_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1))
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(fechaFintextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2))
                                .addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(buscar_btnNewButton)
                                .addGap(111))
        );
    }
}
