package org.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.services.MalaiGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractMalaiSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MalaiGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Transition___LeftCurlyBracketKeyword_8_0_RightCurlyBracketKeyword_8_5__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MalaiGrammarAccess) access;
		match_Transition___LeftCurlyBracketKeyword_8_0_RightCurlyBracketKeyword_8_5__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_8_5()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Transition___LeftCurlyBracketKeyword_8_0_RightCurlyBracketKeyword_8_5__q.equals(syntax))
				emit_Transition___LeftCurlyBracketKeyword_8_0_RightCurlyBracketKeyword_8_5__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_Transition___LeftCurlyBracketKeyword_8_0_RightCurlyBracketKeyword_8_5__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
