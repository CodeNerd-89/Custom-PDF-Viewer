package com.tahmid.l2t2allpdf;

public class PdfModel {

    private String title;
    private String pdfName;

    public PdfModel(String title, String pdfName) {
        this.title = title;
        this.pdfName = pdfName;
    }

    public String getTitle() {
        return title;
    }

    public String getPdfName() {
        return pdfName;
    }
}
