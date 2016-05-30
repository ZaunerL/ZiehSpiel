package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class ZiehGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCheck;
	private JTextField ausgabe;
	boolean getroffen = true;
	int genZahl = 0;
	int schwierigkeit = 1000;
	int opt = (int)(Math.log(schwierigkeit)/Math.log(2));
	private JTextField pruefung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZiehGUI frame = new ZiehGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZiehGUI() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		setTextField(new JTextField());
		getTextField().setText("0");
		contentPane.add(getTextField(), BorderLayout.SOUTH);
		getTextField().setColumns(10);

		btnCheck = new JButton("Checke Zahl");
		btnCheck.addActionListener(new BtnCheckeButtonActionListener());
		contentPane.add(btnCheck, BorderLayout.EAST);

		setAusgabe(new JTextField());
		getAusgabe().setForeground(Color.BLUE);
		getAusgabe().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getAusgabe().setText("VERSUCHEN SIE DIE ZUFALLSZAHL ZU ERRATEN!");
		contentPane.add(getAusgabe(), BorderLayout.NORTH);
		getAusgabe().setColumns(10);

		setPruefung(new JTextField());
		contentPane.add(getPruefung(), BorderLayout.WEST);
		contentPane.add(getAusgabe());
		contentPane.add(getAusgabe(), BorderLayout.NORTH);
		getAusgabe().setColumns(10);

		setPruefung(new JTextField());
		contentPane.add(getPruefung(), BorderLayout.CENTER);
	}
		class BtnCheckeButtonActionListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				if(getroffen){
					genZahl = (int) ((Math.random()*schwierigkeit)+1);
					getroffen = false;
				}

				int gewaehlt = Integer.parseInt(textField.getText());

				if(genZahl == gewaehlt){
					ausgabe.setText("Treffer");
					getroffen = true;
				}

				else if(genZahl > gewaehlt){
					int dif = genZahl - gewaehlt;
					opt = opt - 1;
					if(opt >= 0) pruefung.setText(String.valueOf(genZahl+" Schritte übrig zu Optimal: "+opt));
					else{
						pruefung.setText(String.valueOf(genZahl+" Optimal: Nicht mehr möglich!"));
					}
					ausgabe.setText("gewählte Zahl müsste größer sein! Differenz: "+dif);

				}
				else if(gewaehlt > genZahl){
					int dif = gewaehlt - genZahl;
					opt = opt - 1; 
					if(opt >= 0) pruefung.setText(String.valueOf(genZahl+" Schritte übrig zu Optimal: "+opt));
					else{
						pruefung.setText(String.valueOf(genZahl+" Optimal: Nicht mehr möglich!"));
					}
					ausgabe.setText("gewählte Zahlt müsste kleiner sein! Differenz: "+dif);
				}
			}
		}


	public JTextField getAusgabe() {
		return ausgabe;
	}

	public void setAusgabe(JTextField ausgabe) {
		this.ausgabe = ausgabe;
	}

	public JTextField getPruefung() {
		return pruefung;
	}

	public void setPruefung(JTextField pruefung) {
		this.pruefung = pruefung;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
