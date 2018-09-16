import java.awt.Graphics;
import java.awt.Color;
/**
 * Cuerda representa una cuerda en la guitarra,
 * se asocia con una linea en la tablatura.
 * 
 * @author     FRoM 
 * @version     2013.
 */
public class Cuerda
{
    public final int ALTO = 4;    
    private int ancho = 0;
    // disTraste: distancia entre trastes
    private int distDiapasonCuerdas = 44;
    private int posicionX = 60;  
    private int posicionY = 40; // var�a para cada traste
    private Color colorCuerda = Color.YELLOW;

    public Cuerda( Graphics g, int ancho, int distEntreCuerdas )
    {
        this.ancho = ancho - distDiapasonCuerdas;
        // distCejilla: distancia de cejilla a traste
        posicionY = distDiapasonCuerdas + distEntreCuerdas;        
        g.setColor( colorCuerda );
        g.fillRect( posicionX, posicionY, ancho, ALTO);
    }
}