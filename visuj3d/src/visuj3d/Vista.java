/*
 * vista.java
 *
 * Created on 11 de octubre de 2006, 20:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visuj3d;

//import java.awt.Graphics;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
 *
 * @author lidia
 */


public abstract class Vista {
   
  static double  ANCHO_PUNTO=0.02;
  
  public double convCoordX (double x) {
      return (x/(Geometria.RANGO)); 
  }
  
  public double convCoordY (double y) {
     return (y/(Geometria.RANGO)); 
  }
  
   public double convCoordZ (double z) {
     return (z/(Geometria.RANGO)); 
  }
    
    /** primitiva abstracta */
    
    public abstract void pinta(TransformGroup trans, Appearance app) throws Exception;
}
