package presidentsWeb;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Presidents")
public class PresServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	DAOPres daopres;
	//int presidentNum;

	public void init() throws ServletException
	{
		try {
			daopres = new DAOPres(getServletContext());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
	{

		req.setAttribute("termNumber", daopres.getPrez());
		req.getRequestDispatcher("/Pres.jsp").forward(req, response);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		if (session.getAttribute("presidents") == null) {
			session.setAttribute("presidents", new LinkedHashSet<President>());
			session.setAttribute("presidentNum", 1);
		}
		int presidentNum = (int)session.getAttribute("presidentNum");
		String input = req.getParameter("input");
		
		if(req.getParameter("termNumber") != null){
			presidentNum = Integer.parseInt(req.getParameter("termNumber"));
		}
		else{
			if(input !=null){
				switch(input){
				case "Previous":
					if(presidentNum>1){
						--presidentNum;
					}
					else{
						presidentNum=44;
					}
					break;
				case "Next":
					if(presidentNum <44){
						++presidentNum;
					}
					else{
						presidentNum = 1;
					}
						
					break;
				}
			}
		}
		
		President president = daopres.getPresident(presidentNum);
		//req.getRequestDispatcher("/Pres.jsp").forward(req, response);

		req.setAttribute("president", president);
		
		session.setAttribute("presidentNum", presidentNum);
		
		if (president != null) {
			
			Set<President> presidentList = (Set<President>) session.getAttribute("presidents");
			presidentList.add(president);
			
			req.getRequestDispatcher("/Pres.jsp").forward(req, response);
		}
	}

}
