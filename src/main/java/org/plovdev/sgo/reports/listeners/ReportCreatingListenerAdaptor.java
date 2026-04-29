package org.plovdev.sgo.reports.listeners;

import org.plovdev.sgo.reports.dto.ReportCreated;
import org.plovdev.sgo.reports.dto.ReportCreatingProgress;

public abstract class ReportCreatingListenerAdaptor implements ReportCreatingProgressListener {
    @Override
    public void onProgress(ReportCreatingProgress progress) {

    }

    @Override
    public void onCreated(ReportCreated created) {

    }

    @Override
    public void onError(ReportCreatingProgress error) {

    }
}