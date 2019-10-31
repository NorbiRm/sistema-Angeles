import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario {

    // Root Panel
    public JPanel invPanel;
    // Data Table
    private JTable inventoryTable;
    // Menu Buttons
    private JPanel titlePanel;
    private JButton homeMenuButton;
    private JButton maintenanceMenuButton;
    private JButton calendarMenuButton;
    private JButton usersMenuButton;
    private JButton deleteEquipment;
    // Inventory Actions
    private JPanel menuPanel;
    private JButton addEquipment;
    private JButton viewFullTable;
    private JButton updateEquipment;
    private JButton printTable;
    private JButton searchButton;
    private JComboBox filterColumn;
    private JTextField searchEquipmentTextField;

    private Controller controller;


    public Inventario(Controller controller) {
        this.controller = controller;

        inventoryTable.setModel(generateModel(true));
        Color backColor = new Color(47,84,150);
        inventoryTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        inventoryTable.getTableHeader().setReorderingAllowed(false);
        inventoryTable.getTableHeader().setBackground(backColor);
        inventoryTable.getTableHeader().setForeground(Color.white);

        viewFullTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewFullTable.getText().compareTo("Ver Tabla Completa") == 0){
                    inventoryTable.setModel(generateModel(false));
                    viewFullTable.setText("Ver Tabla Reducida");
                }else{
                    inventoryTable.setModel(generateModel(true));
                    viewFullTable.setText("Ver Tabla Completa");
                }
            }
        });

        this.addEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroEquipo form = new RegistroEquipo(controller);
                JFrame mainFrame = new JFrame("Registrar Nuevo Equipo");
                mainFrame.setContentPane(form.registerEquipmentPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
        updateEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarEquipo form = new EditarEquipo(controller);
                JFrame mainFrame = new JFrame("Actualizar Equipo");
                mainFrame.setContentPane(form.editEquipmentPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(1000, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
        deleteEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarEquipo form = new EliminarEquipo(controller);
                JFrame mainFrame = new JFrame("Eliminar Equipo");
                mainFrame.setContentPane(form.deleteEquipmentPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
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
    public void showMaintenance(JFrame f, Mantenimiento maint){
        this.maintenanceMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(maint.maintPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showUsers( JFrame f, Usuario user){
        this.usersMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }

    private DefaultTableModel generateModel(Boolean isShort){
        String[] header = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
        String[] header_completo = controller.cols_equipos;
        Object[][] data = controller.showEquipo();
        String[] headers = isShort ? header : header_completo;
        DefaultTableModel model = new DefaultTableModel(data, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        return model;
    }





}
