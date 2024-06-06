package normes.couleurs;

import tools.OutilCouleur;

public class DistanceEuclidienne implements NormeCouleurs {
	@Override
	public double distanceCouleur(int c1, int c2) {
		int[] tab1 = OutilCouleur.getTabColor(c1);
		int[] tab2 = OutilCouleur.getTabColor(c2);

		return Math.pow(tab1[0] - tab2[0], 2) + Math.pow(tab1[1] - tab2[1], 2) + Math.pow(tab1[2] - tab2[2], 2);
	}
}
