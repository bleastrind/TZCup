package net.tiaozhanbei.util;



import java.util.regex.Pattern;

/**
 * @author Luke Taylor
 * @version $Id: RegexUrlPathMatcher.java,v 1.5 2009/04/02 11:04:43 admin Exp $
 */
public class RegexUrlPathMatcher{

    private boolean requiresLowerCaseUrl = false;

    public Object compile(String path) {
        return Pattern.compile(path);
    }

    public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
        this.requiresLowerCaseUrl = requiresLowerCaseUrl;
    }

    public boolean pathMatchesUrl(String path, String url) {
        Pattern pattern = Pattern.compile(path);
        
        return pattern.matcher(url).matches();
    }

    public String getUniversalMatchPattern() {
        return "/.*";
    }

    public boolean requiresLowerCaseUrl() {
        return requiresLowerCaseUrl;
    }
    
    public static void main(String[] args) {
		String aString=".*/manage/userManage\\.do.*";
		String bString="/manage/userManage.do";
		System.out.print(new RegexUrlPathMatcher().pathMatchesUrl(aString, bString));
	}
}
