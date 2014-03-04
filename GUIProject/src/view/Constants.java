package view;

import java.awt.Color;

public enum Constants {

	BACKGROUNDCOLOR (new Color(245,245,245)),
	TEXTCOLOR (new Color(91, 96, 106)),
	TEXTCOLORLIGHT (new Color(155,160,170)),
	HOVERCOLOR (new Color(148,40,31)),
	CONTRASTCOLOR (new Color(190,51,40));
	
	private Color color;
	
	Constants(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}

}
