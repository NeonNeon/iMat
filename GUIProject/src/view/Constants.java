package view;

import java.awt.Color;
import java.awt.Font;

public enum Constants {

	BACKGROUNDCOLOR (new Color(245,245,245)),
	TEXTCOLOR (new Color(91, 96, 106)),
	TEXTCOLORLIGHT (new Color(155,160,170)),
	HOVERCOLOR (new Color(148,40,31)),
	//HOVERCOLOR (new Color (51,127,176)),
	//CONTRASTCOLOR (new Color(51,127,176)),
	BUTTONCOLOR (new Color(91, 96, 106)),
	CONTRASTCOLOR (new Color(190,51,40)),
	CATEGORYFONT (new Font("Avenir Book", Font.PLAIN, 16)),
	CATEGORYCLICKEDFONT (new Font("Avenir Next Bold", Font.PLAIN,16)),
	FAVORITESFONT (new Font("Avenir Book", Font.PLAIN, 20)),
	FAVORITESCLICKEDFONT (new Font("Avenir Next Bold", Font.PLAIN,22)),
	TEXTFONT (new Font("Avenir Light", Font.PLAIN, 12)),
	HEADERFONT (new Font("Avenir Book", Font.PLAIN, 20)),
	SUCHFONT (new Font("Avenir Next", Font.PLAIN, 35));
	
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
