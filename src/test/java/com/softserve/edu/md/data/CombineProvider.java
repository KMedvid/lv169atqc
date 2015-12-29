package com.softserve.edu.md.data;

public final class CombineProvider {
    private static volatile CombineProvider instance = null;

    private CombineProvider() {
    }

    public static CombineProvider get() {
        if (instance == null) {
            synchronized (CombineProvider.class) {
                if (instance == null) {
                    instance = new CombineProvider();
                }
            }
        }
        return instance;
    }

    public Object[][] getExistUsersCVS(IUrls urls) {
        Object[][] userUrl = (new ListUtils()).toMultiArrayNumber(UserRepository.get().getExistUsersCVS(), 2);
        for (int i = 0; i < userUrl.length; i++) {
            userUrl[i][1] = urls;
        }
        return userUrl;
    }

    public Object[][] getExistUsersExcel(IUrls urls) {
        Object[][] userUrl = (new ListUtils()).toMultiArrayNumber(UserRepository.get().getExistUsersExcel(), 2);
        for (int i = 0; i < userUrl.length; i++) {
            userUrl[i][1] = urls;
        }
        return userUrl;
    }

}
