import java.util.ArrayList;

public class Equipo {
    public String num_control;
    public String equipo;
    public String marca;
    public String modelo;
    public String num_serie;
    public String area;
    public String proveedor_compra;
    public ArrayList<String> accesorios;
    public String num_flujo;
    public String ubicacion;
    public String fecha_instalacion; //VERIFICAR
    public String estado;
    public String proveedor_serv;
    public String contacto;
    public String telefono;
    public ArrayList<String> refacciones;
    public ArrayList<String> consumibles;
    public String frecuencia; //CHECAR
    public String prox_mantto;

    public Equipo(Object[] atts){
        this.num_control = (String) atts[0];
        this.equipo = (String) atts[1];
        this.marca = (String) atts[2];
        this.modelo = (String) atts[3];
        this.num_serie = (String) atts[4];
        this.area = (String) atts[5];
        this.proveedor_compra = (String) atts[6];
        this.accesorios = new ArrayList<>();
        this.num_flujo = (String) atts[8];
        this.ubicacion = (String) atts[9];
        this.fecha_instalacion = (String) atts[10];
        this.estado = (String) atts[11];
        this.proveedor_serv = (String) atts[12];
        this.contacto = (String) atts[13];
        this.telefono = (String) atts[14];
        this.refacciones = new ArrayList<>();
        this.consumibles = new ArrayList<>();
        this.frecuencia = (String) atts[17];
        this.prox_mantto = "";
    }

    public Equipo(String num_control, String equipo, String marca, String modelo, String num_serie, String area, String proveedor_compra, ArrayList<String> accesorios, String num_flujo, String ubicacion, String fecha_instalacion, String estado, String proveedor_serv, String contacto, String telefono, ArrayList<String> refacciones, ArrayList<String> consumibles, String frecuencia) {
        this.num_control = num_control;
        this.equipo = equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.area = area;
        this.proveedor_compra = proveedor_compra;
        this.accesorios = accesorios;
        this.num_flujo = num_flujo;
        this.ubicacion = ubicacion;
        this.fecha_instalacion = fecha_instalacion;
        this.estado = estado;
        this.proveedor_serv = proveedor_serv;
        this.contacto = contacto;
        this.telefono = telefono;
        this.refacciones = refacciones;
        this.consumibles = consumibles;
        this.frecuencia = frecuencia;
        this.prox_mantto = "";
    }

    public Object[] getAsRow(){
        Object[] equipo = new Object[18];
        equipo[0] = this.num_control;
        equipo[1] = this.equipo;
        equipo[2] = this.marca;
        equipo[3] = this.modelo;
        equipo[4] = this.num_serie;
        equipo[5] = this.area;
        equipo[6] = this.proveedor_compra;
        equipo[7] = this.accesorios;
        equipo[8] = this.num_flujo;
        equipo[9] = this.ubicacion;
        equipo[10] = this.fecha_instalacion;
        equipo[11] = this.estado;
        equipo[12] = this.proveedor_serv;
        equipo[13] = this.contacto;
        equipo[14] = this.telefono;
        equipo[15] = this.refacciones;
        equipo[16] = this.consumibles;
        equipo[17] = this.frecuencia;
        return equipo;
    }

    public void setProx_mantto(){
        String[] date;
        if(this.prox_mantto == ""){
             date = this.fecha_instalacion.split("/");
        } else{
            date = this.prox_mantto.split("/");
        }
        System.out.println("FECHA:");
        if(this.frecuencia == null)
            this.frecuencia = "3";
        System.out.println(this.frecuencia);
        String mes = date[1];
        String ano = date[2];
        int num_mes = Integer.parseInt(mes);
        int next_mes = num_mes + (int)Double.parseDouble(this.frecuencia);
        if(next_mes>12){
            next_mes = next_mes - 12;
            ano = String.valueOf(Integer.parseInt(ano) + 1);
        }
        this.prox_mantto = date[0] + "/"+String.valueOf(next_mes)+"/"+ano;
    }

}
