/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visuj3d;

import javax.media.j3d.LineArray;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
 *
 * @author raul
 */
public class VisuCajaEnvolvente extends Vista{
    
    CajaEnvolvente a;
    
    public VisuCajaEnvolvente(CajaEnvolvente e){
        a = e;
    }
    
    protected LineStripArray pintaj3d(float R, float G, float B){
        double miny = convCoordY(a.infIzq.getY());
        double minx = convCoordX(a.infIzq.getX());
        double minz = convCoordZ(a.infIzq.getZ());
        double maxy = convCoordY(a.supDer.getY());
        double maxx = convCoordX(a.supDer.getX());
        double maxz = convCoordZ(a.supDer.getZ());
        int[] vertices = {8};
        LineStripArray st = new LineStripArray (4,LineStripArray.COORDINATES|LineStripArray.COLOR_3,vertices);
           st.setCoordinate(0,new Point3d(maxx,maxy,maxz));
           st.setCoordinate(1,new Point3d(maxx,miny,maxz));
           st.setCoordinate(2,new Point3d(minx,miny,maxz));
           st.setCoordinate(3,new Point3d(minx,maxy,maxz));
           st.setCoordinate(4,new Point3d(maxx,maxy,minz));
           st.setCoordinate(5,new Point3d(maxx,miny,minz));
           st.setCoordinate(6,new Point3d(minx,miny,minz));
           st.setCoordinate(7,new Point3d(minx,maxy,minz));
           st.setColor(0,new Color3f(R,G,B));
           st.setColor(1,new Color3f(R,G,B));
           st.setColor(2,new Color3f(R,G,B));
           st.setColor(3,new Color3f(R,G,B));
           st.setColor(4,new Color3f(R,G,B));
           st.setColor(5,new Color3f(R,G,B));
           st.setColor(6,new Color3f(R,G,B));
           st.setColor(7,new Color3f(R,G,B));
        return st;   
    } 
    
    @Override
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
