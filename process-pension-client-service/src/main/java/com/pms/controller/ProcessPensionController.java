package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pms.beans.BankType;
import com.pms.beans.PensionAmount;
import com.pms.beans.PensionType;
import com.pms.beans.PensionerDetails;
import com.pms.beans.ProcessPensionInput;
import com.pms.result.PensionerResult;

@RestController
public class ProcessPensionController {
	@Autowired
	RestTemplate restTemplate;

	@PostMapping
	public PensionAmount callPensionerServiceAndGetData(@RequestBody ProcessPensionInput input) {
		ResponseEntity<PensionerResult> result = restTemplate.postForEntity(
				"http://localhost:8098/pensioner/" + input.getAdhar_number(), input, PensionerResult.class);
		PensionerDetails pensionerDetail = result.getBody().getPensionerDetails();
		PensionAmount p_amount = new PensionAmount();
		float amount = calculatePensionAmount(pensionerDetail.getPensionType(), pensionerDetail.getSalaryEarned(),
				pensionerDetail.getAllowances());
		float bankServiceCharge = calculateBankServiceCharge(pensionerDetail.getBankDetails().get(0).getBanktype());
		p_amount.setPension_amount(amount);
		p_amount.setBankServiceCharge(bankServiceCharge);
		return p_amount;
	}

	private float calculateBankServiceCharge(BankType banktype) {
		float serviceCharge = 0.0f;
		if (banktype.equals("PUBLIC")) {
			serviceCharge = 500.0f;
		} else if (banktype.equals("PRIVATE")) {
			serviceCharge = 550.0f;
		}
		return serviceCharge;
	}

	private float calculatePensionAmount(PensionType pensionType, float salaryEarned, float allowances) {
		float pensionAmount = 0.0f;
		if (pensionType.equals("SELF")) {
			pensionAmount = (float) (0.8 * salaryEarned + allowances);
		} else if (pensionType.equals("FAMILY")) {
			pensionAmount = (float) (0.5 * salaryEarned + allowances);
		}
		return pensionAmount;
	}

}
