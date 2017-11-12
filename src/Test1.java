import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class Test1 {
	@Test
	void testGetBridge() throws IOException {
		Graph G = new Graph();

		G.Load(StringProcess.Split("a b c a d c"));
		assertEquals(StringProcess.Merge(G.GetBridge("a","c")),"b d");
		
		G.Load(StringProcess.Split("a b c a d c"));
		assertEquals(StringProcess.Merge(G.GetBridge("e","c")),"");
		
		G.Load(StringProcess.Split("a b c a d c"));
		assertEquals(StringProcess.Merge(G.GetBridge("a","e")),"");

		G.Load(StringProcess.Split("a b c d"));
		assertEquals(StringProcess.Merge(G.GetBridge("a","d")),"");
	}
}
