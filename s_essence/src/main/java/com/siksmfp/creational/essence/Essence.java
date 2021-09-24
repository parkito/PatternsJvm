package com.siksmfp.creational.essence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Essence {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https", "www.yandex.ru", 443, "/index.html"); //builder style can be used here
        URLConnection con = url.openConnection(); //essence(essential functionality). Can be several.
        con.setReadTimeout(200);
        try (InputStream in = con.getInputStream();
             OutputStream out = new FileOutputStream("Essence-Carlson.pdf")) {
            in.transferTo(out);
        }
    }

    /*
     *  SMTPAppender smtp = new SMTPAppender();
     * //setting parameters
     *  smtp.setLayout(new HTMLLayout());
     *  smtp.setTo(line_man ager);
     *  smtp.setSubject("Serious Error in Production System");
     *  smtp.setFrom(programmer);
     *  smtp.setSMTPHost(host);
     *  smtp.setSMTPPort(port);
     *  smtp.setSMTPPassword(password);
     *  smtp.activateOptions(); //start real work here
     */
}
