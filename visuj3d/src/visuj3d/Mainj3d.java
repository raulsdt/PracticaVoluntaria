package visuj3d;

import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
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
public void pintar3D (TransformGroup trans) throws Exception{
    
    /*********** GENERAMOS LA NUBE DE PUNTOS ***********/
    Random rnd = new Random(50);
    NubePuntos3d nube = new NubePuntos3d(20, new Color3f(1, 0, 0));

    for (int j = 0; j < 20; j++) {
        nube.addPunto(new Punto3d(rnd.nextFloat() * (90 - (-90) + 1) + (-90), rnd.nextFloat() * (90 - (-90) + 1) + (-90), rnd.nextFloat() * (90 - (-90) + 1) + (-90)));
    }
    
    /*********** CARGAMOS OBJETO .OBJ ***********/
    ObjetoTrian ot = new ObjetoTrian("./objetos3d/torus_knot.obj");
    VisuObjetoTrian vot = new VisuObjetoTrian(ot);
    vot.pinta(trans, cadenaApp(0.3f, 0.3f));


    /*********** COMPROBAMOS PUNTOS DENTRO Y PUNTOS FUERA ***********/
    for (int j = 0; j < nube.numPuntos(); j++) {

        if (ot.puntoEnObjeto(nube.getPunto(j))) {
            VisuPunto3d viPunto = new VisuPunto3d(nube.getPunto(j));
            viPunto.pinta(trans, cadenaApp(), 0.0f, 1.0f, 0.0f);
        } else {
            VisuPunto3d viPunto = new VisuPunto3d(nube.getPunto(j));
            viPunto.pinta(trans, cadenaApp(), 1.0f, 0.0f, 0.0f);
        }
    }
    
    /*********** GENERAMOS LA CAJA ENVOLVENTE ***********/
    CajaEnvolvente caja = ot.getCajaEnvolvente();
    VisuCajaEnvolvente visuCaja = new VisuCajaEnvolvente(caja);
    visuCaja.pinta(trans, cadenaApp());

    //Mueve
//    ot.mover(50, 50, 50);
//    VisuObjetoTrian vor = new VisuObjetoTrian(ot);
//    vor.pinta(trans, cadenaApp(0.3f, 0.3f));

    /*********** RAYO QUE INTERSECTA EL OBJETO ***********/
    Vector3d direccion = new Vector3d(1000, 800, 1000);//Cualquier direccion
    Rayo3d r = new Rayo3d(new Vector3d(3.0f, .39f, -53.03f), direccion);
    VisuRayo3d ravi = new VisuRayo3d(r);
    ravi.pinta(trans, cadenaApp(), 0.0f, 0.0f, 1.0f);

    //Comprobamos si intersecta el objeto con el rayo

    if (ot.IntersectaRayo3d(r)) {
        System.out.println("Rayo1 intersecta con figura");
    } else {
        System.out.println("Rayo1 No intersecta rayo");
    }

    /*********** RAYO QUE SOLO INTERSECTA LA CAJA ***********/
    Vector3d dire = new Vector3d(100, -200, 1000);//Cualquier direccion
    Rayo3d re = new Rayo3d(new Vector3d(70f, -70, 90.03f), direccion);
    VisuRayo3d rav = new VisuRayo3d(re);
    rav.pinta(trans, cadenaApp(), 0.0f, 0.0f, 1.0f);

    if (ot.IntersectaRayo3d(re)) {
        System.out.println("Rayo2 intersecta con figura");
    } else {
        System.out.println("Rayo2 No intersecta rayo");
    }
    
    /*********** ORIGEN (0,0,0) ***********/
    Punto3d pin = new Punto3d(0, 0, 0);
    VisuPunto3d vpin = new VisuPunto3d(pin);
    vpin.pinta(trans, cadenaApp());
    NubePuntos3d np = new NubePuntos3d(ot.getNubePuntos());
    VisuNube3d vnp = new VisuNube3d(np);
    vnp.pinta(trans, cadenaApp(0.5f, 0.4f), 1f, 1f, 1f);
              
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
