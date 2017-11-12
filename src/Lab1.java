import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Lab1 {
  /**
    * 
    */
  public static void main(String args[]) throws IOException {
    String[] ss = StringProcess.LoadFile("E:/1.txt");
    System.out.println(StringProcess.Merge(ss));
    Graph g = new Graph();
    g.Load(ss);
    HashMap<String, Integer> res = g.Dijkstra("i");
    Iterator<String> iter = res.keySet().iterator();
    while (iter.hasNext()) {
      String key = iter.next();
      System.out.println(key + " = " + res.get(key));
    }
    System.out.println(StringProcess.Merge(g.GetBridge("i","a")));
    System.out.println(StringProcess.Merge(g.RandomWalk("i")));
    String[][] sss = g.ShortestPath("a", "c");
    System.out.println(sss.length);
    for (int i = 0 ; i < sss.length ; i++) {
      System.out.println(":" + StringProcess.Merge(sss[i])); }
  }
}