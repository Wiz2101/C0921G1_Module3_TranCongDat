import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", urlPatterns = {"","/customer"})
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Nguyễn Văn An",1,"24/12/2000","Hội An","https://lh3.googleusercontent.com/proxy/43ETRRgZx062S3Un1LQ6M9ECYIcYqbMbVOc6urC4UL4Fh4XCDQM8ft0PRMHk62RqXvEsIqC7613M574G_JvJgC0tNKEK5aA6-yM_4VkC_N-bCciVqA"));
        customerList.add(new Customer("Trần Văn Bình",1,"08/03/1999","Đà Nẵng","https://lh3.googleusercontent.com/proxy/43ETRRgZx062S3Un1LQ6M9ECYIcYqbMbVOc6urC4UL4Fh4XCDQM8ft0PRMHk62RqXvEsIqC7613M574G_JvJgC0tNKEK5aA6-yM_4VkC_N-bCciVqA"));
        customerList.add(new Customer("Đỗ Thị Cần",0,"02/09/1998","Huế","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQKLGljbbY-D_lT6bt1CefJ9wof7WZZl8Odx6y7HrLon3w0d05vqkciqLd2yRBzosjheo&usqp=CAU"));
        customerList.add(new Customer("Nguyễn Thị Duyên",0,"01/06/1996","Quảng Ngãi","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQKLGljbbY-D_lT6bt1CefJ9wof7WZZl8Odx6y7HrLon3w0d05vqkciqLd2yRBzosjheo&usqp=CAU"));
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
