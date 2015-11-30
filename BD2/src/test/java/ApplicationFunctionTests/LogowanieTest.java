package ApplicationFunctionTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BazyDanychProjekt.ApplicationFunction.LogowanieAF;

public class LogowanieTest {

	@Test
	public void testCorrectLogin() {
		//given
		String login = "mdejczer";
		String password = "password12345";
		LogowanieAF logowanie = new LogowanieAF();
		boolean result;
		//when
		result = logowanie.zaloguj(login, password);
		
		//then
		assertTrue(result);
	}
	
	@Test
	public void testFailedLogin() {
		//given
		String login = "abcd";
		String password = "efgh";
		LogowanieAF logowanie = new LogowanieAF();
		boolean result;
		//when
		result = logowanie.zaloguj(login, password);
		
		//then
		assertFalse(result);
	}

}
