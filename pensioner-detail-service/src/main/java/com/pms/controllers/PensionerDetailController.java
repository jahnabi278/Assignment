package com.pms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pms.beans.PensionerDetails;
import com.pms.result.PensionerResult;
import com.pms.result.PensionersResult;
import com.pms.result.Result;
import com.pms.services.PensionerDetailService;

@RestController
@RequestMapping("/pensioner")
public class PensionerDetailController {
	@Autowired
	PensionerDetailService pensionerDetailService;

	@PostMapping(value = "/create")
	public Result create(@Valid @RequestBody PensionerDetails pensionerDetails) {
		return pensionerDetailService.savePensioner(pensionerDetails);
	}

	@GetMapping
	public PensionersResult getPensioners() {
		return pensionerDetailService.getPensioners();
	}

	@GetMapping({ "/{id}" })
	public PensionerResult getPensionersById(@PathVariable String id) {
		return pensionerDetailService.getById(id);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void handleNonExistantUser() {

	}

	@DeleteMapping({ "/{id}" })
	public Result deletePensionersById(@PathVariable String id) {
		return pensionerDetailService.deleteById(id);
	}

	@DeleteMapping({ "/deleteAll" })
	public Result deleteAll() {
		return pensionerDetailService.deleteAllPensioners();
	}
}
