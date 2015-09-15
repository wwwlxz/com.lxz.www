package com.lxz.fpgrowth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FPTreeTest {
	private int minSupport;
	
	public int getMinSupport(){
		return minSupport;
	}
	
	public void setMinSupport(int minSupport){
		this.minSupport = minSupport;
	}
	
	public List<List<String>> readTransRecord(String... filenames){
		List<List<String>> transRecords = null;
		if(filenames.length > 0){
			transRecords = new LinkedList<List<String>>();
			for(String filename : filenames){
				try{
					FileReader fr = new FileReader(filename);
					BufferedReader br = new BufferedReader(fr);
					try{
						String line;
						List<String> record;
						while((line = br.readLine()) != null){
							if(line.trim().length()>0){
								String str[] = line.trim().split("，");
								record = new LinkedList<String>();
								for(String w : str){
									record.add(w);
								}
								transRecords.add(record);
							}
						}
					} finally{
						br.close();
					}
				} catch(IOException e){
					System.out.println("Read transaction records failed." + e.getMessage());
					System.exit(1);
				}
			}
		}
		return transRecords;
	}
	
	public ArrayList<TreeNode> buildHeaderTable(List<List<String>> transRecords){
		ArrayList<TreeNode> F1 = null;
		if(transRecords.size() > 0){
			F1 = new ArrayList<TreeNode>();
			Map<String, TreeNode> map = new HashMap<String, TreeNode>();
			for(List<String> record : transRecords){
				for(String item : record){
					System.out.println(map.keySet() + "\t########" + item);
					if(!map.containsKey(item)){
						TreeNode node = new TreeNode(item);
						node.setCount(1);
						map.put(item, node);
					} else{
						map.get(item).countIncrement(1);
					}
				}
			}
			Set<String> names = map.keySet();
			for(String name : names){
				TreeNode tnode = map.get(name);
				if(tnode.getCount() >= minSupport){
					F1.add(tnode);
				}
			}
			Collections.sort(F1);
			/*for(int i = 0; i < F1.size(); i++){
				System.out.println(F1.get(i).getName() + "===" + F1.get(i).getCount());
			}*/
			return F1;
		} else{
			return null;
		}
	}
	
	public LinkedList<String> sortByF1(List<String> transRecord, ArrayList<TreeNode> F1){		
		Map<String, Integer> map = new HashMap<String, Integer>();
		LinkedList<String> rest = new LinkedList<String>();
		for(int i = 0; i < F1.size(); i++){
			if(transRecord.contains(F1.get(i).getName())){
				rest.add(F1.get(i).getName());
			}
		}
		return rest;
	}
	
	public void addNodes(TreeNode ancestor, LinkedList<String> record, ArrayList<TreeNode> F1){
		if(record.size() > 0){
			while(record.size() > 0){
				String item = record.poll();
				TreeNode leafnode = new TreeNode(item);
				leafnode.setCount(1);
				leafnode.setParent(ancestor);
				ancestor.addChild(leafnode);
				for(TreeNode f1 : F1){
					if(f1.getName().equals(item)){
						while(f1.getNextHomonym() != null){
							f1 = f1.getNextHomonym();
						}
						f1.setNextHomonym(leafnode);
						break;
					}
				}
				addNodes(leafnode, record, F1);
			}
		}
	}
	
	public TreeNode buildTree(List<List<String>> transRecords, ArrayList<TreeNode> F1){
		TreeNode root =new TreeNode();
		for(List<String> transRecord : transRecords){
			LinkedList<String> record = sortByF1(transRecord, F1);
			TreeNode subTreeRoot = root;
			TreeNode tmpRoot = null;
			if(root.getChildren() != null){
				while(!record.isEmpty() && (tmpRoot = subTreeRoot.findChild(record.peek())) != null){
					tmpRoot.countIncrement(1);
					subTreeRoot = tmpRoot;
					record.poll();
				}
			}
			addNodes(subTreeRoot, record, F1);
		}
		return root;
	}
	
	public void FPGrowth(List<List<String>> transRecords, List<String> postPattern){
		ArrayList<TreeNode> headerTable = buildHeaderTable(transRecords);
		TreeNode treeRoot = buildTree(transRecords, headerTable);
		if(treeRoot.getChildren() == null || treeRoot.getChildren().size() == 0){
			return;
		}
		if(postPattern != null){
			for(TreeNode header : headerTable){
				System.out.print(header.getCount() + "\t" + header.getName());
				for(String ele : postPattern){
					System.out.print("\t" + ele);
				}
				System.out.println();
			}
		}
		for(TreeNode header : headerTable){
			List<String> newPostPattern = new LinkedList<String>();
			newPostPattern.add(header.getName());
			if(postPattern != null){
				newPostPattern.addAll(postPattern);
			}
			List<List<String>> newTransRecords = new LinkedList<List<String>>();
			TreeNode backnode = header.getNextHomonym();
			while(backnode != null){
				int counter = backnode.getCount();
				List<String> prenodes = new ArrayList<String>();
				TreeNode parent = backnode;
				while((parent = parent.getParent()).getName() != null){
					prenodes.add(parent.getName());
				}
				while(counter-- > 0){
					newTransRecords.add(prenodes);
				}
				backnode = backnode.getNextHomonym();
			}
			FPGrowth(newTransRecords, newPostPattern);
		}
	}
	
	public static void main(String[] args){
		FPTreeTest fpTreeTest = new FPTreeTest();
		fpTreeTest.setMinSupport(3);
		List<List<String>> transRecords = fpTreeTest.readTransRecord("d:\\hello.txt");
		fpTreeTest.FPGrowth(transRecords, null);
//		List<String> record = null;
//		for(int i = 0; i < transRecords.size(); i++){
//			record = transRecords.get(i);
//			System.out.println(record);
//		}
//		System.out.println(transRecords);
	}
	
}
