import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class STEP {

	
	private String stepFile;
	String[][] stepMatrix;
	
	/**
	 * 
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public STEP (String filePath) throws IOException{
		this.stepFile= openStepFile(filePath);
		this.stepMatrix = createStepMatrix(this.stepFile);
		
	}
	/**
	 * 
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private static String openStepFile(String path) throws IOException{
		
		Scanner sc=null;
		File f= new File(path);
		String inputstring="";
		try{
			sc= new Scanner(f);
		}catch(FileNotFoundException e){
			System.out.println("Fehler: Datei wurde nicht gedunden!");
		}
		while (sc.hasNextLine()){
			inputstring+="\n"+sc.nextLine();
		}
		return inputstring;
	}
	
	/**
	 * 
	 * 
	 * @param stepFile
	 * @return
	 */
	private String[][] createStepMatrix(String stepFile){
		String data=cutDataArea(stepFile);
		data = data.replaceAll("\n", "");
		
		String[] rows = data.split(";");
		
		String [][]stepmatrix= new String [rows.length][3];
		for (int i=0;i<rows.length;i++){
			stepmatrix[i][0]=rows[i].split("=")[0];
			stepmatrix[i][1]=rows[i].split("=")[1].split("\\(")[0];
			stepmatrix[i][1]=stepmatrix[i][1].replaceAll(" ", "");
			stepmatrix[i][2]=rows[i].split("=")[1].replaceAll(stepmatrix[i][1], "");;
//			rows[i].split("=")[1].split("\\(")[1];
		}
		return stepmatrix;
	}
	
	/**
	 * 
	 * 
	 * @param stepFile
	 * @return
	 */
	private String cutDataArea(String stepFile){
		return stepFile.split("DATA;\n")[1].split("ENDSEC;")[0];
	
	}
	
	String[] getArguments(int row){
		String arguments = this.stepMatrix[row][2].substring(2, stepMatrix[row][2].length()-2);
		
		return arguments.split(", ");
		
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public int getNumberOfShapes(){
		
		int foundObjects=0;
		int row=0;
		while( row<this.stepMatrix.length){
			int nextObject=findElement(row, 1, "ITEM_DEFINED_TRANSFORMATION");
			if(nextObject ==-1)
				return foundObjects;
			foundObjects++;
			row=nextObject+1;
		}
		System.out.println(row);
		return 0;
		
		
	}
	/**
	 * 
	 * 
	 * @param col
	 * @param element
	 * @return
	 */
	protected int findElement(int start, int col, String element){
		
		for(int i=start; i<this.stepMatrix.length; i++){
			
			if(stepMatrix[i][col].equals(element))
				return i;
		}
		return -1;		
	}
	
	
	/**
	 * 
	 * 
	 */
	public String toString(){
		String print="";
		for (int i=0;i<this.stepMatrix.length;i++){
			for(int j=0;j<this.stepMatrix[0].length;j++){
			print += stepMatrix[i][j] + "// ";
		}
		print +="\n";
		
	}
	return print;
	}
}