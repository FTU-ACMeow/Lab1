import java.util.HashMap;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void testDijkstra() {
		Graph G = new Graph();
		G.Load(new Strs("a c b d c e").s);
		G.Dijkstra("a");
		
		HashMap<String,Integer> res = G.Dijkstra("a");
	    Iterator<String> iter = res.keySet().iterator();
	    while (iter.hasNext()) {
	      String key = iter.next();
	      System.out.println(key + ":" + res.get(key));
	    }
	}
}
