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
        Class<?> classEnum = First.class;
        //System.out.println(First.ONE.toString());
        System.out.println(First.ONE.toString());
    }

}
