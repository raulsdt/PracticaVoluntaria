/*
 * VisuTriangulo3d.java
 *
 * Created on 30 de noviembre de 2006, 11:29
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

import javax.media.j3d.LineStripArray;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Appearance;
import javax.media.j3d.Shape3D;
import javax.vecmath.Point3d;
import javax.vecmath.Color3f;


/**
 *
 * @author lidia
 */
public class VisuTriangulo3d extends Vista {
    
    Triangulo3d vt;
    /**Constructor de VisuTriangulo */
    public VisuTriangulo3d (Triangulo3d t) {
        vt = t;
    }
    
    /** Obtiene el Triangulo3d*/
     public Triangulo3d getTriangulo3d (){
        return vt;
    }
    
    /** Convierte el triangulo a posiciones de pantalla */
    protected LineStripArray pintaj3d(float R, float G, float B){
        Punto3d a = vt.getPuntoA();
        Punto3d b = vt.getPuntoB();
        Punto3d c = vt.getPuntoC();
        
        double ay = convCoordY(a.getY());
        double ax = convCoordX(a.getX());
        double az = convCoordZ(a.getZ());
        double by = convCoordY(b.getY());
        double bx = convCoordX(b.getX());
        double bz = convCoordZ(b.getZ());
        double cy = convCoordY(c.getY());
        double cx = convCoordX(c.getX());
        double cz = convCoordZ(c.getZ());
        int[] vertices = {4};
        LineStripArray st = new LineStripArray (4,LineStripArray.COORDINATES|LineStripArray.COLOR_3,vertices);
           st.setCoordinate(0,new Point3d(ax,ay,az));
           st.setCoordinate(1,new Point3d(bx,by,bz));
           st.setCoordinate(2,new Point3d(cx,cy,cz));
           st.setCoordinate(3,new Point3d(ax,ay,az));
           st.setColor(0,new Color3f(R,G,B));
           st.setColor(1,new Color3f(R,G,B));
           st.setColor(2,new Color3f(R,G,B));
           st.setColor(3,new Color3f(R,G,B));
        return st;   
    } 
 
    /** Pinta un Triangulo3d en color amarillo */
    public void pinta (TransformGroup trans, Appearance app){
        LineStripArray sg=this.pintaj3d(0f, 1f, 1f);
        trans.addChild(new Shape3D(sg,app));
    }
      
    /** Pinta un Triangulo3d en color RGB */
    public void pinta (TransformGroup trans, Appearance app, float R, float G, float B){
        LineStripArray sg=this.pintaj3d(R,G,B);
        trans.addChild(new Shape3D(sg,app));
    }

}    