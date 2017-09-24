import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OnServletLogin")
public class OnServletLogin extends HttpServlet  
{
   
	//private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");

		String user=request.getParameter("userName");
		String pass=request.getParameter("userPassword");

		if(user.equals("java4s")&&pass.equals("java4s")) {
                 //pw.println("Login Success...!"); 
                 response.sendRedirect("UserPage.jsp?invalid=false");
		}
        else {
        	/*pw.print("<h1>page</h1>");
        	pw.print("<script type=\"text/javascript\">");
        	pw.print("alert('Login Failed...!');");
        	pw.print("location=	'index.jsp';");
        	pw.print("</script>");*/
        	response.sendRedirect("index.jsp?invalid=true");
        }
        pw.close();

	}

}