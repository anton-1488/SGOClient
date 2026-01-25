package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class AvailableNagatiateTransport implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("transport")
    private String transport;

    @SerializedName("transferFormats")
    private List<String> transferFormats;

    public AvailableNagatiateTransport(String transport, List<String> transferFormats) {
        this.transport = transport;
        this.transferFormats = transferFormats;
    }

    public AvailableNagatiateTransport() {
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public List<String> getTransferFormats() {
        return transferFormats;
    }

    public void setTransferFormats(List<String> transferFormats) {
        this.transferFormats = transferFormats;
    }

    @Override
    public String toString() {
        return "AvailableNagatiateTransport{" +
                "transport='" + transport + '\'' +
                ", transferFormats=" + transferFormats +
                '}';
    }
}