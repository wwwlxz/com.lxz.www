package com.lxz.highutility;

public class DataStruct {
	public int tid = 0;
	public int[] transaction = new int[7];
	public int tu = 0;
	public int[] profit = {10, 4, 1, 2, 3, 1, 1};
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int[] getTransaction() {
		return transaction;
	}

	public void setTransaction(int[] transaction) {
		this.transaction = transaction;
		this.tu = transaction[0] * profit[0] + transaction[1] * profit[1] + 
				transaction[2] * profit[2] + transaction[3] * profit[3] + 
				transaction[4] * profit[4] + transaction[5] * profit[5] +
				transaction[6] * profit[6];
	}

	public int getTu() {
		return tu;
	}

	public String toString(){
		return "DataStruct: [Tid: " + getTid() + ", Transaction: {A: " + getTransaction()[0] + 
				", B: " + getTransaction()[1] + ", C: " + getTransaction()[2] +
				", D: " + getTransaction()[3] + ", E: " + getTransaction()[4] +
				", F: " + getTransaction()[5] + ", G: " + getTransaction()[6] +
				"}, Tu:" + getTu() + "]"; 
	}
	
	public static void main(String[] args){
		DataStruct[] ds = new DataStruct[7];
		//tid = 1
		ds[0] = new DataStruct();
		ds[0].setTid(1);
        //                             A  B  C  D  E  F  G
		ds[0].setTransaction(new int[]{0, 4, 3, 3, 1, 0, 0});
		System.out.println(ds[0]);
		//tid = 2
		ds[1] = new DataStruct();
		ds[1].setTid(2);
		//                             A  B  C  D  E  F  G
		ds[1].setTransaction(new int[]{0, 2, 2, 0, 1, 0, 3});
		System.out.println(ds[1]);
		//tid = 3
		ds[2] = new DataStruct();
		ds[2].setTid(3);
		//                             A  B  C  D  E  F  G
		ds[2].setTransaction(new int[]{0, 3, 4, 0, 0, 1, 0});
		System.out.println(ds[2]);
		//tid = 4
		ds[3] = new DataStruct();
		ds[3].setTid(4);
		//                             A  B  C  D  E  F  G
		ds[3].setTransaction(new int[]{1, 0, 6, 2, 0, 0, 0});
		System.out.println(ds[3]);
		//tid = 5
		ds[4] = new DataStruct();
		ds[4].setTid(5);
		//                             A  B  C  D  E  F  G
		ds[4].setTransaction(new int[]{2, 1, 2, 2, 1, 0, 0});
		System.out.println(ds[4]);
		//tid = 6
		ds[5] = new DataStruct();
		ds[5].setTid(6);
		//                             A  B  C  D  E  F  G
		ds[5].setTransaction(new int[]{0, 0, 3, 1, 1, 0, 2});
		System.out.println(ds[5]);
		//tid = 7
		ds[6] = new DataStruct();
		ds[6].setTid(7);
		//                             A  B  C  D  E  F  G
		ds[6].setTransaction(new int[]{2, 0, 6, 10, 0, 0, 0});
		System.out.println(ds[6]);
	}
}
