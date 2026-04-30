package org.plovdev.sgoclient.reports.listeners;

import org.plovdev.sgoclient.reports.dto.ReportCreated;
import org.plovdev.sgoclient.reports.dto.ReportCreatingProgress;

public interface ReportCreatingProgressListener {
    void onProgress(ReportCreatingProgress progress);

    void onCreated(ReportCreated created);

    void onError(ReportCreatingProgress error);
}