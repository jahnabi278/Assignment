package com.pms.result;

import java.util.List;

import com.pms.beans.PensionerDetails;

public class PensionersResult extends Result {
	List<PensionerDetails> listOfPensioners;

	public List<PensionerDetails> getListOfPensioners() {
		return listOfPensioners;
	}

	public void setListOfPensioners(List<PensionerDetails> listOfPensioners) {
		this.listOfPensioners = listOfPensioners;
	}

}
