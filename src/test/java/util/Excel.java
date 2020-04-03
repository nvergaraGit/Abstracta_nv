package util;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {

	public static List<List<String>> getDatosHojaExcel(String nombreDatapool, int nrohoja) {
	
		// Crea un ArrayList donde almacenara la data leida desde la hoja
		// del archivo excel
		List<List<String>> datosExcel = new ArrayList<List<String>>();
		String curDir = System.getProperty("user.dir");
			
		// Ruta archivo
		String archivoExcel = curDir +"/Datapool/"+nombreDatapool; 
		
		try {
			
			//Crea un FileInputStream para leer el archivo excel
			FileInputStream archivo = new FileInputStream(archivoExcel);

			// Create un libro excel desde el archivo.
			HSSFWorkbook libro = new HSSFWorkbook(archivo);
			
			// Obtiene la primera hoja del libro excel		
			HSSFSheet hoja = libro.getSheetAt(nrohoja);
			
			// Cuando tenemos un objeto de la hoja con el Iterator podemos recorrer
			// las filas de cada hoja y las celdas de cada fila. Almacenamos las filas
			// en un ArrayList y las celdas de vada fila en un List.
			Iterator<?> rows = hoja.rowIterator();
			
			//Formateo de celdas
			DataFormatter formatter = new DataFormatter();
			
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();				
				Iterator<?> cells = row.cellIterator();
				List<String> data = new ArrayList<String>();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					// Agrega las celdas a una Lista y formatea la celda a texto
					data.add(formatter.formatCellValue(cell));
				}
				// Agrega la Lista con el contenido de las celdas a un ArrayList
				datosExcel.add(data);
			}
			archivo.close();
			libro.close();
		} catch (IOException e) {
			System.out.println("getDatosHojaExcel "+e);		
		}catch (Exception e) {
			System.out.println("getDatosHojaExcel "+e);		
		}
		return datosExcel;
	}
}
