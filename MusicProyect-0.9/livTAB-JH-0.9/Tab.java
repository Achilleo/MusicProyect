import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 * Tab representa una tablatura.
 *
 * @author  FRoM
 * @version 2018
 */
public class Tab
{
    
    public final int CUERDAS = 6;
    public final int iCUERDA = 0; // indicador de cuerda en Tab: eBGDAE    
    private String[] cuerdas;
    private int chordNumber = 6;
    
       
    private String[] currentMoment = new String[chordNumber];
    private String[] currentMomentNext = new String[chordNumber];
    private String[] currentMomentBefore = new String[chordNumber];

    private String enumberBefore;
    private String BnumberBefore;
    private String GnumberBefore;
    private String DnumberBefore;
    private String AnumberBefore;
    private String EnumberBefore;
   
    private String enumber;
    private String Bnumber;
    private String Gnumber;
    private String Dnumber;
    private String Anumber;
    private String Enumber;
   
    private  String enumberNext;
    private  String BnumberNext;
    private  String GnumberNext;
    private  String DnumberNext;
    private  String AnumberNext;
    private  String EnumberNext;
         
    
    private String convertedString = "HIJKLMNOPQRSTUVWXYZ";
 
       
    private Converter instance = Converter.getConverter();
    
    private static Tab instancia = new Tab();
    public  static Tab getTab(  )
    {       
        return instancia;
    }

    /**
     * Constructor Tab
     */
    public Tab()
    {
        cuerdas = new String[CUERDAS];
        for( int i = 0; i<6; i++ )
        {
            cuerdas[i] = "";
        }        
    }

    public void painter(Diapason diapason)
    {
     Graphics g = diapason.getGraphics();
     g.setColor( Color.RED );
       
     //82 es la pos inicial del primer traste
     //40 es la distancia entre puntos en el eje Y
     //60 en el eje X
     //g.fillOval( X, Y, 20, 20 );
     
   
     checkMomentBefore();
     checkMomentActual();
     checkMomentAfter();
     
     if(convertedString.contains(enumber)) //Es una letra de las convertidas
      {
      int e = Converter.convertIntoNumber(enumber);
      g.fillOval( 60*e + 82, 35, 20, 20 );
      }     
     if(Converter.checkMe(enumber) == true) //Es un número?
      {  
        int  e = Integer.parseInt(enumber);
        g.fillOval( 60*e + 82, 35, 20, 20 );
      } else Converter.convertAction(diapason, 35, enumberBefore, enumber, enumberNext);

      
     if(convertedString.contains(Bnumber)) //Es una letra de las convertidas
      {
      int B = Converter.convertIntoNumber(Bnumber);
      g.fillOval( 60*B + 82, 75, 20, 20 );
      }  
     if(Converter.checkMe(Bnumber) == true)
      {  
        int B = Integer.parseInt(Bnumber);
        g.fillOval( 60*B + 82, 75, 20, 20 );
      }  else Converter.convertAction(diapason, 75, BnumberBefore, Bnumber, BnumberNext);

      
            
      if(convertedString.contains(Gnumber)) //Es una letra de las convertidas
      {
      int G = Converter.convertIntoNumber(Gnumber);
      g.fillOval( 60*G + 82, 115, 20, 20 );
      }
       if(Converter.checkMe(Gnumber) == true)
      {  
        int G = Integer.parseInt(Gnumber);
        g.fillOval( 60*G + 82, 115, 20, 20 );
      }  else Converter.convertAction(diapason, 115, GnumberBefore, Gnumber, GnumberNext);
      
      
      if(convertedString.contains(Dnumber)) //Es una letra de las convertidas
      {
      int D = Converter.convertIntoNumber(Dnumber);
      g.fillOval( 60*D + 82, 155, 20, 20 );
      }
       if(Converter.checkMe(Dnumber) == true)
      {  
        int D = Integer.parseInt(Dnumber);
        g.fillOval( 60*D + 82, 155, 20, 20 );
      }  else Converter.convertAction(diapason, 155, DnumberBefore, Dnumber, DnumberNext);
      
      
      if(convertedString.contains(Anumber)) //Es una letra de las convertidas
      {
      int A = Converter.convertIntoNumber(Anumber);
       g.fillOval( 60*A + 82, 195, 20, 20 );
      }
       if(Converter.checkMe(Anumber) == true)
      {  
        int A = Integer.parseInt(Anumber);
        g.fillOval( 60*A + 82, 195, 20, 20 );
      }  else Converter.convertAction(diapason, 195, AnumberBefore, Anumber, AnumberNext);
      
      
      
      if(convertedString.contains(Enumber)) //Es una letra de las convertidas
      {
      int E = Converter.convertIntoNumber(Enumber);
       g.fillOval( 60*E + 82, 235, 20, 20 );
      }
       if(Converter.checkMe(Enumber) == true)
      {  
        int E = Integer.parseInt(Enumber);
        g.fillOval( 60*E + 82, 235, 20, 20 );
      }  else Converter.convertAction(diapason, 235, EnumberBefore, Enumber, EnumberNext);

     diapason.paintComponents(g);
   
    }

    
    public void checkMomentBefore(){
     
     //Método invocado que guarda la nota anterior.
     enumberBefore =  currentMomentBefore[0];
     BnumberBefore =  currentMomentBefore[1];
     GnumberBefore =  currentMomentBefore[2];
     DnumberBefore =  currentMomentBefore[3];
     AnumberBefore =  currentMomentBefore[4];
     EnumberBefore =  currentMomentBefore[5];
    
    }
      
        public void checkMomentActual(){
     
     //Método invocado que guarda la nota actual.
     enumber =  currentMoment[0];
     Bnumber =  currentMoment[1];
     Gnumber =  currentMoment[2];
     Dnumber =  currentMoment[3];
     Anumber =  currentMoment[4];
     Enumber =  currentMoment[5];
    
    }
      
    
    public void checkMomentAfter(){
        
     //Método invocado que guarda la nota siguiente.   
     enumberNext =  currentMomentNext[0];
     BnumberNext =  currentMomentNext[1];
     GnumberNext =  currentMomentNext[2];
     DnumberNext =  currentMomentNext[3];
     AnumberNext =  currentMomentNext[4];
     EnumberNext =  currentMomentNext[5];
     
    }
    public void animate(Diapason diapason)
    {
           
       int length = minimumChords();
        
       for( int i = 0; i<=length; i++ )
        {

            currentMomentBefore(i, cuerdas); //Tomar en el vector la posición anterior 
            currentMoment(i, cuerdas); //Tomar en el vector la posición actual
            currentMomentNext(i, cuerdas); //Tomar en el vector la posición siguiente
            
            
            Graphics g = diapason.getGraphics(); //Tome el gráfico del diapasón
            
            //Este condicional se usa para que no se actualice tan rápido
            if(currentMoment[0].equals("-") == false || currentMoment[1].equals("-") ==  false || currentMoment[2].equals("-") ==  false || currentMoment[3].equals("-") ==  false || currentMoment[4].equals("-") ==  false || currentMoment[5].equals("-") ==  false)
            diapason.paintComponent(g);
            
            painter(diapason);
            
            try{
            Thread.sleep(500);
           }catch(Exception E)
          {System.out.println("No esperó");}
        
          System.out.println(i);
            
        } 
    
    
    }

    public int minimumChords(){
    
     int min = 9999999;
    
    
       for( int i = 0; i<=5; i++ )
        {
        int temp = cuerdas[i].length();
        if(temp < min)
           min = temp;
                    
        }
        
     return min;
   }
    
    /**
     * Agrega una linea de notas a cuerda.
     * @param indica cuerda: 0 A 6, 0 es mi aguda...
     * @param String de notas a agregar.
     */
    public void agregaLinea( String str )
    {
        if( str != null && !str.equals("") )
        {
            char ch = str.charAt( iCUERDA );
            str = normaliza( str );
            switch( ch )
            {
                case 'e':
                cuerdas[0] += str;
                break;
                case 'B':
                cuerdas[1] += str;
                break;
                case 'G':
                cuerdas[2] += str;
                break;
                case 'D':
                cuerdas[3] += str;
                break;
                case 'A':
                cuerdas[4] += str;
                break;
                case 'E':
                cuerdas[5] += str;
                break;
            }
        }
    }

    /**
     * Elimina caracteres no validos para la ejecucion
     * @param  String leido de cada linea del archivo.
     */
    private String normaliza( String str )
    {
        String noValidos = "eBGDAE|";
        char[] chars = str.toCharArray();
        String strNormal = "";

        for( int i = 0; i<chars.length; i++ )
        {
            if( noValidos.indexOf( chars[i] ) == -1 )
                strNormal += chars[i];
        }
        return strNormal;
    }

        
    // Método que captura el momento actual en el que se encuentra la máquina.
  public String[] currentMoment(int i, String[] currentStrings)
    {
      
             
          String string0 = Character.toString(currentStrings[0].charAt(i));
          String string1 = Character.toString(currentStrings[1].charAt(i));
          String string2 = Character.toString(currentStrings[2].charAt(i));
          String string3 = Character.toString(currentStrings[3].charAt(i));        
          String string4 = Character.toString(currentStrings[4].charAt(i));
          String string5 = Character.toString(currentStrings[5].charAt(i));
          
          currentMoment[0] = string0;
          currentMoment[1] = string1;
          currentMoment[2] = string2;
          currentMoment[3] = string3;
          currentMoment[4] = string4;
          currentMoment[5] = string5;
 
    return currentMoment;
    }
    
    
        // Método que captura el momento siguiente en el que se encontrará la máquina.
  public String[] currentMomentNext(int i, String[] currentStrings)
    {
                
          String stringNext0 = Character.toString(currentStrings[0].charAt(i+1));
          String stringNext1 = Character.toString(currentStrings[1].charAt(i+1));
          String stringNext2 = Character.toString(currentStrings[2].charAt(i+1));
          String stringNext3 = Character.toString(currentStrings[3].charAt(i+1));        
          String stringNext4 = Character.toString(currentStrings[4].charAt(i+1));
          String stringNext5 = Character.toString(currentStrings[5].charAt(i+1)); 

          currentMomentNext[0] = stringNext0;
          currentMomentNext[1] = stringNext1;
          currentMomentNext[2] = stringNext2;
          currentMomentNext[3] = stringNext3;
          currentMomentNext[4] = stringNext4;
          currentMomentNext[5] = stringNext5;
        
    return currentMomentNext;
    }
    
          // Método que captura el momento siguiente en el que se encontrará la máquina.
  public String[] currentMomentBefore(int i, String[] currentStrings)
    {
           
        
       if(i>0){
          String stringBefore0 = Character.toString(currentStrings[0].charAt(i-1));
          String stringBefore1 = Character.toString(currentStrings[1].charAt(i-1));
          String stringBefore2 = Character.toString(currentStrings[2].charAt(i-1));
          String stringBefore3 = Character.toString(currentStrings[3].charAt(i-1));        
          String stringBefore4 = Character.toString(currentStrings[4].charAt(i-1));
          String stringBefore5 = Character.toString(currentStrings[5].charAt(i-1)); 

          currentMomentBefore[0] = stringBefore0;
          currentMomentBefore[1] = stringBefore1;
          currentMomentBefore[2] = stringBefore2;
          currentMomentBefore[3] = stringBefore3;
          currentMomentBefore[4] = stringBefore4;
          currentMomentBefore[5] = stringBefore5;
        
       return currentMomentBefore;
     }
     return null;
    }
    
    
    public String[] getCuerdas()
    {
        return cuerdas;
    }
    
      
}
