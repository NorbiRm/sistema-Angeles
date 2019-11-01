import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JButton showInventoryButton;
    public JPanel homePanel;
    private JButton showUsersButton;
    private JButton showMaintenanceButton;
    private JButton showCalendarButton;
    private JPanel buttonsPanel;
    private JPanel imagePanel;
    private JButton showIndicatorButton;
    private JLabel imgLabel;
    private Controller controller;


    public Inicio(Controller controller) {
        this.controller = controller;
    }

    public void showCalendar(JFrame f, Calendario cal){
        this.showCalendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(cal.calendarPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showInventory( JFrame f, Inventario inv){
        this.showInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(inv.invPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showMaintenance( JFrame f, Mantenimiento maint){
        this.showMaintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(maint.maintPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showUsers( JFrame f, Usuario user){
        this.showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showIndicators(JFrame f, Indicador ind){
        showIndicatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(ind.mainPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }


}
