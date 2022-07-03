package com.dola.runnerbook.domain.road;

public class NoRoadException extends RuntimeException {
    public NoRoadException(String id) {
        super(String.valueOf(id));
    }
}
