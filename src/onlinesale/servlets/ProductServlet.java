package onlinesale.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinesale.dbconnection.CartConnection;
import onlinesale.dbconnection.ProductConnection;
import onlinesale.manager.ProductManager;
import onlinesale.model.Cart;
import onlinesale.model.Product;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Cart cartInstance;
	
	private ProductManager _productManager;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action").trim();
		if("addToCart".equals(action)){
			String productId = request.getParameter("productId").trim();
			
			Product product = ProductConnection.getInstance().getProduct(Integer.valueOf(productId));
			
			int actualQuantity = CartConnection.getInstance().getQuantityInCart(getCartInstance().getId(), product.getId());
			
			if(actualQuantity == 0){
				CartConnection.getInstance().addCartContent(getCartInstance().getId(), product.getId());
				actualQuantity++;
			}
			else{
				CartConnection.getInstance().setQuantityInCart(++actualQuantity, getCartInstance().getId(), product.getId());
			}
			
			String mess = actualQuantity +  " " + product.getName() + " now in cart";
			response.setContentType("text/plain");
			response.getWriter().write(mess);
		}
		else if("getCartId".equals(action)){
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private static Cart getCartInstance(){
		if(cartInstance==null)
			cartInstance = CartConnection.getInstance().insertCart();
		return cartInstance;
	}
}
