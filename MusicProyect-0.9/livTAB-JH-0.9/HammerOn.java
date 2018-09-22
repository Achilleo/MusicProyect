import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class HammerOn extends Action
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
     
        super(diap, chv, bef, curr, aft, Color.GREEN);
        
        diapason = diap;
        chordValue = chv;
        before = bef;
        current = curr;
        after = aft;
      
        super.repaint();
      
    }


}
