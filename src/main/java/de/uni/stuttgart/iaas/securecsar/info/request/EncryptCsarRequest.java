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
package de.uni.stuttgart.iaas.securecsar.info.request;

import de.uni.stuttgart.iaas.securecsar.info.KeystoreInfo;

public class EncryptCsarRequest {
	private String encryptedBy;
	private String encryptorContact;
	private byte[] csar;
	private String csarName;
	private KeystoreInfo keystoreInfo;
	private String encAlg;
	
	public EncryptCsarRequest () {
		
	}
	
	public byte[] getCsar() {
		return csar;
	}
	public void setCsar(byte[] csar) {
		this.csar = csar;
	}
	public String getCsarName() {
		return csarName;
	}
	public void setCsarName(String csarName) {
		this.csarName = csarName;
	}
	public KeystoreInfo getKeystoreInfo() {
		return keystoreInfo;
	}
	public void setKeystoreInfo(KeystoreInfo keystoreInfo) {
		this.keystoreInfo = keystoreInfo;
	}
	public String getEncAlg() {
		return encAlg;
	}
	public void setEncAlg(String encAlg) {
		this.encAlg = encAlg;
	}
	public String getEncryptedBy() {
		return encryptedBy;
	}
	public void setEncryptedBy(String encryptedBy) {
		this.encryptedBy = encryptedBy;
	}
	public String getEncryptorContact() {
		return encryptorContact;
	}
	public void setEncryptorContact(String encryptorContact) {
		this.encryptorContact = encryptorContact;
	}
}
