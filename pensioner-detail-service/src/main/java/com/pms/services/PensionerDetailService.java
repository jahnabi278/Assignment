package com.pms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.beans.PensionerDetails;
import com.pms.result.PensionerResult;
import com.pms.result.PensionersResult;
import com.pms.result.Result;
import com.pms.util.ErrorMessages;

@Service
public class PensionerDetailService {
	@Autowired
	PensionerDetailRepository pensionerDetailIORepo;

	@Transactional(rollbackOn = Exception.class)
	public Result savePensioner(PensionerDetails pensionerDetails) {
		pensionerDetailIORepo.save(pensionerDetails);
		return new Result(200, ErrorMessages.SAVE_SUCCESSFUL);
	}

	public PensionersResult getPensioners() {
		PensionersResult result = new PensionersResult();
		List<PensionerDetails> ls = pensionerDetailIORepo.findAll();
		result.setListOfPensioners(ls);
		result.setErrorCode(200);
		result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
		return result;
	}

	public PensionerResult getById(String id) {
		PensionerResult result = new PensionerResult();
		Optional<PensionerDetails> pensioner = pensionerDetailIORepo.findById(id);
		PensionerDetails rs = pensioner.get();
		result.setPensionerDetail(rs);
		result.setErrorCode(200);
		result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
		return result;
	}

	public Result deleteById(String id) {
		pensionerDetailIORepo.deleteById(id);
		return new Result(200, ErrorMessages.DELETE_SUCCESSFUL);
	}

	public Result deleteAllPensioners() {
		pensionerDetailIORepo.deleteAll();
		return new Result(200, ErrorMessages.DELETE_SUCCESSFUL);
	}

}
