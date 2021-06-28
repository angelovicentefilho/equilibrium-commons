package com.equilibrium.commons.image.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.equilibrium.commons.image.exception.RenderException;
import com.equilibrium.commons.image.parser.DocumentHolder;
import com.lowagie.text.DocumentException;

public class PdfRendererImpl implements PdfRenderer {
	private DocumentHolder documentHolder;

	public PdfRendererImpl(DocumentHolder documentHolder) {
		this.documentHolder = documentHolder;
	}

	@Override
	public void saveToPDF(OutputStream outputStream, boolean closeStream) {
		try {
			ITextRenderer renderer = new ITextRenderer();
			final Document document = documentHolder.getDocument();
			renderer.setDocument(document, document.getDocumentURI());
			renderer.layout();
			renderer.createPDF(outputStream);
		} catch (DocumentException e) {
			throw new RenderException("DocumentException while rendering PDF", e);
		} finally {
			if (closeStream) {
				try {
					outputStream.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	@Override
	public void saveToPDF(File file) {
		try {
			saveToPDF(new FileOutputStream(file), true);
		} catch (FileNotFoundException e) {
			throw new RenderException(String.format("File not found %s", file.getAbsolutePath()), e);
		}
	}

	@Override
	public void saveToPDF(String file) {
		saveToPDF(new File(file));
	}
}