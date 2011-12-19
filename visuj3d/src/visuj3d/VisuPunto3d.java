/*
 * VisuPunto3d.java
 *
 * Created on 21 de noviembre de 2006, 15:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visuj3d;

/**
 *
 * @author lidia
 */


import javax.media.j3d.*;
import javax.vecmath.*;


/**
 *
 * @author lidia
 */
public class VisuPunto3d extends Vista {
    
    Punto3d vp;
    /** Crea una nueva instancia de Punto */
    public VisuPunto3d (Punto3d p) {
        vp = p ;
    }
    /** Obtiene el punto */
    public Punto3d getPunto (){
        return vp;
    }
    
    protected  PointArray pintaj3d(float R, float G, float B){
        PointArray p = new PointArray(1,PointArray.COORDINATES|PointArray.COLOR_3);
        double xp = convCoordX (vp.getX());
        double yp = convCoordY (vp.getY());
        double zp = convCoordZ (vp.getZ());
        p.setCoordinate (0,new Point3d(xp,yp,zp));
        p.setColor(0,new Color3f(R,G,B));
        return p;
    }     
    
    /** Pinta un punto en color amarillo */   
    public void pinta (TransformGroup trans, Appearance app){
        PointArray p = this.pintaj3d(1f, 1f,0f);
        trans.addChild(new Shape3D(p,app));
    }
    
    /** Pinta un punto en color RGB */
    public void pinta (TransformGroup trans, Appearance app, float R, float G, float B){
        PointArray p = this.pintaj3d(R, G, B);
        trans.addChild(new Shape3D(p,app));
    }
    
}

