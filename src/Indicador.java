import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Indicador {
    public JPanel subPanel;
    private JPanel titlePanel;
    private JLabel registerTextEquipment;
    private JLabel availableEquipment;
    private JLabel labelNumberofBreakdowns;
    private JLabel labelAreasTitle;
    private JLabel labelFirst;
    private JLabel labelSecond;
    private JTextField textNumberofBreakdowns;
    private JTextField textFirst;
    private JTextField textSecond;
    private JLabel labelThird;
    private JProgressBar progressAvailableEquipment;
    private JProgressBar progressBarFirst;
    private JProgressBar progressBarSecond;
    private JProgressBar progressBarThird;
    private JLabel labelPreventive;
    private JLabel labelCorrective;
    private JTextField textNumberPreventive;
    private JTextField textNumberCorrective;
    private JProgressBar preventiveVsCorrective;
    private JLabel labelFourth;
    private JLabel labelFifth;
    private JTextField textThird;
    private JTextField textFourth;
    private JTextField textFifth;
    private JProgressBar progressBarFourth;
    private JProgressBar progressBarFifith;
    private JButton homeMenuButton;
    private JButton inventoryMenuButton;
    private JButton maintenanceMenuButton;
    private JButton calendarMenuButton;
    private JPanel indicatorsPanel;
    private JButton userMenuButton;

    private Controller controller;

    public Indicador(Controller controller){
        this.controller = controller;
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
    public void showUsers(JFrame f, Usuario user){
        this.userMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }

}
