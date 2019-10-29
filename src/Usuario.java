import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    //Root Panel
    public JPanel userPanel;

    private JButton inicioButton;
    private JButton inventarioButton;
    private JButton mantenimientoButton;
    private JButton calendarioButton;

    private JButton addUser;
    private JButton updateUser;
    private JPanel titlePanel;
    private JTextField searchUserField;
    private JButton searchUserButton;
    private JComboBox filterUser;
    private JButton deleteUser;
    private JTable userTable;

    public Usuario() {
        String header[] = {"Nombre", "Puesto", "Género", "Fecha de Registro"};
        String data[][] = {
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"}
        };

        DefaultTableModel model = new DefaultTableModel(data, header);
        userTable.setModel(model);
        Color backColor = new Color(47,84,150);
        userTable.getTableHeader().setBackground(backColor);
        userTable.getTableHeader().setForeground(Color.white);
    }

    public void showHome(JFrame f, Inicio home){
        this.inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(home.homePanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showInventory(JFrame f, Inventario inv){
        this.inventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(inv.invPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }


}
