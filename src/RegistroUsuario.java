import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public RegistroUsuario(Controller controller){
        this.saveUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Date dateRepresentation = cal.getTime();
                String userName = userNameText.getText();
                String userDate = registerDateText.getText();
                String[] dateData = userDate.split("/", 3);
                Object userTypeObj = userTypeSelect.getSelectedItem();
                String userType = userTypeObj.toString();
                Object userGenderObj = userTypeSelect.getSelectedItem();
                /*
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, Integer.parseInt(dateData[0]));
                cal.set(Calendar.MONTH, Calendar.JANUARY);
                cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateData[2]) );
                Date userD = new Date(), Integer.parseInt(dateData[1]), );
                */
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
                    System.out.println(registerDateText.getText());
                    registerUserPanel.revalidate();
                    registerUserPanel.repaint();
                }

            }
        });
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        format.setLenient(false);
        registerDateText = new JFormattedTextField(format);
        registerDateText.setColumns(10);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
}









