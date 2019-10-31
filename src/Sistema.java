import java.util.ArrayList;

public class Sistema {
    public ArrayList<Equipo> equipos;
    public ArrayList<Servicio> mantenimientos;
    public ArrayList<Usuarios> usuarios;

    public Sistema(ArrayList<Equipo> equipos, ArrayList<Usuarios> usuarios, ArrayList<Servicio> mantenimientos) {
        this.equipos = equipos;
        this.mantenimientos = mantenimientos;
        this.usuarios = usuarios;
        atts();
    }

    public boolean addEquipo(Object[] row){
        Equipo nuevo_equipo = new Equipo(row);
        try{
            this.equipos.add(nuevo_equipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean addUsuario(Object[] row){
        Usuarios nuevo_usuario = new Usuarios(row);
        try{
            this.usuarios.add(nuevo_usuario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void modifyUsuario(int index, Object[] new_data){
        this.usuarios.remove(index);
        this.usuarios.add(index, new Usuarios(new_data));
    }

    public boolean addServicio(Object[] row){
        Servicio nuevo_servicio = new Servicio(row);
        try{
            this.mantenimientos.add(nuevo_servicio);
            return true;
        }catch(Exception e){
            return false;
        }
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
