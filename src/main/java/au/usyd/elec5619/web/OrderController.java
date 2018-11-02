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
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.OrderManager;
import au.usyd.elec5619.service.ProductManager;
import au.usyd.elec5619.service.Usercreater;

@Controller
@RequestMapping(value="/order/**")//
public class OrderController {
	
	@Autowired
	//@Qualifier("DatabaseProductManager")
	private OrderManager orderManager;
	@Autowired
	private ProductManager productmanager;
	@Autowired
	private Usercreater usercreater;
	
	@RequestMapping(value="/add/{id}/{userid}/{pointcheck}")
	public String addProduct(Model uiModel,@PathVariable("id") Long id,@PathVariable("userid") int userid,@PathVariable("pointcheck") int pointcheck) {
		System.out.println(id);
		Order order = new Order();
		order.setProductID(id);
		order.setUserid(userid);
		Product product = productmanager.getProductById(id);
		uiModel.addAttribute("product", product);
		uiModel.addAttribute("order", order);
		if(pointcheck==1) {
			uiModel.addAttribute("pointcheck", 1);
		}
		else {
			uiModel.addAttribute("pointcheck", 0);
		}
		
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
	public String addOrder(@ModelAttribute Order order, Model model) {
		long userid = order.getUserid();		
		int userid_c = (int)userid;
		Product product = productmanager.getProductById(order.getProductID());
		//trade point
		double price = product.getPrice();
		int amount = order.getAmount();
		int price_c = (int)price;
		int point = price_c * amount;
		User user = usercreater.getUserById(userid_c);
		int currectpoint = user.getPoints();
		if(point>=currectpoint) {
			return "redirect:/order/add/"+product.getId()+"/"+userid+"/"+1;
		}
		else {
			usercreater.trade(point, 0, userid_c);
			//要更新数据库(把原来的数据库drop掉)
			int currentamount = product.getAmount();
			int remainamount = currentamount-order.getAmount();
			product.setAmount(remainamount);
			productmanager.updateProduct(product);
			orderManager.addOrder(order);
			model.addAttribute("pointcheck", 0);
			return "redirect:/shop";
		}
		
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
