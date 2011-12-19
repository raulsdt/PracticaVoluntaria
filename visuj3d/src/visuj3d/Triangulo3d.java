/*
 * Triangulo3d.java
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
import org.j3d.geom.IntersectionUtils;


public class Triangulo3d {

    /** un triangulo viene definido por tres puntos en el espacio*/
    protected Vector3d a,b,c;
   
    /** Constructor por defecto a valor (0,0) */
    public Triangulo3d() {
        a = new Vector3d ();
        b = new Vector3d ();
        c = new Vector3d ();
    }
    
    /** Constructor a partir de coordenadas de los tres puntos*/
    public Triangulo3d(double ax, double ay, double az,
                       double bx, double by, double bz,
                       double cx, double cy, double cz) {
        a = new Vector3d (ax,ay,az);
        b = new Vector3d (bx,by,bz);
        c = new Vector3d (cx,cy,cz);
    }
        
    /** Constructor copia*/
    public Triangulo3d(Triangulo3d t) {
        a = new Vector3d (t.a);
        b = new Vector3d (t.b);
        c = new Vector3d (t.c);
    }
    
    /** Constructor a partir de tres Vector3d de javax*/
    public Triangulo3d (Vector3d va, Vector3d vb, Vector3d vc){
        a = new Vector3d (va);
        b = new Vector3d (vb);
        c = new Vector3d (vc);
    }
    
    
    /** Constructor a partir de tres Puntos3d*/
    public Triangulo3d (Punto3d va, Punto3d vb, Punto3d vc){
        a = new Vector3d (va.getVector3d());
        b = new Vector3d (vb.getVector3d());
        c = new Vector3d (vc.getVector3d());
    }
    
    /**Obtiene el Punto de a */
    public Punto3d getPuntoA() {
        return new Punto3d(a);
    }
    
    /**Obtiene el Punto de b */
    public Punto3d getPuntoB() {
        return new Punto3d(b);
    }
    
    /**Obtiene el Punto de c */
    public Punto3d getPuntoC() {
        return new Punto3d(c);
    }
    
    /**Obtiene el Vector3d de a */
    public Vector3d getA() {
        return a;
    }
    
    /**Obtiene el Punto b */
    public Vector3d getB() {
        return b;
    }
    
    /**Obtiene el Punto c */
    public Vector3d getC() {
        return c;
    }
    
     /**Devuelve una copia del objeto Punto */
     public Triangulo3d copia(){
         return new Triangulo3d(a,b,c);
     }
     
     /**Modifica el valor de a*/
     public void modificaA(Punto3d pa){
         a = pa.getVector3d();
     }
     
     /**Modifica el valor de b*/
     public void modificaB(Punto3d pb){
         b = pb.getVector3d();
     }
     
     /**Modifica el valor de c*/
     public void modificaC(Punto3d pc){
         c = pc.getVector3d();
     }
     
     /** Interseccion rayo3d-triangulo3d */
     public boolean intersectaRayo3d (Rayo3d r){
         IntersectionUtils iu = new IntersectionUtils ();
         Point3d origen = new Point3d (r.getOrigen().getVector3d());
         Vector3d dir = new Vector3d (r.getDireccion());
         float coordenadas[] = {(float)a.x,(float)a.y,(float)a.z,(float)b.x,(float)b.y,(float)b.z,(float)c.x,(float)c.y,(float)c.z};
         Point3d result = new Point3d();
         return (iu.rayPolygon(origen, dir, 0.0f , coordenadas, 3, result ));    
     }
     
      /**Muestra un punto 3d en pantalla*/
     public void out (){
         System.out.println("Triangulo3d: ("+ a +"-"+ b + "-"+ c +")");
     }
    }
    

