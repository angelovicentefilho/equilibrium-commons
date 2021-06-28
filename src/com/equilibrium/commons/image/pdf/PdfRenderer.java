package com.equilibrium.commons.image.pdf;

import java.io.File;
import java.io.OutputStream;

public interface PdfRenderer {
	void saveToPDF(OutputStream outputStream, boolean closeStream);

	void saveToPDF(File file);

	void saveToPDF(String file);
}