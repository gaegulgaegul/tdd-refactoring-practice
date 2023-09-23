package me.gaegul.refactoring.ch11.no13;

import java.util.Objects;
import java.util.UUID;

public class Resource {
    private String id;

    public Resource() {
        this.id = UUID.randomUUID().toString();
    }

    public static Resource create() {
        return new Resource();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
