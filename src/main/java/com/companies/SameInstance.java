package com.companies;


/**/
public class SameInstance {

    private static SameInstance same;

    private SameInstance() {

    }

    synchronized static SameInstance returnSelf() {
        if (same == null)
            same = new SameInstance();
        return same;
    }
}
