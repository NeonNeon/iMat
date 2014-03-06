package view;

import java.awt.Color;
import java.awt.Font;

public enum Constants {

	BACKGROUNDCOLOR (new Color(245,245,245)),
	TEXTCOLOR (new Color(91, 96, 106)),
	TEXTCOLORLIGHT (new Color(155,160,170)),
	HOVERCOLOR (new Color(148,40,31)),
	CONTRASTCOLOR (new Color(190,51,40)),
	CATEGORYFONT (new Font("Adobe Heiti Std", Font.PLAIN, 16)),
	CATEGORYCLICKEDFONT (new Font("Adobe Heiti Std", Font.PLAIN,16)),
	FAVORITESFONT (new Font("Adobe Heiti Std", Font.PLAIN, 20)),
	FAVORITESCLICKEDFONT (new Font("Adobe Heiti Std", Font.PLAIN,22)),
	TEXTFONT (new Font("Adobe Heiti Std", Font.PLAIN, 14)),
	HEADERFONT (new Font("Adobe Gothic Std", Font.PLAIN, 20));
	
	private Color color;
	private Font font;
	
	Constants(Color color){
		this.color = color;
	}
	
	Constants(Font font){
		this.font = font;
	}
	
	public Color getColor(){
		return color;
	}
	
	public Font getFont(){
		return font;
	}

}
