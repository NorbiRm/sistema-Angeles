import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import sun.net.www.content.text.Generic;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Controller {

    public String[] cols_usuarios;
    public String[] cols_equipos;
    public String[] cols_servicios;
    public Sistema system;

    public Controller(){
        this.cols_usuarios = new String[]{"Nombre", "Puesto", "Genero", "Fecha de Registro"};
        this.cols_equipos = new String[]{"Numero de control", "Equipo", "Marca", "Modelo", "Numero de serie", "Area", "Proveedor de compra",
                "Accesorios", "Numero de activo fijo", "Ubicacion", "Fecha de instalacion", "Estado de equipo", "Proveedor de servicio",
                "Contacto", "Telefono", "Refacciones Cambiadas", "Consumibles", "Frecuencia"};
        this.cols_servicios = new String[]{"Folio", "No_Control", "No_Serie", "Equipo", "Marca", "Fecha_Solicitud",
                "Fecha_Terminacion", "Departamento_Solicitante", "Asignado_A", "Falla_Encontrada", "Trabajo_Realizado",
                "Partes_Nuevas", "Costo_Refaccion", "Costo_Servicio_Externo", "Costo_Total", "Horas_Ingeniero",
                "Costo_Horas_Ingeniero", "Reporta", "Falla_Reportada", "Recibe", "Trabajo_Realizado", "Trabajo_Realizado_Descripcion",
                "Observaciones"};

        this.system  = new Sistema(getEquipos(), getUsuarios(), getMantenimientos());
    }

    public ArrayList<Equipo> getEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Object[]> rows_equipos;
        rows_equipos = loadSheet("EQUIPO", this.cols_equipos, this.cols_equipos.length);
        for(Object[] row: rows_equipos) {
            if(!rowIsNull(row)){
                Equipo equipo = new Equipo(row);
                equipo.setProx_mantto();
                equipos.add(equipo);
            }
        }
        return equipos;
    }

    public ArrayList<Usuarios> getUsuarios(){
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        ArrayList<Object[]> rows_usuarios;
        rows_usuarios = loadSheet("USUARIOS", this.cols_usuarios, this.cols_usuarios.length);
        for(Object[] row: rows_usuarios){
            usuarios.add(new Usuarios(row));
        }
        return usuarios;
    }

    public ArrayList<Servicio> getMantenimientos(){
        ArrayList<Servicio> servicios = new ArrayList<>();
        ArrayList<Object[]> rows_servicios;
        rows_servicios = loadSheet("MANTENIMIENTO", this.cols_servicios, this.cols_servicios.length);
        for(Object[] row: rows_servicios){
            if(!rowIsNull(row)){
                servicios.add(new Servicio(row));
            }
        }
        return servicios;
    }

    public Object[][] showEquipo(){
        int num_equipos = this.system.equipos.size();
        Object[][] data = new Object[num_equipos][];
        for(int i=0;i<num_equipos;i++){
            data[i] = this.system.equipos.get(i).getAsRow();
        }
        return data;
    }

    public Object[][] showUsuarios(){
        int num_usuarios = this.system.usuarios.size();
        Object[][] data = new Object[num_usuarios][];
        for(int i=0;i<num_usuarios;i++){
            data[i] = this.system.usuarios.get(i).getAsRow();
        }
        return data;
    }

    public Object[][] showServicios(){
        int num_mantenimientos = this.system.mantenimientos.size();
        Object[][] data = new Object[num_mantenimientos][];
        for(int i=0;i<num_mantenimientos;i++){
            data[i] = this.system.mantenimientos.get(i).getAsRow();
        }
        return data;
    }

    private Object[] loadWB() throws IOException{
        String file_path = "src/Datos.xlsx";
        FileInputStream root_excel = new FileInputStream(new File(file_path));

        //System.out.println("Se carga el archivo");
        Object wb;
        String file_type = "xlsx";
        //Parse file based on the type of file
        if (file_path.contains(".xlsx")) {
            wb = new XSSFWorkbook(root_excel);
        }else{
            wb = new HSSFWorkbook(root_excel);
            file_type = "xls";
        }
        Object[] data_return = {wb, file_type, root_excel};
        return data_return;

        /*FOR CSV
        //String file_path = "src/Datos.csv";
        File csvFile = new File(file_path);
        if (csvFile.isFile()) {
            String row = null;
            BufferedReader csvReader = new BufferedReader(new FileReader(file_path));
            //HashMap<String, ArrayList<String>>
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // do something with the data
            }
            csvReader.close();
            // create BufferedReader and read data from csv
        }*/
    }



    //public DefaultTableModel loadSheet
    public ArrayList<Object[]> loadSheet(String sheet_name, String[] columns, int num_columns){
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Object[]> sheet_rows = new ArrayList<>();

        try{
            Object[] wb_data = loadWB();
            //make model
            model.setColumnIdentifiers(columns);
            System.out.println("cargo wb");
            String file_type = (String)wb_data[1];

            if(file_type.equals("xlsx")){
                XSSFWorkbook wb = (XSSFWorkbook)wb_data[0];
                //model = makeRows(model, wb.getSheet(sheet_name), num_columns);
                sheet_rows = makeRows(model, wb.getSheet(sheet_name), num_columns);
            } else{
                HSSFWorkbook wb = (HSSFWorkbook)wb_data[0];
                //model = makeRows(model, wb.getSheet(sheet_name), num_columns);
                sheet_rows = makeRows(model, wb.getSheet(sheet_name), num_columns);
            }
            ((FileInputStream)wb_data[2]).close();
            System.out.println("se cierra el archivo");
        }catch(Exception e){
            System.err.println("Error while loading workbook");
            System.out.println(e.toString());
            System.exit(1); //if error
        }
        return sheet_rows; //return model;
    }

    public ArrayList<Object[]> makeRows(DefaultTableModel model, Sheet rows, int row_size){
        ArrayList<Object[]> new_rows = new ArrayList<>();
        System.out.println("entro a makerows");
        Object[] new_row = new Object[row_size];
        int cell_count = 0;
        int row_count = 0;
        for(Row row: rows){
            if(row_count > 0 && isAValidRow(row, row_size)){
                for(Cell cell: row){
                    new_row[cell_count] = cell.toString();
                    cell_count++;
                }
                new_rows.add(new_row);
                new_row = new Object[row_size];
                cell_count = 0;
            }
            row_count++;
        }
        return new_rows;
    }

    public boolean rowIsNull(Object[] row){
        System.out.println("se checa si es null");
        int contNulls = 0;
        for(Object cell: row){
            if(cell==null){
                System.out.println("tiene un null");
                contNulls+=1;
            }
        }
        System.out.println(String.format("countNulls %d, rowcols: %d", contNulls, row.length));
        if(contNulls+1>=row.length){
            return true;
        }
        else
            return false;
    }

    public void calculateKPIs(){
        //% mantos correctos e incorrectos
        //System.out.println(getTiempoMantenimientoPromedio());

        //% equios disponibles
        //getEquiposDisponibles

        //% mantos por tipo de falla
        //getTypeOfFailures()
    }

    /*
    sum every delta_time(fecha_terminacion-fecha_solicitud).days and gets the average
     */
    public int getTiempoMantenimientoPromedio(){
        String[] columns = {
                "Folio", "No_Control", "No_Serie", "Equipo", "Marca", "Fecha_Solicitud",
                "Fecha_Terminacion", "Departamento_Solicitante", "Asignado_A", "Falla_Encontrada",
                "Trabajo_Realizado", "Partes_Nuevas", "Costo_Refacciones", "Costo_Sercivio_Externo",
                "Costo_Total"
        };
        int average_time = 0;
        DefaultTableModel model = new DefaultTableModel(); //loadSheet("Mantenimientos", columns, columns.length);
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(model.getDataVector());
        Vector<Vector> rows = model.getDataVector();
        Vector<Vector> cleanRows = new Vector<>();

        //System.out.println(rows.getClass());
        for(Vector row: rows){
            System.out.println(row.getClass());
            System.out.println(row);
            System.out.println(row.get(5));
            try{
                String start = String.valueOf(row.get(5));
                String end = String.valueOf(row.get(6));
                Date startdt = date_format.parse(start);
                Date enddt = date_format.parse(end);
                long diff = Math.abs(enddt.getTime() - startdt.getTime());
                long days = TimeUnit.MILLISECONDS.toDays(diff);
                average_time += (int)days;
                cleanRows.add(row);
            } catch(ParseException e){
                System.out.println("Error while parsing dates");
                System.exit(1);
            }
        }
        return cleanRows.size()>1? average_time/(rows.size()): 0;
    }
    /*
    Returns false when every cell in row is null, so is not a
    valid row..
     */
    public boolean isAValidRow(Row row, int num_cols){
        int numNulls = 0;
        for(Cell cell: row){
            if(cell.toString() == null){
               numNulls+=1;
            }
        }
        return numNulls<num_cols;
    }

    public DefaultTableModel generateModel(Object[][] data, String[] header){
        DefaultTableModel model = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }

    /*public DefaultTableModel generateCalendarModel(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("day");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String[] monthe_names = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Month[] months;
        Month month_converter;
        YearMonth yearMonthObject = YearMonth.of(year, Calendar.MONTH);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for(int i=0;i<monthe_names.length;i++){
            months[0] =
        }
        System.out.println(dia);
    }*/

    public Object[] concatArrays(Object[] array1, Object[] array2){
        Object[] result = new Object[array1.length + array2.length];
        int limit = array1.length<=array2.length? array1.length : array2.length;
        for(int i=0;i<result.length;i++){
            result[i] = i<limit? array1[i]: array2[i-array1.length];
        }
        return result;
    }



}
