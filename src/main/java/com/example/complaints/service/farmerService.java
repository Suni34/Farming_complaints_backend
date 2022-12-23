package com.example.complaints.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.complaints.exceptions.ComplaintNotFoundException;
import com.example.complaints.model.FarmerComplaints;
import com.example.complaints.repository.farmerRepo;

@Service
public class farmerService {

    @Autowired
    private farmerRepo farmerRepository;
    
    public FarmerComplaints addComlaints(FarmerComplaints complaints) {
      
        return farmerRepository.save(complaints);

   }

   public List<FarmerComplaints> getAllComplaints() {
        // TODO Auto-generated method stub
        return farmerRepository.findAll();
    }
   
    public FarmerComplaints updateComplaints(FarmerComplaints complaints) throws ComplaintNotFoundException {
        Optional<FarmerComplaints> optionalUser =  farmerRepository.findById(complaints.getId());
        if(!(optionalUser.isPresent())) {
            throw new ComplaintNotFoundException("This complaint does not exists..!! Please enter correct details");
        }
        return farmerRepository.save(complaints);



   }
   public Map<String, Boolean> deleteComplaints(Long id) throws ComplaintNotFoundException {
        
        FarmerComplaints complaints = farmerRepository.findById(id)
                .orElseThrow(() -> new ComplaintNotFoundException("Complaint not found :: " +id));
        
        farmerRepository.delete(complaints);
         Map<String, Boolean> response = new HashMap<>();
         response.put("Complaint deleted", Boolean.TRUE);
         return response;
        
    }

public FarmerComplaints getComplaintById(Long id)throws ComplaintNotFoundException {
	// TODO Auto-generated method stub
	Optional<FarmerComplaints> optionalComplaint=farmerRepository.findById(id);
	if(!(optionalComplaint.isPresent())) {
		throw new ComplaintNotFoundException("The Complaint with id: "+id+" does not exist...!!Please enter correct details ");
	}
	return optionalComplaint.get();
}

}
