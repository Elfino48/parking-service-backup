package org;

/**
 * Created by anon on 1/10/2017.
 */

import logic.Main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        /*PrintWriter wr = response.getWriter();
        wr.println("<html><head><title>Hello</title></head><body>HELLOTHERE</body></html>");
        wr.close();
*/
       System.out.println("GET");
       List<Product> products = Product.getList();
        for (Product pr: products) {
            System.out.println(pr.name);
        }
       request.setAttribute("products", products);
       //request.getRequestDispatcher("index.jsp").forward(request, response);
        /*try {
            Main.createPark();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //RequestDispatcher req = request.getRequestDispatcher("main");
        //req.forward(request, response);

        System.out.println("POST");

     /*   request.setCharacterEncoding ("UTF-8");
        String name = request.getParameter("name");
        String second_name = request.getParameter("second_name");
        String tel_num = request.getParameter("tel_num");

        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
*/

/*
        request.setAttribute("name", " ");
        request.setAttribute("second_name", " ");
        request.setAttribute("tel_num", " ");

*/





//        response.setContentType("text/html");

  //      this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        //getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
       /* try {
            Main.createPark();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}