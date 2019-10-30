import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    //Root Panel
    public JPanel userPanel;
    // Data Table
    private JTable userTable;
    // Menu Buttons
    private JButton homeMenuButton;
    private JButton inventoryMenuButton;
    private JButton maintenanceMenuButton;
    private JButton calendarMenuButton;
    // Users Actions
    private JButton addUser;
    private JButton updateUser;
    private JPanel titlePanel;
    private JButton searchUserButton;
    private JComboBox filterUserType;
    private JButton deleteUser;
    private JFormattedTextField searchUserField;

    public Usuario() {
        String header[] = {"Nombre", "Puesto", "Género", "Fecha de Registro"};
        String data[][] = {
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"},
                {"Ana P","Pasante","Femenino","18/06/2017"}
        };
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        userTable.setModel(model);
        Color backColor = new Color(47,84,150);
        userTable.getTableHeader().setReorderingAllowed(false);
        userTable.getTableHeader().setBackground(backColor);
        userTable.getTableHeader().setForeground(Color.white);
    }

    public void showHome(JFrame f, Inicio home){
        this.homeMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(home.homePanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showInventory(JFrame f, Inventario inv){
        this.inventoryMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(inv.invPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showMaintenance( JFrame f, Mantenimiento maint){
        this.maintenanceMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(maint.maintPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void newUserWindow(RegistroUsuario form){
        this.addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = new JFrame("Registrar Nuevo Usuario");
                mainFrame.setContentPane(form.registerUserPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
    }
}
