/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.google.android.libraries.launcherclient;
public interface ILauncherOverlay extends android.os.IInterface
{
  /** Default implementation for ILauncherOverlay. */
  public static class Default implements com.google.android.libraries.launcherclient.ILauncherOverlay
  {
    @Override public void startScroll() throws android.os.RemoteException
    {
    }
    @Override public void onScroll(float progress) throws android.os.RemoteException
    {
    }
    @Override public void endScroll() throws android.os.RemoteException
    {
    }
    @Override public void windowAttached(android.view.WindowManager.LayoutParams lp, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb, int flags) throws android.os.RemoteException
    {
    }
    @Override public void windowDetached(boolean isChangingConfigurations) throws android.os.RemoteException
    {
    }
    @Override public void closeOverlay(int flags) throws android.os.RemoteException
    {
    }
    @Override public void onPause() throws android.os.RemoteException
    {
    }
    @Override public void onResume() throws android.os.RemoteException
    {
    }
    @Override public void openOverlay(int flags) throws android.os.RemoteException
    {
    }
    @Override public void requestVoiceDetection(boolean start) throws android.os.RemoteException
    {
    }
    @Override public java.lang.String getVoiceSearchLanguage() throws android.os.RemoteException
    {
      return null;
    }
    @Override public boolean isVoiceDetectionRunning() throws android.os.RemoteException
    {
      return false;
    }
    @Override public boolean hasOverlayContent() throws android.os.RemoteException
    {
      return false;
    }
    @Override public void windowAttached2(android.os.Bundle bundle, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb) throws android.os.RemoteException
    {
    }
    @Override public void unusedMethod() throws android.os.RemoteException
    {
    }
    @Override public void setActivityState(int flags) throws android.os.RemoteException
    {
    }
    @Override public boolean startSearch(byte[] data, android.os.Bundle bundle) throws android.os.RemoteException
    {
      return false;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.google.android.libraries.launcherclient.ILauncherOverlay
  {
    private static final java.lang.String DESCRIPTOR = "com.google.android.libraries.launcherclient.ILauncherOverlay";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.google.android.libraries.launcherclient.ILauncherOverlay interface,
     * generating a proxy if needed.
     */
    public static com.google.android.libraries.launcherclient.ILauncherOverlay asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.google.android.libraries.launcherclient.ILauncherOverlay))) {
        return ((com.google.android.libraries.launcherclient.ILauncherOverlay)iin);
      }
      return new com.google.android.libraries.launcherclient.ILauncherOverlay.Stub.Proxy(obj);
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
        case TRANSACTION_startScroll:
        {
          data.enforceInterface(descriptor);
          this.startScroll();
          return true;
        }
        case TRANSACTION_onScroll:
        {
          data.enforceInterface(descriptor);
          float _arg0;
          _arg0 = data.readFloat();
          this.onScroll(_arg0);
          return true;
        }
        case TRANSACTION_endScroll:
        {
          data.enforceInterface(descriptor);
          this.endScroll();
          return true;
        }
        case TRANSACTION_windowAttached:
        {
          data.enforceInterface(descriptor);
          android.view.WindowManager.LayoutParams _arg0;
          if ((0!=data.readInt())) {
            _arg0 = android.view.WindowManager.LayoutParams.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          com.google.android.libraries.launcherclient.ILauncherOverlayCallback _arg1;
          _arg1 = com.google.android.libraries.launcherclient.ILauncherOverlayCallback.Stub.asInterface(data.readStrongBinder());
          int _arg2;
          _arg2 = data.readInt();
          this.windowAttached(_arg0, _arg1, _arg2);
          return true;
        }
        case TRANSACTION_windowDetached:
        {
          data.enforceInterface(descriptor);
          boolean _arg0;
          _arg0 = (0!=data.readInt());
          this.windowDetached(_arg0);
          return true;
        }
        case TRANSACTION_closeOverlay:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.closeOverlay(_arg0);
          return true;
        }
        case TRANSACTION_onPause:
        {
          data.enforceInterface(descriptor);
          this.onPause();
          return true;
        }
        case TRANSACTION_onResume:
        {
          data.enforceInterface(descriptor);
          this.onResume();
          return true;
        }
        case TRANSACTION_openOverlay:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.openOverlay(_arg0);
          return true;
        }
        case TRANSACTION_requestVoiceDetection:
        {
          data.enforceInterface(descriptor);
          boolean _arg0;
          _arg0 = (0!=data.readInt());
          this.requestVoiceDetection(_arg0);
          return true;
        }
        case TRANSACTION_getVoiceSearchLanguage:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.getVoiceSearchLanguage();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_isVoiceDetectionRunning:
        {
          data.enforceInterface(descriptor);
          boolean _result = this.isVoiceDetectionRunning();
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_hasOverlayContent:
        {
          data.enforceInterface(descriptor);
          boolean _result = this.hasOverlayContent();
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_windowAttached2:
        {
          data.enforceInterface(descriptor);
          android.os.Bundle _arg0;
          if ((0!=data.readInt())) {
            _arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          com.google.android.libraries.launcherclient.ILauncherOverlayCallback _arg1;
          _arg1 = com.google.android.libraries.launcherclient.ILauncherOverlayCallback.Stub.asInterface(data.readStrongBinder());
          this.windowAttached2(_arg0, _arg1);
          return true;
        }
        case TRANSACTION_unusedMethod:
        {
          data.enforceInterface(descriptor);
          this.unusedMethod();
          return true;
        }
        case TRANSACTION_setActivityState:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.setActivityState(_arg0);
          return true;
        }
        case TRANSACTION_startSearch:
        {
          data.enforceInterface(descriptor);
          byte[] _arg0;
          _arg0 = data.createByteArray();
          android.os.Bundle _arg1;
          if ((0!=data.readInt())) {
            _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
          }
          else {
            _arg1 = null;
          }
          boolean _result = this.startSearch(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.google.android.libraries.launcherclient.ILauncherOverlay
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
      @Override public void startScroll() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_startScroll, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().startScroll();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void onScroll(float progress) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeFloat(progress);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onScroll, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onScroll(progress);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void endScroll() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_endScroll, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().endScroll();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void windowAttached(android.view.WindowManager.LayoutParams lp, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb, int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((lp!=null)) {
            _data.writeInt(1);
            lp.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_windowAttached, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().windowAttached(lp, cb, flags);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void windowDetached(boolean isChangingConfigurations) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(((isChangingConfigurations)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_windowDetached, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().windowDetached(isChangingConfigurations);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void closeOverlay(int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_closeOverlay, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().closeOverlay(flags);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void onPause() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onPause, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onPause();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void onResume() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onResume, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onResume();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void openOverlay(int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_openOverlay, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().openOverlay(flags);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void requestVoiceDetection(boolean start) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(((start)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_requestVoiceDetection, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().requestVoiceDetection(start);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public java.lang.String getVoiceSearchLanguage() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getVoiceSearchLanguage, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getVoiceSearchLanguage();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean isVoiceDetectionRunning() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_isVoiceDetectionRunning, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().isVoiceDetectionRunning();
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean hasOverlayContent() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_hasOverlayContent, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().hasOverlayContent();
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void windowAttached2(android.os.Bundle bundle, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((bundle!=null)) {
            _data.writeInt(1);
            bundle.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_windowAttached2, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().windowAttached2(bundle, cb);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void unusedMethod() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_unusedMethod, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().unusedMethod();
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void setActivityState(int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setActivityState, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().setActivityState(flags);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public boolean startSearch(byte[] data, android.os.Bundle bundle) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeByteArray(data);
          if ((bundle!=null)) {
            _data.writeInt(1);
            bundle.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_startSearch, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().startSearch(data, bundle);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.google.android.libraries.launcherclient.ILauncherOverlay sDefaultImpl;
    }
    static final int TRANSACTION_startScroll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onScroll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_endScroll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_windowAttached = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_windowDetached = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_closeOverlay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_onPause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_onResume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_openOverlay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_requestVoiceDetection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_getVoiceSearchLanguage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_isVoiceDetectionRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_hasOverlayContent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_windowAttached2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_unusedMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
    static final int TRANSACTION_setActivityState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
    static final int TRANSACTION_startSearch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
    public static boolean setDefaultImpl(com.google.android.libraries.launcherclient.ILauncherOverlay impl) {
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
    public static com.google.android.libraries.launcherclient.ILauncherOverlay getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void startScroll() throws android.os.RemoteException;
  public void onScroll(float progress) throws android.os.RemoteException;
  public void endScroll() throws android.os.RemoteException;
  public void windowAttached(android.view.WindowManager.LayoutParams lp, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb, int flags) throws android.os.RemoteException;
  public void windowDetached(boolean isChangingConfigurations) throws android.os.RemoteException;
  public void closeOverlay(int flags) throws android.os.RemoteException;
  public void onPause() throws android.os.RemoteException;
  public void onResume() throws android.os.RemoteException;
  public void openOverlay(int flags) throws android.os.RemoteException;
  public void requestVoiceDetection(boolean start) throws android.os.RemoteException;
  public java.lang.String getVoiceSearchLanguage() throws android.os.RemoteException;
  public boolean isVoiceDetectionRunning() throws android.os.RemoteException;
  public boolean hasOverlayContent() throws android.os.RemoteException;
  public void windowAttached2(android.os.Bundle bundle, com.google.android.libraries.launcherclient.ILauncherOverlayCallback cb) throws android.os.RemoteException;
  public void unusedMethod() throws android.os.RemoteException;
  public void setActivityState(int flags) throws android.os.RemoteException;
  public boolean startSearch(byte[] data, android.os.Bundle bundle) throws android.os.RemoteException;
}
