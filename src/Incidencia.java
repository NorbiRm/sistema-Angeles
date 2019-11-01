import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Incidencia {
    //Root Panel
    public JPanel mainPanel;
    public JPanel incidentPanel;
    // Labels
    private JLabel tittleIncident;
    private JLabel labelProtection;
    private JLabel labelDangerousMaterials;
    private JLabel labelEmergency;
    private JLabel labelSecurity;
    private JLabel labelKeySystemms;
    private JLabel labelAccident;
    private JLabel labelDevices;
    private JLabel labelEmployee;
    private JLabel labelPatient;
    private JLabel labelPhysician;
    private JLabel labelProcess;
    private JLabel labelInvolvedEmployees;
    private JLabel labelNames;
    private JLabel labelJob;
    private JLabel labelAntiguedad;
    private JLabel labelIncidentDate;
    private JLabel labelInvolvedService;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel titleInvolved;
    private JLabel titleDescription;
    private JLabel labelSituation;
    private JLabel labelBackground;
    private JLabel labelActions;
    private JLabel labelRecommendations;
    private JLabel registerTextEquipment;
    private JPanel titlePanel;
    private JLabel tittleTypeIncident;
    private JLabel labelOthers;
    private JTextField textOthers;
    // User Input
    private JCheckBox checkPhysician;
    private JCheckBox checkPatient;
    private JCheckBox checkEmployee;
    private JCheckBox chechOthers;
    private JCheckBox checkProcess;
    private JCheckBox checkFailure;
    private JCheckBox checkAdversEvent;
    private JCheckBox checkCentinel;
    private JTextPane paneCentinel;
    private JTextPane paneAdversEvent;
    private JTextPane paneFailure;
    private JTextField textDateIncident;
    private JTextField textInvolvedService;
    private JTextPane textPaneSituation;
    private JTextPane textPaneBackground;
    private JTextPane textPaneActions;
    private JTextPane textPaneRecommendations;
    private JButton saveButton;
    private JCheckBox checkProtection;
    private JCheckBox checkEmergency;
    private JCheckBox checkDangerousMaterials;
    private JCheckBox checkDevices;
    private JCheckBox checkAccident;
    private JCheckBox checkSecurity;
    private JCheckBox checkKeySystem;
    private JButton imprimirButton;



    public Incidencia(){
        Color backColor = new Color(47,84,150);
        this.paneAdversEvent.setBorder(new LineBorder(backColor));
        this.paneFailure.setBorder(new LineBorder(backColor));
        this.paneCentinel.setBorder(new LineBorder(backColor));
        this.textPaneActions.setBorder(new LineBorder(backColor));
        this.textPaneBackground.setBorder(new LineBorder(backColor));
        this.textPaneSituation.setBorder(new LineBorder(backColor));
        this.textPaneRecommendations.setBorder(new LineBorder(backColor));
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
                        g2.scale(0.495,0.55);

                        incidentPanel.paint(g2);
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
        // TODO: place custom component creation code here
    }
}
