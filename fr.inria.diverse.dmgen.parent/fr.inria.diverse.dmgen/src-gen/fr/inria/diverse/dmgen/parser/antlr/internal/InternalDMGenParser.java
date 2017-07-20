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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_SCHEME", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'fs-master'", "'deploy-mode'", "'cluster'", "'local'", "'['", "']'", "'hbase-master'", "'*'", "'.'", "'_'", "'generate'", "'with'", "'size'", "'prefix'", "'{'", "'density'", "';'", "'deviation'", "'}'", "'depth'", "'..'", "'variation'", "'/'", "'-'", "':'"
    };
    public static final int RULE_SCHEME=7;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
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
    // InternalDMGen.g:71:1: ruleGenConfig returns [EObject current=null] : (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) ) ( (lv_generators_14_0= ruleGenerator ) ) ( (lv_generators_15_0= ruleGenerator ) )* ) ;
    public final EObject ruleGenConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_deployMode_8_1=null;
        Token lv_deployMode_8_2=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_metamodel_1_0 = null;

        AntlrDatatypeRuleToken lv_package_4_0 = null;

        EObject lv_hdfsMaster_6_0 = null;

        AntlrDatatypeRuleToken lv_numberOfNodes_10_0 = null;

        EObject lv_hbaseMaster_13_0 = null;

        EObject lv_generators_14_0 = null;

        EObject lv_generators_15_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:77:2: ( (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) ) ( (lv_generators_14_0= ruleGenerator ) ) ( (lv_generators_15_0= ruleGenerator ) )* ) )
            // InternalDMGen.g:78:2: (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) ) ( (lv_generators_14_0= ruleGenerator ) ) ( (lv_generators_15_0= ruleGenerator ) )* )
            {
            // InternalDMGen.g:78:2: (otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) ) ( (lv_generators_14_0= ruleGenerator ) ) ( (lv_generators_15_0= ruleGenerator ) )* )
            // InternalDMGen.g:79:3: otherlv_0= 'import' ( (lv_metamodel_1_0= ruleMetamodel ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) ) ( (lv_generators_14_0= ruleGenerator ) ) ( (lv_generators_15_0= ruleGenerator ) )*
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

            // InternalDMGen.g:102:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) ) )
            // InternalDMGen.g:103:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) )
            {
            // InternalDMGen.g:103:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* ) )
            // InternalDMGen.g:104:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            				
            // InternalDMGen.g:107:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )* )
            // InternalDMGen.g:108:6: ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )*
            {
            // InternalDMGen.g:108:6: ( ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) ) )*
            loop2:
            do {
                int alt2=5;
                int LA2_0 = input.LA(1);

                if ( LA2_0 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 2) ) {
                    alt2=3;
                }
                else if ( LA2_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 3) ) {
                    alt2=4;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDMGen.g:109:4: ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:109:4: ({...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) ) )
            	    // InternalDMGen.g:110:5: {...}? => ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalDMGen.g:110:106: ( ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) ) )
            	    // InternalDMGen.g:111:6: ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalDMGen.g:114:9: ({...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) ) )
            	    // InternalDMGen.g:114:10: {...}? => (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:114:19: (otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) ) )
            	    // InternalDMGen.g:114:20: otherlv_3= 'package' ( (lv_package_4_0= rulePACKAGE ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_3); 

            	    									newLeafNode(otherlv_3, grammarAccess.getGenConfigAccess().getPackageKeyword_2_0_0());
            	    								
            	    // InternalDMGen.g:118:9: ( (lv_package_4_0= rulePACKAGE ) )
            	    // InternalDMGen.g:119:10: (lv_package_4_0= rulePACKAGE )
            	    {
            	    // InternalDMGen.g:119:10: (lv_package_4_0= rulePACKAGE )
            	    // InternalDMGen.g:120:11: lv_package_4_0= rulePACKAGE
            	    {

            	    											newCompositeNode(grammarAccess.getGenConfigAccess().getPackagePACKAGEParserRuleCall_2_0_1_0());
            	    										
            	    pushFollow(FOLLOW_4);
            	    lv_package_4_0=rulePACKAGE();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    											}
            	    											set(
            	    												current,
            	    												"package",
            	    												lv_package_4_0,
            	    												"fr.inria.diverse.dmgen.DMGen.PACKAGE");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:143:4: ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:143:4: ({...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) ) )
            	    // InternalDMGen.g:144:5: {...}? => ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalDMGen.g:144:106: ( ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) ) )
            	    // InternalDMGen.g:145:6: ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalDMGen.g:148:9: ({...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) ) )
            	    // InternalDMGen.g:148:10: {...}? => (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:148:19: (otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) ) )
            	    // InternalDMGen.g:148:20: otherlv_5= 'fs-master' ( (lv_hdfsMaster_6_0= ruleURI ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_5); 

            	    									newLeafNode(otherlv_5, grammarAccess.getGenConfigAccess().getFsMasterKeyword_2_1_0());
            	    								
            	    // InternalDMGen.g:152:9: ( (lv_hdfsMaster_6_0= ruleURI ) )
            	    // InternalDMGen.g:153:10: (lv_hdfsMaster_6_0= ruleURI )
            	    {
            	    // InternalDMGen.g:153:10: (lv_hdfsMaster_6_0= ruleURI )
            	    // InternalDMGen.g:154:11: lv_hdfsMaster_6_0= ruleURI
            	    {

            	    											newCompositeNode(grammarAccess.getGenConfigAccess().getHdfsMasterURIParserRuleCall_2_1_1_0());
            	    										
            	    pushFollow(FOLLOW_4);
            	    lv_hdfsMaster_6_0=ruleURI();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    											}
            	    											set(
            	    												current,
            	    												"hdfsMaster",
            	    												lv_hdfsMaster_6_0,
            	    												"fr.inria.diverse.dmgen.DMGen.URI");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalDMGen.g:177:4: ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) )
            	    {
            	    // InternalDMGen.g:177:4: ({...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) ) )
            	    // InternalDMGen.g:178:5: {...}? => ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalDMGen.g:178:106: ( ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) ) )
            	    // InternalDMGen.g:179:6: ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalDMGen.g:182:9: ({...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' ) )
            	    // InternalDMGen.g:182:10: {...}? => (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:182:19: (otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']' )
            	    // InternalDMGen.g:182:20: otherlv_7= 'deploy-mode' ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) ) otherlv_9= '[' ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) ) otherlv_11= ']'
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_6); 

            	    									newLeafNode(otherlv_7, grammarAccess.getGenConfigAccess().getDeployModeKeyword_2_2_0());
            	    								
            	    // InternalDMGen.g:186:9: ( ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) ) )
            	    // InternalDMGen.g:187:10: ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) )
            	    {
            	    // InternalDMGen.g:187:10: ( (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' ) )
            	    // InternalDMGen.g:188:11: (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' )
            	    {
            	    // InternalDMGen.g:188:11: (lv_deployMode_8_1= 'cluster' | lv_deployMode_8_2= 'local' )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==16) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==17) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalDMGen.g:189:12: lv_deployMode_8_1= 'cluster'
            	            {
            	            lv_deployMode_8_1=(Token)match(input,16,FOLLOW_7); 

            	            												newLeafNode(lv_deployMode_8_1, grammarAccess.getGenConfigAccess().getDeployModeClusterKeyword_2_2_1_0_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getGenConfigRule());
            	            												}
            	            												setWithLastConsumed(current, "deployMode", lv_deployMode_8_1, null);
            	            											

            	            }
            	            break;
            	        case 2 :
            	            // InternalDMGen.g:200:12: lv_deployMode_8_2= 'local'
            	            {
            	            lv_deployMode_8_2=(Token)match(input,17,FOLLOW_7); 

            	            												newLeafNode(lv_deployMode_8_2, grammarAccess.getGenConfigAccess().getDeployModeLocalKeyword_2_2_1_0_1());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getGenConfigRule());
            	            												}
            	            												setWithLastConsumed(current, "deployMode", lv_deployMode_8_2, null);
            	            											

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    otherlv_9=(Token)match(input,18,FOLLOW_8); 

            	    									newLeafNode(otherlv_9, grammarAccess.getGenConfigAccess().getLeftSquareBracketKeyword_2_2_2());
            	    								
            	    // InternalDMGen.g:217:9: ( (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED ) )
            	    // InternalDMGen.g:218:10: (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED )
            	    {
            	    // InternalDMGen.g:218:10: (lv_numberOfNodes_10_0= ruleINTorUNBOUNDED )
            	    // InternalDMGen.g:219:11: lv_numberOfNodes_10_0= ruleINTorUNBOUNDED
            	    {

            	    											newCompositeNode(grammarAccess.getGenConfigAccess().getNumberOfNodesINTorUNBOUNDEDParserRuleCall_2_2_3_0());
            	    										
            	    pushFollow(FOLLOW_9);
            	    lv_numberOfNodes_10_0=ruleINTorUNBOUNDED();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    											}
            	    											set(
            	    												current,
            	    												"numberOfNodes",
            	    												lv_numberOfNodes_10_0,
            	    												"fr.inria.diverse.dmgen.DMGen.INTorUNBOUNDED");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_11=(Token)match(input,19,FOLLOW_4); 

            	    									newLeafNode(otherlv_11, grammarAccess.getGenConfigAccess().getRightSquareBracketKeyword_2_2_4());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalDMGen.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) ) )
            	    // InternalDMGen.g:247:5: {...}? => ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalDMGen.g:247:106: ( ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) ) )
            	    // InternalDMGen.g:248:6: ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGenConfigAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalDMGen.g:251:9: ({...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) ) )
            	    // InternalDMGen.g:251:10: {...}? => (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenConfig", "true");
            	    }
            	    // InternalDMGen.g:251:19: (otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) ) )
            	    // InternalDMGen.g:251:20: otherlv_12= 'hbase-master' ( (lv_hbaseMaster_13_0= ruleURI ) )
            	    {
            	    otherlv_12=(Token)match(input,20,FOLLOW_5); 

            	    									newLeafNode(otherlv_12, grammarAccess.getGenConfigAccess().getHbaseMasterKeyword_2_3_0());
            	    								
            	    // InternalDMGen.g:255:9: ( (lv_hbaseMaster_13_0= ruleURI ) )
            	    // InternalDMGen.g:256:10: (lv_hbaseMaster_13_0= ruleURI )
            	    {
            	    // InternalDMGen.g:256:10: (lv_hbaseMaster_13_0= ruleURI )
            	    // InternalDMGen.g:257:11: lv_hbaseMaster_13_0= ruleURI
            	    {

            	    											newCompositeNode(grammarAccess.getGenConfigAccess().getHbaseMasterURIParserRuleCall_2_3_1_0());
            	    										
            	    pushFollow(FOLLOW_4);
            	    lv_hbaseMaster_13_0=ruleURI();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    											}
            	    											set(
            	    												current,
            	    												"hbaseMaster",
            	    												lv_hbaseMaster_13_0,
            	    												"fr.inria.diverse.dmgen.DMGen.URI");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGenConfigAccess().getUnorderedGroup_2());
            				

            }

            // InternalDMGen.g:287:3: ( (lv_generators_14_0= ruleGenerator ) )
            // InternalDMGen.g:288:4: (lv_generators_14_0= ruleGenerator )
            {
            // InternalDMGen.g:288:4: (lv_generators_14_0= ruleGenerator )
            // InternalDMGen.g:289:5: lv_generators_14_0= ruleGenerator
            {

            					newCompositeNode(grammarAccess.getGenConfigAccess().getGeneratorsGeneratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_generators_14_0=ruleGenerator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenConfigRule());
            					}
            					add(
            						current,
            						"generators",
            						lv_generators_14_0,
            						"fr.inria.diverse.dmgen.DMGen.Generator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDMGen.g:306:3: ( (lv_generators_15_0= ruleGenerator ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDMGen.g:307:4: (lv_generators_15_0= ruleGenerator )
            	    {
            	    // InternalDMGen.g:307:4: (lv_generators_15_0= ruleGenerator )
            	    // InternalDMGen.g:308:5: lv_generators_15_0= ruleGenerator
            	    {

            	    					newCompositeNode(grammarAccess.getGenConfigAccess().getGeneratorsGeneratorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_generators_15_0=ruleGenerator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenConfigRule());
            	    					}
            	    					add(
            	    						current,
            	    						"generators",
            	    						lv_generators_15_0,
            	    						"fr.inria.diverse.dmgen.DMGen.Generator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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


    // $ANTLR start "entryRuleINTorUNBOUNDED"
    // InternalDMGen.g:329:1: entryRuleINTorUNBOUNDED returns [String current=null] : iv_ruleINTorUNBOUNDED= ruleINTorUNBOUNDED EOF ;
    public final String entryRuleINTorUNBOUNDED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTorUNBOUNDED = null;


        try {
            // InternalDMGen.g:329:54: (iv_ruleINTorUNBOUNDED= ruleINTorUNBOUNDED EOF )
            // InternalDMGen.g:330:2: iv_ruleINTorUNBOUNDED= ruleINTorUNBOUNDED EOF
            {
             newCompositeNode(grammarAccess.getINTorUNBOUNDEDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleINTorUNBOUNDED=ruleINTorUNBOUNDED();

            state._fsp--;

             current =iv_ruleINTorUNBOUNDED.getText(); 
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
    // $ANTLR end "entryRuleINTorUNBOUNDED"


    // $ANTLR start "ruleINTorUNBOUNDED"
    // InternalDMGen.g:336:1: ruleINTorUNBOUNDED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleINTorUNBOUNDED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalDMGen.g:342:2: ( (kw= '*' | this_INT_1= RULE_INT ) )
            // InternalDMGen.g:343:2: (kw= '*' | this_INT_1= RULE_INT )
            {
            // InternalDMGen.g:343:2: (kw= '*' | this_INT_1= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalDMGen.g:344:3: kw= '*'
                    {
                    kw=(Token)match(input,21,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getINTorUNBOUNDEDAccess().getAsteriskKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDMGen.g:350:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getINTorUNBOUNDEDAccess().getINTTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleINTorUNBOUNDED"


    // $ANTLR start "entryRulePACKAGE"
    // InternalDMGen.g:361:1: entryRulePACKAGE returns [String current=null] : iv_rulePACKAGE= rulePACKAGE EOF ;
    public final String entryRulePACKAGE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePACKAGE = null;


        try {
            // InternalDMGen.g:361:47: (iv_rulePACKAGE= rulePACKAGE EOF )
            // InternalDMGen.g:362:2: iv_rulePACKAGE= rulePACKAGE EOF
            {
             newCompositeNode(grammarAccess.getPACKAGERule()); 
            pushFollow(FOLLOW_1);
            iv_rulePACKAGE=rulePACKAGE();

            state._fsp--;

             current =iv_rulePACKAGE.getText(); 
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
    // $ANTLR end "entryRulePACKAGE"


    // $ANTLR start "rulePACKAGE"
    // InternalDMGen.g:368:1: rulePACKAGE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken rulePACKAGE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalDMGen.g:374:2: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )* ) )
            // InternalDMGen.g:375:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )* )
            {
            // InternalDMGen.g:375:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )* )
            // InternalDMGen.g:376:3: this_ID_0= RULE_ID ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getPACKAGEAccess().getIDTerminalRuleCall_0());
            		
            // InternalDMGen.g:383:3: ( (kw= '.' | kw= '_' ) this_ID_3= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=22 && LA6_0<=23)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDMGen.g:384:4: (kw= '.' | kw= '_' ) this_ID_3= RULE_ID
            	    {
            	    // InternalDMGen.g:384:4: (kw= '.' | kw= '_' )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==22) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==23) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalDMGen.g:385:5: kw= '.'
            	            {
            	            kw=(Token)match(input,22,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getPACKAGEAccess().getFullStopKeyword_1_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalDMGen.g:391:5: kw= '_'
            	            {
            	            kw=(Token)match(input,23,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getPACKAGEAccess().get_Keyword_1_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    				current.merge(this_ID_3);
            	    			

            	    				newLeafNode(this_ID_3, grammarAccess.getPACKAGEAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "rulePACKAGE"


    // $ANTLR start "entryRuleDECIMAL"
    // InternalDMGen.g:409:1: entryRuleDECIMAL returns [String current=null] : iv_ruleDECIMAL= ruleDECIMAL EOF ;
    public final String entryRuleDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECIMAL = null;


        try {
            // InternalDMGen.g:409:47: (iv_ruleDECIMAL= ruleDECIMAL EOF )
            // InternalDMGen.g:410:2: iv_ruleDECIMAL= ruleDECIMAL EOF
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
    // InternalDMGen.g:416:1: ruleDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalDMGen.g:422:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalDMGen.g:423:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalDMGen.g:423:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalDMGen.g:424:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,22,FOLLOW_13); 

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
    // InternalDMGen.g:447:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalDMGen.g:447:50: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalDMGen.g:448:2: iv_ruleGenerator= ruleGenerator EOF
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
    // InternalDMGen.g:454:1: ruleGenerator returns [EObject current=null] : ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) ( (lv_classes_16_0= ruleClazz ) )? (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )* otherlv_19= '}' ) ;
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
        Token lv_globalDensity_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_globalDeviation_14_0 = null;

        EObject lv_classes_16_0 = null;

        EObject lv_classes_18_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:460:2: ( ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) ( (lv_classes_16_0= ruleClazz ) )? (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )* otherlv_19= '}' ) )
            // InternalDMGen.g:461:2: ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) ( (lv_classes_16_0= ruleClazz ) )? (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )* otherlv_19= '}' )
            {
            // InternalDMGen.g:461:2: ( ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) ( (lv_classes_16_0= ruleClazz ) )? (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )* otherlv_19= '}' )
            // InternalDMGen.g:462:3: ( (lv_name_0_0= 'generate' ) ) ( (lv_number_1_0= RULE_INT ) ) otherlv_2= 'with' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_8= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) ( (lv_classes_16_0= ruleClazz ) )? (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )* otherlv_19= '}'
            {
            // InternalDMGen.g:462:3: ( (lv_name_0_0= 'generate' ) )
            // InternalDMGen.g:463:4: (lv_name_0_0= 'generate' )
            {
            // InternalDMGen.g:463:4: (lv_name_0_0= 'generate' )
            // InternalDMGen.g:464:5: lv_name_0_0= 'generate'
            {
            lv_name_0_0=(Token)match(input,24,FOLLOW_13); 

            					newLeafNode(lv_name_0_0, grammarAccess.getGeneratorAccess().getNameGenerateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratorRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "generate");
            				

            }


            }

            // InternalDMGen.g:476:3: ( (lv_number_1_0= RULE_INT ) )
            // InternalDMGen.g:477:4: (lv_number_1_0= RULE_INT )
            {
            // InternalDMGen.g:477:4: (lv_number_1_0= RULE_INT )
            // InternalDMGen.g:478:5: lv_number_1_0= RULE_INT
            {
            lv_number_1_0=(Token)match(input,RULE_INT,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneratorAccess().getWithKeyword_2());
            		
            // InternalDMGen.g:498:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) )
            // InternalDMGen.g:499:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalDMGen.g:499:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            // InternalDMGen.g:500:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            				
            // InternalDMGen.g:503:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            // InternalDMGen.g:504:6: ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+ {...}?
            {
            // InternalDMGen.g:504:6: ( ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( LA7_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDMGen.g:505:4: ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:505:4: ({...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalDMGen.g:506:5: {...}? => ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalDMGen.g:506:106: ( ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) ) )
            	    // InternalDMGen.g:507:6: ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalDMGen.g:510:9: ({...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) ) )
            	    // InternalDMGen.g:510:10: {...}? => (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:510:19: (otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) ) )
            	    // InternalDMGen.g:510:20: otherlv_4= 'size' ( (lv_size_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_13); 

            	    									newLeafNode(otherlv_4, grammarAccess.getGeneratorAccess().getSizeKeyword_3_0_0());
            	    								
            	    // InternalDMGen.g:514:9: ( (lv_size_5_0= RULE_INT ) )
            	    // InternalDMGen.g:515:10: (lv_size_5_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:515:10: (lv_size_5_0= RULE_INT )
            	    // InternalDMGen.g:516:11: lv_size_5_0= RULE_INT
            	    {
            	    lv_size_5_0=(Token)match(input,RULE_INT,FOLLOW_16); 

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
            	    // InternalDMGen.g:538:4: ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:538:4: ({...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalDMGen.g:539:5: {...}? => ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalDMGen.g:539:106: ( ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) ) )
            	    // InternalDMGen.g:540:6: ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalDMGen.g:543:9: ({...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) ) )
            	    // InternalDMGen.g:543:10: {...}? => (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:543:19: (otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) ) )
            	    // InternalDMGen.g:543:20: otherlv_6= 'prefix' ( (lv_prefix_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,27,FOLLOW_17); 

            	    									newLeafNode(otherlv_6, grammarAccess.getGeneratorAccess().getPrefixKeyword_3_1_0());
            	    								
            	    // InternalDMGen.g:547:9: ( (lv_prefix_7_0= RULE_STRING ) )
            	    // InternalDMGen.g:548:10: (lv_prefix_7_0= RULE_STRING )
            	    {
            	    // InternalDMGen.g:548:10: (lv_prefix_7_0= RULE_STRING )
            	    // InternalDMGen.g:549:11: lv_prefix_7_0= RULE_STRING
            	    {
            	    lv_prefix_7_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canLeave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGeneratorAccess().getUnorderedGroup_3());
            				

            }

            otherlv_8=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_8, grammarAccess.getGeneratorAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDMGen.g:583:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) ) )
            // InternalDMGen.g:584:4: ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) )
            {
            // InternalDMGen.g:584:4: ( ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* ) )
            // InternalDMGen.g:585:5: ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGeneratorAccess().getUnorderedGroup_5());
            				
            // InternalDMGen.g:588:5: ( ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )* )
            // InternalDMGen.g:589:6: ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )*
            {
            // InternalDMGen.g:589:6: ( ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDMGen.g:590:4: ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // InternalDMGen.g:590:4: ({...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) ) )
            	    // InternalDMGen.g:591:5: {...}? => ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalDMGen.g:591:106: ( ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) ) )
            	    // InternalDMGen.g:592:6: ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 0);
            	    					
            	    // InternalDMGen.g:595:9: ({...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' ) )
            	    // InternalDMGen.g:595:10: {...}? => (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:595:19: (otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';' )
            	    // InternalDMGen.g:595:20: otherlv_10= 'density' ( (lv_globalDensity_11_0= RULE_INT ) ) otherlv_12= ';'
            	    {
            	    otherlv_10=(Token)match(input,29,FOLLOW_13); 

            	    									newLeafNode(otherlv_10, grammarAccess.getGeneratorAccess().getDensityKeyword_5_0_0());
            	    								
            	    // InternalDMGen.g:599:9: ( (lv_globalDensity_11_0= RULE_INT ) )
            	    // InternalDMGen.g:600:10: (lv_globalDensity_11_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:600:10: (lv_globalDensity_11_0= RULE_INT )
            	    // InternalDMGen.g:601:11: lv_globalDensity_11_0= RULE_INT
            	    {
            	    lv_globalDensity_11_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            	    											newLeafNode(lv_globalDensity_11_0, grammarAccess.getGeneratorAccess().getGlobalDensityINTTerminalRuleCall_5_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getGeneratorRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"globalDensity",
            	    												lv_globalDensity_11_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }

            	    otherlv_12=(Token)match(input,30,FOLLOW_18); 

            	    									newLeafNode(otherlv_12, grammarAccess.getGeneratorAccess().getSemicolonKeyword_5_0_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGeneratorAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:627:4: ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // InternalDMGen.g:627:4: ({...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) ) )
            	    // InternalDMGen.g:628:5: {...}? => ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "getUnorderedGroupHelper().canSelect(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalDMGen.g:628:106: ( ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) ) )
            	    // InternalDMGen.g:629:6: ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGeneratorAccess().getUnorderedGroup_5(), 1);
            	    					
            	    // InternalDMGen.g:632:9: ({...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' ) )
            	    // InternalDMGen.g:632:10: {...}? => (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGenerator", "true");
            	    }
            	    // InternalDMGen.g:632:19: (otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';' )
            	    // InternalDMGen.g:632:20: otherlv_13= 'deviation' ( (lv_globalDeviation_14_0= ruleDECIMAL ) ) otherlv_15= ';'
            	    {
            	    otherlv_13=(Token)match(input,31,FOLLOW_13); 

            	    									newLeafNode(otherlv_13, grammarAccess.getGeneratorAccess().getDeviationKeyword_5_1_0());
            	    								
            	    // InternalDMGen.g:636:9: ( (lv_globalDeviation_14_0= ruleDECIMAL ) )
            	    // InternalDMGen.g:637:10: (lv_globalDeviation_14_0= ruleDECIMAL )
            	    {
            	    // InternalDMGen.g:637:10: (lv_globalDeviation_14_0= ruleDECIMAL )
            	    // InternalDMGen.g:638:11: lv_globalDeviation_14_0= ruleDECIMAL
            	    {

            	    											newCompositeNode(grammarAccess.getGeneratorAccess().getGlobalDeviationDECIMALParserRuleCall_5_1_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
            	    lv_globalDeviation_14_0=ruleDECIMAL();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getGeneratorRule());
            	    											}
            	    											set(
            	    												current,
            	    												"globalDeviation",
            	    												lv_globalDeviation_14_0,
            	    												"fr.inria.diverse.dmgen.DMGen.DECIMAL");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_15=(Token)match(input,30,FOLLOW_18); 

            	    									newLeafNode(otherlv_15, grammarAccess.getGeneratorAccess().getSemicolonKeyword_5_1_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGeneratorAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGeneratorAccess().getUnorderedGroup_5());
            				

            }

            // InternalDMGen.g:672:3: ( (lv_classes_16_0= ruleClazz ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDMGen.g:673:4: (lv_classes_16_0= ruleClazz )
                    {
                    // InternalDMGen.g:673:4: (lv_classes_16_0= ruleClazz )
                    // InternalDMGen.g:674:5: lv_classes_16_0= ruleClazz
                    {

                    					newCompositeNode(grammarAccess.getGeneratorAccess().getClassesClazzParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_20);
                    lv_classes_16_0=ruleClazz();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGeneratorRule());
                    					}
                    					add(
                    						current,
                    						"classes",
                    						lv_classes_16_0,
                    						"fr.inria.diverse.dmgen.DMGen.Clazz");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDMGen.g:691:3: (otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDMGen.g:692:4: otherlv_17= ';' ( (lv_classes_18_0= ruleClazz ) )
            	    {
            	    otherlv_17=(Token)match(input,30,FOLLOW_3); 

            	    				newLeafNode(otherlv_17, grammarAccess.getGeneratorAccess().getSemicolonKeyword_7_0());
            	    			
            	    // InternalDMGen.g:696:4: ( (lv_classes_18_0= ruleClazz ) )
            	    // InternalDMGen.g:697:5: (lv_classes_18_0= ruleClazz )
            	    {
            	    // InternalDMGen.g:697:5: (lv_classes_18_0= ruleClazz )
            	    // InternalDMGen.g:698:6: lv_classes_18_0= ruleClazz
            	    {

            	    						newCompositeNode(grammarAccess.getGeneratorAccess().getClassesClazzParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_classes_18_0=ruleClazz();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGeneratorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"classes",
            	    							lv_classes_18_0,
            	    							"fr.inria.diverse.dmgen.DMGen.Clazz");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_19=(Token)match(input,32,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getGeneratorAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalDMGen.g:724:1: entryRuleMetamodel returns [EObject current=null] : iv_ruleMetamodel= ruleMetamodel EOF ;
    public final EObject entryRuleMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodel = null;


        try {
            // InternalDMGen.g:724:50: (iv_ruleMetamodel= ruleMetamodel EOF )
            // InternalDMGen.g:725:2: iv_ruleMetamodel= ruleMetamodel EOF
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
    // InternalDMGen.g:731:1: ruleMetamodel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) ) ;
    public final EObject ruleMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_uri_1_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:737:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) ) )
            // InternalDMGen.g:738:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) )
            {
            // InternalDMGen.g:738:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) ) )
            // InternalDMGen.g:739:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI ) )
            {
            // InternalDMGen.g:739:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:740:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:740:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:741:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            // InternalDMGen.g:757:3: ( (lv_uri_1_0= ruleURI ) )
            // InternalDMGen.g:758:4: (lv_uri_1_0= ruleURI )
            {
            // InternalDMGen.g:758:4: (lv_uri_1_0= ruleURI )
            // InternalDMGen.g:759:5: lv_uri_1_0= ruleURI
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
    // InternalDMGen.g:780:1: entryRuleClazz returns [EObject current=null] : iv_ruleClazz= ruleClazz EOF ;
    public final EObject entryRuleClazz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClazz = null;


        try {
            // InternalDMGen.g:780:46: (iv_ruleClazz= ruleClazz EOF )
            // InternalDMGen.g:781:2: iv_ruleClazz= ruleClazz EOF
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
    // InternalDMGen.g:787:1: ruleClazz returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )? (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )? ) ;
    public final EObject ruleClazz() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_depth_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_range_1_0 = null;

        EObject lv_properties_5_0 = null;

        EObject lv_properties_7_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:793:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )? (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )? ) )
            // InternalDMGen.g:794:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )? (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )? )
            {
            // InternalDMGen.g:794:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )? (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )? )
            // InternalDMGen.g:795:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )? (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )?
            {
            // InternalDMGen.g:795:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:796:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:796:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:797:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

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

            // InternalDMGen.g:813:3: ( (lv_range_1_0= ruleRange ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDMGen.g:814:4: (lv_range_1_0= ruleRange )
                    {
                    // InternalDMGen.g:814:4: (lv_range_1_0= ruleRange )
                    // InternalDMGen.g:815:5: lv_range_1_0= ruleRange
                    {

                    					newCompositeNode(grammarAccess.getClazzAccess().getRangeRangeParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_22);
                    lv_range_1_0=ruleRange();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClazzRule());
                    					}
                    					set(
                    						current,
                    						"range",
                    						lv_range_1_0,
                    						"fr.inria.diverse.dmgen.DMGen.Range");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDMGen.g:832:3: (otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDMGen.g:833:4: otherlv_2= 'depth' ( (lv_depth_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getClazzAccess().getDepthKeyword_2_0());
                    			
                    // InternalDMGen.g:837:4: ( (lv_depth_3_0= RULE_INT ) )
                    // InternalDMGen.g:838:5: (lv_depth_3_0= RULE_INT )
                    {
                    // InternalDMGen.g:838:5: (lv_depth_3_0= RULE_INT )
                    // InternalDMGen.g:839:6: lv_depth_3_0= RULE_INT
                    {
                    lv_depth_3_0=(Token)match(input,RULE_INT,FOLLOW_23); 

                    						newLeafNode(lv_depth_3_0, grammarAccess.getClazzAccess().getDepthINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClazzRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"depth",
                    							lv_depth_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalDMGen.g:856:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDMGen.g:857:4: otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) ) (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )* otherlv_8= '}'
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getClazzAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalDMGen.g:861:4: ( (lv_properties_5_0= ruleProperty ) )
                    // InternalDMGen.g:862:5: (lv_properties_5_0= ruleProperty )
                    {
                    // InternalDMGen.g:862:5: (lv_properties_5_0= ruleProperty )
                    // InternalDMGen.g:863:6: lv_properties_5_0= ruleProperty
                    {

                    						newCompositeNode(grammarAccess.getClazzAccess().getPropertiesPropertyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_properties_5_0=ruleProperty();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClazzRule());
                    						}
                    						add(
                    							current,
                    							"properties",
                    							lv_properties_5_0,
                    							"fr.inria.diverse.dmgen.DMGen.Property");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDMGen.g:880:4: (otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==30) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalDMGen.g:881:5: otherlv_6= ';' ( (lv_properties_7_0= ruleProperty ) )
                    	    {
                    	    otherlv_6=(Token)match(input,30,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getClazzAccess().getSemicolonKeyword_3_2_0());
                    	    				
                    	    // InternalDMGen.g:885:5: ( (lv_properties_7_0= ruleProperty ) )
                    	    // InternalDMGen.g:886:6: (lv_properties_7_0= ruleProperty )
                    	    {
                    	    // InternalDMGen.g:886:6: (lv_properties_7_0= ruleProperty )
                    	    // InternalDMGen.g:887:7: lv_properties_7_0= ruleProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getClazzAccess().getPropertiesPropertyParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_properties_7_0=ruleProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClazzRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_7_0,
                    	    								"fr.inria.diverse.dmgen.DMGen.Property");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getClazzAccess().getRightCurlyBracketKeyword_3_3());
                    			

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


    // $ANTLR start "entryRuleRange"
    // InternalDMGen.g:914:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalDMGen.g:914:46: (iv_ruleRange= ruleRange EOF )
            // InternalDMGen.g:915:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalDMGen.g:921:1: ruleRange returns [EObject current=null] : (otherlv_0= '[' ( (lv_lower_1_0= RULE_INT ) ) otherlv_2= '..' ( (lv_upper_3_0= RULE_INT ) ) otherlv_4= ']' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lower_1_0=null;
        Token otherlv_2=null;
        Token lv_upper_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalDMGen.g:927:2: ( (otherlv_0= '[' ( (lv_lower_1_0= RULE_INT ) ) otherlv_2= '..' ( (lv_upper_3_0= RULE_INT ) ) otherlv_4= ']' ) )
            // InternalDMGen.g:928:2: (otherlv_0= '[' ( (lv_lower_1_0= RULE_INT ) ) otherlv_2= '..' ( (lv_upper_3_0= RULE_INT ) ) otherlv_4= ']' )
            {
            // InternalDMGen.g:928:2: (otherlv_0= '[' ( (lv_lower_1_0= RULE_INT ) ) otherlv_2= '..' ( (lv_upper_3_0= RULE_INT ) ) otherlv_4= ']' )
            // InternalDMGen.g:929:3: otherlv_0= '[' ( (lv_lower_1_0= RULE_INT ) ) otherlv_2= '..' ( (lv_upper_3_0= RULE_INT ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalDMGen.g:933:3: ( (lv_lower_1_0= RULE_INT ) )
            // InternalDMGen.g:934:4: (lv_lower_1_0= RULE_INT )
            {
            // InternalDMGen.g:934:4: (lv_lower_1_0= RULE_INT )
            // InternalDMGen.g:935:5: lv_lower_1_0= RULE_INT
            {
            lv_lower_1_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            					newLeafNode(lv_lower_1_0, grammarAccess.getRangeAccess().getLowerINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"lower",
            						lv_lower_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,34,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2());
            		
            // InternalDMGen.g:955:3: ( (lv_upper_3_0= RULE_INT ) )
            // InternalDMGen.g:956:4: (lv_upper_3_0= RULE_INT )
            {
            // InternalDMGen.g:956:4: (lv_upper_3_0= RULE_INT )
            // InternalDMGen.g:957:5: lv_upper_3_0= RULE_INT
            {
            lv_upper_3_0=(Token)match(input,RULE_INT,FOLLOW_9); 

            					newLeafNode(lv_upper_3_0, grammarAccess.getRangeAccess().getUpperINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"upper",
            						lv_upper_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRangeAccess().getRightSquareBracketKeyword_4());
            		

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
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleProperty"
    // InternalDMGen.g:981:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalDMGen.g:981:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalDMGen.g:982:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalDMGen.g:988:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Token lv_density_4_0=null;
        Token otherlv_5=null;
        Token lv_variation_6_0=null;
        EObject lv_range_2_0 = null;



        	enterRule();

        try {
            // InternalDMGen.g:994:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalDMGen.g:995:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalDMGen.g:995:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalDMGen.g:996:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            {
            // InternalDMGen.g:996:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDMGen.g:997:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDMGen.g:997:4: (lv_name_0_0= RULE_ID )
            // InternalDMGen.g:998:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); 

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

            // InternalDMGen.g:1014:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            // InternalDMGen.g:1015:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalDMGen.g:1015:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            // InternalDMGen.g:1016:5: ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            				
            // InternalDMGen.g:1019:5: ( ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            // InternalDMGen.g:1020:6: ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+ {...}?
            {
            // InternalDMGen.g:1020:6: ( ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( LA16_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0) ) {
                    alt16=1;
                }
                else if ( LA16_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDMGen.g:1021:4: ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) )
            	    {
            	    // InternalDMGen.g:1021:4: ({...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) ) )
            	    // InternalDMGen.g:1022:5: {...}? => ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalDMGen.g:1022:105: ( ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) ) )
            	    // InternalDMGen.g:1023:6: ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalDMGen.g:1026:9: ({...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? ) )
            	    // InternalDMGen.g:1026:10: {...}? => ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalDMGen.g:1026:19: ( ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )? )
            	    // InternalDMGen.g:1026:20: ( (lv_range_2_0= ruleRange ) ) (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )?
            	    {
            	    // InternalDMGen.g:1026:20: ( (lv_range_2_0= ruleRange ) )
            	    // InternalDMGen.g:1027:10: (lv_range_2_0= ruleRange )
            	    {
            	    // InternalDMGen.g:1027:10: (lv_range_2_0= ruleRange )
            	    // InternalDMGen.g:1028:11: lv_range_2_0= ruleRange
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getRangeRangeParserRuleCall_1_0_0_0());
            	    										
            	    pushFollow(FOLLOW_26);
            	    lv_range_2_0=ruleRange();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPropertyRule());
            	    											}
            	    											set(
            	    												current,
            	    												"range",
            	    												lv_range_2_0,
            	    												"fr.inria.diverse.dmgen.DMGen.Range");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalDMGen.g:1045:9: (otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) ) )?
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==29) ) {
            	        alt15=1;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // InternalDMGen.g:1046:10: otherlv_3= 'density' ( (lv_density_4_0= RULE_INT ) )
            	            {
            	            otherlv_3=(Token)match(input,29,FOLLOW_13); 

            	            										newLeafNode(otherlv_3, grammarAccess.getPropertyAccess().getDensityKeyword_1_0_1_0());
            	            									
            	            // InternalDMGen.g:1050:10: ( (lv_density_4_0= RULE_INT ) )
            	            // InternalDMGen.g:1051:11: (lv_density_4_0= RULE_INT )
            	            {
            	            // InternalDMGen.g:1051:11: (lv_density_4_0= RULE_INT )
            	            // InternalDMGen.g:1052:12: lv_density_4_0= RULE_INT
            	            {
            	            lv_density_4_0=(Token)match(input,RULE_INT,FOLLOW_27); 

            	            												newLeafNode(lv_density_4_0, grammarAccess.getPropertyAccess().getDensityINTTerminalRuleCall_1_0_1_1_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getPropertyRule());
            	            												}
            	            												setWithLastConsumed(
            	            													current,
            	            													"density",
            	            													lv_density_4_0,
            	            													"org.eclipse.xtext.common.Terminals.INT");
            	            											

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDMGen.g:1075:4: ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalDMGen.g:1075:4: ({...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) ) )
            	    // InternalDMGen.g:1076:5: {...}? => ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalDMGen.g:1076:105: ( ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) ) )
            	    // InternalDMGen.g:1077:6: ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalDMGen.g:1080:9: ({...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) ) )
            	    // InternalDMGen.g:1080:10: {...}? => (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalDMGen.g:1080:19: (otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) ) )
            	    // InternalDMGen.g:1080:20: otherlv_5= 'variation' ( (lv_variation_6_0= RULE_INT ) )
            	    {
            	    otherlv_5=(Token)match(input,35,FOLLOW_13); 

            	    									newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getVariationKeyword_1_1_0());
            	    								
            	    // InternalDMGen.g:1084:9: ( (lv_variation_6_0= RULE_INT ) )
            	    // InternalDMGen.g:1085:10: (lv_variation_6_0= RULE_INT )
            	    {
            	    // InternalDMGen.g:1085:10: (lv_variation_6_0= RULE_INT )
            	    // InternalDMGen.g:1086:11: lv_variation_6_0= RULE_INT
            	    {
            	    lv_variation_6_0=(Token)match(input,RULE_INT,FOLLOW_27); 

            	    											newLeafNode(lv_variation_6_0, grammarAccess.getPropertyAccess().getVariationINTTerminalRuleCall_1_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPropertyRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"variation",
            	    												lv_variation_6_0,
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPropertyAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canLeave(grammarAccess.getPropertyAccess().getUnorderedGroup_1())");
            }

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
    // InternalDMGen.g:1120:1: entryRuleURI returns [EObject current=null] : iv_ruleURI= ruleURI EOF ;
    public final EObject entryRuleURI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURI = null;


        try {
            // InternalDMGen.g:1120:44: (iv_ruleURI= ruleURI EOF )
            // InternalDMGen.g:1121:2: iv_ruleURI= ruleURI EOF
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
    // InternalDMGen.g:1127:1: ruleURI returns [EObject current=null] : ( ( (lv_scheme_0_0= RULE_SCHEME ) )? ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* ) ;
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
            // InternalDMGen.g:1133:2: ( ( ( (lv_scheme_0_0= RULE_SCHEME ) )? ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* ) )
            // InternalDMGen.g:1134:2: ( ( (lv_scheme_0_0= RULE_SCHEME ) )? ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* )
            {
            // InternalDMGen.g:1134:2: ( ( (lv_scheme_0_0= RULE_SCHEME ) )? ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )* )
            // InternalDMGen.g:1135:3: ( (lv_scheme_0_0= RULE_SCHEME ) )? ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )? ( (lv_fragments_3_0= ruleFRAGMENT ) ) (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )*
            {
            // InternalDMGen.g:1135:3: ( (lv_scheme_0_0= RULE_SCHEME ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_SCHEME) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDMGen.g:1136:4: (lv_scheme_0_0= RULE_SCHEME )
                    {
                    // InternalDMGen.g:1136:4: (lv_scheme_0_0= RULE_SCHEME )
                    // InternalDMGen.g:1137:5: lv_scheme_0_0= RULE_SCHEME
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
                    break;

            }

            // InternalDMGen.g:1153:3: ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalDMGen.g:1154:4: ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/'
                    {
                    // InternalDMGen.g:1154:4: ( (lv_authority_1_0= ruleFRAGMENT ) )
                    // InternalDMGen.g:1155:5: (lv_authority_1_0= ruleFRAGMENT )
                    {
                    // InternalDMGen.g:1155:5: (lv_authority_1_0= ruleFRAGMENT )
                    // InternalDMGen.g:1156:6: lv_authority_1_0= ruleFRAGMENT
                    {

                    						newCompositeNode(grammarAccess.getURIAccess().getAuthorityFRAGMENTParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    otherlv_2=(Token)match(input,36,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getURIAccess().getSolidusKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalDMGen.g:1178:3: ( (lv_fragments_3_0= ruleFRAGMENT ) )
            // InternalDMGen.g:1179:4: (lv_fragments_3_0= ruleFRAGMENT )
            {
            // InternalDMGen.g:1179:4: (lv_fragments_3_0= ruleFRAGMENT )
            // InternalDMGen.g:1180:5: lv_fragments_3_0= ruleFRAGMENT
            {

            					newCompositeNode(grammarAccess.getURIAccess().getFragmentsFRAGMENTParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalDMGen.g:1197:3: (otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==36) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDMGen.g:1198:4: otherlv_4= '/' ( (lv_fragments_5_0= ruleFRAGMENT ) )
            	    {
            	    otherlv_4=(Token)match(input,36,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getURIAccess().getSolidusKeyword_3_0());
            	    			
            	    // InternalDMGen.g:1202:4: ( (lv_fragments_5_0= ruleFRAGMENT ) )
            	    // InternalDMGen.g:1203:5: (lv_fragments_5_0= ruleFRAGMENT )
            	    {
            	    // InternalDMGen.g:1203:5: (lv_fragments_5_0= ruleFRAGMENT )
            	    // InternalDMGen.g:1204:6: lv_fragments_5_0= ruleFRAGMENT
            	    {

            	    						newCompositeNode(grammarAccess.getURIAccess().getFragmentsFRAGMENTParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    break loop19;
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
    // InternalDMGen.g:1226:1: entryRuleFRAGMENT returns [String current=null] : iv_ruleFRAGMENT= ruleFRAGMENT EOF ;
    public final String entryRuleFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFRAGMENT = null;


        try {
            // InternalDMGen.g:1226:48: (iv_ruleFRAGMENT= ruleFRAGMENT EOF )
            // InternalDMGen.g:1227:2: iv_ruleFRAGMENT= ruleFRAGMENT EOF
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
    // InternalDMGen.g:1233:1: ruleFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;
        Token this_INT_5=null;


        	enterRule();

        try {
            // InternalDMGen.g:1239:2: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? ) )
            // InternalDMGen.g:1240:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? )
            {
            // InternalDMGen.g:1240:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )? )
            // InternalDMGen.g:1241:3: this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* (kw= ':' this_INT_5= RULE_INT )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_0());
            		
            // InternalDMGen.g:1248:3: ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22||LA21_0==37) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDMGen.g:1249:4: (kw= '.' | kw= '-' ) this_ID_3= RULE_ID
            	    {
            	    // InternalDMGen.g:1249:4: (kw= '.' | kw= '-' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==22) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==37) ) {
            	        alt20=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalDMGen.g:1250:5: kw= '.'
            	            {
            	            kw=(Token)match(input,22,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getFullStopKeyword_1_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalDMGen.g:1256:5: kw= '-'
            	            {
            	            kw=(Token)match(input,37,FOLLOW_3); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getHyphenMinusKeyword_1_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_30); 

            	    				current.merge(this_ID_3);
            	    			

            	    				newLeafNode(this_ID_3, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalDMGen.g:1270:3: (kw= ':' this_INT_5= RULE_INT )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==38) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDMGen.g:1271:4: kw= ':' this_INT_5= RULE_INT
                    {
                    kw=(Token)match(input,38,FOLLOW_13); 

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


    protected DFA18 dfa18 = new DFA18(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\uffff\1\6\5\uffff\2\6\1\uffff";
    static final String dfa_3s = "\1\5\1\15\2\5\1\4\1\5\1\uffff\2\15\1\uffff";
    static final String dfa_4s = "\1\5\1\46\2\5\1\4\1\5\1\uffff\1\46\1\44\1\uffff";
    static final String dfa_5s = "\6\uffff\1\2\2\uffff\1\1";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\3\6\4\uffff\1\6\1\uffff\1\2\1\uffff\1\6\13\uffff\1\5\1\3\1\4",
            "\1\7",
            "\1\7",
            "\1\10",
            "\1\11",
            "",
            "\3\6\4\uffff\1\6\1\uffff\1\2\1\uffff\1\6\13\uffff\1\5\1\3\1\4",
            "\3\6\4\uffff\1\6\3\uffff\1\6\13\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1153:3: ( ( (lv_authority_1_0= ruleFRAGMENT ) ) otherlv_2= '/' )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000110E000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000110E002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000001E0000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000210040002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000210000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000820040002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800040002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000006000400002L});

}
