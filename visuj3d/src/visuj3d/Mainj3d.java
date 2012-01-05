package visuj3d;


/**
 *
 * @author lidia
 */

import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import java.util.Random;


//import com.sun.j3d.utils.behaviors.picking.Intersect;

public class Mainj3d extends Applet {

  /**Constructor de la aplicacion */  
  public Mainj3d() throws Exception {
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas = new Canvas3D(config);
    this.setLayout(new BorderLayout());
    this.add(canvas, BorderLayout.CENTER);

    SimpleUniverse universe = new SimpleUniverse(canvas);
    universe.getViewingPlatform().setNominalViewingTransform();

    BranchGroup scene = createSceneGraph();

    universe.addBranchGraph(scene);
  }

  
  /**Define el grafo de escena con capacidad de rotacion, traslacion y zoom*/
  private BranchGroup createSceneGraph() throws Exception {
    BranchGroup objRoot = new BranchGroup();
    
    TransformGroup trans = new TransformGroup();
    trans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

    BoundingSphere bounds = new BoundingSphere(new Point3d(), 100.0);
    
    MouseRotate rotator = new MouseRotate(trans);
    rotator.setSchedulingBounds(bounds);
    objRoot.addChild(rotator);
    
    MouseTranslate translator = new MouseTranslate(trans);
    translator.setSchedulingBounds(bounds);
    objRoot.addChild(translator);
    
    MouseZoom zoomer = new MouseZoom(trans);
    zoomer.setSchedulingBounds(bounds);
    objRoot.addChild(zoomer);

    pintar3D (trans);

    objRoot.addChild(trans);
    objRoot.compile();   
    return objRoot;
  }

  /** Define la apariencia de puntos y lineas */
   Appearance cadenaApp()
   {
	Appearance app=new Appearance();
	app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_LINE
		,PolygonAttributes.CULL_NONE,0f));
        app.setPointAttributes(new PointAttributes(6.0f,true));	//grosor del ppunto
	app.setLineAttributes (new LineAttributes(3f,LineAttributes.PATTERN_SOLID,false)); //grosor linea
	return app;
   }

/** Define una apariencia variable en grosor de lineas y puntos (en este orden) */
   Appearance cadenaApp(float anchoPunto, float anchoLinea)
   {
	Appearance app=new Appearance();
	app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_LINE
		,PolygonAttributes.CULL_NONE,0f));
        app.setPointAttributes(new PointAttributes(anchoPunto,true));	//grosor del ppunto
	app.setLineAttributes (new LineAttributes(anchoLinea,LineAttributes.PATTERN_SOLID,false)); //grosor linea
	return app;
   }

   
   
  /** Define la apariencia de los ejes de coordenadas */
   Appearance cadenaAppEjes()
   {
	Appearance app=new Appearance();
	app.setLineAttributes (new LineAttributes(1f,LineAttributes.PATTERN_SOLID,false)); //grosor linea
	return app;
   }   
   
/**Pinta los ejes de coordenadas*/
public void pintaEjes (TransformGroup trans) throws Exception{
  
                double r = Geometria.RANGO;
		Segmento sgy = new Segmento (new Punto(0,r ), new Punto(0,-r));
                VisuSegmento vsgy = new VisuSegmento(sgy);
		vsgy.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                
                Segmento sgx = new Segmento (new Punto(-r, 0), new Punto(r,0));
                VisuSegmento vsgx = new VisuSegmento(sgx);
		vsgx.pinta(trans,cadenaAppEjes(), 0.5f,0.5f,0.5f);
                
                Segmento3d sgz = new Segmento3d(new Punto3d(0, 0, -r), new Punto3d(0,0,r));
                VisuSegmento3d vsgz = new VisuSegmento3d(sgz);
		vsgz.pinta(trans,cadenaAppEjes(), 0.5f,0.5f,0.5f);
                
                
                double ancho = r/100;
                double x = 0;
                while (x<r){
                   VisuSegmento rx = new VisuSegmento(new Segmento(x, -ancho, x, ancho));
                   VisuSegmento ry = new VisuSegmento(new Segmento(-r+x, -ancho,  -r+x,  ancho));
                   rx.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   ry.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   x += r/10;
                }
                double y = 0;
                while (y<r){
                   VisuSegmento rx = new VisuSegmento(new Segmento(-ancho, y, ancho, y));
                   VisuSegmento ry = new VisuSegmento(new Segmento(-ancho, -r+y, ancho, -r+y));
                   rx.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   ry.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   y += r/10;
                }
                double z = 0;
                while (z<r){
                   VisuSegmento3d rx = new VisuSegmento3d(new Segmento3d(0,-ancho,z, 0, ancho, z));
                   VisuSegmento3d ry = new VisuSegmento3d(new Segmento3d(0,-ancho,-r+z, 0, ancho, -r+z));
                   rx.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   ry.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   z += r/10;
                }
    
}   
 
/**Pinta la cuadrícula*/
public void pintaCuadricula (TransformGroup trans) throws Exception{
  
                double r = Geometria.RANGO;
                double ancho = 2*r;
                double x = 0;
                while (x<r){
                   VisuSegmento rx = new VisuSegmento(new Segmento(x, -ancho, x, ancho));
                   VisuSegmento ry = new VisuSegmento(new Segmento(-r+x, -ancho,  -r+x,  ancho));
                   rx.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   ry.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   x += r/10;
                }
                double y = 0;
                while (y<r){
                   VisuSegmento rx = new VisuSegmento(new Segmento(-ancho, y, ancho, y));
                   VisuSegmento ry = new VisuSegmento(new Segmento(-ancho, -r+y, ancho, -r+y));
                   rx.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   ry.pinta(trans,cadenaAppEjes(),0.5f,0.5f,0.5f);
                   y += r/10;
                }
    
}

/**Modificar la siguiente funcion:*/
/** Define lo que va a visualizarse en pantalla*/   
public void pintar3D (TransformGroup trans) throws Exception
{
    
                //pintaEjes(trans);
                //pintaCuadricula(trans);
    /*
		Punto pp = new Punto(0,0);
                VisuPunto vpp = new VisuPunto (pp);
                vpp.pinta(trans, cadenaApp());
                
		
		Punto kk = new Punto (100,100);
                VisuPunto vkk = new VisuPunto(kk);
		vkk.pinta(trans,cadenaApp());
                

		Segmento sg = new Segmento (pp,kk);
                VisuSegmento vsg = new VisuSegmento(sg);
		vsg.pinta(trans,cadenaApp());
		
                
                
                Punto3d tt = new Punto3d(50,50,-10);
                VisuPunto3d vtt = new VisuPunto3d (tt);
                //vtt.pinta(trans, cadenaApp());
                
                Punto3d ss = new Punto3d(50,50,70);
                VisuPunto3d vss = new VisuPunto3d (ss);
                //vss.pinta(trans, cadenaApp());
                
                Segmento3d dd = new Segmento3d (tt,ss);
                VisuSegmento3d vdd = new VisuSegmento3d (dd);
                vdd.pinta (trans, cadenaApp());
                
                
                NubePuntos3d nt = new NubePuntos3d (5);
		nt.addPunto(new Punto3d(90,0.0, 20)); 
		nt.addPunto(new Punto3d(80,30,-20));
		nt.addPunto(new Punto3d(30,0.0,40));
		nt.addPunto(new Punto3d(50,-20,20));
		nt.addPunto(new Punto3d(70,-70,20));
                VisuNube3d vnt = new VisuNube3d(nt);
                vnt.pinta(trans,cadenaApp());
      
                
                Triangulo3d tr = new Triangulo3d (new Punto3d(45 ,45,45), new Punto3d(-45.0,45,45), new Punto3d(45,9,45));
                VisuTriangulo3d vtr = new VisuTriangulo3d(tr);
                vtr.pinta(trans, cadenaApp());
                
                Rayo3d r = new Rayo3d (new Punto3d(0,0,0), new Punto3d(-30, 40, 80));
                VisuRayo3d vrr = new VisuRayo3d (r);
                vrr.pinta(trans, cadenaApp());
                
                boolean intersecta = tr.intersectaRayo3d(r);
                System.out.println ("El rayo intersecta: " + intersecta);
      */        
                Random rnd = new Random(50);
                NubePuntos3d nube = new  NubePuntos3d(20,new Color3f(1,0,0));

                for (int j=0;j<20;j++){

                    nube.addPunto(new Punto3d(rnd.nextFloat()*(90-(-90)+1)+(-90), rnd.nextFloat()*(90-(-90)+1)+(-90),rnd.nextFloat()*(90-(-90)+1)+(-90)));

                }
//                VisuNube3d vinube = new VisuNube3d(nube);
//                vinube.pinta(trans,cadenaApp());
                
                ObjetoTrian ot = new ObjetoTrian ("./objetos3d/lata_cerveza.obj");
                VisuObjetoTrian vot = new VisuObjetoTrian (ot);
                vot.pinta(trans,cadenaApp(0.3f,0.3f));
               
                for(int j=0;j<nube.numPuntos();j++){
                    if(ot.puntoEnObjeto(new Punto3d(-0.2f,0.39f,0.03f))){
                        VisuPunto3d viPunto = new VisuPunto3d(new Punto3d(-0.2f,0.39f,0.03f));
                        viPunto.pinta(trans, cadenaApp(), 0.0f, 1.0f, 0.0f);
                    }
                }
                
                Punto3d pin = new Punto3d (0, 0,0);
                VisuPunto3d vpin = new VisuPunto3d(pin);
                vpin.pinta(trans,cadenaApp());
                NubePuntos3d np = new NubePuntos3d(ot.getNubePuntos());
                VisuNube3d vnp = new VisuNube3d (np);
                vnp.pinta(trans,cadenaApp(0.5f,0.4f),1f,1f,1f);
              
}


  public static void main(String[] args) throws Exception{
   try{    
    Mainj3d applet = new Mainj3d();
    Frame frame = new MainFrame(applet, 2*Geometria.RANGO, 2*Geometria.RANGO);
   } catch (Exception e){
       System.out.println("Se ha producido algun tipo de error");
   }
  }
}
