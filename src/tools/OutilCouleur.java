package tools;

import java.awt.*;

public class OutilCouleur {
	public static int[] getTabColor(int c) {
		int[] tab = new int[3];
		tab[2] = c & 0xFF;
		tab[1] = (c & 0xFF00) >> 8;
		tab[0] = (c & 0xFF0000) >> 16;
		return tab;
	}

	public static int getColor(int[] tab) {
		Color color = new Color(tab[0], tab[1], tab[2]);
		return color.getRGB();
	}

	public static int getGrayScale(int c) {
		return getGrayScale(getTabColor(c));
	}

	public static int getGrayScale(int[] tab) {
		int[] grayTab = new int[3];
		grayTab[0] = (tab[0] + tab[1] + tab[2]) / 3;
		grayTab[1] = grayTab[0];
		grayTab[2] = grayTab[0];
		return getColor(grayTab);
	}

	public static int filter(int c, int scale) {
		return c & scale;
	}
}
