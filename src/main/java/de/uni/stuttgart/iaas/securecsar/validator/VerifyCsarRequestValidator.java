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
package de.uni.stuttgart.iaas.securecsar.validator;

import de.uni.stuttgart.iaas.securecsar.info.Constant;
import de.uni.stuttgart.iaas.securecsar.info.request.VerifyCsarRequest;
import de.uni.stuttgart.iaas.securecsar.info.response.MessageType;
import de.uni.stuttgart.iaas.securecsar.info.response.ResponseMessage;
import de.uni.stuttgart.iaas.securecsar.info.response.VerifyCsarResponse;
import de.uni.stuttgart.iaas.securecsar.util.StringUtil;

public class VerifyCsarRequestValidator {

	// This function validates VerifyCsarRequest.
	// Incase validation fails, it sets respective message in
	// VerifyCsarResponse object and returns false.
	public boolean validate(VerifyCsarRequest request, VerifyCsarResponse response) throws Exception {
		if (request.getCsar() == null) {
			response.addResponseMsg(new ResponseMessage(MessageType.ERROR,Constant.VALIDATION_MSG_PROVIDE_CSAR));
			return false;
		}
		
		if (StringUtil.isEmpty(request.getSigfile())) {
			response.addResponseMsg(new ResponseMessage(MessageType.ERROR,Constant.VALIDATION_MSG_PROVIDE_SIG_NAME));
			return false;
		}
		
		return true;
	}
}
