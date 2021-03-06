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

public class KeystoreEntryInfo {
	private String aliasName;
	private String aliasPass;
	// keyAlgorithm could be one of: DSA, RSA, or AES
	private String keyalg;
	private int keysize;
	private CertificateInfo certificateInfo;
	
	public KeystoreEntryInfo() {
		
	}
	
	public KeystoreEntryInfo(String aliasName, String aliasPass, String keyalg, int keysize, int validity, CertificateInfo certificateInfo) {
		this.aliasName = aliasName;
		this.aliasPass = aliasPass;
		this.keyalg = keyalg;
		this.keysize = keysize;
		this.certificateInfo = certificateInfo;
	}
	
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getAliasPass() {
		return aliasPass;
	}
	public void setAliasPass(String aliasPass) {
		this.aliasPass = aliasPass;
	}
	
	public String getKeyalg() {
		return keyalg;
	}
	public void setKeyalg(String keyalg) {
		this.keyalg = keyalg;
	}

	public int getKeysize() {
		return keysize;
	}

	public void setKeysize(int keysize) {
		this.keysize = keysize;
	}

	public CertificateInfo getCertificateInfo() {
		return certificateInfo;
	}

	public void setCertificateInfo(CertificateInfo certificateInfo) {
		this.certificateInfo = certificateInfo;
	}
}
