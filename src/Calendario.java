import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;

public class Calendario {
    private JComboBox comboBoxMonths;
    private JTable tableCalendar;
    private JLabel titleCalendar;
    private JLabel labelLogo;

    public JPanel calendarPanel;
    private JPanel menuPanel;
    private JButton homeMenuButton;
    private JButton maintenanceMenuButton;
    private JButton inventoryMenuButton;
    private JButton usersMenuButton;
    private JButton indicatorMenuButton;
    private JComboBox comboBox1;
    private Controller controller;

    public int num_month;
    public int num_year;

    public Calendario( Controller controller){
        this.controller = controller;
        this.num_month = 1;
        this.comboBoxMonths.setSelectedIndex(this.num_month-1);
        num_year = Calendar.getInstance().get(Calendar.YEAR);
        this.comboBox1.setSelectedIndex(num_year-2000);
        //tableCalendar.setModel(generateModel(true));
        tableCalendar.setModel(generateModel());
        Color backColor = new Color(47,84,150);
        tableCalendar.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tableCalendar.getTableHeader().setReorderingAllowed(false);
        tableCalendar.getTableHeader().setBackground(backColor);
        tableCalendar.getTableHeader().setForeground(Color.white);
        tableCalendar.getColumnModel().getColumn(0).setMinWidth(110);
        tableCalendar.getColumnModel().getColumn(0).setPreferredWidth(110);
        tableCalendar.getColumnModel().getColumn(1).setMinWidth(200);
        tableCalendar.getColumnModel().getColumn(1).setPreferredWidth(200);
        comboBoxMonths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum_month(comboBoxMonths.getSelectedItem().toString());
                System.out.println(num_month);
                tableCalendar.setModel(generateModel());
                tableCalendar.getColumnModel().getColumn(0).setMinWidth(110);
                tableCalendar.getColumnModel().getColumn(0).setPreferredWidth(110);
                tableCalendar.getColumnModel().getColumn(1).setMinWidth(200);
                tableCalendar.getColumnModel().getColumn(1).setPreferredWidth(200);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum_month(comboBoxMonths.getSelectedItem().toString());
                tableCalendar.setModel(generateModel());
                tableCalendar.getColumnModel().getColumn(0).setMinWidth(110);
                tableCalendar.getColumnModel().getColumn(0).setPreferredWidth(110);
                tableCalendar.getColumnModel().getColumn(1).setMinWidth(200);
                tableCalendar.getColumnModel().getColumn(1).setPreferredWidth(200);
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


    private DefaultTableModel generateModel(){
        String[] header_incom = {"Num_Control", "Equipo"};
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //int month = Calendar.getInstance().get(Calendar.MONTH);
        YearMonth yearMonthObject = YearMonth.of(year, this.num_month);
        int num_days = yearMonthObject.lengthOfMonth();
        System.out.println("NUM DAYS %s".format(String.valueOf(num_days)));
        String[] day_num = new String[num_days];
        for(int i=0; i<num_days; i++){
            day_num[i] = String.valueOf(i+1);
        }
        Object[] concat = controller.concatArrays(header_incom, day_num);
        String[] header = Arrays.copyOf(concat, concat.length, String[].class);
        Object[][] data;
        int year_filter = year;
        try{
            year_filter = Integer.parseInt(comboBox1.getSelectedItem().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        //Object[][] data;
        data = this.controller.system.getEquiposMantoByMonth(this.num_month, year_filter);

        //String[] headers = isShort ? header : header_completo;
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        return model;
    }

    public void setNum_month(String month){
        System.out.println("MES");
        System.out.println(month);
        int actual_month = this.num_month;
        Object[][] months = {
                {"Enero", 1}, {"Febrero", 2}, {"Marzo", 3}, {"Abril", 4},
                {"Mayo", 5}, {"Junio", 6}, {"Julio", 7}, {"Agosto", 8},
                {"Septiembre", 9}, {"Octubre", 10}, {"Noviembre", 11},
                {"Diciembre", 12}
        };
        for(Object[] m: months){
            if(month.replace(" ", "").equals(m[0])){
                System.out.println("ENCONTRO");
                System.out.println((int)m[1]);
                this.num_month = (int)m[1];
            }
        }
    }
}
