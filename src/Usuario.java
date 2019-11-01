import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    //Root Panel
    public JPanel userPanel;
    // Data Table
    public JTable userTable;
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
    private JButton deleteUser;
    private JFormattedTextField searchUserField;
    private JButton refrescarTablaButton;
    private JButton indicatorMenuButton;

    //public DefaultTableModel model;

    private Controller controller;

    public Usuario(Controller controller){
        this.controller = controller;
        Usuario self = this;
        userTable.setModel(generateModel());
        Color backColor = new Color(47,84,150);
        userTable.getTableHeader().setReorderingAllowed(false);
        userTable.getTableHeader().setBackground(backColor);
        userTable.getTableHeader().setForeground(Color.white);

        this.refrescarTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTable.setModel(generateModel());
            }
        });

        this.deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarUsuario form = new EliminarUsuario(controller);
                form.setInterfaz_usuario(self);
                JFrame mainFrame = new JFrame("Eliminar Usuario");
                mainFrame.setContentPane(form.deleteUserPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(800, 500);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
                mainFrame.revalidate();
            }
        });

        this.updateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarUsuario edit = new EditarUsuario(controller);
                edit.setInterfaz_usuario(self);
                JFrame mainFrame = new JFrame("Editar Usuario");
                mainFrame.setContentPane(edit.editUserPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(800, 500);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
                mainFrame.revalidate();
            }
        });

        this.addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroUsuario form = new RegistroUsuario(controller);
                form.setInterfaz_usuario(self);
                JFrame mainFrame = new JFrame("Registrar Nuevo Usuario");
                mainFrame.setContentPane(form.registerUserPanel);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setSize(900, 600);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            }
        });

        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lookup = searchUserField.getText();
                if(lookup!=null && controller.system.usuarioExiste(lookup)){
                    String[] header = {"Nombre", "Puesto", "Genero", "Fecha de Registro"};
                    Object[][] data = {controller.system.getUsuarioByName(lookup)};
                    DefaultTableModel model = new DefaultTableModel(data, header) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    userTable.setModel(model);
                }else{
                    userTable.setModel(generateModel());
                }
            }
        });
    }
    public void setTableModel(DefaultTableModel model){
        this.userTable.setModel(model);
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
    public void showIndicators(JFrame f, Indicador ind){
        indicatorMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(ind.mainPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }

    private DefaultTableModel generateModel(){
        String[] header = {"Nombre", "Puesto", "Genero", "Fecha de Registro"};
        Object[][] data = controller.showUsuarios();
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }


}
