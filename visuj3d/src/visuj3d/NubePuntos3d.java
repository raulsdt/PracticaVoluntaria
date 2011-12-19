/*
 * NubePuntos3d.java
 *
 * Created on 21 de noviembre de 2006, 16:28
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

import javax.media.j3d.PointArray;
import javax.vecmath.Vector3d;
import javax.vecmath.Point3d;
import javax.vecmath.Color3f;
import javax.media.j3d.BoundingPolytope;



class ErrorNubeInvalida extends Exception {}
class ErrorRangoNubeInvalido extends Exception{}
class ErrorNubeNoCerrada extends Exception{}
class ErrorNubeCerrada extends Exception{}

public class NubePuntos3d {
     protected PointArray nube;  /** la nube de puntos de j3d*/
     protected int nPuntos; /** numero de puntos de la nube*/
     protected int formato; /** formato por defecto: puntos con color */
     protected Color3f color;
     private int tamalog;
     
    /** Constructor por defecto para un tamanio; la nube no esta cerrada; deben aniadirse tama puntos*/
    public NubePuntos3d(int tama) {
        nPuntos = tama;     /** Tamanio final de la nube de puntos*/
        formato = PointArray.COORDINATES | PointArray.COLOR_3; /**apariencia*/
        nube = new PointArray(tama,formato); /** coordenadas de la nube*/
        color = new Color3f(1f, 1f, 1f); /**color de la nube*/
        tamalog = 0;  /**tamanio mientras se construye la nube de forma incremental*/
    }
    
    /** Constructor por defecto para un tamanio y un color dado; la nube no esta cerrada, debe aniadirse puntos con addPunto*/
    public NubePuntos3d(int tama, Color3f c) {
        nPuntos = tama;
        formato = PointArray.COORDINATES | PointArray.COLOR_3; 
        nube = new PointArray(tama,formato);
        color = new Color3f(c);
        tamalog = 0;
    }
        
    /** Aniade una una nueva coordenada al final; la nube no es valida hasta que este valor no llega a nPuntos */
    public void addPunto (Punto3d p) throws ErrorNubeCerrada {
      try { 
        if (nPuntos == tamalog) throw new ErrorNubeCerrada();  
        Point3d c = new Point3d (p.getX(), p.getY(), p.getZ());
        nube.setCoordinate(tamalog, c);
        nube.setColor(tamalog, color);
        tamalog+=1;
      }  catch (Exception e){
          
      }  
    }  
    
    /** Indica si la nube esta bien construida*/    
    boolean nubeValida (){
        return nPuntos == tamalog;
    }
 
    /**Construye una nube a partir de un vector de Puntos3d*/
    public NubePuntos3d (Punto3d[] np){
        nPuntos = tamalog = np.length;
        formato = PointArray.COORDINATES | PointArray.COLOR_3; 
        color = new Color3f(1f, 1f, 1f);
        for (int i = 0; i<nPuntos; i++){
            nube.setCoordinate(i, new Point3d (np[i].getX(),np[i].getY(),np[i].getZ()));
            nube.setColor(i,color);
        }
    }
    
    /**Constructor copia*/
    public NubePuntos3d (NubePuntos3d np) {
        nPuntos = np.nPuntos;
        formato = np.formato;
        color = new Color3f (np.color);
        nube = np.nube;
        tamalog = np.tamalog;
    }
    
    /**Dice el numero de puntos*/
    public int numPuntos(){
        return nPuntos;
    }
    
    /**Dice el color de los puntos*/
    public Color3f getColor(){
        return color;
    }
    
    /**Obtiene el punto del poligon de la posicion indice*/
    public Punto3d getPunto (int indice) throws ErrorRangoNubeInvalido{
        Punto3d p = null;
        try{
            Point3d c = new Point3d();
            nube.getCoordinate(indice,c);
            p =  new Punto3d (c.x,c.y,c.z);      
        } catch (Exception e) {
            throw new ErrorRangoNubeInvalido(); 
        }
        return p;
    }
    
        
    /** Cambia una una nueva coordenada en la posicion i; la nube no es valida hasta que este valor no llega a nPuntos */
    public void setPunto (Punto3d p, int pos) throws ErrorRangoNubeInvalido, ErrorNubeNoCerrada{
      try{
        if (pos < 0 || pos > nPuntos) throw new ErrorRangoNubeInvalido();
        if (tamalog != nPuntos) throw new ErrorNubeNoCerrada();
        Point3d c = new Point3d (p.getX(), p.getY(), p.getZ());
        nube.setCoordinate(pos, c);
        nube.setColor(pos, color);
      } catch (Exception e){
          
      }  
    }  

    /** Construye la envolvente convexa en 3d */
    /**
    public BoundingPolytope envolventeConvexa (){
        BoundingPolytope bp = new BoundingPolytope ();
        Point3d p = new Point3d();
        for (int i=0; i<nPuntos; i++){
            nube.getCoordinate(i,p);
            bp.combine(p);
        }
        return bp;
    }
    */
    
    /**Visualiza el poligono en pantalla*/
    public void out(){
        System.out.println("NubePuntos:"+nube);
    }

}