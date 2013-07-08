
 

import java.util.LinkedList;

import org.w3c.dom.css.RGBColor;

import guiObjects.legoObject;
import guiObjects.legoHexagon;

import LEGO.legoAssemblage;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.*;
import com.jme3.input.controls.*;
import com.jme3.material.Material;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
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
	
	public LinkedList<legoObject> objects;
	Geometry cameraFixpoint;
	ChaseCamera chaseCam;
	EventHandler eventHandler;
	legoAssemblage assemblage;
	
    public static void main(String[] args){
        main app = new main();
        app.start(); // start the game
        
    }
     
    
    public void simpleInitApp() {
    	viewPort.setBackgroundColor(ColorRGBA.White);
    	this.objects=new LinkedList<legoObject>();
    	this.assemblage = new legoAssemblage(this.objects);
    	addObject(new Vector3f(0,0,2));
    	initCam();
        this.eventHandler=new EventHandler(this, this.inputManager);
       
    }

    
    
    
    /**
     * 
     */
    private void initCam(){
    	//Camera Setup
    	flyCam.setEnabled(false);
    	cameraFixpoint = (Geometry) assetManager.loadModel("Models/Teapot/Teapot.obj");
//    	cameraFixpoint.setMaterial(new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md"));
    	rootNode.attachChild(cameraFixpoint);
    	chaseCam = new ChaseCamera(getCam(), cameraFixpoint, inputManager);
    	chaseCam.setToggleRotationTrigger(new MouseButtonTrigger(MouseInput.BUTTON_MIDDLE));
    	chaseCam.setMinVerticalRotation((float) (-Math.PI/2));
    }
    
    
    /**
     * 
     * @param position
     */
    public void addObject(Vector3f position){
    	int id=this.objects.size();
    	
    	this.objects.add(new legoHexagon(id,  assetManager, position.clone()));
    	rootNode.attachChild(this.objects.get(id).getGeometry());
    }
    
    /**
     * 
     * @param rotation
     * @param object
     */
    public void rotateObject(Vector3f rotation, legoObject object){
    		object.rotateObject(rotation);
    }
 
      
      /**
       * 
       */
    
    
}

	