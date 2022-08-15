package filters;

import twitter4j.Status;

/**
 * A filter that represents the logical and of its children's filter
 */
public class AndFilter extends AdvancedFilter{

    public AndFilter(Filter childOne, Filter childTwo) {
        super(childOne, childTwo);
    }

    /**
     * An And filter matches when both children match
     * @param s     the tweet to check
     * @return      whether or not both children match
     */
    @Override
    public boolean matches(Status s) {
        return childOne.matches(s) && childTwo.matches(s);
    }

    @Override
    public String toString() {
        return "(" + childOne + " and " + childTwo + ')';
    }
}
