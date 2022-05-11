package com.pms.result;

import com.pms.beans.PensionerDetails;

public class PensionerResult extends Result {
	PensionerDetails pensionerDetails;

	public PensionerDetails getPensionerDetails() {
		return pensionerDetails;
	}

	public void setPensionerDetail(PensionerDetails pensionerDetails) {
		this.pensionerDetails = pensionerDetails;
	}
}
