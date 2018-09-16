import org.apache.commons.lang3.StringUtils;

public class Converter{

    
    private static Converter instancia = new Converter();
    private Tab tab = Tab.getTab();
    
    public static Converter getConverter(  )
    {       
        return instancia;
    }
    
      public static String[] convertDoubleDigit(String[] sixStrings)
    {
              
        String[] cuerdasNuevas = sixStrings;
        
       for( int i = 0; i<6; i++ )
        {
                    
            //prohibidas eDGBAE, reservado de A hasta G
            //empieza desde H hasta Z
            
           String replacedString10 = StringUtils.replacePattern(cuerdasNuevas[i],"10", "H");
           cuerdasNuevas[i] = replacedString10;
            
           String replacedString11 = StringUtils.replacePattern(cuerdasNuevas[i],"11", "I");
           cuerdasNuevas[i] = replacedString11;
                     
           String replacedString12 = StringUtils.replacePattern(cuerdasNuevas[i],"12", "J");
           cuerdasNuevas[i] = replacedString12;
                     
           String replacedString13 = StringUtils.replacePattern(cuerdasNuevas[i],"13", "K");
           cuerdasNuevas[i] = replacedString13;
                     
           String replacedString14 = StringUtils.replacePattern(cuerdasNuevas[i],"14", "L");
           cuerdasNuevas[i] = replacedString14;
                     
           String replacedString15 = StringUtils.replacePattern(cuerdasNuevas[i],"15", "M");
           cuerdasNuevas[i] = replacedString15;
                     
           String replacedString16 = StringUtils.replacePattern(cuerdasNuevas[i],"16", "N");
           cuerdasNuevas[i] = replacedString16;
                     
           String replacedString17 = StringUtils.replacePattern(cuerdasNuevas[i],"17", "O");
           cuerdasNuevas[i] = replacedString17;
           
           String replacedString18 = StringUtils.replacePattern(cuerdasNuevas[i],"18", "P");
           cuerdasNuevas[i] = replacedString18;
                     
           String replacedString19 = StringUtils.replacePattern(cuerdasNuevas[i],"19", "Q");
           cuerdasNuevas[i] = replacedString19;
                     
           String replacedString20 = StringUtils.replacePattern(cuerdasNuevas[i],"20", "R");
           cuerdasNuevas[i] = replacedString20;
                     
           String replacedString21 = StringUtils.replacePattern(cuerdasNuevas[i],"21", "S");
           cuerdasNuevas[i] = replacedString21;
                     
           String replacedString22 = StringUtils.replacePattern(cuerdasNuevas[i],"22", "T");
           cuerdasNuevas[i] = replacedString22;
                     
           String replacedString23 = StringUtils.replacePattern(cuerdasNuevas[i],"23", "U");
           cuerdasNuevas[i] = replacedString23;
                     
           String replacedString24 = StringUtils.replacePattern(cuerdasNuevas[i],"24", "V");
           cuerdasNuevas[i] = replacedString24;
           
           // W, X, Y and Z are free
                                                 
        } 
     return cuerdasNuevas;
   }

    
        public static int convertIntoNumber(String s) {
  
     if(s.equals("H"))
       return 10;
     if(s.equals("I"))
       return 11;
     if(s.equals("J"))
       return 12;
     if(s.equals("K"))
       return 13;
     if(s.equals("L"))
       return 14;
     if(s.equals("M"))
       return 15;
     if(s.equals("N"))
       return 16;
     if(s.equals("O"))
       return 17;
     if(s.equals("P"))
       return 18;
     if(s.equals("Q"))
       return 19;
     if(s.equals("R"))
       return 20;
     if(s.equals("S"))
       return 21;
     if(s.equals("T"))
       return 22;
     if(s.equals("U"))
       return 23;
     if(s.equals("V"))
       return 24;
            
     return 0; 
          
  }  
    
    
    
  
      public static void convertAction(Diapason diap, int chordValue, String before, String X, String after)
    {
      if(X.equals("p"))
         new PullOff();
      if(X.equals("h"))
         new HammerOn(diap, chordValue, before, X, after);
      if(X.equals("/"))
         new SlideUp(); //missing SlideDown because \ is reserved by Java
      if(X.equals("b"))
         new Bend();
      if(X.equals("("))
         System.out.println("Do something");
      if(X.equals("r"))
         System.out.println("Do something"); //Probably ignore it (-) as its called in Bend already
      
    }
   
    
     //Método que revisa si es un número   
    public static boolean checkMe(String s) {
  boolean amIValid = false;
  try {
   Integer.parseInt(s);
  
   amIValid = true;
  } catch (NumberFormatException e) {  return false;}
  return amIValid;
  }  
  
}
