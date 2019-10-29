import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JButton invButton;
    public JPanel homePanel;
    private JButton usersButton;
    private JButton mantButton;
    private JButton calendarioButton;
    private JPanel buttonsPanel;
    private JPanel imagePanel;


    public Inicio() {

    }

    public void showInventory( JFrame f, Inventario inv){
        this.invButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
                f.setContentPane(inv.invPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
    public void showUsers( JFrame f, Usuario user){
        this.usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.remove(inicio.panel1);
                f.setContentPane(user.userPanel);
                f.revalidate();
                f.repaint();
            }
        });
    }
}
