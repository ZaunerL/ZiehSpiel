package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnCheckeButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ZiehGUI z = new ZiehGUI();
		
		if(z.getroffen){
			z.genZahl = (int) ((Math.random()*z.schwierigkeit)+1);
			z.getroffen = false;
		}

		int gewaehlt = Integer.parseInt(z.getTextField().getText());

		if(z.genZahl == gewaehlt){
			z.getAusgabe().setText("Treffer");
			z.getroffen = true;
		}

		else if(z.genZahl > gewaehlt){
			int dif = z.genZahl - gewaehlt;
			z.opt = z.opt - 1;
			if(z.opt >= 0) z.getPruefung().setText(String.valueOf(z.genZahl+" Schritte �brig zu Optimal: "+z.opt));
			else{
				z.getPruefung().setText(String.valueOf(z.genZahl+" Optimal: Nicht mehr m�glich!"));
			}
			z.getAusgabe().setText("gew�hlte Zahl m�sste gr��er sein! Differenz: "+dif);

		}
		else if(gewaehlt > z.genZahl){
			int dif = gewaehlt - z.genZahl;
			z.opt = z.opt - 1; 
			if(z.opt >= 0) z.getPruefung().setText(String.valueOf(z.genZahl+" Schritte �brig zu Optimal: "+z.opt));
			else{
				z.getPruefung().setText(String.valueOf(z.genZahl+" Optimal: Nicht mehr m�glich!"));
			}
			z.getAusgabe().setText("gew�hlte Zahlt m�sste gro�er sein! Differenz: "+dif);
		}

	}

}
