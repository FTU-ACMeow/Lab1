import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Lab1 {
  /**
    * 
    */
  public static void main(String args[]) throws IOException {
	Control g = new Control();
    g.LoadFile("E:/1.txt");
    HashMap<String, Integer> res = g.G.Dijkstra("i");
    Iterator<String> iter = res.keySet().iterator();
    while (iter.hasNext()) {
      String key = iter.next();
      System.out.println(key + " = " + res.get(key));
    }
    System.out.println(new Str(g.GetBridge("i","a")).s);
    System.out.println(new Str(g.RandomWalk("i")).s);
    String[] sss = g.ShortestPath("a", "c");
    System.out.println(sss.length);
    for (int i = 0 ; i < sss.length ; i++) {
      System.out.println(":" + sss[i]);
    }
  }
}