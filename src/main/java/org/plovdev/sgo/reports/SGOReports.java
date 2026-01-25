package org.plovdev.sgo.reports;

import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.SGOLogin;
import org.plovdev.sgo.dto.SGOReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SGOReports {
    private static final Logger log = LoggerFactory.getLogger(SGOReports.class);
    private SGOClient sgoClient;
    public SGOReports(SGOClient client) {
        sgoClient = client;
    }

    public SGOClient getSgoClient() {
        return sgoClient;
    }

    public void setSgoClient(SGOClient sgoClient) {
        this.sgoClient = sgoClient;
    }

    public SGOReport createReport(SGOReportSettings settings) {
        SGOLogin sgoLogin = sgoClient.getCurrentSession().getSgoLogin();


        return new SGOReport();
    }
}