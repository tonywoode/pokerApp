package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechGrammarRuleState Interface
 */
@IID("{D4286F2C-EE67-45AE-B928-28D695362EDA}")
public interface ISpeechGrammarRuleState extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Rule
   * </p>
   * <p>
   * Getter method for the COM property "Rule"
   * </p>
   * @return  Returns a value of typeISpeechGrammarRule
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
 ISpeechGrammarRule rule();


  /**
   * <p>
   * Transitions
   * </p>
   * <p>
   * Getter method for the COM property "Transitions"
   * </p>
   * @return  Returns a value of typeISpeechGrammarRuleStateTransitions
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
 ISpeechGrammarRuleStateTransitions transitions();


  @VTID(8)
  @ReturnValue(defaultPropertyThrough={ISpeechGrammarRuleStateTransitions.class})
 ISpeechGrammarRuleStateTransition transitions(
    int index);

  /**
   * <p>
   * AddWordTransition
   * </p>
   * @param destState MandatoryISpeechGrammarRuleState parameter.
   * @param words Mandatory java.lang.String parameter.
   * @param separators Optional parameter. Default value is " "
   * @param type Optional parameter. Default value is 1
   * @param propertyName Optional parameter. Default value is ""
   * @param propertyId Optional parameter. Default value is 0
   * @param propertyValue Optional parameter. Default value is ""
   * @param weight Optional parameter. Default value is 1.0f
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  void addWordTransition(
   ISpeechGrammarRuleState destState,
    java.lang.String words,
    @Optional @DefaultValue(" ") java.lang.String separators,
    @Optional @DefaultValue("1")SpeechGrammarWordType type,
    @Optional @DefaultValue("") java.lang.String propertyName,
    @Optional @DefaultValue("0") int propertyId,
    @Optional @DefaultValue("") java.lang.Object propertyValue,
    @Optional @DefaultValue("1") float weight);


  /**
   * <p>
   * AddRuleTransition
   * </p>
   * @param destinationState MandatoryISpeechGrammarRuleState parameter.
   * @param rule MandatoryISpeechGrammarRule parameter.
   * @param propertyName Optional parameter. Default value is ""
   * @param propertyId Optional parameter. Default value is 0
   * @param propertyValue Optional parameter. Default value is ""
   * @param weight Optional parameter. Default value is 1.0f
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  void addRuleTransition(
   ISpeechGrammarRuleState destinationState,
   ISpeechGrammarRule rule,
    @Optional @DefaultValue("") java.lang.String propertyName,
    @Optional @DefaultValue("0") int propertyId,
    @Optional @DefaultValue("") java.lang.Object propertyValue,
    @Optional @DefaultValue("1") float weight);


  /**
   * <p>
   * AddSpecialTransition
   * </p>
   * @param destinationState MandatoryISpeechGrammarRuleState parameter.
   * @param type MandatorySpeechSpecialTransitionType parameter.
   * @param propertyName Optional parameter. Default value is ""
   * @param propertyId Optional parameter. Default value is 0
   * @param propertyValue Optional parameter. Default value is ""
   * @param weight Optional parameter. Default value is 1.0f
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  void addSpecialTransition(
   ISpeechGrammarRuleState destinationState,
   SpeechSpecialTransitionType type,
    @Optional @DefaultValue("") java.lang.String propertyName,
    @Optional @DefaultValue("0") int propertyId,
    @Optional @DefaultValue("") java.lang.Object propertyValue,
    @Optional @DefaultValue("1") float weight);


  // Properties:
}
