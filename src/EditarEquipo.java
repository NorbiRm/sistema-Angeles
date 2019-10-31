import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditarEquipo {
    // Root Panel
    public JPanel editEquipmentPanel;
    // Fields
    private JButton searchButton;
    private JTextField textReplacementParts;
    private JTextField textTelephone;
    private JTextField textContact;
    private JTextField textServiceProvider;
    private JComboBox comboBoxStatus;
    private JTextField textInstallationDate;
    private JComboBox comboBoxLocation;
    private JTextField textFixAsset;
    private JComboBox comboBoxMaintenanceFrequency;
    private JTextField textControlNumber;
    private JTextField textEquipment;
    private JTextField textBrand;
    private JTextField textModel;
    private JTextField textSerialNumber;
    private JComboBox comboBoxArea;
    private JTextField textProvedor;
    private JTextField textAccesories;
    private JButton saveButton;
    // Labels
    private JPanel titlePanel;
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
    private JLabel model;
    private JLabel brand;
    private JLabel equipment;
    private JLabel controlNumber;
    private JLabel registerTextEquipment;
    private JLabel errorLabel;

    private Controller controller;

    public EditarEquipo(Controller controller){
        this.controller = controller;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String controlNumberSearch = textControlNumber.getText();
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
                        for(int contArea = 0; contArea < 24; contArea++){
                            if(comboBoxArea.getItemAt(contArea).equals(area)){
                                comboBoxArea.setSelectedIndex(contArea);
                            }
                        }
                        textProvedor.setText(equipos.get(i).proveedor_compra);
                        textFixAsset.setText(equipos.get(i).num_flujo);
                        int status = equipos.get(i).estado.equals("Operativo") ? 0 : 1;
                        comboBoxStatus.setSelectedIndex(status);
                        textInstallationDate.setText(equipos.get(i).fecha_instalacion);
                        textServiceProvider.setText(equipos.get(i).proveedor_serv);
                        textContact.setText(equipos.get(i).contacto);
                        textTelephone.setText(equipos.get(i).telefono);
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
    }
}
