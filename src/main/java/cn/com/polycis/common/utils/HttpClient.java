package cn.com.polycis.common.utils;

import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * <p> Date             :2018/1/18 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 *          <p>--------------------------------------------------------------</p>
 *          <p>修改历史</p>
 *          <p>    序号    日期    修改人    修改原因    </p>
 *          <p>    1                                     </p>
 */
public class HttpClient {


    public static String sendHttp(String url, String param, Map<String, String> headers, String method, Integer timeOut) throws Exception {
        method = method == null ? "GET" : method;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        if (!StringUtils.isEmpty(param) && "GET".equalsIgnoreCase(method)) {
            url = url + "?" + param;
        }
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        if (timeOut != null && timeOut > 0) {
            conn.setReadTimeout(timeOut * 1000);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
        httpURLConnection.setRequestMethod(method.toUpperCase());
        for (Map.Entry<String, String> header : headers.entrySet()) {
            httpURLConnection.setRequestProperty(header.getKey(), header.getValue());
        }
        conn.setDoInput(true);
        if (!StringUtils.isEmpty(param) && "POST".equalsIgnoreCase(method)) {
            conn.setDoOutput(true);
            out = new PrintWriter(conn.getOutputStream());

            out.print(param);
            out.flush();
        }

        httpURLConnection.connect();
        in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        return result;
    }

    public static String[] sendHttps(String url, String param, Map<String, String> headers, String method, Integer timeOut) throws Exception {
        method = method == null ? "GET" : method;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        if (!StringUtils.isEmpty(param) && "GET".equalsIgnoreCase(method)) {
            url = url + "?" + param;
        }

        HttpsURLConnection.setDefaultHostnameVerifier(new HttpClient().new NullHostNameVerifier());
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        if (timeOut != null && timeOut > 0) {
            conn.setReadTimeout(timeOut * 1000);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) conn;
        httpsURLConnection.setRequestMethod(method.toUpperCase());
        for (Map.Entry<String, String> header : headers.entrySet()) {
            httpsURLConnection.setRequestProperty(header.getKey(), header.getValue());
        }

        conn.setDoInput(true);
        if (!StringUtils.isEmpty(param) && "POST".equalsIgnoreCase(method)) {
            conn.setDoOutput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
        }

        if (!StringUtils.isEmpty(param) && "PUT".equalsIgnoreCase(method)) {
            ((HttpsURLConnection) conn).setRequestMethod("PUT");
            conn.setDoOutput(true);
            out = new PrintWriter(conn.getOutputStream());

            out.print(param);
            out.flush();
        }

        httpsURLConnection.connect();
        try {
            in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            result = null;
        }
        return new String[]{String.valueOf(httpsURLConnection.getResponseCode()), result};
    }

    public class NullHostNameVerifier implements HostnameVerifier {
        /*
         * (non-Javadoc)
         *
         * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String,
         * javax.net.ssl.SSLSession)
         */
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            // TODO Auto-generated method stub
            return true;
        }
    }

    static TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    }};


}
