import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JEditorPane accessoriesText;
    private JTextField textProvider;
    private JLabel errorLabel;
    private Controller controller;

    public RegistroEquipo(Controller controller){
        this.controller = controller;
        Color backColor = new Color(47,84,150);
        this.accessoriesText.setBorder(new LineBorder(backColor));


        saveEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipmentControlN = textControlNumber.getText();
                String equipmentName = textEquipment.getText();
                String equipmentBrand = textBrand.getText();
                String equipmentModel = textModel.getText();
                String equipmentSerialNumber = textSerialNumber.getText();
                String equipmentArea = (String) comboBoxArea.getSelectedItem();
                String equipmentProviderB = textProvider.getText();
                String equipmentAccessories = accessoriesText.getText();
                String equipmentAssetNum = textFixAsset.getText();
                String equipmentLocation = (String) comboBoxLocation.getSelectedItem();
                String equipmentMaintenance = (String) comboBoxMaintenanceFrequency.getSelectedItem();
                String equipmentDate = textInstallationDate.getText();
                String equipmentState = (String) comboBoxStatus.getSelectedItem();
                String equipmentServiceProvider = textServiceProvider.getText();
                String equipmentContact = textContact.getText();
                String equipmentTelephone = textTelephone.getText();
                String equipmentReplacementParts = textReplacementParts.getText();

                if(equipmentControlN.equals("") || equipmentName.equals("") || equipmentBrand.equals("") || equipmentModel.equals("") || equipmentSerialNumber.equals("") || equipmentArea.equals("") || equipmentProviderB.equals("") || equipmentAccessories.equals("") || equipmentAssetNum.equals("") || equipmentLocation.equals("") || equipmentMaintenance.equals("") || equipmentDate.equals("") || equipmentState.equals("") || equipmentServiceProvider.equals("") || equipmentContact.equals("") || equipmentTelephone.equals("") || equipmentReplacementParts.equals("")){
                    errorLabel.setText("Llene todos los campos");
                }
                else{
                    errorLabel.setText("");
                    // CREAR NUEVO EQUIPO

                    // CIERRA LA VENTNA
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(registerEquipmentPanel);
                    topFrame.dispose();
                }

            }
        });
    }
}
