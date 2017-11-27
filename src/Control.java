import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Control {
	Graph G;
	public Control () {
		G = new Graph();
	}
	public void LoadFile (String FileName) throws IOException {
		String Data = "";
		String Line = "";
		BufferedReader in = new BufferedReader(new FileReader(FileName));
		while ((Line = in.readLine()) != null)
			Data = Data + " " + Line;
		in.close();
		G.Load((new Strs(Data)).s);
	}
	public String[] ShortestPath (String u, String v) {
		String[][] Tmp = G.ShortestPath(u, v);
		String[] Res = new String[Tmp.length];
		for (int i = 0 ; i < Tmp.length ; i++) {
			Res[i] = (new Str(Tmp[i])).s;
		}
		return Res;
	}
	public String[] GetBridge (String u, String v) {
		return G.GetBridge(u, v);
	}
	public String Fill (String Data) {
		return (new Str(G.Fill((new Strs(Data)).s))).s;
	}
	public String[] RandomWalk (String u) {
		return G.RandomWalk(u);
	}
}
