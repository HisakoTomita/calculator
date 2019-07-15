/* 61713041 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Calculator {
	private JLabel label;
	private List<String> list = new ArrayList<String>();
	private List<Integer> numlist = new ArrayList<Integer>();
	private int ans = 0;
	private int operand = 0;

	class ZeroButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("0");
			list.add("0");
		}
	}

	class OneButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("1");
			list.add("1");
		}
	}

	class TwoButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("2");
			list.add("2");
		}
	}

	class ThreeButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("3");
			list.add("3");
		}
	}

	class FourButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("4");
			list.add("4");
		}
	}

	class FiveButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("5");
			list.add("5");
		}
	}

	class SixButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("6");
			list.add("6");
		}
	}

	class SevenButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("7");
			list.add("7");
		}
	}

	class EightButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("8");
			list.add("8");
		}
	}

	class NineButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("9");
			list.add("9");
		}
	}

	class PlusButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("+");
			list.add("+");
		}
	}

	class MinusButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("-");
			list.add("-");
		}
	}

	class TimesButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("*");
			list.add("*");
		}
	}

	class DividesButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("/");
			list.add("/");
		}
	}

	class EqualButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label.setText("=");
			list.add("=");
			label.setText(String.valueOf(calculate(list)));
		}
	}

	class DelButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* if list is empty, tell by dialog */
			if (list.size() > 0) {
				list.clear();
				ans = 0;
				label.setText("0");
			} else {
				JOptionPane.showMessageDialog(null, "None Input", "Error",
											  JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public int calculate(List<String> list) {
		Iterator<String> iter = list.iterator();
		String operatorNow = "+";
		String operatorNext = null;
		while(iter.hasNext()) {
			String s = iter.next();
			if (!(s.matches("^[0-9]+$"))) { // operator(+,-,*,/,=) was pushed
				operatorNext = s;
				for (int i = 0; i < numlist.size(); i++) {
					for (int j = 0; j < i; j++) {
						numlist.set(i, numlist.get(i) * 10);
					}
					operand += numlist.get(i);
				}
				numlist.clear();
				if (operatorNow.equals("+")) {
					ans += operand;
				} else if (operatorNow.equals("-")) {
					ans -= operand;
				} else if (operatorNow.equals("*")) {
					ans *= operand;
				} else if (operatorNow.equals("/")) {
					ans /= operand;
				} else if (operatorNow.equals("=")) {
					break;
				}
				operand = 0;
				operatorNow = operatorNext;
			} else { // number was pushed
				numlist.add(0, Integer.parseInt(s));
			}
		}
		return ans;
	}

	public Component createComponents() {
		label = new JLabel(" 0 ");

		/* 0 button */
		JButton zeroButton = new JButton(" 0 ");
		ZeroButtonAction zeroButtonListener = new ZeroButtonAction();
		zeroButton.addActionListener( zeroButtonListener );

		/* 1 button */
		JButton oneButton = new JButton(" 1 ");
		OneButtonAction oneButtonListener = new OneButtonAction();
		oneButton.addActionListener( oneButtonListener );

		/* 2 button */
		JButton twoButton = new JButton(" 2 ");
		TwoButtonAction twoButtonListener = new TwoButtonAction();
		twoButton.addActionListener( twoButtonListener );

		/* 3 button */
		JButton threeButton = new JButton(" 3 ");
		ThreeButtonAction threeButtonListener = new ThreeButtonAction();
		threeButton.addActionListener( threeButtonListener );

		/* 4 button */
		JButton fourButton = new JButton(" 4 ");
		FourButtonAction fourButtonListener = new FourButtonAction();
		fourButton.addActionListener( fourButtonListener );

		/* 5 button */
		JButton fiveButton = new JButton(" 5 ");
		FiveButtonAction fiveButtonListener = new FiveButtonAction();
		fiveButton.addActionListener( fiveButtonListener );

		/* 6 button */
		JButton sixButton = new JButton(" 6 ");
		SixButtonAction sixButtonListener = new SixButtonAction();
		sixButton.addActionListener( sixButtonListener );

		/* 7 button */
		JButton sevenButton = new JButton(" 7 ");
		SevenButtonAction sevenButtonListener = new SevenButtonAction();
		sevenButton.addActionListener( sevenButtonListener );

		/* 8 button */
		JButton eightButton = new JButton(" 8 ");
		EightButtonAction eightButtonListener = new EightButtonAction();
		eightButton.addActionListener( eightButtonListener );

		/* 9 button */
		JButton nineButton = new JButton(" 9 ");
		NineButtonAction nineButtonListener = new NineButtonAction();
		nineButton.addActionListener( nineButtonListener );

		/* + button */
		JButton plusButton = new JButton(" + ");
		PlusButtonAction plusButtonListener = new PlusButtonAction();
		plusButton.addActionListener( plusButtonListener );

		/* - button */
		JButton minusButton = new JButton(" - ");
		MinusButtonAction minusButtonListener = new MinusButtonAction();
		minusButton.addActionListener( minusButtonListener );

		/* * button */
		JButton timesButton = new JButton(" * ");
		TimesButtonAction timesButtonListener = new TimesButtonAction();
		timesButton.addActionListener( timesButtonListener );

		/* / button */
		JButton dividesButton = new JButton(" / ");
		DividesButtonAction dividesButtonListener = new DividesButtonAction();
		dividesButton.addActionListener( dividesButtonListener );

		/* = button */
		JButton equalButton = new JButton(" = ");
		EqualButtonAction equalButtonListener = new EqualButtonAction();
		equalButton.addActionListener( equalButtonListener );

		/* C button */
		JButton delButton = new JButton(" C ");
		DelButtonAction delButtonListener = new DelButtonAction();
		delButton.addActionListener( delButtonListener );

		/* 7 8 9 / */
		JPanel subPane1 = new JPanel();
		subPane1.setLayout(new GridLayout(1, 0));
		subPane1.add(sevenButton);
		subPane1.add(eightButton);
		subPane1.add(nineButton);
		subPane1.add(dividesButton);

		/* 4 5 6 * */
		JPanel subPane2 = new JPanel();
		subPane2.setLayout(new GridLayout(1, 0));
		subPane2.add(fourButton);
		subPane2.add(fiveButton);
		subPane2.add(sixButton);
		subPane2.add(timesButton);

		/* 1 2 3 - */
		JPanel subPane3 = new JPanel();
		subPane3.setLayout(new GridLayout(1, 0));
		subPane3.add(oneButton);
		subPane3.add(twoButton);
		subPane3.add(threeButton);
		subPane3.add(minusButton);

		/* 0 C = + */
		JPanel subPane4 = new JPanel();
		subPane4.setLayout(new GridLayout(1, 0));
		subPane4.add(zeroButton);
		subPane4.add(delButton);
		subPane4.add(equalButton);
		subPane4.add(plusButton);

		/* most top layer */
		JPanel mainPane = new JPanel();
		mainPane.setBorder(BorderFactory.createEmptyBorder( 30, 30, 30, 30 ));
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		mainPane.add(label);

		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(subPane1);
		mainPane.add(subPane2);
		mainPane.add(subPane3);
		mainPane.add(subPane4);

		return mainPane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		Calculator app = new Calculator();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
