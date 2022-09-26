package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.CategoryEntity;
import Repository.CategoryRepository;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet({"/CategoryController", "/category", "/danh-muc"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryRepository categoryRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
    	categoryRepository = new CategoryRepository();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method
		String view = "";
		String action = request.getParameter("action");
		if(action == null || action.equals("index")) {
			List<CategoryEntity> lists = categoryRepository.find();
			view = "views/category/category.jsp";
			request.setAttribute("lists", lists);
		} else if(action.equals("update")) {
			view = "views/category/update.jsp";
			String id = request.getParameter("id");
			request.setAttribute("cat", categoryRepository.findById(Integer.parseInt(id)));
		} else if(action.equals("remove")) {
			String id = request.getParameter("id");
			categoryRepository.remove(Integer.parseInt(id));
			List<CategoryEntity> lists = categoryRepository.find();
			view = "views/category/category.jsp";
			request.setAttribute("lists", lists);
		} else if(action.equals("add")) {
			view = "views/category/add.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		int status = Integer.parseInt(request.getParameter("status"));
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		
		if(action!= null && action.equals("add")) {
			categoryRepository.add(new CategoryEntity(name, status, parentId));
		} else if(action != null && action.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			categoryRepository.update(new CategoryEntity(id, name, status, parentId));
		}
		response.sendRedirect("category");
	}

}
