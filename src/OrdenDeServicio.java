import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OrdenDeServicio {
    // Root Panel
    public JPanel serviceOrderPanel;
    // User Input
    private JTextField controlNumberText;
    private JFormattedTextField startDateText;
    private JFormattedTextField endDateText;
    private JComboBox departmentSelector;
    private JFormattedTextField userReportingText;
    private JEditorPane failureText;
    private JButton generateOrderButton;
    private JTextPane workDonetext;
    private JComboBox userInChargeSelect;
    // Labels
    private JPanel titlePanel;
    private JLabel registerTextEquipment;
    private JLabel logo;
    private JLabel controlNumberLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel departmentLabel;
    private JLabel userReportingLabel;
    private JLabel failureLabel;
    private JLabel userReceivesLabel;
    private JLabel userInChargeLabel;

    private Controller controller;

    public OrdenDeServicio(Controller controller){
        this.controller = controller;

        Color backColor = new Color(47,84,150);
        this.failureText.setBorder(new LineBorder(backColor));
        this.workDonetext.setBorder(new LineBorder(backColor));
    }


}
