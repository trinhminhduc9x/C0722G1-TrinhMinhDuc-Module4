package householdmanagement.controller;

import householdmanagement.model.Member;
import householdmanagement.service.IHouseholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    IHouseholService iHouseholService;

    @GetMapping("/listHousehol/{id}")
    public ResponseEntity<List<Member>> listId(@PathVariable Integer id) {
        List<Member> memberList = iHouseholService.findMemberById(id);
        if (memberList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }
}
