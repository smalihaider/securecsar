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

public class KeystoreInfo {
	private String keystoreName;
	private String keystorePass;
	private byte[] jksFile;
	private KeystoreEntryInfo entry;
	
	public KeystoreInfo() {
	} 
	
	public KeystoreInfo(String keystoreName, String keystorePass, byte[] jksFile, KeystoreEntryInfo entry) {
		this.keystoreName = keystoreName;
		this.keystorePass = keystorePass;
		this.jksFile = jksFile;
		this.entry = entry;
	}

	public String getKeystoreName() {
		return keystoreName;
	}

	public void setKeystoreName(String keystoreName) {
		this.keystoreName = keystoreName;
	}

	public String getKeystorePass() {
		return keystorePass;
	}

	public void setKeystorePass(String keystorePass) {
		this.keystorePass = keystorePass;
	}

	public byte[] getJksFile() {
		return jksFile;
	}

	public void setJksFile(byte[] jksFile) {
		this.jksFile = jksFile;
	}

	public KeystoreEntryInfo getEntry() {
		return entry;
	}

	public void setEntry(KeystoreEntryInfo entry) {
		this.entry = entry;
	}
}
