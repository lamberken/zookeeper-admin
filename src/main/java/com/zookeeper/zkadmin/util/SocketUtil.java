/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zookeeper.zkadmin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.TreeSet;

public class SocketUtil {
    private static final Logger logger = LoggerFactory.getLogger("SYSTEM_LOGGER");

    public static String getRespByCMD(String host, int port, String cmd) {
        String respContent = "";
        Socket s = null;
        try {
            byte[] reqBytes = new byte[4];
            ByteBuffer req = ByteBuffer.wrap(reqBytes);
            req.putInt(ByteBuffer.wrap(cmd.getBytes()).getInt());
            s = new Socket();
            s.setSoLinger(false, 10);
            s.setSoTimeout(15 * 1000);
            s.connect(new InetSocketAddress(host, port));
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            os.write(reqBytes);
            os.flush();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int read;
            while ((read = is.read()) != -1) {
                baos.write(read);
            }
            respContent = new String(baos.toByteArray());

        } catch (Exception e) {
            String msg = String.format("%s:%s 出现异常", host, port);
            logger.error(msg, e);
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (Exception e) {
                    logger.error("Unexpected exception", e);
                }
            }
        }
        return respContent;
    }

    public static void main(String[] args) {

        TreeSet ts = new TreeSet();
        ts.add("1");
        ts.add("2");
        ts.add("3");

        System.out.println(ts);


    }

}































