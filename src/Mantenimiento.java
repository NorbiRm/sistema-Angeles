import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mantenimiento {
    // Root Panel
    public JPanel maintPanel;
    // Data Table
    private JTable maintTable;
    // Menu Buttons
    private JPanel menuPanel;
    private JButton homeButton;
    private JButton inventoryButton;
    private JButton calendarButton;
    private JButton usersButton;
    // Maintenance Buttons
    private JButton searchButton;
    private JTextField searchMaintentanceTextField;
    private JComboBox filterColumn;
    private JButton generateOrder;
    private JButton exportHistory;
    private JButton incidentReport;
    private JButton viewFullTable;
    private JPanel titlePanel;

    private Controller controller;


    public Mantenimiento(Controller controller) {
        this.controller = controller;

        String header[] = {"Folio","Número Control", "Número Serie", "Equipo", "Marca", "Modelo","Fecha Solicitud", "Fecha Terminación", "Área", "Falla", "Trabajo Realizado", "Partes Nuevas", "Costo Refacciones", "Costo Servicio Externo", "Costo Total"};
        String header_completo[] = controller.cols_servicios;
        Object[][] data = controller.showServicios();
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        maintTable.setModel(model);
        Color backColor = new Color(47,84,150);
        maintTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        maintTable.getTableHeader().setReorderingAllowed(false);
        maintTable.getTableHeader().setBackground(backColor);
        maintTable.getTableHeader().setForeground(Color.white);
        viewFullTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewFullTable.getText().compareTo("Ver Tabla Completa") == 0){
                    maintTable.setModel(new DefaultTableModel(data, header_completo));
                    viewFullTable.setText("Ver Tabla Reducida");
                }else{
                    maintTable.setModel(new DefaultTableModel(data, header));
                    viewFullTable.setText("Ver Tabla Completa");
                }
            }
        });
    }

    public void showHome(JFrame f, Inicio home){
        this.homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(home.homePanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showUsers( JFrame f, Usuario user){
        this.usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showInventory(JFrame f, Inventario inv){
        this.inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(inv.invPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void newServiceOrderWindow(OrdenDeServicio form){
        this.generateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = new JFrame("Nueva Orden de Servicio");
                mainFrame.setContentPane(form.serviceOrderPanel);
                mainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
    }


}
