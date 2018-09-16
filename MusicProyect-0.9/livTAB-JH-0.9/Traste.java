import java.awt.Graphics;
import java.awt.Color;
/**
 * Traste representa un lugar en la guitarra asociado a una nota.
 * 
 * @author     FRoM 
 * @version     2013.
 */
public class Traste
{
    private int ancho = 6;
    private int alto = 214;    
    // distEntreTrastes: distancia entre trastes
    private int distCejilla = 60;
    private int posicionX = 0;  // var�a para cada traste
    private int posicionY = 40;
    private Color colorTraste = Color.GRAY;

    public Traste( Graphics g, int distEntreTrastes )
    {
        // distCejilla: distancia de cejilla a traste
        posicionX = distCejilla + distEntreTrastes;
        g.setColor( colorTraste );        
        g.fillRect( posicionX, posicionY, ancho, alto);
    }
}