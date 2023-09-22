package me.gaegul.refactoring.ch11.no13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

public class ResourcePool {

    private final Deque<Resource> available = new ArrayDeque<>();
    private final List<Resource> allocated = new ArrayList<>();

    public Resource get() {
        Resource result = null;
        if (available.isEmpty()) {
            result = Resource.create();
            allocated.add(result);
        } else {
            result = available.pop();
            allocated.add(result);
        }
        return result;
    }

    public void addAvailableResource(Resource resource) {
        this.available.add(resource);
    }

    public Deque<Resource> getAvailable() {
        return available;
    }

    public List<Resource> getAllocated() {
        return allocated;
    }
}
