package maiN;

public class sudoko extends SudoValues {
	int firstcount=0;
	static int b=0;
	
	public static void main(String[] args) {
		printl();
		slove();
		System.out.println("sloved");
		
		printl();
	}

	private static void slove() {
		//boolean b=false;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudo[i][j] == 0) {
					int count=0;
					int val=0;
					for (int k = 1; k < 10; k++) {
						Boolean b1 = runRow(k, i);
						Boolean b2 = runCol(k, j);
						Boolean b3 = runBox(k, i, j);
						if (b1 && b2 && b3) {
							sudo[i][j] = k;
							break;
						}
					}
					//b=true;
				}
			}
		}
		b++;
		if (b==6)
			return;
		slove();
	}

	private static void printl() {
		for(int i=0;i<9;i++) {
			if(i%3==0)
				System.out.println();
			for(int j=0;j<9;j++) {
				if(j%3==0)
					System.out.print("   ");
				System.out.print(sudo[i][j]+" ");
			}
			System.out.println();
		}
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
