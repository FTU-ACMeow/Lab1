import java.util.*;

public class Str {
	public final String s;
	public Str (String ss) {
		s = ss;
	}
	public Str (Strs ss) {
		s = ss.Merge();
	}
	public Str (String[] ss) {
		s = (new Strs(ss)).Merge();
	}
	public String[] Split () {
		ArrayList<String> Res = new ArrayList<String>();
		String tmp = "";
		String Data = s.toLowerCase() + " ";
		for (int i = 0 ; i < Data.length() ; i++) {
			if (Character.isLowerCase(Data.charAt(i)))
				tmp = tmp + Data.charAt(i);
			else if (tmp != "" && (Data.charAt(i) == ' ' || Data.charAt(i) == '\t' || Data.charAt(i) == '\n' || Data.charAt(i) == '.'  || Data.charAt(i) == ','  || Data.charAt(i) == '?'  || Data.charAt(i) == '!'  || Data.charAt(i) == ':'  || Data.charAt(i) == ';'  || Data.charAt(i) == '\'' || Data.charAt(i) == '\"' || Data.charAt(i) == '~'  || Data.charAt(i) == '('  || Data.charAt(i) == ')')) {
				Res.add(tmp);
				tmp = "";
			}
		}
		return Res.toArray(new String[Res.size()]);
	}
}
