import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RegistroUsuario {
    // Root Panel
    public JPanel registerUserPanel;
    private JComboBox userGenderSelect;
    private JFormattedTextField registerDateText;
    private JButton saveUserButton;
    private JTextField userNameText;
    private JComboBox userTypeSelect;
    // Labels
    private JLabel registerDateLabel;
    private JLabel userTypeLabel;
    private JLabel userGenderLabel;
    private JLabel nameLabel;
    private JPanel titlePanel;
    private JLabel dateErrorLabel;
    private JLabel errorLabel;

    private Controller controller;

    public RegistroUsuario(Controller controller){
        this.controller = controller;
            registerDateLabel.setText("<html><body>Fecha de Registro<br>Formato Dia/Mes/Año</body></html>");
        this.saveUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Date dateRepresentation = cal.getTime();
                String userName = userNameText.getText();
                String userDate = registerDateText.getText();
                String[] dateData = userDate.split("/", 3);
                Object userTypeObj = userTypeSelect.getSelectedItem();
                String userType = userTypeObj.toString();
                Object userGenderObj = userGenderSelect.getSelectedItem();
                String userGender = userGenderObj.toString();
                if(userType.equals("") || userName.equals("") || userGender.equals("")){
                    errorLabel.setText("Llene todos los campos");
                }
                else if(userDate.equals("")){
                    errorLabel.setText("");
                    dateErrorLabel.setText("Ingrese una fecha en formato dd/mm/aaaa");
                }
                else{
                    errorLabel.setText("");
                    dateErrorLabel.setText("");
                    userNameText.setText("");
                    String[] datos_usuario = {userName, userType, userGender, userDate};
                    controller.system.addUsuario(datos_usuario);
                    // CIERRA LA VENTNA
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(registerUserPanel);
                    topFrame.dispose();
                }
            }
        });
    }
    private void createUIComponents() {
        registerDateLabel = new JLabel("Text");
        registerDateLabel.setForeground(Color.red);
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        format.setLenient(false);
        registerDateText = new JFormattedTextField(format);
        registerDateText.setColumns(10);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
}









