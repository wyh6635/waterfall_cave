package com.iboxpay.hgm.wfc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.iboxpay.hgm.wfc.entity.SyncMerchant;


public class FileHelper {

	public static List<String> readFile(String fileName) throws Exception {
		List<String> lineList = new ArrayList<String>();
		
		File file = new File(fileName);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "GBK");
		BufferedReader br = new BufferedReader(reader);
		
		String str = null; 
		while ( (str = br.readLine()) != null) {
			lineList.add(str);
			System.out.println(str);
		}
		
		br.close();
		reader.close();
		
		return lineList;
	}
	
	public static void writeFile(String fileName, List<String> list) throws Exception {
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
			sb.append("\n");
		}
		
		FileWriter file = new FileWriter(new File(fileName));
		BufferedWriter writer = new BufferedWriter(file);
		writer.write(sb.toString());
		
		writer.close();
		file.close();
	}
	
	public static void main(String[] args) {
		try  {
			List<SyncMerchant> list = MerchantUtils.parseObject(readFile("f:/SPDB_MCHT_79_140917_01S.txt"));
			writeFile("f:/update_mcht_79_140917_01S.sql", MerchantUtils.parseStrList(list));
		} catch (Exception e) {
			
		}
	}
	
}

	