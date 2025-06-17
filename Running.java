package whatKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Running {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Notes Guide");
		frame.setLayout(new BorderLayout(0,0));
		frame.setSize(600,400);
		frame.setLocation(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		frame.add(mainPanel);
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		JLabel instructions = new JLabel("Welcome to the music key app. Please select an option below.");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		mainPanel.add(instructions, c);
		
		JButton arpeggio = new JButton("I have a Root, Third, and Fifth");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		mainPanel.add(arpeggio, c);
		
		JButton key = new JButton("I have a key");
		//c.ipadx = 50;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		mainPanel.add(key, c);
		
		
		
		
		JLabel arpeggioLabel = new JLabel("Enter the root, third, and fifth of the scale or chord to get your key. ");
		
		JLabel arpeggioLabel2 = new JLabel("Enter in the format C, C#, Bb, etc. # (hashtag) for sharp, b (lowercase b) for flat.");
		
		JLabel rootLabel = new JLabel("Root: ");
		
		JTextField inputRoot = new JTextField(10);
		inputRoot.setToolTipText("Enter Root");
		
		JLabel thirdLabel = new JLabel("Third: ");
		
		JTextField inputThird = new JTextField(10);
		inputThird.setToolTipText("Enter Third");
		
		JLabel fifthLabel = new JLabel("FIfth:");
		
		JTextField inputFifth = new JTextField(10);
		inputFifth.setToolTipText("Enter Fifth");
		
		JButton submitArpeggio = new JButton("Enter");
		
		JLabel outputArpeggio = new JLabel("");
		
		JButton backArpeggio = new JButton("Go Back");
		
		//mainPanel.add(input);
		//mainPanel.add(submit);
		//mainPanel.add(output);
		
		JLabel keyLabel = new JLabel("Input the key in the format A Minor, D Major, etc.");
		
		JLabel keyLabel2 = new JLabel("Major, Minor, Augmented, Diminished");
		
		JLabel keyInputLabel = new JLabel("Key:");
		
		JTextField keyInput = new JTextField(10);
		
		JButton submitKey = new JButton("Enter");
		
		JLabel keyOutput = new JLabel("");
		
		JButton keyBack = new JButton("Go Back");
		
		arpeggio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(instructions);
				mainPanel.remove(arpeggio);
				mainPanel.remove(key);
				
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				mainPanel.add(arpeggioLabel, c);
				
				c.gridx = 0;
				c.gridy = 1;
				c.gridwidth = 2;
				mainPanel.add(arpeggioLabel2, c);
				
				c.gridx = 0;
				c.gridy = 2;
				c.gridwidth = 1;
				mainPanel.add(rootLabel, c);
				
				c.gridx = 1;
				c.gridy = 2;
				c.gridwidth = 1;
				mainPanel.add(inputRoot, c);
				
				c.gridx = 0;
				c.gridy = 3;
				c.gridwidth = 1;
				mainPanel.add(thirdLabel, c);
				
				c.gridx = 1;
				c.gridy = 3;
				c.gridwidth = 1;
				mainPanel.add(inputThird, c);
				
				c.gridx = 0;
				c.gridy = 4;
				c.gridwidth = 1;
				mainPanel.add(fifthLabel, c);
				
				c.gridx = 1;
				c.gridy = 4;
				c.gridwidth = 1;
				mainPanel.add(inputFifth, c);
				
				c.gridx = 0;
				c.gridy = 5;
				c.gridwidth = 2;
				mainPanel.add(submitArpeggio, c);
				
				c.gridx = 0;
				c.gridy = 6;
				c.gridwidth = 2;
				mainPanel.add(outputArpeggio, c);
				
				c.gridx = 0;
				c.gridy = 7;
				c.gridwidth = 2;
				mainPanel.add(backArpeggio, c);
				
				mainPanel.repaint();
				mainPanel.revalidate();
			}
			
		});
		
		key.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(instructions);
				mainPanel.remove(arpeggio);
				mainPanel.remove(key);
				
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				mainPanel.add(keyLabel, c);
				
				c.gridx = 0;
				c.gridy = 1;
				c.gridwidth = 2;
				mainPanel.add(keyLabel2, c);
				
				c.gridx = 0;
				c.gridy = 2;
				c.gridwidth = 1;
				mainPanel.add(keyInputLabel, c);
				
				c.gridx = 1;
				c.gridy = 2;
				c.gridwidth = 1;
				mainPanel.add(keyInput, c);
				
				c.gridx = 0;
				c.gridy = 3;
				c.gridwidth = 2;
				mainPanel.add(submitKey, c);
				
				c.gridx = 0;
				c.gridy = 4;
				c.gridwidth = 2;
				mainPanel.add(keyOutput, c);
				
				c.gridx = 0;
				c.gridy = 5;
				c.gridwidth = 2;
				mainPanel.add(keyBack, c);
				
				mainPanel.repaint();
				mainPanel.revalidate();
			}
			
		});
		
		submitArpeggio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Key key = new Key(inputRoot.getText(), inputThird.getText(), inputFifth.getText());
				outputArpeggio.setText(key.getKey());
				
			}
			
		});
		
		backArpeggio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputRoot.setText("");
				inputThird.setText("");
				inputFifth.setText("");
				outputArpeggio.setText("");
				
				mainPanel.remove(arpeggioLabel);
				mainPanel.remove(arpeggioLabel2);
				mainPanel.remove(rootLabel);
				mainPanel.remove(inputRoot);
				mainPanel.remove(thirdLabel);
				mainPanel.remove(inputThird);
				mainPanel.remove(fifthLabel);
				mainPanel.remove(inputFifth);
				mainPanel.remove(submitArpeggio);
				mainPanel.remove(outputArpeggio);
				mainPanel.remove(backArpeggio);
				
				
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				mainPanel.add(instructions, c);
				
				
				c.gridx = 0;
				c.gridy = 1;
				c.gridwidth = 1;
				mainPanel.add(arpeggio, c);
				
				
				//c.ipadx = 50;
				c.gridx = 1;
				c.gridy = 1;
				c.gridwidth = 1;
				mainPanel.add(key, c);
				
				mainPanel.repaint();
				mainPanel.revalidate();
				
			}
			
		});
		
		submitKey.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Key key;
				if(keyInput.getText().length() >= 3) {
					key = new Key(keyInput.getText().substring(0,1), keyInput.getText().substring(2));
				}
				else {
					key = new Key("Wark", "Warble");
				}
				keyOutput.setText(key.arpeggio());
				
			}
			
		});
		
		keyBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				keyInput.setText("");
				keyOutput.setText("");
				
				mainPanel.remove(keyLabel);
				mainPanel.remove(keyLabel2);
				mainPanel.remove(keyInputLabel);
				mainPanel.remove(keyInput);
				mainPanel.remove(submitKey);
				mainPanel.remove(keyOutput);
				mainPanel.remove(keyBack);
				
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				mainPanel.add(instructions, c);
				
				
				c.gridx = 0;
				c.gridy = 1;
				c.gridwidth = 1;
				mainPanel.add(arpeggio, c);
				
				
				//c.ipadx = 50;
				c.gridx = 1;
				c.gridy = 1;
				c.gridwidth = 1;
				mainPanel.add(key, c);
				
				mainPanel.repaint();
				mainPanel.revalidate();
				
			}
			
		});
		
		frame.setVisible(true);
	}
}
