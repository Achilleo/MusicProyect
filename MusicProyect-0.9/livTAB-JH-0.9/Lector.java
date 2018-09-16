import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Scanner;
import java.io.File;
import java.io. FileNotFoundException;
import java.io. IOException;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Lector lee tablatura de archivo texto y crea objeto Tab.
 *
 * @author  FRoM
 * @version 2018
 */
public class Lector
{   
    static private Tab tab;
    /**
     * Lee archivo texto que seleccione usuario.
     */
    static public void leeTab()
    {
        tab = new Tab();
        String strArchivo = seleccionaArchivo();
        creaTab( strArchivo );
    }

    /**
     * Lee archivo texto que seleccione usuario.
     */
    static private String seleccionaArchivo()
    {
        String strArchivo = "../tabs/menor.txt";
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));        
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            strArchivo = chooser.getSelectedFile().getAbsolutePath();
        }
        return strArchivo;
    }

    /**
     * Con data leida crea objeto Tab.
     * @param  data leida de archivo texto.
     */
    static private void creaTab(String strArchivo)
    {
        System.out.println("Seleccionaste " + strArchivo);

        try
        {
            Scanner file = new Scanner( new File (strArchivo) );
            while ( file.hasNext( ) ) // test for the end of the file
            {
                String stringRead = file.nextLine( );  // read a line
                tab.agregaLinea(stringRead);
                System.out.println( stringRead );  // print the line read
            }

            file.close( );
        }
            catch ( IOException ioe )
        {
            ioe.printStackTrace( );
        }        
    }

    /**
     * Entrega objeto Tab de lectura de archivo.
     * @return  objeto Tab.
     */
    static public Tab obtenTab()
    {
        return tab;
    }
}