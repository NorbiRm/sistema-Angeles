import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;

public class Servicio {
    public String folio;
    public String num_control;
    public String num_serie;
    public String equipo; //Checar si no carmbiar por EQUIPO
    public String marca;
    public String fecha_solicitud;
    public String fecha_terminación;
    public String departamento_solicitante;
    public String asignado_a;
    public String falla_encontrada;
    public String trabajo_realizado;
    public String partes_nuevas;
    public double costo_refacciones;
    public double costo_servicio;
    public double total;
    //opcionales
    public int horas_ing;
    public int costo_hora;
    public String area;
    public String reporta; //Usuarios
    public String falla;
    public String recibe;
    //public String trabajo_realizado; VER PORQUE ESTA 2 VECES
    public String oberservaciones;

    public Servicio(String folio, String num_control, String num_serie, String equipo, String marca, String fecha_solicitud,
                    String fecha_terminación, String departamento_solicitante, String asignado_a, String falla_encontrada,
                    String trabajo_realizado, String partes_nuevas, double costo_refacciones, double costo_servicio,
                    double total, double horas_ing, double costo_hora, String area, String reporta, String falla, String recibe,
                    String oberservaciones) {
        this.folio = folio;
        this.num_control = num_control;
        this.num_serie = num_serie;
        this.equipo = equipo;
        this.marca = marca;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_terminación = fecha_terminación;
        this.departamento_solicitante = departamento_solicitante;
        this.asignado_a = asignado_a;
        this.falla_encontrada = falla_encontrada;
        this.trabajo_realizado = trabajo_realizado;
        this.partes_nuevas = partes_nuevas;
        this.costo_refacciones = costo_refacciones;
        this.costo_servicio = costo_servicio;
        this.total = total;
        this.horas_ing = (int)horas_ing;
        this.costo_hora = (int)costo_hora;
        this.area = area;
        this.reporta = reporta;
        this.falla = falla;
        this.recibe = recibe;
        this.oberservaciones = oberservaciones;
    }

    public Servicio(Object[] atts){
        /*int cont = 0;
        for(Object at: atts){
            System.out.print(cont);
            System.out.println(at);
            cont++;
        }*/
        this.folio = (String)atts[0];
        this.num_control = (String)atts[1];
        this.num_serie = (String)atts[2];
        this.equipo = (String)atts[3];
        this.marca = (String)atts[4];
        this.fecha_solicitud = (String)atts[5];
        this.fecha_terminación = (String)atts[6];
        this.departamento_solicitante = (String)atts[7];
        this.asignado_a = (String)atts[8];
        this.falla_encontrada = (String)atts[9];
        this.trabajo_realizado = (String)atts[10];
        this.partes_nuevas = (String)atts[11];
        this.costo_refacciones = Double.parseDouble((String)atts[12]);
        this.costo_servicio = Double.parseDouble((String)atts[13]);
        this.total = Double.parseDouble((String)atts[14]);
        this.horas_ing = (int)Double.parseDouble((String)atts[15]);
        this.costo_hora = (int)Double.parseDouble((String)atts[16]);
        this.area = (String)atts[17];
        this.reporta = (String)atts[18];
        this.falla = (String)atts[19];
        this.recibe = (String)atts[20];
        this.oberservaciones = (String)atts[21];
    }

    public Object[] getAsRow(){
        Object[] servicio = new Object[22];
        servicio[0] = this.folio;
        servicio[1] = this.num_control;
        servicio[2] = this.num_serie;
        servicio[3] = this.equipo;
        servicio[4] = this.marca;
        servicio[5] = this.fecha_solicitud;
        servicio[6] = this.fecha_terminación;
        servicio[7] = this.departamento_solicitante;
        servicio[8] = this.asignado_a;
        servicio[9] = this.falla_encontrada;
        servicio[10] = this.trabajo_realizado ;
        servicio[11] = this.partes_nuevas;
        servicio[12] = this.costo_refacciones;
        servicio[13] = this.costo_servicio;
        servicio[14] = this.total;
        servicio[15] = this.horas_ing;
        servicio[16] = this.costo_hora;
        servicio[17] = this.area ;
        servicio[18] = this.reporta ;
        servicio[19] = this.falla ;
        servicio[20] = this.recibe ;
        servicio[21] = this.oberservaciones ;

        return servicio;
    }
}
