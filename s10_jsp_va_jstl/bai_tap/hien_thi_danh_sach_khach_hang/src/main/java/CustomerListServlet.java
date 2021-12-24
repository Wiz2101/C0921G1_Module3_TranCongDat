import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", urlPatterns = "/customer")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Nguyen Van An",1,"24/12/2000","Hoi An","https://lh3.googleusercontent.com/proxy/43ETRRgZx062S3Un1LQ6M9ECYIcYqbMbVOc6urC4UL4Fh4XCDQM8ft0PRMHk62RqXvEsIqC7613M574G_JvJgC0tNKEK5aA6-yM_4VkC_N-bCciVqA"));
        customerList.add(new Customer("Tran Van Binh",1,"08/03/1999","Da Nang","https://lh3.googleusercontent.com/proxy/43ETRRgZx062S3Un1LQ6M9ECYIcYqbMbVOc6urC4UL4Fh4XCDQM8ft0PRMHk62RqXvEsIqC7613M574G_JvJgC0tNKEK5aA6-yM_4VkC_N-bCciVqA"));
        customerList.add(new Customer("Do Thi Can",0,"02/09/1998","Hue","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQKLGljbbY-D_lT6bt1CefJ9wof7WZZl8Odx6y7HrLon3w0d05vqkciqLd2yRBzosjheo&usqp=CAU"));
        customerList.add(new Customer("Nguyen Thi Duyen",0,"01/06/1996","Quang Nam","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQKLGljbbY-D_lT6bt1CefJ9wof7WZZl8Odx6y7HrLon3w0d05vqkciqLd2yRBzosjheo&usqp=CAU"));
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
