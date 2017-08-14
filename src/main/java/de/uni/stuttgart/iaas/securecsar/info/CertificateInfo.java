/**
 * Copyright (c) 2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Muhammad Ali Haider - initial implementation
 */
package de.uni.stuttgart.iaas.securecsar.info;

public class CertificateInfo {
	private String firstAndLastName;
	private String organizationalUnit;
	private String organization;
	private String city;
	private String state;
	private String countryCode;
	// validity in days
	private int validity;
	// sigalg specifies the algorithm that should be used to sign the certificate
	private String sigalg;
	
	public CertificateInfo() {
	}

	public String getFirstAndLastName() {
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
	}

	public String getOrganizationalUnit() {
		return organizationalUnit;
	}

	public void setOrganizationalUnit(String organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getSigalg() {
		return sigalg;
	}

	public void setSigalg(String sigalg) {
		this.sigalg = sigalg;
	}
}
