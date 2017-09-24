import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONObject;

/**
 * Servlet implementation class CompileAndRun
 */
@WebServlet("/CompileAndRun")
public class CompileAndRun extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public CompileAndRun() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String type=request.getParameter("type");
		 String code=request.getParameter("code");
		 PrintWriter write = response.getWriter();
		 
		 Program newCode = new Program();
		 
		 try {
			 write.print(newCode.selectCode(type, code));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendError(406);
	}


}
