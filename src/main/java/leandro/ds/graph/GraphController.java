package leandro.ds.graph;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/v1/graph")
public class GraphController {
    @Autowired
    private Graph graph;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> add(@RequestBody Model model) throws Exception
    {
        try {
            graph.addRoot(model.getLocal(), model.getCloseness());
            return ResponseEntity.ok("New destination was added");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/display", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAll() throws Exception
    {
        try{
            return graph.getDestinations();
        }catch(Exception e){
            throw new Exception("ERROR: " + e.getMessage());
        }
    }

    @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> calculate(@RequestBody Model model) throws Exception
    {
        try{
            return graph.findShorterWay(model.getLocal(), model.getCloseness());
        }catch(Exception e){
            throw new Exception("ERROR: " + e.getMessage());
        }
    }


}
