import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;


public class Action
{
    private String before;
    private String current;
    private String after;
    private int chordValue;
    private Diapason diapason; 
    private Color color;
    private String convertedString = "HIJKLMNOPQRSTUVWXYZ";

    /**
     * Constructor for objects of class HammerOn
     */
    public Action(Diapason diap, int chv, String bef, String curr, String aft, Color col)
    {
     
        diapason = diap;
        chordValue = chv;
        before = bef;
        current = curr;
        after = aft;
        color = col;
      
    }

    
    public void repaint()
    {
              
     Graphics g = diapason.getGraphics();
     g.setColor(color);


     boolean W = false; 
     boolean X = false; 
     boolean Y = false;
     boolean Z = false;
     int lineW = 0;
     int lineX = 0;
     int lineY = 0;
     int lineZ = 0;
    
     //Si es un número////////////////////
      if(Converter.checkMe(before) == true)
      {  
        int multiplierBefore = Integer.parseInt(before);
        g.fillOval( 60*multiplierBefore - 41, chordValue, 20, 20 );
        W = true;
        lineW = 60*multiplierBefore - 41;
      } 
     if(Converter.checkMe(after) == true)
      {  
        int multiplierAfter = Integer.parseInt(after);
        g.fillOval( 60*multiplierAfter - 41, chordValue, 20, 20 );
        X = true;
        lineX = 60*multiplierAfter - 41;
      } 

      //Si es una letra  ////////////////////////
     if(convertedString.contains(before)) //Es una letra de las convertidas
      {
      int multiplierBefore = Converter.convertIntoNumber(before);
      g.fillOval( 60*multiplierBefore - 41, chordValue, 20, 20 );
      Y = true;
      lineY = 60*multiplierBefore - 41;
      }     
     if(convertedString.contains(after)) //Es una letra de las convertidas
      {
      int multiplierAfter = Converter.convertIntoNumber(after);
      g.fillOval( 60*multiplierAfter - 41, chordValue, 20, 20 );
      Z = true;
      lineZ = 60*multiplierAfter - 41;
      } 
     ////////////////////////////////////////////////////////////
 
     //Líneas
     if(W == true && X == true)
     {
      g.drawLine(lineW, chordValue + 7, lineX, chordValue + 7);
      g.drawLine(lineW, chordValue + 10, lineX, chordValue + 10);
      g.drawLine(lineW, chordValue + 13, lineX, chordValue + 13);
         
     }
     if(W == true && Z == true)
     {
      g.drawLine(lineW, chordValue + 7, lineZ, chordValue + 7);
      g.drawLine(lineW, chordValue + 10, lineZ, chordValue + 10);
      g.drawLine(lineW, chordValue + 13, lineZ, chordValue + 13);
     }
     if(Y == true && X == true)
     {
      g.drawLine(lineY, chordValue + 7, lineX, chordValue + 7);
      g.drawLine(lineY, chordValue + 10, lineX, chordValue + 10);
      g.drawLine(lineY, chordValue + 13, lineX, chordValue + 13);   
     }
     if(Y == true && Z == true)
     {
      g.drawLine(lineY, chordValue + 7, lineZ, chordValue + 7);
      g.drawLine(lineY, chordValue + 10, lineZ, chordValue + 10);
      g.drawLine(lineY, chordValue + 13, lineZ, chordValue + 13);
        
     }
     
     
    }

    


}