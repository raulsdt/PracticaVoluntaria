/*
 * Punto.java
 *
 * Created on 13 de noviembre de 2006, 11:13
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


public class Punto {
    /** un vector 2D de la javax.vecmath */
    protected  Vector2d p;

    /** Constructor por defecto a valor (0,0) */
    public Punto() {
        p = new Vector2d();
    }
    /** Constructor a partir de coordenadas x,y*/
    public Punto(double x, double y) {
        p = new Vector2d(x,y);
    }
    /** Constructor copia*/
    public Punto(Punto pp) {
        p = new Vector2d (pp.getVector2d());
    }
    /** Constructor a partir de un Vector2d de javax.vecmath*/
    public Punto (Vector2d pp){
        p = new Vector2d (pp);
    }
    
    /**Obtiene el Vector2d */
    public Vector2d getVector2d(){
        return p;
    }
    
    /**Obtiene la coordenada x */
    public double getX() {
        return p.x;
    }
    /**Obtiene la coordenada y */
     public double getY() {
        return p.y;
     }
     /**Devuelve una copia del objeto Punto */
     public Punto copia(){
         return new Punto(p);
     }
     /**Traslada las coordenadas x e y un desplazamiento dx dy*/
     public void translada (double dx, double dy){ 
        p.x+=dx; p.y+=dy;
     }
     /**Girar 90 grados positivos */
     public void rota90Pos (){ 
        double aux = p.x;
        p.x = -p.y; 
        p.y = aux;
     }
     /**Mostrar en Pantalla*/
     public void out (){
         System.out.println("Punto:"+p+")");
     }
     
}
