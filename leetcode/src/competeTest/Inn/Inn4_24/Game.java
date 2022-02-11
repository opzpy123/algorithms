package competeTest.Inn.Inn4_24;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Game extends JFrame {
	//Define the components that need to be used
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	//Number of players selected
	private int selectNum=2;
	//save player name
	private ArrayList<String> playerNames = new ArrayList<>();
	public static Game frame;

	//The main program generates the main window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Game();
					frame.setTitle("my game");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Internal components of the main window
	public Game() {
		//Set main panel properties
		setBounds(100, 100, 600, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Component configuration
		JLabel lblName = new JLabel("Choose the number of players:");
		lblName.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblName.setBounds(45, 20, 300, 50);
		contentPane.add(lblName);
		//set ComboBox
		JComboBox<Integer> box = new JComboBox<Integer>();//创建一个下拉列表框c1
		box.addItem(2);
		box.addItem(3);
		box.addItem(4);
		box.addItem(5);
		box.addItem(6);
		box.setBounds(350, 32, 100, 30);
		box.setSelectedIndex(0);
		//Select event from drop-down box
		this.showComponents(box);
		contentPane.add(box);

		textField_1=new JTextField();
		textField_1.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_1.setBounds(250, 80, 200, 35);
		textField_1.setVisible(true);
		contentPane.add(textField_1);

		textField_2=new JTextField();
		textField_2.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_2.setBounds(250, 130, 200, 35);
		textField_2.setVisible(true);
		contentPane.add(textField_2);

		textField_3=new JTextField();
		textField_3.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_3.setBounds(250, 180, 200, 35);
		textField_3.setVisible(false);
		contentPane.add(textField_3);

		textField_4=new JTextField();
		textField_4.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_4.setBounds(250, 230, 200, 35);
		textField_4.setVisible(false);
		contentPane.add(textField_4);

		textField_5=new JTextField();
		textField_5.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_5.setBounds(250, 280, 200, 35);
		textField_5.setVisible(false);
		contentPane.add(textField_5);

		textField_6=new JTextField();
		textField_6.setFont(new Font("SimSun", Font.PLAIN, 22));
		textField_6.setBounds(250, 330, 200, 35);
		textField_6.setVisible(false);
		contentPane.add(textField_6);

		//set label
		label_1 = new JLabel("player1:");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_1.setBounds(95, 70, 150, 50);
		label_1.setVisible(true);
		contentPane.add(label_1);

		label_2 = new JLabel("player2:");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_2.setBounds(95, 120, 150, 50);
		label_2.setVisible(true);
		contentPane.add(label_2);

		label_3 = new JLabel("player3:");
		label_3.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_3.setBounds(95, 170, 150, 50);
		label_3.setVisible(false);
		contentPane.add(label_3);

		label_4 = new JLabel("player4:");
		label_4.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_4.setBounds(95, 220, 150, 50);
		label_4.setVisible(false);
		contentPane.add(label_4);

		label_5 = new JLabel("player5:");
		label_5.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_5.setBounds(95, 270, 150, 50);
		label_5.setVisible(false);
		contentPane.add(label_5);

		label_6 = new JLabel("player6:");
		label_6.setFont(new Font("SimSun", Font.PLAIN, 22));
		label_6.setBounds(95, 320, 150, 50);
		label_6.setVisible(false);
		contentPane.add(label_6);

		//Submit button and event
		JButton btn = new JButton("OK!");
		btn.setFont(new Font("SimSun", Font.PLAIN, 22));
		btn.setBounds(140, 390, 100, 43);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Collect the entered player name and number of players
				JTextField[] jTextFields = new JTextField[6];
				jTextFields[0]=textField_1;
				jTextFields[1]=textField_2;
				jTextFields[2]=textField_3;
				jTextFields[3]=textField_4;
				jTextFields[4]=textField_5;
				jTextFields[5]=textField_6;
				for (int i =0;i<selectNum;i++){
					if(jTextFields[i].getText().isEmpty()){
						JOptionPane.showMessageDialog(contentPane, "please input player name");
						return;
					}
				}
				for (int i =0;i<selectNum;i++){
					playerNames.add(jTextFields[i].getText());
				}
				//Write file
				try {
					wrireFile(selectNum,playerNames);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				//Initialize the collection
				playerNames=new ArrayList<>();
				//Create a new form
				createNewWindow();
			}
		});
		contentPane.add(btn);
	}
	//Create a new form and set properties
	private void createNewWindow(){
		JFrame f = new JFrame() ;
		f.setBounds(150, 150, 400, 300);
		f.setVisible(true) ;
		//Close the original form
		frame.setVisible(false);
	}

	//Build text Write file
	private void wrireFile(int num, ArrayList<String> playerNames) throws IOException {
		//Build File String
		StringBuilder sb = new StringBuilder();
		sb.append("player number:").append(num).append("\n");
		for (int i =0 ;i<playerNames.size();i++){
			sb.append("player_").append(i + 1).append(": ").append(playerNames.get(i)).append("\n");
		}
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = smt.format(new Date());
		sb.append("time:").append(nowTime).append("\n\n");
		//Write file
		File file =new File("Game.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		//true = append file
		FileWriter fileWritter = new FileWriter(file.getName(),true);
		fileWritter.write(sb.toString());
		fileWritter.close();
	}

	//Select event from drop-down box
	private void showComponents(JComboBox<Integer> box) {
		box.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					//If n is selected, the text of 1-n and the input box will be displayed
					selectNum = (int) e.getItem();
					if (selectNum == 2) {
						textField_1.setVisible(true);
						textField_2.setVisible(true);
						textField_3.setVisible(false);
						textField_4.setVisible(false);
						textField_5.setVisible(false);
						textField_6.setVisible(false);
						label_1.setVisible(true);
						label_2.setVisible(true);
						label_3.setVisible(false);
						label_4.setVisible(false);
						label_5.setVisible(false);
						label_6.setVisible(false);
					} else if (selectNum == 3) {
						textField_1.setVisible(true);
						textField_2.setVisible(true);
						textField_3.setVisible(true);
						textField_4.setVisible(false);
						textField_5.setVisible(false);
						textField_6.setVisible(false);
						label_1.setVisible(true);
						label_2.setVisible(true);
						label_3.setVisible(true);
						label_4.setVisible(false);
						label_5.setVisible(false);
						label_6.setVisible(false);
					} else if (selectNum == 4) {
						textField_1.setVisible(true);
						textField_2.setVisible(true);
						textField_3.setVisible(true);
						textField_4.setVisible(true);
						textField_5.setVisible(false);
						textField_6.setVisible(false);
						label_1.setVisible(true);
						label_2.setVisible(true);
						label_3.setVisible(true);
						label_4.setVisible(true);
						label_5.setVisible(false);
						label_6.setVisible(false);
					} else if (selectNum == 5) {
						textField_1.setVisible(true);
						textField_2.setVisible(true);
						textField_3.setVisible(true);
						textField_4.setVisible(true);
						textField_5.setVisible(true);
						textField_6.setVisible(false);
						label_1.setVisible(true);
						label_2.setVisible(true);
						label_3.setVisible(true);
						label_4.setVisible(true);
						label_5.setVisible(true);
						label_6.setVisible(false);
					} else if (selectNum == 6) {
						textField_1.setVisible(true);
						textField_2.setVisible(true);
						textField_3.setVisible(true);
						textField_4.setVisible(true);
						textField_5.setVisible(true);
						textField_6.setVisible(true);
						label_1.setVisible(true);
						label_2.setVisible(true);
						label_3.setVisible(true);
						label_4.setVisible(true);
						label_5.setVisible(true);
						label_6.setVisible(true);
					} else {
						textField_2.setVisible(false);
						textField_3.setVisible(false);
						textField_4.setVisible(false);
						textField_5.setVisible(false);
						textField_6.setVisible(false);
						label_1.setVisible(false);
						label_2.setVisible(false);
						label_3.setVisible(false);
						label_4.setVisible(false);
						label_5.setVisible(false);
						label_6.setVisible(false);
					}
				}
			}
		});
	}

}

