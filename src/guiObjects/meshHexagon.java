package guiObjects;


import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.util.BufferUtils;
import com.jme3.scene.VertexBuffer.Type;


public class meshHexagon extends Mesh{
	
	
	public meshHexagon(){
	
		super();
		
		float innerRadius=1; //length of the inner radius, half of the distance of two oppposite edges
		float edge = (float) (2/Math.sqrt(3)) *innerRadius; //length of an edge of the hexagon, equal to the outer radius 
		
		// Vertex positions in space
        Vector3f [] vertices = new Vector3f[12];
        vertices[0] = new Vector3f(-edge/2,-edge,0);
        vertices[1] = new Vector3f(edge/2,-edge,0);
        vertices[2] = new Vector3f(edge,0,0);
        vertices[3] = new Vector3f(edge/2,edge,0);
        vertices[4] = new Vector3f(-edge/2,edge,0);
        vertices[5] = new Vector3f(-edge,0,0);
        
        vertices[6] = new Vector3f(-edge/2,-edge,2);
        vertices[7] = new Vector3f(edge/2,-edge,2);
        vertices[8] = new Vector3f(edge,0,2);
        vertices[9] = new Vector3f(edge/2,edge,2);
        vertices[10] = new Vector3f(-edge/2,edge,2);
        vertices[11] = new Vector3f(-edge,0,2);
        

        // Texture coordinates
        Vector3f [] texCoord = new Vector3f[12];
        for(int i=0;i<12;i++)
        	 texCoord[i] = new Vector3f(1,1,1);
        	
        	
        // Indexes. We define the order in which mesh should be constructed
        int [] indexes = {5,4,0, 4,3,0, 3,1,0, 3,2,1, 6,10,11, 6,9,10, 6,7,9, 7,8,9, 0,7,6, 0,1,7, 1,8,7, 1,2,8, 2,9,8, 2,3,9, 3,10,9, 3,4,10, 4,11,10, 4,5,11, 5,6,11, 5,0,6 };
	
     
        
	
	this.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
	this.setBuffer(Type.TexCoord, 3, BufferUtils.createFloatBuffer(texCoord));
	this.setBuffer(Type.Index,    3, BufferUtils.createIntBuffer(indexes));
	
	this.updateBound();
	}
}
