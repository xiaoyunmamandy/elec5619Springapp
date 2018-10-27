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

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;

/*https://stackoverflow.com/questions/4140448/difference-between-and-in-servlet-mapping-url-pattern
 * about the difference between / and /*
 * https://zhidao.baidu.com/question/1883800724917404028.html
 * come from www.baidu.com
 * */

@Controller
@RequestMapping(value="/product/**")//
public class ProductController {
	
	@Autowired
	//@Qualifier("DatabaseProductManager")
	private ProductManager productManager;
	
	@RequestMapping(value="/add")
	public String addProduct(Model uiModel) {
		uiModel.addAttribute("product", new Product());
		return "addproduct";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file) {
				
		String localpath = "F:\\ELEC5619\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println(originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		System.out.println(newFileName);
		File newFile = new File(localpath,newFileName);
		try {
			file.transferTo(newFile);
		}catch (IOException e) {
			e.printStackTrace();
		}	
		//要更新数据库(把原来的数据库drop掉)
		product.setProductImg(newFileName);
		productManager.addProduct(product);
			
		return "redirect:/product/list-products";
	}
	
	@RequestMapping(value="/edit-product/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long id, Model uiModel) {
		
		Product product = productManager.getProductById(id);
		uiModel.addAttribute("product", product);
		
		return "editproduct";
	}
	
	@RequestMapping(value="/update-product")
	public String editProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file) {
		
		String localpath = "F:\\ELEC5619\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println(originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		System.out.println(newFileName);
		File newFile = new File(localpath,newFileName);
		try {
			file.transferTo(newFile);
		}catch (IOException e) {
			e.printStackTrace();
		}	
		product.setProductImg(newFileName);
		
		productManager.updateProduct(product);
		System.out.println(product.getId());
		
		return "redirect:/product/list-products";
	}
	
	@RequestMapping(value = "/list-products")
    public String listProducts(Model model) {
        List<Product> products = productManager.getProducts();
        System.out.println(products.get(0));
        model.addAttribute("products", products);

        return "ProductList";
    }
	
	@RequestMapping(value="/delete-product/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id) {
		
		productManager.deleteProduct(id);
		
		return "redirect:/product/list-products";
	}
	
//	@RequestMapping(value="/testimage", method=RequestMethod.GET)
//	public String testimage(Model model) {
//		
//		List<Product> products = productManager.getProducts();
//		model.addAttribute("products", products);
//		System.out.println(products.get(1).getProductImg());
//		String localpath = "F:\\study\\COMP5619 Object Oriented Application Frameworks\\image\\product\\";
//		model.addAttribute("localpath", localpath);
//		return "TestImage";
//	}
}
