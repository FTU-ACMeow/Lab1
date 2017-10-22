//Change1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {
  public HashMap<String, HashMap<String, Integer>> edge;
  private HashMap<String, HashMap<String, Integer>> revedge;
  private HashMap<String, HashMap<String, Integer>> Mem_Dis;
  
  public void Insertedge (String u, String v) {
  if (!edge.containsKey(u)){
    edge.put(u, new HashMap<String, Integer>());}
		if (!edge.get(u).containsKey(v))
			edge.get(u).put(v, 0);
		edge.get(u).put(v, edge.get(u).remove(v) + 1);
		if (!revedge.containsKey(v))
			revedge.put(v, new HashMap<String, Integer>());
		if (!revedge.get(v).containsKey(u))
			revedge.get(v).put(u, 0);
		revedge.get(v).put(u, revedge.get(v).remove(u) + 1);
		Mem_Dis = new HashMap<String, HashMap<String, Integer>>();
	}
	public void Init () {
		edge = new HashMap<String, HashMap<String, Integer>>();
		revedge = new HashMap<String, HashMap<String, Integer>>();
		Mem_Dis = new HashMap<String, HashMap<String, Integer>>();
	}
	public void Load (String[] FileData) {
		Init();
		for (int i = 1 ; i < FileData.length ; i++)
			Insertedge(FileData[i-1], FileData[i]);
	}
	public String[] GetBridge (String u, String v) {
		if (edge.containsKey(u) && edge.containsKey(v)) {
			ArrayList<String> res = new ArrayList<String>();
			Iterator<String> iter = edge.keySet().iterator();
			while (iter.hasNext()) {
				String w = iter.next();
				if (edge.get(u).containsKey(w) && edge.get(w).containsKey(v))
					res.add(w);
			}
			return res.toArray(new String[res.size()]);
		}
		else return new String[0];
	}
	public String[] FillWithBridge (String[] Text) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0 ; i < Text.length ; i++) {
			res.add(Text[i]);
			if (i > 1) {
				String[] Bridges = GetBridge (Text[i-1], Text[i]);
				if (Bridges.length > 0)
					res.add(Bridges[(int)(Math.random()*Bridges.length)]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
	public HashMap<String, Integer> Dijkstra (String u) {
		if (!Mem_Dis.containsKey(u)) {
			HashMap<String, Integer> Dis = new HashMap<String, Integer>();
			HashSet<String> Visit = new HashSet<String>();
			Dis.put(u, 0);
			while (Visit.size() < Dis.size()) {
				u = null;
				Iterator<String> iter = Dis.keySet().iterator();
				while (iter.hasNext()) {
					String v = iter.next();
					if (!Visit.contains(v) && (u == null || Dis.get(v) < Dis.get(u))) 
						u = v;
				}
				Visit.add(u);
				if (edge.containsKey(u)) {
					iter = edge.get(u).keySet().iterator();
					while (iter.hasNext()) {
						String v = iter.next();
						if (!Dis.containsKey(v) || Dis.get(u) + edge.get(u).get(v) < Dis.get(v))
							Dis.put(v, Dis.get(u) + edge.get(u).get(v));
					}
				}
			}
			Mem_Dis.put(u, Dis);
		}
		return Mem_Dis.get(u);
	}
	private void SPDFS (String u, String v, String w, ArrayList<String[]> res, HashSet<String> visit, ArrayList<String> Path, HashMap<String, Integer> Dis) {
		if (w.equals(v))
			res.add(Path.toArray(new String[Path.size()]));
		else {
			Iterator<String> iter = edge.get(w).keySet().iterator();
			while (iter.hasNext()) {
				String p = iter.next();
				if (visit.contains(p) && edge.get(w).containsKey(p) && Dis.get(w) + edge.get(w).get(p) == Dis.get(p)) {
					Path.add(p);
					SPDFS(u,v,p,res,visit,Path,Dis);
					Path.remove(Path.size()-1);
				}
			}
		}
	}
	/**
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public String[][] ShortestPath (String u, String v) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		HashMap<String, Integer> Dis = Dijkstra(u);
		HashSet<String> visit = new HashSet<String>();
		Queue<String> que = new LinkedList<String>();
		if (Dis.containsKey(v))
			que.add(v);
		while (que.size() > 0) {
			String w = que.remove();
			visit.add(w);
			Iterator<String> iter = revedge.get(w).keySet().iterator();
			while (iter.hasNext()) {
				String p = iter.next();
				if (Dis.containsKey(p) && edge.containsKey(p) && edge.get(p).containsKey(w) && Dis.get(p) + edge.get(p).get(w) == Dis.get(w))
					que.add(p);
			}
		}
		ArrayList<String> Path = new ArrayList<String>();
		Path.add(u);
		SPDFS(u,v,u,res,visit,Path,Dis);
		return res.toArray(new String[res.size()][]);
	}
	public HashMap<String, String[][]> ShortestPath (String u) {
		HashMap<String, Integer> Dis = Dijkstra(u);
		Iterator<String> iter = Dis.keySet().iterator();
		HashMap<String, String[][]> res = new HashMap<String, String[][]>();
		while (iter.hasNext()) {
			String v = iter.next();
			res.put(v, ShortestPath(u, v));
		}
		return res;
	}
	public String[] RandomWalk (String u) {
		ArrayList<String> res = new ArrayList<String>();
		HashSet<String> visit = new HashSet<String>();
		res.add(u);
		while (edge.containsKey(u)) {
			Set<String> vset = edge.get(u).keySet();
			String v = (String)vset.toArray()[(int)(Math.random()*vset.size())];
			if (visit.contains(u+" "+v))
				break;
			visit.add(u+" "+v);
			res.add(v);
			u = v;
		}
		return res.toArray(new String[res.size()]);
	}
}
