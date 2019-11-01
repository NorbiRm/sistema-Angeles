import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calendario {
    private JComboBox comboBoxMonths;
    private JTable tableCalendar;
    private JButton reagendarServicioButton;
    private JButton generarOrdenDeServicioButton;
    private JLabel titleCalendar;
    private JLabel labelLogo;

    public JPanel calendarPanel;
    private JPanel menuPanel;
    private JButton homeMenuButton;
    private JButton maintenanceMenuButton;
    private JButton inventoryMenuButton;
    private JButton usersMenuButton;
    private JButton indicatorMenuButton;
    private Controller controller;

    public Calendario( Controller controller){
        this.controller = controller;

        tableCalendar.setModel(generateModel(true));
        Color backColor = new Color(47,84,150);
        tableCalendar.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tableCalendar.getTableHeader().setReorderingAllowed(false);
        tableCalendar.getTableHeader().setBackground(backColor);
        tableCalendar.getTableHeader().setForeground(Color.white);

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
                f.setContentPane(ind.mainPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private DefaultTableModel generateModel(Boolean isShort){
        String[] header = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
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
