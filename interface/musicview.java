import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class musicview extends JFrame{
	private int i = 0;
	private JLabel label;
	private JLabel labelup;
	private JLabel labeldown;
	public musicview(){
		final String[] choix = new String[3];
		final String[] choixmini = new String[3];
		choix[0]= "----------Canon----------";
		choix[1]= "---------Good Life--------";
		choix[2]= "-----How to save a life------";
		choixmini[0]= "                   Canon             ";
		choixmini[1]= "                 Good Life           ";
		choixmini[2]= "             How to save a life      ";
		this.setTitle("SONGS");
		this.setSize(200,250);
		this.setLocationRelativeTo(null);		//窗口显示在屏幕中间
		this.setLayout(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //arret du programme
		label = new JLabel(choix[0]);
		label.setBounds(0, 40, 200, 80);
		labelup = new JLabel(choixmini[1]);
		labelup.setBounds(0, 0, 200, 80);
		labeldown = new JLabel(choixmini[2]);
		labeldown.setBounds(0, 80, 200, 80);
		
		JButton suivant = new JButton("next");
		suivant.setBounds(10,150,50,40);
		JButton precedent = new JButton("avant");
		precedent.setBounds(70,150,50,40);
		JButton valider = new JButton("OK");
		valider.setBounds(130,150,50,50);
		suivant.addActionListener(new ActionListener(){
			int left = 0;
			int right = 0;
			public void actionPerformed(ActionEvent e) {
				++i;
				if(i<0){
					i=i+1;
				}
				if(i==choix.length){
					i=0;
				}
				if(i-1 < 0){
					left = choix.length-1;
				}
				else{left = i-1;}
				if(i+1 == choix.length){
					right = 0;
				}
				else {right = i+1;}
				label.setText(choix[i]);
				labelup.setText(choixmini[left]);
				labeldown.setText(choixmini[right]);
				//System.out.println("suivant" +i);
			}
		});
		precedent.addActionListener(new ActionListener(){
			int left = 0;
			int right = 0;
			public void actionPerformed(ActionEvent e) {
				--i;
				if(i == choix.length){
					i=i-1;
				}
				if(i < 0){
					i=choix.length-1;
				}
				if(i-1 < 0){
					left = choix.length-1;
				}
				else{left = i-1;}
				if(i+1 == choix.length){
					right = 0;
				}
				else {right = i+1;}
				label.setText(choix[i]);
				labelup.setText(choixmini[left]);
				labeldown.setText(choixmini[right]);
				//System.out.println("precedent "+i);
			}
		});
		valider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.add(label);
		this.add(labelup);
		this.add(labeldown);
		this.add(suivant);
		this.add(precedent);
		this.add(valider);
		this.setVisible(true);
	}
}
