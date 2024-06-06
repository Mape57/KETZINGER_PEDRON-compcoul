package normes.couleurs;

import tools.OutilCouleur;

public class Cielab_better implements NormeCouleurs {
	@Override
	public double distanceCouleur(int c1, int c2) {
		int[] tab1 = OutilCouleur.getTabColor(c1);
		int[] tab2 = OutilCouleur.getTabColor(c2);
		tab1 = Cielab.rgb2lab(tab1[0], tab1[1], tab1[2]);
		tab2 = Cielab.rgb2lab(tab2[0], tab2[1], tab2[2]);

		double C1 = Math.sqrt(tab1[1] * tab1[1] + tab1[2] * tab1[2]);
		double C2 = Math.sqrt(tab2[1] * tab2[1] + tab2[2] * tab2[2]);
		double SC = 1 + 0.045 * C1;
		double SH = 1 + 0.015 * C1;
		double deltaL = tab1[0] - tab2[0];
		double deltaC = C1 - C2;
		double deltaH = Math.sqrt((tab1[1] - tab2[1]) * (tab1[1] - tab2[1]) + (tab1[2] - tab2[2]) * (tab1[2] - tab2[2]) - deltaC * deltaC);
		double res = Math.sqrt(Math.pow(deltaL / 1, 2) + Math.pow(deltaC / SC, 2) + Math.pow(deltaH / SH, 2));
		return res;
	}
}
