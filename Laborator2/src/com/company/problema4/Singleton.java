package com.company.problema4;

class Singleton {
    private static float nr;
    private static Singleton singleton;

    private Singleton(){
        this.nr = 3.14f;
    }

    public static Singleton getSingleton(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
