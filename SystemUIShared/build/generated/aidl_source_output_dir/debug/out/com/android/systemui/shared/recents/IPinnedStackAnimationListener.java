/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.android.systemui.shared.recents;
/**
 * Listener interface that Launcher attaches to SystemUI to get
 * pinned stack animation callbacks.
 */
public interface IPinnedStackAnimationListener extends android.os.IInterface
{
  /** Default implementation for IPinnedStackAnimationListener. */
  public static class Default implements com.android.systemui.shared.recents.IPinnedStackAnimationListener
  {
    /**
         * Notifies the pinned stack animation is started.
         */
    @Override public void onPinnedStackAnimationStarted() throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.android.systemui.shared.recents.IPinnedStackAnimationListener
  {
    private static final java.lang.String DESCRIPTOR = "com.android.systemui.shared.recents.IPinnedStackAnimationListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.android.systemui.shared.recents.IPinnedStackAnimationListener interface,
     * generating a proxy if needed.
     */
    public static com.android.systemui.shared.recents.IPinnedStackAnimationListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.android.systemui.shared.recents.IPinnedStackAnimationListener))) {
        return ((com.android.systemui.shared.recents.IPinnedStackAnimationListener)iin);
      }
      return new com.android.systemui.shared.recents.IPinnedStackAnimationListener.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_onPinnedStackAnimationStarted:
        {
          data.enforceInterface(descriptor);
          this.onPinnedStackAnimationStarted();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.android.systemui.shared.recents.IPinnedStackAnimationListener
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * Notifies the pinned stack animation is started.
           */
      @Override public void onPinnedStackAnimationStarted() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onPinnedStackAnimationStarted, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onPinnedStackAnimationStarted();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static com.android.systemui.shared.recents.IPinnedStackAnimationListener sDefaultImpl;
    }
    static final int TRANSACTION_onPinnedStackAnimationStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.android.systemui.shared.recents.IPinnedStackAnimationListener impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.android.systemui.shared.recents.IPinnedStackAnimationListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * Notifies the pinned stack animation is started.
       */
  public void onPinnedStackAnimationStarted() throws android.os.RemoteException;
}
