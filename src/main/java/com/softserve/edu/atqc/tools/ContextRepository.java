package com.softserve.edu.atqc.tools;

public final class ContextRepository {
    private static volatile ContextRepository instance = null;

    private ContextRepository() {
    }

    static ContextRepository get() {
        if (instance == null) {
            synchronized (ContextRepository.class) {
                if (instance == null) {
                    instance = new ContextRepository();
                }
            }
        }
        return instance;
    }

    public ASearchContext getImplicitWrapper() {
        return SearchImplicit.get();
    }

    public ASearchContext getExplicitWrapper() {
        return SearchExplicit.get();
    }

}
