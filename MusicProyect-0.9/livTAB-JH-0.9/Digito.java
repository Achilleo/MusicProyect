import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
/**
 * Digito:  Abstrae un lugar donde se digita en la guitarra.
 * Posee una posicion determinada por traste + cuerda y color.
 * 
 * @author     FRoM 
 * @version     2013.
 */
public class Digito
{   
    private Color colorDigito;
    private Color defaultColor = Color.GRAY;    // default color

    private int posX, posY;    
    private int radio = 20;
    private int duraNota = 200;   
    
    public Digito( Graphics g, int posX, int posY )
    {
        colorDigito = defaultColor;
        this.posX = posX;
        this.posY = posY;
        dibujate( g );
    }

    public void dibujate( Graphics g)
    {
        g.setColor( colorDigito );
        g.fillOval( posX, posY, radio, radio );
    }

    // Cambia temporalmente el color del digito; usado por animate     
    private void dibujate( Graphics g, Color colorDedo )
    {
        g.setColor( colorDedo );
        g.fillOval( posX, posY, radio, radio );
    }

    public void animate( Graphics g, Color colorDedo, int tDura )
    {
        dibujate( g, colorDedo );
        espera( tDura );    
        dibujate( g );
    }

    public void setColor( Graphics g, Color colorNuevo )
    {
        colorDigito = colorNuevo;
    }

    public Color getColor()
    {
        return colorDigito;
    }

    /**
     * espera una cantidad de milisegundos y desaparece.
     * @param  milisegundos  the number 
     */
    public void espera( int milisegundos )
    {
        try
        {
            Thread.sleep( milisegundos );
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }         
}