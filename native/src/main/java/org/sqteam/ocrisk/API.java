package org.sqteam.ocrisk;

public class API {
    private native long init();
    private native void test(long ptr);

    private native void destroy(long ptr);

    private final long ptr_state;
    public API(){
        ptr_state = init();
    }

    public void test(){
        test(this.ptr_state);
    }

    @Override
    protected void finalize() throws Throwable {
        destroy(this.ptr_state);
        super.finalize();
    }
}
