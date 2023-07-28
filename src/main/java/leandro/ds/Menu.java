package leandro.ds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Menu {
    @GetMapping(value = "/tree")
    public ModelAndView tree()
    {
        return new ModelAndView("tree");
    }
    
    @GetMapping(value = "/graph")
    public ModelAndView graph()
    {
        return new ModelAndView("graph");
    }
}
