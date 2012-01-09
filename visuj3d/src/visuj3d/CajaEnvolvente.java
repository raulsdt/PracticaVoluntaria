/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visuj3d;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Shape3D;
import javax.vecmath.Point3d;

/**
 *
 * @author raul
 */
public class CajaEnvolvente {

    Punto3d supDer; // Punto superior Derecho que define la caja
    Punto3d infIzq; // Punto inferior izquierda que define la caja

    public CajaEnvolvente(Punto3d s, Punto3d i) {
        supDer = new Punto3d(s);
        infIzq = new Punto3d(i);
    }

    public CajaEnvolvente(ObjetoTrian ot) throws ErrorRangoObjInvalido {
        supDer = new Punto3d(ot.getCajaEnvolvente().supDer);
        infIzq = new Punto3d(ot.getCajaEnvolvente().infIzq);
    }

    public CajaEnvolvente(String camino)throws ErrorRangoObjInvalido {

        ObjetoTrian ot = new ObjetoTrian(camino);
        supDer = ot.getCajaEnvolvente().supDer;
        infIzq = ot.getCajaEnvolvente().infIzq;
        
    }

    public CajaEnvolvente(NubePuntos3d n) throws ErrorRangoNubeInvalido {
        float minZ = 900, minY = 900, minX = 900;
        float maxZ = 0, maxY = 0, maxX = 0;
        float array[] = new float[6];

        for (int j = 0; j < n.nPuntos; j++) {

            Punto3d punto3d = new Punto3d(n.getPunto(j));
            if (minX > (float) punto3d.getX()) {
                minX = (float) punto3d.getX();
            }
            if (maxX < (float) punto3d.getX()) {
                maxX = (float) punto3d.getX();
            }
            if (minY > (float) punto3d.getY()) {
                minY = (float) punto3d.getY();
            }
            if (maxY < (float) punto3d.getY()) {
                maxY = (float) punto3d.getY();
            }
            if (minZ > (float) punto3d.getZ()) {
                minZ = (float) punto3d.getZ();
            }
            if (maxZ < (float) punto3d.getZ()) {
                maxZ = (float) punto3d.getZ();
            }

        }

        infIzq = new Punto3d(minX, minY, minZ);
        supDer = new Punto3d(maxX, maxY, maxZ);


    }
    /**
     * Devuelve el punto minimo d ela caja envolvente
     * @return  Punto minimo
     */
    public Punto3d getMinimo() {
        return infIzq;
    }
    /**
     * Devuelve el punto maximo que define la caja envolvente
     * @return PUnto Maximo
     */
    public Punto3d getMaximo() {
        return supDer;
    }

    /**
     * Comprueba si existe intersección entre dos cajas envolventes
     * @param ce Caja envolvente a la que le qyueremos comprobar la intersección
     * @return True si se produce intersección, y false en cualquier otro caso.
     */
    public boolean intersecta(CajaEnvolvente ce) {
        BoundingBox cajaClase = new BoundingBox(new Point3d(infIzq.getX(), infIzq.getY(), infIzq.getZ()), 
                new Point3d(supDer.getX(), supDer.getY(), supDer.getZ()) );
        
        BoundingBox cajaCe = new BoundingBox(new Point3d(ce.infIzq.getX(), ce.infIzq.getY(), ce.infIzq.getZ()), 
                new Point3d(ce.supDer.getX(), ce.supDer.getY(), ce.supDer.getZ()) );
        
        return cajaCe.intersect(cajaClase);
    }
}
