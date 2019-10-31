import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Calendario {
    private JComboBox comboBoxMonths;
    private JTable tableCalendar;
    private JButton reagendarServicioButton;
    private JButton generarOrdenDeServicioButton;
    private JLabel titleCalendar;
    private JLabel labelLogo;

    public JPanel calendarPanel;
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
