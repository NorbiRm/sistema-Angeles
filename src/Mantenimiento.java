import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mantenimiento {
    // Root Panel
    public JPanel maintPanel;
    // Data Table
    public JTable maintTable;
    // Menu Buttons
    private JPanel menuPanel;
    private JButton homeButton;
    private JButton inventoryButton;
    private JButton calendarButton;
    private JButton usersButton;
    private JButton generateOrder;
    private JButton incidentReport;
    private JButton viewFullTable;
    private JPanel titlePanel;
    private JButton indicatorMenuButton;

    private Controller controller;


    public Mantenimiento(Controller controller) {
        this.controller = controller;
        Mantenimiento self = this;
        maintTable.setModel(generateModel(true));
        Color backColor = new Color(47,84,150);
        maintTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        maintTable.getTableHeader().setReorderingAllowed(false);
        maintTable.getTableHeader().setBackground(backColor);
        maintTable.getTableHeader().setForeground(Color.white);

        viewFullTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewFullTable.getText().compareTo("Ver Tabla Completa") == 0){
                    maintTable.setModel(generateModel(false));
                    viewFullTable.setText("Ver Tabla Reducida");
                }else{
                    maintTable.setModel(generateModel(true));
                    viewFullTable.setText("Ver Tabla Completa");
                }
            }
        });

        generateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenServicio form = new OrdenServicio(controller);
                form.setInterfaz_mantto(self);
                JFrame mainFrame = new JFrame("Nueva Orden de Servicio");
                mainFrame.setContentPane(form.mainPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(1280, 900);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
        incidentReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Incidencia form = new Incidencia();
                JFrame mainFrame = new JFrame("Nuevo Registro de Incidente");
                mainFrame.setContentPane(form.mainPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(1280, 700);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
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
    public void showCalendar(JFrame f, Calendario cal){
        this.calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(cal.calendarPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showUsers( JFrame f, Usuario user){
        this.usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    public void showIndicators(JFrame f, Indicador ind){
        this.indicatorMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(ind.mainPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }

    public DefaultTableModel generateModel(Boolean isShort){
        String header[] = {"Folio","Número Control", "Número Serie", "Equipo", "Marca", "Modelo","Fecha Solicitud", "Fecha Terminación", "Área", "Falla", "Trabajo Realizado", "Partes Nuevas", "Costo Refacciones", "Costo Servicio Externo", "Costo Total"};
        String header_completo[] = controller.cols_servicios;
        Object[][] data = controller.showServicios();
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
