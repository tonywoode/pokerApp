package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpObjectToken Interface
 */
@IID("{14056589-E16C-11D2-BB90-00C04F8EE6C0}")
public interface ISpObjectToken extends ISpDataKey {
  // Methods:
  /**
   * @param pszCategoryId Mandatory java.lang.String parameter.
   * @param pszTokenId Mandatory java.lang.String parameter.
   * @param fCreateIfNotExist Mandatory int parameter.
   */

  @VTID(15)
  void setId(
    @MarshalAs(NativeType.Unicode) java.lang.String pszCategoryId,
    @MarshalAs(NativeType.Unicode) java.lang.String pszTokenId,
    int fCreateIfNotExist);


    /**
     * @param ppTokenCategory Mandatory Holder<ISpObjectTokenCategory> parameter.
     */

    @VTID(17)
    void getCategory(
      Holder<ISpObjectTokenCategory> ppTokenCategory);


    /**
     * @param pUnkOuter Mandatory com4j.Com4jObject parameter.
     * @param dwClsContext Mandatory int parameter.
     * @param riid Mandatory GUID parameter.
     * @return  Returns a value of type java.nio.Buffer
     */

    @VTID(18)
    java.nio.Buffer createInstance(
      com4j.Com4jObject pUnkOuter,
      int dwClsContext,
      GUID riid);


    /**
     * @param clsidCaller Mandatory GUID parameter.
     * @param pszValueName Mandatory java.lang.String parameter.
     * @param pszFileNameSpecifier Mandatory java.lang.String parameter.
     * @param nFolder Mandatory int parameter.
     * @return  Returns a value of type Holder<Short>
     */

    @VTID(19)
    Holder<Short> getStorageFileName(
      GUID clsidCaller,
      @MarshalAs(NativeType.Unicode) java.lang.String pszValueName,
      @MarshalAs(NativeType.Unicode) java.lang.String pszFileNameSpecifier,
      int nFolder);


    /**
     * @param clsidCaller Mandatory GUID parameter.
     * @param pszKeyName Mandatory java.lang.String parameter.
     * @param fDeleteFile Mandatory int parameter.
     */

    @VTID(20)
    void removeStorageFileName(
      GUID clsidCaller,
      @MarshalAs(NativeType.Unicode) java.lang.String pszKeyName,
      int fDeleteFile);


    /**
     * @param pclsidCaller Mandatory GUID parameter.
     */

    @VTID(21)
    void remove(
      GUID pclsidCaller);


    /**
     * @param pszTypeOfUI Mandatory java.lang.String parameter.
     * @param pvExtraData Mandatory java.nio.Buffer parameter.
     * @param cbExtraData Mandatory int parameter.
     * @param punkObject Mandatory com4j.Com4jObject parameter.
     * @return  Returns a value of type int
     */

    @VTID(22)
    int isUISupported(
      @MarshalAs(NativeType.Unicode) java.lang.String pszTypeOfUI,
      java.nio.Buffer pvExtraData,
      int cbExtraData,
      com4j.Com4jObject punkObject);


    /**
     * @param hWndParent Mandatory int parameter.
     * @param pszTitle Mandatory java.lang.String parameter.
     * @param pszTypeOfUI Mandatory java.lang.String parameter.
     * @param pvExtraData Mandatory java.nio.Buffer parameter.
     * @param cbExtraData Mandatory int parameter.
     * @param punkObject Mandatory com4j.Com4jObject parameter.
     */

    @VTID(23)
    void displayUI(
      int hWndParent,
      @MarshalAs(NativeType.Unicode) java.lang.String pszTitle,
      @MarshalAs(NativeType.Unicode) java.lang.String pszTypeOfUI,
      java.nio.Buffer pvExtraData,
      int cbExtraData,
      com4j.Com4jObject punkObject);


    /**
     * @param pszAttributes Mandatory java.lang.String parameter.
     * @return  Returns a value of type int
     */

    @VTID(24)
    int matchesAttributes(
      @MarshalAs(NativeType.Unicode) java.lang.String pszAttributes);


    // Properties:
  }
