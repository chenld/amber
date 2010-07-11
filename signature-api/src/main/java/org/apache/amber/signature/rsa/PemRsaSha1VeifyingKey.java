/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.amber.signature.rsa;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.amber.signature.SignatureException;
import org.apache.amber.signature.SigningKey;

/**
 * 
 *
 * @version $Id$
 */
public final class PemRsaSha1VeifyingKey
        extends AbstractRsaSha1Key
        implements SigningKey {

    public PemRsaSha1VeifyingKey(File certificateFileLocation)
            throws SignatureException {
        super(certificateFileLocation);
    }

    public PemRsaSha1VeifyingKey(String certificateClasspathLocation)
            throws SignatureException {
        super(certificateClasspathLocation);
    }

    public PemRsaSha1VeifyingKey(URL certificateURL) throws SignatureException {
        super(certificateURL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected byte[] readCertificate(InputStream input) throws Exception {
        PemCertificateParser pemCertificateParser = new PemCertificateParser(input);
        return pemCertificateParser.parsePublicCertificate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return null;
    }

}