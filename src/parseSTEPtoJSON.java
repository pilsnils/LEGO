import java.io.IOException;





public class parseSTEPtoJSON {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		STEP step = new STEP("D:/Eigene Dateien/Documents/Studium/Master ITM/2. Semester/Projekt/Source/src/STEPfiles/block_asm_3.step");
		System.out.println(step.toString());

	}

}
