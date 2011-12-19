/*
 * Segmento.java
 *
 * Created on 13 de noviembre de 2006, 12:21
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

import javax.vecmath.Vector2d;
import javax.vecmath.Point2d;

public class Segmento {

    protected Vector2d a,b;
    
    /** Constructor por defecto; a continuación modificar su contenido*/ 
    public Segmento() {
       a = new Vector2d(); b = new Vector2d();
    }
    
    /** Constructor a partir de dos puntos extremos*/ 
    public Segmento(Punto pa, Punto pb) {
        a = new Vector2d(pa.p); 
        b = new Vector2d(pb.p);
    }
    
    /** Constructor a partir de las coordenadas (ax,ay) (bx,by)*/ 
    public Segmento(double ax, double ay, double bx, double by) {
        a = new Vector2d(ax, ay);
        b = new Vector2d(bx, by);
    }
    
    /** Constructor a partir de dos puntos Vector3d*/ 
    public Segmento(Vector2d pa, Vector2d pb) {
        a = new Vector2d (pa);
        b = new Vector2d (pb);
    }
    
    
    /** Constructor copia*/
    public Segmento (Segmento seg){
        a = new Vector2d (seg.a);
        b = new Vector2d (seg.b);
    } 
    
    /**Obtiene el punto a del segmento*/
    public Punto getA(){
        return new Punto(a);
    }
    
    /**Obtiene el punto b del segmento*/
    public Punto getB(){
        return new Punto(b);
    }
    
    /**Obtiene la x del punto a*/
     public double getAX(){
        return a.x;
    }
     
     /**Obtiene la y del punto a*/
     public double getAY(){
        return a.y;
    }

     /**Obtiene la x del punto b*/
     public double getBX(){
        return b.x;
    }
     
     /**Obtiene la y del punto b*/
     public double getBY(){
        return b.y;
    }
     
    /**Obtiene un nuevo segmento copia de this*/
    public Segmento copia (){
        return new Segmento(a,b);
    }
    
    /**Modifica las coordenadas de ambos extremos del segmento*/
    public void modifica (Punto pa, Punto pb){
        a = pa.getVector2d();
        b = pb.getVector2d();
    }
    
    /**Obtiene la longitud del segmento*/
    public double longitud (){
        Point2d pa = new Point2d (a.x, a.y);
        Point2d pb = new Point2d (b.x, b.y);
        return pa.distance(pb);
    }
    
    /**Muestra el segmento por pantalla*/
    public void out (){
        System.out.println("Segmento: ("+ a +"-"+b+")");
    }
    
}
