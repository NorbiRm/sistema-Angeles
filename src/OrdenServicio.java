
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

public class OrdenServicio {
    // Root panel
    public JPanel mainPanel;
    public JPanel serviceOrderPanel;

    private JLabel serialNumber;
    private JLabel labelArea;
    private JTextField textDepartment;
    private JTextField textReporter;
    private JTextField textReportedFailure;
    private JTextField textField9;
    private JCheckBox checkEquipment;
    private JCheckBox checkTechnique;
    private JCheckBox checkOperation;
    private JCheckBox checkPreventive;
    private JCheckBox checkCorrective;
    private JCheckBox checkAssistance;
    private JCheckBox checkService;
    private JTextField textObservations;
    private JEditorPane editorNewParts;
    private JFormattedTextField formattedHours;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JFormattedTextField formattedTextField5;
    private JFormattedTextField formattedTextField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel labelSolicitude;
    private JLabel labelSolicitudeDate;
    private JFormattedTextField formattedSolicitude;
    private JFormattedTextField formattedControlNumber;
    private JFormattedTextField formattedDateStart;
    private JFormattedTextField formattedDateFinish;
    private JLabel labelEndDate;
    private JLabel titlelDepartment;
    private JLabel labelDapartment;
    private JLabel labelReportedFailure;
    private JLabel labelReporter;
    private JLabel s1;
    private JLabel s2;
    private JLabel labelReciever;
    private JLabel labelAssigned;
    private JLabel labelRealizedWork;
    private JLabel s3;
    private JLabel tittleFailure;
    private JLabel labelEquipment;
    private JLabel labelTecnique;
    private JLabel labelOperation;
    private JLabel s4;
    private JLabel labelPreventive;
    private JLabel tittleRealizedWork;
    private JLabel labelExternalService;
    private JLabel labelServiceAssistance;
    private JLabel labelCorrective;
    private JLabel labelNewParts;
    private JLabel labelObservations;
    private JLabel tittleCost;
    private JLabel labelCostParts;
    private JLabel labelHours;
    private JLabel labelTotal;
    private JLabel labelExternalCost;
    private JLabel labelCostEngineerperHour;
    private JEditorPane costPartsEdit;
    private JLabel brand;
    private JPanel titlePanel;
    private JTextField textBrand;
    private JButton saveButton;
    private JTextField textSerialNumber;
    private JLabel controlNumber;
    private JLabel equipment;
    private JTextField textEquipment;
    private JLabel model;
    private JTextField textModel;
    private JComboBox comboBoxArea;
    private JLabel labelRecievedby;
    private JLabel labelObservations2;
    private JLabel labelDate;
    private JLabel registerTextEquipment;
    private JButton buscarButton;


    private JComboBox comboBoxReceives;
    private JComboBox comboBoxAsigned;
    private JLabel errorLabel;
    private JButton imprimirButton;



    private Controller controller;
    private String[] userNames;

    public OrdenServicio(Controller controller){
        this.controller = controller;
        serviceOrderPanel.setPreferredSize(new Dimension(1000,1200));

        Color backColor = new Color(47,84,150);
        this.editorNewParts.setBorder(new LineBorder(backColor));
        this.costPartsEdit.setBorder(new LineBorder(backColor));

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String controlNumberSearch = formattedControlNumber.getText();
                ArrayList<Equipo> equipos = new ArrayList<>();
                equipos = controller.system.equipos;
                System.out.println("Busca: " + controlNumberSearch);
                for(int i = 0; i < equipos.size(); i++){
                    if(equipos.get(i).num_control.equals(controlNumberSearch)){
                        textEquipment.setText(equipos.get(i).equipo);
                        textBrand.setText(equipos.get(i).marca);
                        textModel.setText(equipos.get(i).modelo);
                        textSerialNumber.setText(equipos.get(i).num_serie);
                        String area = equipos.get(i).area;
                        for(int contArea = 0; contArea < 25; contArea++){
                            if(comboBoxArea.getItemAt(contArea).equals(area)){
                                comboBoxArea.setSelectedIndex(contArea);
                            }
                        }
                        errorLabel.setText("");
                        break;

                    }
                    else if(!equipos.get(i).num_control.equals(controlNumberSearch)){
                        errorLabel.setText("Equipo no encontrado");
                    }
                    else{
                        errorLabel.setText("");
                    }
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //GUARDAR ORDEN DE SERVICIO
            }
        });
        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Imprimir Orden Servicio");
                job.setPrintable(new Printable(){
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.LANDSCAPE);
                        if(pageNum>0){
                            return Printable.NO_SUCH_PAGE;
                        }
                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.49,0.55);

                        serviceOrderPanel.paint(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });
                boolean ok = job.printDialog();
                if(ok){
                    try{

                        job.print();
                    }
                    catch (PrinterException ex){}
                }
            }
        });
    }


    private void createUIComponents() {
        ArrayList<Usuarios> users = new ArrayList<>();
        users = controller.system.usuarios;
        this.userNames = new String[users.size()];
        for(int i = 0; i < userNames.length; i++){
            this.userNames[i] = users.get(i).nombre;
        }
        comboBoxAsigned = new JComboBox(userNames);
        comboBoxReceives = new JComboBox(userNames);
    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }
}