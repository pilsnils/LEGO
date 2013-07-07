import guiObjects.legoObject;

import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.input.*;
import com.jme3.input.controls.*;

public class EventHandler implements ActionListener, AnalogListener{

	
	private main main;
	
	private boolean Ctrl, Shift, LMouse, RMouse;
	
	public EventHandler(main main, InputManager inputManager){
		this.main=main;
		initKeys(inputManager);
		
	}
	
	
	
	
	/**
	 * 
	 */
	 public void addElement(){
     	  CollisionResults results = new CollisionResults();
          Vector2f click2d = main.getInputManager().getCursorPosition();
          Vector3f click3d = main.getCam().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
          Vector3f aim = main.getCam().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();
          Ray ray = new Ray(click3d, aim);
          main.getRootNode().collideWith(ray, results);
//          for (int i = 0; i < results.size(); i++) {
//            float dist = results.getCollision(i).getDistance();
//            Vector3f pt = results.getCollision(i).getContactPoint();
//            String target = results.getCollision(i).getGeometry().getName();
//            System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
//          }
//          if(results.size()>0&&results.getCollision(0).getGeometry().getName()=="Teapot-geom-0"){
//        	  int collision=0;
//        	  if(results.getCollision(0).getGeometry().getName()=="Teapot-geom-0")
//        		  collision=2;
          	if(results.size()>0){
          	Vector3f point = results.getCollision(0).getContactPoint();
          	legoObject pickedObject = getCollisionObject(results);
          	if(pickedObject != null)
        	System.out.println("Face: "+pickedObject.getPickedFace(point));
          	this.main.addObject(pickedObject.calculateNeighborPlace(pickedObject.getPickedFace(point)));
          	}
        	 
     }
	 
	 /**
	  * 
	  * @param results
	  * @return
	  */
	 private legoObject getCollisionObject(CollisionResults results){

		 		int index=0;
		 		while(results.getCollision(index).getGeometry().getName().equals("Teapot-geom-0")){
		 			index++;
		 			if (index==results.size())
		 				return null;
		 		}
		 
		 		int objectIndex=getIndexOfObject(results.getCollision(index).getGeometry().getName());
	        	if(objectIndex!=-1)
	        		return this.main.objects.get(objectIndex);
	        	return null;
	 }
	 
	 
	 /**
	  * 
	  * @param name
	  * @return
	  */
	 private int getIndexOfObject(String name){
		 for(int i=0; i< this.main.objects.size();i++)
			 if(this.main.objects.get(i).getGeometry().getName()==name)
				 return i;
		return -1; 
	 }
	
	 /**
	  * 
	  * @param inputManager
	  */
	 private void initKeys(InputManager inputManager){
		 String[] inputs = {"Space", 
		  "Ctrl",
	      "ChaseCamDown",
          "ChaseCamUp",
          "ChaseCamMoveLeft",
          "ChaseCamMoveRight",
          "LMouse",
          "RMouse"
          };
	      
	          inputManager.addMapping("ChaseCamDown", new MouseAxisTrigger(MouseInput.AXIS_Y, true));
	          inputManager.addMapping("ChaseCamUp", new MouseAxisTrigger(MouseInput.AXIS_Y, false));
	          inputManager.addMapping("ChaseCamMoveLeft", new MouseAxisTrigger(MouseInput.AXIS_X, true));
	          inputManager.addMapping("ChaseCamMoveRight", new MouseAxisTrigger(MouseInput.AXIS_X, false));
          
          	inputManager.addMapping("LMouse", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
          	inputManager.addMapping("RMouse", new MouseButtonTrigger(MouseInput.BUTTON_RIGHT));
		 	inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
		 	inputManager.addMapping("Ctrl", new KeyTrigger(KeyInput.KEY_LCONTROL));
		 	inputManager.addMapping("Shift", new KeyTrigger(KeyInput.KEY_LSHIFT));
		 	inputManager.addListener(this, inputs);
	 }

	 
	 public void onAction(String name, boolean keyPressed, float tpf) {
		switchBottoms(name, keyPressed);
		if (name.equals("LMouse")&&keyPressed)
			addElement();
		 
	 }
	 
	 /**
	  * 
	  * @param name
	  * @param keyPressed
	  */
	private void switchBottoms(String name, boolean keyPressed) {
		if (name.equals("Ctrl")) 
			 if(keyPressed)
				 this.Ctrl=true;
			 else
				 this.Ctrl=false;
		 
		 if (name.equals("Shift")) 
			 if(keyPressed)
				 this.Shift=true;
			 else
				 this.Shift=false;
		 if (name.equals("LMouse")){ 
			 if(keyPressed)
				 this.LMouse=true;
			 else
				 this.LMouse=false;
			 
		 }
		 if (name.equals("RMouse")) 
			 if(keyPressed)
				 this.RMouse=true;
			 else
				 this.RMouse=false;
		
	}




	/**
	 * 
	 */
	public void onAnalog(String name, float value, float tpf) {
		
		float hAngle=main.chaseCam.getHorizontalRotation();
		float vAngle=main.chaseCam.getVerticalRotation();
		
		Vector3f dir = new Vector3f((float) (5*tpf*Math.cos(hAngle)),(float) (5*tpf *Math.sin(hAngle)),(float) (5*tpf *Math.sin(vAngle)));

		
		if (name.equals("ChaseCamUp")) {
            if(this.RMouse){
            	main.cameraFixpoint.move(0,-50 * tpf, 0);
            }
		}
		if (name.equals("ChaseCamDown")) {
            if(this.RMouse){
            	main.cameraFixpoint.move(0,50 * tpf, 0);
            }
		}
		if (name.equals("ChaseCamMoveLeft")) {
            if(this.RMouse){
            	main.cameraFixpoint.move( dir.y*10,0,-dir.x*10);
            }
		}
		if (name.equals("ChaseCamMoveRight")) {
            if(this.RMouse){
            	main.cameraFixpoint.move( -dir.y*10,0,dir.x*10);
            }
		}
	}
	 
	 
}
