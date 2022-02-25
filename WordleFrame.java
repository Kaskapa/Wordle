package lv.jak.veveris;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class WordleFrame {
	public static WordleWords words = new WordleWords();
	public static String ans = words.getAnwer().toUpperCase();
	public static JLabel label11 = new JLabel();
	public static JLabel label21 = new JLabel();
	public static JLabel label31 = new JLabel();
	public static JLabel label41 = new JLabel();
	public static JLabel label51 = new JLabel();
	public static JLabel label61 = new JLabel();

	public static JLabel label12 = new JLabel();
	public static JLabel label22 = new JLabel();
	public static JLabel label32 = new JLabel();
	public static JLabel label42 = new JLabel();
	public static JLabel label52 = new JLabel();
	public static JLabel label62 = new JLabel();

	public static JLabel label13 = new JLabel();
	public static JLabel label23 = new JLabel();
	public static JLabel label33 = new JLabel();
	public static JLabel label43 = new JLabel();
	public static JLabel label53 = new JLabel();
	public static JLabel label63 = new JLabel();

	public static JLabel label14 = new JLabel();
	public static JLabel label24 = new JLabel();
	public static JLabel label34 = new JLabel();
	public static JLabel label44 = new JLabel();
	public static JLabel label54 = new JLabel();
	public static JLabel label64 = new JLabel();

	public static JLabel label15 = new JLabel();
	public static JLabel label25 = new JLabel();
	public static JLabel label35 = new JLabel();
	public static JLabel label45 = new JLabel();
	public static JLabel label55 = new JLabel();
	public static JLabel label65 = new JLabel();

	public static JLabel label16 = new JLabel();
	public static JLabel label26 = new JLabel();
	public static JLabel label36 = new JLabel();
	public static JLabel label46 = new JLabel();
	public static JLabel label56 = new JLabel();
	public static JLabel label66 = new JLabel();

	public static JLabel labelEnd = new JLabel();
	public static JLabel labelEnd2 = new JLabel();

	public static JFrame frameEnd = new JFrame();

	public static int check = 0;

	public static JButton restart = new JButton("Play Again");

	public static JButton another = new JButton("Okay");
	public static JFrame error = new JFrame();
	public static JLabel errorLabel = new JLabel();
	public static JLabel errorLabel2 = new JLabel();

	public static void main(String[] args) {
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameEnd.dispose();
				ans = words.getAnwer().toUpperCase();
				all();
			}
		});
		all();
	}

	public static void creatFrame(JFrame frame, JLabel label, JPanel panel) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(394, 750);
		frame.setLocation(550, 75);
		frame.setTitle("Wordle");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(228, 228, 228));
		frame.setResizable(false);
		frame.add(label);
		frame.add(panel);

	}

	public static void creatLableWordle(JLabel label) {
		label.setText("WORDLE");
		label.setFont(new Font("Montserrat", Font.BOLD, 50));
		label.setBounds(70, 10, 250, 70);
		label.setBackground(new Color(105, 169, 100));
		label.setForeground(Color.white);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
	}

	public static void creatPanel(JFrame frame, JPanel panel, int x, int y) {
		LineBorder border = new LineBorder(Color.gray, 4);
		panel.setBounds(x, y, 59, 59);
		panel.setOpaque(false);
		panel.setBorder(border);

	}

	public static void creatRow(JFrame frame, int x, int y, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4,
			JPanel panel5, JLabel label) {
		creatPanel(frame, panel1, x, y);
		creatFrame(frame, label, panel1);

		creatPanel(frame, panel2, x + 75, y);
		creatFrame(frame, label, panel2);

		creatPanel(frame, panel3, x + 75 + 75, y);
		creatFrame(frame, label, panel3);

		creatPanel(frame, panel4, x + 75 + 75 + 75, y);
		creatFrame(frame, label, panel4);

		creatPanel(frame, panel5, x + 75 + 75 + 75 + 75, y);
		creatFrame(frame, label, panel5);
	}

	public static void creatTextField(JTextField textField) {
		DocumentFilter filter = new UppercaseDocumentFilter();
		AbstractDocument firstNameDoc = (AbstractDocument) textField.getDocument();
		firstNameDoc.setDocumentFilter(filter);
		textField.setBackground(Color.black);
		textField.setFont(new Font("monospaced", Font.BOLD, 50));
		textField.setBorder(BorderFactory.createLineBorder(new Color(228, 228, 228)));
		textField.setForeground(Color.darkGray);
		Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
		attributes.put(TextAttribute.TRACKING, 0.9);

		textField.setFont(textField.getFont().deriveFont(attributes));
		textField.setOpaque(false);
	}

	public static void creatButton(JButton button) {
		button.setBackground(new Color(119, 116, 109));
		button.setForeground(Color.white);
		button.setFont(new Font("Times", Font.BOLD, 15));
		button.setBounds(90, 600, 200, 50);
	}

	public static void creatInput(JButton button1, JTextField textField1, JButton button2, JTextField textField2,
			JFrame frame, int y, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5,
			JLabel label11, JLabel label21, JLabel label31, JLabel label41, JLabel label51, JLabel label61) {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guess = textField1.getText();

				boolean conatin = words.contains(guess);

				if (conatin) {
					textField1.setEnabled(false);
					System.out.println(guess);

					frame.remove(textField1);

					panel1.setOpaque(true);
					panel2.setOpaque(true);
					panel3.setOpaque(true);
					panel4.setOpaque(true);
					panel5.setOpaque(true);

					int guessnu = 0;
					check(guessnu, guess, ans, panel1, 0, label11);
					guessnu = 0;
					check(guessnu, guess, ans, panel2, 1, label21);
					guessnu = 0;
					check(guessnu, guess, ans, panel3, 2, label31);
					guessnu = 0;
					check(guessnu, guess, ans, panel4, 3, label41);
					guessnu = 0;
					check(guessnu, guess, ans, panel5, 4, label51);
					guessnu = 0;

					if (check == 5) {
						frame.dispose();
						labelEnd.setText("Congratulations");
						labelEnd.setFont(new Font("Montserrat", Font.BOLD, 35));

						labelEnd2.setText("You Won!");
						labelEnd2.setFont(new Font("Montserrat", Font.BOLD, 35));

						labelEnd.setBounds(70, 30, 400, 50);
						labelEnd2.setBounds(110, 60, 400, 50);

						labelEnd.setForeground(new Color(105, 169, 100));
						labelEnd2.setForeground(new Color(105, 169, 100));

						frameEnd.setLocation(585, 265);
						restart.setText("Play Again");
						frameEnd.setLayout(null);
						frameEnd.setTitle("Wordle");
						frameEnd.setSize(400, 300);
						frameEnd.setResizable(false);
						frameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						restart.setBounds(95, 175, 200, 50);
						frameEnd.add(restart);
						frameEnd.setVisible(true);
						frameEnd.getContentPane().setBackground(new Color(228, 228, 228));
						frameEnd.add(labelEnd);
						frameEnd.add(labelEnd2);
					}
					check = 0;

					creatTextField(textField2);
					textField2.setBounds(20, y, 60 + 75 + 75 + 75 + 75, 59);
					frame.add(textField2);
					frame.remove(button1);

					creatButton(button2);
					frame.add(button2);
				} else {
					textField1.setText("");

					errorLabel.setText("This word isn't in the file!");
					errorLabel2.setText("Please write a different one!");

					errorLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
					errorLabel2.setFont(new Font("Montserrat", Font.BOLD, 25));

					errorLabel.setBounds(20, 0, 375, 100);
					errorLabel2.setBounds(15, 50, 375, 100);

					another.setBounds(130, 145, 100, 50);
					another.setBackground(Color.gray);
					another.setFont(new Font("Montserrat", Font.BOLD, 20));
					another.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							error.dispose();

						}
					});

					error.setVisible(true);
					error.setSize(375, 250);
					error.setLocation(560, 330);
					error.setTitle("ERROR");
					error.setLayout(null);
					error.getContentPane().setBackground(new Color(228, 228, 228));
					error.setResizable(false);

					error.add(errorLabel);
					error.add(errorLabel2);
					error.add(another);
				}
			}
		});
	}

	public static void creatListenerForTextField(JTextField textField1) {
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField1.getText().length() >= 5)
					e.consume();
			}
		});
	}

	public static void check(int guessnu, String guess, String ans, JPanel panel1, int pos, JLabel label1) {
		guessnu = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(pos) == ans.charAt(i)) {
				panel1.setBackground(new Color(201, 180, 87));
				label1.setText(String.valueOf(guess.charAt(pos)));
				label1.setVisible(true);
				label1.setFont(new Font("monospaced", Font.BOLD, 50));
				label1.setBounds(11, 0, 50, 50);
				label1.setForeground(Color.darkGray);
				panel1.setLayout(null);
				panel1.repaint();
				panel1.revalidate();
				panel1.add(label1);
				guessnu = 1;
			}
		}
		if (guess.charAt(pos) == ans.charAt(pos)) {
			panel1.setBackground(new Color(105, 169, 100));
			label1.setText(String.valueOf(guess.charAt(pos)));
			label1.setVisible(true);
			label1.setFont(new Font("monospaced", Font.BOLD, 50));
			label1.setBounds(11, 0, 50, 50);
			label1.setForeground(Color.darkGray);
			panel1.setLayout(null);
			panel1.repaint();
			panel1.revalidate();
			panel1.add(label1);
			check++;

		} else if (guessnu == 0) {
			panel1.setBackground(Color.GRAY);
			label1.setText(String.valueOf(guess.charAt(pos)));
			label1.setVisible(true);
			label1.setFont(new Font("monospaced", Font.BOLD, 50));
			label1.setBounds(11, 0, 50, 50);
			label1.setForeground(Color.darkGray);
			panel1.setLayout(null);
			panel1.repaint();
			panel1.revalidate();
			panel1.add(label1);

		}
		guessnu = 0;
	}

	public static void all() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		System.out.println(ans);

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		JPanel panel11 = new JPanel();
		JPanel panel21 = new JPanel();
		JPanel panel31 = new JPanel();
		JPanel panel41 = new JPanel();
		JPanel panel51 = new JPanel();

		JPanel panel12 = new JPanel();
		JPanel panel22 = new JPanel();
		JPanel panel32 = new JPanel();
		JPanel panel42 = new JPanel();
		JPanel panel52 = new JPanel();

		JPanel panel13 = new JPanel();
		JPanel panel23 = new JPanel();
		JPanel panel33 = new JPanel();
		JPanel panel43 = new JPanel();
		JPanel panel53 = new JPanel();

		JPanel panel14 = new JPanel();
		JPanel panel24 = new JPanel();
		JPanel panel34 = new JPanel();
		JPanel panel44 = new JPanel();
		JPanel panel54 = new JPanel();

		JPanel panel15 = new JPanel();
		JPanel panel25 = new JPanel();
		JPanel panel35 = new JPanel();
		JPanel panel45 = new JPanel();
		JPanel panel55 = new JPanel();

		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		JTextField textField4 = new JTextField();
		JTextField textField5 = new JTextField();
		JTextField textField6 = new JTextField();

		JButton button1 = new JButton("SUBMIT GUESS");
		JButton button2 = new JButton("SUBMIT GUESS");
		JButton button3 = new JButton("SUBMIT GUESS");
		JButton button4 = new JButton("SUBMIT GUESS");
		JButton button5 = new JButton("SUBMIT GUESS");
		JButton button6 = new JButton("SUBMIT GUESS");

		creatButton(restart);

		creatLableWordle(label);
		creatRow(frame, 10, 110, panel1, panel2, panel3, panel4, panel5, label);
		creatRow(frame, 10, 185, panel11, panel21, panel31, panel41, panel51, label);
		creatRow(frame, 10, 185 + 75, panel12, panel22, panel32, panel42, panel52, label);
		creatRow(frame, 10, 185 + 75 + 75, panel13, panel23, panel33, panel43, panel53, label);
		creatRow(frame, 10, 185 + 75 + 75 + 75, panel14, panel24, panel34, panel44, panel54, label);
		creatRow(frame, 10, 185 + 75 + 75 + 75 + 75, panel15, panel25, panel35, panel45, panel55, label);

		creatTextField(textField1);
		textField1.setBounds(20, 107, 60 + 75 + 75 + 75 + 75 + 75, 59);
		frame.add(textField1);
		creatButton(button1);

		creatListenerForTextField(textField1);
		creatListenerForTextField(textField2);
		creatListenerForTextField(textField3);
		creatListenerForTextField(textField4);
		creatListenerForTextField(textField5);
		creatListenerForTextField(textField6);

		creatInput(button1, textField1, button2, textField2, frame, 107 + 75, panel1, panel2, panel3, panel4, panel5,
				label11, label21, label31, label41, label51, label61);
		creatInput(button2, textField2, button3, textField3, frame, 107 + 75 + 75, panel11, panel21, panel31, panel41,
				panel51, label12, label22, label32, label42, label52, label62);
		creatInput(button3, textField3, button4, textField4, frame, 107 + 75 + 75 + 75, panel12, panel22, panel32,
				panel42, panel52, label13, label23, label33, label43, label53, label63);
		creatInput(button4, textField4, button5, textField5, frame, 107 + 75 + 75 + 75 + 75, panel13, panel23, panel33,
				panel43, panel53, label14, label24, label34, label44, label54, label64);
		creatInput(button5, textField5, button6, textField6, frame, 107 + 75 + 75 + 75 + 75 + 75, panel14, panel24,
				panel34, panel44, panel54, label15, label25, label35, label45, label55, label65);

		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guess = textField6.getText();

				boolean conatin = words.contains(guess);
				if (conatin) {
					textField6.setEnabled(false);
					System.out.println(guess);

					frame.remove(textField5);

					panel15.setOpaque(true);
					panel25.setOpaque(true);
					panel35.setOpaque(true);
					panel45.setOpaque(true);
					panel55.setOpaque(true);

					int guessnu = 0;
					check(guessnu, guess, ans, panel15, 0, label16);
					guessnu = 0;
					check(guessnu, guess, ans, panel25, 1, label26);
					guessnu = 0;
					check(guessnu, guess, ans, panel35, 2, label36);
					guessnu = 0;
					check(guessnu, guess, ans, panel45, 3, label46);
					guessnu = 0;
					check(guessnu, guess, ans, panel55, 4, label56);
					guessnu = 0;

					if (check == 5) {
						frame.dispose();
						labelEnd.setText("Congratulations");
						labelEnd.setFont(new Font("Montserrat", Font.BOLD, 35));

						labelEnd2.setText("You Won!");
						labelEnd2.setFont(new Font("Montserrat", Font.BOLD, 35));

						labelEnd.setBounds(70, 30, 400, 50);
						labelEnd2.setBounds(110, 60, 400, 50);

						labelEnd.setForeground(new Color(105, 169, 100));
						labelEnd2.setForeground(new Color(105, 169, 100));

						frameEnd.setLocation(585, 265);
						restart.setText("Play Again");
						frameEnd.setLayout(null);
						frameEnd.setTitle("Wordle");
						frameEnd.setSize(400, 300);
						frameEnd.setResizable(false);
						frameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						restart.setBounds(95, 175, 200, 50);
						frameEnd.add(restart);
						frameEnd.setVisible(true);
						frameEnd.getContentPane().setBackground(new Color(228, 228, 228));
						frameEnd.add(labelEnd);
						frameEnd.add(labelEnd2);

					} else {
						frame.dispose();
						labelEnd.setText("Sorry you lost!");
						labelEnd.setFont(new Font("Montserrat", Font.BOLD, 35));

						labelEnd2.setText("The answer was: " + ans);
						labelEnd2.setFont(new Font("Montserrat", Font.BOLD, 30));

						labelEnd.setBounds(70, 30, 400, 50);
						labelEnd2.setBounds(15, 100, 400, 50);

						labelEnd.setForeground(new Color(220, 20, 60));
						labelEnd2.setForeground(Color.gray);

						frameEnd.setLocation(585, 265);
						restart.setText("Try Again");
						frameEnd.setLayout(null);
						frameEnd.setTitle("Wordle");
						frameEnd.setSize(400, 300);
						frameEnd.setResizable(false);
						frameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						restart.setBounds(95, 175, 200, 50);
						frameEnd.add(restart);
						frameEnd.setVisible(true);
						frameEnd.getContentPane().setBackground(new Color(228, 228, 228));
						frameEnd.add(labelEnd);
						frameEnd.add(labelEnd2);
					}
					check = 0;
				} else {
					textField6.setText("");

					errorLabel.setText("This word isn't in the file!");
					errorLabel2.setText("Please write a different one!");

					errorLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
					errorLabel2.setFont(new Font("Montserrat", Font.BOLD, 25));

					errorLabel.setBounds(20, 0, 375, 100);
					errorLabel2.setBounds(15, 50, 375, 100);

					another.setBounds(130, 145, 100, 50);
					another.setBackground(Color.gray);
					another.setFont(new Font("Montserrat", Font.BOLD, 20));
					another.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							error.dispose();

						}
					});

					error.setVisible(true);
					error.setSize(375, 250);
					error.setLocation(560, 330);
					error.setTitle("ERROR");
					error.setLayout(null);
					error.getContentPane().setBackground(new Color(228, 228, 228));
					error.setResizable(false);

					error.add(errorLabel);
					error.add(errorLabel2);
					error.add(another);
				}

			}
		});
		frame.add(button1);
	}

}

class UppercaseDocumentFilter extends DocumentFilter {
	@Override
	public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
			throws BadLocationException {
		fb.insertString(offset, text.toUpperCase(), attr);
	}

	@Override
	public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		fb.replace(offset, length, text.toUpperCase(), attrs);
	}
}
