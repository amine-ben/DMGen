package fr.inria.diverse.dmgen.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDMGenLexer extends Lexer {
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

    public InternalDMGenLexer() {;} 
    public InternalDMGenLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDMGenLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalDMGen.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:11:7: ( 'import' )
            // InternalDMGen.g:11:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:12:7: ( 'package' )
            // InternalDMGen.g:12:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:13:7: ( 'fs-master' )
            // InternalDMGen.g:13:9: 'fs-master'
            {
            match("fs-master"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:14:7: ( 'deploy-mode' )
            // InternalDMGen.g:14:9: 'deploy-mode'
            {
            match("deploy-mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:15:7: ( 'cluster' )
            // InternalDMGen.g:15:9: 'cluster'
            {
            match("cluster"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:16:7: ( 'local' )
            // InternalDMGen.g:16:9: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:17:7: ( '[' )
            // InternalDMGen.g:17:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:18:7: ( ']' )
            // InternalDMGen.g:18:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:19:7: ( 'hbase-master' )
            // InternalDMGen.g:19:9: 'hbase-master'
            {
            match("hbase-master"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:20:7: ( '*' )
            // InternalDMGen.g:20:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:21:7: ( '.' )
            // InternalDMGen.g:21:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:22:7: ( '_' )
            // InternalDMGen.g:22:9: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:23:7: ( 'generate' )
            // InternalDMGen.g:23:9: 'generate'
            {
            match("generate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:24:7: ( 'with' )
            // InternalDMGen.g:24:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:25:7: ( 'size' )
            // InternalDMGen.g:25:9: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:26:7: ( 'prefix' )
            // InternalDMGen.g:26:9: 'prefix'
            {
            match("prefix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:27:7: ( '{' )
            // InternalDMGen.g:27:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:28:7: ( 'density' )
            // InternalDMGen.g:28:9: 'density'
            {
            match("density"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:29:7: ( ';' )
            // InternalDMGen.g:29:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:30:7: ( 'deviation' )
            // InternalDMGen.g:30:9: 'deviation'
            {
            match("deviation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:31:7: ( '}' )
            // InternalDMGen.g:31:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:32:7: ( 'depth' )
            // InternalDMGen.g:32:9: 'depth'
            {
            match("depth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:33:7: ( '..' )
            // InternalDMGen.g:33:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:34:7: ( 'variation' )
            // InternalDMGen.g:34:9: 'variation'
            {
            match("variation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:35:7: ( '/' )
            // InternalDMGen.g:35:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:36:7: ( '-' )
            // InternalDMGen.g:36:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:37:7: ( ':' )
            // InternalDMGen.g:37:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "RULE_SCHEME"
    public final void mRULE_SCHEME() throws RecognitionException {
        try {
            int _type = RULE_SCHEME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1287:13: ( ( 'http://' | 'file:///' | 'platform:/' | 'neoemfhbase://' | 'hdfs://' ) )
            // InternalDMGen.g:1287:15: ( 'http://' | 'file:///' | 'platform:/' | 'neoemfhbase://' | 'hdfs://' )
            {
            // InternalDMGen.g:1287:15: ( 'http://' | 'file:///' | 'platform:/' | 'neoemfhbase://' | 'hdfs://' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 'h':
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='t') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='d') ) {
                    alt1=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'p':
                {
                alt1=3;
                }
                break;
            case 'n':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalDMGen.g:1287:16: 'http://'
                    {
                    match("http://"); 


                    }
                    break;
                case 2 :
                    // InternalDMGen.g:1287:26: 'file:///'
                    {
                    match("file:///"); 


                    }
                    break;
                case 3 :
                    // InternalDMGen.g:1287:37: 'platform:/'
                    {
                    match("platform:/"); 


                    }
                    break;
                case 4 :
                    // InternalDMGen.g:1287:50: 'neoemfhbase://'
                    {
                    match("neoemfhbase://"); 


                    }
                    break;
                case 5 :
                    // InternalDMGen.g:1287:67: 'hdfs://'
                    {
                    match("hdfs://"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SCHEME"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1289:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDMGen.g:1289:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDMGen.g:1289:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDMGen.g:1289:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalDMGen.g:1289:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDMGen.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1291:10: ( ( '0' .. '9' )+ )
            // InternalDMGen.g:1291:12: ( '0' .. '9' )+
            {
            // InternalDMGen.g:1291:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDMGen.g:1291:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1293:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalDMGen.g:1293:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalDMGen.g:1293:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDMGen.g:1293:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalDMGen.g:1293:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDMGen.g:1293:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDMGen.g:1293:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalDMGen.g:1293:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalDMGen.g:1293:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDMGen.g:1293:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDMGen.g:1293:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1295:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalDMGen.g:1295:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalDMGen.g:1295:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDMGen.g:1295:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1297:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDMGen.g:1297:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDMGen.g:1297:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDMGen.g:1297:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalDMGen.g:1297:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDMGen.g:1297:41: ( '\\r' )? '\\n'
                    {
                    // InternalDMGen.g:1297:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalDMGen.g:1297:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1299:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalDMGen.g:1299:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalDMGen.g:1299:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDMGen.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDMGen.g:1301:16: ( . )
            // InternalDMGen.g:1301:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalDMGen.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_SCHEME | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=35;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalDMGen.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalDMGen.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalDMGen.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalDMGen.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalDMGen.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalDMGen.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalDMGen.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalDMGen.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalDMGen.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalDMGen.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalDMGen.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalDMGen.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalDMGen.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalDMGen.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalDMGen.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalDMGen.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalDMGen.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalDMGen.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalDMGen.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalDMGen.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalDMGen.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalDMGen.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // InternalDMGen.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // InternalDMGen.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // InternalDMGen.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // InternalDMGen.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // InternalDMGen.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // InternalDMGen.g:1:172: RULE_SCHEME
                {
                mRULE_SCHEME(); 

                }
                break;
            case 29 :
                // InternalDMGen.g:1:184: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 30 :
                // InternalDMGen.g:1:192: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 31 :
                // InternalDMGen.g:1:201: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 32 :
                // InternalDMGen.g:1:213: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 33 :
                // InternalDMGen.g:1:229: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 34 :
                // InternalDMGen.g:1:245: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 35 :
                // InternalDMGen.g:1:253: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\6\40\2\uffff\1\40\1\uffff\1\60\1\61\3\40\3\uffff\1\40\1\73\2\uffff\1\40\1\36\2\uffff\2\36\2\uffff\1\40\1\uffff\10\40\2\uffff\3\40\4\uffff\3\40\3\uffff\1\40\5\uffff\1\40\3\uffff\4\40\1\uffff\35\40\1\165\1\166\6\40\1\uffff\1\40\1\176\3\40\1\u0082\2\40\2\uffff\2\40\1\u0087\1\40\1\u0089\2\40\1\uffff\3\40\2\uffff\3\40\1\uffff\1\u0092\1\uffff\1\40\1\uffff\1\u0094\1\40\1\u0096\3\40\1\uffff\1\40\1\uffff\1\40\1\uffff\1\u009b\2\40\1\u009e\1\uffff\1\u009f\1\40\2\uffff\2\40";
    static final String DFA13_eofS =
        "\u00a2\uffff";
    static final String DFA13_minS =
        "\1\0\1\155\1\141\1\151\1\145\1\154\1\157\2\uffff\1\142\1\uffff\1\56\1\60\1\145\2\151\3\uffff\1\141\1\52\2\uffff\1\145\1\101\2\uffff\2\0\2\uffff\1\160\1\uffff\1\143\1\145\1\141\1\55\1\154\1\156\1\165\1\143\2\uffff\1\141\1\164\1\146\4\uffff\1\156\1\164\1\172\3\uffff\1\162\5\uffff\1\157\3\uffff\1\157\1\153\1\146\1\164\1\uffff\1\145\1\154\1\163\1\151\1\163\1\141\1\163\1\160\1\163\1\145\1\150\1\145\1\151\1\145\1\162\1\141\1\151\1\146\1\72\1\157\1\150\1\151\1\141\1\164\1\154\1\145\2\72\1\162\2\60\1\141\1\155\1\164\1\147\1\170\1\157\1\uffff\1\171\1\60\2\164\1\145\1\60\1\55\1\141\2\uffff\1\164\1\146\1\60\1\145\1\60\1\162\1\55\1\uffff\1\171\1\151\1\162\2\uffff\1\164\1\151\1\150\1\uffff\1\60\1\uffff\1\155\1\uffff\1\60\1\157\1\60\1\145\1\157\1\142\1\uffff\1\72\1\uffff\1\156\1\uffff\1\60\1\156\1\141\1\60\1\uffff\1\60\1\163\2\uffff\1\145\1\72";
    static final String DFA13_maxS =
        "\1\uffff\1\155\1\162\1\163\1\145\1\154\1\157\2\uffff\1\164\1\uffff\1\56\1\172\1\145\2\151\3\uffff\1\141\1\57\2\uffff\1\145\1\172\2\uffff\2\uffff\2\uffff\1\160\1\uffff\1\143\1\145\1\141\1\55\1\154\1\166\1\165\1\143\2\uffff\1\141\1\164\1\146\4\uffff\1\156\1\164\1\172\3\uffff\1\162\5\uffff\1\157\3\uffff\1\157\1\153\1\146\1\164\1\uffff\1\145\1\164\1\163\1\151\1\163\1\141\1\163\1\160\1\163\1\145\1\150\1\145\1\151\1\145\1\162\1\141\1\151\1\146\1\72\1\157\1\150\1\151\1\141\1\164\1\154\1\145\2\72\1\162\2\172\1\141\1\155\1\164\1\147\1\170\1\157\1\uffff\1\171\1\172\2\164\1\145\1\172\1\55\1\141\2\uffff\1\164\1\146\1\172\1\145\1\172\1\162\1\55\1\uffff\1\171\1\151\1\162\2\uffff\1\164\1\151\1\150\1\uffff\1\172\1\uffff\1\155\1\uffff\1\172\1\157\1\172\1\145\1\157\1\142\1\uffff\1\72\1\uffff\1\156\1\uffff\1\172\1\156\1\141\1\172\1\uffff\1\172\1\163\2\uffff\1\145\1\72";
    static final String DFA13_acceptS =
        "\7\uffff\1\7\1\10\1\uffff\1\12\5\uffff\1\21\1\23\1\25\2\uffff\1\32\1\33\2\uffff\1\35\1\36\2\uffff\1\42\1\43\1\uffff\1\35\10\uffff\1\7\1\10\3\uffff\1\12\1\27\1\13\1\14\3\uffff\1\21\1\23\1\25\1\uffff\1\40\1\41\1\31\1\32\1\33\1\uffff\1\36\1\37\1\42\4\uffff\1\3\45\uffff\1\34\10\uffff\1\16\1\17\7\uffff\1\26\3\uffff\1\6\1\11\3\uffff\1\1\1\uffff\1\20\1\uffff\1\4\6\uffff\1\2\1\uffff\1\22\1\uffff\1\5\4\uffff\1\15\2\uffff\1\24\1\30\2\uffff";
    static final String DFA13_specialS =
        "\1\2\32\uffff\1\0\1\1\u0085\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\36\2\35\2\36\1\35\22\36\1\35\1\36\1\33\4\36\1\34\2\36\1\12\2\36\1\25\1\13\1\24\12\32\1\26\1\21\5\36\32\31\1\7\1\36\1\10\1\30\1\14\1\36\2\31\1\5\1\4\1\31\1\3\1\15\1\11\1\1\2\31\1\6\1\31\1\27\1\31\1\2\2\31\1\17\2\31\1\23\1\16\3\31\1\20\1\36\1\22\uff82\36",
            "\1\37",
            "\1\41\12\uffff\1\43\5\uffff\1\42",
            "\1\45\11\uffff\1\44",
            "\1\46",
            "\1\47",
            "\1\50",
            "",
            "",
            "\1\53\1\uffff\1\55\17\uffff\1\54",
            "",
            "\1\57",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "",
            "",
            "\1\70",
            "\1\71\4\uffff\1\72",
            "",
            "",
            "\1\76",
            "\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\0\100",
            "\0\100",
            "",
            "",
            "\1\102",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\111\1\uffff\1\110\5\uffff\1\112",
            "\1\113",
            "\1\114",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "\1\123",
            "",
            "",
            "",
            "",
            "",
            "\1\124",
            "",
            "",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "\1\132\7\uffff\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\154",
            "\1\154",
            "\1\164",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0085",
            "\1\u0086",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0088",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u008a",
            "\1\u008b",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u0093",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0095",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\154",
            "",
            "\1\u009a",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u009c",
            "\1\u009d",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00a0",
            "",
            "",
            "\1\u00a1",
            "\1\154"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_SCHEME | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_27 = input.LA(1);

                        s = -1;
                        if ( ((LA13_27>='\u0000' && LA13_27<='\uFFFF')) ) {s = 64;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_28 = input.LA(1);

                        s = -1;
                        if ( ((LA13_28>='\u0000' && LA13_28<='\uFFFF')) ) {s = 64;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='i') ) {s = 1;}

                        else if ( (LA13_0=='p') ) {s = 2;}

                        else if ( (LA13_0=='f') ) {s = 3;}

                        else if ( (LA13_0=='d') ) {s = 4;}

                        else if ( (LA13_0=='c') ) {s = 5;}

                        else if ( (LA13_0=='l') ) {s = 6;}

                        else if ( (LA13_0=='[') ) {s = 7;}

                        else if ( (LA13_0==']') ) {s = 8;}

                        else if ( (LA13_0=='h') ) {s = 9;}

                        else if ( (LA13_0=='*') ) {s = 10;}

                        else if ( (LA13_0=='.') ) {s = 11;}

                        else if ( (LA13_0=='_') ) {s = 12;}

                        else if ( (LA13_0=='g') ) {s = 13;}

                        else if ( (LA13_0=='w') ) {s = 14;}

                        else if ( (LA13_0=='s') ) {s = 15;}

                        else if ( (LA13_0=='{') ) {s = 16;}

                        else if ( (LA13_0==';') ) {s = 17;}

                        else if ( (LA13_0=='}') ) {s = 18;}

                        else if ( (LA13_0=='v') ) {s = 19;}

                        else if ( (LA13_0=='/') ) {s = 20;}

                        else if ( (LA13_0=='-') ) {s = 21;}

                        else if ( (LA13_0==':') ) {s = 22;}

                        else if ( (LA13_0=='n') ) {s = 23;}

                        else if ( (LA13_0=='^') ) {s = 24;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||(LA13_0>='a' && LA13_0<='b')||LA13_0=='e'||(LA13_0>='j' && LA13_0<='k')||LA13_0=='m'||LA13_0=='o'||(LA13_0>='q' && LA13_0<='r')||(LA13_0>='t' && LA13_0<='u')||(LA13_0>='x' && LA13_0<='z')) ) {s = 25;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 26;}

                        else if ( (LA13_0=='\"') ) {s = 27;}

                        else if ( (LA13_0=='\'') ) {s = 28;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 29;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<=')')||(LA13_0>='+' && LA13_0<=',')||(LA13_0>='<' && LA13_0<='@')||LA13_0=='\\'||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 30;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}