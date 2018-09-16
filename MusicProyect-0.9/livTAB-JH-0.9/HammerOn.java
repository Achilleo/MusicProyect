import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class HammerOn
{
    
    private String before;
    private String current;
    private String after;
    private int chordValue;
    private Diapason diapason; 
    private String convertedString = "HIJKLMNOPQRSTUVWXYZ";

    /**
     * Constructor for objects of class HammerOn
     */
    public HammerOn(Diapason diap, int chv, String bef, String curr, String aft)
    {
     
        diapason = diap;
        chordValue = chv;
        before = bef;
        current = curr;
        after = aft;
      
     Graphics g = diapason.getGraphics();
     g.setColor( Color.GREEN);
     
     
     ////////////////////Si es un número////////////////////
     
     if(Converter.checkMe(before) == true)
      {  
        int multiplierBefore = Integer.parseInt(before);
        g.fillOval( 60*multiplierBefore - 41, chordValue, 20, 20 );
      } 
     if(Converter.checkMe(after) == true)
      {  
        int multiplierAfter = Integer.parseInt(after);
        g.fillOval( 60*multiplierAfter - 41, chordValue, 20, 20 );
      } 

     ////////////////////////////////////////////////////////////
     
      ///////////////// Si es una letra  ////////////////////////
     if(convertedString.contains(before)) //Es una letra de las convertidas
      {
      int multiplierBefore = Converter.convertIntoNumber(before);
      g.fillOval( 60*multiplierBefore - 41, chordValue, 20, 20 );
      }     
     if(convertedString.contains(after)) //Es una letra de las convertidas
      {
      int multiplierAfter = Converter.convertIntoNumber(after);
      g.fillOval( 60*multiplierAfter - 41, chordValue, 20, 20 );
      } 
     ////////////////////////////////////////////////////////////
      
    }


}
