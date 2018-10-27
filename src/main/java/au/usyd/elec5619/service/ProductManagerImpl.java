package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.DAO.ProductDAO;
import au.usyd.elec5619.domain.Product;
//使用注解就可以不用在XML中再写其他的
@Service(value="productmanager")
@Transactional
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	public ProductDAO productDAO;
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		productDAO.increasePrice(percentage);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getallProducts();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.addProduct(product);
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(id);
	}
	
	//将图片文件存到server的制定文件夹中
	public String uploadpicture(MultipartFile file, String serverpath) throws Exception, IOException {
		//String localpath = "D:\\apache-tomcat-8.0.53\\webapps\\elec5619Springapp\\img\\";
		String localpath = "F:\\study\\COMP5619 Object Oriented Application Frameworks\\image\\product";
		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		File newFile = new File(localpath,newFileName);
		//File newFile = new File(serverpath+'\\'+newFileName);
		file.transferTo(newFile);
		String url = newFileName;
		return url;
	}
}