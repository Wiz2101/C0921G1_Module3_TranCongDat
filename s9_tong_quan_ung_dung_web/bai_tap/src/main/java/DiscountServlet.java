import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;
        request.setAttribute("productDescription", description);
        request.setAttribute("productDiscount",discount);
        request.setAttribute("productPromotion",discountAmount);
        request.setAttribute("productDiscountPrice", discountPrice);
        request.getRequestDispatcher("result.jsp").forward(request,response);
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h2>" + description + " discounted " + discount + " is:"  );
//        writer.println("<h2> Discount Amount: " + discount + " USD</h2>");
//        writer.println("<h2> The price after discount: " + discountPrice + " USD</h2>");
//        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
