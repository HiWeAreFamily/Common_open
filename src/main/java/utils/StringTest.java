package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static String sss(String myString){
		String newString=myString;
		Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
		Matcher m = CRLF.matcher(myString);
		if (m.find()) {
		  newString = m.replaceAll(" ");
		}
		return newString;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String aaa="sdfsfdsfsdf\r\n,dsfsdfsdf\r\n";
		System.out.println(aaa);
		//aaa.replace("s", "x");
		String newStr=sss("asd");
		System.out.println(newStr);
	}

}