/**
 * 
 */
package uploadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class BuscaExtension {
	private static BufferedReader abrirYPrepararFichero (String nombre) throws FileNotFoundException
	{
		BufferedReader br = null;
		
		//TODO Abrir y preparar la lectura de un fichero de texto
		FileReader file = new FileReader(nombre);
		
		br = new BufferedReader(file); 
		
		return br;
	}
	
	
	public String StringsetContentType(String extension) throws IOException{
		String respuesta ="";
		
		BufferedReader br = abrirYPrepararFichero("tipomime.txt");
		boolean final_fichero = false;
		String linea;
		
		while (!final_fichero)
		{
			linea = br.readLine();
			if (linea == null)
			{
				final_fichero = true;
			} else 
				{
					if(linea.contains(extension)){
						respuesta = linea.substring(extension.length()+1);
					}
				
				}
		}
		br.close();
		return respuesta;
	}
	
	
	
	
}
