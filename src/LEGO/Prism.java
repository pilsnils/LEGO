package LEGO;


public class Prism extends legoBlock{

	int numberOfEdges;
	int height;
	int width;
	
	public Prism(int id, int[] position, int[] orientation, int numberOfEdges, int height, int width) {
		super(id, position, orientation);
		this.numberOfEdges=numberOfEdges;
		this.height=height;
		this.width=width;
		this.neighbours=new int[numberOfEdges+2];//mantelflächen + oben + unten
	}
	
	
	
	

}
