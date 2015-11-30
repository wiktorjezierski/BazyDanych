package BazyDanychProjekt.ApplicationFunction;

import BazyDanychProjekt.BD2.PracownicyEntity;

public final class SessionData {

	private static PracownicyEntity pracownik;

	public static PracownicyEntity getPracownik() {
		return pracownik;
	}

	public static void setPracownik(PracownicyEntity pracownik) {
		SessionData.pracownik = pracownik;
	}

}
