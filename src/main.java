
 

import java.util.LinkedList;

import org.w3c.dom.css.RGBColor;

import guiObjects.legoObject;
import guiObjects.legoHexagon;

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
	
    public static void main(String[] args){
        main app = new main();
        app.start(); // start the game
        
    }
     
    
    public void simpleInitApp() {
    	viewPort.setBackgroundColor(ColorRGBA.White);
    	this.objects=new LinkedList<legoObject>();
    	
    	addObject(new Vector3f(0,0,0));
    	
    	
    	addObject(new Vector3f(2,4,10));
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
    void addObject(Vector3f position){
    	int id=this.objects.size();
    	
    	this.objects.add(new legoHexagon(id,  assetManager, position.clone()));
    	rootNode.attachChild(this.objects.get(id).getGeometry());
    }
    
 
//    private void initKeys() {
//    	inputManager.addMapping("moveUp", new KeyTrigger(keyInput.KEY_UP), new KeyTrigger(keyInput.KEY_Q));
//        inputManager.addMapping("moveDown", new KeyTrigger(keyInput.KEY_DOWN), new KeyTrigger(keyInput.KEY_E));
//    	inputManager.addMapping("moveForward", new KeyTrigger(keyInput.KEY_UP), new KeyTrigger(keyInput.KEY_W));
//        inputManager.addMapping("moveBackward", new KeyTrigger(keyInput.KEY_DOWN), new KeyTrigger(keyInput.KEY_S));
//        inputManager.addMapping("moveRight", new KeyTrigger(keyInput.KEY_RIGHT), new KeyTrigger(keyInput.KEY_D));
//        inputManager.addMapping("moveLeft", new KeyTrigger(keyInput.KEY_LEFT), new KeyTrigger(keyInput.KEY_A));
//    	inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_SPACE));
//        inputManager.addMapping("LMouse", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
//        inputManager.addListener(analogListener, new String[]{"LMouse", "Rotate", 
//        		"moveForward", "moveBackward", "moveRight", "moveLeft", "moveUp", "moveDown"});
//      }
    
    
//    private AnalogListener analogListener = new AnalogListener() {
//        public void onAnalog(String name, float value, float tpf) {
//        		float hAngle=chaseCam.getHorizontalRotation();
//        		float vAngle=chaseCam.getVerticalRotation();
//        		
//        		Vector3f dir = new Vector3f((float) (5*tpf*Math.cos(hAngle)),(float) (5*tpf *Math.sin(hAngle)),(float) (5*tpf *Math.sin(vAngle)));
//
//        		if (name.equals("moveForward")) {
//        			float angle=chaseCam.getHorizontalRotation();
//        		
//        			cameraFixpoint.move(new Vector3f(-dir.x,-dir.z,-dir.y));
//        			}
//        	    if (name.equals("moveBackward")) {
//        	    	cameraFixpoint.move(new Vector3f(dir.x,dir.z,dir.y));
//            	    }
//        	    if (name.equals("moveRight")) {
//        	    	cameraFixpoint.move( dir.y,0,-dir.x);
//            	    }
//        	    if (name.equals("moveLeft")) {
//        	    	cameraFixpoint.move( -dir.y,0,dir.x);
//            	    }
//        	    if (name.equals("moveUp")) {
//        	    	cameraFixpoint.move(0,5 * tpf,  0);
//        	    }
//        	    if (name.equals("moveDown")) {
//        	    	cameraFixpoint.move(0,-5 * tpf, 0);
//        	    }
//        	    
//	            if (name.equals("LMouse")) {
//	            	
//	               eventHandler.pickEvent();
//	            }
//	            
//	            if (name.equals("Rotate")) {
//	            	
////            	objects.get(0).getGeometry().rotate(value*speed,0, 0);
//            	 System.out.println(objects.get(0).getPosition().toString());
//            	 System.out.println(objects.get(1).getPosition().toString());
////            	 Vector3f localCoord = .subtract(objects.get(1).getPosition());
//            	 
//	            }
//        }
//      };
      
      /**
       * 
       */
    
    
}

	