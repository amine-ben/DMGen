package fr.inria.diverse.dmgen.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.inria.diverse.dmgen.services.DMGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDMGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_SCHEME", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "';'", "'global'", "'density'", "'variation'", "'.'", "'generate'", "'with'", "'size'", "'prefix'", "'{'", "'}'", "'#'", "'/'", "'-'", "':'"
    };
    public static final int RULE_SCHEME=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalDMGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDMGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDMGenParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDMGen.g"; }



     	private DMGenGrammarAccess grammarAccess;

        public InternalDMGenParser(TokenStream input, DMGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "GenConfig";
       	}

       	@Override
       	protected DMGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGenConfig"
    // InternalDMGen.g:64:1: entryRuleGenConfig returns [EObject current=null] : iv_ruleGenConfig= ruleGenConfig EOF ;
    public final EObject entryRuleGenConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenConfig = null;


        try {
            // InternalDMGen.g:64:50: (iv_ruleGenConfig= ruleGenConfig EOF )
            // InternalDMGen.g:65:2: iv_ruleGenConfig= ruleGenConfig EOF
            {
             newCompositeNode(grammarAccess.getGenConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenConfig=ruleGenConfig();

            state._fsp--;

             current =iv_ruleGenConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGenConfig"


    // $ANTLR start "ruleGenConfig"
    // InternalDMGen.g:71:1: ruleGenConfig returns [EObject current=null] : (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) otherlv_2= ';' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) ( (lv_generators_12_0= ruleGenerator ) ) ( (lv_generators_13_0= ruleGenerator ) )* ) ;
    public final EObject ruleGenConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_globalDensity_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_metamodel_1_0 = null;

        AntlrDatatypeRuleToken lv_globalVariation_10_0 = null;

        EObject lv_generators_12_0 = null;

        EObject lv_generators_13_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:77:2: ( (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) otherlv_2= ';' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) ( (lv_generators_12_0= ruleGenerator ) ) ( (lv_generators_13_0= ruleGenerator ) )* ) )
            // InternalDMGen.g:78:2: (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) otherlv_2= ';' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) ( (lv_generators_12_0= ruleGenerator ) ) ( (lv_generators_13_0= ruleGenerator ) )* )
            {
            // InternalDMGen.g:78:2: (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) otherlv_2= ';' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) ( (lv_generators_12_0= ruleGenerator ) ) ( (lv_generators_13_0= ruleGenerator ) )* )
            // InternalDMGen.g:79:3: otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) otherlv_2= ';' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) ( (lv_generators_12_0= ruleGenerator ) ) ( (lv_generators_13_0= ruleGenerator ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGenConfigAccess().getImportKeyword_0());
            		
            // InternalDMGen.g:83:3: ( (lv_metamodel_1_0= ruleMetamodel ) )
            // InternalDMGen.g:84:4: (lv_metamodel_1_0= ruleMetamodel )
            {
            // InternalDMGen.g:84:4: (lv_metamodel_1_0= ruleMetamodel )
            // InternalDMGen.g:85:5: lv_metamodel_1_0= ruleMetamodel
            {

            					newCompositeNode(grammarAccess.getGenConfigAccess().getMetamodelMetamodelParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_metamodel_1_0=ruleMetamodel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenConfigRule());
            					}
            					set(
            						current,
            						"metamodel",
            						lv_metamodel_1_0,
            						"fr.inria.diverse.dmgen.DMGen.Metamodel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGenConfigAccess().getSemicolonKeyword_2());
            		
            // InternalDMGen.g:106:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) ) )
            // InternalDMGen.g:107:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) )
            {
            // InternalDMGen.g:107:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* ) )
            // InternalDMGen.g:108:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGenConfigAccess().getUnorderedGroup_3());
            				
            // InternalDMGen.g:111:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )* )
            // InternalDMGen.g:112:6: ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )*
            {
            // InternalDMGen.g:112:6: ( ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( LA1_0 == 14 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 0) ) ) {
                    int LA1_2 = input.LA(2);

                    if ( LA1_2 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 0) ) {
                        alt1=1;
                    }
                    else if ( LA1_2 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 1) ) {
                        alt1=2;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // InternalDMGen.g:113:4: ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) )
            	    {
            	    // InternalDMGen.g:113:4: ({...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) ) )
            	    // InternalDMGen.g:114:5: {...}? => ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalDMGen.g:114:106: ( ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) ) )
            	    // InternalDMGen.g:115:6: ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalDMGen.g:118:9: ({...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' ) )
            	    // InternalDMGen.g:118:10: {...}? => (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:118:19: (otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';' )
            	    // InternalDMGen.g:118:20: otherlv_4= 'global' otherlv_5= 'density' ( (lv_globalDensity_6_0= RULE_INT ) ) otherlv_7= ';'
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_6); 

            	    									newLeafNode(otherlv_4, grammarAccess.getGenConfigAccess().getGlobalKeyword_3_0_0());
            	    								
            	    otherlv_5=(Token)match(input,15,FOLLOW_7); 

            	    									newLeafNode(otherlv_5, grammarAccess.getGenConfigAccess().getDensityKeyword_3_0_1());
            	    								
            	    // InternalDMGen.g:126:9: ( (lv_globalDensity_6_0= RULE_INT ) )
            	    // InternalDMGen.g:127:10: (lv_globalDensity_6_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:127:10: (lv_globalDensity_6_0= RULE_INT )
            	    // InternalDMGen.g:128:11: lv_globalDensity_6_0= RULE_INT
            	    {
            	    lv_globalDensity_6_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    											newLeafNode(lv_globalDensity_6_0, grammarAccess.getGenConfigAccess().getGlobalDensityINTTerminalRuleCall_3_0_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getGenConfigRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"globalDensity",
            	    												lv_globalDensity_6_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }

            	    otherlv_7=(Token)match(input,13,FOLLOW_5); 

            	    									newLeafNode(otherlv_7, grammarAccess.getGenConfigAccess().getSemicolonKeyword_3_0_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:154:4: ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // InternalDMGen.g:154:4: ({...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) ) )
            	    // InternalDMGen.g:155:5: {...}? => ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalDMGen.g:155:106: ( ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) ) )
            	    // InternalDMGen.g:156:6: ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalDMGen.g:159:9: ({...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' ) )
            	    // InternalDMGen.g:159:10: {...}? => (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:159:19: (otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';' )
            	    // InternalDMGen.g:159:20: otherlv_8= 'global' otherlv_9= 'variation' ( (lv_globalVariation_10_0= ruleDECIMAL ) ) otherlv_11= ';'
            	    {
            	    otherlv_8=(Token)match(input,14,FOLLOW_8); 

            	    									newLeafNode(otherlv_8, grammarAccess.getGenConfigAccess().getGlobalKeyword_3_1_0());
            	    								
            	    otherlv_9=(Token)match(input,16,FOLLOW_7); 

            	    									newLeafNode(otherlv_9, grammarAccess.getGenConfigAccess().getVariationKeyword_3_1_1());
            	    								
            	    // InternalDMGen.g:167:9: ( (lv_globalVariation_10_0= ruleDECIMAL ) )
            	    // InternalDMGen.g:168:10: (lv_globalVariation_10_0= ruleDECIMAL )
            	    {
            	    // InternalDMGen.g:168:10: (lv_globalVariation_10_0= ruleDECIMAL )
            	    // InternalDMGen.g:169:11: lv_globalVariation_10_0= ruleDECIMAL
            	    {

            	    											newCompositeNode(grammarAccess.getGenConfigAccess().getGlobalVariationDECIMALParserRuleCall_3_1_2_0());
            	    										
            	    pushFollow(FOLLOW_4);
            	    lv_globalVariation_10_0=ruleDECIMAL();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    											}
            	    											set(
            	    												current,
            	    												"globalVariation",
            	    												lv_globalVariation_10_0,
            	    												"fr.inria.diverse.dmgen.DMGen.DECIMAL");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_11=(Token)match(input,13,FOLLOW_5); 

            	    									newLeafNode(otherlv_11, grammarAccess.getGenConfigAccess().getSemicolonKeyword_3_1_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGenConfigAccess().getUnorderedGroup_3());
            				

            }

            // InternalDMGen.g:203:3: ( (lv_generators_12_0= ruleGenerator ) )
            // InternalDMGen.g:204:4: (lv_generators_12_0= ruleGenerator )
            {
            // InternalDMGen.g:204:4: (lv_generators_12_0= ruleGenerator )
            // InternalDMGen.g:205:5: lv_generators_12_0= ruleGenerator
            {

            					newCompositeNode(grammarAccess.getGenConfigAccess().getGeneratorsGeneratorParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_generators_12_0=ruleGenerator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenConfigRule());
            					}
            					add(
            						current,
            						"generators",
            						lv_generators_12_0,
            						"fr.inria.diverse.dmgen.DMGen.Generator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDMGen.g:222:3: ( (lv_generators_13_0= ruleGenerator ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDMGen.g:223:4: (lv_generators_13_0= ruleGenerator )
            	    {
            	    // InternalDMGen.g:223:4: (lv_generators_13_0= ruleGenerator )
            	    // InternalDMGen.g:224:5: lv_generators_13_0= ruleGenerator
            	    {

            	    					newCompositeNode(grammarAccess.getGenConfigAccess().getGeneratorsGeneratorParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_generators_13_0=ruleGenerator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    					}
            	    					add(
            	    						current,
            	    						"generators",
            	    						lv_generators_13_0,
            	    						"fr.inria.diverse.dmgen.DMGen.Generator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleGenConfig"


    // $ANTLR start "entryRuleDECIMAL"
    // InternalDMGen.g:245:1: entryRuleDECIMAL returns [String current=null] : iv_ruleDECIMAL= ruleDECIMAL EOF ;
    public final String entryRuleDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECIMAL = null;


        try {
            // InternalDMGen.g:245:47: (iv_ruleDECIMAL= ruleDECIMAL EOF )
            // InternalDMGen.g:246:2: iv_ruleDECIMAL= ruleDECIMAL EOF
            {
             newCompositeNode(grammarAccess.getDECIMALRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDECIMAL=ruleDECIMAL();

            state._fsp--;

             current =iv_ruleDECIMAL.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDECIMAL"


    // $ANTLR start "ruleDECIMAL"
    // InternalDMGen.g:252:1: ruleDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalDMGen.g:258:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalDMGen.g:259:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalDMGen.g:259:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalDMGen.g:260:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_10); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,17,FOLLOW_7); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDECIMALAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_2());
            		

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
    // $ANTLR end "ruleDECIMAL"


    // $ANTLR start "entryRuleGenerator"
    // InternalDMGen.g:283:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalDMGen.g:283:50: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalDMGen.g:284:2: iv_ruleGenerator= ruleGenerator EOF
            {
             newCompositeNode(grammarAccess.getGeneratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerator=ruleGenerator();

            state._fsp--;

             current =iv_ruleGenerator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGenerator"


    // $ANTLR start "ruleGenerator"
    // InternalDMGen.g:290:1: ruleGenerator returns [EObject current=null] : ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( (lv_classes_9_0= ruleClazz ) )? (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleGenerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_number_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_size_5_0=null;
        Token otherlv_6=null;
        Token lv_prefix_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_classes_9_0 = null;

        EObject lv_classes_11_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:296:2: ( ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( (lv_classes_9_0= ruleClazz ) )? (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )* otherlv_12= '}' ) )
            // InternalDMGen.g:297:2: ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( (lv_classes_9_0= ruleClazz ) )? (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )* otherlv_12= '}' )
            {
            // InternalDMGen.g:297:2: ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( (lv_classes_9_0= ruleClazz ) )? (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )* otherlv_12= '}' )
            // InternalDMGen.g:298:3: ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( (lv_classes_9_0= ruleClazz ) )? (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )* otherlv_12= '}'
            {
            // InternalDMGen.g:298:3: ( (lv_name_0_0= 'generate' ) )
            // InternalDMGen.g:299:4: (lv_name_0_0= 'generate' )
            {
            // InternalDMGen.g:299:4: (lv_name_0_0= 'generate' )
            // InternalDMGen.g:300:5: lv_name_0_0= 'generate'
            {
            lv_name_0_0=(Token)match(input,18,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getGeneratorAccess().getNameGenerateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratorRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "generate");
            				

            }


            }

            // InternalDMGen.g:312:3: ( (lv_number_1_0= RULE_INT ) )
            // InternalDMGen.g:313:4: (lv_number_1_0= RULE_INT )
            {
            // InternalDMGen.g:313:4: (lv_number_1_0= RULE_INT )
            // InternalDMGen.g:314:5: lv_number_1_0= RULE_INT
            {
            lv_number_1_0=(Token)match(input,RULE_INT,FOLLOW_11); 

            					newLeafNode(lv_number_1_0, grammarAccess.getGeneratorAccess().getNumberINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"number",
            						lv_number_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneratorAccess().getWithKeyword_2());
            		
            // InternalDMGen.g:334:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) )
            // InternalDMGen.g:335:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalDMGen.g:335:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            // InternalDMGen.g:336:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            				
            // InternalDMGen.g:339:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            // InternalDMGen.g:340:6: ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?
            {
            // InternalDMGen.g:340:6: ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( LA3_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0) ) {
                    alt3=1;
                }
                else if ( LA3_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDMGen.g:341:4: ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:341:4: ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalDMGen.g:342:5: {...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalDMGen.g:342:106: ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) )
            	    // InternalDMGen.g:343:6: ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalDMGen.g:346:9: ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) )
            	    // InternalDMGen.g:346:10: {...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:346:19: (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) )
            	    // InternalDMGen.g:346:20: otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,20,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getGeneratorAccess().getSizeKeyword_3_0_0());
            	    								
            	    // InternalDMGen.g:350:9: ( (lv_size_5_0= RULE_INT ) )
            	    // InternalDMGen.g:351:10: (lv_size_5_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:351:10: (lv_size_5_0= RULE_INT )
            	    // InternalDMGen.g:352:11: lv_size_5_0= RULE_INT
            	    {
            	    lv_size_5_0=(Token)match(input,RULE_INT,FOLLOW_13); 

            	    											newLeafNode(lv_size_5_0, grammarAccess.getGeneratorAccess().getSizeINTTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getGeneratorRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"size",
            	    												lv_size_5_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:374:4: ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:374:4: ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalDMGen.g:375:5: {...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalDMGen.g:375:106: ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) )
            	    // InternalDMGen.g:376:6: ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalDMGen.g:379:9: ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) )
            	    // InternalDMGen.g:379:10: {...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:379:19: (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) )
            	    // InternalDMGen.g:379:20: otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,21,FOLLOW_14); 

            	    									newLeafNode(otherlv_6, grammarAccess.getGeneratorAccess().getPrefixKeyword_3_1_0());
            	    								
            	    // InternalDMGen.g:383:9: ( (lv_prefix_7_0= RULE_STRING ) )
            	    // InternalDMGen.g:384:10: (lv_prefix_7_0= RULE_STRING )
            	    {
            	    // InternalDMGen.g:384:10: (lv_prefix_7_0= RULE_STRING )
            	    // InternalDMGen.g:385:11: lv_prefix_7_0= RULE_STRING
            	    {
            	    lv_prefix_7_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	    											newLeafNode(lv_prefix_7_0, grammarAccess.getGeneratorAccess().getPrefixSTRINGTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getGeneratorRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"prefix",
            	    												lv_prefix_7_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canLeave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            				

            }

            otherlv_8=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getGeneratorAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDMGen.g:419:3: ( (lv_classes_9_0= ruleClazz ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDMGen.g:420:4: (lv_classes_9_0= ruleClazz )
                    {
                    // InternalDMGen.g:420:4: (lv_classes_9_0= ruleClazz )
                    // InternalDMGen.g:421:5: lv_classes_9_0= ruleClazz
                    {

                    					newCompositeNode(grammarAccess.getGeneratorAccess().getClassesClazzParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_classes_9_0=ruleClazz();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGeneratorRule());
                    					}
                    					add(
                    						current,
                    						"classes",
                    						lv_classes_9_0,
                    						"fr.inria.diverse.dmgen.DMGen.Clazz");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDMGen.g:438:3: (otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDMGen.g:439:4: otherlv_10= ';' ( (lv_classes_11_0= ruleClazz ) )
            	    {
            	    otherlv_10=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_10, grammarAccess.getGeneratorAccess().getSemicolonKeyword_6_0());
            	    			
            	    // InternalDMGen.g:443:4: ( (lv_classes_11_0= ruleClazz ) )
            	    // InternalDMGen.g:444:5: (lv_classes_11_0= ruleClazz )
            	    {
            	    // InternalDMGen.g:444:5: (lv_classes_11_0= ruleClazz )
            	    // InternalDMGen.g:445:6: lv_classes_11_0= ruleClazz
            	    {

            	    						newCompositeNode(grammarAccess.getGeneratorAccess().getClassesClazzParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_classes_11_0=ruleClazz();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGeneratorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"classes",
            	    							lv_classes_11_0,
            	    							"fr.inria.diverse.dmgen.DMGen.Clazz");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_12=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getGeneratorAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleGenerator"


    // $ANTLR start "entryRuleMetamodel"
    // InternalDMGen.g:471:1: entryRuleMetamodel returns [EObject current=null] : iv_ruleMetamodel= ruleMetamodel EOF ;
    public final EObject entryRuleMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodel = null;


        try {
            // InternalDMGen.g:471:50: (iv_ruleMetamodel= ruleMetamodel EOF )
            // InternalDMGen.g:472:2: iv_ruleMetamodel= ruleMetamodel EOF
            {
             newCompositeNode(grammarAccess.getMetamodelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetamodel=ruleMetamodel();

            state._fsp--;

             current =iv_ruleMetamodel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetamodel"


    // $ANTLR start "ruleMetamodel"
    // InternalDMGen.g:478:1: ruleMetamodel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) ) ;
    public final EObject ruleMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_uri_1_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:484:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) ) )
            // InternalDMGen.g:485:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) )
            {
            // InternalDMGen.g:485:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) )
            // InternalDMGen.g:486:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) )
            {
            // InternalDMGen.g:486:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:487:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:487:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:488:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getMetamodelAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetamodelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDMGen.g:504:3: ( (lv_uri_1_0= ruleURI ) )
            // InternalDMGen.g:505:4: (lv_uri_1_0= ruleURI )
            {
            // InternalDMGen.g:505:4: (lv_uri_1_0= ruleURI )
            // InternalDMGen.g:506:5: lv_uri_1_0= ruleURI
            {

            					newCompositeNode(grammarAccess.getMetamodelAccess().getUriURIParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_uri_1_0=ruleURI();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetamodelRule());
            					}
            					set(
            						current,
            						"uri",
            						lv_uri_1_0,
            						"fr.inria.diverse.dmgen.DMGen.URI");
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
    // $ANTLR end "ruleMetamodel"


    // $ANTLR start "entryRuleClazz"
    // InternalDMGen.g:527:1: entryRuleClazz returns [EObject current=null] : iv_ruleClazz= ruleClazz EOF ;
    public final EObject entryRuleClazz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClazz = null;


        try {
            // InternalDMGen.g:527:46: (iv_ruleClazz= ruleClazz EOF )
            // InternalDMGen.g:528:2: iv_ruleClazz= ruleClazz EOF
            {
             newCompositeNode(grammarAccess.getClazzRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClazz=ruleClazz();

            state._fsp--;

             current =iv_ruleClazz; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleClazz"


    // $ANTLR start "ruleClazz"
    // InternalDMGen.g:534:1: ruleClazz returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )? (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )? ) ;
    public final EObject ruleClazz() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_instances_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_properties_4_0 = null;

        EObject lv_properties_6_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:540:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )? (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )? ) )
            // InternalDMGen.g:541:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )? (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )? )
            {
            // InternalDMGen.g:541:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )? (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )? )
            // InternalDMGen.g:542:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )? (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )?
            {
            // InternalDMGen.g:542:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:543:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:543:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:544:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getClazzAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClazzRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDMGen.g:560:3: (otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDMGen.g:561:4: otherlv_1= '#' ( (lv_instances_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getClazzAccess().getNumberSignKeyword_1_0());
                    			
                    // InternalDMGen.g:565:4: ( (lv_instances_2_0= RULE_INT ) )
                    // InternalDMGen.g:566:5: (lv_instances_2_0= RULE_INT )
                    {
                    // InternalDMGen.g:566:5: (lv_instances_2_0= RULE_INT )
                    // InternalDMGen.g:567:6: lv_instances_2_0= RULE_INT
                    {
                    lv_instances_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

                    						newLeafNode(lv_instances_2_0, grammarAccess.getClazzAccess().getInstancesINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClazzRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"instances",
                    							lv_instances_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalDMGen.g:584:3: (otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDMGen.g:585:4: otherlv_3= '{' ( (lv_properties_4_0= ruleProperty ) ) (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )* otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getClazzAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalDMGen.g:589:4: ( (lv_properties_4_0= ruleProperty ) )
                    // InternalDMGen.g:590:5: (lv_properties_4_0= ruleProperty )
                    {
                    // InternalDMGen.g:590:5: (lv_properties_4_0= ruleProperty )
                    // InternalDMGen.g:591:6: lv_properties_4_0= ruleProperty
                    {

                    						newCompositeNode(grammarAccess.getClazzAccess().getPropertiesPropertyParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_properties_4_0=ruleProperty();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClazzRule());
                    						}
                    						add(
                    							current,
                    							"properties",
                    							lv_properties_4_0,
                    							"fr.inria.diverse.dmgen.DMGen.Property");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDMGen.g:608:4: (otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==13) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalDMGen.g:609:5: otherlv_5= ';' ( (lv_properties_6_0= ruleProperty ) )
                    	    {
                    	    otherlv_5=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getClazzAccess().getSemicolonKeyword_2_2_0());
                    	    				
                    	    // InternalDMGen.g:613:5: ( (lv_properties_6_0= ruleProperty ) )
                    	    // InternalDMGen.g:614:6: (lv_properties_6_0= ruleProperty )
                    	    {
                    	    // InternalDMGen.g:614:6: (lv_properties_6_0= ruleProperty )
                    	    // InternalDMGen.g:615:7: lv_properties_6_0= ruleProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getClazzAccess().getPropertiesPropertyParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_properties_6_0=ruleProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClazzRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_6_0,
                    	    								"fr.inria.diverse.dmgen.DMGen.Property");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,23,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getClazzAccess().getRightCurlyBracketKeyword_2_3());
                    			

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
    // $ANTLR end "ruleClazz"


    // $ANTLR start "entryRuleProperty"
    // InternalDMGen.g:642:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalDMGen.g:642:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalDMGen.g:643:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalDMGen.g:649:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_density_3_0=null;
        Token otherlv_4=null;
        Token lv_variation_5_0=null;


        	enterRule();

        try {
            // InternalDMGen.g:655:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) ) ) )
            // InternalDMGen.g:656:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalDMGen.g:656:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) ) )
            // InternalDMGen.g:657:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) )
            {
            // InternalDMGen.g:657:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:658:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:658:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:659:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDMGen.g:675:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) ) )
            // InternalDMGen.g:676:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) )
            {
            // InternalDMGen.g:676:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* ) )
            // InternalDMGen.g:677:5: ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            				
            // InternalDMGen.g:680:5: ( ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )* )
            // InternalDMGen.g:681:6: ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )*
            {
            // InternalDMGen.g:681:6: ( ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( LA9_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0) ) {
                    alt9=1;
                }
                else if ( LA9_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDMGen.g:682:4: ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:682:4: ({...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) ) )
            	    // InternalDMGen.g:683:5: {...}? => ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalDMGen.g:683:105: ( ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) ) )
            	    // InternalDMGen.g:684:6: ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalDMGen.g:687:9: ({...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) ) )
            	    // InternalDMGen.g:687:10: {...}? => (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalDMGen.g:687:19: (otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) ) )
            	    // InternalDMGen.g:687:20: otherlv_2= 'density' ( (lv_density_3_0= RULE_INT ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    									newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getDensityKeyword_1_0_0());
            	    								
            	    // InternalDMGen.g:691:9: ( (lv_density_3_0= RULE_INT ) )
            	    // InternalDMGen.g:692:10: (lv_density_3_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:692:10: (lv_density_3_0= RULE_INT )
            	    // InternalDMGen.g:693:11: lv_density_3_0= RULE_INT
            	    {
            	    lv_density_3_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            	    											newLeafNode(lv_density_3_0, grammarAccess.getPropertyAccess().getDensityINTTerminalRuleCall_1_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPropertyRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"density",
            	    												lv_density_3_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:715:4: ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:715:4: ({...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalDMGen.g:716:5: {...}? => ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalDMGen.g:716:105: ( ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) ) )
            	    // InternalDMGen.g:717:6: ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalDMGen.g:720:9: ({...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) ) )
            	    // InternalDMGen.g:720:10: {...}? => (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalDMGen.g:720:19: (otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) ) )
            	    // InternalDMGen.g:720:20: otherlv_4= 'variation' ( (lv_variation_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getPropertyAccess().getVariationKeyword_1_1_0());
            	    								
            	    // InternalDMGen.g:724:9: ( (lv_variation_5_0= RULE_INT ) )
            	    // InternalDMGen.g:725:10: (lv_variation_5_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:725:10: (lv_variation_5_0= RULE_INT )
            	    // InternalDMGen.g:726:11: lv_variation_5_0= RULE_INT
            	    {
            	    lv_variation_5_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            	    											newLeafNode(lv_variation_5_0, grammarAccess.getPropertyAccess().getVariationINTTerminalRuleCall_1_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPropertyRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"variation",
            	    												lv_variation_5_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            				

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleURI"
    // InternalDMGen.g:759:1: entryRuleURI returns [EObject current=null] : iv_ruleURI= ruleURI EOF ;
    public final EObject entryRuleURI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURI = null;


        try {
            // InternalDMGen.g:759:44: (iv_ruleURI= ruleURI EOF )
            // InternalDMGen.g:760:2: iv_ruleURI= ruleURI EOF
            {
             newCompositeNode(grammarAccess.getURIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURI=ruleURI();

            state._fsp--;

             current =iv_ruleURI; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleURI"


    // $ANTLR start "ruleURI"
    // InternalDMGen.g:766:1: ruleURI returns [EObject current=null] : ( ( (lv_scheme_0_0= RULE_SCHEME ) ) ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* ) ;
    public final EObject ruleURI() throws RecognitionException {
        EObject current = null;

        Token lv_scheme_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_authority_1_0 = null;

        AntlrDatatypeRuleToken lv_fragments_3_0 = null;

        AntlrDatatypeRuleToken lv_fragments_5_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:772:2: ( ( ( (lv_scheme_0_0= RULE_SCHEME ) ) ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* ) )
            // InternalDMGen.g:773:2: ( ( (lv_scheme_0_0= RULE_SCHEME ) ) ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* )
            {
            // InternalDMGen.g:773:2: ( ( (lv_scheme_0_0= RULE_SCHEME ) ) ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* )
            // InternalDMGen.g:774:3: ( (lv_scheme_0_0= RULE_SCHEME ) ) ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )*
            {
            // InternalDMGen.g:774:3: ( (lv_scheme_0_0= RULE_SCHEME ) )
            // InternalDMGen.g:775:4: (lv_scheme_0_0= RULE_SCHEME )
            {
            // InternalDMGen.g:775:4: (lv_scheme_0_0= RULE_SCHEME )
            // InternalDMGen.g:776:5: lv_scheme_0_0= RULE_SCHEME
            {
            lv_scheme_0_0=(Token)match(input,RULE_SCHEME,FOLLOW_3); 

            					newLeafNode(lv_scheme_0_0, grammarAccess.getURIAccess().getSchemeSCHEMETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"scheme",
            						lv_scheme_0_0,
            						"fr.inria.diverse.dmgen.DMGen.SCHEME");
            				

            }


            }

            // InternalDMGen.g:792:3: ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalDMGen.g:793:4: ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/'
                    {
                    // InternalDMGen.g:793:4: ( (lv_authority_1_0= ruleFRAGMENT ) )
                    // InternalDMGen.g:794:5: (lv_authority_1_0= ruleFRAGMENT )
                    {
                    // InternalDMGen.g:794:5: (lv_authority_1_0= ruleFRAGMENT )
                    // InternalDMGen.g:795:6: lv_authority_1_0= ruleFRAGMENT
                    {

                    						newCompositeNode(grammarAccess.getURIAccess().getAuthorityFRAGMENTParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_authority_1_0=ruleFRAGMENT();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURIRule());
                    						}
                    						set(
                    							current,
                    							"authority",
                    							lv_authority_1_0,
                    							"fr.inria.diverse.dmgen.DMGen.FRAGMENT");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getURIAccess().getSolidusKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalDMGen.g:817:3: ( (lv_fragments_3_0= ruleFRAGMENT ) )
            // InternalDMGen.g:818:4: (lv_fragments_3_0= ruleFRAGMENT )
            {
            // InternalDMGen.g:818:4: (lv_fragments_3_0= ruleFRAGMENT )
            // InternalDMGen.g:819:5: lv_fragments_3_0= ruleFRAGMENT
            {

            					newCompositeNode(grammarAccess.getURIAccess().getFragmentsFRAGMENTParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_22);
            lv_fragments_3_0=ruleFRAGMENT();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getURIRule());
            					}
            					add(
            						current,
            						"fragments",
            						lv_fragments_3_0,
            						"fr.inria.diverse.dmgen.DMGen.FRAGMENT");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDMGen.g:836:3: (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDMGen.g:837:4: otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getURIAccess().getSolidusKeyword_3_0());
            	    			
            	    // InternalDMGen.g:841:4: ( (lv_fragments_5_0= ruleFRAGMENT ) )
            	    // InternalDMGen.g:842:5: (lv_fragments_5_0= ruleFRAGMENT )
            	    {
            	    // InternalDMGen.g:842:5: (lv_fragments_5_0= ruleFRAGMENT )
            	    // InternalDMGen.g:843:6: lv_fragments_5_0= ruleFRAGMENT
            	    {

            	    						newCompositeNode(grammarAccess.getURIAccess().getFragmentsFRAGMENTParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_fragments_5_0=ruleFRAGMENT();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getURIRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fragments",
            	    							lv_fragments_5_0,
            	    							"fr.inria.diverse.dmgen.DMGen.FRAGMENT");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end "ruleURI"


    // $ANTLR start "entryRuleFRAGMENT"
    // InternalDMGen.g:865:1: entryRuleFRAGMENT returns [String current=null] : iv_ruleFRAGMENT= ruleFRAGMENT EOF ;
    public final String entryRuleFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFRAGMENT = null;


        try {
            // InternalDMGen.g:865:48: (iv_ruleFRAGMENT= ruleFRAGMENT EOF )
            // InternalDMGen.g:866:2: iv_ruleFRAGMENT= ruleFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getFRAGMENTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFRAGMENT=ruleFRAGMENT();

            state._fsp--;

             current =iv_ruleFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFRAGMENT"


    // $ANTLR start "ruleFRAGMENT"
    // InternalDMGen.g:872:1: ruleFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;
        Token this_INT_5=null;


        	enterRule();

        try {
            // InternalDMGen.g:878:2: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? ) )
            // InternalDMGen.g:879:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? )
            {
            // InternalDMGen.g:879:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? )
            // InternalDMGen.g:880:3: this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_0());
            		
            // InternalDMGen.g:887:3: ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==17||LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDMGen.g:888:4: (kw= '.' | kw= '-' ) this_ID_3= RULE_ID
            	    {
            	    // InternalDMGen.g:888:4: (kw= '.' | kw= '-' )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==17) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==26) ) {
            	        alt12=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalDMGen.g:889:5: kw= '.'
            	            {
            	            kw=(Token)match(input,17,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getFullStopKeyword_1_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalDMGen.g:895:5: kw= '-'
            	            {
            	            kw=(Token)match(input,26,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getHyphenMinusKeyword_1_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_23); 

            	    				current.merge(this_ID_3);
            	    			

            	    				newLeafNode(this_ID_3, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalDMGen.g:909:3: (kw= ':' this_INT_5= RULE_INT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDMGen.g:910:4: kw= ':' this_INT_5= RULE_INT
                    {
                    kw=(Token)match(input,27,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getColonKeyword_2_0());
                    			
                    this_INT_5=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_5);
                    			

                    				newLeafNode(this_INT_5, grammarAccess.getFRAGMENTAccess().getINTTerminalRuleCall_2_1());
                    			

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
    // $ANTLR end "ruleFRAGMENT"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\uffff\1\6\5\uffff\2\6\1\uffff";
    static final String dfa_3s = "\1\6\1\15\2\6\1\4\1\6\1\uffff\2\15\1\uffff";
    static final String dfa_4s = "\1\6\1\33\2\6\1\4\1\6\1\uffff\1\33\1\31\1\uffff";
    static final String dfa_5s = "\6\uffff\1\2\2\uffff\1\1";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\6\3\uffff\1\2\7\uffff\1\5\1\3\1\4",
            "\1\7",
            "\1\7",
            "\1\10",
            "\1\11",
            "",
            "\1\6\3\uffff\1\2\7\uffff\1\5\1\3\1\4",
            "\1\6\13\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "792:3: ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000700000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000802040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001400002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000000C020002L});

}
