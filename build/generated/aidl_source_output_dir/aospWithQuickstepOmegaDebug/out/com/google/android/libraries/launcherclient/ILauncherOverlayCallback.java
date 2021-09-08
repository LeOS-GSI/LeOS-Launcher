/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.google.android.libraries.launcherclient;
public interface ILauncherOverlayCallback extends android.os.IInterface
{
  /** Default implementation for ILauncherOverlayCallback. */
  public static class Default implements com.google.android.libraries.launcherclient.ILauncherOverlayCallback
  {
    @Override public void overlayScrollChanged(float progress) throws android.os.RemoteException
    {
    }
    @Override public void overlayStatusChanged(int status) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.google.android.libraries.launcherclient.ILauncherOverlayCallback
  {
    private static final java.lang.String DESCRIPTOR = "com.google.android.libraries.launcherclient.ILauncherOverlayCallback";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.google.android.libraries.launcherclient.ILauncherOverlayCallback interface,
     * generating a proxy if needed.
     */
    public static com.google.android.libraries.launcherclient.ILauncherOverlayCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.google.android.libraries.launcherclient.ILauncherOverlayCallback))) {
        return ((com.google.android.libraries.launcherclient.ILauncherOverlayCallback)iin);
      }
      return new com.google.android.libraries.launcherclient.ILauncherOverlayCallback.Stub.Proxy(obj);
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
        case TRANSACTION_overlayScrollChanged:
        {
          data.enforceInterface(descriptor);
          float _arg0;
          _arg0 = data.readFloat();
          this.overlayScrollChanged(_arg0);
          return true;
        }
        case TRANSACTION_overlayStatusChanged:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.overlayStatusChanged(_arg0);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.google.android.libraries.launcherclient.ILauncherOverlayCallback
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
      @Override public void overlayScrollChanged(float progress) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeFloat(progress);
          boolean _status = mRemote.transact(Stub.TRANSACTION_overlayScrollChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().overlayScrollChanged(progress);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void overlayStatusChanged(int status) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(status);
          boolean _status = mRemote.transact(Stub.TRANSACTION_overlayStatusChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().overlayStatusChanged(status);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static com.google.android.libraries.launcherclient.ILauncherOverlayCallback sDefaultImpl;
    }
    static final int TRANSACTION_overlayScrollChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_overlayStatusChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(com.google.android.libraries.launcherclient.ILauncherOverlayCallback impl) {
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
    public static com.google.android.libraries.launcherclient.ILauncherOverlayCallback getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void overlayScrollChanged(float progress) throws android.os.RemoteException;
  public void overlayStatusChanged(int status) throws android.os.RemoteException;
}
