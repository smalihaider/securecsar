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

public class SignCsarRequest {
	private byte[] csar;
	private String csarName;
	private KeystoreInfo keystoreInfo;
	private String sigalg;
	private String digestalg;
	private String sigfile;
	
	public SignCsarRequest() {
		
	}

	public KeystoreInfo getKeystoreInfo() {
		return keystoreInfo;
	}

	public void setKeystoreInfo(KeystoreInfo keystoreInfo) {
		this.keystoreInfo = keystoreInfo;
	}
	
	public String getSigalg() {
		return sigalg;
	}

	public void setSigalg(String sigalg) {
		this.sigalg = sigalg;
	}

	public String getDigestalg() {
		return digestalg;
	}

	public void setDigestalg(String digestalg) {
		this.digestalg = digestalg;
	}

	public String getSigfile() {
		return sigfile;
	}

	public void setSigfile(String sigfile) {
		this.sigfile = sigfile;
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
}
