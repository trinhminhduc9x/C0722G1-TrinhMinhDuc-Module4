package casestudy.controller;

import casestudy.model.contract.AttachFacility;
import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.service.contract.IAttachFacilityService;
import casestudy.service.contract.IContractDetailService;
import casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class restController {
    @Autowired
    IAttachFacilityService iAttachFacilityService;

    @Autowired
    IContractDetailService iContractDetailService;

    @Autowired
    IContractService iContractService;

    @GetMapping("/listAttachFacility")
    public ResponseEntity<List<AttachFacility>> showListAttachFacility() {
        List<AttachFacility> facilityList = iAttachFacilityService.findListAll();
        if (facilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }

    @GetMapping("/listContractDetail/{id}")
    public ResponseEntity<List<ContractDetail>> listContractDetailByContractId(@PathVariable Integer id) {
        List<ContractDetail> contractDetailList = iContractDetailService.findListContracDetailByIdContract(id);
        if (contractDetailList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("/listAttachFacility/{id}")
    public ResponseEntity<List<AttachFacility>> listAttachFacilityByContractId(@PathVariable Integer id) {
        List<AttachFacility> attachFacilityList = iContractDetailService.findListattachFacilityByContractId(id);
        if (attachFacilityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }

    @PostMapping("/createContractDetail")
    public ResponseEntity createContractDetail(@RequestBody ContractDetail contractDetail) {
        iContractDetailService.save(contractDetail);
        if (contractDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetail, HttpStatus.CREATED);
    }
}
