package org.java.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import java.io.IOException;

class HTML2XML {
	public static void main(String args[]) throws JDOMException {
		InputStream isInHtml = null;
		URL url = null;
		URLConnection connection = null;
		DataInputStream disInHtml = null;
		FileOutputStream fosOutHtml = null;
		FileWriter fwOutXml = null;
		FileReader frInHtml = null;
		BufferedWriter bwOutXml = null;
		BufferedReader brInHtml = null;
		try {
			// url = new URL("www.climb.co.jp");
			// connection = url.openConnection();
			// isInHtml = connection.getInputStream();

			frInHtml = new FileReader("C:\\Users\\pankajk6\\Documents\\CoE\\CoE\\Reports\\Reports(31 Aug 2018 11 27 09 AM IST)\\mainReport.html");
			brInHtml = new BufferedReader(frInHtml);
			SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
			org.jdom.Document jdomDocument = saxBuilder.build(brInHtml);

			XMLOutputter outputter = new XMLOutputter();
			org.jdom.output.Format newFormat = outputter.getFormat();
			String encoding = "iso-8859-2";
			newFormat.setEncoding(encoding);
			outputter.setFormat(newFormat);

			try {
				outputter.output(jdomDocument, System.out);
				fwOutXml = new FileWriter("C:\\Users\\pankajk6\\Desktop\\Second.xml");
				bwOutXml = new BufferedWriter(fwOutXml);
				outputter.output(jdomDocument, bwOutXml);
				System.out.flush();
			} catch (IOException e) {
			}

		} catch (IOException e) {
		} finally {
			System.out.flush();
			try {
				isInHtml.close();
				disInHtml.close();
				fosOutHtml.flush();
				fosOutHtml.getFD().sync();
				fosOutHtml.close();
				fwOutXml.flush();
				fwOutXml.close();
				bwOutXml.close();
			} catch (Exception w) {

			}
		}
	}
}