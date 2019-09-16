import java.util.HashSet;
import java.util.Set;

import com.creditsuisse.canvas.DrawingApp;

public class Test {
	public static int count(int[] tree) {
        
		Set<Integer> parents = new HashSet<Integer>();
		
		for (int i =0;i<tree.length;i++) {
				if(i!=tree[i] && tree[i]!=-1) {
					parents.add(tree[i]);
				}
		}
		
		return parents.size();
    }

    public static void main(String[] args) {
       DrawingApp app = new DrawingApp();
       app.startApp();
    }
}
