package au.usyd.elec5619.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Order;
import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.OrderManager;
import au.usyd.elec5619.service.ProductManager;

@Controller
@RequestMapping(value="/order/**")//
public class OrderController {
	
	@Autowired
	//@Qualifier("DatabaseProductManager")
	private OrderManager orderManager;
	@Autowired
	private ProductManager productmanager;
	
	@RequestMapping(value="/add/{id}/{userid}")
	public String addProduct(Model uiModel,@PathVariable("id") Long id,@PathVariable("userid") int userid) {
		System.out.println(id);
		Order order = new Order();
		order.setProductID(id);
		order.setUserid(userid);
		Product product = productmanager.getProductById(id);
		uiModel.addAttribute("product", product);
		uiModel.addAttribute("order", order);
		return "addorder";
	}
	
//	@RequestMapping(value="/addorder", method=RequestMethod.POST)
//	public String addOrder(@ModelAttribute Order order) {
//		//要更新数据库(把原来的数据库drop掉)
//		System.out.println(order.getAddress());
//		orderManager.addOrder(order);
//			
//		return "redirect:/shop";
//	}
	@RequestMapping(value="/addorder", method=RequestMethod.POST)
	public String addOrder(@ModelAttribute Order order) {
		//要更新数据库(把原来的数据库drop掉)
		Product product = productmanager.getProductById(order.getProductID());
		int currentamount = product.getAmount();
		int remainamount = currentamount-order.getAmount();
		product.setAmount(remainamount);
		productmanager.updateProduct(product);
		orderManager.addOrder(order);
		return "redirect:/shop";
	}
	@RequestMapping(value = "/list-orders")
    public String listOrders(Model model) {
        List<Order> orders = orderManager.getOrders();
        System.out.println(orders.get(0));
        model.addAttribute("orders", orders);

        return "OrderList";
    }
	
	@RequestMapping(value="/delete-order/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id) {
		
		orderManager.deleteOrder(id);
		
		return "redirect:/order/list-orders";
	}
}
