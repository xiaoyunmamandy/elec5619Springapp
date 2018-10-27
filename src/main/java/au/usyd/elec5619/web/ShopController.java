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
import javax.servlet.http.HttpSession;
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
public class ShopController {
	
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping(value="/shop")
	public String resMainpage(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		List<Product> products = productManager.getProducts();
        model.addAttribute("products", products);
        HttpSession session = request.getSession(true);
		if(session.getAttribute("username")!="") {
			String username = (String)session.getAttribute("username");
			int userid = (Integer) session.getAttribute("userid");
			System.out.println(username);
			model.addAttribute("userid",userid);
			model.addAttribute("username",username);
		}	
		return "shop_main_page";
	}
}