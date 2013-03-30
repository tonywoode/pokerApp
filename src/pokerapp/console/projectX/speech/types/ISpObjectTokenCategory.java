package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpObjectTokenCategory
 */
@IID("{2D3D3845-39AF-4850-BBF9-40B49780011D}")
public interface ISpObjectTokenCategory extends ISpDataKey {
  // Methods:
  /**
   * @param pszCategoryId Mandatory java.lang.String parameter.
   * @param fCreateIfNotExist Mandatory int parameter.
   */

  @VTID(15)
  void setId(
    @MarshalAs(NativeType.Unicode) java.lang.String pszCategoryId,
    int fCreateIfNotExist);


  /**
   * @return  Returns a value of type Holder<Short>
   */

  @VTID(16)
  Holder<Short> getId();


  /**
   * @param spdkl MandatorySPDATAKEYLOCATION parameter.
   * @param ppDataKey Mandatory Holder<ISpDataKey> parameter.
   */

  @VTID(17)
  void getDataKey(
   SPDATAKEYLOCATION spdkl,
    Holder<ISpDataKey> ppDataKey);


  /**
   * @param pzsReqAttribs Mandatory java.lang.String parameter.
   * @param pszOptAttribs Mandatory java.lang.String parameter.
   * @return  Returns a value of typeIEnumSpObjectTokens
   */

  @VTID(18)
 IEnumSpObjectTokens enumTokens(
    @MarshalAs(NativeType.Unicode) java.lang.String pzsReqAttribs,
    @MarshalAs(NativeType.Unicode) java.lang.String pszOptAttribs);


  /**
   * @param pszTokenId Mandatory java.lang.String parameter.
   */

  @VTID(19)
  void setDefaultTokenId(
    @MarshalAs(NativeType.Unicode) java.lang.String pszTokenId);


  /**
   * @return  Returns a value of type Holder<Short>
   */

  @VTID(20)
  Holder<Short> getDefaultTokenId();


  // Properties:
}
