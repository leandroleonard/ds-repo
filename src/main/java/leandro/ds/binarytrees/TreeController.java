package leandro.ds.binarytrees;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/tree")
public class TreeController {
    @Autowired
    private Tree tree;

    @GetMapping(value = "/tree")
    public ModelAndView index() {
        return new ModelAndView("tree");
    }

    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insert(@RequestBody Model model) throws Exception {
        try {
            tree.insert(model.getNumber());
            return ResponseEntity.ok("New value added");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/display", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Model> getAll() throws Exception {
        try {
            return tree.getValues();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/destroy", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> destroy() throws Exception
    {
        try {
            tree.destroy();
            return ResponseEntity.ok("Tree was destroyed");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/search-pre-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> preOrder() throws Exception
    {
        try {
            return tree.preOrderToList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/search-pos-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> posOrder() throws Exception
    {
        try {
            return tree.posOrderToList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/search-in-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> inOrder() throws Exception
    {
        try {
            return tree.inOrderToList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

}
