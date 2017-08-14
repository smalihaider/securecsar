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
package de.uni.stuttgart.iaas.securecsar.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	
	public String storeFileAndGetDownloadLink(String fileName, byte[] data) throws Exception {
		String downloadFilesContainer = ConfigUtil.getInstance().getProperty("download.files.container");
		SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date now = new Date();
	    String timestampString = timestampFormat.format(now);
		String filePath = downloadFilesContainer + File.separator + timestampString + "_" + fileName;
		FileUtils.writeByteArrayToFile(new File(filePath), data);
		return "/downloadfile/" + timestampString + "_" + fileName;
	}
}
