import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EliminarUsuario {

    private JPanel containerPanel;
    private JLabel labelUser;
    private JPanel titlePanel;
    private JLabel titleEliminateUser;
    private JComboBox comboBoxUser;
    private JButton deleteUserButton;
    //Root panel
    public JPanel deleteUserPanel;
    private JLabel errorLabel;
    private String[] userNames;
    private Controller controller;

    public EliminarUsuario( Controller controller){
        this.controller = controller;
        this.deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedUserObj = comboBoxUser.getSelectedItem();
                String selectedUser = selectedUserObj.toString();
                System.out.println("Selected user : " + selectedUser);
                for(int i = 0; i < controller.system.usuarios.size(); i++){
                    if(controller.system.usuarios.get(i).nombre.equals(selectedUser)){
                        System.out.println("Deleted user : " + controller.system.usuarios.get(i).nombre);
                        controller.system.usuarios.remove(i);
                        comboBoxUser.removeItemAt(i);
                    }

                }

                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(deleteUserPanel);
                topFrame.dispose();
            }
        });
    }

    private void createUIComponents() {
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
