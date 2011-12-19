/*
 * Punto3d.java
 *
 * Created on 21 de noviembre de 2006, 15:42
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

import javax.vecmath.Vector3d;
import javax.vecmath.Point3d;



public class Punto3d {

    /** un punto de la libreria  javax  con precision double*/
    protected Vector3d p;

    
    /** Constructor por defecto a valor (0,0) */
    public Punto3d() {
        p = new Vector3d ();
    }
    
    /** Constructor a partir de coordenadas x,y,z*/
    public Punto3d(double x, double y, double z) {
        p = new Vector3d (x,y,z);
    }
    
    /** Constructor a partir de un Punto y una coordenada z*/
    public Punto3d(Punto pp, double z) {
        p = new Vector3d(pp.getX(), pp.getY(), z);
    }

    /** Devuelve el Vector3d de javax */
    public Vector3d getVector3d(){
        return p;
    }
    
    /** Constructor copia*/
    public Punto3d(Punto3d pp) {
        p = new Vector3d (pp.p);
    }
    
    /** Constructor a partir de un Vector3d de javax*/
    public Punto3d (Vector3d pp){
        p = new Vector3d (pp);
    }
    
    /** Constructor a partir de un Point3d de javax*/
    public Punto3d (Point3d pp){
        p = new Vector3d (pp.x, pp.y, pp.z);
    }
    
    /** Constructor a partir de un Punto 2D (z=0)*/
    public Punto3d (Punto pp){
        p = new Vector3d(pp.getX(), pp.getY(), 0.0);
    }
    
    /**Obtiene la coordenada x */
    public double getX() {
        return p.x;
    }
    
    /**Obtiene la coordenada y */
     public double getY() {
        return p.y;
     }
     
     /**Obtiene la coordenada z */
     public double getZ() {
        return p.z;
     }
     
     /**Devuelve una copia del objeto Punto */
     public Punto3d copia(){
         return new Punto3d(p);
     }
     
     /** Modifica las coordenadas del punto */
     public void modifica (double x, double y, double z){
         p.set(x, y, z);
     }
     
     /**Traslada las coordenadas x e y un desplazamiento dx dy*/
     public void translada (double dx, double dy, double dz){ 
        p.x+=dx; p.y+=dy; p.z+=dz;
     }
     
      /**Muestra un punto 3d en pantalla*/
     public void out (){
         System.out.println("Punto3d: ("+ p+")");
     }
    }
    

