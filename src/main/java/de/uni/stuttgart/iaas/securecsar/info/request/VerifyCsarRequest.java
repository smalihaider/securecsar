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

public class VerifyCsarRequest {
	private byte[] csar;
	private String sigfile;
	
	public byte[] getCsar() {
		return csar;
	}
	public void setCsar(byte[] csar) {
		this.csar = csar;
	}
	public String getSigfile() {
		return sigfile;
	}
	public void setSigfile(String sigfile) {
		this.sigfile = sigfile;
	}
}
