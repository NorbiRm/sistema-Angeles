import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RegistroEquipo {
    //Root Panel
    public JPanel registerEquipmentPanel;
    //Labels
    private JLabel serialNumber;
    private JLabel labelArea;
    private JLabel labelProvedor;
    private JLabel labelAccesories;
    private JLabel labelReplacementParts;
    private JLabel labelTelephone;
    private JLabel labelContact;
    private JLabel labelServiceProvider;
    private JLabel labelStatus;
    private JLabel labelInstallationDate;
    private JLabel labelLocation;
    private JLabel labelFixAsset;
    private JLabel labelMaintenanceFrequency;
    private JLabel controlNumber;
    private JLabel equipment;
    private JLabel brand;
    private JLabel model;
    private JLabel registerTextEquipment;
    private JLabel logo;
    private JPanel titlePanel;
    // User Input
    private JComboBox comboBoxMaintenanceFrequency;
    private JButton saveEquipment;
    private JTextField textFixAsset;
    private JComboBox comboBoxLocation;
    private JTextField textInstallationDate;
    private JComboBox comboBoxStatus;
    private JTextField textContact;
    private JTextField textServiceProvider;
    private JTextField textTelephone;
    private JTextField textReplacementParts;
    private JComboBox comboBoxArea;
    private JTextField textSerialNumber;
    private JTextField textControlNumber;
    private JTextField textEquipment;
    private JTextField textBrand;
    private JTextField textModel;
    private JComboBox providerSelect;
    private JEditorPane accessoriesText;

    public RegistroEquipo(){
        Color backColor = new Color(47,84,150);
        this.accessoriesText.setBorder(new LineBorder(backColor));
    }
}
