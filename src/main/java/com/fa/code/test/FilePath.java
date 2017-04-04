package com.fa.code.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FilePath {
	private Map<String,Integer> map;
	
	/**
	 * Constructor to load file_list.txt in to HashMap from the given path.
	 * @param filePath
	 */
	public FilePath(String filePath) {
		this.map = new HashMap<String, Integer>();
		
		File file = new File(filePath);
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			try {
				while( (line=br.readLine()) != null){
					String[] dirsAndSize=line.split(" ");
					String key = dirsAndSize[0];
					Integer val = Integer.parseInt(dirsAndSize[1]);
					
					Integer dirSize = map.get(key);
					if( dirSize !=null){
						int newDirSize = dirSize + val;
						map.put(key,newDirSize);
					}else{
						map.put(key,val);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr != null)
					fr.close();
				if(br != null) 
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * Function that takes directory path and returns size of it.
	 * @param path
	 * @return size of directory
	 */
	public int getSize(String path){
		Set<String> keys = this.map.keySet();
		int size = 0;
		
		if(path.equals(".")){
			for( String key : keys){
				if(key.indexOf("/") == -1){
					size +=map.get(key);
				}
			}
		}else{
			for( String key : keys){
				if(key.startsWith(path)){
					size +=map.get(key);
				}
			}
		}
		return size;
	}
}