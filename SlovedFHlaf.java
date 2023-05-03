package maiN;

import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SlovedFHlaf extends SudoUsingTravelingSlaceman{
  @Test
  public void recslove() {
	  System.out.println("Unsloved sudoku");
	  printl();
	  run();
	 ArrayList<ArrayList> z = Zeros();
//	 System.out.println(z.size());
	 HalfRun();
	
	 System.out.println(" sloved Sudoku");
	 printl();
  }
  public void HalfRun() {
	  ArrayList<ArrayList> z = Zeros();
	  for (ArrayList a : z) {
		int i=(int) a.get(0);
		int j=(int) a.get(1);
		if(sudo[i][j]==0) {
			ArrayList<Integer> l = findPairs(i,j);
			System.out.println(l.size());
			for (  Integer b : l) {
				sudo[i][j]=b;
				run();
				if(Zeros().size()==0)
					return;
			}
		}
		
	}
  }
  public ArrayList<Integer> findPairs(int i, int j) {
	  ArrayList<Integer> l=new ArrayList();
	  for(int k=1;k<=9;k++) {
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
				l.add(k);
			}
	  }
	  return l;
  }
}
