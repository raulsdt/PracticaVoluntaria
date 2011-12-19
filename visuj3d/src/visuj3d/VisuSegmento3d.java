/*
 * VisuSegmento3d.java
 *
 * Created on 21 de noviembre de 2006, 16:17
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


public class VisuSegmento3d extends Vista {
    
    Segmento3d vs;
    /** Creates a new instance of VisuPunto */
    public VisuSegmento3d (Segmento3d s) {
        vs = s;
    }
    
    /**Obtiene el Segmento3d *(
     public Segmento3d getLineSegment (){
        return vs;
    }
    
    /** Convierte las coordenadas el segmento a coordenadas de pantalla */
    protected LineArray pintaj3d(float R, float G, float B){
        double sy = convCoordY(vs.getAY());
        double sx = convCoordX(vs.getAX());
        double sz = convCoordZ(vs.getAZ());
        double iy = convCoordY(vs.getBY());
        double ix = convCoordX(vs.getBX());
        double iz = convCoordZ(vs.getBZ());
        LineArray sg = new LineArray (2,LineArray.COORDINATES|LineArray.COLOR_3);
           sg.setCoordinate(0,new Point3d(sx,sy,sz));
           sg.setCoordinate(1,new Point3d(ix,iy,iz));
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

