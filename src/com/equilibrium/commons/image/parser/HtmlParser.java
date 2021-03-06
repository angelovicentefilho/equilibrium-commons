package com.equilibrium.commons.image.parser;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public interface HtmlParser extends DocumentHolder {

	DOMParser getDomParser();

	void setDomParser(DOMParser domParser);

	void setDocument(Document document);

	void load(URL url);

	void load(URI uri);

	void load(File file);

	void load(Reader reader);

	void load(InputStream inputStream);

	void loadHtml(String html);

	void loadURI(String uri);
}