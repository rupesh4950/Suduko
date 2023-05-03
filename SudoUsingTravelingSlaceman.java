package maiN;

import java.util.ArrayList;

public class SudoUsingTravelingSlaceman extends SudoValues{
	static int dummy=0;
	static int firstcount = 0;
	static int b = 0;
	public static void main(String[] args) {
		run();
		
	}
	static int[][] run() {
	//	printl();
		//System.out.println("before " + Zeros().size());
		ArrayList<ArrayList> z = Zeros();
		// general slove method
		slove();
		//System.out.println("first round " + Zeros().size());
		//printl();
		// now recurrence slove method
	//	recSlove();
		//System.out.println("second round " + Zeros().size());
	//	System.out.println("sloved");

	//	printl();
		return sudo;
	}

 static boolean recSlove() {
		System.out.println(dummy++);
		ArrayList<ArrayList> l = Zeros();
		if(l.size()==0)
			return true;
		for (ArrayList a : l) {
			int  i= (int) a.get(0);
			int j=(int)a.get(1);
			ArrayList<Integer> love= new ArrayList<>();
			///////i and j values fetched
			if(sudo[i][j]==0) {
			for(int k=1;i<=9;k++) {
				Boolean b1 = runRow(k, i);
				Boolean b2 = runCol(k, j);
				Boolean b3 = runBox(k, i, j);
				if(b1&&b2&&b3) {
					love.add(k);
				}
			}
			for(int f=0;f<love.size();f++) {
				sudo[i][j]=love.get(0);
				boolean b4 = recSlove();
				if(b4)
					break;
				if(love.size()==f+1)
					return true;
			}
			return true;
			}
		}
		return false;
	}

	static void slove() {
		// to slove the max of the problem
		// boolean b=false;
		ArrayList<ArrayList> z = Zeros();
		// System.out.println("inside "+z.size());
		int top = -1;
		for (ArrayList a1 : z) {
			int i = (int) a1.get(0);
			int j = (int) a1.get(1);
			int count = 0;
			int val = 0;
			top++;
			for (int k = 1; k < 10; k++) {
				Boolean b1 = runRow(k, i);
				if (!b1)
					continue;
				Boolean b2 = runCol(k, j);
				if (!b2)
					continue;
				Boolean b3 = runBox(k, i, j);
				if (!b3)
					continue;
				if (b1 && b2 && b3) {
					val = k;
					count++;
				}
			}
			if (count == 1) {
				sudo[i][j] = val;
			}
		}
		if (z.size() == firstcount)
			return;
		firstcount = z.size();
		slove();
	}

	public static ArrayList<ArrayList> Zeros() {
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

	 static void printl() {
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

	public static Boolean runRow(int k, int i) {
		for (int n = 0; n < 9; n++) {
			if (sudo[i][n] == k)
				return false;
		}
		return true;
	}

	public static Boolean runCol(int k, int j) {
		for (int n = 0; n < 9; n++) {
			if (sudo[n][j] == k)
				return false;
		}
		return true;
	}

	public static Boolean runBox(int k, int i, int j) {
		if (i < 3 && j < 3) {
			return boxRun(k, 0, 0);
		} else if (i < 3 && j < 6) {
			return boxRun(k, 0, 3);
		} else if (i < 3 && j < 9) {
			return boxRun(k, 0, 6);
		}
		// first row
		else if (i < 6 && j < 3) {
			return boxRun(k, 3, 0);
		} else if (i < 6 && j < 6) {
			return boxRun(k, 3, 3);
		} else if (i < 6 && j < 9) {
			return boxRun(k, 3, 6);
		}
		// second row
		else if (i < 9 && j < 3) {
			return boxRun(k, 6, 0);
		} else if (i < 9 && j < 6) {
			return boxRun(k, 6, 3);
		} else if (i < 9 && j < 9) {
			return boxRun(k, 6, 6);
		}
		return false;
	}

	public static Boolean boxRun(int k, int i, int j) {
		for (int n = i; n < (i + 3); n++) {
			for (int m = j; m < (j + 3); m++) {
				if (sudo[n][m] == k)
					return false;
			}
		}
		return true;
	}
}