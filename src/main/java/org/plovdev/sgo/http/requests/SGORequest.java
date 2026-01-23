package org.plovdev.sgo.http.requests;

import org.plovdev.sgo.http.HttpMethod;

import java.lang.reflect.Type;
import java.util.Map;

public abstract class SGORequest<T> {
    public abstract HttpMethod method();
    public abstract String endpoint();
    public abstract String params();
    public abstract String contentType();
    public abstract Map<String, String> headers();
    public abstract Type responseType();
}