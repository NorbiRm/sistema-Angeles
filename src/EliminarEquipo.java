import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminarEquipo {
    //Root Panel
    public JPanel deleteEquipmentPanel;
    // Labels
    private JLabel serialNumber;
    private JLabel labelArea;
    private JPanel titlePanel;
    private JLabel registerTextEquipment;
    private JLabel equipment;
    private JLabel controlNumber;
    private JLabel model;
    private JLabel brand;
    // Fields
    private JTextField textEquipment;
    private JTextField textBrand;
    private JTextField textArea;
    private JTextField textSerialNumber;
    private JButton deleteSearchButton;
    private JTextField textModel;
    private JTextField textControlNumber;
    private JButton submitDeleteButton;
    private JLabel providerLabel;
    private JTextField textProvider;
    private JLabel errorLabel;

    private Controller controller;

    public EliminarEquipo(Controller controller){
        this.controller = controller;
        deleteSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String controlNumberSearch = textControlNumber.getText();
                ArrayList<Equipo> equipos = new ArrayList<>();
                equipos = controller.system.equipos;
                for(int i = 0; i < equipos.size(); i++){
                    if(equipos.get(i).num_control.equals(controlNumberSearch)){
                        textEquipment.setText(equipos.get(i).equipo);
                        textBrand.setText(equipos.get(i).marca);
                        textModel.setText(equipos.get(i).modelo);
                        textSerialNumber.setText(equipos.get(i).num_serie);
                        textArea.setText(equipos.get(i).area);
                        textProvider.setText(equipos.get(i).proveedor_compra);
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
