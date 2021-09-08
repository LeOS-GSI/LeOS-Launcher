/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package amirz.aidlbridge;
public interface IBridge extends android.os.IInterface
{
  /** Default implementation for IBridge. */
  public static class Default implements amirz.aidlbridge.IBridge
  {
    @Override public void bindService(amirz.aidlbridge.IBridgeCallback cb, int flags) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements amirz.aidlbridge.IBridge
  {
    private static final java.lang.String DESCRIPTOR = "amirz.aidlbridge.IBridge";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an amirz.aidlbridge.IBridge interface,
     * generating a proxy if needed.
     */
    public static amirz.aidlbridge.IBridge asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof amirz.aidlbridge.IBridge))) {
        return ((amirz.aidlbridge.IBridge)iin);
      }
      return new amirz.aidlbridge.IBridge.Stub.Proxy(obj);
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
        case TRANSACTION_bindService:
        {
          data.enforceInterface(descriptor);
          amirz.aidlbridge.IBridgeCallback _arg0;
          _arg0 = amirz.aidlbridge.IBridgeCallback.Stub.asInterface(data.readStrongBinder());
          int _arg1;
          _arg1 = data.readInt();
          this.bindService(_arg0, _arg1);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements amirz.aidlbridge.IBridge
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
      @Override public void bindService(amirz.aidlbridge.IBridgeCallback cb, int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_bindService, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().bindService(cb, flags);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static amirz.aidlbridge.IBridge sDefaultImpl;
    }
    static final int TRANSACTION_bindService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(amirz.aidlbridge.IBridge impl) {
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
    public static amirz.aidlbridge.IBridge getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void bindService(amirz.aidlbridge.IBridgeCallback cb, int flags) throws android.os.RemoteException;
}
