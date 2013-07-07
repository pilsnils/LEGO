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
	protected int[]faces;
	
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
	 * @param point
	 * @return
	 */
	public int getPickedFace(Vector3f point){
		return -1;
	}
	public Vector3f calculateNeighborPlace(int face){
		return null;
	}
	
}
