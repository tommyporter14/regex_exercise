package regex_exercise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class regex_exerciseTest {

	//TESTS for part 1 only
	
	@Test
	void regTestCapTrue() {
		String test = "JJFHADFJJ";
		String reg = "[A-Z]+";
		assertEquals(true, regex_exercise.regTest(test, reg));
	}

	@Test
	void regTestCapFalse() {
		String test = "JJFhdhADFJJ";
		String reg = "[A-Z]+";
		assertEquals(false, regex_exercise.regTest(test, reg));
	}

	@Test
	void regTestDigitTrue() {
		String test = "hsdfh1DAHA";
		String reg = ".*[0-9].*";
		assertEquals(true, regex_exercise.regTest(test, reg));
	}
	
	@Test
	void regTestDigitFalse() {
		String test = "hsasfhA";
		String reg = ".*[0-9].*";
		assertEquals(false, regex_exercise.regTest(test, reg));
	}
	
	@Test
	void regTestPhoneTrue() {
		String test = "345-987-0184";
		String reg = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
		assertEquals(true, regex_exercise.regTest(test, reg));
	}
	
	@Test
	void regTestPhoneFalse() {
		String test = "3-8236-03";
		String reg = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
		assertEquals(false, regex_exercise.regTest(test, reg));
	}
	
	@Test
	void regTestDateTrue() {
		String test = "03/21/1970";
		String reg = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$";
		assertEquals(true, regex_exercise.regTest(test, reg));
	}
	
	@Test
	void regTestDateFalse() {
		String test = "2/2/19";
		String reg = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$";
		assertEquals(false, regex_exercise.regTest(test, reg));
	}
}
