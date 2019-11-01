import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Indicador {
    public JPanel subPanel;
    private JPanel titlePanel;
    private JLabel registerTextEquipment;
    private JLabel availableEquipment;
    private JLabel labelNumberofBreakdowns;
    private JLabel labelAreasTitle;
    private JTextField textNumberofServices;
    private JTextField textFirst;
    private JTextField textSecond;
    private JProgressBar progressAvailableEquipment;
    private JProgressBar progressBarFirst;
    private JProgressBar progressBarSecond;
    private JProgressBar progressBarThird;
    private JLabel labelPreventive;
    private JLabel labelCorrective;
    private JTextField textNumberPreventive;
    private JTextField textNumberCorrective;
    private JProgressBar preventiveVsCorrective;
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
    private JButton recalcularIndicadoresButton;
    public JPanel mainPanel;
    private JTextField textNumberOfBreakdowns;

    private Controller controller;

    public Indicador(Controller controller){
        this.controller = controller;
        loadIndicators();

        recalcularIndicadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadIndicators();
            }
        });
    }
    private void loadIndicators(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos = controller.system.equipos;
        int totalEquipments = equipos.size();
        int operationalCounter = 0;
        for(int i = 0; i < totalEquipments; i++){
            if(equipos.get(i).estado.equals("Operativo")){
                operationalCounter++;
            }
        }
        int percentage = (operationalCounter*100)/totalEquipments;
        progressAvailableEquipment.setValue(percentage);
        progressAvailableEquipment.setString(Integer.toString(percentage) + "%");

        ArrayList<Servicio> servicios = new ArrayList<>();
        servicios = controller.system.mantenimientos;
        int totalServices = servicios.size();
        int preventiveCounter = 0;
        textNumberofServices.setText(Integer.toString(totalServices));

        for(int i = 0; i < totalServices; i++){
            if(servicios.get(i).trabajo_realizado.equals("Mantto. Preventivo")){
                preventiveCounter++;
            }
        }
        int correctiveCounter = totalServices - preventiveCounter;
        Color c = preventiveCounter > correctiveCounter ? Color.red : Color.BLUE;
        Color c2 = preventiveCounter < correctiveCounter ? Color.red : Color.BLUE;
        textNumberPreventive.setText(Integer.toString(preventiveCounter));
        int valuePvC = preventiveCounter < correctiveCounter ? correctiveCounter : preventiveCounter;
        int percentageServices = (valuePvC*100)/totalServices;
        preventiveVsCorrective.setValue(percentageServices);
        preventiveVsCorrective.setString(percentageServices + "%");
        textNumberPreventive.setForeground(c);
        textNumberCorrective.setText(Integer.toString(correctiveCounter));
        textNumberCorrective.setForeground(c2);
        textNumberOfBreakdowns.setText(Integer.toString(correctiveCounter));
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
