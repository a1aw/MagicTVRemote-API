package com.github.mob41.magictv.remote.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.github.mob41.magictv.remote.api.MagicTVRemote;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MTVRemoteUI extends JFrame {
	private JLabel lblStatus;
	private MagicTVRemote re;
	private String ip = null;
	private int port = 23456;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTVRemoteUI frame = new MTVRemoteUI();
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
	public MTVRemoteUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		setTitle("MagicTVRemote");
		
		setBounds(0, 0, 400, 760);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnChangeHost = new JButton("Change host");
		btnChangeHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputHost();
			}
		});
		panel.add(btnChangeHost, "2, 2");
		
		JButton btnPower = new JButton("Power");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.power();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnPower, "6, 2");
		
		JButton btnGuide = new JButton("Guide");
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (re != null){
					try {
						re.guide();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e1) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnGuide, "2, 6");
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.menu();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e2) {
						lblStatus.setText("Status: Send error: " + e2 + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnHome, "4, 6");
		
		JButton btnText = new JButton("Text");
		panel.add(btnText, "6, 6");
		
		JButton btnAspect = new JButton("Aspect");
		panel.add(btnAspect, "2, 8");
		
		JButton btnAudio = new JButton("Audio");
		panel.add(btnAudio, "4, 8");
		
		JButton btnSubtitle = new JButton("Subtitle");
		panel.add(btnSubtitle, "6, 8");
		
		JButton button = new JButton("< Back");
		panel.add(button, "2, 10");
		
		JButton btnInfo = new JButton("Info");
		panel.add(btnInfo, "6, 10");
		
		JButton btnUp = new JButton("Up");
		panel.add(btnUp, "4, 12");
		
		JButton btnLeft = new JButton("Left");
		panel.add(btnLeft, "2, 14");
		
		JButton btnOk = new JButton("OK");
		panel.add(btnOk, "4, 14");
		
		JButton btnRight = new JButton("Right");
		panel.add(btnRight, "6, 14");
		
		JButton btnDown = new JButton("Down");
		panel.add(btnDown, "4, 16");
		
		JButton btnVol = new JButton("VOL +");
		panel.add(btnVol, "2, 18");
		
		JButton btnCh = new JButton("CH +");
		panel.add(btnCh, "6, 18");
		
		JButton btnMute = new JButton("Mute");
		panel.add(btnMute, "4, 20");
		
		JButton btnVol_1 = new JButton("VOL -");
		panel.add(btnVol_1, "2, 22");
		
		JButton btnCh_1 = new JButton("CH -");
		panel.add(btnCh_1, "6, 22");
		
		JButton btnRecord = new JButton("Record");
		panel.add(btnRecord, "2, 24");
		
		JButton btnPause = new JButton("Pause");
		panel.add(btnPause, "4, 24");
		
		JButton btnStop = new JButton("Stop");
		panel.add(btnStop, "6, 24");
		
		JButton button_1 = new JButton("<< Fast-reverse");
		panel.add(button_1, "2, 26");
		
		JButton btnPlay = new JButton("Play");
		panel.add(btnPlay, "4, 26");
		
		JButton btnFastforward = new JButton("Fast-forward >>");
		panel.add(btnFastforward, "6, 26");
		
		JButton button_2 = new JButton("|< Replay");
		panel.add(button_2, "2, 28");
		
		JButton btnLiveSource = new JButton("Live source");
		panel.add(btnLiveSource, "4, 28");
		
		JButton btnSkip = new JButton("Skip >|");
		panel.add(btnSkip, "6, 28");
		
		JButton button_3 = new JButton("1");
		panel.add(button_3, "2, 32");
		
		JButton button_4 = new JButton("2");
		panel.add(button_4, "4, 32");
		
		JButton button_5 = new JButton("3");
		panel.add(button_5, "6, 32");
		
		JButton button_6 = new JButton("4");
		panel.add(button_6, "2, 34");
		
		JButton button_7 = new JButton("5");
		panel.add(button_7, "4, 34");
		
		JButton button_8 = new JButton("6");
		panel.add(button_8, "6, 34");
		
		JButton button_9 = new JButton("7");
		panel.add(button_9, "2, 36");
		
		JButton button_10 = new JButton("8");
		panel.add(button_10, "4, 36");
		
		JButton button_11 = new JButton("9");
		panel.add(button_11, "6, 36");
		
		JButton btnClear = new JButton("Clear");
		panel.add(btnClear, "2, 38");
		
		JButton button_12 = new JButton("0");
		panel.add(button_12, "4, 38");
		
		JButton btnEnter = new JButton("Enter");
		panel.add(btnEnter, "6, 38");
		
		JButton btnRed = new JButton("Red");
		btnRed.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRed.setForeground(Color.BLACK);
		btnRed.setBackground(Color.RED);
		panel.add(btnRed, "2, 40");
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setForeground(Color.BLACK);
		btnGreen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGreen.setBackground(new Color(50, 205, 50));
		panel.add(btnGreen, "6, 40");
		
		JButton btnYellow = new JButton("Yellow");
		btnYellow.setForeground(Color.BLACK);
		btnYellow.setFont(new Font("PMingLiU", Font.BOLD, 12));
		btnYellow.setBackground(new Color(255, 255, 0));
		panel.add(btnYellow, "2, 42");
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.setBackground(new Color(0, 0, 205));
		btnBlue.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBlue.setForeground(Color.BLACK);
		panel.add(btnBlue, "6, 42");
		
		lblStatus = new JLabel("Status: No host specified.");
		panel.add(lblStatus, "2, 46, 5, 1");
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				inputHost();
				String name = re.getModel();
				if (!name.equals("")){
					lblStatus.setText("Status: Connected to \"" + name + "\"");
				}
			}
		});
	}
	
	public void inputHost(){
		InputHostPanel inpanel = new InputHostPanel();
		int option = JOptionPane.showOptionDialog(this, inpanel, "Change hostname", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "Cancel"}, 1);
		
		if (option == 1 || option == JOptionPane.CLOSED_OPTION){
			return;
		}
		
		ip = inpanel.getHostname();
		port = inpanel.getPort();
		
		re = new MagicTVRemote(ip, port);
	}
}
