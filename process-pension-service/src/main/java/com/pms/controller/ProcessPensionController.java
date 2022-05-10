package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.beans.PensionAmount;
import com.pms.beans.ProcessPensionInput;
import com.pms.delegate.ProcessPensionDelegate;

@RestController
@RequestMapping("/processpension")
public class ProcessPensionController {
	@Autowired
	ProcessPensionDelegate pensionServiceDelegate;

	@PostMapping("/pensionDetail")
	public PensionAmount getPensionDetail(@RequestBody ProcessPensionInput input) throws Exception {
		return pensionServiceDelegate.callPensionerServiceAndGetData(input);
	}
}