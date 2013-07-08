package guiObjects;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;



public class legoHexagon extends legoObject{

	
	
	public legoHexagon(int ID,  AssetManager assetManager, Vector3f position) {
		super(ID, new meshHexagon(), assetManager, position.clone());
		this.mesh=new meshHexagon();
		this.faces=new int[8];
/*The faces are counted according to the Hexagon-Mesh:
 * bottom, top, front right-front,right-rear, read, left-rear, left-front
 */
	}
	/**
	 * 
	 */
	public int getPickedFace(Vector3f contactPoint){
		
		Vector3f localCoord = contactPoint.subtract(this.position);
//		System.out.println("local: " + localCoord.toString());
		localCoord=transformCoordinates(localCoord);
//		System.out.println("local: " + localCoord.toString());
		
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
	
	/**
	 * 
	 */
	public Vector3f calculateNeighborPlace(int face){
		if(face ==0)
			return this.position.add(new Vector3f(0,0,-2*this.mesh.innerRadius));
		if(face ==1)
			return this.position.add(new Vector3f(0,0,2*this.mesh.innerRadius));
		if(face ==2)
			return this.position.add(new Vector3f(0,-2*this.mesh.innerRadius,0));
		if(face ==5)
			return this.position.add(new Vector3f(0,2*this.mesh.innerRadius,0));
		if(face ==3)
			return this.position.add(new Vector3f(this.mesh.outerRadius+this.mesh.innerRadius/2,-this.mesh.innerRadius,0));
		if(face ==4)
			return this.position.add(new Vector3f(this.mesh.outerRadius+this.mesh.innerRadius/2,this.mesh.innerRadius,0));
		if(face ==6)
			return this.position.add(new Vector3f(-this.mesh.outerRadius-this.mesh.innerRadius/2,this.mesh.innerRadius,0));
		if(face ==7)
			return this.position.add(new Vector3f(-this.mesh.outerRadius-this.mesh.innerRadius/2,-this.mesh.innerRadius,0));
		
		return new Vector3f(0,0,0);
	}
	
	/**
	 * 
	 * @param axis - The Axis to rotate around - x=0, y=1,
	 * @return
	 */
	public Vector3f calculateRotation(int axis){
		Vector3f rotationVector =  new Vector3f(0,0,0);
		if(axis ==0)
			return rotationVector=new Vector3f(0,(float) Math.PI/2,0);
		if(axis ==1)
			return rotationVector=new Vector3f((float) Math.PI/2,0,0);
		return rotationVector;
	}
	
}
