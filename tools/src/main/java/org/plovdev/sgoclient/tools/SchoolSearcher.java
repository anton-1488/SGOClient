package org.plovdev.sgoclient.tools;

import org.jspecify.annotations.NonNull;
import org.plovdev.sgoclient.core.SGOClient;
import org.plovdev.sgoclient.core.dto.SGOSchool;
import org.plovdev.sgoclient.core.http.requests.commons.SearchSchools;

import java.util.List;
import java.util.Optional;

public class SchoolSearcher {
    public static @NonNull Optional<SGOSchool> searchSchool(@NonNull SGOClient client, String name) {
        List<SGOSchool> schools = client.execute(new SearchSchools(name));
        return schools.stream().findFirst();
    }
}