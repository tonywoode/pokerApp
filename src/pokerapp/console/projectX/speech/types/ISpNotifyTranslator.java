package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpNotifyTranslator Interface
 */
@IID("{ACA16614-5D3D-11D2-960E-00C04F8EE628}")
public interface ISpNotifyTranslator extends ISpNotifySink {
  // Methods:
  /**
   * @param hWnd Mandatory int parameter.
   * @param msg Mandatory int parameter.
   * @param wParam Mandatory int parameter.
   * @param lParam Mandatory int parameter.
   */

  @VTID(4)
  void initWindowMessage(
    int hWnd,
    int msg,
    int wParam,
    int lParam);


  /**
   * @param pfnCallback Mandatory Holder<java.nio.Buffer> parameter.
   * @param wParam Mandatory int parameter.
   * @param lParam Mandatory int parameter.
   */

  @VTID(5)
  void initCallback(
    Holder<java.nio.Buffer> pfnCallback,
    int wParam,
    int lParam);


  /**
   * @param pSpCallback Mandatory Holder<java.nio.Buffer> parameter.
   * @param wParam Mandatory int parameter.
   * @param lParam Mandatory int parameter.
   */

  @VTID(6)
  void initSpNotifyCallback(
    Holder<java.nio.Buffer> pSpCallback,
    int wParam,
    int lParam);


  /**
   * @param hEvent Mandatory java.nio.Buffer parameter.
   * @param fCloseHandleOnRelease Mandatory int parameter.
   */

  @VTID(7)
  void initWin32Event(
    java.nio.Buffer hEvent,
    int fCloseHandleOnRelease);


  /**
   * @param dwMilliseconds Mandatory int parameter.
   */

  @VTID(8)
  void wait_(
    int dwMilliseconds);


  /**
   */

  @VTID(9)
  void getEventHandle();


  // Properties:
}
