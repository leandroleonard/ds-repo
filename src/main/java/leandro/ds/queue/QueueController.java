package leandro.ds.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import leandro.ds.exception.PersonBadRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class QueueController {
    @Autowired
    private Queue queue;

    @GetMapping(value = "queue")
    public ModelAndView queue()
    {
        return new ModelAndView("queue");
    }

    @RequestMapping(value = "/api/v1/care-line/add-patient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertPatient(@RequestBody Person person) throws Exception
    {
        try{
            queue.insert(person);
            return ResponseEntity.ok("Patient (" + person.getName() + ") was added in the care line");
        }catch(Exception e){
            throw new PersonBadRequest("There was some error during the operation!");
        }
    }

    @RequestMapping(value = "/api/v1/care-line/add-priority-patient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertPriorityPatient(@RequestBody Person person) throws Exception
    {
        try{
            queue.insertAtPosition(0, person);
            return ResponseEntity.ok("Patient (" + person.getName() + ") was added in the priority care line");
        }catch(Exception e){
            throw new PersonBadRequest("There was some error during the operation!");
        }
    }

    @RequestMapping(value = "/api/v1/care-line/get-all-patients", method = RequestMethod.GET)
    public List<Person> getPeopleOnCareLine() throws Exception
    {
        try{
            return queue.getAll();
        }catch(Exception e){
            throw new Exception("There is no patients in the care line");
        }
    }

    @RequestMapping(value = "/api/v1/care-line/attend-patient", method = RequestMethod.DELETE)
    public ResponseEntity<String> attendPatient() throws Exception
    {
        try{
            Person person = queue.remove();
            return ResponseEntity.ok("Patient (" + person.getName() + ") was treated");
        }catch(Exception e){
            throw new Exception("There is no patient in the care line");
        }
    }
}
