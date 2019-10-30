import java.util.ArrayList;

public class Sistema {
    public ArrayList<Equipo> equipos;
    public ArrayList<Servicio> mantenimientos;
    public ArrayList<Usuarios> usuarios;
    public Controller controller;

    public Sistema(ArrayList<Equipo> equipos, ArrayList<Usuarios> usuarios, ArrayList<Servicio> mantenimientos) {
        this.equipos = equipos;
        this.mantenimientos = mantenimientos;
        this.usuarios = usuarios;
        atts();
    }

    public void atts(){
        System.out.println("//////////////////////////////////////");
        System.out.println("EQUIPOS/");
        System.out.println(this.equipos.toString());
        System.out.println("//////////////////////////////////////");
        System.out.println("USUARIOS");
        System.out.println(this.usuarios.toString());
        System.out.println("//////////////////////////////////////");
        System.out.println("MANTTOS");
        System.out.println(this.mantenimientos.toString());
        System.out.println("//////////////////////////////////////");

    }
}
