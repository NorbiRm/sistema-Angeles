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
    private Usuario interfaz_usuario;
    private int index_user;

    public EditarUsuario( Controller controller ){
        this.controller = controller;
        this.index_user = -1;

        registerDateLabel.setText("<html><body>Fecha de Registro<br>Formato Dia/Mes/Año</body></html>");

        comboBoxUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedUserObj = comboBoxUser.getSelectedItem();
                String selectedUser = selectedUserObj.toString();
                for(int i = 0; i < controller.system.usuarios.size(); i++){
                    if(controller.system.usuarios.get(i).nombre.equals(selectedUser)){
                        index_user = i;
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
        saveUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index_user != -1){
                    String nombre = userNameText.getText();
                    String puesto = (String)userTypeSelect.getSelectedItem();
                    String genero = (String)userGenderSelect.getSelectedItem();
                    String fecha = registerDateText.getText();
                    // PARSEAR FECHA
                    Object[] new_data = {nombre, puesto, genero, fecha};
                    controller.system.modifyUsuario(index_user, new_data);
                    interfaz_usuario.userTable.setModel(controller.generateModel(controller.showUsuarios(), controller.cols_usuarios));
                    // CIERRA LA VENTNA
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(editUserPanel);
                    topFrame.dispose();
                }

            }
        });
    }

    public void setInterfaz_usuario(Usuario usuario){
        this.interfaz_usuario = usuario;
    }

    private void createUIComponents() {
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");;
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
