package controller;

import bean.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ProductServlet", urlPatterns = {"", "/products"})
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private IProductService iProductService = new ProductService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }


    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int max = 0;
        for (Product li : iProductService.findAll()) {
            if (li.getId() > max) {
                max = li.getId();
            }
        }
        int id = max + 1;
        String productName = request.getParameter("productName");
        String quality = request.getParameter("quality");
        String price = request.getParameter("productPrice");
        String productDesc = request.getParameter("productDesc");

        Product product = new Product(id, productName, quality, price, productDesc);
        this.iProductService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        String quality = request.getParameter("quality");
        String price = request.getParameter("productPrice");
        String productDesc = request.getParameter("productDesc");
        Product product = this.iProductService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error404.jsp");
        } else {
            product.setProductName(productName);
            product.setQuality(quality);
            product.setPrice(price);
            product.setProductDesc(productDesc);
            this.iProductService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.iProductService.remove(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                break;


        }
        List<Product> productList = this.iProductService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("product/list_product.jsp").forward(request, response);

    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
