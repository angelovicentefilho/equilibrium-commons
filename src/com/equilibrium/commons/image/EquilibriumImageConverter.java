package com.equilibrium.commons.image;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;

import org.w3c.dom.Document;

import com.equilibrium.commons.image.imagemap.HtmlImageMap;
import com.equilibrium.commons.image.imagemap.HtmlImageMapImpl;
import com.equilibrium.commons.image.parser.HtmlParser;
import com.equilibrium.commons.image.parser.HtmlParserImpl;
import com.equilibrium.commons.image.pdf.PdfRenderer;
import com.equilibrium.commons.image.pdf.PdfRendererImpl;
import com.equilibrium.commons.image.render.ImageRenderer;
import com.equilibrium.commons.image.render.ImageRendererImpl;

public class EquilibriumImageConverter {
	private HtmlParser parser = new HtmlParserImpl();
	private HtmlImageMap htmlImageMap;
	private ImageRenderer imageRenderer;
	private PdfRenderer pdfRenderer;

	public HtmlParser getParser() {
		return parser;
	}

	public HtmlImageMap getHtmlImageMap() {
		if (htmlImageMap == null) {
			htmlImageMap = new HtmlImageMapImpl(getImageRenderer());
		}
		return htmlImageMap;
	}

	public PdfRenderer getPdfRenderer() {
		if (pdfRenderer == null) {
			pdfRenderer = new PdfRendererImpl(parser);
		}
		return pdfRenderer;
	}

	public ImageRenderer getImageRenderer() {
		if (imageRenderer == null) {
			imageRenderer = new ImageRendererImpl(parser);
		}
		return imageRenderer;
	}

	public static EquilibriumImageConverter fromDocument(Document document) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().setDocument(document);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromHtml(String html) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().loadHtml(html);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromURL(URL url) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().load(url);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromURI(URI uri) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().load(uri);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromFile(File file) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().load(file);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromReader(Reader reader) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().load(reader);
		return EquilibriumImageConverter;
	}

	public static EquilibriumImageConverter fromInputStream(InputStream inputStream) {
		final EquilibriumImageConverter EquilibriumImageConverter = new EquilibriumImageConverter();
		EquilibriumImageConverter.getParser().load(inputStream);
		return EquilibriumImageConverter;
	}
}
