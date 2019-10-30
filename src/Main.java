import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String [] args){
        JFrame mainFrame = new JFrame("Sistema de Gestión de Equipo");
        Controller controller = new Controller();

        Inicio homeWindow = new Inicio(controller);
        Inventario inventoryWindow = new Inventario(controller);
        RegistroEquipo equipmentRegister = new RegistroEquipo(controller);
        Usuario userWindow = new Usuario(controller);
        RegistroUsuario userRegister = new RegistroUsuario(controller);
        Mantenimiento maintenanceWindow = new Mantenimiento(controller);
        OrdenDeServicio serviceOrder = new OrdenDeServicio(controller);

        mainFrame.setContentPane(homeWindow.homePanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        mainFrame.setMinimumSize(new Dimension(1000, 700));
        mainFrame.setVisible(true);
        // Home buttons
        homeWindow.showInventory(mainFrame, inventoryWindow);
        homeWindow.showUsers(mainFrame, userWindow);
        homeWindow.showMaintenance(mainFrame, maintenanceWindow);
        // Inventory menu buttons
        inventoryWindow.showHome(mainFrame, homeWindow);
        inventoryWindow.showUsers(mainFrame, userWindow);
        inventoryWindow.showMaintenance(mainFrame, maintenanceWindow);
        inventoryWindow.newEquipmentWindow(equipmentRegister);
        // Users menu buttons
        userWindow.showHome(mainFrame, homeWindow);
        userWindow.showInventory(mainFrame, inventoryWindow);
        userWindow.showMaintenance(mainFrame, maintenanceWindow);
        userWindow.newUserWindow(userRegister);
        // Maintenance menu buttons
        maintenanceWindow.showHome(mainFrame, homeWindow);
        maintenanceWindow.showInventory(mainFrame, inventoryWindow);
        maintenanceWindow.showUsers(mainFrame, userWindow);
        maintenanceWindow.newServiceOrderWindow(serviceOrder);





    }
}
