import java.util.Arrays;

public class Strs {
	public final String[] s;
	public Strs (Str ss) {
		s = ss.Split();
	}
	public Strs (String ss) {
		s = (new Str(ss)).Split();
	}
	public Strs (String[] ss) {
		s = Arrays.copyOf(ss, ss.length);
	}
	public String Merge () {
		StringBuffer Res = new StringBuffer();
		for (int i = 0 ; i < s.length ; i++) {
			if (i > 0)
				Res.append(" ");
			Res.append(s[i]);
		}
		return Res.toString();
	}
}
