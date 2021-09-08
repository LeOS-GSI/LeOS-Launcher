/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package amirz.aidlbridge;
public interface IBridgeCallback extends android.os.IInterface
{
  /** Default implementation for IBridgeCallback. */
  public static class Default implements amirz.aidlbridge.IBridgeCallback
  {
    @Override public void onServiceConnected(android.content.ComponentName name, android.os.IBinder service) throws android.os.RemoteException
    {
    }
    @Override public void onServiceDisconnected(android.content.ComponentName name) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements amirz.aidlbridge.IBridgeCallback
  {
    private static final java.lang.String DESCRIPTOR = "amirz.aidlbridge.IBridgeCallback";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an amirz.aidlbridge.IBridgeCallback interface,
     * generating a proxy if needed.
     */
    public static amirz.aidlbridge.IBridgeCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof amirz.aidlbridge.IBridgeCallback))) {
        return ((amirz.aidlbridge.IBridgeCallback)iin);
      }
      return new amirz.aidlbridge.IBridgeCallback.Stub.Proxy(obj);
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
        case TRANSACTION_onServiceConnected:
        {
          data.enforceInterface(descriptor);
          android.content.ComponentName _arg0;
          if ((0!=data.readInt())) {
            _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          android.os.IBinder _arg1;
          _arg1 = data.readStrongBinder();
          this.onServiceConnected(_arg0, _arg1);
          return true;
        }
        case TRANSACTION_onServiceDisconnected:
        {
          data.enforceInterface(descriptor);
          android.content.ComponentName _arg0;
          if ((0!=data.readInt())) {
            _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.onServiceDisconnected(_arg0);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements amirz.aidlbridge.IBridgeCallback
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
      @Override public void onServiceConnected(android.content.ComponentName name, android.os.IBinder service) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((name!=null)) {
            _data.writeInt(1);
            name.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeStrongBinder(service);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onServiceConnected, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onServiceConnected(name, service);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void onServiceDisconnected(android.content.ComponentName name) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((name!=null)) {
            _data.writeInt(1);
            name.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_onServiceDisconnected, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onServiceDisconnected(name);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static amirz.aidlbridge.IBridgeCallback sDefaultImpl;
    }
    static final int TRANSACTION_onServiceConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onServiceDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(amirz.aidlbridge.IBridgeCallback impl) {
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
    public static amirz.aidlbridge.IBridgeCallback getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void onServiceConnected(android.content.ComponentName name, android.os.IBinder service) throws android.os.RemoteException;
  public void onServiceDisconnected(android.content.ComponentName name) throws android.os.RemoteException;
}
