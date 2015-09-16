package com.lxz.fpgrowth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArrayFPTree {
	private int minSupport;
	
	public int getMinSupport(){
		return minSupport;
	}
	
	public void setMinSupport(int minSupport){
		this.minSupport = minSupport;
	}
	
	public ArrayList<ArrayList<String>> readTransRecord(String... filenames){
		ArrayList<ArrayList<String>> transRecords = null;
		if(filenames.length > 0){
			transRecords = new ArrayList<ArrayList<String>>();
			for(String filename : filenames){
				try{
					FileReader fr = new FileReader(filename);
					BufferedReader br = new BufferedReader(fr);
					try{
						String line = null;
						ArrayList<String> record = null;
						while((line = br.readLine()) != null){
							if(line.length() > 0){
								record = new ArrayList<String>();
								String[] strs = line.trim().split("，");	
								for(String w : strs){
									record.add(w);
								}
								transRecords.add(record);
							}
						}
					}finally{
						br.close();
					}
				}catch(IOException e){
					System.out.println("Read transaction records failed." + e.getMessage());
					System.exit(1);
				}
			}
		}
		System.out.println(transRecords);
		return transRecords;
	}
	
	public TreeMap<String, Integer> builderHeaderTable(ArrayList<ArrayList<String>> transRecords){
		//ArrayList<String> F1 = null;
		if(transRecords.size() > 0){
			//F1 = new ArrayList<String>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ValueComparator vc = new ValueComparator(map);
			TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(vc);
			for(ArrayList<String> record : transRecords){
				for(String item : record){
					System.out.println(map.keySet() + "\t#######" + item);
					if(!map.containsKey(item)){
						map.put(item, 1);
					} else{
						map.put(item, map.get(item) + 1);
					}
				}
			}
			sorted_map.putAll(map);
			Iterator iter = sorted_map.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
				if(entry.getValue() < minSupport){
					iter.remove();
					sorted_map.remove(entry.getKey());
				}
			}
			return sorted_map;
			//System.out.println(sorted_map);
			/*Iterator iter = sorted_map.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
				if(entry.getValue() >= minSupport){
					//System.out.println(entry.getKey());
					F1.add(entry.getKey());
				}else{
					break;
				}
			}
			System.out.println(F1);*/
			//return F1;
		} else{
			return null;
		}
	}
	
	public Map<String, ArrayList<ArrayList<String>>> buildArray(ArrayList<ArrayList<String>> transRecords, TreeMap<String, Integer> F1){
		Map<String, ArrayList<ArrayList<String>>> root = new HashMap<String, ArrayList<ArrayList<String>>>();
		for(String item : F1.keySet()){
			root.put(item, new ArrayList<ArrayList<String>>());
		}
		System.out.println(root);
		System.out.println("###################");
		for(ArrayList<String> transRecord : transRecords){//一行行读取
			ArrayList<String> tmpRecord = new ArrayList<String>();
			for(String item : F1.keySet()){
				if(transRecord.contains(item)){
					if(tmpRecord.size() > 0){
						root.get(item).add(new ArrayList<String>(tmpRecord));
						tmpRecord.add(item);
					}else{
						tmpRecord.add(item);
					}
					//System.out.println(tmpRecord);
					//System.out.println(root);
				}
			}
			//System.out.println("@@@@@@@@@@@@@@@@");
		}
//		System.out.println(root);
//		System.out.println("###################");
		return root;
	}
	
	public void FPGrowth(ArrayList<ArrayList<String>> transRecords, List<String> postPattern){
		TreeMap<String, Integer> headerTable = builderHeaderTable(transRecords);
		//System.out.println(headerTable);
		//ArrayList<String> headerTable = builderHeaderTable(transRecords);
		Map<String, ArrayList<ArrayList<String>>> root = buildArray(transRecords, headerTable); 
		System.out.println(root);
		System.out.println("###################");
		if(root.isEmpty()){
			return;
		}
		if(postPattern != null){
			for(String header : headerTable.keySet()){
				System.out.println(headerTable.get(header) + "\t" + header);
				for(String ele : postPattern){
					System.out.println("\t" + ele);
				}
				System.out.println();
			}
		}
		for(String header : headerTable.keySet()){
			ArrayList<String> newPostPattern = new ArrayList<String>();
			newPostPattern.add(header);
			if(postPattern != null){
				newPostPattern.addAll(postPattern);
			}
			ArrayList<ArrayList<String>> newTransRecords = new ArrayList<ArrayList<String>>();
			newTransRecords = root.get(header);
			FPGrowth(newTransRecords, newPostPattern);
		}
	}
	
	public static void main(String[] args){
		ArrayFPTree arrayFPTree = new ArrayFPTree();
		arrayFPTree.setMinSupport(3);//设置最小支持度为3
		ArrayList<ArrayList<String>> transRecords = arrayFPTree.readTransRecord("d:\\hello.txt");
		arrayFPTree.FPGrowth(transRecords, null);/**/
		/*HashMap<String, Integer> map = new HashMap<String, Integer>();
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
		map.put("a", 34);
		map.put("v", 24);
		map.put("f", 53);
		map.put("s", 3);
		map.put("g", 43);
		System.out.println(map);
		sorted_map.putAll(map);
		System.out.println(sorted_map);
		System.out.println(sorted_map.containsKey("a"));
		System.out.println(map.containsKey("a"));*/
	}
	
}

class ValueComparator implements Comparator<String>{
	Map<String, Integer> base;
	
	public ValueComparator(Map<String, Integer> base){
		this.base = base;
	}
	
	public int compare(String o1, String o2) {
		if(base.get(o1) >= base.get(o2)){
			return -1;
		} else{
			return 1;
		}//return 0 would merge keys
	}
	
}
