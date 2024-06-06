package tools;

import normes.couleurs.NormeCouleurs;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Palette {
	ArrayList<Color> colors;

	public Palette(Color[] colors) {
		this.colors = new ArrayList<>(Arrays.asList(colors));
	}

	public Color getPlusProche(Color c, NormeCouleurs normeCouleurs) {
		double bestSimilValue = -1;
		int bestSimilIndex = -1;

		for (int i = 0; i < this.colors.size(); i++) {
			double sim = normeCouleurs.distanceCouleur(c.getRGB(), this.colors.get(i).getRGB());

			if (sim > bestSimilValue) {
				bestSimilIndex = i;
				bestSimilValue = sim;
			}
		}

		return colors.get(bestSimilIndex);
	}
}
