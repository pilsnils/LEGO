
 
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.*;
import com.jme3.input.controls.*;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;
import com.jogamp.opengl.util.texture.Texture;
import com.jme3.input.controls.ActionListener;
 
/** Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys. */
public class main extends SimpleApplication {
 
    public static void main(String[] args){
        main app = new main();
        app.start(); // start the game
    }
 
    
    
    
    @Override
    public void simpleInitApp() {
    	
    	
        Box b = new Box(Vector3f.ZERO, 1, 1, 1); // create cube shape at the origin
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat_tl = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_tl.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
        mat_tl.setColor("Color", new ColorRGBA(1f,0f,1f, 1f)); // purple
        geom.setMaterial(mat_tl);
             
        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene
 
        /** Attach the two boxes to the *pivot* node. */
        pivot.attachChild(geom);
        
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(.4f,.0f,0f);
    }
    
}