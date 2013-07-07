package guiObjects;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;

public class legoHexagon extends legoObject{

	
	
	public legoHexagon(int ID,  AssetManager assetManager, Vector3f position) {
		super(ID, new meshHexagon(), assetManager, position.clone());
		this.faces=new int[8];
/*The faces are counted according to the Hexagon-Mesh:
 * bottom, top, front right-front,right-rear, read, left-rear, left-front
 */
	}
	/**
	 * 
	 */
	public int getPickedFace(Vector3f point){
		
		Vector3f localCoord = point.subtract(this.position);
		if(localCoord.z<=-0.97)
			return 0;
		if(localCoord.z>=0.97)
			return 1;
		if(localCoord.y==-1&&Math.abs(localCoord.z)<0.95)
			return 2;
		if(localCoord.x>0&&localCoord.y<0&&Math.abs(localCoord.z)<0.95)
			return 3;
		if(localCoord.x>0&&localCoord.y>0&&Math.abs(localCoord.z)<0.95)
			return 4;
		if(localCoord.y==1&&Math.abs(localCoord.z)<0.95)
			return 5;
		if(localCoord.x<0&&localCoord.y>0&&Math.abs(localCoord.z)<0.95)
			return 6;
		if(localCoord.x<0&&localCoord.y<0&&Math.abs(localCoord.z)<0.95)
			return 7;
		return -1;
	}
	
	
	public Vector3f calculateNeighborPlace(int face){
		if(face ==0)
			return this.position.add(new Vector3f(0,0,-2));
		if(face ==1)
			return this.position.add(new Vector3f(0,0,2));
		if(face ==2)
			return this.position.add(new Vector3f(0,-2,0));
		if(face ==5)
			return this.position.add(new Vector3f(0,2,0));
		return new Vector3f(0,0,0);
	}
	
	
}
