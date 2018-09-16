import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
/**
 * Demo prueba que la tablatura se escribe toda horizontalmente
 * en el objeto Tab en cada uno de sus 6 Strings y presenta en
 * JTextArea.
 * 
 * @author  FRoM
 * @version 2018
 */
public class Demo extends JFrame
{
    public final int ANCHO = 800;
    public final int ALTO = 400;   
    private Container contents;
    private JTextArea texto;
    
    private Tab tab;

    public Demo()
    {
        creaVentana();
        iniciaElementos();
    }

    private void iniciaElementos()
    {
       
        
        
        Lector.leeTab();
        tab = Lector.obtenTab();
        
        
         String[] cuerdasLeidas = tab.getCuerdas();
         String[] cuerdasTrabajadas = Converter.convertDoubleDigit(cuerdasLeidas);
         
        
        texto.append("\n");
        for( int i = 0; i<6; i++ )
        {
            texto.append(cuerdasTrabajadas[i]+ "\n");
        }
        
        
    }

    private void creaVentana()
    {
        setTitle( "livTAB - V0.2 - FRoM" );
        contents = getContentPane( );
        contents.setLayout( new FlowLayout( ) );

        texto = new JTextArea();
        Font font = new Font("Consolas", Font.PLAIN, 20);
        texto.setFont(font);
        texto.setEditable( false );
        JScrollPane js = new JScrollPane( texto );
        js.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        js.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );  
        js.setPreferredSize( new Dimension( ANCHO-40, ALTO-80 ) );
        contents.add( js );

        setSize( ANCHO, ALTO );
        setVisible( true );        
    }
}
