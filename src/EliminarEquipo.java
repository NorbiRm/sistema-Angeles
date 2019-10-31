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
    private Inventario interfaz_inv;
    private int index_equipo;

    public EliminarEquipo(Controller controller){
        this.controller = controller;
        this.index_equipo = -1;
        deleteSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String controlNumberSearch = textControlNumber.getText();
                ArrayList<Equipo> equipos = new ArrayList<>();
                equipos = controller.system.equipos;
                for(int i = 0; i < equipos.size(); i++){
                    if(equipos.get(i).num_control.equals(controlNumberSearch)){
                        index_equipo = i;
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

        submitDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] header = {"Numero Control", "Equipo", "Marca", "Modelo", "Numero de Serie", "Area", "Proveedor de Compra"};
                //String selected = textControlNumber.getText().toString();
                if(index_equipo != -1){
                    System.out.println("Deleted user : " + controller.system.equipos.get(index_equipo).num_control);
                    controller.system.equipos.remove(index_equipo);
                    interfaz_inv.inventoryTable.setModel(controller.generateModel(controller.showEquipo(), header));
                    index_equipo = -1;
                }
                // CERRAR VENTANA
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(deleteEquipmentPanel);
                topFrame.dispose();
            }
        });
    }
    public void setinterfaz_inv(Inventario inventario){
        this.interfaz_inv = inventario;
    }


}
