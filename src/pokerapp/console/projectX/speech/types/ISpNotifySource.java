package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpNotifySource Interface
 */
@IID("{5EFF4AEF-8487-11D2-961C-00C04F8EE628}")
public interface ISpNotifySource extends Com4jObject {
  // Methods:
  /**
   * @param pNotifySink MandatoryISpNotifySink parameter.
   */

  @VTID(3)
  void setNotifySink(
   ISpNotifySink pNotifySink);


  /**
   * @param hWnd Mandatory int parameter.
   * @param msg Mandatory int parameter.
   * @param wParam Mandatory int parameter.
   * @param lParam Mandatory int parameter.
   */

  @VTID(4)
  void setNotifyWindowMessage(
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
  void setNotifyCallbackFunction(
    Holder<java.nio.Buffer> pfnCallback,
    int wParam,
    int lParam);


  /**
   * @param pSpCallback Mandatory Holder<java.nio.Buffer> parameter.
   * @param wParam Mandatory int parameter.
   * @param lParam Mandatory int parameter.
   */

  @VTID(6)
  void setNotifyCallbackInterface(
    Holder<java.nio.Buffer> pSpCallback,
    int wParam,
    int lParam);


  /**
   */

  @VTID(7)
  void setNotifyWin32Event();


  /**
   * @param dwMilliseconds Mandatory int parameter.
   */

  @VTID(8)
  void waitForNotifyEvent(
    int dwMilliseconds);


  /**
   */

  @VTID(9)
  void getNotifyEventHandle();


  // Properties:
}
