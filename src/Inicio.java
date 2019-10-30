import javax.swing.*;
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
    private Controller controller;


    public Inicio(Controller controller) {
        this.controller = controller;
    }

    public void showInventory( JFrame f, Inventario inv){
        this.showInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
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
                //f.remove(inicio.panel1);
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
}
