package au.usyd.elec5619.web;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.service.SimpleRecipecreater;

public class RecipeControllerTest extends TestCase{
	public void testHandleRequestView() throws Exception{
		RecipeController controller = new RecipeController();
		controller.setRecipecreater(new SimpleRecipecreater());
		ModelAndView modelandview = controller.handleRequest(null, null);
		assertEquals("hello", modelandview.getViewName());
		assertNotNull(modelandview.getModel());
		Map modelmap = (Map)modelandview.getModel().get("model");
		String nowvalue = (String)modelmap.get("now");
		assertNotNull(nowvalue);
	}
}