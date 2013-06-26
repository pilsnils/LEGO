import java.awt.*;
import javax.swing.*;


public class legoGUI extends JFrame{

	private JButton button;
	private JPanel panel;
	
	public legoGUI() {
		super("LEGO Assemblage Tool");
		 
         
         setLocation(300,300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout(5,5));

         panel = new JPanel(new GridLayout(1,1));
         button = new JButton("Button");

         panel.add(button);

         getContentPane().add(panel);

         pack();
         setVisible(true);
         
         
         
	}
	
}
