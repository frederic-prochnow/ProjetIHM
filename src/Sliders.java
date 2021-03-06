import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sliders extends JPanel{

	private static final long serialVersionUID = -4575342049181712379L;
	private PanelDeCouleurs pan;
	private JLabel labelRed;
	private JLabel labelBlue;
	private JLabel labelGreen;
	private JSlider sliderRed,sliderBlue,sliderGreen;
	
	public Sliders(PanelDeCouleurs panneau){
		this.pan = panneau;
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		this.setLayout(new GridLayout(3,3));
		
		JLabel label = new JLabel("Red");
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label);
		sliderRed = new JSlider(0,255,pan.getCouleurs(pan.selectionne).getCouleur().getRed());
		this.add(sliderRed);
		sliderRed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelRed.setText(""+sliderRed.getValue());
				if(pan.selectionne != -1){
					Color temp = pan.getCouleurs(pan.selectionne).getCouleur();
					temp = new Color(sliderRed.getValue(), temp.getGreen(), temp.getBlue());
					pan.setCouleur(pan.selectionne, temp.getRed(), temp.getGreen(), temp.getBlue());
					pan.repaint();
				}
			}
		});
		this.labelRed = new JLabel(""+sliderRed.getValue());
		this.add(labelRed);
		
		JLabel label_1 = new JLabel("Green");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label_1);
		sliderGreen = new JSlider(0,255,pan.getCouleurs(pan.selectionne).getCouleur().getGreen());
		this.add(sliderGreen);
		sliderGreen.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelGreen.setText(""+sliderGreen.getValue());
				if(pan.selectionne != -1){
					Color temp = pan.getCouleurs(pan.selectionne).getCouleur();
					temp = new Color(temp.getRed(), sliderGreen.getValue(), temp.getBlue());
					pan.setCouleur(pan.selectionne, temp.getRed(), temp.getGreen(), temp.getBlue());
					pan.repaint();
				}
			}
		});
		this.labelGreen = new JLabel(""+sliderGreen.getValue());
		this.add(labelGreen);
		
		JLabel label_2 = new JLabel("Blue");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label_2);
		sliderBlue = new JSlider(0,255,pan.getCouleurs(pan.selectionne).getCouleur().getBlue());
		this.add(sliderBlue);
		sliderBlue.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelBlue.setText(""+sliderBlue.getValue());
				if(pan.selectionne != -1){
					Color temp = pan.getCouleurs(pan.selectionne).getCouleur();
					temp = new Color(temp.getRed(), temp.getGreen(), sliderBlue.getValue());
					pan.setCouleur(pan.selectionne, temp.getRed(), temp.getGreen(), temp.getBlue());
					pan.repaint();
				}
			}
		});
		this.labelBlue = new JLabel(""+sliderBlue.getValue());
		this.add(labelBlue);
		
		this.labelRed.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelBlue.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelGreen.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.repaint();
	}
	
	
	public void updateSliders(){
		this.sliderRed.setValue(pan.getCouleurs(pan.selectionne).getCouleur().getRed());
		this.sliderBlue.setValue(pan.getCouleurs(pan.selectionne).getCouleur().getBlue());
		this.sliderGreen.setValue(pan.getCouleurs(pan.selectionne).getCouleur().getGreen());
		this.repaint();
	}
}
