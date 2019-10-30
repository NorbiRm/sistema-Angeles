public class Usuarios {
    public String clave;
    public String nombre;
    public String genero;
    public String fecha_registro; //Checar si Date

    public Usuarios(Object[] atts){
        this.clave = (String)atts[0];
        this.nombre = (String)atts[1];
        this.genero = (String)atts[2];
        this.fecha_registro = (String)atts[3];
    }
    public Usuarios(String clave, String nombre, String genero, String fecha_registro) {
        this.clave = clave;
        this.nombre = nombre;
        this.genero = genero;
        this.fecha_registro = fecha_registro;
    }
}
