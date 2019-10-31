import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EditarUsuario {
    private JPanel childPanel;
    private JLabel userTypeLabel;
    private JLabel userGenderLabel;
    private JLabel nameLabel;
    private JLabel registerDateLabel;
    private JLabel labelSelectUser;
    private JPanel titlePanel;
    // Fields
    private JButton saveUserButton;
    private JComboBox userTypeSelect;
    private JComboBox userGenderSelect;
    private JFormattedTextField registerDateText;
    private JTextField userNameText;
    private JComboBox comboBoxUser;
    //Root
    public JPanel editUserPanel;

    private Controller controller;
    private String[] userNames;

    public EditarUsuario( Controller controller ){
        this.controller = controller;

        registerDateLabel.setText("<html><body>Fecha de Registro<br>Formato Dia/Mes/Año</body></html>");

        comboBoxUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedUserObj = comboBoxUser.getSelectedItem();
                String selectedUser = selectedUserObj.toString();
                for(int i = 0; i < controller.system.usuarios.size(); i++){
                    if(controller.system.usuarios.get(i).nombre.equals(selectedUser)){
                        userNameText.setText(controller.system.usuarios.get(i).nombre);
                        registerDateText.setText(controller.system.usuarios.get(i).fecha_registro);
                        int valT = (controller.system.usuarios.get(i).puesto.equals("Pasante")) ? 0 : 1;
                        userTypeSelect.setSelectedIndex(valT);
                        int valG = (controller.system.usuarios.get(i).genero.equals("Masculino")) ? 0 : 1;
                        userGenderSelect.setSelectedIndex(valG);
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        format.setLenient(false);
        registerDateText = new JFormattedTextField(format);
        registerDateText.setColumns(10);

        ArrayList<Usuarios> users = new ArrayList<>();
        users = controller.system.usuarios;
        this.userNames = new String[users.size()];
        for(int i = 0; i < userNames.length; i++){
            this.userNames[i] = users.get(i).nombre;
        }
        comboBoxUser = new JComboBox(userNames);

    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }
}
