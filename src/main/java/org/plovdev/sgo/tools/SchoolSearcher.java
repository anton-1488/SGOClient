package org.plovdev.sgo.tools;

import org.plovdev.sgo.SGOClient;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.requests.SearchSchools;

import java.util.List;
import java.util.Optional;

public class SchoolSearcher {
    public static Optional<SGOSchool> searchSchool(SGOClient client, String name) {
        List<SGOSchool> schools = client.execute(new SearchSchools(name));
        return schools.stream().findFirst();
    }
}