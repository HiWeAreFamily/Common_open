package utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfiguratorTXTUtils {

	public static void main(String[] args) {
		String puids = "46973,53285,46968,53225,55910,43585,43586,20481,20482,20479,20480,32362,32363,54445,54446,54447,54448,54449,54450,"
				+ "54451,54452,61314,104617,104618,104619,104620,1,4621,104622,100975,53385,43947,32150,32149,51150,44948,30329,53846,53847,"
				+ "48785,58605,57146,32948,46706,48788,48789,53454,48790,17648,29267,57206,56186,56187,51146,7261,4728,60292,61864,61925,61425,53974,"
				+ "108318,101430,105351,107824,107408,107409,47610,54028,56725,54026,54027,60887,60827,60865,60868,60870,60855,60872,109614,109615,109618,109619,"
				+ "109610,109611,109995";
		service(puids);
	}

	public static void service(String puids) {
		String[] puidArray = puids.split(",");
		List<String> idLongs = new ArrayList<String>();
		// for(String str1 : puidArray){
		// // System.out.println(str1);
		// idLongs.add(str1);
		// }
		System.out.println(puidArray.length);
		
		for (String str1 : puidArray) {
			String fc = readFile(str1);
			idLongs.add(str1 + "," + fc);
		}
	}

	public static String readFile(String puid) {
		String result = null;
		File file = new File(
				
				"D:\\Work_Tools\\Modeling\\OLB_Config_Gen_BLD\\configurator\\Configurator.txt");
		BufferedReader reader = null;
		try {
//			System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith(puid) && tempString.endsWith("(")) {

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

		return result;
	}
}
