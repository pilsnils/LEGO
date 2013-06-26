
 
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;
 
/** Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys. */
public class testgame extends SimpleApplication {
 
    public static void main(String[] args){
        testgame app = new testgame();
        app.start(); // start the game
    }
 
    @Override
    public void simpleInitApp() {
    	
    	
        Box b = new Box(Vector3f.ZERO, 3, 1, 1); // create cube shape at the origin
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Green);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        this.rootNode.attachChild(geom);              // make the cube appear in the scene
    }
}