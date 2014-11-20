/**
 * YIXUN_1.5_EE
 */
package com.kingray.servlet;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-29 上午10:16:01
 */

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream buffer = null;
    private ServletOutputStream out = null;
    private PrintWriter writer = null;
    private HttpServletResponse response;

    public ResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        buffer = new ByteArrayOutputStream();// 真正存储数据的流
        out = new WapperedOutputStream(buffer);
        writer = new PrintWriter(new OutputStreamWriter(buffer, this.getCharacterEncoding()));
        this.response = response;
    }

    // 重载父类获取outputstream的方法
    public ServletOutputStream getOutputStream() throws IOException {
        return out;
    }

    // 重载父类获取writer的方法
    public PrintWriter getWriter() throws UnsupportedEncodingException {
        //		if (usingOutputStream) {
        //            throw new IllegalStateException(
        //                lStrings.getString("err.ise.getWriter"));
        //        }
        //
        //        if (writer == null) {
        //            OutputStreamWriter w = new OutputStreamWriter(
        //                noBody, getCharacterEncoding());
        //            writer = new PrintWriter(w);
        //        }

        return writer;
    }

    // 重载父类获取flushBuffer的方法
    public void flushBuffer() throws IOException {
        if (out != null) {
            out.flush();
        }
        if (writer != null) {
            writer.flush();
        }
    }

    public void reset() {
        buffer.reset();
    }

    public byte[] getResponseData() throws IOException {
        // 将out、writer中的数据强制输出到WapperedResponse的buffer里面，否则取不到数据
        flushBuffer();
        return buffer.toByteArray();
    }

    //内部类，对ServletOutputStream进行包装
    private class WapperedOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream bos = null;

        public WapperedOutputStream(ByteArrayOutputStream stream) throws IOException {
            bos = stream;
        }

        public void write(int b) throws IOException {
            bos.write(b);
        }

    }
}
