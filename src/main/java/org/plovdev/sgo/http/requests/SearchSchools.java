package org.plovdev.sgo.http.requests;

import com.google.gson.reflect.TypeToken;
import org.plovdev.sgo.dto.SGOSchool;
import org.plovdev.sgo.http.HttpMethod;
import org.plovdev.sgo.http.SGOHttpPath;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class SearchSchools extends SGORequest<List<SGOSchool>> {
    private String searchString;
    private boolean withAddress = true;

    public SearchSchools(String searchString, boolean withAddress) {
        this.searchString = searchString;
        this.withAddress = withAddress;
    }

    public SearchSchools(String searchString) {
        this.searchString = searchString;
    }

    public SearchSchools() {
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isWithAddress() {
        return withAddress;
    }

    public void setWithAddress(boolean withAddress) {
        this.withAddress = withAddress;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public String endpoint() {
        String params = "?withAddress=" + withAddress;
        StringBuilder nameBuilder = new StringBuilder();

        if (searchString != null) {
            for (String name : searchString.split(" ")) {
                nameBuilder.append("&name=");
                nameBuilder.append(URLEncoder.encode(name, StandardCharsets.UTF_8));
            }
        }
        params = params + nameBuilder;

        return SGOHttpPath.SEARCH_SCHOOL + params;
    }

    @Override
    public String params() {
        return "";
    }

    @Override
    public String contentType() {
        return "application/json; charset=utf-8";
    }

    @Override
    public Map<String, String> headers() {
        return Map.of();
    }

    @Override
    public Type responseType() {
        return new TypeToken<List<SGOSchool>>(){}.getType();
    }
}