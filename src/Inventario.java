import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario {
    private JButton deleteEquipment;
    private JTable inventarioTable;
    private JPanel titlePanel;
    private JButton addEquipment;
    public JPanel invPanel;
    private JButton viewTable;
    private JButton updateEquipment;
    private JButton printTable;
    private JTextField searchField;
    private JButton buscarButton;
    private JComboBox filterColumn;
    private JButton inicioButton;
    private JButton mantenimientoButton;
    private JButton calendarioButton;
    private JButton usuariosButton;
    private JPanel actionsPanel;

    public Inventario() {
        String header[] = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
        String data[][] = {
                {"100","Vinod","programmer","5000"},
                {"101","Deepak","Content Writer","20000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"104","Rinku","PHP programar","25000"}
        };
        DefaultTableModel model = new DefaultTableModel(data, header);
        inventarioTable.setModel(model);
        Color backColor = new Color(47,84,150);
        inventarioTable.getTableHeader().setBackground(backColor);
        inventarioTable.getTableHeader().setForeground(Color.white);
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
    public void showUsers( JFrame f, Usuario user){
        this.usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }


}
