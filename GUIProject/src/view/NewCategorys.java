package view;
/**
 * This is an enum that we should use instead of the ProductCategory enum.
 * Should try to seperate POTATIS and RIS, might do that later.
 * @author neon
 * 
 */

/*
 * Kategorier: - favoriter - gr�nsaker - frukt och b�r - baljv�xter - potatis
 * och rotfrukter - ris och pasta - skafferi - br�d - mejeriprodukter - k�tt -
 * fisk och skaldjur - dryck - �rter -snacks och s�tsaker
 */
public enum NewCategorys {
	FAVORITER("Favoriter"),GRONSAKER("Gr�nsaker"),FRUKT_OCH_BAR("Frukt och b�r"),
	BALJVAXTER("Baljv�xter"),POTATIS_RIS_OCH_ROTFRUKTER("Potatis, ris och rotfrukter"),
	PASTA("Pasta"),SKAFFERI("Skafferi"),BROD("Br�d"),MEJERI("Mejeri"),KOTT("K�tt"),
	FISK_OCH_SKALDJUR("Fisk och skaldjur"),DRYCK("Dryck"),ORTER("�rter"),
	SNACKS_OCH_SOTSAKER("Snacks och s�tsaker");
	private final String name;
	private NewCategorys(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
