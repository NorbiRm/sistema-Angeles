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
    private JButton inventarioButton;
    private JButton mantenimientoButton;
    private JButton calendarioButton;
    private JButton usuariosButton;

    public Inventario() {
        String header[] = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
        String data[][] = {
                {"  ","Vinod","programmer","5000"},
                {"101","Deepak","Content Writer","20000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"},
                {"104","Rinku","PHP programar","25000"}
        };
        DefaultTableModel model = new DefaultTableModel(data, header);
        inventarioTable.setModel(model);
        Color backColor = new Color(47,84,150);
        inventarioTable.getTableHeader().setBackground(backColor);
        inventarioTable.getTableHeader().setForeground(Color.white);
    }


}
