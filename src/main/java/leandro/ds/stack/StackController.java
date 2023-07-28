package leandro.ds.stack;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StackController {

    @Autowired
    private Stack stack;

    @GetMapping(value = "/stack")
    public ModelAndView stack()
    {
        return new ModelAndView("stack");
    }

    @RequestMapping(value = "/api/v1/shopping-cart/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addToCart(@RequestBody Product product) throws Exception
    {
        try{
            stack.push(product);
            return ResponseEntity.ok(product.getName() + " was added to cart");
        }catch(Exception e){
            throw new Exception("ERROR: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/api/v1/shopping-cart/get-products", method = RequestMethod.GET)
    public List<Product> getProducts() throws Exception
    {
        try {
            return stack.get();
        } catch (Exception e) {
            throw new Exception("ERROR: " + e.getMessage());
        }
    }

    @RequestMapping(value = "api/v1/shopping-cart/get-total", method = RequestMethod.GET)
    public int getTotal()
    {
       return stack.total();
    }

    @RequestMapping(value = "api/v1/shopping-cart/remove", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> removeFromCart() throws Exception
    {
        try {
            Product product = stack.pop();
            return ResponseEntity.ok(product.getName() + " was removed from cart");
        } catch (Exception e) {
            throw new Exception("There is no product in the cart");
        }
    }
}
