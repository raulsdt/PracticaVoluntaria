/*
 * VisuRayo3d.java
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


public class VisuRayo3d extends Vista {
    
    Rayo3d vr;
    /** Creates a new instance of VisuPunto */
    public VisuRayo3d (Rayo3d s) {
        vr = s;
    }
    
    /**Devuelve el Rayo3d */
     public Rayo3d getRayo3d (){
        return vr;
    }
    
    /** Convierte las coordenadas del rayo (del segmento en realidad) y las convierta a coordenadas de pantalla*/ 
    protected LineArray pintaj3d(float R, float G, float B){
        double oy = convCoordY(vr.getOrigenY());
        double ox = convCoordX(vr.getOrigenX());
        double oz = convCoordZ(vr.getOrigenZ());
        double qy = convCoordY(vr.getQY());
        double qx = convCoordX(vr.getQX());
        double qz = convCoordZ(vr.getQZ());
        LineArray sg = new LineArray (2,LineArray.COORDINATES|LineArray.COLOR_3);
           sg.setCoordinate(0,new Point3d(ox,oy,oz));
           sg.setCoordinate(1,new Point3d(qx,qy,qz));
           sg.setColor(0,new Color3f(R,G,B));
           sg.setColor(1,new Color3f(R,G,B));
        return sg;   
    } 
 
    /** Pinta el rayo en color magenta */
    public void pinta (TransformGroup trans, Appearance app){
        LineArray sg=this.pintaj3d(1f, 0f, 1f);
        trans.addChild(new Shape3D(sg,app));
    }
      
    /** Pinta un segmento en color RGB */
    public void pinta (TransformGroup trans, Appearance app, float R, float G, float B){
        LineArray sg=this.pintaj3d(R,G,B);
        trans.addChild(new Shape3D(sg,app));
    }
}

