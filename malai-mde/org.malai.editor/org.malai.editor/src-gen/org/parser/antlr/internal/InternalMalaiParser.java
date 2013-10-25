package org.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.services.MalaiGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMalaiParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'interactiveSystem'", "'{'", "'instruments'", "','", "'}'", "'interactions'", "'actions'", "'events'", "'widgets'", "'initiallyActivated'", "'Instrument'", "'description'", "'author'", "'version'", "'dateCreation'", "'interimFeedback'", "'subscribedWidgets'", "'('", "')'", "'links'", "'clazz'", "'helpers'", "'providedWidgets'", "'undoable'", "'modifyInstrument'", "'Action'", "'execute'", "'canDo'", "'undo'", "'redo'", "'cancelledBy'", "'dependencies'", "'Event'", "'executeOnUpdate'", "'Link'", "'isConditionRespected'", "'updateAction'", "'initialiseAction'", "'interaction'", "'action'", "'activated'", "'Interaction'", "'initState'", "'currentState'", "'states'", "':'", "'=>'", "'condition'", "'hid'", "'InitState'", "'['", "']'", "'AbortingState'", "'TerminalState'", "'StandardState'", "'ActionDependency'", "'srcAction'", "'tgtActions'", "'Tree'", "'Slider'", "'ProgressBar'", "'Table'", "'Label'", "'text'", "'TextArea'", "'TextField'", "'Spinner'", "'MultiLineList'", "'SingleLineList'", "'Panel'", "'elements'", "'Window'", "'DialogueBox'", "'SplitPane'", "'TabbedPanel'", "'Button'", "'ToggleButton'", "'Menu'", "'CheckBox'", "'RadioButton'", "'ToggleMenu'", "'RadioMenu'", "'abstract'", "'interface'", "'EClass'", "'instanceClassName'", "'instanceTypeName'", "'eSuperTypes'", "'eAnnotations'", "'eTypeParameters'", "'eOperations'", "'eStructuralFeatures'", "'eGenericSuperTypes'", "'true'", "'false'", "'-'", "'EAnnotation'", "'source'", "'references'", "'details'", "'contents'", "'ETypeParameter'", "'eBounds'", "'EOperation'", "'ordered'", "'unique'", "'lowerBound'", "'upperBound'", "'eType'", "'eExceptions'", "'eGenericType'", "'eParameters'", "'eGenericExceptions'", "'EGenericType'", "'eTypeParameter'", "'eClassifier'", "'eUpperBound'", "'eTypeArguments'", "'eLowerBound'", "'EStringToStringMapEntry'", "'key'", "'value'", "'EObject'", "'EParameter'", "'volatile'", "'transient'", "'unsettable'", "'derived'", "'iD'", "'EAttribute'", "'changeable'", "'defaultValueLiteral'", "'containment'", "'EReference'", "'resolveProxies'", "'eOpposite'", "'eKeys'", "'EDataType'", "'serializable'", "'EEnum'", "'eLiterals'", "'EEnumLiteral'", "'literal'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__16=16;
    public static final int T__147=147;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__149=149;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__150=150;
    public static final int T__98=98;
    public static final int T__151=151;
    public static final int T__97=97;
    public static final int T__152=152;
    public static final int T__96=96;
    public static final int T__153=153;
    public static final int T__95=95;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__141=141;
    public static final int T__85=85;
    public static final int T__142=142;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__140=140;
    public static final int T__86=86;
    public static final int T__145=145;
    public static final int T__89=89;
    public static final int T__146=146;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__143=143;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int RULE_STRING=4;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__129=129;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__130=130;
    public static final int T__74=74;
    public static final int T__131=131;
    public static final int T__73=73;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__79=79;
    public static final int T__134=134;
    public static final int T__78=78;
    public static final int T__135=135;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalMalaiParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMalaiParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMalaiParser.tokenNames; }
    public String getGrammarFileName() { return "../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g"; }



     	private MalaiGrammarAccess grammarAccess;
     	
        public InternalMalaiParser(TokenStream input, MalaiGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "interactiveSystem";	
       	}
       	
       	@Override
       	protected MalaiGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleinteractiveSystem"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:67:1: entryRuleinteractiveSystem returns [EObject current=null] : iv_ruleinteractiveSystem= ruleinteractiveSystem EOF ;
    public final EObject entryRuleinteractiveSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleinteractiveSystem = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:68:2: (iv_ruleinteractiveSystem= ruleinteractiveSystem EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:69:2: iv_ruleinteractiveSystem= ruleinteractiveSystem EOF
            {
             newCompositeNode(grammarAccess.getInteractiveSystemRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleinteractiveSystem_in_entryRuleinteractiveSystem75);
            iv_ruleinteractiveSystem=ruleinteractiveSystem();

            state._fsp--;

             current =iv_ruleinteractiveSystem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleinteractiveSystem85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleinteractiveSystem"


    // $ANTLR start "ruleinteractiveSystem"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:76:1: ruleinteractiveSystem returns [EObject current=null] : ( () otherlv_1= 'interactiveSystem' otherlv_2= '{' (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )? (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )? (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )? (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )? (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )? otherlv_33= '}' ) ;
    public final EObject ruleinteractiveSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        EObject lv_instruments_5_0 = null;

        EObject lv_instruments_7_0 = null;

        EObject lv_interactions_11_0 = null;

        EObject lv_interactions_13_0 = null;

        EObject lv_actions_17_0 = null;

        EObject lv_actions_19_0 = null;

        EObject lv_events_23_0 = null;

        EObject lv_events_25_0 = null;

        EObject lv_widgets_29_0 = null;

        EObject lv_widgets_31_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:79:28: ( ( () otherlv_1= 'interactiveSystem' otherlv_2= '{' (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )? (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )? (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )? (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )? (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )? otherlv_33= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:80:1: ( () otherlv_1= 'interactiveSystem' otherlv_2= '{' (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )? (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )? (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )? (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )? (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )? otherlv_33= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:80:1: ( () otherlv_1= 'interactiveSystem' otherlv_2= '{' (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )? (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )? (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )? (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )? (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )? otherlv_33= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:80:2: () otherlv_1= 'interactiveSystem' otherlv_2= '{' (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )? (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )? (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )? (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )? (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )? otherlv_33= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:80:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInteractiveSystemAccess().getInteractiveSystemAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleinteractiveSystem131); 

                	newLeafNode(otherlv_1, grammarAccess.getInteractiveSystemAccess().getInteractiveSystemKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem143); 

                	newLeafNode(otherlv_2, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:94:1: (otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:94:3: otherlv_3= 'instruments' otherlv_4= '{' ( (lv_instruments_5_0= ruleInstrument ) ) (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleinteractiveSystem156); 

                        	newLeafNode(otherlv_3, grammarAccess.getInteractiveSystemAccess().getInstrumentsKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem168); 

                        	newLeafNode(otherlv_4, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:102:1: ( (lv_instruments_5_0= ruleInstrument ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:103:1: (lv_instruments_5_0= ruleInstrument )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:103:1: (lv_instruments_5_0= ruleInstrument )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:104:3: lv_instruments_5_0= ruleInstrument
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getInstrumentsInstrumentParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInstrument_in_ruleinteractiveSystem189);
                    lv_instruments_5_0=ruleInstrument();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	        }
                           		add(
                           			current, 
                           			"instruments",
                            		lv_instruments_5_0, 
                            		"Instrument");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:120:2: (otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:120:4: otherlv_6= ',' ( (lv_instruments_7_0= ruleInstrument ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleinteractiveSystem202); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getInteractiveSystemAccess().getCommaKeyword_3_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:124:1: ( (lv_instruments_7_0= ruleInstrument ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:125:1: (lv_instruments_7_0= ruleInstrument )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:125:1: (lv_instruments_7_0= ruleInstrument )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:126:3: lv_instruments_7_0= ruleInstrument
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getInstrumentsInstrumentParserRuleCall_3_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleInstrument_in_ruleinteractiveSystem223);
                    	    lv_instruments_7_0=ruleInstrument();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"instruments",
                    	            		lv_instruments_7_0, 
                    	            		"Instrument");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem237); 

                        	newLeafNode(otherlv_8, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_3_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:146:3: (otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:146:5: otherlv_9= 'interactions' otherlv_10= '{' ( (lv_interactions_11_0= ruleInteraction ) ) (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleinteractiveSystem252); 

                        	newLeafNode(otherlv_9, grammarAccess.getInteractiveSystemAccess().getInteractionsKeyword_4_0());
                        
                    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem264); 

                        	newLeafNode(otherlv_10, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:154:1: ( (lv_interactions_11_0= ruleInteraction ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:155:1: (lv_interactions_11_0= ruleInteraction )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:155:1: (lv_interactions_11_0= ruleInteraction )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:156:3: lv_interactions_11_0= ruleInteraction
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getInteractionsInteractionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInteraction_in_ruleinteractiveSystem285);
                    lv_interactions_11_0=ruleInteraction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	        }
                           		add(
                           			current, 
                           			"interactions",
                            		lv_interactions_11_0, 
                            		"Interaction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:172:2: (otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:172:4: otherlv_12= ',' ( (lv_interactions_13_0= ruleInteraction ) )
                    	    {
                    	    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleinteractiveSystem298); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getInteractiveSystemAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:176:1: ( (lv_interactions_13_0= ruleInteraction ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:177:1: (lv_interactions_13_0= ruleInteraction )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:177:1: (lv_interactions_13_0= ruleInteraction )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:178:3: lv_interactions_13_0= ruleInteraction
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getInteractionsInteractionParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleInteraction_in_ruleinteractiveSystem319);
                    	    lv_interactions_13_0=ruleInteraction();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"interactions",
                    	            		lv_interactions_13_0, 
                    	            		"Interaction");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem333); 

                        	newLeafNode(otherlv_14, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:198:3: (otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:198:5: otherlv_15= 'actions' otherlv_16= '{' ( (lv_actions_17_0= ruleAction ) ) (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleinteractiveSystem348); 

                        	newLeafNode(otherlv_15, grammarAccess.getInteractiveSystemAccess().getActionsKeyword_5_0());
                        
                    otherlv_16=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem360); 

                        	newLeafNode(otherlv_16, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:206:1: ( (lv_actions_17_0= ruleAction ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:207:1: (lv_actions_17_0= ruleAction )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:207:1: (lv_actions_17_0= ruleAction )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:208:3: lv_actions_17_0= ruleAction
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getActionsActionParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleinteractiveSystem381);
                    lv_actions_17_0=ruleAction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	        }
                           		add(
                           			current, 
                           			"actions",
                            		lv_actions_17_0, 
                            		"Action");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:224:2: (otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==14) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:224:4: otherlv_18= ',' ( (lv_actions_19_0= ruleAction ) )
                    	    {
                    	    otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleinteractiveSystem394); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getInteractiveSystemAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:228:1: ( (lv_actions_19_0= ruleAction ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:229:1: (lv_actions_19_0= ruleAction )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:229:1: (lv_actions_19_0= ruleAction )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:230:3: lv_actions_19_0= ruleAction
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getActionsActionParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleinteractiveSystem415);
                    	    lv_actions_19_0=ruleAction();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actions",
                    	            		lv_actions_19_0, 
                    	            		"Action");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem429); 

                        	newLeafNode(otherlv_20, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:250:3: (otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:250:5: otherlv_21= 'events' otherlv_22= '{' ( (lv_events_23_0= ruleEvent ) ) (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )* otherlv_26= '}'
                    {
                    otherlv_21=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleinteractiveSystem444); 

                        	newLeafNode(otherlv_21, grammarAccess.getInteractiveSystemAccess().getEventsKeyword_6_0());
                        
                    otherlv_22=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem456); 

                        	newLeafNode(otherlv_22, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:258:1: ( (lv_events_23_0= ruleEvent ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:259:1: (lv_events_23_0= ruleEvent )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:259:1: (lv_events_23_0= ruleEvent )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:260:3: lv_events_23_0= ruleEvent
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getEventsEventParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEvent_in_ruleinteractiveSystem477);
                    lv_events_23_0=ruleEvent();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	        }
                           		add(
                           			current, 
                           			"events",
                            		lv_events_23_0, 
                            		"Event");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:276:2: (otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:276:4: otherlv_24= ',' ( (lv_events_25_0= ruleEvent ) )
                    	    {
                    	    otherlv_24=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleinteractiveSystem490); 

                    	        	newLeafNode(otherlv_24, grammarAccess.getInteractiveSystemAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:280:1: ( (lv_events_25_0= ruleEvent ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:281:1: (lv_events_25_0= ruleEvent )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:281:1: (lv_events_25_0= ruleEvent )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:282:3: lv_events_25_0= ruleEvent
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getEventsEventParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEvent_in_ruleinteractiveSystem511);
                    	    lv_events_25_0=ruleEvent();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"events",
                    	            		lv_events_25_0, 
                    	            		"Event");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem525); 

                        	newLeafNode(otherlv_26, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:302:3: (otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:302:5: otherlv_27= 'widgets' otherlv_28= '{' ( (lv_widgets_29_0= ruleWidget ) ) (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )* otherlv_32= '}'
                    {
                    otherlv_27=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleinteractiveSystem540); 

                        	newLeafNode(otherlv_27, grammarAccess.getInteractiveSystemAccess().getWidgetsKeyword_7_0());
                        
                    otherlv_28=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleinteractiveSystem552); 

                        	newLeafNode(otherlv_28, grammarAccess.getInteractiveSystemAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:310:1: ( (lv_widgets_29_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:311:1: (lv_widgets_29_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:311:1: (lv_widgets_29_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:312:3: lv_widgets_29_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getWidgetsWidgetParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleinteractiveSystem573);
                    lv_widgets_29_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	        }
                           		add(
                           			current, 
                           			"widgets",
                            		lv_widgets_29_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:328:2: (otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==14) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:328:4: otherlv_30= ',' ( (lv_widgets_31_0= ruleWidget ) )
                    	    {
                    	    otherlv_30=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleinteractiveSystem586); 

                    	        	newLeafNode(otherlv_30, grammarAccess.getInteractiveSystemAccess().getCommaKeyword_7_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:332:1: ( (lv_widgets_31_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:333:1: (lv_widgets_31_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:333:1: (lv_widgets_31_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:334:3: lv_widgets_31_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractiveSystemAccess().getWidgetsWidgetParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleinteractiveSystem607);
                    	    lv_widgets_31_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractiveSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"widgets",
                    	            		lv_widgets_31_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem621); 

                        	newLeafNode(otherlv_32, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            otherlv_33=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleinteractiveSystem635); 

                	newLeafNode(otherlv_33, grammarAccess.getInteractiveSystemAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleinteractiveSystem"


    // $ANTLR start "entryRuleWidget"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:366:1: entryRuleWidget returns [EObject current=null] : iv_ruleWidget= ruleWidget EOF ;
    public final EObject entryRuleWidget() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidget = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:367:2: (iv_ruleWidget= ruleWidget EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:368:2: iv_ruleWidget= ruleWidget EOF
            {
             newCompositeNode(grammarAccess.getWidgetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWidget_in_entryRuleWidget671);
            iv_ruleWidget=ruleWidget();

            state._fsp--;

             current =iv_ruleWidget; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWidget681); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWidget"


    // $ANTLR start "ruleWidget"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:375:1: ruleWidget returns [EObject current=null] : (this_Tree_0= ruleTree | this_Slider_1= ruleSlider | this_ProgressBar_2= ruleProgressBar | this_Table_3= ruleTable | this_Label_4= ruleLabel | this_TextArea_5= ruleTextArea | this_TextField_6= ruleTextField | this_Spinner_7= ruleSpinner | this_MultiLineList_8= ruleMultiLineList | this_SingleLineList_9= ruleSingleLineList | this_Panel_10= rulePanel | this_Window_Impl_11= ruleWindow_Impl | this_DialogueBox_12= ruleDialogueBox | this_SplitPane_13= ruleSplitPane | this_TabbedPanel_14= ruleTabbedPanel | this_Button_Impl_15= ruleButton_Impl | this_ToggleButton_16= ruleToggleButton | this_Menu_Impl_17= ruleMenu_Impl | this_CheckBox_18= ruleCheckBox | this_RadioButton_19= ruleRadioButton | this_ToggleMenu_20= ruleToggleMenu | this_RadioMenu_21= ruleRadioMenu ) ;
    public final EObject ruleWidget() throws RecognitionException {
        EObject current = null;

        EObject this_Tree_0 = null;

        EObject this_Slider_1 = null;

        EObject this_ProgressBar_2 = null;

        EObject this_Table_3 = null;

        EObject this_Label_4 = null;

        EObject this_TextArea_5 = null;

        EObject this_TextField_6 = null;

        EObject this_Spinner_7 = null;

        EObject this_MultiLineList_8 = null;

        EObject this_SingleLineList_9 = null;

        EObject this_Panel_10 = null;

        EObject this_Window_Impl_11 = null;

        EObject this_DialogueBox_12 = null;

        EObject this_SplitPane_13 = null;

        EObject this_TabbedPanel_14 = null;

        EObject this_Button_Impl_15 = null;

        EObject this_ToggleButton_16 = null;

        EObject this_Menu_Impl_17 = null;

        EObject this_CheckBox_18 = null;

        EObject this_RadioButton_19 = null;

        EObject this_ToggleMenu_20 = null;

        EObject this_RadioMenu_21 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:378:28: ( (this_Tree_0= ruleTree | this_Slider_1= ruleSlider | this_ProgressBar_2= ruleProgressBar | this_Table_3= ruleTable | this_Label_4= ruleLabel | this_TextArea_5= ruleTextArea | this_TextField_6= ruleTextField | this_Spinner_7= ruleSpinner | this_MultiLineList_8= ruleMultiLineList | this_SingleLineList_9= ruleSingleLineList | this_Panel_10= rulePanel | this_Window_Impl_11= ruleWindow_Impl | this_DialogueBox_12= ruleDialogueBox | this_SplitPane_13= ruleSplitPane | this_TabbedPanel_14= ruleTabbedPanel | this_Button_Impl_15= ruleButton_Impl | this_ToggleButton_16= ruleToggleButton | this_Menu_Impl_17= ruleMenu_Impl | this_CheckBox_18= ruleCheckBox | this_RadioButton_19= ruleRadioButton | this_ToggleMenu_20= ruleToggleMenu | this_RadioMenu_21= ruleRadioMenu ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:379:1: (this_Tree_0= ruleTree | this_Slider_1= ruleSlider | this_ProgressBar_2= ruleProgressBar | this_Table_3= ruleTable | this_Label_4= ruleLabel | this_TextArea_5= ruleTextArea | this_TextField_6= ruleTextField | this_Spinner_7= ruleSpinner | this_MultiLineList_8= ruleMultiLineList | this_SingleLineList_9= ruleSingleLineList | this_Panel_10= rulePanel | this_Window_Impl_11= ruleWindow_Impl | this_DialogueBox_12= ruleDialogueBox | this_SplitPane_13= ruleSplitPane | this_TabbedPanel_14= ruleTabbedPanel | this_Button_Impl_15= ruleButton_Impl | this_ToggleButton_16= ruleToggleButton | this_Menu_Impl_17= ruleMenu_Impl | this_CheckBox_18= ruleCheckBox | this_RadioButton_19= ruleRadioButton | this_ToggleMenu_20= ruleToggleMenu | this_RadioMenu_21= ruleRadioMenu )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:379:1: (this_Tree_0= ruleTree | this_Slider_1= ruleSlider | this_ProgressBar_2= ruleProgressBar | this_Table_3= ruleTable | this_Label_4= ruleLabel | this_TextArea_5= ruleTextArea | this_TextField_6= ruleTextField | this_Spinner_7= ruleSpinner | this_MultiLineList_8= ruleMultiLineList | this_SingleLineList_9= ruleSingleLineList | this_Panel_10= rulePanel | this_Window_Impl_11= ruleWindow_Impl | this_DialogueBox_12= ruleDialogueBox | this_SplitPane_13= ruleSplitPane | this_TabbedPanel_14= ruleTabbedPanel | this_Button_Impl_15= ruleButton_Impl | this_ToggleButton_16= ruleToggleButton | this_Menu_Impl_17= ruleMenu_Impl | this_CheckBox_18= ruleCheckBox | this_RadioButton_19= ruleRadioButton | this_ToggleMenu_20= ruleToggleMenu | this_RadioMenu_21= ruleRadioMenu )
            int alt11=22;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt11=1;
                }
                break;
            case 70:
                {
                alt11=2;
                }
                break;
            case 71:
                {
                alt11=3;
                }
                break;
            case 72:
                {
                alt11=4;
                }
                break;
            case 73:
                {
                alt11=5;
                }
                break;
            case 75:
                {
                alt11=6;
                }
                break;
            case 76:
                {
                alt11=7;
                }
                break;
            case 77:
                {
                alt11=8;
                }
                break;
            case 78:
                {
                alt11=9;
                }
                break;
            case 79:
                {
                alt11=10;
                }
                break;
            case 80:
                {
                alt11=11;
                }
                break;
            case 82:
                {
                alt11=12;
                }
                break;
            case 83:
                {
                alt11=13;
                }
                break;
            case 84:
                {
                alt11=14;
                }
                break;
            case 85:
                {
                alt11=15;
                }
                break;
            case 86:
                {
                alt11=16;
                }
                break;
            case 87:
                {
                alt11=17;
                }
                break;
            case 88:
                {
                alt11=18;
                }
                break;
            case 89:
                {
                alt11=19;
                }
                break;
            case 90:
                {
                alt11=20;
                }
                break;
            case 91:
                {
                alt11=21;
                }
                break;
            case 92:
                {
                alt11=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:380:5: this_Tree_0= ruleTree
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getTreeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTree_in_ruleWidget728);
                    this_Tree_0=ruleTree();

                    state._fsp--;

                     
                            current = this_Tree_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:390:5: this_Slider_1= ruleSlider
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getSliderParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSlider_in_ruleWidget755);
                    this_Slider_1=ruleSlider();

                    state._fsp--;

                     
                            current = this_Slider_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:400:5: this_ProgressBar_2= ruleProgressBar
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getProgressBarParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleProgressBar_in_ruleWidget782);
                    this_ProgressBar_2=ruleProgressBar();

                    state._fsp--;

                     
                            current = this_ProgressBar_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:410:5: this_Table_3= ruleTable
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getTableParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTable_in_ruleWidget809);
                    this_Table_3=ruleTable();

                    state._fsp--;

                     
                            current = this_Table_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:420:5: this_Label_4= ruleLabel
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getLabelParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLabel_in_ruleWidget836);
                    this_Label_4=ruleLabel();

                    state._fsp--;

                     
                            current = this_Label_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:430:5: this_TextArea_5= ruleTextArea
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getTextAreaParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTextArea_in_ruleWidget863);
                    this_TextArea_5=ruleTextArea();

                    state._fsp--;

                     
                            current = this_TextArea_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:440:5: this_TextField_6= ruleTextField
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getTextFieldParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTextField_in_ruleWidget890);
                    this_TextField_6=ruleTextField();

                    state._fsp--;

                     
                            current = this_TextField_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:450:5: this_Spinner_7= ruleSpinner
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getSpinnerParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpinner_in_ruleWidget917);
                    this_Spinner_7=ruleSpinner();

                    state._fsp--;

                     
                            current = this_Spinner_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:460:5: this_MultiLineList_8= ruleMultiLineList
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getMultiLineListParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMultiLineList_in_ruleWidget944);
                    this_MultiLineList_8=ruleMultiLineList();

                    state._fsp--;

                     
                            current = this_MultiLineList_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:470:5: this_SingleLineList_9= ruleSingleLineList
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getSingleLineListParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSingleLineList_in_ruleWidget971);
                    this_SingleLineList_9=ruleSingleLineList();

                    state._fsp--;

                     
                            current = this_SingleLineList_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:480:5: this_Panel_10= rulePanel
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getPanelParserRuleCall_10()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePanel_in_ruleWidget998);
                    this_Panel_10=rulePanel();

                    state._fsp--;

                     
                            current = this_Panel_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:490:5: this_Window_Impl_11= ruleWindow_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getWindow_ImplParserRuleCall_11()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWindow_Impl_in_ruleWidget1025);
                    this_Window_Impl_11=ruleWindow_Impl();

                    state._fsp--;

                     
                            current = this_Window_Impl_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:500:5: this_DialogueBox_12= ruleDialogueBox
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getDialogueBoxParserRuleCall_12()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDialogueBox_in_ruleWidget1052);
                    this_DialogueBox_12=ruleDialogueBox();

                    state._fsp--;

                     
                            current = this_DialogueBox_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:510:5: this_SplitPane_13= ruleSplitPane
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getSplitPaneParserRuleCall_13()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSplitPane_in_ruleWidget1079);
                    this_SplitPane_13=ruleSplitPane();

                    state._fsp--;

                     
                            current = this_SplitPane_13; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:520:5: this_TabbedPanel_14= ruleTabbedPanel
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getTabbedPanelParserRuleCall_14()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTabbedPanel_in_ruleWidget1106);
                    this_TabbedPanel_14=ruleTabbedPanel();

                    state._fsp--;

                     
                            current = this_TabbedPanel_14; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:530:5: this_Button_Impl_15= ruleButton_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getButton_ImplParserRuleCall_15()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleButton_Impl_in_ruleWidget1133);
                    this_Button_Impl_15=ruleButton_Impl();

                    state._fsp--;

                     
                            current = this_Button_Impl_15; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:540:5: this_ToggleButton_16= ruleToggleButton
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getToggleButtonParserRuleCall_16()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleToggleButton_in_ruleWidget1160);
                    this_ToggleButton_16=ruleToggleButton();

                    state._fsp--;

                     
                            current = this_ToggleButton_16; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:550:5: this_Menu_Impl_17= ruleMenu_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getMenu_ImplParserRuleCall_17()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMenu_Impl_in_ruleWidget1187);
                    this_Menu_Impl_17=ruleMenu_Impl();

                    state._fsp--;

                     
                            current = this_Menu_Impl_17; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 19 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:560:5: this_CheckBox_18= ruleCheckBox
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getCheckBoxParserRuleCall_18()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCheckBox_in_ruleWidget1214);
                    this_CheckBox_18=ruleCheckBox();

                    state._fsp--;

                     
                            current = this_CheckBox_18; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 20 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:570:5: this_RadioButton_19= ruleRadioButton
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getRadioButtonParserRuleCall_19()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRadioButton_in_ruleWidget1241);
                    this_RadioButton_19=ruleRadioButton();

                    state._fsp--;

                     
                            current = this_RadioButton_19; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 21 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:580:5: this_ToggleMenu_20= ruleToggleMenu
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getToggleMenuParserRuleCall_20()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleToggleMenu_in_ruleWidget1268);
                    this_ToggleMenu_20=ruleToggleMenu();

                    state._fsp--;

                     
                            current = this_ToggleMenu_20; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 22 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:590:5: this_RadioMenu_21= ruleRadioMenu
                    {
                     
                            newCompositeNode(grammarAccess.getWidgetAccess().getRadioMenuParserRuleCall_21()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRadioMenu_in_ruleWidget1295);
                    this_RadioMenu_21=ruleRadioMenu();

                    state._fsp--;

                     
                            current = this_RadioMenu_21; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWidget"


    // $ANTLR start "entryRuleState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:606:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:607:2: (iv_ruleState= ruleState EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:608:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState1330);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState1340); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:615:1: ruleState returns [EObject current=null] : (this_AbortingState_0= ruleAbortingState | this_TerminalState_1= ruleTerminalState | this_StandardState_Impl_2= ruleStandardState_Impl | this_InitState_3= ruleInitState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_AbortingState_0 = null;

        EObject this_TerminalState_1 = null;

        EObject this_StandardState_Impl_2 = null;

        EObject this_InitState_3 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:618:28: ( (this_AbortingState_0= ruleAbortingState | this_TerminalState_1= ruleTerminalState | this_StandardState_Impl_2= ruleStandardState_Impl | this_InitState_3= ruleInitState ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:619:1: (this_AbortingState_0= ruleAbortingState | this_TerminalState_1= ruleTerminalState | this_StandardState_Impl_2= ruleStandardState_Impl | this_InitState_3= ruleInitState )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:619:1: (this_AbortingState_0= ruleAbortingState | this_TerminalState_1= ruleTerminalState | this_StandardState_Impl_2= ruleStandardState_Impl | this_InitState_3= ruleInitState )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt12=1;
                }
                break;
            case 64:
                {
                alt12=2;
                }
                break;
            case 65:
                {
                alt12=3;
                }
                break;
            case 60:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:620:5: this_AbortingState_0= ruleAbortingState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getAbortingStateParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbortingState_in_ruleState1387);
                    this_AbortingState_0=ruleAbortingState();

                    state._fsp--;

                     
                            current = this_AbortingState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:630:5: this_TerminalState_1= ruleTerminalState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getTerminalStateParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalState_in_ruleState1414);
                    this_TerminalState_1=ruleTerminalState();

                    state._fsp--;

                     
                            current = this_TerminalState_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:640:5: this_StandardState_Impl_2= ruleStandardState_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getStandardState_ImplParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStandardState_Impl_in_ruleState1441);
                    this_StandardState_Impl_2=ruleStandardState_Impl();

                    state._fsp--;

                     
                            current = this_StandardState_Impl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:650:5: this_InitState_3= ruleInitState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getInitStateParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInitState_in_ruleState1468);
                    this_InitState_3=ruleInitState();

                    state._fsp--;

                     
                            current = this_InitState_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleInstrument"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:666:1: entryRuleInstrument returns [EObject current=null] : iv_ruleInstrument= ruleInstrument EOF ;
    public final EObject entryRuleInstrument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstrument = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:667:2: (iv_ruleInstrument= ruleInstrument EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:668:2: iv_ruleInstrument= ruleInstrument EOF
            {
             newCompositeNode(grammarAccess.getInstrumentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInstrument_in_entryRuleInstrument1503);
            iv_ruleInstrument=ruleInstrument();

            state._fsp--;

             current =iv_ruleInstrument; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInstrument1513); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstrument"


    // $ANTLR start "ruleInstrument"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:675:1: ruleInstrument returns [EObject current=null] : ( () ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )? otherlv_2= 'Instrument' otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )? (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )? (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )? (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )? (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )? (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )? (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )? otherlv_40= '}' ) ;
    public final EObject ruleInstrument() throws RecognitionException {
        EObject current = null;

        Token lv_initiallyActivated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        AntlrDatatypeRuleToken lv_description_5_0 = null;

        AntlrDatatypeRuleToken lv_author_7_0 = null;

        AntlrDatatypeRuleToken lv_version_9_0 = null;

        AntlrDatatypeRuleToken lv_dateCreation_11_0 = null;

        AntlrDatatypeRuleToken lv_interimFeedback_13_0 = null;

        EObject lv_links_22_0 = null;

        EObject lv_links_24_0 = null;

        EObject lv_clazz_27_0 = null;

        EObject lv_helpers_30_0 = null;

        EObject lv_helpers_32_0 = null;

        EObject lv_providedWidgets_36_0 = null;

        EObject lv_providedWidgets_38_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:678:28: ( ( () ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )? otherlv_2= 'Instrument' otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )? (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )? (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )? (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )? (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )? (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )? (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )? otherlv_40= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:679:1: ( () ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )? otherlv_2= 'Instrument' otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )? (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )? (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )? (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )? (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )? (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )? (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )? otherlv_40= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:679:1: ( () ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )? otherlv_2= 'Instrument' otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )? (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )? (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )? (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )? (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )? (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )? (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )? otherlv_40= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:679:2: () ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )? otherlv_2= 'Instrument' otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )? (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )? (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )? (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )? (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )? (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )? (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )? otherlv_40= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:679:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:680:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInstrumentAccess().getInstrumentAction_0(),
                        current);
                

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:685:2: ( (lv_initiallyActivated_1_0= 'initiallyActivated' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:686:1: (lv_initiallyActivated_1_0= 'initiallyActivated' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:686:1: (lv_initiallyActivated_1_0= 'initiallyActivated' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:687:3: lv_initiallyActivated_1_0= 'initiallyActivated'
                    {
                    lv_initiallyActivated_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleInstrument1565); 

                            newLeafNode(lv_initiallyActivated_1_0, grammarAccess.getInstrumentAccess().getInitiallyActivatedInitiallyActivatedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstrumentRule());
                    	        }
                           		setWithLastConsumed(current, "initiallyActivated", true, "initiallyActivated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleInstrument1591); 

                	newLeafNode(otherlv_2, grammarAccess.getInstrumentAccess().getInstrumentKeyword_2());
                
            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInstrument1603); 

                	newLeafNode(otherlv_3, grammarAccess.getInstrumentAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:708:1: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:708:3: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleInstrument1616); 

                        	newLeafNode(otherlv_4, grammarAccess.getInstrumentAccess().getDescriptionKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:712:1: ( (lv_description_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:713:1: (lv_description_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:713:1: (lv_description_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:714:3: lv_description_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getDescriptionEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1637);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:730:4: (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:730:6: otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleInstrument1652); 

                        	newLeafNode(otherlv_6, grammarAccess.getInstrumentAccess().getAuthorKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:734:1: ( (lv_author_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:735:1: (lv_author_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:735:1: (lv_author_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:736:3: lv_author_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getAuthorEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1673);
                    lv_author_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"author",
                            		lv_author_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:752:4: (otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:752:6: otherlv_8= 'version' ( (lv_version_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleInstrument1688); 

                        	newLeafNode(otherlv_8, grammarAccess.getInstrumentAccess().getVersionKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:756:1: ( (lv_version_9_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:757:1: (lv_version_9_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:757:1: (lv_version_9_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:758:3: lv_version_9_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getVersionEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1709);
                    lv_version_9_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"version",
                            		lv_version_9_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:774:4: (otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:774:6: otherlv_10= 'dateCreation' ( (lv_dateCreation_11_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleInstrument1724); 

                        	newLeafNode(otherlv_10, grammarAccess.getInstrumentAccess().getDateCreationKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:778:1: ( (lv_dateCreation_11_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:779:1: (lv_dateCreation_11_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:779:1: (lv_dateCreation_11_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:780:3: lv_dateCreation_11_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getDateCreationEStringParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1745);
                    lv_dateCreation_11_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"dateCreation",
                            		lv_dateCreation_11_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:796:4: (otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:796:6: otherlv_12= 'interimFeedback' ( (lv_interimFeedback_13_0= ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleInstrument1760); 

                        	newLeafNode(otherlv_12, grammarAccess.getInstrumentAccess().getInterimFeedbackKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:800:1: ( (lv_interimFeedback_13_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:801:1: (lv_interimFeedback_13_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:801:1: (lv_interimFeedback_13_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:802:3: lv_interimFeedback_13_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getInterimFeedbackEStringParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1781);
                    lv_interimFeedback_13_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"interimFeedback",
                            		lv_interimFeedback_13_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:818:4: (otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:818:6: otherlv_14= 'subscribedWidgets' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')'
                    {
                    otherlv_14=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleInstrument1796); 

                        	newLeafNode(otherlv_14, grammarAccess.getInstrumentAccess().getSubscribedWidgetsKeyword_9_0());
                        
                    otherlv_15=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleInstrument1808); 

                        	newLeafNode(otherlv_15, grammarAccess.getInstrumentAccess().getLeftParenthesisKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:826:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:827:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:827:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:828:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstrumentRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getSubscribedWidgetsWidgetCrossReference_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1831);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:841:2: (otherlv_17= ',' ( ( ruleEString ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==14) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:841:4: otherlv_17= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInstrument1844); 

                    	        	newLeafNode(otherlv_17, grammarAccess.getInstrumentAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:845:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:846:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:846:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:847:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getInstrumentRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstrumentAccess().getSubscribedWidgetsWidgetCrossReference_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInstrument1867);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleInstrument1881); 

                        	newLeafNode(otherlv_19, grammarAccess.getInstrumentAccess().getRightParenthesisKeyword_9_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:864:3: (otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:864:5: otherlv_20= 'links' otherlv_21= '{' ( (lv_links_22_0= ruleLink ) ) (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )* otherlv_25= '}'
                    {
                    otherlv_20=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleInstrument1896); 

                        	newLeafNode(otherlv_20, grammarAccess.getInstrumentAccess().getLinksKeyword_10_0());
                        
                    otherlv_21=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInstrument1908); 

                        	newLeafNode(otherlv_21, grammarAccess.getInstrumentAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:872:1: ( (lv_links_22_0= ruleLink ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:873:1: (lv_links_22_0= ruleLink )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:873:1: (lv_links_22_0= ruleLink )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:874:3: lv_links_22_0= ruleLink
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getLinksLinkParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleLink_in_ruleInstrument1929);
                    lv_links_22_0=ruleLink();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		add(
                           			current, 
                           			"links",
                            		lv_links_22_0, 
                            		"Link");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:890:2: (otherlv_23= ',' ( (lv_links_24_0= ruleLink ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==14) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:890:4: otherlv_23= ',' ( (lv_links_24_0= ruleLink ) )
                    	    {
                    	    otherlv_23=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInstrument1942); 

                    	        	newLeafNode(otherlv_23, grammarAccess.getInstrumentAccess().getCommaKeyword_10_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:894:1: ( (lv_links_24_0= ruleLink ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:895:1: (lv_links_24_0= ruleLink )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:895:1: (lv_links_24_0= ruleLink )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:896:3: lv_links_24_0= ruleLink
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstrumentAccess().getLinksLinkParserRuleCall_10_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleLink_in_ruleInstrument1963);
                    	    lv_links_24_0=ruleLink();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"links",
                    	            		lv_links_24_0, 
                    	            		"Link");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_25=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInstrument1977); 

                        	newLeafNode(otherlv_25, grammarAccess.getInstrumentAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:916:3: (otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:916:5: otherlv_26= 'clazz' ( (lv_clazz_27_0= ruleEClass ) )
                    {
                    otherlv_26=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleInstrument1992); 

                        	newLeafNode(otherlv_26, grammarAccess.getInstrumentAccess().getClazzKeyword_11_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:920:1: ( (lv_clazz_27_0= ruleEClass ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:921:1: (lv_clazz_27_0= ruleEClass )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:921:1: (lv_clazz_27_0= ruleEClass )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:922:3: lv_clazz_27_0= ruleEClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getClazzEClassParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleInstrument2013);
                    lv_clazz_27_0=ruleEClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		set(
                           			current, 
                           			"clazz",
                            		lv_clazz_27_0, 
                            		"EClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:938:4: (otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:938:6: otherlv_28= 'helpers' otherlv_29= '{' ( (lv_helpers_30_0= ruleEClassifier ) ) (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )* otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleInstrument2028); 

                        	newLeafNode(otherlv_28, grammarAccess.getInstrumentAccess().getHelpersKeyword_12_0());
                        
                    otherlv_29=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInstrument2040); 

                        	newLeafNode(otherlv_29, grammarAccess.getInstrumentAccess().getLeftCurlyBracketKeyword_12_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:946:1: ( (lv_helpers_30_0= ruleEClassifier ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:947:1: (lv_helpers_30_0= ruleEClassifier )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:947:1: (lv_helpers_30_0= ruleEClassifier )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:948:3: lv_helpers_30_0= ruleEClassifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getHelpersEClassifierParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEClassifier_in_ruleInstrument2061);
                    lv_helpers_30_0=ruleEClassifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		add(
                           			current, 
                           			"helpers",
                            		lv_helpers_30_0, 
                            		"EClassifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:964:2: (otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==14) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:964:4: otherlv_31= ',' ( (lv_helpers_32_0= ruleEClassifier ) )
                    	    {
                    	    otherlv_31=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInstrument2074); 

                    	        	newLeafNode(otherlv_31, grammarAccess.getInstrumentAccess().getCommaKeyword_12_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:968:1: ( (lv_helpers_32_0= ruleEClassifier ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:969:1: (lv_helpers_32_0= ruleEClassifier )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:969:1: (lv_helpers_32_0= ruleEClassifier )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:970:3: lv_helpers_32_0= ruleEClassifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstrumentAccess().getHelpersEClassifierParserRuleCall_12_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEClassifier_in_ruleInstrument2095);
                    	    lv_helpers_32_0=ruleEClassifier();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"helpers",
                    	            		lv_helpers_32_0, 
                    	            		"EClassifier");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInstrument2109); 

                        	newLeafNode(otherlv_33, grammarAccess.getInstrumentAccess().getRightCurlyBracketKeyword_12_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:990:3: (otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:990:5: otherlv_34= 'providedWidgets' otherlv_35= '{' ( (lv_providedWidgets_36_0= ruleWidget ) ) (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )* otherlv_39= '}'
                    {
                    otherlv_34=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleInstrument2124); 

                        	newLeafNode(otherlv_34, grammarAccess.getInstrumentAccess().getProvidedWidgetsKeyword_13_0());
                        
                    otherlv_35=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInstrument2136); 

                        	newLeafNode(otherlv_35, grammarAccess.getInstrumentAccess().getLeftCurlyBracketKeyword_13_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:998:1: ( (lv_providedWidgets_36_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:999:1: (lv_providedWidgets_36_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:999:1: (lv_providedWidgets_36_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1000:3: lv_providedWidgets_36_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstrumentAccess().getProvidedWidgetsWidgetParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleInstrument2157);
                    lv_providedWidgets_36_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	        }
                           		add(
                           			current, 
                           			"providedWidgets",
                            		lv_providedWidgets_36_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1016:2: (otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==14) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1016:4: otherlv_37= ',' ( (lv_providedWidgets_38_0= ruleWidget ) )
                    	    {
                    	    otherlv_37=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInstrument2170); 

                    	        	newLeafNode(otherlv_37, grammarAccess.getInstrumentAccess().getCommaKeyword_13_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1020:1: ( (lv_providedWidgets_38_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1021:1: (lv_providedWidgets_38_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1021:1: (lv_providedWidgets_38_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1022:3: lv_providedWidgets_38_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstrumentAccess().getProvidedWidgetsWidgetParserRuleCall_13_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleInstrument2191);
                    	    lv_providedWidgets_38_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstrumentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"providedWidgets",
                    	            		lv_providedWidgets_38_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInstrument2205); 

                        	newLeafNode(otherlv_39, grammarAccess.getInstrumentAccess().getRightCurlyBracketKeyword_13_4());
                        

                    }
                    break;

            }

            otherlv_40=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInstrument2219); 

                	newLeafNode(otherlv_40, grammarAccess.getInstrumentAccess().getRightCurlyBracketKeyword_14());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstrument"


    // $ANTLR start "entryRuleAction"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1054:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1055:2: (iv_ruleAction= ruleAction EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1056:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2255);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2265); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1063:1: ruleAction returns [EObject current=null] : ( ( (lv_undoable_0_0= 'undoable' ) ) ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )? otherlv_2= 'Action' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )? (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )? (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )? (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )? (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= 'clazz' ( (lv_clazz_20_0= ruleEClass ) ) (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )? otherlv_27= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_undoable_0_0=null;
        Token lv_modifyInstrument_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_execute_6_0 = null;

        AntlrDatatypeRuleToken lv_canDo_8_0 = null;

        AntlrDatatypeRuleToken lv_undo_10_0 = null;

        AntlrDatatypeRuleToken lv_redo_12_0 = null;

        EObject lv_clazz_20_0 = null;

        EObject lv_dependencies_23_0 = null;

        EObject lv_dependencies_25_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1066:28: ( ( ( (lv_undoable_0_0= 'undoable' ) ) ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )? otherlv_2= 'Action' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )? (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )? (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )? (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )? (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= 'clazz' ( (lv_clazz_20_0= ruleEClass ) ) (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )? otherlv_27= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1067:1: ( ( (lv_undoable_0_0= 'undoable' ) ) ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )? otherlv_2= 'Action' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )? (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )? (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )? (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )? (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= 'clazz' ( (lv_clazz_20_0= ruleEClass ) ) (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )? otherlv_27= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1067:1: ( ( (lv_undoable_0_0= 'undoable' ) ) ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )? otherlv_2= 'Action' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )? (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )? (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )? (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )? (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= 'clazz' ( (lv_clazz_20_0= ruleEClass ) ) (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )? otherlv_27= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1067:2: ( (lv_undoable_0_0= 'undoable' ) ) ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )? otherlv_2= 'Action' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )? (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )? (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )? (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )? (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= 'clazz' ( (lv_clazz_20_0= ruleEClass ) ) (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )? otherlv_27= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1067:2: ( (lv_undoable_0_0= 'undoable' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1068:1: (lv_undoable_0_0= 'undoable' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1068:1: (lv_undoable_0_0= 'undoable' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1069:3: lv_undoable_0_0= 'undoable'
            {
            lv_undoable_0_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction2308); 

                    newLeafNode(lv_undoable_0_0, grammarAccess.getActionAccess().getUndoableUndoableKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActionRule());
            	        }
                   		setWithLastConsumed(current, "undoable", true, "undoable");
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1082:2: ( (lv_modifyInstrument_1_0= 'modifyInstrument' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1083:1: (lv_modifyInstrument_1_0= 'modifyInstrument' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1083:1: (lv_modifyInstrument_1_0= 'modifyInstrument' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1084:3: lv_modifyInstrument_1_0= 'modifyInstrument'
                    {
                    lv_modifyInstrument_1_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAction2339); 

                            newLeafNode(lv_modifyInstrument_1_0, grammarAccess.getActionAccess().getModifyInstrumentModifyInstrumentKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionRule());
                    	        }
                           		setWithLastConsumed(current, "modifyInstrument", true, "modifyInstrument");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAction2365); 

                	newLeafNode(otherlv_2, grammarAccess.getActionAccess().getActionKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1101:1: ( (lv_name_3_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1102:1: (lv_name_3_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1102:1: (lv_name_3_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1103:3: lv_name_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getActionAccess().getNameEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2386);
            lv_name_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAction2398); 

                	newLeafNode(otherlv_4, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1123:1: (otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1123:3: otherlv_5= 'execute' ( (lv_execute_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAction2411); 

                        	newLeafNode(otherlv_5, grammarAccess.getActionAccess().getExecuteKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1127:1: ( (lv_execute_6_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1128:1: (lv_execute_6_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1128:1: (lv_execute_6_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1129:3: lv_execute_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getExecuteEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2432);
                    lv_execute_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"execute",
                            		lv_execute_6_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1145:4: (otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1145:6: otherlv_7= 'canDo' ( (lv_canDo_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleAction2447); 

                        	newLeafNode(otherlv_7, grammarAccess.getActionAccess().getCanDoKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1149:1: ( (lv_canDo_8_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1150:1: (lv_canDo_8_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1150:1: (lv_canDo_8_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1151:3: lv_canDo_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getCanDoEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2468);
                    lv_canDo_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"canDo",
                            		lv_canDo_8_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1167:4: (otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1167:6: otherlv_9= 'undo' ( (lv_undo_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAction2483); 

                        	newLeafNode(otherlv_9, grammarAccess.getActionAccess().getUndoKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1171:1: ( (lv_undo_10_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1172:1: (lv_undo_10_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1172:1: (lv_undo_10_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1173:3: lv_undo_10_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getUndoEStringParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2504);
                    lv_undo_10_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"undo",
                            		lv_undo_10_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1189:4: (otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1189:6: otherlv_11= 'redo' ( (lv_redo_12_0= ruleEString ) )
                    {
                    otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAction2519); 

                        	newLeafNode(otherlv_11, grammarAccess.getActionAccess().getRedoKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1193:1: ( (lv_redo_12_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1194:1: (lv_redo_12_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1194:1: (lv_redo_12_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1195:3: lv_redo_12_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getRedoEStringParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2540);
                    lv_redo_12_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"redo",
                            		lv_redo_12_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1211:4: (otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==41) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1211:6: otherlv_13= 'cancelledBy' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')'
                    {
                    otherlv_13=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleAction2555); 

                        	newLeafNode(otherlv_13, grammarAccess.getActionAccess().getCancelledByKeyword_9_0());
                        
                    otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAction2567); 

                        	newLeafNode(otherlv_14, grammarAccess.getActionAccess().getLeftParenthesisKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1219:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1220:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1220:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1221:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getCancelledByActionCrossReference_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2590);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1234:2: (otherlv_16= ',' ( ( ruleEString ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==14) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1234:4: otherlv_16= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAction2603); 

                    	        	newLeafNode(otherlv_16, grammarAccess.getActionAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1238:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1239:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1239:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1240:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getActionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getActionAccess().getCancelledByActionCrossReference_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAction2626);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAction2640); 

                        	newLeafNode(otherlv_18, grammarAccess.getActionAccess().getRightParenthesisKeyword_9_4());
                        

                    }
                    break;

            }

            otherlv_19=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2654); 

                	newLeafNode(otherlv_19, grammarAccess.getActionAccess().getClazzKeyword_10());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1261:1: ( (lv_clazz_20_0= ruleEClass ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1262:1: (lv_clazz_20_0= ruleEClass )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1262:1: (lv_clazz_20_0= ruleEClass )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1263:3: lv_clazz_20_0= ruleEClass
            {
             
            	        newCompositeNode(grammarAccess.getActionAccess().getClazzEClassParserRuleCall_11_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleAction2675);
            lv_clazz_20_0=ruleEClass();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActionRule());
            	        }
                   		set(
                   			current, 
                   			"clazz",
                    		lv_clazz_20_0, 
                    		"EClass");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1279:2: (otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==42) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1279:4: otherlv_21= 'dependencies' otherlv_22= '{' ( (lv_dependencies_23_0= ruleActionDependency ) ) (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )* otherlv_26= '}'
                    {
                    otherlv_21=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleAction2688); 

                        	newLeafNode(otherlv_21, grammarAccess.getActionAccess().getDependenciesKeyword_12_0());
                        
                    otherlv_22=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAction2700); 

                        	newLeafNode(otherlv_22, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_12_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1287:1: ( (lv_dependencies_23_0= ruleActionDependency ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1288:1: (lv_dependencies_23_0= ruleActionDependency )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1288:1: (lv_dependencies_23_0= ruleActionDependency )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1289:3: lv_dependencies_23_0= ruleActionDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getDependenciesActionDependencyParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleActionDependency_in_ruleAction2721);
                    lv_dependencies_23_0=ruleActionDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		add(
                           			current, 
                           			"dependencies",
                            		lv_dependencies_23_0, 
                            		"ActionDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1305:2: (otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==14) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1305:4: otherlv_24= ',' ( (lv_dependencies_25_0= ruleActionDependency ) )
                    	    {
                    	    otherlv_24=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAction2734); 

                    	        	newLeafNode(otherlv_24, grammarAccess.getActionAccess().getCommaKeyword_12_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1309:1: ( (lv_dependencies_25_0= ruleActionDependency ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1310:1: (lv_dependencies_25_0= ruleActionDependency )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1310:1: (lv_dependencies_25_0= ruleActionDependency )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1311:3: lv_dependencies_25_0= ruleActionDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActionAccess().getDependenciesActionDependencyParserRuleCall_12_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleActionDependency_in_ruleAction2755);
                    	    lv_dependencies_25_0=ruleActionDependency();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dependencies",
                    	            		lv_dependencies_25_0, 
                    	            		"ActionDependency");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAction2769); 

                        	newLeafNode(otherlv_26, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_12_4());
                        

                    }
                    break;

            }

            otherlv_27=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAction2783); 

                	newLeafNode(otherlv_27, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEvent"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1343:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1344:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1345:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvent_in_entryRuleEvent2819);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvent2829); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1352:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'Event' otherlv_1= '{' otherlv_2= 'clazz' ( (lv_clazz_3_0= ruleEClass ) ) otherlv_4= '}' ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_clazz_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1355:28: ( (otherlv_0= 'Event' otherlv_1= '{' otherlv_2= 'clazz' ( (lv_clazz_3_0= ruleEClass ) ) otherlv_4= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1356:1: (otherlv_0= 'Event' otherlv_1= '{' otherlv_2= 'clazz' ( (lv_clazz_3_0= ruleEClass ) ) otherlv_4= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1356:1: (otherlv_0= 'Event' otherlv_1= '{' otherlv_2= 'clazz' ( (lv_clazz_3_0= ruleEClass ) ) otherlv_4= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1356:3: otherlv_0= 'Event' otherlv_1= '{' otherlv_2= 'clazz' ( (lv_clazz_3_0= ruleEClass ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEvent2866); 

                	newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
                
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEvent2878); 

                	newLeafNode(otherlv_1, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEvent2890); 

                	newLeafNode(otherlv_2, grammarAccess.getEventAccess().getClazzKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1368:1: ( (lv_clazz_3_0= ruleEClass ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1369:1: (lv_clazz_3_0= ruleEClass )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1369:1: (lv_clazz_3_0= ruleEClass )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1370:3: lv_clazz_3_0= ruleEClass
            {
             
            	        newCompositeNode(grammarAccess.getEventAccess().getClazzEClassParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleEvent2911);
            lv_clazz_3_0=ruleEClass();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEventRule());
            	        }
                   		set(
                   			current, 
                   			"clazz",
                    		lv_clazz_3_0, 
                    		"EClass");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEvent2923); 

                	newLeafNode(otherlv_4, grammarAccess.getEventAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleLink"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1398:1: entryRuleLink returns [EObject current=null] : iv_ruleLink= ruleLink EOF ;
    public final EObject entryRuleLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLink = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1399:2: (iv_ruleLink= ruleLink EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1400:2: iv_ruleLink= ruleLink EOF
            {
             newCompositeNode(grammarAccess.getLinkRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLink_in_entryRuleLink2959);
            iv_ruleLink=ruleLink();

            state._fsp--;

             current =iv_ruleLink; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLink2969); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLink"


    // $ANTLR start "ruleLink"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1407:1: ruleLink returns [EObject current=null] : ( ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) ) otherlv_1= 'Link' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )? (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )? (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )? (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )? otherlv_13= 'interaction' ( ( ruleEString ) ) otherlv_15= 'action' ( ( ruleEString ) ) (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )? otherlv_19= '}' ) ;
    public final EObject ruleLink() throws RecognitionException {
        EObject current = null;

        Token lv_executeOnUpdate_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_description_4_0 = null;

        AntlrDatatypeRuleToken lv_interimFeedback_6_0 = null;

        AntlrDatatypeRuleToken lv_isConditionRespected_8_0 = null;

        AntlrDatatypeRuleToken lv_updateAction_10_0 = null;

        AntlrDatatypeRuleToken lv_initialiseAction_12_0 = null;

        EObject lv_clazz_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1410:28: ( ( ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) ) otherlv_1= 'Link' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )? (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )? (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )? (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )? otherlv_13= 'interaction' ( ( ruleEString ) ) otherlv_15= 'action' ( ( ruleEString ) ) (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )? otherlv_19= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1411:1: ( ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) ) otherlv_1= 'Link' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )? (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )? (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )? (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )? otherlv_13= 'interaction' ( ( ruleEString ) ) otherlv_15= 'action' ( ( ruleEString ) ) (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )? otherlv_19= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1411:1: ( ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) ) otherlv_1= 'Link' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )? (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )? (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )? (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )? otherlv_13= 'interaction' ( ( ruleEString ) ) otherlv_15= 'action' ( ( ruleEString ) ) (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )? otherlv_19= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1411:2: ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) ) otherlv_1= 'Link' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )? (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )? (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )? (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )? otherlv_13= 'interaction' ( ( ruleEString ) ) otherlv_15= 'action' ( ( ruleEString ) ) (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )? otherlv_19= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1411:2: ( (lv_executeOnUpdate_0_0= 'executeOnUpdate' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1412:1: (lv_executeOnUpdate_0_0= 'executeOnUpdate' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1412:1: (lv_executeOnUpdate_0_0= 'executeOnUpdate' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1413:3: lv_executeOnUpdate_0_0= 'executeOnUpdate'
            {
            lv_executeOnUpdate_0_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleLink3012); 

                    newLeafNode(lv_executeOnUpdate_0_0, grammarAccess.getLinkAccess().getExecuteOnUpdateExecuteOnUpdateKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRule());
            	        }
                   		setWithLastConsumed(current, "executeOnUpdate", true, "executeOnUpdate");
            	    

            }


            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleLink3037); 

                	newLeafNode(otherlv_1, grammarAccess.getLinkAccess().getLinkKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLink3049); 

                	newLeafNode(otherlv_2, grammarAccess.getLinkAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1434:1: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==22) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1434:3: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleLink3062); 

                        	newLeafNode(otherlv_3, grammarAccess.getLinkAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1438:1: ( (lv_description_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1439:1: (lv_description_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1439:1: (lv_description_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1440:3: lv_description_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3083);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1456:4: (otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==26) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1456:6: otherlv_5= 'interimFeedback' ( (lv_interimFeedback_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLink3098); 

                        	newLeafNode(otherlv_5, grammarAccess.getLinkAccess().getInterimFeedbackKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1460:1: ( (lv_interimFeedback_6_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1461:1: (lv_interimFeedback_6_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1461:1: (lv_interimFeedback_6_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1462:3: lv_interimFeedback_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getInterimFeedbackEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3119);
                    lv_interimFeedback_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"interimFeedback",
                            		lv_interimFeedback_6_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1478:4: (otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==46) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1478:6: otherlv_7= 'isConditionRespected' ( (lv_isConditionRespected_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleLink3134); 

                        	newLeafNode(otherlv_7, grammarAccess.getLinkAccess().getIsConditionRespectedKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1482:1: ( (lv_isConditionRespected_8_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1483:1: (lv_isConditionRespected_8_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1483:1: (lv_isConditionRespected_8_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1484:3: lv_isConditionRespected_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getIsConditionRespectedEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3155);
                    lv_isConditionRespected_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"isConditionRespected",
                            		lv_isConditionRespected_8_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1500:4: (otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==47) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1500:6: otherlv_9= 'updateAction' ( (lv_updateAction_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleLink3170); 

                        	newLeafNode(otherlv_9, grammarAccess.getLinkAccess().getUpdateActionKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1504:1: ( (lv_updateAction_10_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1505:1: (lv_updateAction_10_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1505:1: (lv_updateAction_10_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1506:3: lv_updateAction_10_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getUpdateActionEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3191);
                    lv_updateAction_10_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"updateAction",
                            		lv_updateAction_10_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1522:4: (otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==48) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1522:6: otherlv_11= 'initialiseAction' ( (lv_initialiseAction_12_0= ruleEString ) )
                    {
                    otherlv_11=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleLink3206); 

                        	newLeafNode(otherlv_11, grammarAccess.getLinkAccess().getInitialiseActionKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1526:1: ( (lv_initialiseAction_12_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1527:1: (lv_initialiseAction_12_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1527:1: (lv_initialiseAction_12_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1528:3: lv_initialiseAction_12_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getInitialiseActionEStringParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3227);
                    lv_initialiseAction_12_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"initialiseAction",
                            		lv_initialiseAction_12_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLink3241); 

                	newLeafNode(otherlv_13, grammarAccess.getLinkAccess().getInteractionKeyword_8());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1548:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1549:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1549:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1550:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLinkAccess().getInteractionInteractionCrossReference_9_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3264);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_15=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleLink3276); 

                	newLeafNode(otherlv_15, grammarAccess.getLinkAccess().getActionKeyword_10());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1567:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1568:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1568:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1569:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLinkAccess().getActionActionCrossReference_11_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLink3299);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1582:2: (otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==31) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1582:4: otherlv_17= 'clazz' ( (lv_clazz_18_0= ruleEClass ) )
                    {
                    otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLink3312); 

                        	newLeafNode(otherlv_17, grammarAccess.getLinkAccess().getClazzKeyword_12_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1586:1: ( (lv_clazz_18_0= ruleEClass ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1587:1: (lv_clazz_18_0= ruleEClass )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1587:1: (lv_clazz_18_0= ruleEClass )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1588:3: lv_clazz_18_0= ruleEClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkAccess().getClazzEClassParserRuleCall_12_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleLink3333);
                    lv_clazz_18_0=ruleEClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkRule());
                    	        }
                           		set(
                           			current, 
                           			"clazz",
                            		lv_clazz_18_0, 
                            		"EClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLink3347); 

                	newLeafNode(otherlv_19, grammarAccess.getLinkAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLink"


    // $ANTLR start "entryRuleInteraction"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1616:1: entryRuleInteraction returns [EObject current=null] : iv_ruleInteraction= ruleInteraction EOF ;
    public final EObject entryRuleInteraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteraction = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1617:2: (iv_ruleInteraction= ruleInteraction EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1618:2: iv_ruleInteraction= ruleInteraction EOF
            {
             newCompositeNode(grammarAccess.getInteractionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInteraction_in_entryRuleInteraction3383);
            iv_ruleInteraction=ruleInteraction();

            state._fsp--;

             current =iv_ruleInteraction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInteraction3393); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteraction"


    // $ANTLR start "ruleInteraction"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1625:1: ruleInteraction returns [EObject current=null] : ( ( (lv_activated_0_0= 'activated' ) ) otherlv_1= 'Interaction' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )? (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )? (otherlv_12= 'initState' ( ( ruleEString ) ) )? (otherlv_14= 'currentState' ( ( ruleEString ) ) )? (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )? otherlv_21= 'clazz' ( (lv_clazz_22_0= ruleEClass ) ) (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )? otherlv_29= '}' ) ;
    public final EObject ruleInteraction() throws RecognitionException {
        EObject current = null;

        Token lv_activated_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;

        AntlrDatatypeRuleToken lv_author_7_0 = null;

        AntlrDatatypeRuleToken lv_dateCreation_9_0 = null;

        AntlrDatatypeRuleToken lv_version_11_0 = null;

        EObject lv_states_18_0 = null;

        EObject lv_states_19_0 = null;

        EObject lv_clazz_22_0 = null;

        EObject lv_helpers_25_0 = null;

        EObject lv_helpers_27_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1628:28: ( ( ( (lv_activated_0_0= 'activated' ) ) otherlv_1= 'Interaction' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )? (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )? (otherlv_12= 'initState' ( ( ruleEString ) ) )? (otherlv_14= 'currentState' ( ( ruleEString ) ) )? (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )? otherlv_21= 'clazz' ( (lv_clazz_22_0= ruleEClass ) ) (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )? otherlv_29= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1629:1: ( ( (lv_activated_0_0= 'activated' ) ) otherlv_1= 'Interaction' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )? (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )? (otherlv_12= 'initState' ( ( ruleEString ) ) )? (otherlv_14= 'currentState' ( ( ruleEString ) ) )? (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )? otherlv_21= 'clazz' ( (lv_clazz_22_0= ruleEClass ) ) (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )? otherlv_29= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1629:1: ( ( (lv_activated_0_0= 'activated' ) ) otherlv_1= 'Interaction' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )? (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )? (otherlv_12= 'initState' ( ( ruleEString ) ) )? (otherlv_14= 'currentState' ( ( ruleEString ) ) )? (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )? otherlv_21= 'clazz' ( (lv_clazz_22_0= ruleEClass ) ) (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )? otherlv_29= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1629:2: ( (lv_activated_0_0= 'activated' ) ) otherlv_1= 'Interaction' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )? (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )? (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )? (otherlv_12= 'initState' ( ( ruleEString ) ) )? (otherlv_14= 'currentState' ( ( ruleEString ) ) )? (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )? otherlv_21= 'clazz' ( (lv_clazz_22_0= ruleEClass ) ) (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )? otherlv_29= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1629:2: ( (lv_activated_0_0= 'activated' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1630:1: (lv_activated_0_0= 'activated' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1630:1: (lv_activated_0_0= 'activated' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1631:3: lv_activated_0_0= 'activated'
            {
            lv_activated_0_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleInteraction3436); 

                    newLeafNode(lv_activated_0_0, grammarAccess.getInteractionAccess().getActivatedActivatedKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInteractionRule());
            	        }
                   		setWithLastConsumed(current, "activated", true, "activated");
            	    

            }


            }

            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleInteraction3461); 

                	newLeafNode(otherlv_1, grammarAccess.getInteractionAccess().getInteractionKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1648:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1649:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1649:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1650:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getInteractionAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3482);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInteractionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInteraction3494); 

                	newLeafNode(otherlv_3, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1670:1: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1670:3: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleInteraction3507); 

                        	newLeafNode(otherlv_4, grammarAccess.getInteractionAccess().getDescriptionKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1674:1: ( (lv_description_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1675:1: (lv_description_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1675:1: (lv_description_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1676:3: lv_description_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getDescriptionEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3528);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1692:4: (otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1692:6: otherlv_6= 'author' ( (lv_author_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleInteraction3543); 

                        	newLeafNode(otherlv_6, grammarAccess.getInteractionAccess().getAuthorKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1696:1: ( (lv_author_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1697:1: (lv_author_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1697:1: (lv_author_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1698:3: lv_author_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getAuthorEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3564);
                    lv_author_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		set(
                           			current, 
                           			"author",
                            		lv_author_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1714:4: (otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==25) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1714:6: otherlv_8= 'dateCreation' ( (lv_dateCreation_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleInteraction3579); 

                        	newLeafNode(otherlv_8, grammarAccess.getInteractionAccess().getDateCreationKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1718:1: ( (lv_dateCreation_9_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1719:1: (lv_dateCreation_9_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1719:1: (lv_dateCreation_9_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1720:3: lv_dateCreation_9_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getDateCreationEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3600);
                    lv_dateCreation_9_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		set(
                           			current, 
                           			"dateCreation",
                            		lv_dateCreation_9_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1736:4: (otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==24) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1736:6: otherlv_10= 'version' ( (lv_version_11_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleInteraction3615); 

                        	newLeafNode(otherlv_10, grammarAccess.getInteractionAccess().getVersionKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1740:1: ( (lv_version_11_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1741:1: (lv_version_11_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1741:1: (lv_version_11_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1742:3: lv_version_11_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getVersionEStringParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3636);
                    lv_version_11_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		set(
                           			current, 
                           			"version",
                            		lv_version_11_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1758:4: (otherlv_12= 'initState' ( ( ruleEString ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1758:6: otherlv_12= 'initState' ( ( ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleInteraction3651); 

                        	newLeafNode(otherlv_12, grammarAccess.getInteractionAccess().getInitStateKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1762:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1763:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1763:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1764:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInteractionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getInitStateInitStateCrossReference_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3674);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1777:4: (otherlv_14= 'currentState' ( ( ruleEString ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==54) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1777:6: otherlv_14= 'currentState' ( ( ruleEString ) )
                    {
                    otherlv_14=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleInteraction3689); 

                        	newLeafNode(otherlv_14, grammarAccess.getInteractionAccess().getCurrentStateKeyword_9_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1781:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1782:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1782:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1783:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInteractionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getCurrentStateStateCrossReference_9_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInteraction3712);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1796:4: (otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==55) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1796:6: otherlv_16= 'states' otherlv_17= '{' ( (lv_states_18_0= ruleState ) ) ( (lv_states_19_0= ruleState ) )* otherlv_20= '}'
                    {
                    otherlv_16=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleInteraction3727); 

                        	newLeafNode(otherlv_16, grammarAccess.getInteractionAccess().getStatesKeyword_10_0());
                        
                    otherlv_17=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInteraction3739); 

                        	newLeafNode(otherlv_17, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1804:1: ( (lv_states_18_0= ruleState ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1805:1: (lv_states_18_0= ruleState )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1805:1: (lv_states_18_0= ruleState )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1806:3: lv_states_18_0= ruleState
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getStatesStateParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleInteraction3760);
                    lv_states_18_0=ruleState();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		add(
                           			current, 
                           			"states",
                            		lv_states_18_0, 
                            		"State");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1822:2: ( (lv_states_19_0= ruleState ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==60||(LA49_0>=63 && LA49_0<=65)) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1823:1: (lv_states_19_0= ruleState )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1823:1: (lv_states_19_0= ruleState )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1824:3: lv_states_19_0= ruleState
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractionAccess().getStatesStateParserRuleCall_10_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleInteraction3781);
                    	    lv_states_19_0=ruleState();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"states",
                    	            		lv_states_19_0, 
                    	            		"State");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInteraction3794); 

                        	newLeafNode(otherlv_20, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }

            otherlv_21=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleInteraction3808); 

                	newLeafNode(otherlv_21, grammarAccess.getInteractionAccess().getClazzKeyword_11());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1848:1: ( (lv_clazz_22_0= ruleEClass ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1849:1: (lv_clazz_22_0= ruleEClass )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1849:1: (lv_clazz_22_0= ruleEClass )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1850:3: lv_clazz_22_0= ruleEClass
            {
             
            	        newCompositeNode(grammarAccess.getInteractionAccess().getClazzEClassParserRuleCall_12_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleInteraction3829);
            lv_clazz_22_0=ruleEClass();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInteractionRule());
            	        }
                   		set(
                   			current, 
                   			"clazz",
                    		lv_clazz_22_0, 
                    		"EClass");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1866:2: (otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1866:4: otherlv_23= 'helpers' otherlv_24= '{' ( (lv_helpers_25_0= ruleEClassifier ) ) (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )* otherlv_28= '}'
                    {
                    otherlv_23=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleInteraction3842); 

                        	newLeafNode(otherlv_23, grammarAccess.getInteractionAccess().getHelpersKeyword_13_0());
                        
                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInteraction3854); 

                        	newLeafNode(otherlv_24, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_13_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1874:1: ( (lv_helpers_25_0= ruleEClassifier ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1875:1: (lv_helpers_25_0= ruleEClassifier )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1875:1: (lv_helpers_25_0= ruleEClassifier )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1876:3: lv_helpers_25_0= ruleEClassifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getInteractionAccess().getHelpersEClassifierParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEClassifier_in_ruleInteraction3875);
                    lv_helpers_25_0=ruleEClassifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	        }
                           		add(
                           			current, 
                           			"helpers",
                            		lv_helpers_25_0, 
                            		"EClassifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1892:2: (otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==14) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1892:4: otherlv_26= ',' ( (lv_helpers_27_0= ruleEClassifier ) )
                    	    {
                    	    otherlv_26=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInteraction3888); 

                    	        	newLeafNode(otherlv_26, grammarAccess.getInteractionAccess().getCommaKeyword_13_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1896:1: ( (lv_helpers_27_0= ruleEClassifier ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1897:1: (lv_helpers_27_0= ruleEClassifier )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1897:1: (lv_helpers_27_0= ruleEClassifier )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1898:3: lv_helpers_27_0= ruleEClassifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInteractionAccess().getHelpersEClassifierParserRuleCall_13_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEClassifier_in_ruleInteraction3909);
                    	    lv_helpers_27_0=ruleEClassifier();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"helpers",
                    	            		lv_helpers_27_0, 
                    	            		"EClassifier");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInteraction3923); 

                        	newLeafNode(otherlv_28, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_13_4());
                        

                    }
                    break;

            }

            otherlv_29=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInteraction3937); 

                	newLeafNode(otherlv_29, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_14());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteraction"


    // $ANTLR start "entryRuleTransition"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1930:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1931:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1932:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_entryRuleTransition3973);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransition3983); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1939:1: ruleTransition returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= ')' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= '=>' ( ( ruleEString ) ) (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_description_10_0 = null;

        AntlrDatatypeRuleToken lv_condition_12_0 = null;

        AntlrDatatypeRuleToken lv_actions_14_0 = null;

        AntlrDatatypeRuleToken lv_hid_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1942:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= ')' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= '=>' ( ( ruleEString ) ) (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )? ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1943:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= ')' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= '=>' ( ( ruleEString ) ) (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )? )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1943:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= ')' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= '=>' ( ( ruleEString ) ) (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )? )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1943:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= ')' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= '=>' ( ( ruleEString ) ) (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )?
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1943:2: ( (lv_name_0_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1944:1: (lv_name_0_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1944:1: (lv_name_0_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1945:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getNameEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4029);
            lv_name_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTransition4041); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1965:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1966:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1966:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1967:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getEventEventCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4064);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTransition4076); 

                	newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleTransition4088); 

                	newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getColonKeyword_4());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1988:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1989:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1989:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:1990:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getInputStateStateCrossReference_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4111);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTransition4123); 

                	newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_6());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2007:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2008:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2008:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2009:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getOutputStateStateCrossReference_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4146);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2022:2: (otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==12) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2022:4: otherlv_8= '{' (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )? (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )? (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )? (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )? otherlv_17= '}'
                    {
                    otherlv_8=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTransition4159); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2026:1: (otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==22) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2026:3: otherlv_9= 'description' ( (lv_description_10_0= ruleEString ) )
                            {
                            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTransition4172); 

                                	newLeafNode(otherlv_9, grammarAccess.getTransitionAccess().getDescriptionKeyword_8_1_0());
                                
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2030:1: ( (lv_description_10_0= ruleEString ) )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2031:1: (lv_description_10_0= ruleEString )
                            {
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2031:1: (lv_description_10_0= ruleEString )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2032:3: lv_description_10_0= ruleEString
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getDescriptionEStringParserRuleCall_8_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4193);
                            lv_description_10_0=ruleEString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"description",
                                    		lv_description_10_0, 
                                    		"EString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2048:4: (otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==58) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2048:6: otherlv_11= 'condition' ( (lv_condition_12_0= ruleEString ) )
                            {
                            otherlv_11=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleTransition4208); 

                                	newLeafNode(otherlv_11, grammarAccess.getTransitionAccess().getConditionKeyword_8_2_0());
                                
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2052:1: ( (lv_condition_12_0= ruleEString ) )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2053:1: (lv_condition_12_0= ruleEString )
                            {
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2053:1: (lv_condition_12_0= ruleEString )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2054:3: lv_condition_12_0= ruleEString
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getConditionEStringParserRuleCall_8_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4229);
                            lv_condition_12_0=ruleEString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"condition",
                                    		lv_condition_12_0, 
                                    		"EString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2070:4: (otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==17) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2070:6: otherlv_13= 'actions' ( (lv_actions_14_0= ruleEString ) )
                            {
                            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTransition4244); 

                                	newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getActionsKeyword_8_3_0());
                                
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2074:1: ( (lv_actions_14_0= ruleEString ) )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2075:1: (lv_actions_14_0= ruleEString )
                            {
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2075:1: (lv_actions_14_0= ruleEString )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2076:3: lv_actions_14_0= ruleEString
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getActionsEStringParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTransition4265);
                            lv_actions_14_0=ruleEString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"actions",
                                    		lv_actions_14_0, 
                                    		"EString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2092:4: (otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==59) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2092:6: otherlv_15= 'hid' ( (lv_hid_16_0= ruleEInt ) )
                            {
                            otherlv_15=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleTransition4280); 

                                	newLeafNode(otherlv_15, grammarAccess.getTransitionAccess().getHidKeyword_8_4_0());
                                
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2096:1: ( (lv_hid_16_0= ruleEInt ) )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2097:1: (lv_hid_16_0= ruleEInt )
                            {
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2097:1: (lv_hid_16_0= ruleEInt )
                            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2098:3: lv_hid_16_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getHidEIntParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleTransition4301);
                            lv_hid_16_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"hid",
                                    		lv_hid_16_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTransition4315); 

                        	newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_8_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleInitState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2126:1: entryRuleInitState returns [EObject current=null] : iv_ruleInitState= ruleInitState EOF ;
    public final EObject entryRuleInitState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitState = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2127:2: (iv_ruleInitState= ruleInitState EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2128:2: iv_ruleInitState= ruleInitState EOF
            {
             newCompositeNode(grammarAccess.getInitStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInitState_in_entryRuleInitState4353);
            iv_ruleInitState=ruleInitState();

            state._fsp--;

             current =iv_ruleInitState; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInitState4363); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitState"


    // $ANTLR start "ruleInitState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2135:1: ruleInitState returns [EObject current=null] : ( () otherlv_1= 'InitState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) ;
    public final EObject ruleInitState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_outputTransitions_6_0 = null;

        EObject lv_outputTransitions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2138:28: ( ( () otherlv_1= 'InitState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2139:1: ( () otherlv_1= 'InitState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2139:1: ( () otherlv_1= 'InitState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2139:2: () otherlv_1= 'InitState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2139:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2140:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInitStateAccess().getInitStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleInitState4409); 

                	newLeafNode(otherlv_1, grammarAccess.getInitStateAccess().getInitStateKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2149:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2150:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2150:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2151:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getInitStateAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInitState4430);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitStateRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2167:2: (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==61) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2167:4: otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleInitState4443); 

                        	newLeafNode(otherlv_3, grammarAccess.getInitStateAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2171:1: ( (lv_description_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2172:1: (lv_description_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2172:1: (lv_description_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2173:3: lv_description_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitStateAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleInitState4464);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitStateRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleInitState4476); 

                        	newLeafNode(otherlv_5, grammarAccess.getInitStateAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2193:3: ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_ID)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2193:4: ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2193:4: ( (lv_outputTransitions_6_0= ruleTransition ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2194:1: (lv_outputTransitions_6_0= ruleTransition )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2194:1: (lv_outputTransitions_6_0= ruleTransition )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2195:3: lv_outputTransitions_6_0= ruleTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitStateAccess().getOutputTransitionsTransitionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleInitState4500);
                    lv_outputTransitions_6_0=ruleTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitStateRule());
                    	        }
                           		add(
                           			current, 
                           			"outputTransitions",
                            		lv_outputTransitions_6_0, 
                            		"Transition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2211:2: (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==14) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2211:4: otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInitState4513); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getInitStateAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2215:1: ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2216:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2216:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2217:3: lv_outputTransitions_8_0= ruleTransition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInitStateAccess().getOutputTransitionsTransitionParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleInitState4534);
                    	    lv_outputTransitions_8_0=ruleTransition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInitStateRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputTransitions",
                    	            		lv_outputTransitions_8_0, 
                    	            		"Transition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitState"


    // $ANTLR start "entryRuleAbortingState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2241:1: entryRuleAbortingState returns [EObject current=null] : iv_ruleAbortingState= ruleAbortingState EOF ;
    public final EObject entryRuleAbortingState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbortingState = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2242:2: (iv_ruleAbortingState= ruleAbortingState EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2243:2: iv_ruleAbortingState= ruleAbortingState EOF
            {
             newCompositeNode(grammarAccess.getAbortingStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbortingState_in_entryRuleAbortingState4574);
            iv_ruleAbortingState=ruleAbortingState();

            state._fsp--;

             current =iv_ruleAbortingState; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbortingState4584); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbortingState"


    // $ANTLR start "ruleAbortingState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2250:1: ruleAbortingState returns [EObject current=null] : ( () otherlv_1= 'AbortingState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) ;
    public final EObject ruleAbortingState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_outputTransitions_6_0 = null;

        EObject lv_outputTransitions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2253:28: ( ( () otherlv_1= 'AbortingState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2254:1: ( () otherlv_1= 'AbortingState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2254:1: ( () otherlv_1= 'AbortingState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2254:2: () otherlv_1= 'AbortingState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2254:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2255:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAbortingStateAccess().getAbortingStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleAbortingState4630); 

                	newLeafNode(otherlv_1, grammarAccess.getAbortingStateAccess().getAbortingStateKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2264:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2265:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2265:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2266:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAbortingStateAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAbortingState4651);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAbortingStateRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2282:2: (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==61) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2282:4: otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleAbortingState4664); 

                        	newLeafNode(otherlv_3, grammarAccess.getAbortingStateAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2286:1: ( (lv_description_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2287:1: (lv_description_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2287:1: (lv_description_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2288:3: lv_description_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbortingStateAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleAbortingState4685);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAbortingStateRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleAbortingState4697); 

                        	newLeafNode(otherlv_5, grammarAccess.getAbortingStateAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2308:3: ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_ID)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2308:4: ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2308:4: ( (lv_outputTransitions_6_0= ruleTransition ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2309:1: (lv_outputTransitions_6_0= ruleTransition )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2309:1: (lv_outputTransitions_6_0= ruleTransition )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2310:3: lv_outputTransitions_6_0= ruleTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbortingStateAccess().getOutputTransitionsTransitionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleAbortingState4721);
                    lv_outputTransitions_6_0=ruleTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAbortingStateRule());
                    	        }
                           		add(
                           			current, 
                           			"outputTransitions",
                            		lv_outputTransitions_6_0, 
                            		"Transition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2326:2: (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==14) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2326:4: otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAbortingState4734); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getAbortingStateAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2330:1: ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2331:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2331:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2332:3: lv_outputTransitions_8_0= ruleTransition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAbortingStateAccess().getOutputTransitionsTransitionParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleAbortingState4755);
                    	    lv_outputTransitions_8_0=ruleTransition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAbortingStateRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputTransitions",
                    	            		lv_outputTransitions_8_0, 
                    	            		"Transition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbortingState"


    // $ANTLR start "entryRuleTerminalState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2356:1: entryRuleTerminalState returns [EObject current=null] : iv_ruleTerminalState= ruleTerminalState EOF ;
    public final EObject entryRuleTerminalState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalState = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2357:2: (iv_ruleTerminalState= ruleTerminalState EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2358:2: iv_ruleTerminalState= ruleTerminalState EOF
            {
             newCompositeNode(grammarAccess.getTerminalStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalState_in_entryRuleTerminalState4795);
            iv_ruleTerminalState=ruleTerminalState();

            state._fsp--;

             current =iv_ruleTerminalState; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalState4805); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalState"


    // $ANTLR start "ruleTerminalState"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2365:1: ruleTerminalState returns [EObject current=null] : ( () otherlv_1= 'TerminalState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) ;
    public final EObject ruleTerminalState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_outputTransitions_6_0 = null;

        EObject lv_outputTransitions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2368:28: ( ( () otherlv_1= 'TerminalState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2369:1: ( () otherlv_1= 'TerminalState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2369:1: ( () otherlv_1= 'TerminalState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2369:2: () otherlv_1= 'TerminalState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2369:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2370:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTerminalStateAccess().getTerminalStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleTerminalState4851); 

                	newLeafNode(otherlv_1, grammarAccess.getTerminalStateAccess().getTerminalStateKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2379:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2380:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2380:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2381:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTerminalStateAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTerminalState4872);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTerminalStateRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2397:2: (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==61) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2397:4: otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleTerminalState4885); 

                        	newLeafNode(otherlv_3, grammarAccess.getTerminalStateAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2401:1: ( (lv_description_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2402:1: (lv_description_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2402:1: (lv_description_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2403:3: lv_description_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTerminalStateAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTerminalState4906);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTerminalStateRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleTerminalState4918); 

                        	newLeafNode(otherlv_5, grammarAccess.getTerminalStateAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2423:3: ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_ID)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2423:4: ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2423:4: ( (lv_outputTransitions_6_0= ruleTransition ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2424:1: (lv_outputTransitions_6_0= ruleTransition )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2424:1: (lv_outputTransitions_6_0= ruleTransition )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2425:3: lv_outputTransitions_6_0= ruleTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getTerminalStateAccess().getOutputTransitionsTransitionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleTerminalState4942);
                    lv_outputTransitions_6_0=ruleTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTerminalStateRule());
                    	        }
                           		add(
                           			current, 
                           			"outputTransitions",
                            		lv_outputTransitions_6_0, 
                            		"Transition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2441:2: (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==14) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2441:4: otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTerminalState4955); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getTerminalStateAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2445:1: ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2446:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2446:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2447:3: lv_outputTransitions_8_0= ruleTransition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTerminalStateAccess().getOutputTransitionsTransitionParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleTerminalState4976);
                    	    lv_outputTransitions_8_0=ruleTransition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTerminalStateRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputTransitions",
                    	            		lv_outputTransitions_8_0, 
                    	            		"Transition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalState"


    // $ANTLR start "entryRuleStandardState_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2471:1: entryRuleStandardState_Impl returns [EObject current=null] : iv_ruleStandardState_Impl= ruleStandardState_Impl EOF ;
    public final EObject entryRuleStandardState_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardState_Impl = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2472:2: (iv_ruleStandardState_Impl= ruleStandardState_Impl EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2473:2: iv_ruleStandardState_Impl= ruleStandardState_Impl EOF
            {
             newCompositeNode(grammarAccess.getStandardState_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStandardState_Impl_in_entryRuleStandardState_Impl5016);
            iv_ruleStandardState_Impl=ruleStandardState_Impl();

            state._fsp--;

             current =iv_ruleStandardState_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStandardState_Impl5026); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStandardState_Impl"


    // $ANTLR start "ruleStandardState_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2480:1: ruleStandardState_Impl returns [EObject current=null] : ( () otherlv_1= 'StandardState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) ;
    public final EObject ruleStandardState_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_outputTransitions_6_0 = null;

        EObject lv_outputTransitions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2483:28: ( ( () otherlv_1= 'StandardState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2484:1: ( () otherlv_1= 'StandardState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2484:1: ( () otherlv_1= 'StandardState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )? )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2484:2: () otherlv_1= 'StandardState' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )? ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2484:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2485:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStandardState_ImplAccess().getStandardStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleStandardState_Impl5072); 

                	newLeafNode(otherlv_1, grammarAccess.getStandardState_ImplAccess().getStandardStateKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2494:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2495:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2495:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2496:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getStandardState_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleStandardState_Impl5093);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardState_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2512:2: (otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==61) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2512:4: otherlv_3= '[' ( (lv_description_4_0= ruleEString ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleStandardState_Impl5106); 

                        	newLeafNode(otherlv_3, grammarAccess.getStandardState_ImplAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2516:1: ( (lv_description_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2517:1: (lv_description_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2517:1: (lv_description_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2518:3: lv_description_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardState_ImplAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleStandardState_Impl5127);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardState_ImplRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleStandardState_Impl5139); 

                        	newLeafNode(otherlv_5, grammarAccess.getStandardState_ImplAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2538:3: ( ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_ID)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2538:4: ( (lv_outputTransitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2538:4: ( (lv_outputTransitions_6_0= ruleTransition ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2539:1: (lv_outputTransitions_6_0= ruleTransition )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2539:1: (lv_outputTransitions_6_0= ruleTransition )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2540:3: lv_outputTransitions_6_0= ruleTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardState_ImplAccess().getOutputTransitionsTransitionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleStandardState_Impl5163);
                    lv_outputTransitions_6_0=ruleTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardState_ImplRule());
                    	        }
                           		add(
                           			current, 
                           			"outputTransitions",
                            		lv_outputTransitions_6_0, 
                            		"Transition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2556:2: (otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==14) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2556:4: otherlv_7= ',' ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleStandardState_Impl5176); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getStandardState_ImplAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2560:1: ( (lv_outputTransitions_8_0= ruleTransition ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2561:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2561:1: (lv_outputTransitions_8_0= ruleTransition )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2562:3: lv_outputTransitions_8_0= ruleTransition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardState_ImplAccess().getOutputTransitionsTransitionParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleStandardState_Impl5197);
                    	    lv_outputTransitions_8_0=ruleTransition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStandardState_ImplRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputTransitions",
                    	            		lv_outputTransitions_8_0, 
                    	            		"Transition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStandardState_Impl"


    // $ANTLR start "entryRuleActionDependency"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2586:1: entryRuleActionDependency returns [EObject current=null] : iv_ruleActionDependency= ruleActionDependency EOF ;
    public final EObject entryRuleActionDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionDependency = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2587:2: (iv_ruleActionDependency= ruleActionDependency EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2588:2: iv_ruleActionDependency= ruleActionDependency EOF
            {
             newCompositeNode(grammarAccess.getActionDependencyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleActionDependency_in_entryRuleActionDependency5237);
            iv_ruleActionDependency=ruleActionDependency();

            state._fsp--;

             current =iv_ruleActionDependency; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActionDependency5247); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionDependency"


    // $ANTLR start "ruleActionDependency"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2595:1: ruleActionDependency returns [EObject current=null] : (otherlv_0= 'ActionDependency' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'srcAction' ( ( ruleEString ) ) otherlv_5= 'tgtActions' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' ) ;
    public final EObject ruleActionDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2598:28: ( (otherlv_0= 'ActionDependency' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'srcAction' ( ( ruleEString ) ) otherlv_5= 'tgtActions' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2599:1: (otherlv_0= 'ActionDependency' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'srcAction' ( ( ruleEString ) ) otherlv_5= 'tgtActions' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2599:1: (otherlv_0= 'ActionDependency' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'srcAction' ( ( ruleEString ) ) otherlv_5= 'tgtActions' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2599:3: otherlv_0= 'ActionDependency' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'srcAction' ( ( ruleEString ) ) otherlv_5= 'tgtActions' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleActionDependency5284); 

                	newLeafNode(otherlv_0, grammarAccess.getActionDependencyAccess().getActionDependencyKeyword_0());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2603:1: ( (lv_name_1_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2604:1: (lv_name_1_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2604:1: (lv_name_1_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2605:3: lv_name_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getActionDependencyAccess().getNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleActionDependency5305);
            lv_name_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActionDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleActionDependency5317); 

                	newLeafNode(otherlv_2, grammarAccess.getActionDependencyAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleActionDependency5329); 

                	newLeafNode(otherlv_3, grammarAccess.getActionDependencyAccess().getSrcActionKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2629:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2630:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2630:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2631:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActionDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActionDependencyAccess().getSrcActionActionCrossReference_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleActionDependency5352);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleActionDependency5364); 

                	newLeafNode(otherlv_5, grammarAccess.getActionDependencyAccess().getTgtActionsKeyword_5());
                
            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleActionDependency5376); 

                	newLeafNode(otherlv_6, grammarAccess.getActionDependencyAccess().getLeftParenthesisKeyword_6());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2652:1: ( ( ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2653:1: ( ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2653:1: ( ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2654:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActionDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActionDependencyAccess().getTgtActionsActionCrossReference_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleActionDependency5399);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2667:2: (otherlv_8= ',' ( ( ruleEString ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==14) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2667:4: otherlv_8= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleActionDependency5412); 

            	        	newLeafNode(otherlv_8, grammarAccess.getActionDependencyAccess().getCommaKeyword_8_0());
            	        
            	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2671:1: ( ( ruleEString ) )
            	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2672:1: ( ruleEString )
            	    {
            	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2672:1: ( ruleEString )
            	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2673:3: ruleEString
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getActionDependencyRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getActionDependencyAccess().getTgtActionsActionCrossReference_8_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleActionDependency5435);
            	    ruleEString();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleActionDependency5449); 

                	newLeafNode(otherlv_10, grammarAccess.getActionDependencyAccess().getRightParenthesisKeyword_9());
                
            otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleActionDependency5461); 

                	newLeafNode(otherlv_11, grammarAccess.getActionDependencyAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionDependency"


    // $ANTLR start "entryRuleTree"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2702:1: entryRuleTree returns [EObject current=null] : iv_ruleTree= ruleTree EOF ;
    public final EObject entryRuleTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTree = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2703:2: (iv_ruleTree= ruleTree EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2704:2: iv_ruleTree= ruleTree EOF
            {
             newCompositeNode(grammarAccess.getTreeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTree_in_entryRuleTree5497);
            iv_ruleTree=ruleTree();

            state._fsp--;

             current =iv_ruleTree; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTree5507); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2711:1: ruleTree returns [EObject current=null] : ( () otherlv_1= 'Tree' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleTree() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2714:28: ( ( () otherlv_1= 'Tree' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2715:1: ( () otherlv_1= 'Tree' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2715:1: ( () otherlv_1= 'Tree' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2715:2: () otherlv_1= 'Tree' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2715:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2716:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTreeAccess().getTreeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleTree5553); 

                	newLeafNode(otherlv_1, grammarAccess.getTreeAccess().getTreeKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2725:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2726:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2726:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2727:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTreeAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTree5574);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTreeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleSlider"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2751:1: entryRuleSlider returns [EObject current=null] : iv_ruleSlider= ruleSlider EOF ;
    public final EObject entryRuleSlider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSlider = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2752:2: (iv_ruleSlider= ruleSlider EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2753:2: iv_ruleSlider= ruleSlider EOF
            {
             newCompositeNode(grammarAccess.getSliderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSlider_in_entryRuleSlider5610);
            iv_ruleSlider=ruleSlider();

            state._fsp--;

             current =iv_ruleSlider; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSlider5620); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSlider"


    // $ANTLR start "ruleSlider"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2760:1: ruleSlider returns [EObject current=null] : ( () otherlv_1= 'Slider' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleSlider() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2763:28: ( ( () otherlv_1= 'Slider' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2764:1: ( () otherlv_1= 'Slider' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2764:1: ( () otherlv_1= 'Slider' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2764:2: () otherlv_1= 'Slider' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2764:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2765:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSliderAccess().getSliderAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleSlider5666); 

                	newLeafNode(otherlv_1, grammarAccess.getSliderAccess().getSliderKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2774:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2775:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2775:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2776:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSliderAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSlider5687);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSliderRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSlider"


    // $ANTLR start "entryRuleProgressBar"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2800:1: entryRuleProgressBar returns [EObject current=null] : iv_ruleProgressBar= ruleProgressBar EOF ;
    public final EObject entryRuleProgressBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgressBar = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2801:2: (iv_ruleProgressBar= ruleProgressBar EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2802:2: iv_ruleProgressBar= ruleProgressBar EOF
            {
             newCompositeNode(grammarAccess.getProgressBarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgressBar_in_entryRuleProgressBar5723);
            iv_ruleProgressBar=ruleProgressBar();

            state._fsp--;

             current =iv_ruleProgressBar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgressBar5733); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgressBar"


    // $ANTLR start "ruleProgressBar"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2809:1: ruleProgressBar returns [EObject current=null] : ( () otherlv_1= 'ProgressBar' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleProgressBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2812:28: ( ( () otherlv_1= 'ProgressBar' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2813:1: ( () otherlv_1= 'ProgressBar' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2813:1: ( () otherlv_1= 'ProgressBar' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2813:2: () otherlv_1= 'ProgressBar' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2813:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2814:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgressBarAccess().getProgressBarAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleProgressBar5779); 

                	newLeafNode(otherlv_1, grammarAccess.getProgressBarAccess().getProgressBarKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2823:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2824:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2824:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2825:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getProgressBarAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleProgressBar5800);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgressBarRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgressBar"


    // $ANTLR start "entryRuleTable"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2849:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2850:2: (iv_ruleTable= ruleTable EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2851:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTable_in_entryRuleTable5836);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTable5846); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2858:1: ruleTable returns [EObject current=null] : ( () otherlv_1= 'Table' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2861:28: ( ( () otherlv_1= 'Table' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2862:1: ( () otherlv_1= 'Table' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2862:1: ( () otherlv_1= 'Table' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2862:2: () otherlv_1= 'Table' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2862:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2863:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableAccess().getTableAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleTable5892); 

                	newLeafNode(otherlv_1, grammarAccess.getTableAccess().getTableKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2872:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2873:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2873:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2874:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTable5913);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleLabel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2898:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2899:2: (iv_ruleLabel= ruleLabel EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2900:2: iv_ruleLabel= ruleLabel EOF
            {
             newCompositeNode(grammarAccess.getLabelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLabel_in_entryRuleLabel5949);
            iv_ruleLabel=ruleLabel();

            state._fsp--;

             current =iv_ruleLabel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLabel5959); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2907:1: ruleLabel returns [EObject current=null] : ( () otherlv_1= 'Label' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_text_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2910:28: ( ( () otherlv_1= 'Label' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2911:1: ( () otherlv_1= 'Label' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2911:1: ( () otherlv_1= 'Label' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2911:2: () otherlv_1= 'Label' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2911:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2912:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLabelAccess().getLabelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleLabel6005); 

                	newLeafNode(otherlv_1, grammarAccess.getLabelAccess().getLabelKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2921:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2922:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2922:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2923:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLabelAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLabel6026);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLabelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLabel6038); 

                	newLeafNode(otherlv_3, grammarAccess.getLabelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2943:1: (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==74) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2943:3: otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleLabel6051); 

                        	newLeafNode(otherlv_4, grammarAccess.getLabelAccess().getTextKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2947:1: ( (lv_text_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2948:1: (lv_text_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2948:1: (lv_text_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2949:3: lv_text_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getLabelAccess().getTextEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLabel6072);
                    lv_text_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLabelRule());
                    	        }
                           		set(
                           			current, 
                           			"text",
                            		lv_text_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLabel6086); 

                	newLeafNode(otherlv_6, grammarAccess.getLabelAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleTextArea"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2977:1: entryRuleTextArea returns [EObject current=null] : iv_ruleTextArea= ruleTextArea EOF ;
    public final EObject entryRuleTextArea() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextArea = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2978:2: (iv_ruleTextArea= ruleTextArea EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2979:2: iv_ruleTextArea= ruleTextArea EOF
            {
             newCompositeNode(grammarAccess.getTextAreaRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTextArea_in_entryRuleTextArea6122);
            iv_ruleTextArea=ruleTextArea();

            state._fsp--;

             current =iv_ruleTextArea; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextArea6132); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextArea"


    // $ANTLR start "ruleTextArea"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2986:1: ruleTextArea returns [EObject current=null] : ( () otherlv_1= 'TextArea' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleTextArea() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_text_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2989:28: ( ( () otherlv_1= 'TextArea' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2990:1: ( () otherlv_1= 'TextArea' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2990:1: ( () otherlv_1= 'TextArea' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2990:2: () otherlv_1= 'TextArea' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2990:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:2991:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTextAreaAccess().getTextAreaAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleTextArea6178); 

                	newLeafNode(otherlv_1, grammarAccess.getTextAreaAccess().getTextAreaKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3000:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3001:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3001:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3002:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTextAreaAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTextArea6199);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTextAreaRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTextArea6211); 

                	newLeafNode(otherlv_3, grammarAccess.getTextAreaAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3022:1: (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==74) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3022:3: otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleTextArea6224); 

                        	newLeafNode(otherlv_4, grammarAccess.getTextAreaAccess().getTextKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3026:1: ( (lv_text_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3027:1: (lv_text_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3027:1: (lv_text_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3028:3: lv_text_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTextAreaAccess().getTextEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTextArea6245);
                    lv_text_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTextAreaRule());
                    	        }
                           		set(
                           			current, 
                           			"text",
                            		lv_text_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTextArea6259); 

                	newLeafNode(otherlv_6, grammarAccess.getTextAreaAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextArea"


    // $ANTLR start "entryRuleTextField"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3056:1: entryRuleTextField returns [EObject current=null] : iv_ruleTextField= ruleTextField EOF ;
    public final EObject entryRuleTextField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextField = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3057:2: (iv_ruleTextField= ruleTextField EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3058:2: iv_ruleTextField= ruleTextField EOF
            {
             newCompositeNode(grammarAccess.getTextFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTextField_in_entryRuleTextField6295);
            iv_ruleTextField=ruleTextField();

            state._fsp--;

             current =iv_ruleTextField; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextField6305); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextField"


    // $ANTLR start "ruleTextField"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3065:1: ruleTextField returns [EObject current=null] : ( () otherlv_1= 'TextField' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleTextField() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_text_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3068:28: ( ( () otherlv_1= 'TextField' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3069:1: ( () otherlv_1= 'TextField' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3069:1: ( () otherlv_1= 'TextField' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3069:2: () otherlv_1= 'TextField' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3069:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3070:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTextFieldAccess().getTextFieldAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleTextField6351); 

                	newLeafNode(otherlv_1, grammarAccess.getTextFieldAccess().getTextFieldKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3079:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3080:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3080:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3081:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTextFieldAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTextField6372);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTextFieldRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTextField6384); 

                	newLeafNode(otherlv_3, grammarAccess.getTextFieldAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3101:1: (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==74) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3101:3: otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleTextField6397); 

                        	newLeafNode(otherlv_4, grammarAccess.getTextFieldAccess().getTextKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3105:1: ( (lv_text_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3106:1: (lv_text_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3106:1: (lv_text_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3107:3: lv_text_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTextFieldAccess().getTextEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTextField6418);
                    lv_text_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTextFieldRule());
                    	        }
                           		set(
                           			current, 
                           			"text",
                            		lv_text_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTextField6432); 

                	newLeafNode(otherlv_6, grammarAccess.getTextFieldAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextField"


    // $ANTLR start "entryRuleSpinner"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3135:1: entryRuleSpinner returns [EObject current=null] : iv_ruleSpinner= ruleSpinner EOF ;
    public final EObject entryRuleSpinner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpinner = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3136:2: (iv_ruleSpinner= ruleSpinner EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3137:2: iv_ruleSpinner= ruleSpinner EOF
            {
             newCompositeNode(grammarAccess.getSpinnerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpinner_in_entryRuleSpinner6468);
            iv_ruleSpinner=ruleSpinner();

            state._fsp--;

             current =iv_ruleSpinner; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpinner6478); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpinner"


    // $ANTLR start "ruleSpinner"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3144:1: ruleSpinner returns [EObject current=null] : ( () otherlv_1= 'Spinner' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleSpinner() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_text_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3147:28: ( ( () otherlv_1= 'Spinner' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3148:1: ( () otherlv_1= 'Spinner' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3148:1: ( () otherlv_1= 'Spinner' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3148:2: () otherlv_1= 'Spinner' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3148:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3149:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpinnerAccess().getSpinnerAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSpinner6524); 

                	newLeafNode(otherlv_1, grammarAccess.getSpinnerAccess().getSpinnerKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3158:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3159:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3159:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3160:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSpinnerAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSpinner6545);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpinnerRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSpinner6557); 

                	newLeafNode(otherlv_3, grammarAccess.getSpinnerAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3180:1: (otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==74) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3180:3: otherlv_4= 'text' ( (lv_text_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleSpinner6570); 

                        	newLeafNode(otherlv_4, grammarAccess.getSpinnerAccess().getTextKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3184:1: ( (lv_text_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3185:1: (lv_text_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3185:1: (lv_text_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3186:3: lv_text_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpinnerAccess().getTextEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSpinner6591);
                    lv_text_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpinnerRule());
                    	        }
                           		set(
                           			current, 
                           			"text",
                            		lv_text_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSpinner6605); 

                	newLeafNode(otherlv_6, grammarAccess.getSpinnerAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpinner"


    // $ANTLR start "entryRuleMultiLineList"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3214:1: entryRuleMultiLineList returns [EObject current=null] : iv_ruleMultiLineList= ruleMultiLineList EOF ;
    public final EObject entryRuleMultiLineList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiLineList = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3215:2: (iv_ruleMultiLineList= ruleMultiLineList EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3216:2: iv_ruleMultiLineList= ruleMultiLineList EOF
            {
             newCompositeNode(grammarAccess.getMultiLineListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiLineList_in_entryRuleMultiLineList6641);
            iv_ruleMultiLineList=ruleMultiLineList();

            state._fsp--;

             current =iv_ruleMultiLineList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiLineList6651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiLineList"


    // $ANTLR start "ruleMultiLineList"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3223:1: ruleMultiLineList returns [EObject current=null] : ( () otherlv_1= 'MultiLineList' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleMultiLineList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3226:28: ( ( () otherlv_1= 'MultiLineList' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3227:1: ( () otherlv_1= 'MultiLineList' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3227:1: ( () otherlv_1= 'MultiLineList' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3227:2: () otherlv_1= 'MultiLineList' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3227:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3228:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMultiLineListAccess().getMultiLineListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiLineList6697); 

                	newLeafNode(otherlv_1, grammarAccess.getMultiLineListAccess().getMultiLineListKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3237:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3238:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3238:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3239:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getMultiLineListAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMultiLineList6718);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiLineListRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiLineList"


    // $ANTLR start "entryRuleSingleLineList"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3263:1: entryRuleSingleLineList returns [EObject current=null] : iv_ruleSingleLineList= ruleSingleLineList EOF ;
    public final EObject entryRuleSingleLineList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleLineList = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3264:2: (iv_ruleSingleLineList= ruleSingleLineList EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3265:2: iv_ruleSingleLineList= ruleSingleLineList EOF
            {
             newCompositeNode(grammarAccess.getSingleLineListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleLineList_in_entryRuleSingleLineList6754);
            iv_ruleSingleLineList=ruleSingleLineList();

            state._fsp--;

             current =iv_ruleSingleLineList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleLineList6764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleLineList"


    // $ANTLR start "ruleSingleLineList"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3272:1: ruleSingleLineList returns [EObject current=null] : ( () otherlv_1= 'SingleLineList' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleSingleLineList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3275:28: ( ( () otherlv_1= 'SingleLineList' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3276:1: ( () otherlv_1= 'SingleLineList' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3276:1: ( () otherlv_1= 'SingleLineList' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3276:2: () otherlv_1= 'SingleLineList' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3276:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3277:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSingleLineListAccess().getSingleLineListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleSingleLineList6810); 

                	newLeafNode(otherlv_1, grammarAccess.getSingleLineListAccess().getSingleLineListKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3286:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3287:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3287:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3288:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSingleLineListAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSingleLineList6831);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSingleLineListRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleLineList"


    // $ANTLR start "entryRulePanel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3312:1: entryRulePanel returns [EObject current=null] : iv_rulePanel= rulePanel EOF ;
    public final EObject entryRulePanel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePanel = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3313:2: (iv_rulePanel= rulePanel EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3314:2: iv_rulePanel= rulePanel EOF
            {
             newCompositeNode(grammarAccess.getPanelRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePanel_in_entryRulePanel6867);
            iv_rulePanel=rulePanel();

            state._fsp--;

             current =iv_rulePanel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePanel6877); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePanel"


    // $ANTLR start "rulePanel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3321:1: rulePanel returns [EObject current=null] : ( () otherlv_1= 'Panel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject rulePanel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3324:28: ( ( () otherlv_1= 'Panel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3325:1: ( () otherlv_1= 'Panel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3325:1: ( () otherlv_1= 'Panel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3325:2: () otherlv_1= 'Panel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3325:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3326:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPanelAccess().getPanelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePanel6923); 

                	newLeafNode(otherlv_1, grammarAccess.getPanelAccess().getPanelKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3335:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3336:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3336:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3337:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getPanelAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rulePanel6944);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPanelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_rulePanel6956); 

                	newLeafNode(otherlv_3, grammarAccess.getPanelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3357:1: (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==81) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3357:3: otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_rulePanel6969); 

                        	newLeafNode(otherlv_4, grammarAccess.getPanelAccess().getElementsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_rulePanel6981); 

                        	newLeafNode(otherlv_5, grammarAccess.getPanelAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3365:1: ( (lv_elements_6_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3366:1: (lv_elements_6_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3366:1: (lv_elements_6_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3367:3: lv_elements_6_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getPanelAccess().getElementsWidgetParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_rulePanel7002);
                    lv_elements_6_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPanelRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_6_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3383:2: (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==14) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3383:4: otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePanel7015); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getPanelAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3387:1: ( (lv_elements_8_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3388:1: (lv_elements_8_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3388:1: (lv_elements_8_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3389:3: lv_elements_8_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPanelAccess().getElementsWidgetParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_rulePanel7036);
                    	    lv_elements_8_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPanelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_8_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePanel7050); 

                        	newLeafNode(otherlv_9, grammarAccess.getPanelAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePanel7064); 

                	newLeafNode(otherlv_10, grammarAccess.getPanelAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePanel"


    // $ANTLR start "entryRuleWindow_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3421:1: entryRuleWindow_Impl returns [EObject current=null] : iv_ruleWindow_Impl= ruleWindow_Impl EOF ;
    public final EObject entryRuleWindow_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWindow_Impl = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3422:2: (iv_ruleWindow_Impl= ruleWindow_Impl EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3423:2: iv_ruleWindow_Impl= ruleWindow_Impl EOF
            {
             newCompositeNode(grammarAccess.getWindow_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWindow_Impl_in_entryRuleWindow_Impl7100);
            iv_ruleWindow_Impl=ruleWindow_Impl();

            state._fsp--;

             current =iv_ruleWindow_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWindow_Impl7110); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWindow_Impl"


    // $ANTLR start "ruleWindow_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3430:1: ruleWindow_Impl returns [EObject current=null] : ( () otherlv_1= 'Window' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleWindow_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3433:28: ( ( () otherlv_1= 'Window' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3434:1: ( () otherlv_1= 'Window' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3434:1: ( () otherlv_1= 'Window' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3434:2: () otherlv_1= 'Window' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3434:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3435:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWindow_ImplAccess().getWindowAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleWindow_Impl7156); 

                	newLeafNode(otherlv_1, grammarAccess.getWindow_ImplAccess().getWindowKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3444:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3445:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3445:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3446:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getWindow_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleWindow_Impl7177);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWindow_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleWindow_Impl7189); 

                	newLeafNode(otherlv_3, grammarAccess.getWindow_ImplAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3466:1: (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==81) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3466:3: otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleWindow_Impl7202); 

                        	newLeafNode(otherlv_4, grammarAccess.getWindow_ImplAccess().getElementsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleWindow_Impl7214); 

                        	newLeafNode(otherlv_5, grammarAccess.getWindow_ImplAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3474:1: ( (lv_elements_6_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3475:1: (lv_elements_6_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3475:1: (lv_elements_6_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3476:3: lv_elements_6_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getWindow_ImplAccess().getElementsWidgetParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleWindow_Impl7235);
                    lv_elements_6_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWindow_ImplRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_6_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3492:2: (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==14) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3492:4: otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleWindow_Impl7248); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getWindow_ImplAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3496:1: ( (lv_elements_8_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3497:1: (lv_elements_8_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3497:1: (lv_elements_8_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3498:3: lv_elements_8_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWindow_ImplAccess().getElementsWidgetParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleWindow_Impl7269);
                    	    lv_elements_8_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWindow_ImplRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_8_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleWindow_Impl7283); 

                        	newLeafNode(otherlv_9, grammarAccess.getWindow_ImplAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleWindow_Impl7297); 

                	newLeafNode(otherlv_10, grammarAccess.getWindow_ImplAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWindow_Impl"


    // $ANTLR start "entryRuleDialogueBox"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3530:1: entryRuleDialogueBox returns [EObject current=null] : iv_ruleDialogueBox= ruleDialogueBox EOF ;
    public final EObject entryRuleDialogueBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDialogueBox = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3531:2: (iv_ruleDialogueBox= ruleDialogueBox EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3532:2: iv_ruleDialogueBox= ruleDialogueBox EOF
            {
             newCompositeNode(grammarAccess.getDialogueBoxRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDialogueBox_in_entryRuleDialogueBox7333);
            iv_ruleDialogueBox=ruleDialogueBox();

            state._fsp--;

             current =iv_ruleDialogueBox; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDialogueBox7343); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDialogueBox"


    // $ANTLR start "ruleDialogueBox"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3539:1: ruleDialogueBox returns [EObject current=null] : ( () otherlv_1= 'DialogueBox' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleDialogueBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3542:28: ( ( () otherlv_1= 'DialogueBox' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3543:1: ( () otherlv_1= 'DialogueBox' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3543:1: ( () otherlv_1= 'DialogueBox' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3543:2: () otherlv_1= 'DialogueBox' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3543:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3544:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDialogueBoxAccess().getDialogueBoxAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleDialogueBox7389); 

                	newLeafNode(otherlv_1, grammarAccess.getDialogueBoxAccess().getDialogueBoxKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3553:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3554:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3554:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3555:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getDialogueBoxAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDialogueBox7410);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDialogueBoxRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDialogueBox7422); 

                	newLeafNode(otherlv_3, grammarAccess.getDialogueBoxAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3575:1: (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==81) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3575:3: otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleDialogueBox7435); 

                        	newLeafNode(otherlv_4, grammarAccess.getDialogueBoxAccess().getElementsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDialogueBox7447); 

                        	newLeafNode(otherlv_5, grammarAccess.getDialogueBoxAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3583:1: ( (lv_elements_6_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3584:1: (lv_elements_6_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3584:1: (lv_elements_6_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3585:3: lv_elements_6_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getDialogueBoxAccess().getElementsWidgetParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleDialogueBox7468);
                    lv_elements_6_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDialogueBoxRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_6_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3601:2: (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==14) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3601:4: otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDialogueBox7481); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getDialogueBoxAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3605:1: ( (lv_elements_8_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3606:1: (lv_elements_8_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3606:1: (lv_elements_8_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3607:3: lv_elements_8_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDialogueBoxAccess().getElementsWidgetParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleDialogueBox7502);
                    	    lv_elements_8_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDialogueBoxRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_8_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDialogueBox7516); 

                        	newLeafNode(otherlv_9, grammarAccess.getDialogueBoxAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDialogueBox7530); 

                	newLeafNode(otherlv_10, grammarAccess.getDialogueBoxAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDialogueBox"


    // $ANTLR start "entryRuleSplitPane"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3639:1: entryRuleSplitPane returns [EObject current=null] : iv_ruleSplitPane= ruleSplitPane EOF ;
    public final EObject entryRuleSplitPane() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSplitPane = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3640:2: (iv_ruleSplitPane= ruleSplitPane EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3641:2: iv_ruleSplitPane= ruleSplitPane EOF
            {
             newCompositeNode(grammarAccess.getSplitPaneRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSplitPane_in_entryRuleSplitPane7566);
            iv_ruleSplitPane=ruleSplitPane();

            state._fsp--;

             current =iv_ruleSplitPane; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSplitPane7576); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSplitPane"


    // $ANTLR start "ruleSplitPane"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3648:1: ruleSplitPane returns [EObject current=null] : ( () otherlv_1= 'SplitPane' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleSplitPane() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3651:28: ( ( () otherlv_1= 'SplitPane' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3652:1: ( () otherlv_1= 'SplitPane' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3652:1: ( () otherlv_1= 'SplitPane' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3652:2: () otherlv_1= 'SplitPane' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3652:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3653:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSplitPaneAccess().getSplitPaneAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleSplitPane7622); 

                	newLeafNode(otherlv_1, grammarAccess.getSplitPaneAccess().getSplitPaneKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3662:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3663:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3663:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3664:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSplitPaneAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSplitPane7643);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSplitPaneRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSplitPane7655); 

                	newLeafNode(otherlv_3, grammarAccess.getSplitPaneAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3684:1: (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==81) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3684:3: otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleSplitPane7668); 

                        	newLeafNode(otherlv_4, grammarAccess.getSplitPaneAccess().getElementsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSplitPane7680); 

                        	newLeafNode(otherlv_5, grammarAccess.getSplitPaneAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3692:1: ( (lv_elements_6_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3693:1: (lv_elements_6_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3693:1: (lv_elements_6_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3694:3: lv_elements_6_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getSplitPaneAccess().getElementsWidgetParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleSplitPane7701);
                    lv_elements_6_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSplitPaneRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_6_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3710:2: (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==14) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3710:4: otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSplitPane7714); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getSplitPaneAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3714:1: ( (lv_elements_8_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3715:1: (lv_elements_8_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3715:1: (lv_elements_8_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3716:3: lv_elements_8_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSplitPaneAccess().getElementsWidgetParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleSplitPane7735);
                    	    lv_elements_8_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSplitPaneRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_8_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSplitPane7749); 

                        	newLeafNode(otherlv_9, grammarAccess.getSplitPaneAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSplitPane7763); 

                	newLeafNode(otherlv_10, grammarAccess.getSplitPaneAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSplitPane"


    // $ANTLR start "entryRuleTabbedPanel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3748:1: entryRuleTabbedPanel returns [EObject current=null] : iv_ruleTabbedPanel= ruleTabbedPanel EOF ;
    public final EObject entryRuleTabbedPanel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTabbedPanel = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3749:2: (iv_ruleTabbedPanel= ruleTabbedPanel EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3750:2: iv_ruleTabbedPanel= ruleTabbedPanel EOF
            {
             newCompositeNode(grammarAccess.getTabbedPanelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTabbedPanel_in_entryRuleTabbedPanel7799);
            iv_ruleTabbedPanel=ruleTabbedPanel();

            state._fsp--;

             current =iv_ruleTabbedPanel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTabbedPanel7809); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTabbedPanel"


    // $ANTLR start "ruleTabbedPanel"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3757:1: ruleTabbedPanel returns [EObject current=null] : ( () otherlv_1= 'TabbedPanel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleTabbedPanel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3760:28: ( ( () otherlv_1= 'TabbedPanel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3761:1: ( () otherlv_1= 'TabbedPanel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3761:1: ( () otherlv_1= 'TabbedPanel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3761:2: () otherlv_1= 'TabbedPanel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3761:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3762:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTabbedPanelAccess().getTabbedPanelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleTabbedPanel7855); 

                	newLeafNode(otherlv_1, grammarAccess.getTabbedPanelAccess().getTabbedPanelKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3771:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3772:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3772:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3773:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTabbedPanelAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTabbedPanel7876);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTabbedPanelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTabbedPanel7888); 

                	newLeafNode(otherlv_3, grammarAccess.getTabbedPanelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3793:1: (otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==81) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3793:3: otherlv_4= 'elements' otherlv_5= '{' ( (lv_elements_6_0= ruleWidget ) ) (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleTabbedPanel7901); 

                        	newLeafNode(otherlv_4, grammarAccess.getTabbedPanelAccess().getElementsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTabbedPanel7913); 

                        	newLeafNode(otherlv_5, grammarAccess.getTabbedPanelAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3801:1: ( (lv_elements_6_0= ruleWidget ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3802:1: (lv_elements_6_0= ruleWidget )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3802:1: (lv_elements_6_0= ruleWidget )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3803:3: lv_elements_6_0= ruleWidget
                    {
                     
                    	        newCompositeNode(grammarAccess.getTabbedPanelAccess().getElementsWidgetParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleTabbedPanel7934);
                    lv_elements_6_0=ruleWidget();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTabbedPanelRule());
                    	        }
                           		add(
                           			current, 
                           			"elements",
                            		lv_elements_6_0, 
                            		"Widget");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3819:2: (otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==14) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3819:4: otherlv_7= ',' ( (lv_elements_8_0= ruleWidget ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTabbedPanel7947); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getTabbedPanelAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3823:1: ( (lv_elements_8_0= ruleWidget ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3824:1: (lv_elements_8_0= ruleWidget )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3824:1: (lv_elements_8_0= ruleWidget )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3825:3: lv_elements_8_0= ruleWidget
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTabbedPanelAccess().getElementsWidgetParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWidget_in_ruleTabbedPanel7968);
                    	    lv_elements_8_0=ruleWidget();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTabbedPanelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_8_0, 
                    	            		"Widget");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTabbedPanel7982); 

                        	newLeafNode(otherlv_9, grammarAccess.getTabbedPanelAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTabbedPanel7996); 

                	newLeafNode(otherlv_10, grammarAccess.getTabbedPanelAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTabbedPanel"


    // $ANTLR start "entryRuleButton_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3857:1: entryRuleButton_Impl returns [EObject current=null] : iv_ruleButton_Impl= ruleButton_Impl EOF ;
    public final EObject entryRuleButton_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButton_Impl = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3858:2: (iv_ruleButton_Impl= ruleButton_Impl EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3859:2: iv_ruleButton_Impl= ruleButton_Impl EOF
            {
             newCompositeNode(grammarAccess.getButton_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleButton_Impl_in_entryRuleButton_Impl8032);
            iv_ruleButton_Impl=ruleButton_Impl();

            state._fsp--;

             current =iv_ruleButton_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleButton_Impl8042); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleButton_Impl"


    // $ANTLR start "ruleButton_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3866:1: ruleButton_Impl returns [EObject current=null] : ( () otherlv_1= 'Button' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleButton_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3869:28: ( ( () otherlv_1= 'Button' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3870:1: ( () otherlv_1= 'Button' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3870:1: ( () otherlv_1= 'Button' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3870:2: () otherlv_1= 'Button' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3870:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3871:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getButton_ImplAccess().getButtonAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleButton_Impl8088); 

                	newLeafNode(otherlv_1, grammarAccess.getButton_ImplAccess().getButtonKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3880:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3881:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3881:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3882:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getButton_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleButton_Impl8109);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getButton_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleButton_Impl"


    // $ANTLR start "entryRuleToggleButton"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3906:1: entryRuleToggleButton returns [EObject current=null] : iv_ruleToggleButton= ruleToggleButton EOF ;
    public final EObject entryRuleToggleButton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToggleButton = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3907:2: (iv_ruleToggleButton= ruleToggleButton EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3908:2: iv_ruleToggleButton= ruleToggleButton EOF
            {
             newCompositeNode(grammarAccess.getToggleButtonRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleToggleButton_in_entryRuleToggleButton8145);
            iv_ruleToggleButton=ruleToggleButton();

            state._fsp--;

             current =iv_ruleToggleButton; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleToggleButton8155); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleToggleButton"


    // $ANTLR start "ruleToggleButton"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3915:1: ruleToggleButton returns [EObject current=null] : ( () otherlv_1= 'ToggleButton' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleToggleButton() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3918:28: ( ( () otherlv_1= 'ToggleButton' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3919:1: ( () otherlv_1= 'ToggleButton' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3919:1: ( () otherlv_1= 'ToggleButton' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3919:2: () otherlv_1= 'ToggleButton' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3919:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3920:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getToggleButtonAccess().getToggleButtonAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleToggleButton8201); 

                	newLeafNode(otherlv_1, grammarAccess.getToggleButtonAccess().getToggleButtonKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3929:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3930:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3930:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3931:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getToggleButtonAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleToggleButton8222);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getToggleButtonRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleToggleButton"


    // $ANTLR start "entryRuleMenu_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3955:1: entryRuleMenu_Impl returns [EObject current=null] : iv_ruleMenu_Impl= ruleMenu_Impl EOF ;
    public final EObject entryRuleMenu_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMenu_Impl = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3956:2: (iv_ruleMenu_Impl= ruleMenu_Impl EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3957:2: iv_ruleMenu_Impl= ruleMenu_Impl EOF
            {
             newCompositeNode(grammarAccess.getMenu_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMenu_Impl_in_entryRuleMenu_Impl8258);
            iv_ruleMenu_Impl=ruleMenu_Impl();

            state._fsp--;

             current =iv_ruleMenu_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMenu_Impl8268); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMenu_Impl"


    // $ANTLR start "ruleMenu_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3964:1: ruleMenu_Impl returns [EObject current=null] : ( () otherlv_1= 'Menu' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleMenu_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3967:28: ( ( () otherlv_1= 'Menu' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3968:1: ( () otherlv_1= 'Menu' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3968:1: ( () otherlv_1= 'Menu' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3968:2: () otherlv_1= 'Menu' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3968:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3969:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMenu_ImplAccess().getMenuAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleMenu_Impl8314); 

                	newLeafNode(otherlv_1, grammarAccess.getMenu_ImplAccess().getMenuKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3978:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3979:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3979:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:3980:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getMenu_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMenu_Impl8335);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMenu_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMenu_Impl"


    // $ANTLR start "entryRuleCheckBox"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4004:1: entryRuleCheckBox returns [EObject current=null] : iv_ruleCheckBox= ruleCheckBox EOF ;
    public final EObject entryRuleCheckBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckBox = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4005:2: (iv_ruleCheckBox= ruleCheckBox EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4006:2: iv_ruleCheckBox= ruleCheckBox EOF
            {
             newCompositeNode(grammarAccess.getCheckBoxRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheckBox_in_entryRuleCheckBox8371);
            iv_ruleCheckBox=ruleCheckBox();

            state._fsp--;

             current =iv_ruleCheckBox; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheckBox8381); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheckBox"


    // $ANTLR start "ruleCheckBox"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4013:1: ruleCheckBox returns [EObject current=null] : ( () otherlv_1= 'CheckBox' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleCheckBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4016:28: ( ( () otherlv_1= 'CheckBox' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4017:1: ( () otherlv_1= 'CheckBox' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4017:1: ( () otherlv_1= 'CheckBox' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4017:2: () otherlv_1= 'CheckBox' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4017:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4018:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCheckBoxAccess().getCheckBoxAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleCheckBox8427); 

                	newLeafNode(otherlv_1, grammarAccess.getCheckBoxAccess().getCheckBoxKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4027:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4028:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4028:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4029:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCheckBoxAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCheckBox8448);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCheckBoxRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheckBox"


    // $ANTLR start "entryRuleRadioButton"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4053:1: entryRuleRadioButton returns [EObject current=null] : iv_ruleRadioButton= ruleRadioButton EOF ;
    public final EObject entryRuleRadioButton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRadioButton = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4054:2: (iv_ruleRadioButton= ruleRadioButton EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4055:2: iv_ruleRadioButton= ruleRadioButton EOF
            {
             newCompositeNode(grammarAccess.getRadioButtonRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRadioButton_in_entryRuleRadioButton8484);
            iv_ruleRadioButton=ruleRadioButton();

            state._fsp--;

             current =iv_ruleRadioButton; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRadioButton8494); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRadioButton"


    // $ANTLR start "ruleRadioButton"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4062:1: ruleRadioButton returns [EObject current=null] : ( () otherlv_1= 'RadioButton' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleRadioButton() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4065:28: ( ( () otherlv_1= 'RadioButton' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4066:1: ( () otherlv_1= 'RadioButton' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4066:1: ( () otherlv_1= 'RadioButton' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4066:2: () otherlv_1= 'RadioButton' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4066:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4067:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRadioButtonAccess().getRadioButtonAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleRadioButton8540); 

                	newLeafNode(otherlv_1, grammarAccess.getRadioButtonAccess().getRadioButtonKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4076:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4077:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4077:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4078:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRadioButtonAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleRadioButton8561);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRadioButtonRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRadioButton"


    // $ANTLR start "entryRuleToggleMenu"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4102:1: entryRuleToggleMenu returns [EObject current=null] : iv_ruleToggleMenu= ruleToggleMenu EOF ;
    public final EObject entryRuleToggleMenu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToggleMenu = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4103:2: (iv_ruleToggleMenu= ruleToggleMenu EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4104:2: iv_ruleToggleMenu= ruleToggleMenu EOF
            {
             newCompositeNode(grammarAccess.getToggleMenuRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleToggleMenu_in_entryRuleToggleMenu8597);
            iv_ruleToggleMenu=ruleToggleMenu();

            state._fsp--;

             current =iv_ruleToggleMenu; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleToggleMenu8607); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleToggleMenu"


    // $ANTLR start "ruleToggleMenu"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4111:1: ruleToggleMenu returns [EObject current=null] : ( () otherlv_1= 'ToggleMenu' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleToggleMenu() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4114:28: ( ( () otherlv_1= 'ToggleMenu' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4115:1: ( () otherlv_1= 'ToggleMenu' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4115:1: ( () otherlv_1= 'ToggleMenu' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4115:2: () otherlv_1= 'ToggleMenu' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4115:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4116:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getToggleMenuAccess().getToggleMenuAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleToggleMenu8653); 

                	newLeafNode(otherlv_1, grammarAccess.getToggleMenuAccess().getToggleMenuKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4125:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4126:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4126:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4127:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getToggleMenuAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleToggleMenu8674);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getToggleMenuRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleToggleMenu"


    // $ANTLR start "entryRuleRadioMenu"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4151:1: entryRuleRadioMenu returns [EObject current=null] : iv_ruleRadioMenu= ruleRadioMenu EOF ;
    public final EObject entryRuleRadioMenu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRadioMenu = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4152:2: (iv_ruleRadioMenu= ruleRadioMenu EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4153:2: iv_ruleRadioMenu= ruleRadioMenu EOF
            {
             newCompositeNode(grammarAccess.getRadioMenuRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRadioMenu_in_entryRuleRadioMenu8710);
            iv_ruleRadioMenu=ruleRadioMenu();

            state._fsp--;

             current =iv_ruleRadioMenu; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRadioMenu8720); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRadioMenu"


    // $ANTLR start "ruleRadioMenu"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4160:1: ruleRadioMenu returns [EObject current=null] : ( () otherlv_1= 'RadioMenu' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleRadioMenu() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4163:28: ( ( () otherlv_1= 'RadioMenu' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4164:1: ( () otherlv_1= 'RadioMenu' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4164:1: ( () otherlv_1= 'RadioMenu' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4164:2: () otherlv_1= 'RadioMenu' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4164:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4165:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRadioMenuAccess().getRadioMenuAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleRadioMenu8766); 

                	newLeafNode(otherlv_1, grammarAccess.getRadioMenuAccess().getRadioMenuKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4174:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4175:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4175:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4176:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRadioMenuAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleRadioMenu8787);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRadioMenuRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRadioMenu"


    // $ANTLR start "entryRuleEClassifier"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4200:1: entryRuleEClassifier returns [EObject current=null] : iv_ruleEClassifier= ruleEClassifier EOF ;
    public final EObject entryRuleEClassifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifier = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4201:2: (iv_ruleEClassifier= ruleEClassifier EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4202:2: iv_ruleEClassifier= ruleEClassifier EOF
            {
             newCompositeNode(grammarAccess.getEClassifierRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClassifier_in_entryRuleEClassifier8823);
            iv_ruleEClassifier=ruleEClassifier();

            state._fsp--;

             current =iv_ruleEClassifier; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClassifier8833); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClassifier"


    // $ANTLR start "ruleEClassifier"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4209:1: ruleEClassifier returns [EObject current=null] : (this_EClass_0= ruleEClass | this_EDataType_Impl_1= ruleEDataType_Impl | this_EEnum_2= ruleEEnum ) ;
    public final EObject ruleEClassifier() throws RecognitionException {
        EObject current = null;

        EObject this_EClass_0 = null;

        EObject this_EDataType_Impl_1 = null;

        EObject this_EEnum_2 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4212:28: ( (this_EClass_0= ruleEClass | this_EDataType_Impl_1= ruleEDataType_Impl | this_EEnum_2= ruleEEnum ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4213:1: (this_EClass_0= ruleEClass | this_EDataType_Impl_1= ruleEDataType_Impl | this_EEnum_2= ruleEEnum )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4213:1: (this_EClass_0= ruleEClass | this_EDataType_Impl_1= ruleEDataType_Impl | this_EEnum_2= ruleEEnum )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 93:
            case 94:
            case 95:
                {
                alt85=1;
                }
                break;
            case 148:
                {
                alt85=2;
                }
                break;
            case 150:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4214:5: this_EClass_0= ruleEClass
                    {
                     
                            newCompositeNode(grammarAccess.getEClassifierAccess().getEClassParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEClass_in_ruleEClassifier8880);
                    this_EClass_0=ruleEClass();

                    state._fsp--;

                     
                            current = this_EClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4224:5: this_EDataType_Impl_1= ruleEDataType_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getEClassifierAccess().getEDataType_ImplParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEDataType_Impl_in_ruleEClassifier8907);
                    this_EDataType_Impl_1=ruleEDataType_Impl();

                    state._fsp--;

                     
                            current = this_EDataType_Impl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4234:5: this_EEnum_2= ruleEEnum
                    {
                     
                            newCompositeNode(grammarAccess.getEClassifierAccess().getEEnumParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEEnum_in_ruleEClassifier8934);
                    this_EEnum_2=ruleEEnum();

                    state._fsp--;

                     
                            current = this_EEnum_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEClassifier"


    // $ANTLR start "entryRuleEStructuralFeature"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4250:1: entryRuleEStructuralFeature returns [EObject current=null] : iv_ruleEStructuralFeature= ruleEStructuralFeature EOF ;
    public final EObject entryRuleEStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeature = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4251:2: (iv_ruleEStructuralFeature= ruleEStructuralFeature EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4252:2: iv_ruleEStructuralFeature= ruleEStructuralFeature EOF
            {
             newCompositeNode(grammarAccess.getEStructuralFeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeature_in_entryRuleEStructuralFeature8969);
            iv_ruleEStructuralFeature=ruleEStructuralFeature();

            state._fsp--;

             current =iv_ruleEStructuralFeature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEStructuralFeature8979); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEStructuralFeature"


    // $ANTLR start "ruleEStructuralFeature"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4259:1: ruleEStructuralFeature returns [EObject current=null] : (this_EAttribute_0= ruleEAttribute | this_EReference_1= ruleEReference ) ;
    public final EObject ruleEStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject this_EAttribute_0 = null;

        EObject this_EReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4262:28: ( (this_EAttribute_0= ruleEAttribute | this_EReference_1= ruleEReference ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4263:1: (this_EAttribute_0= ruleEAttribute | this_EReference_1= ruleEReference )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4263:1: (this_EAttribute_0= ruleEAttribute | this_EReference_1= ruleEReference )
            int alt86=2;
            switch ( input.LA(1) ) {
            case 135:
                {
                switch ( input.LA(2) ) {
                case 136:
                    {
                    switch ( input.LA(3) ) {
                    case 137:
                        {
                        switch ( input.LA(4) ) {
                        case 138:
                            {
                            int LA86_4 = input.LA(5);

                            if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                                alt86=1;
                            }
                            else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                                alt86=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 86, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 143:
                        case 144:
                            {
                            alt86=2;
                            }
                            break;
                        case 139:
                        case 140:
                            {
                            alt86=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 86, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 138:
                        {
                        int LA86_4 = input.LA(4);

                        if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                            alt86=1;
                        }
                        else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                            alt86=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 86, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 139:
                    case 140:
                        {
                        alt86=1;
                        }
                        break;
                    case 143:
                    case 144:
                        {
                        alt86=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 2, input);

                        throw nvae;
                    }

                    }
                    break;
                case 137:
                    {
                    switch ( input.LA(3) ) {
                    case 138:
                        {
                        int LA86_4 = input.LA(4);

                        if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                            alt86=1;
                        }
                        else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                            alt86=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 86, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 143:
                    case 144:
                        {
                        alt86=2;
                        }
                        break;
                    case 139:
                    case 140:
                        {
                        alt86=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                case 138:
                    {
                    int LA86_4 = input.LA(3);

                    if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                        alt86=1;
                    }
                    else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                        alt86=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 143:
                case 144:
                    {
                    alt86=2;
                    }
                    break;
                case 139:
                case 140:
                    {
                    alt86=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;
                }

                }
                break;
            case 136:
                {
                switch ( input.LA(2) ) {
                case 137:
                    {
                    switch ( input.LA(3) ) {
                    case 138:
                        {
                        int LA86_4 = input.LA(4);

                        if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                            alt86=1;
                        }
                        else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                            alt86=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 86, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 143:
                    case 144:
                        {
                        alt86=2;
                        }
                        break;
                    case 139:
                    case 140:
                        {
                        alt86=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                case 138:
                    {
                    int LA86_4 = input.LA(3);

                    if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                        alt86=1;
                    }
                    else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                        alt86=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 139:
                case 140:
                    {
                    alt86=1;
                    }
                    break;
                case 143:
                case 144:
                    {
                    alt86=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 2, input);

                    throw nvae;
                }

                }
                break;
            case 137:
                {
                switch ( input.LA(2) ) {
                case 138:
                    {
                    int LA86_4 = input.LA(3);

                    if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                        alt86=1;
                    }
                    else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                        alt86=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 143:
                case 144:
                    {
                    alt86=2;
                    }
                    break;
                case 139:
                case 140:
                    {
                    alt86=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 3, input);

                    throw nvae;
                }

                }
                break;
            case 138:
                {
                int LA86_4 = input.LA(2);

                if ( ((LA86_4>=139 && LA86_4<=140)) ) {
                    alt86=1;
                }
                else if ( ((LA86_4>=143 && LA86_4<=144)) ) {
                    alt86=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 4, input);

                    throw nvae;
                }
                }
                break;
            case 139:
            case 140:
                {
                alt86=1;
                }
                break;
            case 143:
            case 144:
                {
                alt86=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4264:5: this_EAttribute_0= ruleEAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getEStructuralFeatureAccess().getEAttributeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleEStructuralFeature9026);
                    this_EAttribute_0=ruleEAttribute();

                    state._fsp--;

                     
                            current = this_EAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4274:5: this_EReference_1= ruleEReference
                    {
                     
                            newCompositeNode(grammarAccess.getEStructuralFeatureAccess().getEReferenceParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEReference_in_ruleEStructuralFeature9053);
                    this_EReference_1=ruleEReference();

                    state._fsp--;

                     
                            current = this_EReference_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEStructuralFeature"


    // $ANTLR start "entryRuleEClass"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4290:1: entryRuleEClass returns [EObject current=null] : iv_ruleEClass= ruleEClass EOF ;
    public final EObject entryRuleEClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClass = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4291:2: (iv_ruleEClass= ruleEClass EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4292:2: iv_ruleEClass= ruleEClass EOF
            {
             newCompositeNode(grammarAccess.getEClassRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEClass_in_entryRuleEClass9088);
            iv_ruleEClass=ruleEClass();

            state._fsp--;

             current =iv_ruleEClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEClass9098); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClass"


    // $ANTLR start "ruleEClass"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4299:1: ruleEClass returns [EObject current=null] : ( () ( (lv_abstract_1_0= 'abstract' ) )? ( (lv_interface_2_0= 'interface' ) )? otherlv_3= 'EClass' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )? (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )? (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )? (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )? (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )? (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )? (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' ) ;
    public final EObject ruleEClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token lv_interface_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_7_0 = null;

        AntlrDatatypeRuleToken lv_instanceTypeName_9_0 = null;

        EObject lv_eAnnotations_18_0 = null;

        EObject lv_eAnnotations_20_0 = null;

        EObject lv_eTypeParameters_24_0 = null;

        EObject lv_eTypeParameters_26_0 = null;

        EObject lv_eOperations_30_0 = null;

        EObject lv_eOperations_32_0 = null;

        EObject lv_eStructuralFeatures_36_0 = null;

        EObject lv_eStructuralFeatures_38_0 = null;

        EObject lv_eGenericSuperTypes_42_0 = null;

        EObject lv_eGenericSuperTypes_44_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4302:28: ( ( () ( (lv_abstract_1_0= 'abstract' ) )? ( (lv_interface_2_0= 'interface' ) )? otherlv_3= 'EClass' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )? (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )? (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )? (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )? (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )? (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )? (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4303:1: ( () ( (lv_abstract_1_0= 'abstract' ) )? ( (lv_interface_2_0= 'interface' ) )? otherlv_3= 'EClass' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )? (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )? (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )? (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )? (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )? (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )? (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4303:1: ( () ( (lv_abstract_1_0= 'abstract' ) )? ( (lv_interface_2_0= 'interface' ) )? otherlv_3= 'EClass' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )? (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )? (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )? (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )? (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )? (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )? (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4303:2: () ( (lv_abstract_1_0= 'abstract' ) )? ( (lv_interface_2_0= 'interface' ) )? otherlv_3= 'EClass' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )? (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )? (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )? (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )? (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )? (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )? (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4303:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4304:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEClassAccess().getEClassAction_0(),
                        current);
                

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4309:2: ( (lv_abstract_1_0= 'abstract' ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==93) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4310:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4310:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4311:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleEClass9150); 

                            newLeafNode(lv_abstract_1_0, grammarAccess.getEClassAccess().getAbstractAbstractKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEClassRule());
                    	        }
                           		setWithLastConsumed(current, "abstract", true, "abstract");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4324:3: ( (lv_interface_2_0= 'interface' ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==94) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4325:1: (lv_interface_2_0= 'interface' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4325:1: (lv_interface_2_0= 'interface' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4326:3: lv_interface_2_0= 'interface'
                    {
                    lv_interface_2_0=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleEClass9182); 

                            newLeafNode(lv_interface_2_0, grammarAccess.getEClassAccess().getInterfaceInterfaceKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEClassRule());
                    	        }
                           		setWithLastConsumed(current, "interface", true, "interface");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleEClass9208); 

                	newLeafNode(otherlv_3, grammarAccess.getEClassAccess().getEClassKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4343:1: ( (lv_name_4_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4344:1: (lv_name_4_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4344:1: (lv_name_4_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4345:3: lv_name_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEClassAccess().getNameEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEClass9229);
            lv_name_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEClassRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9241); 

                	newLeafNode(otherlv_5, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4365:1: (otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==96) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4365:3: otherlv_6= 'instanceClassName' ( (lv_instanceClassName_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleEClass9254); 

                        	newLeafNode(otherlv_6, grammarAccess.getEClassAccess().getInstanceClassNameKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4369:1: ( (lv_instanceClassName_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4370:1: (lv_instanceClassName_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4370:1: (lv_instanceClassName_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4371:3: lv_instanceClassName_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getInstanceClassNameEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEClass9275);
                    lv_instanceClassName_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceClassName",
                            		lv_instanceClassName_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4387:4: (otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==97) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4387:6: otherlv_8= 'instanceTypeName' ( (lv_instanceTypeName_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleEClass9290); 

                        	newLeafNode(otherlv_8, grammarAccess.getEClassAccess().getInstanceTypeNameKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4391:1: ( (lv_instanceTypeName_9_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4392:1: (lv_instanceTypeName_9_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4392:1: (lv_instanceTypeName_9_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4393:3: lv_instanceTypeName_9_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getInstanceTypeNameEStringParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEClass9311);
                    lv_instanceTypeName_9_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceTypeName",
                            		lv_instanceTypeName_9_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4409:4: (otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==98) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4409:6: otherlv_10= 'eSuperTypes' otherlv_11= '(' ( ( ruleEString ) ) (otherlv_13= ',' ( ( ruleEString ) ) )* otherlv_15= ')'
                    {
                    otherlv_10=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleEClass9326); 

                        	newLeafNode(otherlv_10, grammarAccess.getEClassAccess().getESuperTypesKeyword_8_0());
                        
                    otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEClass9338); 

                        	newLeafNode(otherlv_11, grammarAccess.getEClassAccess().getLeftParenthesisKeyword_8_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4417:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4418:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4418:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4419:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getESuperTypesEClassCrossReference_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEClass9361);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4432:2: (otherlv_13= ',' ( ( ruleEString ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==14) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4432:4: otherlv_13= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9374); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getEClassAccess().getCommaKeyword_8_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4436:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4437:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4437:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4438:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEClassRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getESuperTypesEClassCrossReference_8_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEClass9397);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEClass9411); 

                        	newLeafNode(otherlv_15, grammarAccess.getEClassAccess().getRightParenthesisKeyword_8_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4455:3: (otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==99) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4455:5: otherlv_16= 'eAnnotations' otherlv_17= '{' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )* otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEClass9426); 

                        	newLeafNode(otherlv_16, grammarAccess.getEClassAccess().getEAnnotationsKeyword_9_0());
                        
                    otherlv_17=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9438); 

                        	newLeafNode(otherlv_17, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4463:1: ( (lv_eAnnotations_18_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4464:1: (lv_eAnnotations_18_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4464:1: (lv_eAnnotations_18_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4465:3: lv_eAnnotations_18_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getEAnnotationsEAnnotationParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEClass9459);
                    lv_eAnnotations_18_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_18_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4481:2: (otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==14) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4481:4: otherlv_19= ',' ( (lv_eAnnotations_20_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_19=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9472); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getEClassAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4485:1: ( (lv_eAnnotations_20_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4486:1: (lv_eAnnotations_20_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4486:1: (lv_eAnnotations_20_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4487:3: lv_eAnnotations_20_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getEAnnotationsEAnnotationParserRuleCall_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEClass9493);
                    	    lv_eAnnotations_20_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_20_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9507); 

                        	newLeafNode(otherlv_21, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_9_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4507:3: (otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==100) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4507:5: otherlv_22= 'eTypeParameters' otherlv_23= '{' ( (lv_eTypeParameters_24_0= ruleETypeParameter ) ) (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )* otherlv_27= '}'
                    {
                    otherlv_22=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleEClass9522); 

                        	newLeafNode(otherlv_22, grammarAccess.getEClassAccess().getETypeParametersKeyword_10_0());
                        
                    otherlv_23=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9534); 

                        	newLeafNode(otherlv_23, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4515:1: ( (lv_eTypeParameters_24_0= ruleETypeParameter ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4516:1: (lv_eTypeParameters_24_0= ruleETypeParameter )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4516:1: (lv_eTypeParameters_24_0= ruleETypeParameter )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4517:3: lv_eTypeParameters_24_0= ruleETypeParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getETypeParametersETypeParameterParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEClass9555);
                    lv_eTypeParameters_24_0=ruleETypeParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_24_0, 
                            		"ETypeParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4533:2: (otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==14) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4533:4: otherlv_25= ',' ( (lv_eTypeParameters_26_0= ruleETypeParameter ) )
                    	    {
                    	    otherlv_25=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9568); 

                    	        	newLeafNode(otherlv_25, grammarAccess.getEClassAccess().getCommaKeyword_10_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4537:1: ( (lv_eTypeParameters_26_0= ruleETypeParameter ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4538:1: (lv_eTypeParameters_26_0= ruleETypeParameter )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4538:1: (lv_eTypeParameters_26_0= ruleETypeParameter )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4539:3: lv_eTypeParameters_26_0= ruleETypeParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getETypeParametersETypeParameterParserRuleCall_10_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEClass9589);
                    	    lv_eTypeParameters_26_0=ruleETypeParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_26_0, 
                    	            		"ETypeParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9603); 

                        	newLeafNode(otherlv_27, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4559:3: (otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==101) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4559:5: otherlv_28= 'eOperations' otherlv_29= '{' ( (lv_eOperations_30_0= ruleEOperation ) ) (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )* otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleEClass9618); 

                        	newLeafNode(otherlv_28, grammarAccess.getEClassAccess().getEOperationsKeyword_11_0());
                        
                    otherlv_29=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9630); 

                        	newLeafNode(otherlv_29, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4567:1: ( (lv_eOperations_30_0= ruleEOperation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4568:1: (lv_eOperations_30_0= ruleEOperation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4568:1: (lv_eOperations_30_0= ruleEOperation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4569:3: lv_eOperations_30_0= ruleEOperation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getEOperationsEOperationParserRuleCall_11_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEOperation_in_ruleEClass9651);
                    lv_eOperations_30_0=ruleEOperation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		add(
                           			current, 
                           			"eOperations",
                            		lv_eOperations_30_0, 
                            		"EOperation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4585:2: (otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==14) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4585:4: otherlv_31= ',' ( (lv_eOperations_32_0= ruleEOperation ) )
                    	    {
                    	    otherlv_31=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9664); 

                    	        	newLeafNode(otherlv_31, grammarAccess.getEClassAccess().getCommaKeyword_11_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4589:1: ( (lv_eOperations_32_0= ruleEOperation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4590:1: (lv_eOperations_32_0= ruleEOperation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4590:1: (lv_eOperations_32_0= ruleEOperation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4591:3: lv_eOperations_32_0= ruleEOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getEOperationsEOperationParserRuleCall_11_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEOperation_in_ruleEClass9685);
                    	    lv_eOperations_32_0=ruleEOperation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eOperations",
                    	            		lv_eOperations_32_0, 
                    	            		"EOperation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop97;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9699); 

                        	newLeafNode(otherlv_33, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_11_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4611:3: (otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==102) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4611:5: otherlv_34= 'eStructuralFeatures' otherlv_35= '{' ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) ) (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )* otherlv_39= '}'
                    {
                    otherlv_34=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleEClass9714); 

                        	newLeafNode(otherlv_34, grammarAccess.getEClassAccess().getEStructuralFeaturesKeyword_12_0());
                        
                    otherlv_35=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9726); 

                        	newLeafNode(otherlv_35, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_12_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4619:1: ( (lv_eStructuralFeatures_36_0= ruleEStructuralFeature ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4620:1: (lv_eStructuralFeatures_36_0= ruleEStructuralFeature )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4620:1: (lv_eStructuralFeatures_36_0= ruleEStructuralFeature )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4621:3: lv_eStructuralFeatures_36_0= ruleEStructuralFeature
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getEStructuralFeaturesEStructuralFeatureParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeature_in_ruleEClass9747);
                    lv_eStructuralFeatures_36_0=ruleEStructuralFeature();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		add(
                           			current, 
                           			"eStructuralFeatures",
                            		lv_eStructuralFeatures_36_0, 
                            		"EStructuralFeature");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4637:2: (otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==14) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4637:4: otherlv_37= ',' ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) )
                    	    {
                    	    otherlv_37=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9760); 

                    	        	newLeafNode(otherlv_37, grammarAccess.getEClassAccess().getCommaKeyword_12_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4641:1: ( (lv_eStructuralFeatures_38_0= ruleEStructuralFeature ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4642:1: (lv_eStructuralFeatures_38_0= ruleEStructuralFeature )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4642:1: (lv_eStructuralFeatures_38_0= ruleEStructuralFeature )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4643:3: lv_eStructuralFeatures_38_0= ruleEStructuralFeature
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getEStructuralFeaturesEStructuralFeatureParserRuleCall_12_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEStructuralFeature_in_ruleEClass9781);
                    	    lv_eStructuralFeatures_38_0=ruleEStructuralFeature();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eStructuralFeatures",
                    	            		lv_eStructuralFeatures_38_0, 
                    	            		"EStructuralFeature");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9795); 

                        	newLeafNode(otherlv_39, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_12_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4663:3: (otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==103) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4663:5: otherlv_40= 'eGenericSuperTypes' otherlv_41= '{' ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )* otherlv_45= '}'
                    {
                    otherlv_40=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleEClass9810); 

                        	newLeafNode(otherlv_40, grammarAccess.getEClassAccess().getEGenericSuperTypesKeyword_13_0());
                        
                    otherlv_41=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEClass9822); 

                        	newLeafNode(otherlv_41, grammarAccess.getEClassAccess().getLeftCurlyBracketKeyword_13_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4671:1: ( (lv_eGenericSuperTypes_42_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4672:1: (lv_eGenericSuperTypes_42_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4672:1: (lv_eGenericSuperTypes_42_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4673:3: lv_eGenericSuperTypes_42_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassAccess().getEGenericSuperTypesEGenericTypeParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEClass9843);
                    lv_eGenericSuperTypes_42_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	        }
                           		add(
                           			current, 
                           			"eGenericSuperTypes",
                            		lv_eGenericSuperTypes_42_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4689:2: (otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==14) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4689:4: otherlv_43= ',' ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) )
                    	    {
                    	    otherlv_43=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEClass9856); 

                    	        	newLeafNode(otherlv_43, grammarAccess.getEClassAccess().getCommaKeyword_13_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4693:1: ( (lv_eGenericSuperTypes_44_0= ruleEGenericType ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4694:1: (lv_eGenericSuperTypes_44_0= ruleEGenericType )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4694:1: (lv_eGenericSuperTypes_44_0= ruleEGenericType )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4695:3: lv_eGenericSuperTypes_44_0= ruleEGenericType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassAccess().getEGenericSuperTypesEGenericTypeParserRuleCall_13_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEClass9877);
                    	    lv_eGenericSuperTypes_44_0=ruleEGenericType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eGenericSuperTypes",
                    	            		lv_eGenericSuperTypes_44_0, 
                    	            		"EGenericType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
                    } while (true);

                    otherlv_45=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9891); 

                        	newLeafNode(otherlv_45, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_13_4());
                        

                    }
                    break;

            }

            otherlv_46=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEClass9905); 

                	newLeafNode(otherlv_46, grammarAccess.getEClassAccess().getRightCurlyBracketKeyword_14());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEClass"


    // $ANTLR start "entryRuleEString"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4727:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4728:2: (iv_ruleEString= ruleEString EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4729:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString9942);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString9953); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4736:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4739:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4740:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4740:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_STRING) ) {
                alt103=1;
            }
            else if ( (LA103_0==RULE_ID) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4740:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString9993); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4748:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString10019); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEBoolean"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4763:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4764:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4765:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean10065);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean10076); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4772:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4775:28: ( (kw= 'true' | kw= 'false' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4776:1: (kw= 'true' | kw= 'false' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4776:1: (kw= 'true' | kw= 'false' )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==104) ) {
                alt104=1;
            }
            else if ( (LA104_0==105) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4777:2: kw= 'true'
                    {
                    kw=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleEBoolean10114); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4784:2: kw= 'false'
                    {
                    kw=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleEBoolean10133); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEInt"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4797:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4798:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4799:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt10174);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt10185); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4806:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4809:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4810:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4810:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4810:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4810:2: (kw= '-' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==106) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4811:2: kw= '-'
                    {
                    kw=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleEInt10224); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt10241); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEAnnotation"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4831:1: entryRuleEAnnotation returns [EObject current=null] : iv_ruleEAnnotation= ruleEAnnotation EOF ;
    public final EObject entryRuleEAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotation = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4832:2: (iv_ruleEAnnotation= ruleEAnnotation EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4833:2: iv_ruleEAnnotation= ruleEAnnotation EOF
            {
             newCompositeNode(grammarAccess.getEAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_entryRuleEAnnotation10286);
            iv_ruleEAnnotation=ruleEAnnotation();

            state._fsp--;

             current =iv_ruleEAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAnnotation10296); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEAnnotation"


    // $ANTLR start "ruleEAnnotation"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4840:1: ruleEAnnotation returns [EObject current=null] : ( () otherlv_1= 'EAnnotation' otherlv_2= '{' (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )? (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )? (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )? (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )? otherlv_29= '}' ) ;
    public final EObject ruleEAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_source_4_0 = null;

        EObject lv_eAnnotations_13_0 = null;

        EObject lv_eAnnotations_15_0 = null;

        EObject lv_details_19_0 = null;

        EObject lv_details_21_0 = null;

        EObject lv_contents_25_0 = null;

        EObject lv_contents_27_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4843:28: ( ( () otherlv_1= 'EAnnotation' otherlv_2= '{' (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )? (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )? (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )? (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )? otherlv_29= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4844:1: ( () otherlv_1= 'EAnnotation' otherlv_2= '{' (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )? (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )? (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )? (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )? otherlv_29= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4844:1: ( () otherlv_1= 'EAnnotation' otherlv_2= '{' (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )? (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )? (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )? (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )? otherlv_29= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4844:2: () otherlv_1= 'EAnnotation' otherlv_2= '{' (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )? (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )? (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )? (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )? otherlv_29= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4844:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4845:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEAnnotationAccess().getEAnnotationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleEAnnotation10342); 

                	newLeafNode(otherlv_1, grammarAccess.getEAnnotationAccess().getEAnnotationKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAnnotation10354); 

                	newLeafNode(otherlv_2, grammarAccess.getEAnnotationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4858:1: (otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==108) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4858:3: otherlv_3= 'source' ( (lv_source_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleEAnnotation10367); 

                        	newLeafNode(otherlv_3, grammarAccess.getEAnnotationAccess().getSourceKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4862:1: ( (lv_source_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4863:1: (lv_source_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4863:1: (lv_source_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4864:3: lv_source_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getSourceEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAnnotation10388);
                    lv_source_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4880:4: (otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==109) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4880:6: otherlv_5= 'references' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')'
                    {
                    otherlv_5=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleEAnnotation10403); 

                        	newLeafNode(otherlv_5, grammarAccess.getEAnnotationAccess().getReferencesKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEAnnotation10415); 

                        	newLeafNode(otherlv_6, grammarAccess.getEAnnotationAccess().getLeftParenthesisKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4888:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4889:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4889:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4890:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAnnotationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getReferencesEObjectCrossReference_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAnnotation10438);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4903:2: (otherlv_8= ',' ( ( ruleEString ) ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==14) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4903:4: otherlv_8= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEAnnotation10451); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getEAnnotationAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4907:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4908:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4908:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4909:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEAnnotationRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getReferencesEObjectCrossReference_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAnnotation10474);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop107;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEAnnotation10488); 

                        	newLeafNode(otherlv_10, grammarAccess.getEAnnotationAccess().getRightParenthesisKeyword_4_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4926:3: (otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==99) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4926:5: otherlv_11= 'eAnnotations' otherlv_12= '{' ( (lv_eAnnotations_13_0= ruleEAnnotation ) ) (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )* otherlv_16= '}'
                    {
                    otherlv_11=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEAnnotation10503); 

                        	newLeafNode(otherlv_11, grammarAccess.getEAnnotationAccess().getEAnnotationsKeyword_5_0());
                        
                    otherlv_12=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAnnotation10515); 

                        	newLeafNode(otherlv_12, grammarAccess.getEAnnotationAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4934:1: ( (lv_eAnnotations_13_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4935:1: (lv_eAnnotations_13_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4935:1: (lv_eAnnotations_13_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4936:3: lv_eAnnotations_13_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getEAnnotationsEAnnotationParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEAnnotation10536);
                    lv_eAnnotations_13_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_13_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4952:2: (otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) ) )*
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==14) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4952:4: otherlv_14= ',' ( (lv_eAnnotations_15_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEAnnotation10549); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getEAnnotationAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4956:1: ( (lv_eAnnotations_15_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4957:1: (lv_eAnnotations_15_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4957:1: (lv_eAnnotations_15_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4958:3: lv_eAnnotations_15_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getEAnnotationsEAnnotationParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEAnnotation10570);
                    	    lv_eAnnotations_15_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_15_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop109;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAnnotation10584); 

                        	newLeafNode(otherlv_16, grammarAccess.getEAnnotationAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4978:3: (otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==110) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4978:5: otherlv_17= 'details' otherlv_18= '{' ( (lv_details_19_0= ruleEStringToStringMapEntry ) ) (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )* otherlv_22= '}'
                    {
                    otherlv_17=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleEAnnotation10599); 

                        	newLeafNode(otherlv_17, grammarAccess.getEAnnotationAccess().getDetailsKeyword_6_0());
                        
                    otherlv_18=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAnnotation10611); 

                        	newLeafNode(otherlv_18, grammarAccess.getEAnnotationAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4986:1: ( (lv_details_19_0= ruleEStringToStringMapEntry ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4987:1: (lv_details_19_0= ruleEStringToStringMapEntry )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4987:1: (lv_details_19_0= ruleEStringToStringMapEntry )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:4988:3: lv_details_19_0= ruleEStringToStringMapEntry
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getDetailsEStringToStringMapEntryParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEStringToStringMapEntry_in_ruleEAnnotation10632);
                    lv_details_19_0=ruleEStringToStringMapEntry();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"details",
                            		lv_details_19_0, 
                            		"EStringToStringMapEntry");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5004:2: (otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==14) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5004:4: otherlv_20= ',' ( (lv_details_21_0= ruleEStringToStringMapEntry ) )
                    	    {
                    	    otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEAnnotation10645); 

                    	        	newLeafNode(otherlv_20, grammarAccess.getEAnnotationAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5008:1: ( (lv_details_21_0= ruleEStringToStringMapEntry ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5009:1: (lv_details_21_0= ruleEStringToStringMapEntry )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5009:1: (lv_details_21_0= ruleEStringToStringMapEntry )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5010:3: lv_details_21_0= ruleEStringToStringMapEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getDetailsEStringToStringMapEntryParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEStringToStringMapEntry_in_ruleEAnnotation10666);
                    	    lv_details_21_0=ruleEStringToStringMapEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"details",
                    	            		lv_details_21_0, 
                    	            		"EStringToStringMapEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop111;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAnnotation10680); 

                        	newLeafNode(otherlv_22, grammarAccess.getEAnnotationAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5030:3: (otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}' )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==111) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5030:5: otherlv_23= 'contents' otherlv_24= '{' ( (lv_contents_25_0= ruleEObject ) ) (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )* otherlv_28= '}'
                    {
                    otherlv_23=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleEAnnotation10695); 

                        	newLeafNode(otherlv_23, grammarAccess.getEAnnotationAccess().getContentsKeyword_7_0());
                        
                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAnnotation10707); 

                        	newLeafNode(otherlv_24, grammarAccess.getEAnnotationAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5038:1: ( (lv_contents_25_0= ruleEObject ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5039:1: (lv_contents_25_0= ruleEObject )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5039:1: (lv_contents_25_0= ruleEObject )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5040:3: lv_contents_25_0= ruleEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getContentsEObjectParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleEAnnotation10728);
                    lv_contents_25_0=ruleEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_25_0, 
                            		"EObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5056:2: (otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==14) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5056:4: otherlv_26= ',' ( (lv_contents_27_0= ruleEObject ) )
                    	    {
                    	    otherlv_26=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEAnnotation10741); 

                    	        	newLeafNode(otherlv_26, grammarAccess.getEAnnotationAccess().getCommaKeyword_7_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5060:1: ( (lv_contents_27_0= ruleEObject ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5061:1: (lv_contents_27_0= ruleEObject )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5061:1: (lv_contents_27_0= ruleEObject )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5062:3: lv_contents_27_0= ruleEObject
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAnnotationAccess().getContentsEObjectParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleEAnnotation10762);
                    	    lv_contents_27_0=ruleEObject();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"contents",
                    	            		lv_contents_27_0, 
                    	            		"EObject");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop113;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAnnotation10776); 

                        	newLeafNode(otherlv_28, grammarAccess.getEAnnotationAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            otherlv_29=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAnnotation10790); 

                	newLeafNode(otherlv_29, grammarAccess.getEAnnotationAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEAnnotation"


    // $ANTLR start "entryRuleETypeParameter"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5094:1: entryRuleETypeParameter returns [EObject current=null] : iv_ruleETypeParameter= ruleETypeParameter EOF ;
    public final EObject entryRuleETypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameter = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5095:2: (iv_ruleETypeParameter= ruleETypeParameter EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5096:2: iv_ruleETypeParameter= ruleETypeParameter EOF
            {
             newCompositeNode(grammarAccess.getETypeParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_entryRuleETypeParameter10826);
            iv_ruleETypeParameter=ruleETypeParameter();

            state._fsp--;

             current =iv_ruleETypeParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleETypeParameter10836); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleETypeParameter"


    // $ANTLR start "ruleETypeParameter"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5103:1: ruleETypeParameter returns [EObject current=null] : ( () otherlv_1= 'ETypeParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )? (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )? otherlv_16= '}' ) ;
    public final EObject ruleETypeParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_eAnnotations_6_0 = null;

        EObject lv_eAnnotations_8_0 = null;

        EObject lv_eBounds_12_0 = null;

        EObject lv_eBounds_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5106:28: ( ( () otherlv_1= 'ETypeParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )? (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )? otherlv_16= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5107:1: ( () otherlv_1= 'ETypeParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )? (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )? otherlv_16= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5107:1: ( () otherlv_1= 'ETypeParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )? (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )? otherlv_16= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5107:2: () otherlv_1= 'ETypeParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )? (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )? otherlv_16= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5107:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5108:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getETypeParameterAccess().getETypeParameterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleETypeParameter10882); 

                	newLeafNode(otherlv_1, grammarAccess.getETypeParameterAccess().getETypeParameterKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5117:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5118:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5118:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5119:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getETypeParameterAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleETypeParameter10903);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getETypeParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleETypeParameter10915); 

                	newLeafNode(otherlv_3, grammarAccess.getETypeParameterAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5139:1: (otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}' )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==99) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5139:3: otherlv_4= 'eAnnotations' otherlv_5= '{' ( (lv_eAnnotations_6_0= ruleEAnnotation ) ) (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleETypeParameter10928); 

                        	newLeafNode(otherlv_4, grammarAccess.getETypeParameterAccess().getEAnnotationsKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleETypeParameter10940); 

                        	newLeafNode(otherlv_5, grammarAccess.getETypeParameterAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5147:1: ( (lv_eAnnotations_6_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5148:1: (lv_eAnnotations_6_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5148:1: (lv_eAnnotations_6_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5149:3: lv_eAnnotations_6_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getETypeParameterAccess().getEAnnotationsEAnnotationParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleETypeParameter10961);
                    lv_eAnnotations_6_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getETypeParameterRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_6_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5165:2: (otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==14) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5165:4: otherlv_7= ',' ( (lv_eAnnotations_8_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleETypeParameter10974); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getETypeParameterAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5169:1: ( (lv_eAnnotations_8_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5170:1: (lv_eAnnotations_8_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5170:1: (lv_eAnnotations_8_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5171:3: lv_eAnnotations_8_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getETypeParameterAccess().getEAnnotationsEAnnotationParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleETypeParameter10995);
                    	    lv_eAnnotations_8_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getETypeParameterRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_8_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleETypeParameter11009); 

                        	newLeafNode(otherlv_9, grammarAccess.getETypeParameterAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5191:3: (otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==113) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5191:5: otherlv_10= 'eBounds' otherlv_11= '{' ( (lv_eBounds_12_0= ruleEGenericType ) ) (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleETypeParameter11024); 

                        	newLeafNode(otherlv_10, grammarAccess.getETypeParameterAccess().getEBoundsKeyword_5_0());
                        
                    otherlv_11=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleETypeParameter11036); 

                        	newLeafNode(otherlv_11, grammarAccess.getETypeParameterAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5199:1: ( (lv_eBounds_12_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5200:1: (lv_eBounds_12_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5200:1: (lv_eBounds_12_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5201:3: lv_eBounds_12_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getETypeParameterAccess().getEBoundsEGenericTypeParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleETypeParameter11057);
                    lv_eBounds_12_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getETypeParameterRule());
                    	        }
                           		add(
                           			current, 
                           			"eBounds",
                            		lv_eBounds_12_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5217:2: (otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) ) )*
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==14) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5217:4: otherlv_13= ',' ( (lv_eBounds_14_0= ruleEGenericType ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleETypeParameter11070); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getETypeParameterAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5221:1: ( (lv_eBounds_14_0= ruleEGenericType ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5222:1: (lv_eBounds_14_0= ruleEGenericType )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5222:1: (lv_eBounds_14_0= ruleEGenericType )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5223:3: lv_eBounds_14_0= ruleEGenericType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getETypeParameterAccess().getEBoundsEGenericTypeParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleETypeParameter11091);
                    	    lv_eBounds_14_0=ruleEGenericType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getETypeParameterRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eBounds",
                    	            		lv_eBounds_14_0, 
                    	            		"EGenericType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop117;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleETypeParameter11105); 

                        	newLeafNode(otherlv_15, grammarAccess.getETypeParameterAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_16=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleETypeParameter11119); 

                	newLeafNode(otherlv_16, grammarAccess.getETypeParameterAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleETypeParameter"


    // $ANTLR start "entryRuleEOperation"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5255:1: entryRuleEOperation returns [EObject current=null] : iv_ruleEOperation= ruleEOperation EOF ;
    public final EObject entryRuleEOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperation = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5256:2: (iv_ruleEOperation= ruleEOperation EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5257:2: iv_ruleEOperation= ruleEOperation EOF
            {
             newCompositeNode(grammarAccess.getEOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEOperation_in_entryRuleEOperation11155);
            iv_ruleEOperation=ruleEOperation();

            state._fsp--;

             current =iv_ruleEOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEOperation11165); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEOperation"


    // $ANTLR start "ruleEOperation"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5264:1: ruleEOperation returns [EObject current=null] : ( () otherlv_1= 'EOperation' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )? (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )? (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )? (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' ) ;
    public final EObject ruleEOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_ordered_5_0 = null;

        AntlrDatatypeRuleToken lv_unique_7_0 = null;

        AntlrDatatypeRuleToken lv_lowerBound_9_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_11_0 = null;

        EObject lv_eAnnotations_22_0 = null;

        EObject lv_eAnnotations_24_0 = null;

        EObject lv_eGenericType_27_0 = null;

        EObject lv_eTypeParameters_30_0 = null;

        EObject lv_eTypeParameters_32_0 = null;

        EObject lv_eParameters_36_0 = null;

        EObject lv_eParameters_38_0 = null;

        EObject lv_eGenericExceptions_42_0 = null;

        EObject lv_eGenericExceptions_44_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5267:28: ( ( () otherlv_1= 'EOperation' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )? (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )? (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )? (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5268:1: ( () otherlv_1= 'EOperation' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )? (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )? (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )? (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5268:1: ( () otherlv_1= 'EOperation' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )? (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )? (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )? (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5268:2: () otherlv_1= 'EOperation' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )? (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )? (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )? (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )? (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )? (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )? otherlv_46= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5268:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5269:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEOperationAccess().getEOperationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleEOperation11211); 

                	newLeafNode(otherlv_1, grammarAccess.getEOperationAccess().getEOperationKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5278:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5279:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5279:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5280:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEOperationAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEOperation11232);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEOperationRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEOperation11244); 

                	newLeafNode(otherlv_3, grammarAccess.getEOperationAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5300:1: (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==115) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5300:3: otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) )
                    {
                    otherlv_4=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleEOperation11257); 

                        	newLeafNode(otherlv_4, grammarAccess.getEOperationAccess().getOrderedKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5304:1: ( (lv_ordered_5_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5305:1: (lv_ordered_5_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5305:1: (lv_ordered_5_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5306:3: lv_ordered_5_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getOrderedEBooleanParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEOperation11278);
                    lv_ordered_5_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"ordered",
                            		lv_ordered_5_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5322:4: (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==116) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5322:6: otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) )
                    {
                    otherlv_6=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleEOperation11293); 

                        	newLeafNode(otherlv_6, grammarAccess.getEOperationAccess().getUniqueKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5326:1: ( (lv_unique_7_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5327:1: (lv_unique_7_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5327:1: (lv_unique_7_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5328:3: lv_unique_7_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getUniqueEBooleanParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEOperation11314);
                    lv_unique_7_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"unique",
                            		lv_unique_7_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5344:4: (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==117) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5344:6: otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleEOperation11329); 

                        	newLeafNode(otherlv_8, grammarAccess.getEOperationAccess().getLowerBoundKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5348:1: ( (lv_lowerBound_9_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5349:1: (lv_lowerBound_9_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5349:1: (lv_lowerBound_9_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5350:3: lv_lowerBound_9_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getLowerBoundEIntParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEOperation11350);
                    lv_lowerBound_9_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_9_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5366:4: (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==118) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5366:6: otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) )
                    {
                    otherlv_10=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleEOperation11365); 

                        	newLeafNode(otherlv_10, grammarAccess.getEOperationAccess().getUpperBoundKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5370:1: ( (lv_upperBound_11_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5371:1: (lv_upperBound_11_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5371:1: (lv_upperBound_11_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5372:3: lv_upperBound_11_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getUpperBoundEIntParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEOperation11386);
                    lv_upperBound_11_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_11_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5388:4: (otherlv_12= 'eType' ( ( ruleEString ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==119) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5388:6: otherlv_12= 'eType' ( ( ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleEOperation11401); 

                        	newLeafNode(otherlv_12, grammarAccess.getEOperationAccess().getETypeKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5392:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5393:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5393:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5394:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEOperationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getETypeEClassifierCrossReference_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEOperation11424);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5407:4: (otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==120) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5407:6: otherlv_14= 'eExceptions' otherlv_15= '(' ( ( ruleEString ) ) (otherlv_17= ',' ( ( ruleEString ) ) )* otherlv_19= ')'
                    {
                    otherlv_14=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleEOperation11439); 

                        	newLeafNode(otherlv_14, grammarAccess.getEOperationAccess().getEExceptionsKeyword_9_0());
                        
                    otherlv_15=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEOperation11451); 

                        	newLeafNode(otherlv_15, grammarAccess.getEOperationAccess().getLeftParenthesisKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5415:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5416:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5416:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5417:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEOperationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getEExceptionsEClassifierCrossReference_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEOperation11474);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5430:2: (otherlv_17= ',' ( ( ruleEString ) ) )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==14) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5430:4: otherlv_17= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEOperation11487); 

                    	        	newLeafNode(otherlv_17, grammarAccess.getEOperationAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5434:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5435:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5435:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5436:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEOperationRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationAccess().getEExceptionsEClassifierCrossReference_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEOperation11510);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop124;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEOperation11524); 

                        	newLeafNode(otherlv_19, grammarAccess.getEOperationAccess().getRightParenthesisKeyword_9_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5453:3: (otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==99) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5453:5: otherlv_20= 'eAnnotations' otherlv_21= '{' ( (lv_eAnnotations_22_0= ruleEAnnotation ) ) (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )* otherlv_25= '}'
                    {
                    otherlv_20=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEOperation11539); 

                        	newLeafNode(otherlv_20, grammarAccess.getEOperationAccess().getEAnnotationsKeyword_10_0());
                        
                    otherlv_21=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEOperation11551); 

                        	newLeafNode(otherlv_21, grammarAccess.getEOperationAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5461:1: ( (lv_eAnnotations_22_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5462:1: (lv_eAnnotations_22_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5462:1: (lv_eAnnotations_22_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5463:3: lv_eAnnotations_22_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getEAnnotationsEAnnotationParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEOperation11572);
                    lv_eAnnotations_22_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_22_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5479:2: (otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==14) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5479:4: otherlv_23= ',' ( (lv_eAnnotations_24_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_23=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEOperation11585); 

                    	        	newLeafNode(otherlv_23, grammarAccess.getEOperationAccess().getCommaKeyword_10_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5483:1: ( (lv_eAnnotations_24_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5484:1: (lv_eAnnotations_24_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5484:1: (lv_eAnnotations_24_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5485:3: lv_eAnnotations_24_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationAccess().getEAnnotationsEAnnotationParserRuleCall_10_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEOperation11606);
                    	    lv_eAnnotations_24_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_24_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_25=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEOperation11620); 

                        	newLeafNode(otherlv_25, grammarAccess.getEOperationAccess().getRightCurlyBracketKeyword_10_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5505:3: (otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==121) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5505:5: otherlv_26= 'eGenericType' ( (lv_eGenericType_27_0= ruleEGenericType ) )
                    {
                    otherlv_26=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleEOperation11635); 

                        	newLeafNode(otherlv_26, grammarAccess.getEOperationAccess().getEGenericTypeKeyword_11_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5509:1: ( (lv_eGenericType_27_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5510:1: (lv_eGenericType_27_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5510:1: (lv_eGenericType_27_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5511:3: lv_eGenericType_27_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getEGenericTypeEGenericTypeParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEOperation11656);
                    lv_eGenericType_27_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"eGenericType",
                            		lv_eGenericType_27_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5527:4: (otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}' )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==100) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5527:6: otherlv_28= 'eTypeParameters' otherlv_29= '{' ( (lv_eTypeParameters_30_0= ruleETypeParameter ) ) (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )* otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleEOperation11671); 

                        	newLeafNode(otherlv_28, grammarAccess.getEOperationAccess().getETypeParametersKeyword_12_0());
                        
                    otherlv_29=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEOperation11683); 

                        	newLeafNode(otherlv_29, grammarAccess.getEOperationAccess().getLeftCurlyBracketKeyword_12_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5535:1: ( (lv_eTypeParameters_30_0= ruleETypeParameter ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5536:1: (lv_eTypeParameters_30_0= ruleETypeParameter )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5536:1: (lv_eTypeParameters_30_0= ruleETypeParameter )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5537:3: lv_eTypeParameters_30_0= ruleETypeParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getETypeParametersETypeParameterParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEOperation11704);
                    lv_eTypeParameters_30_0=ruleETypeParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_30_0, 
                            		"ETypeParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5553:2: (otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) ) )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==14) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5553:4: otherlv_31= ',' ( (lv_eTypeParameters_32_0= ruleETypeParameter ) )
                    	    {
                    	    otherlv_31=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEOperation11717); 

                    	        	newLeafNode(otherlv_31, grammarAccess.getEOperationAccess().getCommaKeyword_12_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5557:1: ( (lv_eTypeParameters_32_0= ruleETypeParameter ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5558:1: (lv_eTypeParameters_32_0= ruleETypeParameter )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5558:1: (lv_eTypeParameters_32_0= ruleETypeParameter )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5559:3: lv_eTypeParameters_32_0= ruleETypeParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationAccess().getETypeParametersETypeParameterParserRuleCall_12_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEOperation11738);
                    	    lv_eTypeParameters_32_0=ruleETypeParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_32_0, 
                    	            		"ETypeParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEOperation11752); 

                        	newLeafNode(otherlv_33, grammarAccess.getEOperationAccess().getRightCurlyBracketKeyword_12_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5579:3: (otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}' )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==122) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5579:5: otherlv_34= 'eParameters' otherlv_35= '{' ( (lv_eParameters_36_0= ruleEParameter ) ) (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )* otherlv_39= '}'
                    {
                    otherlv_34=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleEOperation11767); 

                        	newLeafNode(otherlv_34, grammarAccess.getEOperationAccess().getEParametersKeyword_13_0());
                        
                    otherlv_35=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEOperation11779); 

                        	newLeafNode(otherlv_35, grammarAccess.getEOperationAccess().getLeftCurlyBracketKeyword_13_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5587:1: ( (lv_eParameters_36_0= ruleEParameter ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5588:1: (lv_eParameters_36_0= ruleEParameter )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5588:1: (lv_eParameters_36_0= ruleEParameter )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5589:3: lv_eParameters_36_0= ruleEParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getEParametersEParameterParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEParameter_in_ruleEOperation11800);
                    lv_eParameters_36_0=ruleEParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"eParameters",
                            		lv_eParameters_36_0, 
                            		"EParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5605:2: (otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) ) )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==14) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5605:4: otherlv_37= ',' ( (lv_eParameters_38_0= ruleEParameter ) )
                    	    {
                    	    otherlv_37=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEOperation11813); 

                    	        	newLeafNode(otherlv_37, grammarAccess.getEOperationAccess().getCommaKeyword_13_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5609:1: ( (lv_eParameters_38_0= ruleEParameter ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5610:1: (lv_eParameters_38_0= ruleEParameter )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5610:1: (lv_eParameters_38_0= ruleEParameter )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5611:3: lv_eParameters_38_0= ruleEParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationAccess().getEParametersEParameterParserRuleCall_13_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEParameter_in_ruleEOperation11834);
                    	    lv_eParameters_38_0=ruleEParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eParameters",
                    	            		lv_eParameters_38_0, 
                    	            		"EParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop131;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEOperation11848); 

                        	newLeafNode(otherlv_39, grammarAccess.getEOperationAccess().getRightCurlyBracketKeyword_13_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5631:3: (otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}' )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==123) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5631:5: otherlv_40= 'eGenericExceptions' otherlv_41= '{' ( (lv_eGenericExceptions_42_0= ruleEGenericType ) ) (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )* otherlv_45= '}'
                    {
                    otherlv_40=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleEOperation11863); 

                        	newLeafNode(otherlv_40, grammarAccess.getEOperationAccess().getEGenericExceptionsKeyword_14_0());
                        
                    otherlv_41=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEOperation11875); 

                        	newLeafNode(otherlv_41, grammarAccess.getEOperationAccess().getLeftCurlyBracketKeyword_14_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5639:1: ( (lv_eGenericExceptions_42_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5640:1: (lv_eGenericExceptions_42_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5640:1: (lv_eGenericExceptions_42_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5641:3: lv_eGenericExceptions_42_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationAccess().getEGenericExceptionsEGenericTypeParserRuleCall_14_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEOperation11896);
                    lv_eGenericExceptions_42_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"eGenericExceptions",
                            		lv_eGenericExceptions_42_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5657:2: (otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==14) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5657:4: otherlv_43= ',' ( (lv_eGenericExceptions_44_0= ruleEGenericType ) )
                    	    {
                    	    otherlv_43=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEOperation11909); 

                    	        	newLeafNode(otherlv_43, grammarAccess.getEOperationAccess().getCommaKeyword_14_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5661:1: ( (lv_eGenericExceptions_44_0= ruleEGenericType ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5662:1: (lv_eGenericExceptions_44_0= ruleEGenericType )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5662:1: (lv_eGenericExceptions_44_0= ruleEGenericType )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5663:3: lv_eGenericExceptions_44_0= ruleEGenericType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationAccess().getEGenericExceptionsEGenericTypeParserRuleCall_14_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEOperation11930);
                    	    lv_eGenericExceptions_44_0=ruleEGenericType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eGenericExceptions",
                    	            		lv_eGenericExceptions_44_0, 
                    	            		"EGenericType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop133;
                        }
                    } while (true);

                    otherlv_45=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEOperation11944); 

                        	newLeafNode(otherlv_45, grammarAccess.getEOperationAccess().getRightCurlyBracketKeyword_14_4());
                        

                    }
                    break;

            }

            otherlv_46=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEOperation11958); 

                	newLeafNode(otherlv_46, grammarAccess.getEOperationAccess().getRightCurlyBracketKeyword_15());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEOperation"


    // $ANTLR start "entryRuleEGenericType"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5695:1: entryRuleEGenericType returns [EObject current=null] : iv_ruleEGenericType= ruleEGenericType EOF ;
    public final EObject entryRuleEGenericType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericType = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5696:2: (iv_ruleEGenericType= ruleEGenericType EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5697:2: iv_ruleEGenericType= ruleEGenericType EOF
            {
             newCompositeNode(grammarAccess.getEGenericTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_entryRuleEGenericType11994);
            iv_ruleEGenericType=ruleEGenericType();

            state._fsp--;

             current =iv_ruleEGenericType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEGenericType12004); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEGenericType"


    // $ANTLR start "ruleEGenericType"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5704:1: ruleEGenericType returns [EObject current=null] : ( () otherlv_1= 'EGenericType' otherlv_2= '{' (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )? (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )? (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )? (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )? (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )? otherlv_17= '}' ) ;
    public final EObject ruleEGenericType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_eUpperBound_8_0 = null;

        EObject lv_eTypeArguments_11_0 = null;

        EObject lv_eTypeArguments_13_0 = null;

        EObject lv_eLowerBound_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5707:28: ( ( () otherlv_1= 'EGenericType' otherlv_2= '{' (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )? (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )? (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )? (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )? (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )? otherlv_17= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5708:1: ( () otherlv_1= 'EGenericType' otherlv_2= '{' (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )? (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )? (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )? (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )? (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )? otherlv_17= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5708:1: ( () otherlv_1= 'EGenericType' otherlv_2= '{' (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )? (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )? (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )? (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )? (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )? otherlv_17= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5708:2: () otherlv_1= 'EGenericType' otherlv_2= '{' (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )? (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )? (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )? (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )? (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )? otherlv_17= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5708:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5709:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEGenericTypeAccess().getEGenericTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleEGenericType12050); 

                	newLeafNode(otherlv_1, grammarAccess.getEGenericTypeAccess().getEGenericTypeKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEGenericType12062); 

                	newLeafNode(otherlv_2, grammarAccess.getEGenericTypeAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5722:1: (otherlv_3= 'eTypeParameter' ( ( ruleEString ) ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==125) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5722:3: otherlv_3= 'eTypeParameter' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleEGenericType12075); 

                        	newLeafNode(otherlv_3, grammarAccess.getEGenericTypeAccess().getETypeParameterKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5726:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5727:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5727:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5728:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getETypeParameterETypeParameterCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEGenericType12098);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5741:4: (otherlv_5= 'eClassifier' ( ( ruleEString ) ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==126) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5741:6: otherlv_5= 'eClassifier' ( ( ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleEGenericType12113); 

                        	newLeafNode(otherlv_5, grammarAccess.getEGenericTypeAccess().getEClassifierKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5745:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5746:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5746:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5747:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getEClassifierEClassifierCrossReference_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEGenericType12136);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5760:4: (otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==127) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5760:6: otherlv_7= 'eUpperBound' ( (lv_eUpperBound_8_0= ruleEGenericType ) )
                    {
                    otherlv_7=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleEGenericType12151); 

                        	newLeafNode(otherlv_7, grammarAccess.getEGenericTypeAccess().getEUpperBoundKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5764:1: ( (lv_eUpperBound_8_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5765:1: (lv_eUpperBound_8_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5765:1: (lv_eUpperBound_8_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5766:3: lv_eUpperBound_8_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getEUpperBoundEGenericTypeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEGenericType12172);
                    lv_eUpperBound_8_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEGenericTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"eUpperBound",
                            		lv_eUpperBound_8_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5782:4: (otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}' )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==128) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5782:6: otherlv_9= 'eTypeArguments' otherlv_10= '{' ( (lv_eTypeArguments_11_0= ruleEGenericType ) ) (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleEGenericType12187); 

                        	newLeafNode(otherlv_9, grammarAccess.getEGenericTypeAccess().getETypeArgumentsKeyword_6_0());
                        
                    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEGenericType12199); 

                        	newLeafNode(otherlv_10, grammarAccess.getEGenericTypeAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5790:1: ( (lv_eTypeArguments_11_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5791:1: (lv_eTypeArguments_11_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5791:1: (lv_eTypeArguments_11_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5792:3: lv_eTypeArguments_11_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getETypeArgumentsEGenericTypeParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEGenericType12220);
                    lv_eTypeArguments_11_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEGenericTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeArguments",
                            		lv_eTypeArguments_11_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5808:2: (otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) ) )*
                    loop138:
                    do {
                        int alt138=2;
                        int LA138_0 = input.LA(1);

                        if ( (LA138_0==14) ) {
                            alt138=1;
                        }


                        switch (alt138) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5808:4: otherlv_12= ',' ( (lv_eTypeArguments_13_0= ruleEGenericType ) )
                    	    {
                    	    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEGenericType12233); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEGenericTypeAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5812:1: ( (lv_eTypeArguments_13_0= ruleEGenericType ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5813:1: (lv_eTypeArguments_13_0= ruleEGenericType )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5813:1: (lv_eTypeArguments_13_0= ruleEGenericType )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5814:3: lv_eTypeArguments_13_0= ruleEGenericType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getETypeArgumentsEGenericTypeParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEGenericType12254);
                    	    lv_eTypeArguments_13_0=ruleEGenericType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEGenericTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeArguments",
                    	            		lv_eTypeArguments_13_0, 
                    	            		"EGenericType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop138;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEGenericType12268); 

                        	newLeafNode(otherlv_14, grammarAccess.getEGenericTypeAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5834:3: (otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==129) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5834:5: otherlv_15= 'eLowerBound' ( (lv_eLowerBound_16_0= ruleEGenericType ) )
                    {
                    otherlv_15=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleEGenericType12283); 

                        	newLeafNode(otherlv_15, grammarAccess.getEGenericTypeAccess().getELowerBoundKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5838:1: ( (lv_eLowerBound_16_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5839:1: (lv_eLowerBound_16_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5839:1: (lv_eLowerBound_16_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5840:3: lv_eLowerBound_16_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEGenericTypeAccess().getELowerBoundEGenericTypeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEGenericType12304);
                    lv_eLowerBound_16_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEGenericTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"eLowerBound",
                            		lv_eLowerBound_16_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEGenericType12318); 

                	newLeafNode(otherlv_17, grammarAccess.getEGenericTypeAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEGenericType"


    // $ANTLR start "entryRuleEStringToStringMapEntry"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5868:1: entryRuleEStringToStringMapEntry returns [EObject current=null] : iv_ruleEStringToStringMapEntry= ruleEStringToStringMapEntry EOF ;
    public final EObject entryRuleEStringToStringMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStringToStringMapEntry = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5869:2: (iv_ruleEStringToStringMapEntry= ruleEStringToStringMapEntry EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5870:2: iv_ruleEStringToStringMapEntry= ruleEStringToStringMapEntry EOF
            {
             newCompositeNode(grammarAccess.getEStringToStringMapEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEStringToStringMapEntry_in_entryRuleEStringToStringMapEntry12354);
            iv_ruleEStringToStringMapEntry=ruleEStringToStringMapEntry();

            state._fsp--;

             current =iv_ruleEStringToStringMapEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEStringToStringMapEntry12364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEStringToStringMapEntry"


    // $ANTLR start "ruleEStringToStringMapEntry"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5877:1: ruleEStringToStringMapEntry returns [EObject current=null] : ( () otherlv_1= 'EStringToStringMapEntry' otherlv_2= '{' (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )? (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleEStringToStringMapEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_key_4_0 = null;

        AntlrDatatypeRuleToken lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5880:28: ( ( () otherlv_1= 'EStringToStringMapEntry' otherlv_2= '{' (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )? (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5881:1: ( () otherlv_1= 'EStringToStringMapEntry' otherlv_2= '{' (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )? (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5881:1: ( () otherlv_1= 'EStringToStringMapEntry' otherlv_2= '{' (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )? (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5881:2: () otherlv_1= 'EStringToStringMapEntry' otherlv_2= '{' (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )? (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5881:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5882:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEStringToStringMapEntryAccess().getEStringToStringMapEntryAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleEStringToStringMapEntry12410); 

                	newLeafNode(otherlv_1, grammarAccess.getEStringToStringMapEntryAccess().getEStringToStringMapEntryKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEStringToStringMapEntry12422); 

                	newLeafNode(otherlv_2, grammarAccess.getEStringToStringMapEntryAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5895:1: (otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==131) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5895:3: otherlv_3= 'key' ( (lv_key_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleEStringToStringMapEntry12435); 

                        	newLeafNode(otherlv_3, grammarAccess.getEStringToStringMapEntryAccess().getKeyKeyword_3_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5899:1: ( (lv_key_4_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5900:1: (lv_key_4_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5900:1: (lv_key_4_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5901:3: lv_key_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEStringToStringMapEntryAccess().getKeyEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEStringToStringMapEntry12456);
                    lv_key_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEStringToStringMapEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"key",
                            		lv_key_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5917:4: (otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==132) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5917:6: otherlv_5= 'value' ( (lv_value_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleEStringToStringMapEntry12471); 

                        	newLeafNode(otherlv_5, grammarAccess.getEStringToStringMapEntryAccess().getValueKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5921:1: ( (lv_value_6_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5922:1: (lv_value_6_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5922:1: (lv_value_6_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5923:3: lv_value_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEStringToStringMapEntryAccess().getValueEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEStringToStringMapEntry12492);
                    lv_value_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEStringToStringMapEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_6_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEStringToStringMapEntry12506); 

                	newLeafNode(otherlv_7, grammarAccess.getEStringToStringMapEntryAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEStringToStringMapEntry"


    // $ANTLR start "entryRuleEObject"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5951:1: entryRuleEObject returns [EObject current=null] : iv_ruleEObject= ruleEObject EOF ;
    public final EObject entryRuleEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObject = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5952:2: (iv_ruleEObject= ruleEObject EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5953:2: iv_ruleEObject= ruleEObject EOF
            {
             newCompositeNode(grammarAccess.getEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObject_in_entryRuleEObject12542);
            iv_ruleEObject=ruleEObject();

            state._fsp--;

             current =iv_ruleEObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObject12552); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEObject"


    // $ANTLR start "ruleEObject"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5960:1: ruleEObject returns [EObject current=null] : ( () otherlv_1= 'EObject' ) ;
    public final EObject ruleEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5963:28: ( ( () otherlv_1= 'EObject' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5964:1: ( () otherlv_1= 'EObject' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5964:1: ( () otherlv_1= 'EObject' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5964:2: () otherlv_1= 'EObject'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5964:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5965:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEObjectAccess().getEObjectAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleEObject12598); 

                	newLeafNode(otherlv_1, grammarAccess.getEObjectAccess().getEObjectKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleEParameter"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5982:1: entryRuleEParameter returns [EObject current=null] : iv_ruleEParameter= ruleEParameter EOF ;
    public final EObject entryRuleEParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameter = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5983:2: (iv_ruleEParameter= ruleEParameter EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5984:2: iv_ruleEParameter= ruleEParameter EOF
            {
             newCompositeNode(grammarAccess.getEParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEParameter_in_entryRuleEParameter12634);
            iv_ruleEParameter=ruleEParameter();

            state._fsp--;

             current =iv_ruleEParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEParameter12644); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEParameter"


    // $ANTLR start "ruleEParameter"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5991:1: ruleEParameter returns [EObject current=null] : ( () otherlv_1= 'EParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )? (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )? otherlv_22= '}' ) ;
    public final EObject ruleEParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_ordered_5_0 = null;

        AntlrDatatypeRuleToken lv_unique_7_0 = null;

        AntlrDatatypeRuleToken lv_lowerBound_9_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_11_0 = null;

        EObject lv_eAnnotations_16_0 = null;

        EObject lv_eAnnotations_18_0 = null;

        EObject lv_eGenericType_21_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5994:28: ( ( () otherlv_1= 'EParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )? (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )? otherlv_22= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5995:1: ( () otherlv_1= 'EParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )? (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )? otherlv_22= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5995:1: ( () otherlv_1= 'EParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )? (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )? otherlv_22= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5995:2: () otherlv_1= 'EParameter' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )? (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )? (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )? (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )? (otherlv_12= 'eType' ( ( ruleEString ) ) )? (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )? (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )? otherlv_22= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5995:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:5996:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEParameterAccess().getEParameterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleEParameter12690); 

                	newLeafNode(otherlv_1, grammarAccess.getEParameterAccess().getEParameterKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6005:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6006:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6006:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6007:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEParameterAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEParameter12711);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEParameter12723); 

                	newLeafNode(otherlv_3, grammarAccess.getEParameterAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6027:1: (otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==115) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6027:3: otherlv_4= 'ordered' ( (lv_ordered_5_0= ruleEBoolean ) )
                    {
                    otherlv_4=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleEParameter12736); 

                        	newLeafNode(otherlv_4, grammarAccess.getEParameterAccess().getOrderedKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6031:1: ( (lv_ordered_5_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6032:1: (lv_ordered_5_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6032:1: (lv_ordered_5_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6033:3: lv_ordered_5_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getOrderedEBooleanParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEParameter12757);
                    lv_ordered_5_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		set(
                           			current, 
                           			"ordered",
                            		lv_ordered_5_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6049:4: (otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) ) )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==116) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6049:6: otherlv_6= 'unique' ( (lv_unique_7_0= ruleEBoolean ) )
                    {
                    otherlv_6=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleEParameter12772); 

                        	newLeafNode(otherlv_6, grammarAccess.getEParameterAccess().getUniqueKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6053:1: ( (lv_unique_7_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6054:1: (lv_unique_7_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6054:1: (lv_unique_7_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6055:3: lv_unique_7_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getUniqueEBooleanParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEParameter12793);
                    lv_unique_7_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		set(
                           			current, 
                           			"unique",
                            		lv_unique_7_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6071:4: (otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==117) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6071:6: otherlv_8= 'lowerBound' ( (lv_lowerBound_9_0= ruleEInt ) )
                    {
                    otherlv_8=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleEParameter12808); 

                        	newLeafNode(otherlv_8, grammarAccess.getEParameterAccess().getLowerBoundKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6075:1: ( (lv_lowerBound_9_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6076:1: (lv_lowerBound_9_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6076:1: (lv_lowerBound_9_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6077:3: lv_lowerBound_9_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getLowerBoundEIntParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEParameter12829);
                    lv_lowerBound_9_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		set(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_9_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6093:4: (otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==118) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6093:6: otherlv_10= 'upperBound' ( (lv_upperBound_11_0= ruleEInt ) )
                    {
                    otherlv_10=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleEParameter12844); 

                        	newLeafNode(otherlv_10, grammarAccess.getEParameterAccess().getUpperBoundKeyword_7_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6097:1: ( (lv_upperBound_11_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6098:1: (lv_upperBound_11_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6098:1: (lv_upperBound_11_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6099:3: lv_upperBound_11_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getUpperBoundEIntParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEParameter12865);
                    lv_upperBound_11_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_11_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6115:4: (otherlv_12= 'eType' ( ( ruleEString ) ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==119) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6115:6: otherlv_12= 'eType' ( ( ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleEParameter12880); 

                        	newLeafNode(otherlv_12, grammarAccess.getEParameterAccess().getETypeKeyword_8_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6119:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6120:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6120:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6121:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEParameterRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getETypeEClassifierCrossReference_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEParameter12903);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6134:4: (otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==99) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6134:6: otherlv_14= 'eAnnotations' otherlv_15= '{' ( (lv_eAnnotations_16_0= ruleEAnnotation ) ) (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )* otherlv_19= '}'
                    {
                    otherlv_14=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEParameter12918); 

                        	newLeafNode(otherlv_14, grammarAccess.getEParameterAccess().getEAnnotationsKeyword_9_0());
                        
                    otherlv_15=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEParameter12930); 

                        	newLeafNode(otherlv_15, grammarAccess.getEParameterAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6142:1: ( (lv_eAnnotations_16_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6143:1: (lv_eAnnotations_16_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6143:1: (lv_eAnnotations_16_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6144:3: lv_eAnnotations_16_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getEAnnotationsEAnnotationParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEParameter12951);
                    lv_eAnnotations_16_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_16_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6160:2: (otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) ) )*
                    loop148:
                    do {
                        int alt148=2;
                        int LA148_0 = input.LA(1);

                        if ( (LA148_0==14) ) {
                            alt148=1;
                        }


                        switch (alt148) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6160:4: otherlv_17= ',' ( (lv_eAnnotations_18_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEParameter12964); 

                    	        	newLeafNode(otherlv_17, grammarAccess.getEParameterAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6164:1: ( (lv_eAnnotations_18_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6165:1: (lv_eAnnotations_18_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6165:1: (lv_eAnnotations_18_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6166:3: lv_eAnnotations_18_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEParameterAccess().getEAnnotationsEAnnotationParserRuleCall_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEParameter12985);
                    	    lv_eAnnotations_18_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_18_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop148;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEParameter12999); 

                        	newLeafNode(otherlv_19, grammarAccess.getEParameterAccess().getRightCurlyBracketKeyword_9_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6186:3: (otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==121) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6186:5: otherlv_20= 'eGenericType' ( (lv_eGenericType_21_0= ruleEGenericType ) )
                    {
                    otherlv_20=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleEParameter13014); 

                        	newLeafNode(otherlv_20, grammarAccess.getEParameterAccess().getEGenericTypeKeyword_10_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6190:1: ( (lv_eGenericType_21_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6191:1: (lv_eGenericType_21_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6191:1: (lv_eGenericType_21_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6192:3: lv_eGenericType_21_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEParameterAccess().getEGenericTypeEGenericTypeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEParameter13035);
                    lv_eGenericType_21_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEParameterRule());
                    	        }
                           		set(
                           			current, 
                           			"eGenericType",
                            		lv_eGenericType_21_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_22=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEParameter13049); 

                	newLeafNode(otherlv_22, grammarAccess.getEParameterAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEParameter"


    // $ANTLR start "entryRuleEAttribute"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6220:1: entryRuleEAttribute returns [EObject current=null] : iv_ruleEAttribute= ruleEAttribute EOF ;
    public final EObject entryRuleEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttribute = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6221:2: (iv_ruleEAttribute= ruleEAttribute EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6222:2: iv_ruleEAttribute= ruleEAttribute EOF
            {
             newCompositeNode(grammarAccess.getEAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_entryRuleEAttribute13085);
            iv_ruleEAttribute=ruleEAttribute();

            state._fsp--;

             current =iv_ruleEAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttribute13095); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEAttribute"


    // $ANTLR start "ruleEAttribute"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6229:1: ruleEAttribute returns [EObject current=null] : ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_iD_5_0= 'iD' ) )? otherlv_6= 'EAttribute' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'eType' ( ( ruleEString ) ) )? (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )? (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )? otherlv_31= '}' ) ;
    public final EObject ruleEAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_volatile_1_0=null;
        Token lv_transient_2_0=null;
        Token lv_unsettable_3_0=null;
        Token lv_derived_4_0=null;
        Token lv_iD_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        AntlrDatatypeRuleToken lv_name_7_0 = null;

        AntlrDatatypeRuleToken lv_ordered_10_0 = null;

        AntlrDatatypeRuleToken lv_unique_12_0 = null;

        AntlrDatatypeRuleToken lv_lowerBound_14_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_16_0 = null;

        AntlrDatatypeRuleToken lv_changeable_18_0 = null;

        AntlrDatatypeRuleToken lv_defaultValueLiteral_20_0 = null;

        EObject lv_eAnnotations_25_0 = null;

        EObject lv_eAnnotations_27_0 = null;

        EObject lv_eGenericType_30_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6232:28: ( ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_iD_5_0= 'iD' ) )? otherlv_6= 'EAttribute' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'eType' ( ( ruleEString ) ) )? (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )? (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )? otherlv_31= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6233:1: ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_iD_5_0= 'iD' ) )? otherlv_6= 'EAttribute' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'eType' ( ( ruleEString ) ) )? (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )? (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )? otherlv_31= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6233:1: ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_iD_5_0= 'iD' ) )? otherlv_6= 'EAttribute' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'eType' ( ( ruleEString ) ) )? (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )? (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )? otherlv_31= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6233:2: () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_iD_5_0= 'iD' ) )? otherlv_6= 'EAttribute' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'eType' ( ( ruleEString ) ) )? (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )? (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )? otherlv_31= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6233:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6234:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEAttributeAccess().getEAttributeAction_0(),
                        current);
                

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6239:2: ( (lv_volatile_1_0= 'volatile' ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==135) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6240:1: (lv_volatile_1_0= 'volatile' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6240:1: (lv_volatile_1_0= 'volatile' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6241:3: lv_volatile_1_0= 'volatile'
                    {
                    lv_volatile_1_0=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleEAttribute13147); 

                            newLeafNode(lv_volatile_1_0, grammarAccess.getEAttributeAccess().getVolatileVolatileKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "volatile", true, "volatile");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6254:3: ( (lv_transient_2_0= 'transient' ) )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==136) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6255:1: (lv_transient_2_0= 'transient' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6255:1: (lv_transient_2_0= 'transient' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6256:3: lv_transient_2_0= 'transient'
                    {
                    lv_transient_2_0=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleEAttribute13179); 

                            newLeafNode(lv_transient_2_0, grammarAccess.getEAttributeAccess().getTransientTransientKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "transient", true, "transient");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6269:3: ( (lv_unsettable_3_0= 'unsettable' ) )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==137) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6270:1: (lv_unsettable_3_0= 'unsettable' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6270:1: (lv_unsettable_3_0= 'unsettable' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6271:3: lv_unsettable_3_0= 'unsettable'
                    {
                    lv_unsettable_3_0=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleEAttribute13211); 

                            newLeafNode(lv_unsettable_3_0, grammarAccess.getEAttributeAccess().getUnsettableUnsettableKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "unsettable", true, "unsettable");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6284:3: ( (lv_derived_4_0= 'derived' ) )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==138) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6285:1: (lv_derived_4_0= 'derived' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6285:1: (lv_derived_4_0= 'derived' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6286:3: lv_derived_4_0= 'derived'
                    {
                    lv_derived_4_0=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleEAttribute13243); 

                            newLeafNode(lv_derived_4_0, grammarAccess.getEAttributeAccess().getDerivedDerivedKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6299:3: ( (lv_iD_5_0= 'iD' ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==139) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6300:1: (lv_iD_5_0= 'iD' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6300:1: (lv_iD_5_0= 'iD' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6301:3: lv_iD_5_0= 'iD'
                    {
                    lv_iD_5_0=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleEAttribute13275); 

                            newLeafNode(lv_iD_5_0, grammarAccess.getEAttributeAccess().getIDIDKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "iD", true, "iD");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleEAttribute13301); 

                	newLeafNode(otherlv_6, grammarAccess.getEAttributeAccess().getEAttributeKeyword_6());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6318:1: ( (lv_name_7_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6319:1: (lv_name_7_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6319:1: (lv_name_7_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6320:3: lv_name_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEAttributeAccess().getNameEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAttribute13322);
            lv_name_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAttribute13334); 

                	newLeafNode(otherlv_8, grammarAccess.getEAttributeAccess().getLeftCurlyBracketKeyword_8());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6340:1: (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==115) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6340:3: otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) )
                    {
                    otherlv_9=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleEAttribute13347); 

                        	newLeafNode(otherlv_9, grammarAccess.getEAttributeAccess().getOrderedKeyword_9_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6344:1: ( (lv_ordered_10_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6345:1: (lv_ordered_10_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6345:1: (lv_ordered_10_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6346:3: lv_ordered_10_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getOrderedEBooleanParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEAttribute13368);
                    lv_ordered_10_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"ordered",
                            		lv_ordered_10_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6362:4: (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==116) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6362:6: otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) )
                    {
                    otherlv_11=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleEAttribute13383); 

                        	newLeafNode(otherlv_11, grammarAccess.getEAttributeAccess().getUniqueKeyword_10_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6366:1: ( (lv_unique_12_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6367:1: (lv_unique_12_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6367:1: (lv_unique_12_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6368:3: lv_unique_12_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getUniqueEBooleanParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEAttribute13404);
                    lv_unique_12_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"unique",
                            		lv_unique_12_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6384:4: (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==117) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6384:6: otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) )
                    {
                    otherlv_13=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleEAttribute13419); 

                        	newLeafNode(otherlv_13, grammarAccess.getEAttributeAccess().getLowerBoundKeyword_11_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6388:1: ( (lv_lowerBound_14_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6389:1: (lv_lowerBound_14_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6389:1: (lv_lowerBound_14_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6390:3: lv_lowerBound_14_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getLowerBoundEIntParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEAttribute13440);
                    lv_lowerBound_14_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_14_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6406:4: (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==118) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6406:6: otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) )
                    {
                    otherlv_15=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleEAttribute13455); 

                        	newLeafNode(otherlv_15, grammarAccess.getEAttributeAccess().getUpperBoundKeyword_12_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6410:1: ( (lv_upperBound_16_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6411:1: (lv_upperBound_16_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6411:1: (lv_upperBound_16_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6412:3: lv_upperBound_16_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getUpperBoundEIntParserRuleCall_12_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEAttribute13476);
                    lv_upperBound_16_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_16_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6428:4: (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==141) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6428:6: otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) )
                    {
                    otherlv_17=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleEAttribute13491); 

                        	newLeafNode(otherlv_17, grammarAccess.getEAttributeAccess().getChangeableKeyword_13_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6432:1: ( (lv_changeable_18_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6433:1: (lv_changeable_18_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6433:1: (lv_changeable_18_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6434:3: lv_changeable_18_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getChangeableEBooleanParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEAttribute13512);
                    lv_changeable_18_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"changeable",
                            		lv_changeable_18_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6450:4: (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==142) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6450:6: otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) )
                    {
                    otherlv_19=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleEAttribute13527); 

                        	newLeafNode(otherlv_19, grammarAccess.getEAttributeAccess().getDefaultValueLiteralKeyword_14_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6454:1: ( (lv_defaultValueLiteral_20_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6455:1: (lv_defaultValueLiteral_20_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6455:1: (lv_defaultValueLiteral_20_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6456:3: lv_defaultValueLiteral_20_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getDefaultValueLiteralEStringParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAttribute13548);
                    lv_defaultValueLiteral_20_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_20_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6472:4: (otherlv_21= 'eType' ( ( ruleEString ) ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==119) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6472:6: otherlv_21= 'eType' ( ( ruleEString ) )
                    {
                    otherlv_21=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleEAttribute13563); 

                        	newLeafNode(otherlv_21, grammarAccess.getEAttributeAccess().getETypeKeyword_15_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6476:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6477:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6477:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6478:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getETypeEClassifierCrossReference_15_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEAttribute13586);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6491:4: (otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}' )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==99) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6491:6: otherlv_23= 'eAnnotations' otherlv_24= '{' ( (lv_eAnnotations_25_0= ruleEAnnotation ) ) (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )* otherlv_28= '}'
                    {
                    otherlv_23=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEAttribute13601); 

                        	newLeafNode(otherlv_23, grammarAccess.getEAttributeAccess().getEAnnotationsKeyword_16_0());
                        
                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEAttribute13613); 

                        	newLeafNode(otherlv_24, grammarAccess.getEAttributeAccess().getLeftCurlyBracketKeyword_16_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6499:1: ( (lv_eAnnotations_25_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6500:1: (lv_eAnnotations_25_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6500:1: (lv_eAnnotations_25_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6501:3: lv_eAnnotations_25_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getEAnnotationsEAnnotationParserRuleCall_16_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEAttribute13634);
                    lv_eAnnotations_25_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_25_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6517:2: (otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) ) )*
                    loop163:
                    do {
                        int alt163=2;
                        int LA163_0 = input.LA(1);

                        if ( (LA163_0==14) ) {
                            alt163=1;
                        }


                        switch (alt163) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6517:4: otherlv_26= ',' ( (lv_eAnnotations_27_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_26=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEAttribute13647); 

                    	        	newLeafNode(otherlv_26, grammarAccess.getEAttributeAccess().getCommaKeyword_16_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6521:1: ( (lv_eAnnotations_27_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6522:1: (lv_eAnnotations_27_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6522:1: (lv_eAnnotations_27_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6523:3: lv_eAnnotations_27_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAttributeAccess().getEAnnotationsEAnnotationParserRuleCall_16_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEAttribute13668);
                    	    lv_eAnnotations_27_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_27_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop163;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAttribute13682); 

                        	newLeafNode(otherlv_28, grammarAccess.getEAttributeAccess().getRightCurlyBracketKeyword_16_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6543:3: (otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) ) )?
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==121) ) {
                alt165=1;
            }
            switch (alt165) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6543:5: otherlv_29= 'eGenericType' ( (lv_eGenericType_30_0= ruleEGenericType ) )
                    {
                    otherlv_29=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleEAttribute13697); 

                        	newLeafNode(otherlv_29, grammarAccess.getEAttributeAccess().getEGenericTypeKeyword_17_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6547:1: ( (lv_eGenericType_30_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6548:1: (lv_eGenericType_30_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6548:1: (lv_eGenericType_30_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6549:3: lv_eGenericType_30_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAttributeAccess().getEGenericTypeEGenericTypeParserRuleCall_17_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEAttribute13718);
                    lv_eGenericType_30_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"eGenericType",
                            		lv_eGenericType_30_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_31=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEAttribute13732); 

                	newLeafNode(otherlv_31, grammarAccess.getEAttributeAccess().getRightCurlyBracketKeyword_18());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleEReference"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6577:1: entryRuleEReference returns [EObject current=null] : iv_ruleEReference= ruleEReference EOF ;
    public final EObject entryRuleEReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReference = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6578:2: (iv_ruleEReference= ruleEReference EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6579:2: iv_ruleEReference= ruleEReference EOF
            {
             newCompositeNode(grammarAccess.getEReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEReference_in_entryRuleEReference13768);
            iv_ruleEReference=ruleEReference();

            state._fsp--;

             current =iv_ruleEReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEReference13778); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEReference"


    // $ANTLR start "ruleEReference"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6586:1: ruleEReference returns [EObject current=null] : ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_containment_5_0= 'containment' ) )? otherlv_6= 'EReference' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )? (otherlv_23= 'eType' ( ( ruleEString ) ) )? (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )? (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )? (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )? (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )? otherlv_41= '}' ) ;
    public final EObject ruleEReference() throws RecognitionException {
        EObject current = null;

        Token lv_volatile_1_0=null;
        Token lv_transient_2_0=null;
        Token lv_unsettable_3_0=null;
        Token lv_derived_4_0=null;
        Token lv_containment_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        AntlrDatatypeRuleToken lv_name_7_0 = null;

        AntlrDatatypeRuleToken lv_ordered_10_0 = null;

        AntlrDatatypeRuleToken lv_unique_12_0 = null;

        AntlrDatatypeRuleToken lv_lowerBound_14_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_16_0 = null;

        AntlrDatatypeRuleToken lv_changeable_18_0 = null;

        AntlrDatatypeRuleToken lv_defaultValueLiteral_20_0 = null;

        AntlrDatatypeRuleToken lv_resolveProxies_22_0 = null;

        EObject lv_eAnnotations_35_0 = null;

        EObject lv_eAnnotations_37_0 = null;

        EObject lv_eGenericType_40_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6589:28: ( ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_containment_5_0= 'containment' ) )? otherlv_6= 'EReference' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )? (otherlv_23= 'eType' ( ( ruleEString ) ) )? (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )? (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )? (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )? (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )? otherlv_41= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6590:1: ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_containment_5_0= 'containment' ) )? otherlv_6= 'EReference' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )? (otherlv_23= 'eType' ( ( ruleEString ) ) )? (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )? (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )? (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )? (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )? otherlv_41= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6590:1: ( () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_containment_5_0= 'containment' ) )? otherlv_6= 'EReference' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )? (otherlv_23= 'eType' ( ( ruleEString ) ) )? (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )? (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )? (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )? (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )? otherlv_41= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6590:2: () ( (lv_volatile_1_0= 'volatile' ) )? ( (lv_transient_2_0= 'transient' ) )? ( (lv_unsettable_3_0= 'unsettable' ) )? ( (lv_derived_4_0= 'derived' ) )? ( (lv_containment_5_0= 'containment' ) )? otherlv_6= 'EReference' ( (lv_name_7_0= ruleEString ) ) otherlv_8= '{' (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )? (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )? (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )? (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )? (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )? (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )? (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )? (otherlv_23= 'eType' ( ( ruleEString ) ) )? (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )? (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )? (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )? (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )? otherlv_41= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6590:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6591:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEReferenceAccess().getEReferenceAction_0(),
                        current);
                

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6596:2: ( (lv_volatile_1_0= 'volatile' ) )?
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==135) ) {
                alt166=1;
            }
            switch (alt166) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6597:1: (lv_volatile_1_0= 'volatile' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6597:1: (lv_volatile_1_0= 'volatile' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6598:3: lv_volatile_1_0= 'volatile'
                    {
                    lv_volatile_1_0=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleEReference13830); 

                            newLeafNode(lv_volatile_1_0, grammarAccess.getEReferenceAccess().getVolatileVolatileKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "volatile", true, "volatile");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6611:3: ( (lv_transient_2_0= 'transient' ) )?
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( (LA167_0==136) ) {
                alt167=1;
            }
            switch (alt167) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6612:1: (lv_transient_2_0= 'transient' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6612:1: (lv_transient_2_0= 'transient' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6613:3: lv_transient_2_0= 'transient'
                    {
                    lv_transient_2_0=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleEReference13862); 

                            newLeafNode(lv_transient_2_0, grammarAccess.getEReferenceAccess().getTransientTransientKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "transient", true, "transient");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6626:3: ( (lv_unsettable_3_0= 'unsettable' ) )?
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==137) ) {
                alt168=1;
            }
            switch (alt168) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6627:1: (lv_unsettable_3_0= 'unsettable' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6627:1: (lv_unsettable_3_0= 'unsettable' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6628:3: lv_unsettable_3_0= 'unsettable'
                    {
                    lv_unsettable_3_0=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleEReference13894); 

                            newLeafNode(lv_unsettable_3_0, grammarAccess.getEReferenceAccess().getUnsettableUnsettableKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "unsettable", true, "unsettable");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6641:3: ( (lv_derived_4_0= 'derived' ) )?
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==138) ) {
                alt169=1;
            }
            switch (alt169) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6642:1: (lv_derived_4_0= 'derived' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6642:1: (lv_derived_4_0= 'derived' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6643:3: lv_derived_4_0= 'derived'
                    {
                    lv_derived_4_0=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleEReference13926); 

                            newLeafNode(lv_derived_4_0, grammarAccess.getEReferenceAccess().getDerivedDerivedKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6656:3: ( (lv_containment_5_0= 'containment' ) )?
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==143) ) {
                alt170=1;
            }
            switch (alt170) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6657:1: (lv_containment_5_0= 'containment' )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6657:1: (lv_containment_5_0= 'containment' )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6658:3: lv_containment_5_0= 'containment'
                    {
                    lv_containment_5_0=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleEReference13958); 

                            newLeafNode(lv_containment_5_0, grammarAccess.getEReferenceAccess().getContainmentContainmentKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "containment", true, "containment");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,144,FollowSets000.FOLLOW_144_in_ruleEReference13984); 

                	newLeafNode(otherlv_6, grammarAccess.getEReferenceAccess().getEReferenceKeyword_6());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6675:1: ( (lv_name_7_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6676:1: (lv_name_7_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6676:1: (lv_name_7_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6677:3: lv_name_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEReferenceAccess().getNameEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14005);
            lv_name_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEReference14017); 

                	newLeafNode(otherlv_8, grammarAccess.getEReferenceAccess().getLeftCurlyBracketKeyword_8());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6697:1: (otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) ) )?
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==115) ) {
                alt171=1;
            }
            switch (alt171) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6697:3: otherlv_9= 'ordered' ( (lv_ordered_10_0= ruleEBoolean ) )
                    {
                    otherlv_9=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleEReference14030); 

                        	newLeafNode(otherlv_9, grammarAccess.getEReferenceAccess().getOrderedKeyword_9_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6701:1: ( (lv_ordered_10_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6702:1: (lv_ordered_10_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6702:1: (lv_ordered_10_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6703:3: lv_ordered_10_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getOrderedEBooleanParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEReference14051);
                    lv_ordered_10_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"ordered",
                            		lv_ordered_10_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6719:4: (otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) ) )?
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==116) ) {
                alt172=1;
            }
            switch (alt172) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6719:6: otherlv_11= 'unique' ( (lv_unique_12_0= ruleEBoolean ) )
                    {
                    otherlv_11=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleEReference14066); 

                        	newLeafNode(otherlv_11, grammarAccess.getEReferenceAccess().getUniqueKeyword_10_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6723:1: ( (lv_unique_12_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6724:1: (lv_unique_12_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6724:1: (lv_unique_12_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6725:3: lv_unique_12_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getUniqueEBooleanParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEReference14087);
                    lv_unique_12_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"unique",
                            		lv_unique_12_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6741:4: (otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) ) )?
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==117) ) {
                alt173=1;
            }
            switch (alt173) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6741:6: otherlv_13= 'lowerBound' ( (lv_lowerBound_14_0= ruleEInt ) )
                    {
                    otherlv_13=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleEReference14102); 

                        	newLeafNode(otherlv_13, grammarAccess.getEReferenceAccess().getLowerBoundKeyword_11_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6745:1: ( (lv_lowerBound_14_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6746:1: (lv_lowerBound_14_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6746:1: (lv_lowerBound_14_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6747:3: lv_lowerBound_14_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getLowerBoundEIntParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEReference14123);
                    lv_lowerBound_14_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_14_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6763:4: (otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) ) )?
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==118) ) {
                alt174=1;
            }
            switch (alt174) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6763:6: otherlv_15= 'upperBound' ( (lv_upperBound_16_0= ruleEInt ) )
                    {
                    otherlv_15=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleEReference14138); 

                        	newLeafNode(otherlv_15, grammarAccess.getEReferenceAccess().getUpperBoundKeyword_12_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6767:1: ( (lv_upperBound_16_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6768:1: (lv_upperBound_16_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6768:1: (lv_upperBound_16_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6769:3: lv_upperBound_16_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getUpperBoundEIntParserRuleCall_12_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEReference14159);
                    lv_upperBound_16_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_16_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6785:4: (otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) ) )?
            int alt175=2;
            int LA175_0 = input.LA(1);

            if ( (LA175_0==141) ) {
                alt175=1;
            }
            switch (alt175) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6785:6: otherlv_17= 'changeable' ( (lv_changeable_18_0= ruleEBoolean ) )
                    {
                    otherlv_17=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleEReference14174); 

                        	newLeafNode(otherlv_17, grammarAccess.getEReferenceAccess().getChangeableKeyword_13_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6789:1: ( (lv_changeable_18_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6790:1: (lv_changeable_18_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6790:1: (lv_changeable_18_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6791:3: lv_changeable_18_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getChangeableEBooleanParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEReference14195);
                    lv_changeable_18_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"changeable",
                            		lv_changeable_18_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6807:4: (otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) ) )?
            int alt176=2;
            int LA176_0 = input.LA(1);

            if ( (LA176_0==142) ) {
                alt176=1;
            }
            switch (alt176) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6807:6: otherlv_19= 'defaultValueLiteral' ( (lv_defaultValueLiteral_20_0= ruleEString ) )
                    {
                    otherlv_19=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleEReference14210); 

                        	newLeafNode(otherlv_19, grammarAccess.getEReferenceAccess().getDefaultValueLiteralKeyword_14_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6811:1: ( (lv_defaultValueLiteral_20_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6812:1: (lv_defaultValueLiteral_20_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6812:1: (lv_defaultValueLiteral_20_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6813:3: lv_defaultValueLiteral_20_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getDefaultValueLiteralEStringParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14231);
                    lv_defaultValueLiteral_20_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_20_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6829:4: (otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) ) )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==145) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6829:6: otherlv_21= 'resolveProxies' ( (lv_resolveProxies_22_0= ruleEBoolean ) )
                    {
                    otherlv_21=(Token)match(input,145,FollowSets000.FOLLOW_145_in_ruleEReference14246); 

                        	newLeafNode(otherlv_21, grammarAccess.getEReferenceAccess().getResolveProxiesKeyword_15_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6833:1: ( (lv_resolveProxies_22_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6834:1: (lv_resolveProxies_22_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6834:1: (lv_resolveProxies_22_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6835:3: lv_resolveProxies_22_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getResolveProxiesEBooleanParserRuleCall_15_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEReference14267);
                    lv_resolveProxies_22_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"resolveProxies",
                            		lv_resolveProxies_22_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6851:4: (otherlv_23= 'eType' ( ( ruleEString ) ) )?
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==119) ) {
                alt178=1;
            }
            switch (alt178) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6851:6: otherlv_23= 'eType' ( ( ruleEString ) )
                    {
                    otherlv_23=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleEReference14282); 

                        	newLeafNode(otherlv_23, grammarAccess.getEReferenceAccess().getETypeKeyword_16_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6855:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6856:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6856:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6857:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getETypeEClassifierCrossReference_16_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14305);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6870:4: (otherlv_25= 'eOpposite' ( ( ruleEString ) ) )?
            int alt179=2;
            int LA179_0 = input.LA(1);

            if ( (LA179_0==146) ) {
                alt179=1;
            }
            switch (alt179) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6870:6: otherlv_25= 'eOpposite' ( ( ruleEString ) )
                    {
                    otherlv_25=(Token)match(input,146,FollowSets000.FOLLOW_146_in_ruleEReference14320); 

                        	newLeafNode(otherlv_25, grammarAccess.getEReferenceAccess().getEOppositeKeyword_17_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6874:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6875:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6875:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6876:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEOppositeEReferenceCrossReference_17_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14343);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6889:4: (otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')' )?
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==147) ) {
                alt181=1;
            }
            switch (alt181) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6889:6: otherlv_27= 'eKeys' otherlv_28= '(' ( ( ruleEString ) ) (otherlv_30= ',' ( ( ruleEString ) ) )* otherlv_32= ')'
                    {
                    otherlv_27=(Token)match(input,147,FollowSets000.FOLLOW_147_in_ruleEReference14358); 

                        	newLeafNode(otherlv_27, grammarAccess.getEReferenceAccess().getEKeysKeyword_18_0());
                        
                    otherlv_28=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEReference14370); 

                        	newLeafNode(otherlv_28, grammarAccess.getEReferenceAccess().getLeftParenthesisKeyword_18_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6897:1: ( ( ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6898:1: ( ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6898:1: ( ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6899:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEKeysEAttributeCrossReference_18_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14393);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6912:2: (otherlv_30= ',' ( ( ruleEString ) ) )*
                    loop180:
                    do {
                        int alt180=2;
                        int LA180_0 = input.LA(1);

                        if ( (LA180_0==14) ) {
                            alt180=1;
                        }


                        switch (alt180) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6912:4: otherlv_30= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_30=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEReference14406); 

                    	        	newLeafNode(otherlv_30, grammarAccess.getEReferenceAccess().getCommaKeyword_18_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6916:1: ( ( ruleEString ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6917:1: ( ruleEString )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6917:1: ( ruleEString )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6918:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEReferenceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEKeysEAttributeCrossReference_18_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEReference14429);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop180;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEReference14443); 

                        	newLeafNode(otherlv_32, grammarAccess.getEReferenceAccess().getRightParenthesisKeyword_18_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6935:3: (otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}' )?
            int alt183=2;
            int LA183_0 = input.LA(1);

            if ( (LA183_0==99) ) {
                alt183=1;
            }
            switch (alt183) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6935:5: otherlv_33= 'eAnnotations' otherlv_34= '{' ( (lv_eAnnotations_35_0= ruleEAnnotation ) ) (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )* otherlv_38= '}'
                    {
                    otherlv_33=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEReference14458); 

                        	newLeafNode(otherlv_33, grammarAccess.getEReferenceAccess().getEAnnotationsKeyword_19_0());
                        
                    otherlv_34=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEReference14470); 

                        	newLeafNode(otherlv_34, grammarAccess.getEReferenceAccess().getLeftCurlyBracketKeyword_19_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6943:1: ( (lv_eAnnotations_35_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6944:1: (lv_eAnnotations_35_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6944:1: (lv_eAnnotations_35_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6945:3: lv_eAnnotations_35_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEAnnotationsEAnnotationParserRuleCall_19_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEReference14491);
                    lv_eAnnotations_35_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_35_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6961:2: (otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) ) )*
                    loop182:
                    do {
                        int alt182=2;
                        int LA182_0 = input.LA(1);

                        if ( (LA182_0==14) ) {
                            alt182=1;
                        }


                        switch (alt182) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6961:4: otherlv_36= ',' ( (lv_eAnnotations_37_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_36=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEReference14504); 

                    	        	newLeafNode(otherlv_36, grammarAccess.getEReferenceAccess().getCommaKeyword_19_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6965:1: ( (lv_eAnnotations_37_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6966:1: (lv_eAnnotations_37_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6966:1: (lv_eAnnotations_37_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6967:3: lv_eAnnotations_37_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEAnnotationsEAnnotationParserRuleCall_19_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEReference14525);
                    	    lv_eAnnotations_37_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_37_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop182;
                        }
                    } while (true);

                    otherlv_38=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEReference14539); 

                        	newLeafNode(otherlv_38, grammarAccess.getEReferenceAccess().getRightCurlyBracketKeyword_19_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6987:3: (otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) ) )?
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==121) ) {
                alt184=1;
            }
            switch (alt184) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6987:5: otherlv_39= 'eGenericType' ( (lv_eGenericType_40_0= ruleEGenericType ) )
                    {
                    otherlv_39=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleEReference14554); 

                        	newLeafNode(otherlv_39, grammarAccess.getEReferenceAccess().getEGenericTypeKeyword_20_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6991:1: ( (lv_eGenericType_40_0= ruleEGenericType ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6992:1: (lv_eGenericType_40_0= ruleEGenericType )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6992:1: (lv_eGenericType_40_0= ruleEGenericType )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:6993:3: lv_eGenericType_40_0= ruleEGenericType
                    {
                     
                    	        newCompositeNode(grammarAccess.getEReferenceAccess().getEGenericTypeEGenericTypeParserRuleCall_20_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEGenericType_in_ruleEReference14575);
                    lv_eGenericType_40_0=ruleEGenericType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"eGenericType",
                            		lv_eGenericType_40_0, 
                            		"EGenericType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_41=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEReference14589); 

                	newLeafNode(otherlv_41, grammarAccess.getEReferenceAccess().getRightCurlyBracketKeyword_21());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEReference"


    // $ANTLR start "entryRuleEDataType_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7021:1: entryRuleEDataType_Impl returns [EObject current=null] : iv_ruleEDataType_Impl= ruleEDataType_Impl EOF ;
    public final EObject entryRuleEDataType_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataType_Impl = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7022:2: (iv_ruleEDataType_Impl= ruleEDataType_Impl EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7023:2: iv_ruleEDataType_Impl= ruleEDataType_Impl EOF
            {
             newCompositeNode(grammarAccess.getEDataType_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDataType_Impl_in_entryRuleEDataType_Impl14625);
            iv_ruleEDataType_Impl=ruleEDataType_Impl();

            state._fsp--;

             current =iv_ruleEDataType_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDataType_Impl14635); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDataType_Impl"


    // $ANTLR start "ruleEDataType_Impl"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7030:1: ruleEDataType_Impl returns [EObject current=null] : ( () otherlv_1= 'EDataType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? otherlv_22= '}' ) ;
    public final EObject ruleEDataType_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5_0 = null;

        AntlrDatatypeRuleToken lv_instanceTypeName_7_0 = null;

        AntlrDatatypeRuleToken lv_serializable_9_0 = null;

        EObject lv_eAnnotations_12_0 = null;

        EObject lv_eAnnotations_14_0 = null;

        EObject lv_eTypeParameters_18_0 = null;

        EObject lv_eTypeParameters_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7033:28: ( ( () otherlv_1= 'EDataType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? otherlv_22= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7034:1: ( () otherlv_1= 'EDataType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? otherlv_22= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7034:1: ( () otherlv_1= 'EDataType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? otherlv_22= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7034:2: () otherlv_1= 'EDataType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? otherlv_22= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7034:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7035:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEDataType_ImplAccess().getEDataTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,148,FollowSets000.FOLLOW_148_in_ruleEDataType_Impl14681); 

                	newLeafNode(otherlv_1, grammarAccess.getEDataType_ImplAccess().getEDataTypeKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7044:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7045:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7045:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7046:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEDataType_Impl14702);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEDataType_Impl14714); 

                	newLeafNode(otherlv_3, grammarAccess.getEDataType_ImplAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7066:1: (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )?
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==96) ) {
                alt185=1;
            }
            switch (alt185) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7066:3: otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleEDataType_Impl14727); 

                        	newLeafNode(otherlv_4, grammarAccess.getEDataType_ImplAccess().getInstanceClassNameKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7070:1: ( (lv_instanceClassName_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7071:1: (lv_instanceClassName_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7071:1: (lv_instanceClassName_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7072:3: lv_instanceClassName_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getInstanceClassNameEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEDataType_Impl14748);
                    lv_instanceClassName_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceClassName",
                            		lv_instanceClassName_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7088:4: (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )?
            int alt186=2;
            int LA186_0 = input.LA(1);

            if ( (LA186_0==97) ) {
                alt186=1;
            }
            switch (alt186) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7088:6: otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleEDataType_Impl14763); 

                        	newLeafNode(otherlv_6, grammarAccess.getEDataType_ImplAccess().getInstanceTypeNameKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7092:1: ( (lv_instanceTypeName_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7093:1: (lv_instanceTypeName_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7093:1: (lv_instanceTypeName_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7094:3: lv_instanceTypeName_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getInstanceTypeNameEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEDataType_Impl14784);
                    lv_instanceTypeName_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceTypeName",
                            		lv_instanceTypeName_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7110:4: (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )?
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==149) ) {
                alt187=1;
            }
            switch (alt187) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7110:6: otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) )
                    {
                    otherlv_8=(Token)match(input,149,FollowSets000.FOLLOW_149_in_ruleEDataType_Impl14799); 

                        	newLeafNode(otherlv_8, grammarAccess.getEDataType_ImplAccess().getSerializableKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7114:1: ( (lv_serializable_9_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7115:1: (lv_serializable_9_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7115:1: (lv_serializable_9_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7116:3: lv_serializable_9_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getSerializableEBooleanParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEDataType_Impl14820);
                    lv_serializable_9_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	        }
                           		set(
                           			current, 
                           			"serializable",
                            		lv_serializable_9_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7132:4: (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )?
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==99) ) {
                alt189=1;
            }
            switch (alt189) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7132:6: otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEDataType_Impl14835); 

                        	newLeafNode(otherlv_10, grammarAccess.getEDataType_ImplAccess().getEAnnotationsKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEDataType_Impl14847); 

                        	newLeafNode(otherlv_11, grammarAccess.getEDataType_ImplAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7140:1: ( (lv_eAnnotations_12_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7141:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7141:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7142:3: lv_eAnnotations_12_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getEAnnotationsEAnnotationParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEDataType_Impl14868);
                    lv_eAnnotations_12_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_12_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7158:2: (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )*
                    loop188:
                    do {
                        int alt188=2;
                        int LA188_0 = input.LA(1);

                        if ( (LA188_0==14) ) {
                            alt188=1;
                        }


                        switch (alt188) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7158:4: otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEDataType_Impl14881); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getEDataType_ImplAccess().getCommaKeyword_7_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7162:1: ( (lv_eAnnotations_14_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7163:1: (lv_eAnnotations_14_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7163:1: (lv_eAnnotations_14_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7164:3: lv_eAnnotations_14_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getEAnnotationsEAnnotationParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEDataType_Impl14902);
                    	    lv_eAnnotations_14_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_14_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop188;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEDataType_Impl14916); 

                        	newLeafNode(otherlv_15, grammarAccess.getEDataType_ImplAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7184:3: (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )?
            int alt191=2;
            int LA191_0 = input.LA(1);

            if ( (LA191_0==100) ) {
                alt191=1;
            }
            switch (alt191) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7184:5: otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleEDataType_Impl14931); 

                        	newLeafNode(otherlv_16, grammarAccess.getEDataType_ImplAccess().getETypeParametersKeyword_8_0());
                        
                    otherlv_17=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEDataType_Impl14943); 

                        	newLeafNode(otherlv_17, grammarAccess.getEDataType_ImplAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7192:1: ( (lv_eTypeParameters_18_0= ruleETypeParameter ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7193:1: (lv_eTypeParameters_18_0= ruleETypeParameter )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7193:1: (lv_eTypeParameters_18_0= ruleETypeParameter )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7194:3: lv_eTypeParameters_18_0= ruleETypeParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getETypeParametersETypeParameterParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEDataType_Impl14964);
                    lv_eTypeParameters_18_0=ruleETypeParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_18_0, 
                            		"ETypeParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7210:2: (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )*
                    loop190:
                    do {
                        int alt190=2;
                        int LA190_0 = input.LA(1);

                        if ( (LA190_0==14) ) {
                            alt190=1;
                        }


                        switch (alt190) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7210:4: otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) )
                    	    {
                    	    otherlv_19=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEDataType_Impl14977); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getEDataType_ImplAccess().getCommaKeyword_8_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7214:1: ( (lv_eTypeParameters_20_0= ruleETypeParameter ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7215:1: (lv_eTypeParameters_20_0= ruleETypeParameter )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7215:1: (lv_eTypeParameters_20_0= ruleETypeParameter )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7216:3: lv_eTypeParameters_20_0= ruleETypeParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEDataType_ImplAccess().getETypeParametersETypeParameterParserRuleCall_8_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEDataType_Impl14998);
                    	    lv_eTypeParameters_20_0=ruleETypeParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEDataType_ImplRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_20_0, 
                    	            		"ETypeParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop190;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEDataType_Impl15012); 

                        	newLeafNode(otherlv_21, grammarAccess.getEDataType_ImplAccess().getRightCurlyBracketKeyword_8_4());
                        

                    }
                    break;

            }

            otherlv_22=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEDataType_Impl15026); 

                	newLeafNode(otherlv_22, grammarAccess.getEDataType_ImplAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDataType_Impl"


    // $ANTLR start "entryRuleEEnum"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7248:1: entryRuleEEnum returns [EObject current=null] : iv_ruleEEnum= ruleEEnum EOF ;
    public final EObject entryRuleEEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnum = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7249:2: (iv_ruleEEnum= ruleEEnum EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7250:2: iv_ruleEEnum= ruleEEnum EOF
            {
             newCompositeNode(grammarAccess.getEEnumRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnum_in_entryRuleEEnum15062);
            iv_ruleEEnum=ruleEEnum();

            state._fsp--;

             current =iv_ruleEEnum; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnum15072); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEEnum"


    // $ANTLR start "ruleEEnum"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7257:1: ruleEEnum returns [EObject current=null] : ( () otherlv_1= 'EEnum' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )? otherlv_28= '}' ) ;
    public final EObject ruleEEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5_0 = null;

        AntlrDatatypeRuleToken lv_instanceTypeName_7_0 = null;

        AntlrDatatypeRuleToken lv_serializable_9_0 = null;

        EObject lv_eAnnotations_12_0 = null;

        EObject lv_eAnnotations_14_0 = null;

        EObject lv_eTypeParameters_18_0 = null;

        EObject lv_eTypeParameters_20_0 = null;

        EObject lv_eLiterals_24_0 = null;

        EObject lv_eLiterals_26_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7260:28: ( ( () otherlv_1= 'EEnum' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )? otherlv_28= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7261:1: ( () otherlv_1= 'EEnum' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )? otherlv_28= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7261:1: ( () otherlv_1= 'EEnum' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )? otherlv_28= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7261:2: () otherlv_1= 'EEnum' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )? (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )? (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )? (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )? (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )? (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )? otherlv_28= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7261:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7262:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEEnumAccess().getEEnumAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,150,FollowSets000.FOLLOW_150_in_ruleEEnum15118); 

                	newLeafNode(otherlv_1, grammarAccess.getEEnumAccess().getEEnumKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7271:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7272:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7272:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7273:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEEnumAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEEnum15139);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEEnumRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnum15151); 

                	newLeafNode(otherlv_3, grammarAccess.getEEnumAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7293:1: (otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) ) )?
            int alt192=2;
            int LA192_0 = input.LA(1);

            if ( (LA192_0==96) ) {
                alt192=1;
            }
            switch (alt192) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7293:3: otherlv_4= 'instanceClassName' ( (lv_instanceClassName_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleEEnum15164); 

                        	newLeafNode(otherlv_4, grammarAccess.getEEnumAccess().getInstanceClassNameKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7297:1: ( (lv_instanceClassName_5_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7298:1: (lv_instanceClassName_5_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7298:1: (lv_instanceClassName_5_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7299:3: lv_instanceClassName_5_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getInstanceClassNameEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEEnum15185);
                    lv_instanceClassName_5_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceClassName",
                            		lv_instanceClassName_5_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7315:4: (otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) ) )?
            int alt193=2;
            int LA193_0 = input.LA(1);

            if ( (LA193_0==97) ) {
                alt193=1;
            }
            switch (alt193) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7315:6: otherlv_6= 'instanceTypeName' ( (lv_instanceTypeName_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleEEnum15200); 

                        	newLeafNode(otherlv_6, grammarAccess.getEEnumAccess().getInstanceTypeNameKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7319:1: ( (lv_instanceTypeName_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7320:1: (lv_instanceTypeName_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7320:1: (lv_instanceTypeName_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7321:3: lv_instanceTypeName_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getInstanceTypeNameEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEEnum15221);
                    lv_instanceTypeName_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceTypeName",
                            		lv_instanceTypeName_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7337:4: (otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) ) )?
            int alt194=2;
            int LA194_0 = input.LA(1);

            if ( (LA194_0==149) ) {
                alt194=1;
            }
            switch (alt194) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7337:6: otherlv_8= 'serializable' ( (lv_serializable_9_0= ruleEBoolean ) )
                    {
                    otherlv_8=(Token)match(input,149,FollowSets000.FOLLOW_149_in_ruleEEnum15236); 

                        	newLeafNode(otherlv_8, grammarAccess.getEEnumAccess().getSerializableKeyword_6_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7341:1: ( (lv_serializable_9_0= ruleEBoolean ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7342:1: (lv_serializable_9_0= ruleEBoolean )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7342:1: (lv_serializable_9_0= ruleEBoolean )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7343:3: lv_serializable_9_0= ruleEBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getSerializableEBooleanParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleEEnum15257);
                    lv_serializable_9_0=ruleEBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"serializable",
                            		lv_serializable_9_0, 
                            		"EBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7359:4: (otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}' )?
            int alt196=2;
            int LA196_0 = input.LA(1);

            if ( (LA196_0==99) ) {
                alt196=1;
            }
            switch (alt196) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7359:6: otherlv_10= 'eAnnotations' otherlv_11= '{' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEEnum15272); 

                        	newLeafNode(otherlv_10, grammarAccess.getEEnumAccess().getEAnnotationsKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnum15284); 

                        	newLeafNode(otherlv_11, grammarAccess.getEEnumAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7367:1: ( (lv_eAnnotations_12_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7368:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7368:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7369:3: lv_eAnnotations_12_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getEAnnotationsEAnnotationParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEEnum15305);
                    lv_eAnnotations_12_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_12_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7385:2: (otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) ) )*
                    loop195:
                    do {
                        int alt195=2;
                        int LA195_0 = input.LA(1);

                        if ( (LA195_0==14) ) {
                            alt195=1;
                        }


                        switch (alt195) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7385:4: otherlv_13= ',' ( (lv_eAnnotations_14_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEEnum15318); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getEEnumAccess().getCommaKeyword_7_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7389:1: ( (lv_eAnnotations_14_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7390:1: (lv_eAnnotations_14_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7390:1: (lv_eAnnotations_14_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7391:3: lv_eAnnotations_14_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEEnumAccess().getEAnnotationsEAnnotationParserRuleCall_7_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEEnum15339);
                    	    lv_eAnnotations_14_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_14_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop195;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnum15353); 

                        	newLeafNode(otherlv_15, grammarAccess.getEEnumAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7411:3: (otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}' )?
            int alt198=2;
            int LA198_0 = input.LA(1);

            if ( (LA198_0==100) ) {
                alt198=1;
            }
            switch (alt198) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7411:5: otherlv_16= 'eTypeParameters' otherlv_17= '{' ( (lv_eTypeParameters_18_0= ruleETypeParameter ) ) (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )* otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleEEnum15368); 

                        	newLeafNode(otherlv_16, grammarAccess.getEEnumAccess().getETypeParametersKeyword_8_0());
                        
                    otherlv_17=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnum15380); 

                        	newLeafNode(otherlv_17, grammarAccess.getEEnumAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7419:1: ( (lv_eTypeParameters_18_0= ruleETypeParameter ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7420:1: (lv_eTypeParameters_18_0= ruleETypeParameter )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7420:1: (lv_eTypeParameters_18_0= ruleETypeParameter )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7421:3: lv_eTypeParameters_18_0= ruleETypeParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getETypeParametersETypeParameterParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEEnum15401);
                    lv_eTypeParameters_18_0=ruleETypeParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_18_0, 
                            		"ETypeParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7437:2: (otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) ) )*
                    loop197:
                    do {
                        int alt197=2;
                        int LA197_0 = input.LA(1);

                        if ( (LA197_0==14) ) {
                            alt197=1;
                        }


                        switch (alt197) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7437:4: otherlv_19= ',' ( (lv_eTypeParameters_20_0= ruleETypeParameter ) )
                    	    {
                    	    otherlv_19=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEEnum15414); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getEEnumAccess().getCommaKeyword_8_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7441:1: ( (lv_eTypeParameters_20_0= ruleETypeParameter ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7442:1: (lv_eTypeParameters_20_0= ruleETypeParameter )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7442:1: (lv_eTypeParameters_20_0= ruleETypeParameter )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7443:3: lv_eTypeParameters_20_0= ruleETypeParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEEnumAccess().getETypeParametersETypeParameterParserRuleCall_8_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleETypeParameter_in_ruleEEnum15435);
                    	    lv_eTypeParameters_20_0=ruleETypeParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_20_0, 
                    	            		"ETypeParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop197;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnum15449); 

                        	newLeafNode(otherlv_21, grammarAccess.getEEnumAccess().getRightCurlyBracketKeyword_8_4());
                        

                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7463:3: (otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}' )?
            int alt200=2;
            int LA200_0 = input.LA(1);

            if ( (LA200_0==151) ) {
                alt200=1;
            }
            switch (alt200) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7463:5: otherlv_22= 'eLiterals' otherlv_23= '{' ( (lv_eLiterals_24_0= ruleEEnumLiteral ) ) (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )* otherlv_27= '}'
                    {
                    otherlv_22=(Token)match(input,151,FollowSets000.FOLLOW_151_in_ruleEEnum15464); 

                        	newLeafNode(otherlv_22, grammarAccess.getEEnumAccess().getELiteralsKeyword_9_0());
                        
                    otherlv_23=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnum15476); 

                        	newLeafNode(otherlv_23, grammarAccess.getEEnumAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7471:1: ( (lv_eLiterals_24_0= ruleEEnumLiteral ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7472:1: (lv_eLiterals_24_0= ruleEEnumLiteral )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7472:1: (lv_eLiterals_24_0= ruleEEnumLiteral )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7473:3: lv_eLiterals_24_0= ruleEEnumLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumAccess().getELiteralsEEnumLiteralParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteral_in_ruleEEnum15497);
                    lv_eLiterals_24_0=ruleEEnumLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	        }
                           		add(
                           			current, 
                           			"eLiterals",
                            		lv_eLiterals_24_0, 
                            		"EEnumLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7489:2: (otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) ) )*
                    loop199:
                    do {
                        int alt199=2;
                        int LA199_0 = input.LA(1);

                        if ( (LA199_0==14) ) {
                            alt199=1;
                        }


                        switch (alt199) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7489:4: otherlv_25= ',' ( (lv_eLiterals_26_0= ruleEEnumLiteral ) )
                    	    {
                    	    otherlv_25=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEEnum15510); 

                    	        	newLeafNode(otherlv_25, grammarAccess.getEEnumAccess().getCommaKeyword_9_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7493:1: ( (lv_eLiterals_26_0= ruleEEnumLiteral ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7494:1: (lv_eLiterals_26_0= ruleEEnumLiteral )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7494:1: (lv_eLiterals_26_0= ruleEEnumLiteral )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7495:3: lv_eLiterals_26_0= ruleEEnumLiteral
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEEnumAccess().getELiteralsEEnumLiteralParserRuleCall_9_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteral_in_ruleEEnum15531);
                    	    lv_eLiterals_26_0=ruleEEnumLiteral();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEEnumRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eLiterals",
                    	            		lv_eLiterals_26_0, 
                    	            		"EEnumLiteral");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop199;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnum15545); 

                        	newLeafNode(otherlv_27, grammarAccess.getEEnumAccess().getRightCurlyBracketKeyword_9_4());
                        

                    }
                    break;

            }

            otherlv_28=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnum15559); 

                	newLeafNode(otherlv_28, grammarAccess.getEEnumAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEEnum"


    // $ANTLR start "entryRuleEEnumLiteral"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7527:1: entryRuleEEnumLiteral returns [EObject current=null] : iv_ruleEEnumLiteral= ruleEEnumLiteral EOF ;
    public final EObject entryRuleEEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteral = null;


        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7528:2: (iv_ruleEEnumLiteral= ruleEEnumLiteral EOF )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7529:2: iv_ruleEEnumLiteral= ruleEEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEEnumLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEEnumLiteral_in_entryRuleEEnumLiteral15595);
            iv_ruleEEnumLiteral=ruleEEnumLiteral();

            state._fsp--;

             current =iv_ruleEEnumLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEEnumLiteral15605); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEEnumLiteral"


    // $ANTLR start "ruleEEnumLiteral"
    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7536:1: ruleEEnumLiteral returns [EObject current=null] : ( () otherlv_1= 'EEnumLiteral' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )? (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )? (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )? otherlv_14= '}' ) ;
    public final EObject ruleEEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_literal_7_0 = null;

        EObject lv_eAnnotations_10_0 = null;

        EObject lv_eAnnotations_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7539:28: ( ( () otherlv_1= 'EEnumLiteral' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )? (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )? (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )? otherlv_14= '}' ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7540:1: ( () otherlv_1= 'EEnumLiteral' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )? (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )? (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )? otherlv_14= '}' )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7540:1: ( () otherlv_1= 'EEnumLiteral' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )? (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )? (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )? otherlv_14= '}' )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7540:2: () otherlv_1= 'EEnumLiteral' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )? (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )? (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )? otherlv_14= '}'
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7540:2: ()
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7541:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEEnumLiteralAccess().getEEnumLiteralAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,152,FollowSets000.FOLLOW_152_in_ruleEEnumLiteral15651); 

                	newLeafNode(otherlv_1, grammarAccess.getEEnumLiteralAccess().getEEnumLiteralKeyword_1());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7550:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7551:1: (lv_name_2_0= ruleEString )
            {
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7551:1: (lv_name_2_0= ruleEString )
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7552:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getEEnumLiteralAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEEnumLiteral15672);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEEnumLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnumLiteral15684); 

                	newLeafNode(otherlv_3, grammarAccess.getEEnumLiteralAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7572:1: (otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) ) )?
            int alt201=2;
            int LA201_0 = input.LA(1);

            if ( (LA201_0==132) ) {
                alt201=1;
            }
            switch (alt201) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7572:3: otherlv_4= 'value' ( (lv_value_5_0= ruleEInt ) )
                    {
                    otherlv_4=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleEEnumLiteral15697); 

                        	newLeafNode(otherlv_4, grammarAccess.getEEnumLiteralAccess().getValueKeyword_4_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7576:1: ( (lv_value_5_0= ruleEInt ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7577:1: (lv_value_5_0= ruleEInt )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7577:1: (lv_value_5_0= ruleEInt )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7578:3: lv_value_5_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumLiteralAccess().getValueEIntParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleEEnumLiteral15718);
                    lv_value_5_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumLiteralRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7594:4: (otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) ) )?
            int alt202=2;
            int LA202_0 = input.LA(1);

            if ( (LA202_0==153) ) {
                alt202=1;
            }
            switch (alt202) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7594:6: otherlv_6= 'literal' ( (lv_literal_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,153,FollowSets000.FOLLOW_153_in_ruleEEnumLiteral15733); 

                        	newLeafNode(otherlv_6, grammarAccess.getEEnumLiteralAccess().getLiteralKeyword_5_0());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7598:1: ( (lv_literal_7_0= ruleEString ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7599:1: (lv_literal_7_0= ruleEString )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7599:1: (lv_literal_7_0= ruleEString )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7600:3: lv_literal_7_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumLiteralAccess().getLiteralEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleEEnumLiteral15754);
                    lv_literal_7_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumLiteralRule());
                    	        }
                           		set(
                           			current, 
                           			"literal",
                            		lv_literal_7_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7616:4: (otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}' )?
            int alt204=2;
            int LA204_0 = input.LA(1);

            if ( (LA204_0==99) ) {
                alt204=1;
            }
            switch (alt204) {
                case 1 :
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7616:6: otherlv_8= 'eAnnotations' otherlv_9= '{' ( (lv_eAnnotations_10_0= ruleEAnnotation ) ) (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )* otherlv_13= '}'
                    {
                    otherlv_8=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleEEnumLiteral15769); 

                        	newLeafNode(otherlv_8, grammarAccess.getEEnumLiteralAccess().getEAnnotationsKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEEnumLiteral15781); 

                        	newLeafNode(otherlv_9, grammarAccess.getEEnumLiteralAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7624:1: ( (lv_eAnnotations_10_0= ruleEAnnotation ) )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7625:1: (lv_eAnnotations_10_0= ruleEAnnotation )
                    {
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7625:1: (lv_eAnnotations_10_0= ruleEAnnotation )
                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7626:3: lv_eAnnotations_10_0= ruleEAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEEnumLiteralAccess().getEAnnotationsEAnnotationParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEEnumLiteral15802);
                    lv_eAnnotations_10_0=ruleEAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEEnumLiteralRule());
                    	        }
                           		add(
                           			current, 
                           			"eAnnotations",
                            		lv_eAnnotations_10_0, 
                            		"EAnnotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7642:2: (otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) ) )*
                    loop203:
                    do {
                        int alt203=2;
                        int LA203_0 = input.LA(1);

                        if ( (LA203_0==14) ) {
                            alt203=1;
                        }


                        switch (alt203) {
                    	case 1 :
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7642:4: otherlv_11= ',' ( (lv_eAnnotations_12_0= ruleEAnnotation ) )
                    	    {
                    	    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEEnumLiteral15815); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getEEnumLiteralAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7646:1: ( (lv_eAnnotations_12_0= ruleEAnnotation ) )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7647:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    	    {
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7647:1: (lv_eAnnotations_12_0= ruleEAnnotation )
                    	    // ../org.malai.editor/src-gen/org/parser/antlr/internal/InternalMalai.g:7648:3: lv_eAnnotations_12_0= ruleEAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEEnumLiteralAccess().getEAnnotationsEAnnotationParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEAnnotation_in_ruleEEnumLiteral15836);
                    	    lv_eAnnotations_12_0=ruleEAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEEnumLiteralRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_12_0, 
                    	            		"EAnnotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop203;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnumLiteral15850); 

                        	newLeafNode(otherlv_13, grammarAccess.getEEnumLiteralAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            otherlv_14=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEEnumLiteral15864); 

                	newLeafNode(otherlv_14, grammarAccess.getEEnumLiteralAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEEnumLiteral"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleinteractiveSystem_in_entryRuleinteractiveSystem75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleinteractiveSystem85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleinteractiveSystem131 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem143 = new BitSet(new long[]{0x00000000000FA000L});
        public static final BitSet FOLLOW_13_in_ruleinteractiveSystem156 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem168 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_ruleInstrument_in_ruleinteractiveSystem189 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleinteractiveSystem202 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_ruleInstrument_in_ruleinteractiveSystem223 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem237 = new BitSet(new long[]{0x00000000000F8000L});
        public static final BitSet FOLLOW_16_in_ruleinteractiveSystem252 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem264 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_ruleInteraction_in_ruleinteractiveSystem285 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleinteractiveSystem298 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_ruleInteraction_in_ruleinteractiveSystem319 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem333 = new BitSet(new long[]{0x00000000000E8000L});
        public static final BitSet FOLLOW_17_in_ruleinteractiveSystem348 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem360 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_ruleAction_in_ruleinteractiveSystem381 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleinteractiveSystem394 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_ruleAction_in_ruleinteractiveSystem415 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem429 = new BitSet(new long[]{0x00000000000C8000L});
        public static final BitSet FOLLOW_18_in_ruleinteractiveSystem444 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem456 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEvent_in_ruleinteractiveSystem477 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleinteractiveSystem490 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEvent_in_ruleinteractiveSystem511 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem525 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleinteractiveSystem540 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleinteractiveSystem552 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleinteractiveSystem573 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleinteractiveSystem586 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleinteractiveSystem607 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem621 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleinteractiveSystem635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWidget_in_entryRuleWidget671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWidget681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTree_in_ruleWidget728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSlider_in_ruleWidget755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgressBar_in_ruleWidget782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTable_in_ruleWidget809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLabel_in_ruleWidget836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextArea_in_ruleWidget863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextField_in_ruleWidget890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpinner_in_ruleWidget917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiLineList_in_ruleWidget944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleLineList_in_ruleWidget971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePanel_in_ruleWidget998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWindow_Impl_in_ruleWidget1025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDialogueBox_in_ruleWidget1052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSplitPane_in_ruleWidget1079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTabbedPanel_in_ruleWidget1106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleButton_Impl_in_ruleWidget1133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleToggleButton_in_ruleWidget1160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMenu_Impl_in_ruleWidget1187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckBox_in_ruleWidget1214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRadioButton_in_ruleWidget1241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleToggleMenu_in_ruleWidget1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRadioMenu_in_ruleWidget1295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleState_in_entryRuleState1330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState1340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbortingState_in_ruleState1387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalState_in_ruleState1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStandardState_Impl_in_ruleState1441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInitState_in_ruleState1468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInstrument_in_entryRuleInstrument1503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInstrument1513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleInstrument1565 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleInstrument1591 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInstrument1603 = new BitSet(new long[]{0x00000003CFC08000L});
        public static final BitSet FOLLOW_22_in_ruleInstrument1616 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1637 = new BitSet(new long[]{0x00000003CF808000L});
        public static final BitSet FOLLOW_23_in_ruleInstrument1652 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1673 = new BitSet(new long[]{0x00000003CF008000L});
        public static final BitSet FOLLOW_24_in_ruleInstrument1688 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1709 = new BitSet(new long[]{0x00000003CE008000L});
        public static final BitSet FOLLOW_25_in_ruleInstrument1724 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1745 = new BitSet(new long[]{0x00000003CC008000L});
        public static final BitSet FOLLOW_26_in_ruleInstrument1760 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1781 = new BitSet(new long[]{0x00000003C8008000L});
        public static final BitSet FOLLOW_27_in_ruleInstrument1796 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleInstrument1808 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1831 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleInstrument1844 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInstrument1867 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleInstrument1881 = new BitSet(new long[]{0x00000003C0008000L});
        public static final BitSet FOLLOW_30_in_ruleInstrument1896 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInstrument1908 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_ruleLink_in_ruleInstrument1929 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleInstrument1942 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_ruleLink_in_ruleInstrument1963 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleInstrument1977 = new BitSet(new long[]{0x0000000380008000L});
        public static final BitSet FOLLOW_31_in_ruleInstrument1992 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleInstrument2013 = new BitSet(new long[]{0x0000000300008000L});
        public static final BitSet FOLLOW_32_in_ruleInstrument2028 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInstrument2040 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L,0x0000000000500000L});
        public static final BitSet FOLLOW_ruleEClassifier_in_ruleInstrument2061 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleInstrument2074 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L,0x0000000000500000L});
        public static final BitSet FOLLOW_ruleEClassifier_in_ruleInstrument2095 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleInstrument2109 = new BitSet(new long[]{0x0000000200008000L});
        public static final BitSet FOLLOW_33_in_ruleInstrument2124 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInstrument2136 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleInstrument2157 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleInstrument2170 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleInstrument2191 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleInstrument2205 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleInstrument2219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleAction2308 = new BitSet(new long[]{0x0000001800000000L});
        public static final BitSet FOLLOW_35_in_ruleAction2339 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleAction2365 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2386 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAction2398 = new BitSet(new long[]{0x000003E080000000L});
        public static final BitSet FOLLOW_37_in_ruleAction2411 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2432 = new BitSet(new long[]{0x000003C080000000L});
        public static final BitSet FOLLOW_38_in_ruleAction2447 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2468 = new BitSet(new long[]{0x0000038080000000L});
        public static final BitSet FOLLOW_39_in_ruleAction2483 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2504 = new BitSet(new long[]{0x0000030080000000L});
        public static final BitSet FOLLOW_40_in_ruleAction2519 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2540 = new BitSet(new long[]{0x0000020080000000L});
        public static final BitSet FOLLOW_41_in_ruleAction2555 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleAction2567 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2590 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleAction2603 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAction2626 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleAction2640 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleAction2654 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleAction2675 = new BitSet(new long[]{0x0000040000008000L});
        public static final BitSet FOLLOW_42_in_ruleAction2688 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAction2700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleActionDependency_in_ruleAction2721 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleAction2734 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleActionDependency_in_ruleAction2755 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleAction2769 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAction2783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent2819 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvent2829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEvent2866 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEvent2878 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleEvent2890 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleEvent2911 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEvent2923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLink_in_entryRuleLink2959 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLink2969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleLink3012 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleLink3037 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLink3049 = new BitSet(new long[]{0x0003C00004400000L});
        public static final BitSet FOLLOW_22_in_ruleLink3062 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3083 = new BitSet(new long[]{0x0003C00004000000L});
        public static final BitSet FOLLOW_26_in_ruleLink3098 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3119 = new BitSet(new long[]{0x0003C00000000000L});
        public static final BitSet FOLLOW_46_in_ruleLink3134 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3155 = new BitSet(new long[]{0x0003800000000000L});
        public static final BitSet FOLLOW_47_in_ruleLink3170 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3191 = new BitSet(new long[]{0x0003000000000000L});
        public static final BitSet FOLLOW_48_in_ruleLink3206 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3227 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLink3241 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3264 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleLink3276 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLink3299 = new BitSet(new long[]{0x0000000080008000L});
        public static final BitSet FOLLOW_31_in_ruleLink3312 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleLink3333 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLink3347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInteraction_in_entryRuleInteraction3383 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInteraction3393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleInteraction3436 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleInteraction3461 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3482 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInteraction3494 = new BitSet(new long[]{0x00E0000083C00000L});
        public static final BitSet FOLLOW_22_in_ruleInteraction3507 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3528 = new BitSet(new long[]{0x00E0000083800000L});
        public static final BitSet FOLLOW_23_in_ruleInteraction3543 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3564 = new BitSet(new long[]{0x00E0000083000000L});
        public static final BitSet FOLLOW_25_in_ruleInteraction3579 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3600 = new BitSet(new long[]{0x00E0000081000000L});
        public static final BitSet FOLLOW_24_in_ruleInteraction3615 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3636 = new BitSet(new long[]{0x00E0000080000000L});
        public static final BitSet FOLLOW_53_in_ruleInteraction3651 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3674 = new BitSet(new long[]{0x00C0000080000000L});
        public static final BitSet FOLLOW_54_in_ruleInteraction3689 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInteraction3712 = new BitSet(new long[]{0x0080000080000000L});
        public static final BitSet FOLLOW_55_in_ruleInteraction3727 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInteraction3739 = new BitSet(new long[]{0x9000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleState_in_ruleInteraction3760 = new BitSet(new long[]{0x9000000000008000L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleState_in_ruleInteraction3781 = new BitSet(new long[]{0x9000000000008000L,0x0000000000000003L});
        public static final BitSet FOLLOW_15_in_ruleInteraction3794 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleInteraction3808 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleInteraction3829 = new BitSet(new long[]{0x0000000100008000L});
        public static final BitSet FOLLOW_32_in_ruleInteraction3842 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInteraction3854 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L,0x0000000000500000L});
        public static final BitSet FOLLOW_ruleEClassifier_in_ruleInteraction3875 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleInteraction3888 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L,0x0000000000500000L});
        public static final BitSet FOLLOW_ruleEClassifier_in_ruleInteraction3909 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleInteraction3923 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleInteraction3937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition3973 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransition3983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4029 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleTransition4041 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4064 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleTransition4076 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleTransition4088 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4111 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleTransition4123 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4146 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleTransition4159 = new BitSet(new long[]{0x0C00000000428000L});
        public static final BitSet FOLLOW_22_in_ruleTransition4172 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4193 = new BitSet(new long[]{0x0C00000000028000L});
        public static final BitSet FOLLOW_58_in_ruleTransition4208 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4229 = new BitSet(new long[]{0x0800000000028000L});
        public static final BitSet FOLLOW_17_in_ruleTransition4244 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTransition4265 = new BitSet(new long[]{0x0800000000008000L});
        public static final BitSet FOLLOW_59_in_ruleTransition4280 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleTransition4301 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTransition4315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInitState_in_entryRuleInitState4353 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInitState4363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleInitState4409 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInitState4430 = new BitSet(new long[]{0x2000000000000032L});
        public static final BitSet FOLLOW_61_in_ruleInitState4443 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleInitState4464 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleInitState4476 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleInitState4500 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleInitState4513 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleInitState4534 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleAbortingState_in_entryRuleAbortingState4574 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbortingState4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleAbortingState4630 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAbortingState4651 = new BitSet(new long[]{0x2000000000000032L});
        public static final BitSet FOLLOW_61_in_ruleAbortingState4664 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleAbortingState4685 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleAbortingState4697 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleAbortingState4721 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleAbortingState4734 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleAbortingState4755 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleTerminalState_in_entryRuleTerminalState4795 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalState4805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleTerminalState4851 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTerminalState4872 = new BitSet(new long[]{0x2000000000000032L});
        public static final BitSet FOLLOW_61_in_ruleTerminalState4885 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTerminalState4906 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleTerminalState4918 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleTerminalState4942 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTerminalState4955 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleTerminalState4976 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleStandardState_Impl_in_entryRuleStandardState_Impl5016 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStandardState_Impl5026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleStandardState_Impl5072 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleStandardState_Impl5093 = new BitSet(new long[]{0x2000000000000032L});
        public static final BitSet FOLLOW_61_in_ruleStandardState_Impl5106 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleStandardState_Impl5127 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleStandardState_Impl5139 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleStandardState_Impl5163 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleStandardState_Impl5176 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleStandardState_Impl5197 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleActionDependency_in_entryRuleActionDependency5237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActionDependency5247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleActionDependency5284 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleActionDependency5305 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleActionDependency5317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleActionDependency5329 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleActionDependency5352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleActionDependency5364 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleActionDependency5376 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleActionDependency5399 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleActionDependency5412 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleActionDependency5435 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleActionDependency5449 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleActionDependency5461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTree_in_entryRuleTree5497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTree5507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleTree5553 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTree5574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSlider_in_entryRuleSlider5610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSlider5620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleSlider5666 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSlider5687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgressBar_in_entryRuleProgressBar5723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgressBar5733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleProgressBar5779 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleProgressBar5800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTable_in_entryRuleTable5836 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTable5846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleTable5892 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTable5913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLabel_in_entryRuleLabel5949 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLabel5959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleLabel6005 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLabel6026 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLabel6038 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleLabel6051 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLabel6072 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLabel6086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextArea_in_entryRuleTextArea6122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextArea6132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleTextArea6178 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTextArea6199 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTextArea6211 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleTextArea6224 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTextArea6245 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTextArea6259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextField_in_entryRuleTextField6295 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextField6305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleTextField6351 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTextField6372 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTextField6384 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleTextField6397 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTextField6418 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTextField6432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpinner_in_entryRuleSpinner6468 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpinner6478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleSpinner6524 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSpinner6545 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSpinner6557 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleSpinner6570 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSpinner6591 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSpinner6605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiLineList_in_entryRuleMultiLineList6641 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineList6651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleMultiLineList6697 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMultiLineList6718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleLineList_in_entryRuleSingleLineList6754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleLineList6764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleSingleLineList6810 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSingleLineList6831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePanel_in_entryRulePanel6867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePanel6877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_rulePanel6923 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_rulePanel6944 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_rulePanel6956 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_rulePanel6969 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_rulePanel6981 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_rulePanel7002 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_rulePanel7015 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_rulePanel7036 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_rulePanel7050 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_rulePanel7064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWindow_Impl_in_entryRuleWindow_Impl7100 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWindow_Impl7110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleWindow_Impl7156 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleWindow_Impl7177 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleWindow_Impl7189 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleWindow_Impl7202 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleWindow_Impl7214 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleWindow_Impl7235 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleWindow_Impl7248 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleWindow_Impl7269 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleWindow_Impl7283 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleWindow_Impl7297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDialogueBox_in_entryRuleDialogueBox7333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDialogueBox7343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleDialogueBox7389 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDialogueBox7410 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDialogueBox7422 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleDialogueBox7435 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDialogueBox7447 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleDialogueBox7468 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleDialogueBox7481 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleDialogueBox7502 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleDialogueBox7516 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDialogueBox7530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSplitPane_in_entryRuleSplitPane7566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSplitPane7576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleSplitPane7622 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSplitPane7643 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSplitPane7655 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleSplitPane7668 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSplitPane7680 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleSplitPane7701 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleSplitPane7714 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleSplitPane7735 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleSplitPane7749 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSplitPane7763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTabbedPanel_in_entryRuleTabbedPanel7799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTabbedPanel7809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleTabbedPanel7855 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTabbedPanel7876 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTabbedPanel7888 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleTabbedPanel7901 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTabbedPanel7913 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleTabbedPanel7934 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleTabbedPanel7947 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFDFBE0L});
        public static final BitSet FOLLOW_ruleWidget_in_ruleTabbedPanel7968 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleTabbedPanel7982 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTabbedPanel7996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleButton_Impl_in_entryRuleButton_Impl8032 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleButton_Impl8042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleButton_Impl8088 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleButton_Impl8109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleToggleButton_in_entryRuleToggleButton8145 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleToggleButton8155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleToggleButton8201 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleToggleButton8222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMenu_Impl_in_entryRuleMenu_Impl8258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMenu_Impl8268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleMenu_Impl8314 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMenu_Impl8335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckBox_in_entryRuleCheckBox8371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheckBox8381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleCheckBox8427 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCheckBox8448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRadioButton_in_entryRuleRadioButton8484 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRadioButton8494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_ruleRadioButton8540 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleRadioButton8561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleToggleMenu_in_entryRuleToggleMenu8597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleToggleMenu8607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_91_in_ruleToggleMenu8653 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleToggleMenu8674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRadioMenu_in_entryRuleRadioMenu8710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRadioMenu8720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleRadioMenu8766 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleRadioMenu8787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClassifier_in_entryRuleEClassifier8823 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClassifier8833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClass_in_ruleEClassifier8880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataType_Impl_in_ruleEClassifier8907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnum_in_ruleEClassifier8934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStructuralFeature_in_entryRuleEStructuralFeature8969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeature8979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleEStructuralFeature9026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReference_in_ruleEStructuralFeature9053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEClass_in_entryRuleEClass9088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEClass9098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_93_in_ruleEClass9150 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
        public static final BitSet FOLLOW_94_in_ruleEClass9182 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_95_in_ruleEClass9208 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEClass9229 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9241 = new BitSet(new long[]{0x0000000000008000L,0x000000FF00000000L});
        public static final BitSet FOLLOW_96_in_ruleEClass9254 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEClass9275 = new BitSet(new long[]{0x0000000000008000L,0x000000FE00000000L});
        public static final BitSet FOLLOW_97_in_ruleEClass9290 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEClass9311 = new BitSet(new long[]{0x0000000000008000L,0x000000FC00000000L});
        public static final BitSet FOLLOW_98_in_ruleEClass9326 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleEClass9338 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEClass9361 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9374 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEClass9397 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleEClass9411 = new BitSet(new long[]{0x0000000000008000L,0x000000F800000000L});
        public static final BitSet FOLLOW_99_in_ruleEClass9426 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9438 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEClass9459 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9472 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEClass9493 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9507 = new BitSet(new long[]{0x0000000000008000L,0x000000F000000000L});
        public static final BitSet FOLLOW_100_in_ruleEClass9522 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9534 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEClass9555 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9568 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEClass9589 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9603 = new BitSet(new long[]{0x0000000000008000L,0x000000E000000000L});
        public static final BitSet FOLLOW_101_in_ruleEClass9618 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9630 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
        public static final BitSet FOLLOW_ruleEOperation_in_ruleEClass9651 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9664 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
        public static final BitSet FOLLOW_ruleEOperation_in_ruleEClass9685 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9699 = new BitSet(new long[]{0x0000000000008000L,0x000000C000000000L});
        public static final BitSet FOLLOW_102_in_ruleEClass9714 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000019F80L});
        public static final BitSet FOLLOW_ruleEStructuralFeature_in_ruleEClass9747 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000019F80L});
        public static final BitSet FOLLOW_ruleEStructuralFeature_in_ruleEClass9781 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9795 = new BitSet(new long[]{0x0000000000008000L,0x0000008000000000L});
        public static final BitSet FOLLOW_103_in_ruleEClass9810 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEClass9822 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEClass9843 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEClass9856 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEClass9877 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9891 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEClass9905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString9942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString9953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString9993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString10019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean10065 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean10076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleEBoolean10114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleEBoolean10133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt10174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt10185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleEInt10224 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt10241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_entryRuleEAnnotation10286 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotation10296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleEAnnotation10342 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAnnotation10354 = new BitSet(new long[]{0x0000000000008000L,0x0000F00800000000L});
        public static final BitSet FOLLOW_108_in_ruleEAnnotation10367 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAnnotation10388 = new BitSet(new long[]{0x0000000000008000L,0x0000E00800000000L});
        public static final BitSet FOLLOW_109_in_ruleEAnnotation10403 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleEAnnotation10415 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAnnotation10438 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleEAnnotation10451 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAnnotation10474 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleEAnnotation10488 = new BitSet(new long[]{0x0000000000008000L,0x0000C00800000000L});
        public static final BitSet FOLLOW_99_in_ruleEAnnotation10503 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAnnotation10515 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEAnnotation10536 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEAnnotation10549 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEAnnotation10570 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEAnnotation10584 = new BitSet(new long[]{0x0000000000008000L,0x0000C00000000000L});
        public static final BitSet FOLLOW_110_in_ruleEAnnotation10599 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAnnotation10611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleEStringToStringMapEntry_in_ruleEAnnotation10632 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEAnnotation10645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleEStringToStringMapEntry_in_ruleEAnnotation10666 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEAnnotation10680 = new BitSet(new long[]{0x0000000000008000L,0x0000800000000000L});
        public static final BitSet FOLLOW_111_in_ruleEAnnotation10695 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAnnotation10707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleEAnnotation10728 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEAnnotation10741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleEAnnotation10762 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEAnnotation10776 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEAnnotation10790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_entryRuleETypeParameter10826 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameter10836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleETypeParameter10882 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleETypeParameter10903 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleETypeParameter10915 = new BitSet(new long[]{0x0000000000008000L,0x0002000800000000L});
        public static final BitSet FOLLOW_99_in_ruleETypeParameter10928 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleETypeParameter10940 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleETypeParameter10961 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleETypeParameter10974 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleETypeParameter10995 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleETypeParameter11009 = new BitSet(new long[]{0x0000000000008000L,0x0002000000000000L});
        public static final BitSet FOLLOW_113_in_ruleETypeParameter11024 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleETypeParameter11036 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleETypeParameter11057 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleETypeParameter11070 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleETypeParameter11091 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleETypeParameter11105 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleETypeParameter11119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEOperation_in_entryRuleEOperation11155 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEOperation11165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleEOperation11211 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEOperation11232 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEOperation11244 = new BitSet(new long[]{0x0000000000008000L,0x0FF8001800000000L});
        public static final BitSet FOLLOW_115_in_ruleEOperation11257 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEOperation11278 = new BitSet(new long[]{0x0000000000008000L,0x0FF0001800000000L});
        public static final BitSet FOLLOW_116_in_ruleEOperation11293 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEOperation11314 = new BitSet(new long[]{0x0000000000008000L,0x0FE0001800000000L});
        public static final BitSet FOLLOW_117_in_ruleEOperation11329 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEOperation11350 = new BitSet(new long[]{0x0000000000008000L,0x0FC0001800000000L});
        public static final BitSet FOLLOW_118_in_ruleEOperation11365 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEOperation11386 = new BitSet(new long[]{0x0000000000008000L,0x0F80001800000000L});
        public static final BitSet FOLLOW_119_in_ruleEOperation11401 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEOperation11424 = new BitSet(new long[]{0x0000000000008000L,0x0F00001800000000L});
        public static final BitSet FOLLOW_120_in_ruleEOperation11439 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleEOperation11451 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEOperation11474 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleEOperation11487 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEOperation11510 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleEOperation11524 = new BitSet(new long[]{0x0000000000008000L,0x0E00001800000000L});
        public static final BitSet FOLLOW_99_in_ruleEOperation11539 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEOperation11551 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEOperation11572 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEOperation11585 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEOperation11606 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEOperation11620 = new BitSet(new long[]{0x0000000000008000L,0x0E00001000000000L});
        public static final BitSet FOLLOW_121_in_ruleEOperation11635 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEOperation11656 = new BitSet(new long[]{0x0000000000008000L,0x0C00001000000000L});
        public static final BitSet FOLLOW_100_in_ruleEOperation11671 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEOperation11683 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEOperation11704 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEOperation11717 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEOperation11738 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEOperation11752 = new BitSet(new long[]{0x0000000000008000L,0x0C00000000000000L});
        public static final BitSet FOLLOW_122_in_ruleEOperation11767 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEOperation11779 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEParameter_in_ruleEOperation11800 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEOperation11813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEParameter_in_ruleEOperation11834 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEOperation11848 = new BitSet(new long[]{0x0000000000008000L,0x0800000000000000L});
        public static final BitSet FOLLOW_123_in_ruleEOperation11863 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEOperation11875 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEOperation11896 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEOperation11909 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEOperation11930 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEOperation11944 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEOperation11958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEGenericType_in_entryRuleEGenericType11994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEGenericType12004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleEGenericType12050 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEGenericType12062 = new BitSet(new long[]{0x0000000000008000L,0xE000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_125_in_ruleEGenericType12075 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEGenericType12098 = new BitSet(new long[]{0x0000000000008000L,0xC000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_126_in_ruleEGenericType12113 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEGenericType12136 = new BitSet(new long[]{0x0000000000008000L,0x8000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_127_in_ruleEGenericType12151 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEGenericType12172 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_128_in_ruleEGenericType12187 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEGenericType12199 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEGenericType12220 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEGenericType12233 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEGenericType12254 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEGenericType12268 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleEGenericType12283 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEGenericType12304 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEGenericType12318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEStringToStringMapEntry_in_entryRuleEStringToStringMapEntry12354 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEStringToStringMapEntry12364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleEStringToStringMapEntry12410 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEStringToStringMapEntry12422 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000000L,0x0000000000000018L});
        public static final BitSet FOLLOW_131_in_ruleEStringToStringMapEntry12435 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEStringToStringMapEntry12456 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_132_in_ruleEStringToStringMapEntry12471 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEStringToStringMapEntry12492 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEStringToStringMapEntry12506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObject_in_entryRuleEObject12542 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObject12552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleEObject12598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEParameter_in_entryRuleEParameter12634 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEParameter12644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleEParameter12690 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEParameter12711 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEParameter12723 = new BitSet(new long[]{0x0000000000008000L,0x02F8000800000000L});
        public static final BitSet FOLLOW_115_in_ruleEParameter12736 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEParameter12757 = new BitSet(new long[]{0x0000000000008000L,0x02F0000800000000L});
        public static final BitSet FOLLOW_116_in_ruleEParameter12772 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEParameter12793 = new BitSet(new long[]{0x0000000000008000L,0x02E0000800000000L});
        public static final BitSet FOLLOW_117_in_ruleEParameter12808 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEParameter12829 = new BitSet(new long[]{0x0000000000008000L,0x02C0000800000000L});
        public static final BitSet FOLLOW_118_in_ruleEParameter12844 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEParameter12865 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L});
        public static final BitSet FOLLOW_119_in_ruleEParameter12880 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEParameter12903 = new BitSet(new long[]{0x0000000000008000L,0x0200000800000000L});
        public static final BitSet FOLLOW_99_in_ruleEParameter12918 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEParameter12930 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEParameter12951 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEParameter12964 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEParameter12985 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEParameter12999 = new BitSet(new long[]{0x0000000000008000L,0x0200000000000000L});
        public static final BitSet FOLLOW_121_in_ruleEParameter13014 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEParameter13035 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEParameter13049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttribute_in_entryRuleEAttribute13085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttribute13095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleEAttribute13147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001F00L});
        public static final BitSet FOLLOW_136_in_ruleEAttribute13179 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001E00L});
        public static final BitSet FOLLOW_137_in_ruleEAttribute13211 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001C00L});
        public static final BitSet FOLLOW_138_in_ruleEAttribute13243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001800L});
        public static final BitSet FOLLOW_139_in_ruleEAttribute13275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_140_in_ruleEAttribute13301 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAttribute13322 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAttribute13334 = new BitSet(new long[]{0x0000000000008000L,0x02F8000800000000L,0x0000000000006000L});
        public static final BitSet FOLLOW_115_in_ruleEAttribute13347 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEAttribute13368 = new BitSet(new long[]{0x0000000000008000L,0x02F0000800000000L,0x0000000000006000L});
        public static final BitSet FOLLOW_116_in_ruleEAttribute13383 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEAttribute13404 = new BitSet(new long[]{0x0000000000008000L,0x02E0000800000000L,0x0000000000006000L});
        public static final BitSet FOLLOW_117_in_ruleEAttribute13419 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEAttribute13440 = new BitSet(new long[]{0x0000000000008000L,0x02C0000800000000L,0x0000000000006000L});
        public static final BitSet FOLLOW_118_in_ruleEAttribute13455 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEAttribute13476 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x0000000000006000L});
        public static final BitSet FOLLOW_141_in_ruleEAttribute13491 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEAttribute13512 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_142_in_ruleEAttribute13527 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAttribute13548 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L});
        public static final BitSet FOLLOW_119_in_ruleEAttribute13563 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEAttribute13586 = new BitSet(new long[]{0x0000000000008000L,0x0200000800000000L});
        public static final BitSet FOLLOW_99_in_ruleEAttribute13601 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEAttribute13613 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEAttribute13634 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEAttribute13647 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEAttribute13668 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEAttribute13682 = new BitSet(new long[]{0x0000000000008000L,0x0200000000000000L});
        public static final BitSet FOLLOW_121_in_ruleEAttribute13697 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEAttribute13718 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEAttribute13732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEReference_in_entryRuleEReference13768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEReference13778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleEReference13830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000018700L});
        public static final BitSet FOLLOW_136_in_ruleEReference13862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000018600L});
        public static final BitSet FOLLOW_137_in_ruleEReference13894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000018400L});
        public static final BitSet FOLLOW_138_in_ruleEReference13926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000018000L});
        public static final BitSet FOLLOW_143_in_ruleEReference13958 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_144_in_ruleEReference13984 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14005 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEReference14017 = new BitSet(new long[]{0x0000000000008000L,0x02F8000800000000L,0x00000000000E6000L});
        public static final BitSet FOLLOW_115_in_ruleEReference14030 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEReference14051 = new BitSet(new long[]{0x0000000000008000L,0x02F0000800000000L,0x00000000000E6000L});
        public static final BitSet FOLLOW_116_in_ruleEReference14066 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEReference14087 = new BitSet(new long[]{0x0000000000008000L,0x02E0000800000000L,0x00000000000E6000L});
        public static final BitSet FOLLOW_117_in_ruleEReference14102 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEReference14123 = new BitSet(new long[]{0x0000000000008000L,0x02C0000800000000L,0x00000000000E6000L});
        public static final BitSet FOLLOW_118_in_ruleEReference14138 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEReference14159 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x00000000000E6000L});
        public static final BitSet FOLLOW_141_in_ruleEReference14174 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEReference14195 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x00000000000E4000L});
        public static final BitSet FOLLOW_142_in_ruleEReference14210 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14231 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x00000000000E0000L});
        public static final BitSet FOLLOW_145_in_ruleEReference14246 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEReference14267 = new BitSet(new long[]{0x0000000000008000L,0x0280000800000000L,0x00000000000C0000L});
        public static final BitSet FOLLOW_119_in_ruleEReference14282 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14305 = new BitSet(new long[]{0x0000000000008000L,0x0200000800000000L,0x00000000000C0000L});
        public static final BitSet FOLLOW_146_in_ruleEReference14320 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14343 = new BitSet(new long[]{0x0000000000008000L,0x0200000800000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_147_in_ruleEReference14358 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleEReference14370 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14393 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_14_in_ruleEReference14406 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEReference14429 = new BitSet(new long[]{0x0000000020004000L});
        public static final BitSet FOLLOW_29_in_ruleEReference14443 = new BitSet(new long[]{0x0000000000008000L,0x0200000800000000L});
        public static final BitSet FOLLOW_99_in_ruleEReference14458 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEReference14470 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEReference14491 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEReference14504 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEReference14525 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEReference14539 = new BitSet(new long[]{0x0000000000008000L,0x0200000000000000L});
        public static final BitSet FOLLOW_121_in_ruleEReference14554 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
        public static final BitSet FOLLOW_ruleEGenericType_in_ruleEReference14575 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEReference14589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDataType_Impl_in_entryRuleEDataType_Impl14625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDataType_Impl14635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_148_in_ruleEDataType_Impl14681 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEDataType_Impl14702 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEDataType_Impl14714 = new BitSet(new long[]{0x0000000000008000L,0x0000001B00000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_96_in_ruleEDataType_Impl14727 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEDataType_Impl14748 = new BitSet(new long[]{0x0000000000008000L,0x0000001A00000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_97_in_ruleEDataType_Impl14763 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEDataType_Impl14784 = new BitSet(new long[]{0x0000000000008000L,0x0000001800000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_149_in_ruleEDataType_Impl14799 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEDataType_Impl14820 = new BitSet(new long[]{0x0000000000008000L,0x0000001800000000L});
        public static final BitSet FOLLOW_99_in_ruleEDataType_Impl14835 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEDataType_Impl14847 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEDataType_Impl14868 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEDataType_Impl14881 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEDataType_Impl14902 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEDataType_Impl14916 = new BitSet(new long[]{0x0000000000008000L,0x0000001000000000L});
        public static final BitSet FOLLOW_100_in_ruleEDataType_Impl14931 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEDataType_Impl14943 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEDataType_Impl14964 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEDataType_Impl14977 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEDataType_Impl14998 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEDataType_Impl15012 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEDataType_Impl15026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnum_in_entryRuleEEnum15062 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnum15072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_150_in_ruleEEnum15118 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEEnum15139 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnum15151 = new BitSet(new long[]{0x0000000000008000L,0x0000001B00000000L,0x0000000000A00000L});
        public static final BitSet FOLLOW_96_in_ruleEEnum15164 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEEnum15185 = new BitSet(new long[]{0x0000000000008000L,0x0000001A00000000L,0x0000000000A00000L});
        public static final BitSet FOLLOW_97_in_ruleEEnum15200 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEEnum15221 = new BitSet(new long[]{0x0000000000008000L,0x0000001800000000L,0x0000000000A00000L});
        public static final BitSet FOLLOW_149_in_ruleEEnum15236 = new BitSet(new long[]{0x0000000000000000L,0x0000030000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleEEnum15257 = new BitSet(new long[]{0x0000000000008000L,0x0000001800000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_99_in_ruleEEnum15272 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnum15284 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEEnum15305 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEEnum15318 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEEnum15339 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEEnum15353 = new BitSet(new long[]{0x0000000000008000L,0x0000001000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_100_in_ruleEEnum15368 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnum15380 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEEnum15401 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEEnum15414 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_ruleETypeParameter_in_ruleEEnum15435 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEEnum15449 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_151_in_ruleEEnum15464 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnum15476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_ruleEEnumLiteral_in_ruleEEnum15497 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEEnum15510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_ruleEEnumLiteral_in_ruleEEnum15531 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEEnum15545 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEEnum15559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEEnumLiteral_in_entryRuleEEnumLiteral15595 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteral15605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_152_in_ruleEEnumLiteral15651 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEEnumLiteral15672 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnumLiteral15684 = new BitSet(new long[]{0x0000000000008000L,0x0000000800000000L,0x0000000002000010L});
        public static final BitSet FOLLOW_132_in_ruleEEnumLiteral15697 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleEEnumLiteral15718 = new BitSet(new long[]{0x0000000000008000L,0x0000000800000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_153_in_ruleEEnumLiteral15733 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleEEnumLiteral15754 = new BitSet(new long[]{0x0000000000008000L,0x0000000800000000L});
        public static final BitSet FOLLOW_99_in_ruleEEnumLiteral15769 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEEnumLiteral15781 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEEnumLiteral15802 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEEnumLiteral15815 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_ruleEAnnotation_in_ruleEEnumLiteral15836 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleEEnumLiteral15850 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEEnumLiteral15864 = new BitSet(new long[]{0x0000000000000002L});
    }


}