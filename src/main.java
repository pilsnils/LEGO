
 

import java.util.LinkedList;

import org.w3c.dom.css.RGBColor;

import guiObjects.legoObject;
import guiObjects.meshHexagon;

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
import com.jme3.input.controls.*;
 
/** Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys. */


public class main extends SimpleApplication {
	
	private LinkedList<legoObject> objects;
//	private legoObject[] objects;
	
	
    public static void main(String[] args){
        main app = new main();
        app.start(); // start the game
        
    }
     
    
    public void simpleInitApp() {
    	
    	this.objects=new LinkedList<legoObject>();
    	
    	addObject(new float[]{0,0,0});
   
        initKeys(); 
    }

    
    /**
     * 
     */
    private void initKeys() {
        // You can map one or several inputs to one named action
    	inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Switch", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        // Add the names to the action listener.
        inputManager.addListener(analogListener, new String[]{"Switch", "Rotate"});
        
      }
   
    /**
     * 
     * @param position
     */
    private void addObject(float[] position){
    	int id=this.objects.size();
    	this.objects.add(new legoObject(id, new meshHexagon(), assetManager));
    	rootNode.attachChild(this.objects.get(id).getGeometry());
    }
    
    
    
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {
     
            if (name.equals("Switch")) {
            	 
            	 addObject(new float[]{0,2,4});
            	 
            	 objects.get(0).setColor(ColorRGBA.White);
            }
            if (name.equals("Rotate")) {
            	
            	 objects.get(0).getGeometry().rotate(value*speed,0, 0);
            	
            }
        }
      };
    
    
}

	