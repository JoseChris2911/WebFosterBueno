/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.Categoria;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Producto;
import util.HibernateUtil;

/**
 *
 * @author usuario
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Session singleton = HibernateUtil.getSessionFactory().openSession();
            HttpSession session = request.getSession();
            String op = request.getParameter("op");
            RequestDispatcher dispatcher;

            ArrayList<Categoria> categorias;
            ArrayList<Producto> productos;
            int idprod;

            if (op.equals("inicio")) {
                Query q = singleton.createQuery("from Categoria");

                Iterator itc = q.iterate();
                categorias = new ArrayList<Categoria>();

                for (; itc.hasNext();) {
                    Categoria categoria = (Categoria) itc.next();
                    categorias.add(categoria);
                }

                session.setAttribute("categorias", categorias);
                dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);

            } else if (op.equals("dameproductos")) {
                int idcat = Integer.parseInt(request.getParameter("idcat"));

                Query q = singleton.createQuery("from Producto where categoriaid=" + idcat + "order by id");

                Iterator itc = q.iterate();
                productos = new ArrayList<Producto>();

                for (; itc.hasNext();) {
                    Producto producto = (Producto) itc.next();
                    productos.add(producto);
                }

                session.setAttribute("productos", productos);
                dispatcher = request.getRequestDispatcher("producto.jsp");
                dispatcher.forward(request, response);
            } else if (op.equals("damedetalle")) {

                idprod = Integer.parseInt(request.getParameter("idprod"));
                Query q = singleton.createQuery("from Producto where id=" + idprod);

                Iterator itc = q.iterate();
                Producto producto =null;
                for (; itc.hasNext();) {
                     producto = (Producto) itc.next();
                    
                }
                System.out.println(producto);
                session.setAttribute("producto", producto);

                /* idprod = Integer.parseInt(request.getParameter("idprod"));
                int votos = new DAOPunto().getPuntosByProducto(idprod);
                session.setAttribute("totalvotos", votos);

                */
                dispatcher = request.getRequestDispatcher("detail.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
