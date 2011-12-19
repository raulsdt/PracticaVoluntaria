/*
 * Rayo.java
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

public class Rayo {

    /** origen es el origen del rayo */
    /** q es otro punto cualquiera del rayo*/
    protected Vector2d origen, q;
    
    /** Constructor por defecto; a continuación modificar su contenido*/ 
    public Rayo() {
       origen = new Vector2d(); q = new Vector2d();
    }
    
    /** Constructor a partir de dos puntos, el primero siempre el origen*/ 
    public Rayo(Punto ori, Punto pq) {
        origen = new Vector2d(ori.p); 
        q = new Vector2d(pq.p);
    }
    
    /** Constructor a partir de las coordenadas origen(ax,ay) q(bx,by)*/ 
    public Rayo(double ax, double ay, double bx, double by) {
        origen = new Vector2d(ax, ay);
        q = new Vector2d(bx, by);
    }
    
    /** Constructor a partir de dos puntos Vector2d*/ 
    public Rayo(Vector2d ori, Vector2d pq) {
        origen = new Vector2d (ori);
        q   = new Vector2d (pq);
    }
    
    /** Constructor a partir de un punto origen y una direccion d*/
    public Rayo (Punto ori, Vector2d d){
        origen = new Vector2d (ori.p);
        q.add(d, origen);
    }
    
    
    /** Constructor copia*/
    public Rayo (Rayo r){
        origen = new Vector2d (r.origen);
        q = new Vector2d (r.q);
    } 
    
    /** devuelve la dirección del rayo; d=q-origen*/
    public Vector2d getDireccion(){
        Vector2d c = new Vector2d();
        c.sub(q, origen);
        return c;
    }
    
    /**Obtiene el origen del rayo*/
    public Punto getOrigen(){
        return new Punto(origen);
    }
    
    /**Obtiene el punto q del rayo*/
    public Punto getQ(){
        return new Punto(q);
    }
    
    /**Obtiene la x del origen*/
     public double getOrigenX(){
        return origen.x;
    }
     
     /**Obtiene la y del origen*/
     public double getOrigenY(){
        return origen.y;
    }

     /**Obtiene la x de q*/
     public double getQX(){
        return q.x;
    }
     
     /**Obtiene la y de q*/
     public double getBY(){
        return q.y;
    }
     
    /**Obtiene un nuevo rayo copia de this*/
    public Rayo copia (){
        return new Rayo(origen, q);
    }
    
    /**Modifica las coordenadas del origen*/
    public void modificaOrigen (Punto ori){
        origen = ori.getVector2d();
    }
    
    /**Modifica las coordenadas de q*/
    public void modificaQ (Punto pq){
        q = pq.getVector2d();
    }
    
    /**Muestra el rayo por pantalla*/
    public void out (){
        System.out.println("Rayo: ("+ origen+"-"+q+")");
    }
    
}
