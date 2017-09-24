import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	
	
	public String selectCode(String type,String code) throws Exception{
		//System.out.print(type+"\t->+"+code+"\n\n");
		switch(type) {
			case "java":return runJava(code);
			case "py":return runpython(code);
			case "cpp":return runCpp(code);//runCpp(code);
		}
		return null;
	}
	
	public String runCpp(String code)throws Exception{
		Runtime rt = Runtime.getRuntime();
		String path = "C:\\Users\\Blank\\Desktop\\Buffer";
		String[] compileCommands = {"cmd","/c g++ "+path+"\\Buf.cpp -o "+path+"\\Buf"};
		String[] runCommands = {"cmd","/c "+path+"\\Buf"};
		String read;
		Matcher match;
		StringBuilder res = new StringBuilder();
		boolean errorOccoured= false;
		
		File file = new File(path);
		file.getParentFile().mkdirs(); 
		file.createNewFile();
		//System.out.println(file.getAbsolutePath()+"\n\n");
		PrintWriter saveCode= new PrintWriter(path+"\\Buf.cpp","UTF-8");
		saveCode.print(code);
		saveCode.close();
		
		
		Process proc1 = rt.exec(compileCommands);
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc1.getErrorStream())),stdInput;
		
		while ((read = stdError.readLine()) != null) {
			match = Pattern.compile("Buf\\..*").matcher(read);
			res.append((match.find() ? match.group():read)+"\n");
			errorOccoured= true;
		}
		
		if(errorOccoured)
			return res.toString();
		Process proc2 = rt.exec(runCommands);
		stdInput = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
			
		while ((read = stdInput.readLine()) != null) 
			res.append(read);
		
		return res.toString();
	}
	
	public String runJava(String code) throws Exception{
		Runtime rt = Runtime.getRuntime();
		String path = "C:\\Users\\Blank\\Desktop\\Buffer";
		File file = new File(path);
		file.getParentFile().mkdirs(); 
		file.createNewFile();
		//File file = new File("C:/Users/Blank/Desktop/Buffer");
		//System.out.println(file.getAbsolutePath()+"\n\n");
		PrintWriter saveCode= new PrintWriter(path+"\\Buf.java","UTF-8");
		String[] Compilecommands = {"cmd","/c javac "+path+"\\Buf.java"};
		String[] runCommands = {"cmd","/c java "+path+"\\Buf"};
		String read;
		StringBuilder res = new StringBuilder();
		Process proc1 = rt.exec(Compilecommands);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
		 boolean errorOccoured= false;
		BufferedReader stdError = new BufferedReader(new
		     InputStreamReader(proc1.getErrorStream()));
		 
		//System.out.println("hey bro...here you go\n\n\t"+stdInput.readLine()+"\n\n"+stdError.readLine());
		// read the output from the command
		
		
			while ((read = stdInput.readLine()) != null) 
				res.append(read);
			
			res.append("<div style=\"color:red\">");
		
		// read any errors from the attempted command
		//System.out.println("Here is the standard error of the command (if any):\n");
		while ((read = stdError.readLine()) != null) {
		    res.append(read);
		    errorOccoured= true;
		}
		res.append("</div>");
		
		if(!errorOccoured) {
		Process proc2 = rt.exec(runCommands);
		
		
		stdInput = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
		 
		stdError = new BufferedReader(new
		     InputStreamReader(proc2.getErrorStream()));
		 
		//System.out.println("hey bro...here you go\n\n\t"+stdInput.readLine()+"\n\n"+stdError.readLine());
		// read the output from the command
		
		
			while ((read = stdInput.readLine()) != null) 
				res.append(read);
			
			res.append("<div style=\"color:red\">");
		
		// read any errors from the attempted command
		//System.out.println("Here is the standard error of the command (if any):\n");
		while ((read = stdError.readLine()) != null)
		    res.append(read);
		res.append("</div>");
		}
		return res.toString();
	}
	
	public String runpython(String code) throws Exception{	
		Runtime rt = Runtime.getRuntime();
		String path = "C:\\Users\\Blank\\Desktop\\Buffer";
		File file = new File(path);
		file.getParentFile().mkdirs(); 
		file.createNewFile();
		//File file = new File("C:/Users/Blank/Desktop/Buffer");
		//System.out.println(file.getAbsolutePath()+"\n\n");
		PrintWriter saveCode= new PrintWriter(path+"\\Buf.py","UTF-8");
		String[] commands = {"cmd","/c C:\\Users\\Blank\\AppData\\Local\\Programs\\Python\\Python36-32\\python.exe "+path+"\\Buf.py"};
		Process proc = rt.exec(commands);
		
		StringBuilder res = new StringBuilder();
		String read="";
		boolean errorOccoured = false;
		Matcher match;
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		 
		// read the output from the command
		while((read = stdError.readLine()) != null) {
			errorOccoured=true;
			match = Pattern.compile("Buf\\..*").matcher(read);
			res.append((match.find() ? match.group():read)+"\n");
		}
		
		if(errorOccoured)
			return res.toString();
		
		while ((read = stdInput.readLine()) != null) 
				res.append(read);
		
		return res.toString();
	}
}
