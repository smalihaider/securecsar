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
package de.uni.stuttgart.iaas.securecsar.processor;

import java.io.ByteArrayOutputStream;
import java.security.KeyStore;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import de.uni.stuttgart.iaas.securecsar.info.KeystoreInfo;

public class ResponseProcessor {
	
	public byte[] packCsarWithKeystore(KeyStore keystore, KeystoreInfo keystoreInfo, String csarName, byte[] csarBytes) throws Exception{
		ByteArrayOutputStream bosForKeystore = null;
		ByteArrayOutputStream bosForZip = null;
		ZipArchiveOutputStream zipArhchiveOs = null;
		byte[] packedZip = null;
		
		try {
			bosForZip = new ByteArrayOutputStream();
			bosForKeystore = new ByteArrayOutputStream();
			zipArhchiveOs = new ZipArchiveOutputStream(bosForZip);
			
			// adding csar
			ZipArchiveEntry csarEntry = new ZipArchiveEntry(csarName);
			zipArhchiveOs.putArchiveEntry(csarEntry);
			zipArhchiveOs.write(csarBytes);
			zipArhchiveOs.closeArchiveEntry();
			
			// adding keystore
			keystore.store(bosForKeystore, keystoreInfo.getKeystorePass().toCharArray());
			ZipArchiveEntry keystoreEntry = new ZipArchiveEntry(keystoreInfo.getKeystoreName());
			zipArhchiveOs.putArchiveEntry(keystoreEntry);
			bosForKeystore.close();
			zipArhchiveOs.write(bosForKeystore.toByteArray());
			zipArhchiveOs.closeArchiveEntry();
			
			// closing streams before outputting bytes
			zipArhchiveOs.close();
			bosForZip.close();
			packedZip = bosForZip.toByteArray();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (bosForKeystore != null) {
				bosForKeystore.close();
			}
			
			if (bosForZip != null) {
				bosForZip.close();
			}

			if (zipArhchiveOs != null) {
				zipArhchiveOs.close();
			}
		}
		
		return packedZip;
	} 
}
