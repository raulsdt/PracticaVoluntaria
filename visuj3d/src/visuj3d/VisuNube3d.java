/*
 * VisuNube3d.java
 *
 * Created on 21 de noviembre de 2006, 16:35
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


public class VisuNube3d extends Vista {
    
    NubePuntos3d vn;
    /** Creates a new instance of VisuPunto */
    public VisuNube3d (NubePuntos3d p) {
        vn = p;
    }
    
    /** funcion privada que obtiene los puntos de la nube y la convierte a coordenadas de pantalla*/
    protected PointArray pintaj3d (float R, float G, float B) throws Exception{
        int np = vn.numPuntos();
        double xp, yp, zp;
        PointArray p = new PointArray(np,PointArray.COORDINATES|PointArray.COLOR_3);
        for (int i = 0; i<np; i++){ 
             xp = convCoordX(vn.getPunto(i).getX());
             yp = convCoordY(vn.getPunto(i).getY());
             zp = convCoordY(vn.getPunto(i).getZ());
             p.setCoordinate (i,new Point3d(xp,yp,zp));
             p.setColor(i,new Color3f(R,G,B));
        }
        return p;
    }   

    /** Pinta la nube en pantalla en color rojo */
    public void pinta (TransformGroup trans, Appearance app) throws Exception{
        PointArray p = this.pintaj3d(1,0,0);
        trans.addChild(new Shape3D(p,app));
    }

    /**Pinta la nube en pantalla eligiendo el color */
    public void pinta (TransformGroup trans, Appearance app, float R, float G, float B) throws Exception{
        PointArray p = this.pintaj3d(R,G,B);
        trans.addChild(new Shape3D(p,app));
    }

}
