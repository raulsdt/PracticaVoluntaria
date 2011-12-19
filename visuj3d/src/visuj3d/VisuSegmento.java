/*
 * VisuSegmento.java
 *
 * Created on 11 de octubre de 2006, 20:26
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


public class VisuSegmento extends Vista {
    
    Segmento vs;
    /** Creates a new instance of VisuPunto */
    public VisuSegmento (Segmento s) {
        vs = s;
    }
    
    /**Obtiene el Segmento */
     public Segmento getLineSegment (){
        return vs;
    }
    
    /** Convierte el vector a coordenadas de pantalla */ 
    protected LineArray pintaj3d(float R, float G, float B){
        double sy = convCoordY(vs.getAY());
        double sx = convCoordX(vs.getAX());
        double iy = convCoordY(vs.getBY());
        double ix = convCoordX(vs.getBX());
        LineArray sg = new LineArray (2,LineArray.COORDINATES|LineArray.COLOR_3);
           sg.setCoordinate(0,new Point3d(sx,sy,0.0d));
           sg.setCoordinate(1,new Point3d(ix, iy, 0.0d));
           sg.setColor(0,new Color3f(R,G,B));
           sg.setColor(1,new Color3f(R,G,B));
        return sg;   
    } 
 
    /** Pinta un segmento en color verde */
    public void pinta (TransformGroup trans, Appearance app){
        LineArray sg=this.pintaj3d(0f, 1f, 0f);
        trans.addChild(new Shape3D(sg,app));
    }
      
    /** Pinta un segmento en color RGB */
    public void pinta (TransformGroup trans, Appearance app, float R, float G, float B){
        LineArray sg=this.pintaj3d(R,G,B);
        trans.addChild(new Shape3D(sg,app));
    }
}

