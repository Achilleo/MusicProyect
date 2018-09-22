import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Graphics;
/**
 * livTAB es una clase que coordina la funcionalidad.
 * Despliega un diapason para la tablatura, 
 * permmite seleccionar un tema = {solo, escala, ejercicio, cancion},
 * ejecutarlo dandole vida a la tablatura 
 * y desacelerar/acelerar el tema.
 * Crear ciclos y reproducirlos continuamente.
 * 
 * @author      FRoM 
 * @version     2013
 */
public class livTAB
{
    public final int ANCHO = 1520;
    public final int ALTO = 400;
    private int indice;     

    private Tab tab;
    private Diapason diapason;

    private static livTAB instancia = new livTAB();
    public static livTAB getLivTab(  )
    {       
        return instancia;
    }

    private livTAB()
    {
        iniciaElementos();        
        creaGUI();        
    }

    private class OyentejbPlay implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            tab.animate(diapason);
            
            
        }
    }

    private class OyentejbPause implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
        }
    }

    private void iniciaElementos()
    {
        Lector.leeTab();
        tab = Lector.obtenTab();
                
        String[] cuerdasLeidas = tab.getCuerdas();
        String[] cuerdasTrabajadas = Converter.convertDoubleDigit(cuerdasLeidas);
        
    }

    

    private void creaGUI()
    {
        JFrame ventana = new JFrame( "livTAB - FRoM, 2013" );
        Container contenedor = ventana.getContentPane();

        diapason = new Diapason( ANCHO, ALTO );
        contenedor.add( diapason, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout( new FlowLayout() );

        JButton jbPlay = new JButton( "Play" );        
        jbPlay.addActionListener( new OyentejbPlay() );        
        JButton jbPause = new JButton( "Pause" );
        jbPause.addActionListener( new OyentejbPause() );     
        panelBotones.add( jbPlay );
        panelBotones.add( jbPause );            
        contenedor.add( panelBotones, BorderLayout.SOUTH );

        ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ventana.setSize( ANCHO, ALTO  );
        ventana.setResizable( true );
        ventana.setLocation( 100, 40 );        
        ventana.setVisible(true);
    }

    public Diapason getDiapason()
    {
    return diapason;
    }
    
    public static void main( String [] args )
    {
        livTAB livTab = livTAB.getLivTab();
    }
}