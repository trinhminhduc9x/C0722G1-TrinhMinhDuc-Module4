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


    @GetMapping("/listContractDetail")
    public ResponseEntity<List<ContractDetail>> showListContractDetail() {
        List<ContractDetail> contractDetailList = iContractDetailService.findListAll();
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }


    @GetMapping("/listContractDetail/{id}")
    public ResponseEntity<List<AttachFacility>> ListattachFacilityByContractId(@PathVariable Integer id) {
        List<AttachFacility> attachFacilityList = iContractDetailService.findListattachFacilityByContractId(id);
        if (attachFacilityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }


    @PostMapping("/{id}/ContractDetail")
    public ResponseEntity createContractDetailId(@PathVariable Integer id,@RequestBody ContractDetail contractDetail) {
        contractDetail.setContract(iContractService.findById(id));
        iContractDetailService.save(contractDetail);
        if (contractDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetail, HttpStatus.CREATED);
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
