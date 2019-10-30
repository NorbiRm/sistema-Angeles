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


    public Inventario(Controller controller) {
        String header[] = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
        String data[][] = {
                {"100","Vinod","programmer","5000"},
                {"101","Deepak","Content Writer","20000"},
                {"101","Deepak","Content Writer","20000"},
                {"101","Deepak","Content Writer","20000"},
                {"101","Deepak","Content Writer","20000"},
                {"101","Deepak","Content Writer","20000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"104","Rinku","PHP programar","25000"}
        };
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        inventoryTable.setModel(model);
        Color backColor = new Color(47,84,150);
        inventoryTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        inventoryTable.getTableHeader().setReorderingAllowed(false);
        inventoryTable.getTableHeader().setBackground(backColor);
        inventoryTable.getTableHeader().setForeground(Color.white);
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
    public void showUsers( JFrame f, Usuario user){
        this.usersMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void newEquipmentWindow(RegistroEquipo form){
        this.addEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = new JFrame("Registrar Nuevo Equipo");
                mainFrame.setContentPane(form.registerEquipmentPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });
    }


}
