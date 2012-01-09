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
        double miny = a.infIzq.getY();
        double minx = a.infIzq.getX();
        double minz = a.infIzq.getZ();
        double maxy = a.supDer.getY();
        double maxx = a.supDer.getX();
        double maxz = a.supDer.getZ();
        
        int[] vertices = {16};
        LineStripArray st = new LineStripArray (16,LineStripArray.COORDINATES|LineStripArray.COLOR_3,vertices);
           //Cara delantera
           st.setCoordinate(0,new Point3d(maxx,maxy,maxz));
           st.setCoordinate(1,new Point3d(maxx,miny,maxz));
           st.setCoordinate(2,new Point3d(minx,miny,maxz));
           st.setCoordinate(3,new Point3d(minx,maxy,maxz));
           st.setCoordinate(4,new Point3d(maxx,maxy,maxz));
           //Cara trasera
           st.setCoordinate(5,new Point3d(maxx,maxy,minz));
           st.setCoordinate(6,new Point3d(maxx,miny,minz));
           st.setCoordinate(7,new Point3d(maxx,miny,maxz));
            st.setCoordinate(8,new Point3d(maxx,miny,minz));
           st.setCoordinate(9,new Point3d(minx,miny,minz));
           st.setCoordinate(10,new Point3d(minx,miny,maxz));
           st.setCoordinate(11,new Point3d(minx,miny,minz));
           st.setCoordinate(12,new Point3d(minx,maxy,minz));
           st.setCoordinate(13,new Point3d(minx,maxy,maxz));
           st.setCoordinate(14,new Point3d(minx,maxy,minz));
           st.setCoordinate(15,new Point3d(maxx,maxy,minz));
           
           //Cara derecha
//           st.setCoordinate(10,new Point3d(maxx,miny,maxz));
//           st.setCoordinate(11,new Point3d(maxx,maxy,maxz));
//           st.setCoordinate(12,new Point3d(maxx,maxy,minz));
//           st.setCoordinate(13,new Point3d(maxx,miny,minz));
//           st.setCoordinate(14,new Point3d(maxx,miny,maxz));
           
        
           for(int i = 0;i <16;i++){
               st.setColor(i,new Color3f(R,G,B));
           }
        return st;   
    } 
    

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
