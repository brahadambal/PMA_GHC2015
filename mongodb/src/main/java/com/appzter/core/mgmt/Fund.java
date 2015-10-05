package com.appzter.core.mgmt;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fund {
	
	private Double fund;

	public Fund(Double fund) {
		this.fund = fund;
	}

	public Double getFund() {
		return fund;
	}

	public void setFund(final Double fund) {
		this.fund = fund;
	}
	
	@Override
	public String toString() {
		return "Fund [fundAmount=" + fund +"]";
	}
	
}
