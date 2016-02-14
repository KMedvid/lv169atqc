package com.softserve.edu;

public class ApplEnum {

    public static enum First {
        ONE("First ONE"),
        TWO("First TWO");
        private String query;

        private First(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public static enum Second {
        ONE("Second ONE"),
        TWO("Second TWO");
        private String query;

        private Second(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public static void main(String[] args) {
        // get pointer to enum
        // Class<?> classEnum = First.class;
        // Enum en = First; // Error
        Enum en = First.ONE;
        for (First first : First.values()) {
            System.out.println("ELEMENT: " + first.name() + " toStr: " + first.toString());
        }
        System.out.println("DONE");
        // System.out.println(First.ONE.toString());
        System.out.println(First.ONE.toString());
    }

}
