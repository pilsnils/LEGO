
public class legoBlock {

	private int id;
	private int[]position, orientation;
	protected int[] neighbours;
	
	
	public legoBlock(int id, int[] position, int[] orientation){
		this.id=id;
		this.position=position;
		this.orientation=orientation;
		
	}

	protected void setNeighbour(int pos, int id){
		this.neighbours[pos]=id;
	}
	
	
	protected int getNeighbour(int pos){
		return this.neighbours[pos];
		}
	
	protected void rotate(int[]angles){
		this.orientation[0]+=angles[0];
		this.orientation[1]+=angles[1];
		this.orientation[2]+=angles[2];
	}
	
}
