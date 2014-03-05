package view;

import java.awt.Color;
import java.awt.Font;

public enum Constants {

	BACKGROUNDCOLOR (new Color(245,245,245)),
	TEXTCOLOR (new Color(91, 96, 106)),
	TEXTCOLORLIGHT (new Color(155,160,170)),
	HOVERCOLOR (new Color(148,40,31)),
	CONTRASTCOLOR (new Color(190,51,40)),
	CATEGORYFONT (new Font("Hiragino Kaku Gothic Pro W3", Font.PLAIN, 16)),
	CATEGORYCLICKEDFONT (new Font("Hiragino Kaku Gothic Pro W6", Font.BOLD,16)),
	FAVORITESFONT (new Font("Hiragino Kaku Gothic Pro W3", Font.PLAIN, 22)),
	FAVORITESCLICKEDFONT (new Font("Hiragino Kaku Gothic Pro W6", Font.BOLD,22)),
	TEXTFONT (new Font("Hiragino Kaku Gothic Pro W3", Font.PLAIN, 14));
	
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
