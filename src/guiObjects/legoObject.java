package guiObjects;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;

public class legoObject {
	
	
	private int ID;
	private Geometry geom;
	private Material mat;
	
	/**
	 * 
	 * @param ID
	 * @param mesh
	 * @param assetManager
	 */
	public legoObject(int ID, Mesh mesh, AssetManager assetManager){
		this.ID=ID;
		this.geom = new Geometry("LEGO", mesh);
		this.mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		this.mat.setColor("Color", ColorRGBA.Blue);
		this.mat.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
		this.geom.setMaterial(mat);
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
	
	
}
