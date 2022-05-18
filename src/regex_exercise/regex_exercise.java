package regex_exercise;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class regex_exercise {

	public static void main(String[] args) {
		
		System.out.println("Part 1 Tests:");
		String allCap = "ALLCAP";
		String hasDigit = "This is 1";
		String phoneNumber = "123-456-7890";
		String date = "01/02/3456";
		
		String regCap = "[A-Z]+";
		String regHasDigit = ".*[0-9].*";
		String regPhoneNumber = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
		String regDate = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$";
		
		System.out.println(regTest(allCap, regCap));
		System.out.println(regTest(hasDigit, regHasDigit));
		System.out.println(regTest(phoneNumber, regPhoneNumber));
		System.out.println(regTest(date, regDate));
		
		System.out.println("Part 2: Validator App");
		Scanner scnr = new Scanner(System.in);
		boolean loopName = false;
		while(loopName == false) {
			System.out.println("Please enter your name: (Format: First Last)");
			String name = scnr.nextLine();
			loopName = validateName(name);
			if(loopName == false) {
				System.out.println("Not valid, try again");
			}
		}
		
		boolean loopEmail = false;
		while(loopEmail == false) {
			System.out.println("Please enter your email:");
			String email = scnr.nextLine();
			loopEmail = validateEmail(email);
			if(loopEmail == false) {
				System.out.println("Not valid, try again");
			}
		}
		
		boolean loopPhone = false;
		while(loopPhone == false) {
			System.out.println("Please enter your phone number: (Format: xxx-xxx-xxxx");
			String phone = scnr.nextLine();
			loopPhone = validatePhone(phone);
			if(loopPhone == false) {
				System.out.println("Not valid, try again");
			}
		}
		
		boolean loopDate = false;
		while(loopDate == false) {
			System.out.println("Please enter the date: (Format: mm/dd/yyyy)");
			String date2 = scnr.nextLine();
			loopDate = validateDate(date2);
			if(loopDate == false) {
				System.out.println("Not valid, try again");
			}
		}
		
		System.out.println("All inputs are valid, thanks!\nGoodbye!");
		scnr.close();
	}
	
	public static boolean regTest (String test, String reg) {
		Pattern pt = Pattern.compile(reg);
		Matcher mt = pt.matcher(test);
		boolean result = mt.matches();
		return result;
				
	}
	
	public static boolean validateName(String test) {
		boolean trueFalse;
		String reg = "\\b[A-Z][a-z]* [A-Z][a-z]*( [A-Z])?\\b";
		if (test.length()>30) {
			trueFalse = false;
		}
		else {
			Pattern pt = Pattern.compile(reg);
			Matcher mt = pt.matcher(test);
			trueFalse = mt.matches();
		}
		return trueFalse;
	}
	
	public static boolean validateEmail(String test) {
		boolean trueFalse;
		String reg = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pt = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(test);
		trueFalse = mt.matches();
		return trueFalse;
	}
	
	public static boolean validatePhone(String test) {
		boolean trueFalse;
		String reg = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
		Pattern pt = Pattern.compile(reg);
		Matcher mt = pt.matcher(test);
		trueFalse = mt.matches();
		return trueFalse;
	}
	
	public static boolean validateDate(String test) {
		boolean trueFalse;
		String reg = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$";
		Pattern pt = Pattern.compile(reg);
		Matcher mt = pt.matcher(test);
		trueFalse = mt.matches();
		return trueFalse;
	}
}
