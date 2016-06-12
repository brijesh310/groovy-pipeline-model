package org.jenkinsci.groovy.asmodel;

import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.stmt.Statement;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Pattern match for the following Groovy construct:
 *
 * <pre><xmp>
 * parallel(
 * aaa: { ... },
 * bbb: { ... },
 * ...
 * )
 * </xmp></pre>
 *
 * @author Kohsuke Kawaguchi
 * @see ModelParser#matchParallel(Statement)
 */
public class ParallelMatch {
    /**
     * ASTNode that matches the whole thing, which is a method invocation
     */
    public final MethodCallExpression whole;

    /**
     * Order preserving map of all the branches of parallel.
     */
    public final Map<String,ClosureExpression> args = new LinkedHashMap<String, ClosureExpression>();

    public ParallelMatch(MethodCallExpression whole) {
        this.whole = whole;
    }
}
