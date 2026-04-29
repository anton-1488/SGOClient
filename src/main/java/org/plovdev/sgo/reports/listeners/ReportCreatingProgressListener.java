package org.plovdev.sgo.reports.listeners;

import org.plovdev.sgo.reports.dto.ReportCreated;
import org.plovdev.sgo.reports.dto.ReportCreatingProgress;

public interface ReportCreatingProgressListener {
    void onProgress(ReportCreatingProgress progress);
    void onCreated(ReportCreated created);
    void onError(ReportCreatingProgress error);
}