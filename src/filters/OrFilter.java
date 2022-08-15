package filters;

import twitter4j.Status;

/**
 * A filter that represents the logical or of its children's filter
 */
public class OrFilter extends AdvancedFilter{

    public OrFilter(Filter childOne, Filter childTwo) {
        super(childOne, childTwo);
    }

    /**
     * An Or filter matches when either of the children match
     * @param s     the tweet to check
     * @return      whether or not either of the children match
     */
    @Override
    public boolean matches(Status s) {
        return childOne.matches(s) || childTwo.matches(s);
    }

    @Override
    public String toString() {
        return "(" + childOne + " or " + childTwo + ')';
    }
}
