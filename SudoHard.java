package maiN;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class SudoHard {
	static int sudo[][] = {
			{0,9,0,4,0,0,0,1,0},{5,0,1,0,0,3,0,0,6},{0,7,0,0,5,0,0,0,0},
			{2,0,4,0,9,0,0,6,0},{0,0,0,8,0,0,0,0,3},{0,1,0,0,0,0,0,0,0},
			{6,0,5,0,2,0,0,4,0}, {7,0,0,0,0,0,0,0,0}, {0,0,0,0,0,9,2,0,0} };
	public static void main(String[] args) {
		run1();
	}
//@Test
//public static void main() {
//	run1();
//}

	public static void run1() {
		System.out.println("Unsloved sudoku");
		printl(sudo);
		long a = (System.currentTimeMillis());
		hard();
		long b = (System.currentTimeMillis());
		System.out.println("Sloved sudoku");
		printl(sudo);
		System.out.println("Time taken to slove the sudoku in milli seconds is  "+ (b-a));

	}
	
	
	public static void hard() {
		int[] f = firstZero(sudo);
		int i=f[0];
		int j=f[1];
		if(i==-1)
			return;
		 ArrayList<Integer> kVal = findPairs(i,j);
		 for (Integer k : kVal) {
			sudo[i][j]=k;
			hard();
			if(firstZero(sudo)[0]==-1)
				return;
			sudo[i][j]=0;
		}
	}

	public static int[] firstZero(int[][] Copy) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Copy[i][j] == 0) {
					int a[]= {i,j};
					return a;
				}}}
		int a[]= {-1,-1};
		return a;
	}


	public static int [][] copy(int [][]from,int [][]to){
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				to[i][j]=from[i][j];
			}
		}
		return to;
		
	}
	  public static  ArrayList<Integer> findPairs(int i, int j) {
		  ArrayList<Integer> l=new ArrayList();
		  for(int k=1;k<=9;k++) {
			  Boolean b1 = runRow(k, i,sudo);
				if (!b1)
					continue;
				Boolean b2 = runCol(k, j,sudo);
				if (!b2)
					continue;
				Boolean b3 = runBox(k, i, j,sudo);
				if (!b3)
					continue;
				if (b1 && b2 && b3) {
					l.add(k);
				}
		  }
		  return l;
	  }
		public static Boolean runRow(int k, int i, int[][] sudo) {
			for (int n = 0; n < 9; n++) {
				if (sudo[i][n] == k)
					return false;
			}
			return true;
		}

		public static Boolean runCol(int k, int j, int[][] sudo) {
			for (int n = 0; n < 9; n++) {
				if (sudo[n][j] == k)
					return false;
			}
			return true;
		}

		public static Boolean runBox(int k, int i, int j, int[][] sudo) {
			if (i < 3 && j < 3) {
				return boxRun(k, 0, 0, sudo);
			} else if (i < 3 && j < 6) {
				return boxRun(k, 0, 3, sudo);
			} else if (i < 3 && j < 9) {
				return boxRun(k, 0, 6, sudo);
			}
			// first row
			else if (i < 6 && j < 3) {
				return boxRun(k, 3, 0, sudo);
			} else if (i < 6 && j < 6) {
				return boxRun(k, 3, 3, sudo);
			} else if (i < 6 && j < 9) {
				return boxRun(k, 3, 6, sudo);
			}
			// second row
			else if (i < 9 && j < 3) {
				return boxRun(k, 6, 0, sudo);
			} else if (i < 9 && j < 6) {
				return boxRun(k, 6, 3, sudo);
			} else if (i < 9 && j < 9) {
				return boxRun(k, 6, 6, sudo);
			}
			return false;
		}

		public static Boolean boxRun(int k, int i, int j,int [][]sudo) {
			for (int n = i; n < (i + 3); n++) {
				for (int m = j; m < (j + 3); m++) {
					if (sudo[n][m] == k)
						return false;
				}
			}
			return true;
		}
		static void printl(int [][]sudo) {
			 System.out.println("========================================================================================");
			for (int i = 0; i < 9; i++) {
				if (i % 3 == 0)
					System.out.println();
				for (int j = 0; j < 9; j++) {
					if (j % 3 == 0)
						System.out.print("   ");
					System.out.print(sudo[i][j] + " ");
				}
				System.out.println();
			}
			 System.out.println("========================================================================================");
		}
	public static ArrayList<ArrayList> Zeros(int sudo[][]) {
		ArrayList<ArrayList> l = new ArrayList();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudo[i][j] == 0) {
					ArrayList<Integer> l1 = new ArrayList();
					l1.add(0, i);
					l1.add(1, j);
					l.add(l1);
				//	System.out.println(i+" "+j);
				}
			}
		}
		return l;
	}
//	public int[][] hard(int[][] sudo) {
//		printl(sudo);
//		maintain=sudo;
//		int [][]sudoCopy=new int[9][9];
//		sudoCopy=copy(sudo,sudoCopy);
//		ArrayList<ArrayList> l = Zeros(sudoCopy);
//		System.out.println(l.size()+" "+count++);
//		int innercount=0;
//		for (ArrayList Pairs : l) {
//			int i = (int) Pairs.get(0);
//			int j = (int) Pairs.get(1);
//			ArrayList<Integer> Kvals = findPairs(i, j,sudoCopy);
//			for (Integer k : Kvals) {
//				sudoCopy[i][j]=k;
//				if(Zeros(sudoCopy).size()==0)
//					return sudoCopy;
//				sudoCopy=hard(sudoCopy);
//				if(Zeros(sudoCopy).size()==0)
//					return sudoCopy;
//			}
//			if(Zeros(sudoCopy).size()==0)
//				return sudoCopy;
//			break;
//		}
//		if(maintain==sudoCopy)
//			return sudoCopy;
////		if(count>100)
////			return null;
//		
//		return sudo;
//
//	}
}
