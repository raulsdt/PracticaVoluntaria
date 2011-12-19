/*
 * Segmento3d.java
 *
 * Created on 21 de noviembre de 2006, 16:03
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

public class Segmento3d {
    
    protected Vector3d a,b;
    
    /** Constructor por defecto; a continuación modificar su contenido*/ 
    public Segmento3d() {
       a = new Vector3d(); b = new Vector3d();
    }
    
    /** Constructor a partir de dos puntos extremos*/ 
    public Segmento3d(Punto3d pa, Punto3d pb) {
        a = new Vector3d(pa.p); 
        b = new Vector3d(pb.p);
    }
    
    /** Constructor a partir de las coordenadas (ax,ay,az) (bx,by,bz)*/ 
    public Segmento3d(double ax, double ay, double az, double bx, double by, double bz) {
        a = new Vector3d(ax, ay, az);
        b = new Vector3d(bx, by, bz);
    }
    
    /** Constructor a partir de dos puntos Vector3d*/ 
    public Segmento3d(Vector3d pa, Vector3d pb) {
        a = new Vector3d (pa);
        b = new Vector3d (pb);
    }
    
    
    /** Constructor copia*/
    public Segmento3d (Segmento3d seg){
        a = new Vector3d (seg.a);
        b = new Vector3d (seg.b);
    } 
    
     /** Constructor a partir de un segmento 2D (z=0)*/
    public Segmento3d (Segmento seg){
        a = new Vector3d (seg.getAX(), seg.getAY(), 0.0);
        b = new Vector3d (seg.getBX(), seg.getBY(), 0.0);
    } 
    
    
    /**Obtiene el punto a del segmento*/
    public Punto3d getA(){
        return new Punto3d(a);
    }
    
    /**Obtiene el punto b del segmento*/
    public Punto3d getB(){
        return new Punto3d(b);
    }
    
    /**Obtiene la x del punto a*/
     public double getAX(){
        return a.x;
    }
     
     /**Obtiene la y del punto a*/
     public double getAY(){
        return a.y;
    }
     
    /**Obtiene la z del punto a*/
     public double getAZ(){
        return a.z;
    }
     
    /**Obtiene la x del punto b*/
     public double getBX(){
        return b.x;
    }
     
     /**Obtiene la y del punto b*/
     public double getBY(){
        return b.y;
    }
     
    /**Obtiene la x del punto b*/
     public double getBZ(){
        return b.z;
    }

    /**Obtiene un nuevo segmento copia de this*/
    public Segmento3d copia (){
        return new Segmento3d(a,b);
    }
    
    /**Modifica las coordenadas de ambos extremos del segmento*/
    public void modifica (Punto3d pa, Punto3d pb){
        a = pa.getVector3d();
        b = pb.getVector3d();
    }
    
    /**Obtiene la longitud del segmento*/
    public double longitud (){
        Vector3d c = new Vector3d();
        c.sub(b,a);
        return c.length();
    }
    
    /**Muestra el segmento por pantalla*/
    public void out (){
        System.out.println("Segmento: ("+ a+"-"+b+")");
    }
    
   
    
}
