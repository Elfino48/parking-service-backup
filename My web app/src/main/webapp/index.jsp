<!DOCTYPE html>
<html>

    <head>
       <meta http-equiv="content-type" content="text/html; charset=utf-8">
       <title>JS Bin</title>
       <style type="text/css">
          body{

          background: yellow;

          }

          * {box-sizing: border-box;}
          .product-item {
            width: 300px;
            text-align: center;
            margin: 0 auto;
            border-bottom: 2px solid #F5F5F5;
            background: white;
            font-family: "Open Sans";
            transition: .3s ease-in;
          }
          .product-item:hover {border-bottom: 2px solid #fc5a5a;}
          .product-item img {
            display: block;
            width: 100%;
          }
          .product-list {
            background: #fafafa;
            padding: 15px 0;
          }
          .product-list h3 {
            font-size: 18px;
            font-weight: 400;
            color: #444444;
            margin: 0 0 10px 0;
          }
          .price {
            font-size: 16px;
            color: #fc5a5a;
            display: block;
            margin-bottom: 12px;
          }
          .button {
            text-decoration: none;
            display: inline-block;
            padding: 0 12px;
            background: #cccccc;
            color: white;
            text-transform: uppercase;
            font-size: 12px;
            line-height: 28px;
            transition: .3s ease-in;
          }
          .product-item:hover .button {background: #fc5a5a;}
         </style>
    </head>

    <body>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
        <%@ page import="java.util.*, java.text.*, java.io.*, models.*, java.util.List, dao.*, logic.*, java.sql.SQLException" %>
        <table border="1">
        <caption>Заказы</caption>
            <%


                List<Order> prd = OrderRepository.getOrders("1019", 1);
                out.println("<tr><td>Имя</td><td>Фамилия</td></tr>");
                for ( Order pr : prd ){
                    out.println("<tr><td>" + pr.getName() +
                    "</td><td>" + pr.getSecondName() + "</td></tr>");
                }
            %>

        </table>

        <%


            for ( Order pr : prd ){
                out.println("<div class=\"product-item\">" +
                                "<img src=\"https://html5book.ru/wp-content/uploads/2015/10/black-dress.jpg\">" +
                                "<div class=\"product-list\">" +
                                "<h3>" + pr.getName() + "</h3>" +
                                "<span class=\"price\">₽ 1999</span>" +
                                "<a href=\"\" class=\"button\">В корзину</a>" +
                                "</div></div>");
            }

        %>

        <a href = "order.jsp">АДМИН ПАНЕЛЬ</a>

    </body>
</html>
