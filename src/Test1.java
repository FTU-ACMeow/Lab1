import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class Test1 {
	@Test
	void testGetBridge() throws IOException {
		Graph G = new Graph();

		G.Load(new Strs("a b c a d c").s);
		assertEquals(new Str(G.GetBridge("a","c")).s,"b d");
		
		G.Load(new Strs("a b c a d c").s);
		assertEquals(new Str(G.GetBridge("e","c")).s,"");
		
		G.Load(new Strs("a b c a d c").s);
		assertEquals(new Str(G.GetBridge("a","e")).s,"");

		G.Load(new Strs("a b c d").s);
		assertEquals(new Str(G.GetBridge("a","d")).s,"");
	}
}
