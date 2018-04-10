package ca.coursePlanner.model;

import ca.coursePlanner.model.Watcher.Watcher;

public interface Subject {
    public void notifyWatchers();
    public void registerWatchers(Watcher watcher);
}
