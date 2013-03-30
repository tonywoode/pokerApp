package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpDataKey Interface
 */
@IID("{14056581-E16C-11D2-BB90-00C04F8EE6C0}")
public interface ISpDataKey extends Com4jObject {
  // Methods:
  /**
   * @param pszValueName Mandatory java.lang.String parameter.
   * @param cbData Mandatory int parameter.
   * @param pData Mandatory Holder<Byte> parameter.
   */

  @VTID(3)
  void setData(
    @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
    int cbData,
    Holder<Byte> pData);


  /**
   * @param pszValueName Mandatory java.lang.String parameter.
   * @param pcbData Mandatory Holder<Integer> parameter.
   * @param pData Mandatory Holder<Byte> parameter.
   */

  @VTID(4)
  void getData(
    @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
    Holder<Integer> pcbData,
    Holder<Byte> pData);


  /**
   * @param pszValueName Mandatory java.lang.String parameter.
   * @param pszValue Mandatory java.lang.String parameter.
   */

  @VTID(5)
  void setStringValue(
    @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
    @MarshalAs(NativeType.Unicode) java.lang.String pszValue);


    /**
     * @param pszValueName Mandatory java.lang.String parameter.
     * @param dwValue Mandatory int parameter.
     */

    @VTID(7)
    void setDWORD(
      @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
      int dwValue);


    /**
     * @param pszValueName Mandatory java.lang.String parameter.
     * @param pdwValue Mandatory Holder<Integer> parameter.
     */

    @VTID(8)
    void getDWORD(
      @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
      Holder<Integer> pdwValue);


    /**
     * @param pszSubKeyName Mandatory java.lang.String parameter.
     * @param ppSubKey Mandatory Holder<ISpDataKey> parameter.
     */

    @VTID(9)
    void openKey(
      @MarshalAs(NativeType.Unicode) java.lang.String pszSubKeyName,
      Holder<ISpDataKey> ppSubKey);


    /**
     * @param pszSubKey Mandatory java.lang.String parameter.
     * @param ppSubKey Mandatory Holder<ISpDataKey> parameter.
     */

    @VTID(10)
    void createKey(
      @MarshalAs(NativeType.Unicode) java.lang.String pszSubKey,
      Holder<ISpDataKey> ppSubKey);


    /**
     * @param pszSubKey Mandatory java.lang.String parameter.
     */

    @VTID(11)
    void deleteKey(
      @MarshalAs(NativeType.Unicode) java.lang.String pszSubKey);


    /**
     * @param pszValueName Mandatory java.lang.String parameter.
     */

    @VTID(12)
    void deleteValue(
      @MarshalAs(NativeType.Unicode) java.lang.String pszValueName);


        // Properties:
      }
