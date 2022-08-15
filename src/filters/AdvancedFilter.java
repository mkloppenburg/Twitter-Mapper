package filters;

import java.util.List;

/**
 * abstract class to support more advanced filters with
 * two children like the And and Or filter
 */
public abstract class AdvancedFilter implements Filter {
    protected final Filter childOne;
    protected final Filter childTwo;

    public AdvancedFilter(Filter childOne, Filter childTwo) {
        this.childOne = childOne;
        this.childTwo = childTwo;
    }

    @Override
    public List<String> terms() {
        List<String> allTerms = childOne.terms();
        allTerms.addAll(childTwo.terms());
        return allTerms;
    }
}
