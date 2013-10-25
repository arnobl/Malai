package org.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.BasicEMap.Entry;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.malai.action.Action;
import org.malai.action.ActionDependency;
import org.malai.action.ActionPackage;
import org.malai.event.Event;
import org.malai.event.EventPackage;
import org.malai.instrument.Instrument;
import org.malai.instrument.InstrumentPackage;
import org.malai.instrument.Link;
import org.malai.interaction.AbortingState;
import org.malai.interaction.InitState;
import org.malai.interaction.Interaction;
import org.malai.interaction.InteractionPackage;
import org.malai.interaction.StandardState;
import org.malai.interaction.TerminalState;
import org.malai.interaction.Transition;
import org.malai.interactiveSystem.InteractiveSystemPackage;
import org.malai.interactiveSystem.interactiveSystem;
import org.malai.widget.Button;
import org.malai.widget.CheckBox;
import org.malai.widget.DialogueBox;
import org.malai.widget.Label;
import org.malai.widget.Menu;
import org.malai.widget.MultiLineList;
import org.malai.widget.Panel;
import org.malai.widget.ProgressBar;
import org.malai.widget.RadioButton;
import org.malai.widget.RadioMenu;
import org.malai.widget.SingleLineList;
import org.malai.widget.Slider;
import org.malai.widget.Spinner;
import org.malai.widget.SplitPane;
import org.malai.widget.TabbedPanel;
import org.malai.widget.Table;
import org.malai.widget.TextArea;
import org.malai.widget.TextField;
import org.malai.widget.ToggleButton;
import org.malai.widget.ToggleMenu;
import org.malai.widget.Tree;
import org.malai.widget.WidgetPackage;
import org.malai.widget.Window;
import org.services.MalaiGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractMalaiSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MalaiGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ActionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ActionPackage.ACTION:
				if(context == grammarAccess.getActionRule()) {
					sequence_Action(context, (Action) semanticObject); 
					return; 
				}
				else break;
			case ActionPackage.ACTION_DEPENDENCY:
				if(context == grammarAccess.getActionDependencyRule()) {
					sequence_ActionDependency(context, (ActionDependency) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EcorePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePackage.EANNOTATION:
				if(context == grammarAccess.getEAnnotationRule()) {
					sequence_EAnnotation(context, (EAnnotation) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EATTRIBUTE:
				if(context == grammarAccess.getEAttributeRule() ||
				   context == grammarAccess.getEStructuralFeatureRule()) {
					sequence_EAttribute(context, (EAttribute) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.ECLASS:
				if(context == grammarAccess.getEClassRule() ||
				   context == grammarAccess.getEClassifierRule()) {
					sequence_EClass(context, (EClass) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EDATA_TYPE:
				if(context == grammarAccess.getEClassifierRule() ||
				   context == grammarAccess.getEDataType_ImplRule()) {
					sequence_EDataType_Impl(context, (EDataType) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EENUM:
				if(context == grammarAccess.getEClassifierRule() ||
				   context == grammarAccess.getEEnumRule()) {
					sequence_EEnum(context, (EEnum) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EENUM_LITERAL:
				if(context == grammarAccess.getEEnumLiteralRule()) {
					sequence_EEnumLiteral(context, (EEnumLiteral) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EGENERIC_TYPE:
				if(context == grammarAccess.getEGenericTypeRule()) {
					sequence_EGenericType(context, (EGenericType) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EOBJECT:
				if(context == grammarAccess.getEObjectRule()) {
					sequence_EObject(context, (EObject) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EOPERATION:
				if(context == grammarAccess.getEOperationRule()) {
					sequence_EOperation(context, (EOperation) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EPARAMETER:
				if(context == grammarAccess.getEParameterRule()) {
					sequence_EParameter(context, (EParameter) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EREFERENCE:
				if(context == grammarAccess.getEReferenceRule() ||
				   context == grammarAccess.getEStructuralFeatureRule()) {
					sequence_EReference(context, (EReference) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.ESTRING_TO_STRING_MAP_ENTRY:
				if(context == grammarAccess.getEStringToStringMapEntryRule()) {
					sequence_EStringToStringMapEntry(context, (Entry<?, ?>) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.ETYPE_PARAMETER:
				if(context == grammarAccess.getETypeParameterRule()) {
					sequence_ETypeParameter(context, (ETypeParameter) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EventPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EventPackage.EVENT:
				if(context == grammarAccess.getEventRule()) {
					sequence_Event(context, (Event) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == InstrumentPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InstrumentPackage.INSTRUMENT:
				if(context == grammarAccess.getInstrumentRule()) {
					sequence_Instrument(context, (Instrument) semanticObject); 
					return; 
				}
				else break;
			case InstrumentPackage.LINK:
				if(context == grammarAccess.getLinkRule()) {
					sequence_Link(context, (Link) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == InteractionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InteractionPackage.ABORTING_STATE:
				if(context == grammarAccess.getAbortingStateRule() ||
				   context == grammarAccess.getStateRule()) {
					sequence_AbortingState(context, (AbortingState) semanticObject); 
					return; 
				}
				else break;
			case InteractionPackage.INIT_STATE:
				if(context == grammarAccess.getInitStateRule() ||
				   context == grammarAccess.getStateRule()) {
					sequence_InitState(context, (InitState) semanticObject); 
					return; 
				}
				else break;
			case InteractionPackage.INTERACTION:
				if(context == grammarAccess.getInteractionRule()) {
					sequence_Interaction(context, (Interaction) semanticObject); 
					return; 
				}
				else break;
			case InteractionPackage.STANDARD_STATE:
				if(context == grammarAccess.getStandardState_ImplRule() ||
				   context == grammarAccess.getStateRule()) {
					sequence_StandardState_Impl(context, (StandardState) semanticObject); 
					return; 
				}
				else break;
			case InteractionPackage.TERMINAL_STATE:
				if(context == grammarAccess.getStateRule() ||
				   context == grammarAccess.getTerminalStateRule()) {
					sequence_TerminalState(context, (TerminalState) semanticObject); 
					return; 
				}
				else break;
			case InteractionPackage.TRANSITION:
				if(context == grammarAccess.getTransitionRule()) {
					sequence_Transition(context, (Transition) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == InteractiveSystemPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM:
				if(context == grammarAccess.getInteractiveSystemRule()) {
					sequence_interactiveSystem(context, (interactiveSystem) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == WidgetPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case WidgetPackage.BUTTON:
				if(context == grammarAccess.getButton_ImplRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Button_Impl(context, (Button) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.CHECK_BOX:
				if(context == grammarAccess.getCheckBoxRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_CheckBox(context, (CheckBox) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.DIALOGUE_BOX:
				if(context == grammarAccess.getDialogueBoxRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_DialogueBox(context, (DialogueBox) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.LABEL:
				if(context == grammarAccess.getLabelRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Label(context, (Label) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.MENU:
				if(context == grammarAccess.getMenu_ImplRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Menu_Impl(context, (Menu) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.MULTI_LINE_LIST:
				if(context == grammarAccess.getMultiLineListRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_MultiLineList(context, (MultiLineList) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.PANEL:
				if(context == grammarAccess.getPanelRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Panel(context, (Panel) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.PROGRESS_BAR:
				if(context == grammarAccess.getProgressBarRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_ProgressBar(context, (ProgressBar) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.RADIO_BUTTON:
				if(context == grammarAccess.getRadioButtonRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_RadioButton(context, (RadioButton) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.RADIO_MENU:
				if(context == grammarAccess.getRadioMenuRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_RadioMenu(context, (RadioMenu) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.SINGLE_LINE_LIST:
				if(context == grammarAccess.getSingleLineListRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_SingleLineList(context, (SingleLineList) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.SLIDER:
				if(context == grammarAccess.getSliderRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Slider(context, (Slider) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.SPINNER:
				if(context == grammarAccess.getSpinnerRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Spinner(context, (Spinner) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.SPLIT_PANE:
				if(context == grammarAccess.getSplitPaneRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_SplitPane(context, (SplitPane) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TABBED_PANEL:
				if(context == grammarAccess.getTabbedPanelRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_TabbedPanel(context, (TabbedPanel) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TABLE:
				if(context == grammarAccess.getTableRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Table(context, (Table) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TEXT_AREA:
				if(context == grammarAccess.getTextAreaRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_TextArea(context, (TextArea) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TEXT_FIELD:
				if(context == grammarAccess.getTextFieldRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_TextField(context, (TextField) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TOGGLE_BUTTON:
				if(context == grammarAccess.getToggleButtonRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_ToggleButton(context, (ToggleButton) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TOGGLE_MENU:
				if(context == grammarAccess.getToggleMenuRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_ToggleMenu(context, (ToggleMenu) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.TREE:
				if(context == grammarAccess.getTreeRule() ||
				   context == grammarAccess.getWidgetRule()) {
					sequence_Tree(context, (Tree) semanticObject); 
					return; 
				}
				else break;
			case WidgetPackage.WINDOW:
				if(context == grammarAccess.getWidgetRule() ||
				   context == grammarAccess.getWindow_ImplRule()) {
					sequence_Window_Impl(context, (Window) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=EString description=EString? (outputTransitions+=Transition outputTransitions+=Transition*)?)
	 */
	protected void sequence_AbortingState(EObject context, AbortingState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString srcAction=[Action|EString] tgtActions+=[Action|EString] tgtActions+=[Action|EString]*)
	 */
	protected void sequence_ActionDependency(EObject context, ActionDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         undoable?='undoable' 
	 *         modifyInstrument?='modifyInstrument'? 
	 *         name=EString 
	 *         execute=EString? 
	 *         canDo=EString? 
	 *         undo=EString? 
	 *         redo=EString? 
	 *         (cancelledBy+=[Action|EString] cancelledBy+=[Action|EString]*)? 
	 *         clazz=EClass 
	 *         (dependencies+=ActionDependency dependencies+=ActionDependency*)?
	 *     )
	 */
	protected void sequence_Action(EObject context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_Button_Impl(EObject context, Button semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_CheckBox(EObject context, CheckBox semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (elements+=Widget elements+=Widget*)?)
	 */
	protected void sequence_DialogueBox(EObject context, DialogueBox semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         source=EString? 
	 *         (references+=[EObject|EString] references+=[EObject|EString]*)? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         (details+=EStringToStringMapEntry details+=EStringToStringMapEntry*)? 
	 *         (contents+=EObject contents+=EObject*)?
	 *     )
	 */
	protected void sequence_EAnnotation(EObject context, EAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         volatile?='volatile'? 
	 *         transient?='transient'? 
	 *         unsettable?='unsettable'? 
	 *         derived?='derived'? 
	 *         iD?='iD'? 
	 *         name=EString 
	 *         ordered=EBoolean? 
	 *         unique=EBoolean? 
	 *         lowerBound=EInt? 
	 *         upperBound=EInt? 
	 *         changeable=EBoolean? 
	 *         defaultValueLiteral=EString? 
	 *         eType=[EClassifier|EString]? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         eGenericType=EGenericType?
	 *     )
	 */
	protected void sequence_EAttribute(EObject context, EAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         abstract?='abstract'? 
	 *         interface?='interface'? 
	 *         name=EString 
	 *         instanceClassName=EString? 
	 *         instanceTypeName=EString? 
	 *         (eSuperTypes+=[EClass|EString] eSuperTypes+=[EClass|EString]*)? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         (eTypeParameters+=ETypeParameter eTypeParameters+=ETypeParameter*)? 
	 *         (eOperations+=EOperation eOperations+=EOperation*)? 
	 *         (eStructuralFeatures+=EStructuralFeature eStructuralFeatures+=EStructuralFeature*)? 
	 *         (eGenericSuperTypes+=EGenericType eGenericSuperTypes+=EGenericType*)?
	 *     )
	 */
	protected void sequence_EClass(EObject context, EClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         instanceClassName=EString? 
	 *         instanceTypeName=EString? 
	 *         serializable=EBoolean? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         (eTypeParameters+=ETypeParameter eTypeParameters+=ETypeParameter*)?
	 *     )
	 */
	protected void sequence_EDataType_Impl(EObject context, EDataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString value=EInt? literal=EString? (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)?)
	 */
	protected void sequence_EEnumLiteral(EObject context, EEnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         instanceClassName=EString? 
	 *         instanceTypeName=EString? 
	 *         serializable=EBoolean? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         (eTypeParameters+=ETypeParameter eTypeParameters+=ETypeParameter*)? 
	 *         (eLiterals+=EEnumLiteral eLiterals+=EEnumLiteral*)?
	 *     )
	 */
	protected void sequence_EEnum(EObject context, EEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         eTypeParameter=[ETypeParameter|EString]? 
	 *         eClassifier=[EClassifier|EString]? 
	 *         eUpperBound=EGenericType? 
	 *         (eTypeArguments+=EGenericType eTypeArguments+=EGenericType*)? 
	 *         eLowerBound=EGenericType?
	 *     )
	 */
	protected void sequence_EGenericType(EObject context, EGenericType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EObject}
	 */
	protected void sequence_EObject(EObject context, EObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         ordered=EBoolean? 
	 *         unique=EBoolean? 
	 *         lowerBound=EInt? 
	 *         upperBound=EInt? 
	 *         eType=[EClassifier|EString]? 
	 *         (eExceptions+=[EClassifier|EString] eExceptions+=[EClassifier|EString]*)? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         eGenericType=EGenericType? 
	 *         (eTypeParameters+=ETypeParameter eTypeParameters+=ETypeParameter*)? 
	 *         (eParameters+=EParameter eParameters+=EParameter*)? 
	 *         (eGenericExceptions+=EGenericType eGenericExceptions+=EGenericType*)?
	 *     )
	 */
	protected void sequence_EOperation(EObject context, EOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         ordered=EBoolean? 
	 *         unique=EBoolean? 
	 *         lowerBound=EInt? 
	 *         upperBound=EInt? 
	 *         eType=[EClassifier|EString]? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         eGenericType=EGenericType?
	 *     )
	 */
	protected void sequence_EParameter(EObject context, EParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         volatile?='volatile'? 
	 *         transient?='transient'? 
	 *         unsettable?='unsettable'? 
	 *         derived?='derived'? 
	 *         containment?='containment'? 
	 *         name=EString 
	 *         ordered=EBoolean? 
	 *         unique=EBoolean? 
	 *         lowerBound=EInt? 
	 *         upperBound=EInt? 
	 *         changeable=EBoolean? 
	 *         defaultValueLiteral=EString? 
	 *         resolveProxies=EBoolean? 
	 *         eType=[EClassifier|EString]? 
	 *         eOpposite=[EReference|EString]? 
	 *         (eKeys+=[EAttribute|EString] eKeys+=[EAttribute|EString]*)? 
	 *         (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? 
	 *         eGenericType=EGenericType?
	 *     )
	 */
	protected void sequence_EReference(EObject context, EReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (key=EString? value=EString?)
	 */
	protected void sequence_EStringToStringMapEntry(EObject context, Entry<?, ?> semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (eAnnotations+=EAnnotation eAnnotations+=EAnnotation*)? (eBounds+=EGenericType eBounds+=EGenericType*)?)
	 */
	protected void sequence_ETypeParameter(EObject context, ETypeParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     clazz=EClass
	 */
	protected void sequence_Event(EObject context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString description=EString? (outputTransitions+=Transition outputTransitions+=Transition*)?)
	 */
	protected void sequence_InitState(EObject context, InitState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         initiallyActivated?='initiallyActivated'? 
	 *         description=EString? 
	 *         author=EString? 
	 *         version=EString? 
	 *         dateCreation=EString? 
	 *         interimFeedback=EString? 
	 *         (subscribedWidgets+=[Widget|EString] subscribedWidgets+=[Widget|EString]*)? 
	 *         (links+=Link links+=Link*)? 
	 *         clazz=EClass? 
	 *         (helpers+=EClassifier helpers+=EClassifier*)? 
	 *         (providedWidgets+=Widget providedWidgets+=Widget*)?
	 *     )
	 */
	protected void sequence_Instrument(EObject context, Instrument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         activated?='activated' 
	 *         name=EString 
	 *         description=EString? 
	 *         author=EString? 
	 *         dateCreation=EString? 
	 *         version=EString? 
	 *         initState=[InitState|EString]? 
	 *         currentState=[State|EString]? 
	 *         (states+=State states+=State*)? 
	 *         clazz=EClass 
	 *         (helpers+=EClassifier helpers+=EClassifier*)?
	 *     )
	 */
	protected void sequence_Interaction(EObject context, Interaction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString text=EString?)
	 */
	protected void sequence_Label(EObject context, Label semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         executeOnUpdate?='executeOnUpdate' 
	 *         description=EString? 
	 *         interimFeedback=EString? 
	 *         isConditionRespected=EString? 
	 *         updateAction=EString? 
	 *         initialiseAction=EString? 
	 *         interaction=[Interaction|EString] 
	 *         action=[Action|EString] 
	 *         clazz=EClass?
	 *     )
	 */
	protected void sequence_Link(EObject context, Link semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_Menu_Impl(EObject context, Menu semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_MultiLineList(EObject context, MultiLineList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (elements+=Widget elements+=Widget*)?)
	 */
	protected void sequence_Panel(EObject context, Panel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_ProgressBar(EObject context, ProgressBar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_RadioButton(EObject context, RadioButton semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_RadioMenu(EObject context, RadioMenu semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_SingleLineList(EObject context, SingleLineList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_Slider(EObject context, Slider semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString text=EString?)
	 */
	protected void sequence_Spinner(EObject context, Spinner semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (elements+=Widget elements+=Widget*)?)
	 */
	protected void sequence_SplitPane(EObject context, SplitPane semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString description=EString? (outputTransitions+=Transition outputTransitions+=Transition*)?)
	 */
	protected void sequence_StandardState_Impl(EObject context, StandardState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (elements+=Widget elements+=Widget*)?)
	 */
	protected void sequence_TabbedPanel(EObject context, TabbedPanel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_Table(EObject context, Table semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString description=EString? (outputTransitions+=Transition outputTransitions+=Transition*)?)
	 */
	protected void sequence_TerminalState(EObject context, TerminalState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString text=EString?)
	 */
	protected void sequence_TextArea(EObject context, TextArea semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString text=EString?)
	 */
	protected void sequence_TextField(EObject context, TextField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_ToggleButton(EObject context, ToggleButton semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_ToggleMenu(EObject context, ToggleMenu semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         event=[Event|EString] 
	 *         inputState=[State|EString] 
	 *         outputState=[State|EString] 
	 *         (description=EString? condition=EString? actions=EString? hid=EInt?)?
	 *     )
	 */
	protected void sequence_Transition(EObject context, Transition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_Tree(EObject context, Tree semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString (elements+=Widget elements+=Widget*)?)
	 */
	protected void sequence_Window_Impl(EObject context, Window semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (instruments+=Instrument instruments+=Instrument*)? 
	 *         (interactions+=Interaction interactions+=Interaction*)? 
	 *         (actions+=Action actions+=Action*)? 
	 *         (events+=Event events+=Event*)? 
	 *         (widgets+=Widget widgets+=Widget*)?
	 *     )
	 */
	protected void sequence_interactiveSystem(EObject context, interactiveSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
