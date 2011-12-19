/*
 * Rayo3d.java
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

public class Rayo3d {
    
    /** origen es el origen del rayo */
    /** q es otro punto cualquiera */
    
    protected Vector3d origen,q;
    
    
    /** Constructor por defecto; a continuación modificar su contenido*/ 
    public Rayo3d() {
       origen = new Vector3d(); q = new Vector3d();
    }
    
    /** Constructor a partir de dos puntos, el primero siempre el origen*/ 
    public Rayo3d(Punto3d ori, Punto3d pq) {
        origen = new Vector3d(ori.p); 
        q = new Vector3d(pq.p);
    }
    
    /** Constructor a partir de las coordenadas origen(ax,ay) q(bx,by)*/ 
    public Rayo3d(double ax, double ay, double az, double bx, double by, double bz) {
        origen = new Vector3d(ax, ay, az);
        q = new Vector3d(bx, by, bz);
    }
    
    /** Constructor a partir de dos puntos Vector3d*/ 
    public Rayo3d(Vector3d ori, Vector3d pq) {
        origen = new Vector3d (ori);
        q   = new Vector3d (pq);
    }
    
    /** Constructor a partir de un punto origen y una direccion d=q-origen*/
    public Rayo3d (Punto3d ori, Vector3d d){
        origen = new Vector3d (ori.p);
        q.add(d, origen);
    }
    
    
    /** Constructor copia*/
    public Rayo3d (Rayo3d r){
        origen = new Vector3d (r.origen);
        q = new Vector3d (r.q);
    } 
    
    /** devuelve la dirección del rayo; d=q-origen*/
    public Vector3d getDireccion(){
        Vector3d c = new Vector3d();
        c.sub(q, origen);
        return c;
    }
    
    /**Obtiene el origen del rayo*/
    public Punto3d getOrigen(){
        return new Punto3d(origen);
    }
    
    /**Obtiene el punto q del rayo*/
    public Punto3d getQ(){
        return new Punto3d(q);
    }
    
    /**Obtiene la x del origen*/
     public double getOrigenX(){
        return origen.x;
    }
     
     /**Obtiene la y del origen*/
     public double getOrigenY(){
        return origen.y;
    }
     
     /**Obtiene la z del origen*/
     public double getOrigenZ(){
        return origen.z;
    }

     /**Obtiene la x de q*/
     public double getQX(){
        return q.x;
    }
     
     /**Obtiene la y de q*/
     public double getQY(){
        return q.y;
    }
     
    /**Obtiene la z de q*/
     public double getQZ(){
        return q.z;
    }
     
    /**Obtiene un nuevo rayo copia de this*/
    public Rayo3d copia (){
        return new Rayo3d(origen, q);
    }
    
    /**Modifica las coordenadas del origen*/
    public void modificaOrigen (Punto3d ori){
        origen = ori.getVector3d();
    }
    
    /**Modifica las coordenadas de q*/
    public void modificaQ (Punto3d pq){
        q = pq.getVector3d();
    }
    
    /**Muestra el rayo por pantalla*/
    public void out (){
        System.out.println("Rayo3d: ("+ origen+"-"+q+")");
    }
    

}
