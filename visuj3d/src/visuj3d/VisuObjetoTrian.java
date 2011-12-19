/*
 * VisuObjetoTrian.java
 *
 * Created on 30 de noviembre de 2006, 15:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visuj3d;


import javax.media.j3d.*;
import javax.vecmath.*;

/**
 *
 * @author lidia
 */

public class VisuObjetoTrian extends Vista {
    
    ObjetoTrian ot;
    
    /** Constructor de VisuObjetoTrian */
    public VisuObjetoTrian (ObjetoTrian p) {
        ot = p;
    }
      
    /** pinta el objeto en pantalla */
    public void pinta (TransformGroup trans, Appearance app) throws Exception{
        trans.addChild(new Shape3D (ot.ta,app));  
              
    }


}
