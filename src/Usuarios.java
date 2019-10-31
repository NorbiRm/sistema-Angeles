public class Usuarios {
    public String nombre;
    public String puesto;
    public String genero;
    public String fecha_registro; //Checar si Date

    public Usuarios(Object[] atts){
        this.nombre = (String)atts[0];
        this.puesto = (String)atts[1];
        this.genero = (String)atts[2];
        this.fecha_registro = (String)atts[3];
    }
    public Usuarios(String nombre, String puesto, String genero, String fecha_registro) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.genero = genero;
        this.fecha_registro = fecha_registro;
    }

    public Object[] getAsRow(){
        Object[] usuario = new Object[4];
        usuario[0] = this.nombre;
        usuario[1] = this.puesto;
        usuario[2] = this.genero;
        usuario[3] = this.fecha_registro;

        return usuario;
    }
}
