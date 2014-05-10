package pokerapp.basicgame.jcommander;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.Range;

/**
 * Created by Tony on 10/05/14.
 */
public class DifficultyValidator implements IParameterValidator {

    private static final Range<Integer> DIFFICULTY_RANGE = Range.between(1,4);

    @Override
    public void validate(String name, String value) throws ParameterException {
        int n = Integer.parseInt(value);
        if(!DIFFICULTY_RANGE.contains(4)) {
            throw new ParameterException("Parameter " + name + " should be between 1 and 4.");
        }
    }
}
