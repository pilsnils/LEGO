package guiObjects;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;

public class legoObject {
	
	
	protected int ID;
	protected Geometry geom;
	protected Material mat;
	protected Vector3f position;
	public Vector3f orientation;
	protected int[]faces;
	protected meshLego mesh;
	/**
	 * 
	 * @param ID
	 * @param mesh
	 * @param assetManager
	 */
	public legoObject(int ID, Mesh mesh, AssetManager assetManager, Vector3f position){
		this.ID=ID;
		this.geom = new Geometry("LEGO_" + ID, mesh);
		
	    
		this.mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		this.mat.setColor("Color", ColorRGBA.Blue);
		this.mat.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
		this.geom.setMaterial(mat);
		this.move(position);
		this.orientation=new Vector3f(0,0,0);
		}
	/**
	 * 
	 * @return
	 */
	public Geometry getGeometry (){
		return this.geom;
	}
	/**
	 * 
	 * @return
	 */
	public Material getMaterial(){
		return this.mat;
		}
	/**
	 * 
	 * @param color
	 */
	public void setColor(ColorRGBA color){
		this.mat.setColor("Color", color);
		this.geom.setMaterial(mat);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Vector3f getPosition(){
		return this.position.clone();
	}
	/**
	 * 
	 * @param position
	 */
	public void move(Vector3f position){
		this.position=position.clone();
		this.geom.move(position);
	}
	
	
	/**
	 * 
	 * @param orientation
	 */
	public void rotateObject(Vector3f orientation){
		this.orientation=this.orientation.add(orientation);
		this.geom.rotate(orientation.x, orientation.y, orientation.z);
		
	}
	/**
	 * 
	 * @param point
	 * @return
	 */
	public int getPickedFace(Vector3f point){
		return -1;
	}
	/**
	 * 
	 * @param face
	 * @return
	 */
	public Vector3f calculateNeighborPlace(int face){
		return null;
	}
	/**
	 * 
	 * @param face
	 * @return
	 */
	public Vector3f calculateRotation(int face){
		
		return new Vector3f(0,0,0);
	}
	/**
	 * 
	 * @return
	 */
	protected Vector3f transformCoordinates(Vector3f vector){
		Vector3f current = vector.clone();
		Vector3f result = vector.clone();
		//x-Rotation
		result.y=(float) (current.y*Math.cos(this.orientation.x)+current.z*Math.sin(this.orientation.x));		
		result.z=(float) (-current.y*Math.sin(this.orientation.x)+ current.z*Math.cos(this.orientation.x));	
		current=result.clone();
		
		//y-Rotation	
		result.x=(float) (current.x*Math.cos(this.orientation.y)-current.z*Math.sin(this.orientation.y));		
		result.z=(float) (current.x*Math.sin(this.orientation.y)+ current.z*Math.cos(this.orientation.y));		
		current=result.clone();
		//z-Rotation
		result.x=(float) (current.x*Math.cos(this.orientation.z)+current.y*Math.sin(this.orientation.z));		
		result.y=(float) (-current.x*Math.sin(this.orientation.z)+ current.y*Math.cos(this.orientation.z));
		
		return result;
	}
	
}
