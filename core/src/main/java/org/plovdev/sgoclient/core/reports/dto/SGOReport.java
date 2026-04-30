package org.plovdev.sgoclient.core.reports.dto;

import com.google.gson.annotations.SerializedName;
import org.plovdev.sgoclient.core.reports.SGOReportOutputType;
import org.plovdev.sgoclient.core.reports.SGOReportType;

import java.io.Serial;
import java.io.Serializable;

public class SGOReport implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("reportType")
    private SGOReportType reportType;

    @SerializedName("outputType")
    private SGOReportOutputType outputType;

    private transient byte[] reportBody;

    public SGOReport(SGOReportType reportType, SGOReportOutputType outputType, byte[] reportBody) {
        this.reportType = reportType;
        this.outputType = outputType;
        this.reportBody = reportBody;
    }

    public SGOReport(byte[] reportBody) {
        this.reportBody = reportBody;
    }

    public SGOReport() {
    }

    public SGOReportType getReportType() {
        return reportType;
    }

    public void setReportType(SGOReportType reportType) {
        this.reportType = reportType;
    }

    public SGOReportOutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(SGOReportOutputType outputType) {
        this.outputType = outputType;
    }

    public byte[] getReportBody() {
        return reportBody;
    }

    public void setReportBody(byte[] reportBody) {
        this.reportBody = reportBody;
    }

    @Override
    public String toString() {
        return "SGOReport{" +
                "reportType=" + reportType +
                ", outputType=" + outputType +
                ", report size=" + reportBody.length +
                '}';
    }
}