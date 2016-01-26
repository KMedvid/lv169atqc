package com.softserve.edu.tools;

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

    public ASearchContext getSearchDefault() {
        return SearchExplicit.get();
    }

    public ASearchContext getSearchImplicit() {
        return SearchImplicit.get();
    }

    public ASearchContext getSearchExplicit() {
        return SearchExplicit.get();
    }

}
