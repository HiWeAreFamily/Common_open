package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CleanFCAistMessage {

	public static void main(String[] args) {
		String puids = "46973,53285,46968,53225,55910,43585,43586,20481,20482,20479,20480,32362,32363,54445,54446,54447,54448,54449,54450,"
				+ "54451,54452,61314,104617,104618,104619,104620,1,4621,104622,100975,53385,43947,32150,32149,51150,44948,30329,53846,53847,"
				+ "48785,58605,57146,32948,46706,48788,48789,53454,48790,17648,29267,57206,56186,56187,51146,7261,4728,60292,61864,61925,61425,53974,"
				+ "108318,101430,105351,107824,107408,107409,47610,54028,56725,54026,54027,60887,60827,60865,60868,60870,60855,60872,109614,109615,109618,109619,"
				+ "109610,109611,109995";
		CleanFCAistMessage clean = new CleanFCAistMessage();
		Set<String> messageid = clean.getMessageId();
		for (String id : messageid) {
			System.out.println(id);
		}
		// System.out.println("1=000609;".indexOf("0"));
	}

	// public static void service(String puids) {
	// String[] puidArray = puids.split(",");
	// List<String> idLongs = new ArrayList<String>();
	// // for(String str1 : puidArray){
	// // // System.out.println(str1);
	// // idLongs.add(str1);
	// // }
	// System.out.println(puidArray.length);
	//
	// for (String str1 : puidArray) {
	// String fc = readFile(str1);
	// idLongs.add(str1 + "," + fc);
	// }
	// }

	public Set<String> getMessageId() {
		Set<String> messageid = new HashSet<String>();
		File file = new File(
				"D:\\Work Space\\ASIT\\src\\asit\\aml\\rule\\Rules_5462_XinYi.aml");
		BufferedReader reader = null;
		try {
			// System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				if (tempString.contains("MessageID")
						&& !tempString.contains("//")) {
					messageid.add(tempString.substring(
							tempString.indexOf("=") + 1,
							tempString.indexOf(";")).trim());
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		return messageid;
	}
}
