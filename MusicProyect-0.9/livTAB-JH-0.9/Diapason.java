import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *  Esta clase representa un diapason de una guitarra:
 *  6 cuerdas y 24 trastes.
 *  Sobre las cuerdas se ubican circulos que representan los dedos.
 *  A cada dedo se asigna un color.
 *  
 * @author  FRoM
 * @version 2013.08.29
 */
public class Diapason extends JPanel
{
    public final int N_TRASTES = 24;
    public final int DIST_ENTRE_TRASTES = 60;
    public final int DIST_ENTRE_CUERDAS = 40;
    public final int DIST_BORDE_NOTA_AL_AIRE = 22;
    
    private int ancho = 0;
    private int alto = 0;
    
    public Diapason( int ancho, int alto )
    {
        this.ancho = ancho - 40;
        this.alto = alto - 180 ;
        this.setBackground( Color.BLACK );
    }

    public void paintComponent( Graphics g )
    {      
        super.paintComponent( g );
        pintaDiapason( g );
    }

    
    private void pintaDiapason( Graphics g )
    {
        // pinta diapason de madera
        g.setColor( new Color( 230, 210, 180 ) );
        g.fillRect( 16, 36, ancho, alto );            

        // pinta adornos diapason
        g.setColor( Color.WHITE );
        for( int k = 0; k < 4; k++ )     
            g.fillOval( k*120 + 202, 135, 20, 20 );
        g.fillOval( 744, 76, 20, 20 );
        g.fillOval( 744, 196, 20, 20 ); 
        for( int k = 0; k < 4; k++ )     
            g.fillOval( k*120 + 924, 135, 20, 20 );
        g.fillOval( 1464, 76, 20, 20 );
        g.fillOval( 1464, 196, 20, 20 ); 

        // pinta trastes
        for( int i = 0; i < N_TRASTES; i++ )
        {
            new Traste( g, i * DIST_ENTRE_TRASTES );                
        }

        // pinta cuerdas
        for( int j = 0; j < 6; j++ )
        {
            new Cuerda( g, ancho, j * DIST_ENTRE_CUERDAS );
        }
    }
    
    public int getDIST_ENTRE_TRASTES()
    {
        return DIST_ENTRE_TRASTES;
    }
    
    public int getDIST_BORDE_NOTA_AL_AIRE()
    {
        return DIST_BORDE_NOTA_AL_AIRE;
    }

    
    public Graphics returnGraph()
    {
    return getGraphics();
    }
}