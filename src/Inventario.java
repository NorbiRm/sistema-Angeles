import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Inventario {

    // Root Panel
    public JPanel invPanel;
    // Data Table
    public JTable inventoryTable;
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
    private JButton indicatorMenuButton;
    private JPanel tableRoot;

    private Controller controller;


    public Inventario(Controller controller) {
        this.controller = controller;
        Inventario self = this;
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
                form.setinterfaz_inv(self);
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
                form.setinterfaz_inv(self);
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
                form.setinterfaz_inv(self);
                JFrame mainFrame = new JFrame("Eliminar Equipo");
                mainFrame.setContentPane(form.deleteEquipmentPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter_field = searchEquipmentTextField.getText();
                String filter = filterColumn.getSelectedItem().toString();
                if(filter_field!=null && !filter_field.equals("")){
                    String[] header = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
                    Object[][] data = controller.system.getEquipoByFilter(filter,filter_field);
                    DefaultTableModel model = new DefaultTableModel(data, header) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    inventoryTable.setModel(model);
                }
            }
        });
        printTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Imprimir Orden Servicio");
                job.setPrintable(new Printable(){
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.PORTRAIT);
                        if(pageNum>0){
                            return Printable.NO_SUCH_PAGE;
                        }
                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.35,0.4);

                        inventoryTable.paint(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });
                boolean ok = job.printDialog();
                if(ok){
                    try{

                        job.print();
                    }
                    catch (PrinterException ex){}
                }
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
    public void showCalendar(JFrame f, Calendario cal){
        this.calendarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(cal.calendarPanel);
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
    public void showIndicators(JFrame f, Indicador ind){
        this.indicatorMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(ind.subPanel);
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
