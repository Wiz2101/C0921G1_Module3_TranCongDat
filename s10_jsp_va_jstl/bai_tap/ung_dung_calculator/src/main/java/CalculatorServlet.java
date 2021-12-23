import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/","/calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstOperand = request.getParameter("firstOperand");
        String secondOperand = request.getParameter("secondOperand");
        String operator = request.getParameter("operator");
        Float result = Calculator.calculate(Float.parseFloat(firstOperand),Float.parseFloat(secondOperand),operator);
        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("Calculator.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Calculator.jsp").forward(request,response);
    }
}
