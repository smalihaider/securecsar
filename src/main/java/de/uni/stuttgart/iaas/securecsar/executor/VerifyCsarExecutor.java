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
package de.uni.stuttgart.iaas.securecsar.executor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Manifest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.uni.stuttgart.iaas.securecsar.info.Artifact;
import de.uni.stuttgart.iaas.securecsar.info.Constant;
import de.uni.stuttgart.iaas.securecsar.info.Csar;
import de.uni.stuttgart.iaas.securecsar.info.SignatureFileInfo;
import de.uni.stuttgart.iaas.securecsar.info.request.VerifyCsarRequest;
import de.uni.stuttgart.iaas.securecsar.info.response.MessageType;
import de.uni.stuttgart.iaas.securecsar.info.response.ResponseMessage;
import de.uni.stuttgart.iaas.securecsar.info.response.StatusCode;
import de.uni.stuttgart.iaas.securecsar.info.response.VerifyCsarResponse;
import de.uni.stuttgart.iaas.securecsar.processor.CsarProcessor;
import de.uni.stuttgart.iaas.securecsar.processor.SecurityProcessor;
import de.uni.stuttgart.iaas.securecsar.validator.VerifyCsarRequestValidator;

public class VerifyCsarExecutor {
	private static final Logger LOGGER = LogManager.getLogger();

	public VerifyCsarResponse execute(VerifyCsarRequest request) {
		VerifyCsarResponse response = new VerifyCsarResponse();
		response.setStatusCode(StatusCode.SUCCESS);
		ByteArrayInputStream manifestInputstream = null;
		
		try {
			VerifyCsarRequestValidator validator = new VerifyCsarRequestValidator();
			
			if (validator.validate(request, response)) {
				SecurityProcessor securityProcessor = new SecurityProcessor();
				// Creating csar object from .casr file in request
				Csar csar = new Csar(null, request.getCsar(), null, null, true);
				// Checking existance of signature file and signature block
				CsarProcessor csarProcessor = new CsarProcessor();
				ArrayList<Artifact> sigArtifacts = csarProcessor.getArtifactContainsName(csar, request.getSigfile());
				
				if (sigArtifacts.size() != 2) {
					// .SF file or signature block file or both are missing in CSAR
					response.addResponseMsg(new ResponseMessage(MessageType.ERROR, Constant.VERIFICATION_ERROR_NO_SIGNATURE_FOUND + request.getSigfile()));
				} else {
					Artifact sigFileArtifact = null;
					Artifact sigBlockArtifact = null;
					
					
					for (Artifact sigArtifact: sigArtifacts) {
						if (sigArtifact.getName().endsWith("SF")) {
							sigFileArtifact = sigArtifact;
						} else {
							sigBlockArtifact = sigArtifact;
						}
					}
					
					SignatureFileInfo sigFileInfo = new SignatureFileInfo(sigFileArtifact.getName(), sigFileArtifact.getContent());
					ArrayList<Artifact> manifestArtifacts = csarProcessor.getArtifactContainsName(csar, Constant.MENIFEST_FILE);
					
					if (manifestArtifacts.size() == 1) {
						manifestInputstream = new ByteArrayInputStream(manifestArtifacts.get(0).getContent());
						Manifest existingManifest = new Manifest(manifestInputstream);
						manifestInputstream.close();
						boolean verificationPass = securityProcessor.verifyCsar(csar, existingManifest, sigFileInfo, sigBlockArtifact.getContent(), response);
						
						if (!verificationPass) {
							response.setStatusCode(StatusCode.ERROR);
						}
					} else {
						response.addResponseMsg(new ResponseMessage(MessageType.ERROR, Constant.VERIFICATION_ERROR_NO_MANIFEST_IN_CSAR));
					}
				}
			} else {
				response.setStatusCode(StatusCode.ERROR);
			}
		} catch (Exception ex) {
			LOGGER.log(Level.ERROR, ex.getMessage(), ex);
			response = new VerifyCsarResponse();
			response.setStatusCode(StatusCode.ERROR);
			response.addResponseMsg(new ResponseMessage(MessageType.ERROR, Constant.RESPONSE_ERROR_MSG_UNEXPECTED_ERROR));
		} finally {
			if (manifestInputstream != null) {
				try {
					manifestInputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					LOGGER.log(Level.ERROR, e.getMessage(), e);
				}
			}
		}

		return response;
	}
}
