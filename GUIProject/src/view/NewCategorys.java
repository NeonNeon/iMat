package view;
/**
 * This is an enum that we should use instead of the ProductCategory enum.
 * Should try to seperate POTATIS and RIS, might do that later.
 * @author neon
 * 
 */

/*
 * Kategorier: - favoriter - grï¿½nsaker - frukt och bï¿½r - baljvï¿½xter - potatis
 * och rotfrukter - ris och pasta - skafferi - brï¿½d - mejeriprodukter - kï¿½tt -
 * fisk och skaldjur - dryck - ï¿½rter -snacks och sï¿½tsaker
 */
public enum NewCategorys {
	FAVORITER("Favoriter"),GRONSAKER("Grönsaker"),FRUKT_OCH_BAR("Frukt och bär"),
	BALJVAXTER("Baljväxter"),POTATIS_RIS_OCH_ROTFRUKTER("Potatis, ris och rotfrukter"),
	PASTA("Pasta"),SKAFFERI("Skafferi"),BROD("Bröd"),MEJERI("Mejeri"),KOTT("Kött"),
	FISK_OCH_SKALDJUR("Fisk och skaldjur"),DRYCK("Dryck"),ORTER("Örter"),
	SNACKS_OCH_SOTSAKER("Snacks och sötsaker");
	private final String name;
	private NewCategorys(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
