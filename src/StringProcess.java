
import java.util.*;
import java.io.*;

public class StringProcess {
	public static String mMerge (String[] data) {
		
		StringBuffer Res;
		Res= new StringBuffer();
		String[] Data=data;
		for (int i = 0 ; i < Data.length ; i++) {
			if (i > 0){
				Res.append(" ");
			}
			Res.append(Data[i]);
		}
		return Res.toString();
	}
	public static String[] Split (String Data) {
		ArrayList<String> Res = new ArrayList<String>();
		String tmp = "";
		Data = Data.toLowerCase() + " ";
		for (int i = 0 ; i < Data.length() ; i++) {
			if (Character.isLowerCase(Data.charAt(i)))
				tmp = tmp + Data.charAt(i);
			else if (!tmp.equals("") && (Data.charAt(i) == ' ' || Data.charAt(i) == '\t' || Data.charAt(i) == '\n' || Data.charAt(i) == '.'  || Data.charAt(i) == ','  || Data.charAt(i) == '?'  || Data.charAt(i) == '!'  || Data.charAt(i) == ':'  || Data.charAt(i) == ';'  || Data.charAt(i) == '\'' || Data.charAt(i) == '\"' || Data.charAt(i) == '~'  || Data.charAt(i) == '('  || Data.charAt(i) == ')')) {
				Res.add(tmp);
				tmp = "";
			}
		}
		return Res.toArray(new String[Res.size()]);
	}
	/**
	 * 
	 * @param Data
	 * @return
	 */
	public static String Format (String Data) {
		return mMerge(Split(Data));
	}
	public static String[] LoadFile (String FileName) throws IOException {
		String Data = "";
		String Line = "";
		BufferedReader in = new BufferedReader(new FileReader(FileName));
		while ((Line = in.readLine()) != null)
			Data = Data + " " + Line;
		in.close();
		return Split(Data);
	}
}
