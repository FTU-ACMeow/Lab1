import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class HW1 {
  /**
    * 
    */
  public static void main(String args[]) throws IOException {
    String[] ss = StringProcess.LoadFile("E:/1.txt");
    System.out.println(StringProcess.mMerge(ss));
    Graph g = new Graph();
    g.Load(ss);
    HashMap<String, Integer> res = g.Dijkstra("i");
    Iterator<String> iter = res.keySet().iterator();
    while (iter.hasNext()) {
      String key = iter.next();
      System.out.println(key + " = " + res.get(key));
    }
    System.out.println(StringProcess.mMerge(g.GetBridge("i","a")));
    System.out.println(StringProcess.mMerge(g.RandomWalk("i")));
    String[][] sss = g.ShortestPath("a", "c");
    System.out.println(sss.length);
    for (int i = 0 ; i < sss.length ; i++) {
      System.out.println(":" + StringProcess.mMerge(sss[i])); }
  }
}
