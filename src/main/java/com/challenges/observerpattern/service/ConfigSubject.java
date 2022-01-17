package com.challenges.observerpattern.service;

import com.challenges.observerpattern.utils.ConfigObserver;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Subject
@Service
public class ConfigSubject {
    private final Set<ConfigObserver> observers;

    public ConfigSubject(){
        // Due to all the observers are synchronized, they will execute the same thing at the same time
        observers = Collections.synchronizedSet(new HashSet<>());
    }

    public void addObserver(ConfigObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ConfigObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(Object event){
        synchronized (observers){
            observers.forEach(observer -> observer.updateConfig(event));
        }
    }



}
