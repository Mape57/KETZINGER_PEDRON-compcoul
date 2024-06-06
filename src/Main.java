import normes.couleurs.Cielab;
import normes.couleurs.Cielab_better;
import normes.couleurs.DistanceEuclidienne;
import normes.couleurs.Redmean;
import tools.OutilImage;
import tools.Palette;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1.1.
		BufferedImage im = ImageIO.read(new File("resources/arbre.jpg"));
		ImageIO.write(im, "jpg", new File("resources/arbre2_copie.jpg"));

		// 1.2.
		int w = im.getWidth(), h = im.getHeight();
		BufferedImage im2 = new BufferedImage(w, h, im.getType());
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				im2.setRGB(x, y, im.getRGB(x, y));
			}
		}
		ImageIO.write(im2, "jpg", new File("resources/arbre3_copiePixel.jpg"));

		// 1.4.
		im2 = OutilImage.toGrayScale(im);
		ImageIO.write(im2, "jpg", new File("resources/arbre4_gris.jpg"));

		// 1.5.
		im2 = OutilImage.redFilter(im);
		ImageIO.write(im2, "jpg", new File("resources/arbre5_rouge.jpg"));

		// 1.6.
		im2 = OutilImage.blueAndGreenFilter(im);
		ImageIO.write(im2, "jpg", new File("resources/arbre6_bleuEtVert.jpg"));

		// 2.1.
		im2 = OutilImage.filter(im, new Palette(new Color[] {Color.YELLOW, Color.GREEN}), new DistanceEuclidienne());
		ImageIO.write(im2, "jpg", new File("resources/arbre7_jauneEtVert.jpg"));

		Color[] colors = new Color[] {Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, Color.WHITE};

		// 2.2.
		im2 = OutilImage.filter(im, new Palette(colors), new DistanceEuclidienne());
		ImageIO.write(im2, "jpg", new File("resources/image8_distanceEuclidienne.jpg"));

		// 2.4.
		im2 = OutilImage.filter(im, new Palette(colors), new Redmean());
		ImageIO.write(im2, "jpg", new File("resources/image9_redmean.jpg"));

		// 2.6.
		im2 = OutilImage.filter(im, new Palette(colors), new Cielab());
		ImageIO.write(im2, "jpg", new File("resources/image10_cielab.jpg"));

		// 2.7.
		im2 = OutilImage.filter(im, new Palette(colors), new Cielab_better());
		ImageIO.write(im2, "jpg", new File("resources/image11_cielab.jpg"));
	}
}
