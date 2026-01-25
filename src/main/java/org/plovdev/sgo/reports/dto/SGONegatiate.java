package org.plovdev.sgo.reports.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SGONegatiate implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("negotiateVersion")
    private int negotiateVersion;

    @SerializedName("connectionId")
    private String connectionId;

    @SerializedName("connectionToken")
    private String connectionToken;

    @SerializedName("availableTransports")
    private List<AvailableNagatiateTransport> transports;

    public SGONegatiate(int negotiateVersion, String connectionId, String connectionToken, List<AvailableNagatiateTransport> transports) {
        this.negotiateVersion = negotiateVersion;
        this.connectionId = connectionId;
        this.connectionToken = connectionToken;
        this.transports = transports;
    }

    public SGONegatiate() {
    }

    public int getNegotiateVersion() {
        return negotiateVersion;
    }

    public void setNegotiateVersion(int negotiateVersion) {
        this.negotiateVersion = negotiateVersion;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionToken() {
        return connectionToken;
    }

    public void setConnectionToken(String connectionToken) {
        this.connectionToken = connectionToken;
    }

    public List<AvailableNagatiateTransport> getTransports() {
        return transports;
    }

    public void setTransports(List<AvailableNagatiateTransport> transports) {
        this.transports = transports;
    }

    @Override
    public String toString() {
        return "SGONegatiate{" +
                "negotiateVersion=" + negotiateVersion +
                ", connectionId='" + connectionId + '\'' +
                ", connectionToken='" + connectionToken + '\'' +
                ", transports=" + transports +
                '}';
    }
}