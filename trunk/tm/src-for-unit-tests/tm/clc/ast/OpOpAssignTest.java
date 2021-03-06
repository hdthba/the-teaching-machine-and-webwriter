package tm.clc.ast;

import junit.framework.*;

import tm.clc.analysis.ScopedName ;
import tm.clc.datum.* ;
import tm.clc.rtSymTab.RT_Symbol_Table ;
import tm.cpp.ast.* ;
import tm.cpp.analysis.Cpp_ScopedName;
import tm.cpp.datum.* ;
import tm.interfaces.* ;
import tm.virtualMachine.* ;

public class OpOpAssignTest extends Cpp_AbstractAstTest {

    public OpOpAssignTest() { this ("OpOpAssignTest"); }
    public OpOpAssignTest (String name) { super (name); print=true; }

    public void test_assign () {

        TypeNode lng = TyLong.get() ;
        TyRef refLong = new TyRef( lng ) ;

        AbstractIntDatum d = (AbstractIntDatum) lng.makeDatum(vms, vms.getStore().getStack(), "x") ;
        d.putValue(5) ;

        ScopedName name1 = new Cpp_ScopedName("x") ;
        ScopedName name2 = new Cpp_ScopedName("x") ;

        symtab.newVar( name1, "x", d ) ;

        // Make the tree
            ExpId id = new ExpId(refLong, "x", name2 ) ;
            ExpFetch fetch = new ExpFetch(lng, id) ;
            ConstInt right_operand = new ConstInt( lng, "-99", -99 ) ;
            OpInt expression = new OpInt(lng, Arithmetic.SUBTRACT, "-", fetch, right_operand) ;

            OpOpAssign nd = new OpOpAssign( refLong, "-=", "=", id, right_operand, expression ) ;

        // Make Evaluation.
        ExpressionEvaluation ee = new ExpressionEvaluation( vms, nd ) ;
        vms.push( ee ) ;

        // Evaluate
        // Select and step four times to evaluate operands
            advance(8) ;
        // Select
            nd.select( vms ) ;
            assertTrue( vms.top().getSelected() == nd ) ;
        // Is the target highlighted?
            assertTrue( d.getHighlight() == Datum.HIGHLIGHTED ) ;
        // Step
            advance(1) ;
        // Is the target unhighlighted?
            assertTrue( d.getHighlight() == Datum.PLAIN ) ;
        // Has the value changed?
            assertTrue( d.getValue() == 104 ) ;
        // Is the node mapped correctly?
            assertTrue( vms.top().at( nd ) == vms.top().at( id ) ) ;
    }
}
