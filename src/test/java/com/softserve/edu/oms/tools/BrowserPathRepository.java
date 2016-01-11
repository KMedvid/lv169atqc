package com.softserve.edu.oms.tools;
public final class BrowserPathRepository {

    public static enum BrowserPath {
        CHROME_PATH("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"),
        IE_PATH("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        private String field;

        private BrowserPath(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private BrowserPathRepository() {
    }

    // TODO
    // public static String getChromePath() {
    // Read from Propertiwe File.
    // return "C:\\Program Files
    // (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
    // }

}
