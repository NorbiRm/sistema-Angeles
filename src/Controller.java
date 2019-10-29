import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import sun.security.ssl.Debug;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller {

    public Object[] loadWB() throws IOException{
        String file_path = "src/Libro1.xlsx";
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
    }

    public void addUser(Object[] data){
        try{
            Object[] wb_config = loadWB();

        } catch (IOException e){

        }catch (Exception e){

        }

    }

    public DefaultTableModel loadTable(String sheet_name, String[] columns, int num_columns){
        DefaultTableModel model = new DefaultTableModel();
        try{
            Object[] wb_data = loadWB();
            //make model
            model.setColumnIdentifiers(columns);

            System.out.println("cargo wb");

            String file_type = (String)wb_data[1];

            System.out.println("puso file_type");

            if(file_type.equals("xlsx")){
                XSSFWorkbook wb = (XSSFWorkbook)wb_data[0];
                model = makeRows(model, wb.getSheet(sheet_name), num_columns);
            } else{
                HSSFWorkbook wb = (HSSFWorkbook)wb_data[0];
                model = makeRows(model, wb.getSheet(sheet_name), num_columns);
            }

            ((FileInputStream)wb_data[2]).close();
        }catch(Exception e){
            System.err.println("Error while loading workbook");
            System.out.println(e.toString());
            //if error
            System.exit(1);
        }
        return model;
    }

    public DefaultTableModel makeRows(DefaultTableModel model, Sheet rows, int row_size){
        System.out.println("entro a makerows");
        Object[] new_row = new Object[row_size];
        int cell_cont = 0;
        for(Row row: rows){
            for(Cell cell: row){
                new_row[cell_cont] = cell.toString();
                cell_cont++;
            }
            model.addRow(new_row);
            new_row = new Object[row_size];
            cell_cont = 0;
        }
        return model;
    }

}
