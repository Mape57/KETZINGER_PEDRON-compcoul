package tools;

import normes.couleurs.DistanceEuclidienne;
import normes.couleurs.NormeCouleurs;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OutilImage {
	public static BufferedImage toGrayScale(BufferedImage image) {
		int w = image.getWidth(), h = image.getHeight();
		BufferedImage im2 = new BufferedImage(w, h, image.getType());
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				im2.setRGB(x, y, OutilCouleur.getGrayScale(image.getRGB(x, y)));
			}
		}
		return im2;
	}

	public static BufferedImage redFilter(BufferedImage image) {
		return filter(image, 0xFF0000);
	}

	public static BufferedImage blueAndGreenFilter(BufferedImage image) {
		return filter(image, 0x00FFFF);
	}

	public static BufferedImage filter(BufferedImage image, int filter) {
		int w = image.getWidth(), h = image.getHeight();
		BufferedImage im2 = new BufferedImage(w, h, image.getType());
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				im2.setRGB(x, y, OutilCouleur.filter(image.getRGB(x, y), filter));
			}
		}
		return im2;
	}

	public static BufferedImage filter(BufferedImage image, Palette palette, NormeCouleurs norme) {
		int w = image.getWidth(), h = image.getHeight();
		BufferedImage im2 = new BufferedImage(w, h, image.getType());
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int color = palette.getPlusProche(new Color(image.getRGB(x, y)), norme).getRGB();
				im2.setRGB(x, y, color);
			}
		}
		return im2;
	}
}
